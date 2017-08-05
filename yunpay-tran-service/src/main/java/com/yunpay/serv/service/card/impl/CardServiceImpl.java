package com.yunpay.serv.service.card.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.yunpay.common.exception.YunPayException;
import com.yunpay.common.utils.FileUtil;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.ResultCode;
import com.yunpay.serv.config.PayConfig;
import com.yunpay.serv.dao.WechatConfigDao;
import com.yunpay.serv.model.WechatConfigKey;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.service.card.CardService;
import com.yunpay.wx.rep.card.AccessTokenRep;
import com.yunpay.wx.rep.card.CardRep;
import com.yunpay.wx.rep.card.CreateQrCodeRep;
import com.yunpay.wx.rep.card.UploadImgRep;
import com.yunpay.wx.req.card.CardReq;
import com.yunpay.wx.req.card.CreateQrCodeReq;
import com.yunpay.wx.service.WechatCardService;

@Service("cardService")
public class CardServiceImpl extends CardService{
	
	@Autowired
	private WechatCardService wechatCardService;
	@Autowired
	private WechatConfigDao wechatConfigDao;
	
	
	/**
	 * @Description:获取微信access_token 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午11:12:09 
	 * @param appId
	 * @param appSecret
	 * @return
	 * @throws YunPayException
	 */
	@Cacheable(value="wxAccessToken",key="#appId")
	public String recvAccessToken(String appId,String appSecret) throws YunPayException{
		AccessTokenRep accessTokenRep = wechatCardService.doAccessToken(appId, appSecret);
		if(ResultCode.SUCCESS.getCode().equals(accessTokenRep.getReturn_code())){
			return accessTokenRep.getAccess_token();
		}
		throw new YunPayException(accessTokenRep.getErr_code_des());
	}
	
	
	/**
	 * 
	 * @Description:上传卡券图片
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月3日下午2:59:04 
	 * @param merchantNum 商户号
	 * @param file  文件信息
	 * @return
	 */
	@Override
	public Message cardImgUpload(String merchantNum,CommonsMultipartFile file) {
		// TODO Auto-generated method stub
		//获取商户微信配置
		Message message = null;
		WechatConfigKey wechatConfig = wechatConfigDao.findConfigByMerNo(merchantNum);
		if (wechatConfig == null) {
			return new Message(ErrorCode.ILLEGAL_PAYCONFIG.getCode(),ErrorCode.ILLEGAL_PAYCONFIG.getDes());
		}
		//本地保存路径
		String uploadPath = PayConfig.CARD_IMG_PATH+merchantNum+"/";
		try {
			//将文件保存至本地服务器目录中
			Map<String,String> fileInfo = FileUtil.fileUpload(uploadPath, file);
			//获取微信accessToken
			String accessToken = recvAccessToken(wechatConfig.getAppId(), wechatConfig.getAppSecret());
			//图片上传至微信
			UploadImgRep rep = wechatCardService.doUploadImg(fileInfo.get("savePath"), accessToken);
			if(ResultCode.SUCCESS.getCode().equals(rep.getReturn_code())){
				//图片上传成功
				JSONObject ret = new JSONObject();
				ret.put("imgUrl", rep.getUrl());
				message = new Message(ret);
			}else{
				//图片上传失败
				message = new Message(rep.getErr_code(),rep.getErr_code_des());
			}
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(ErrorCode.SYSTEM_EXCEPTION.getCode(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}catch (YunPayException e) {
			e.printStackTrace();
			return new Message(ErrorCode.SYSTEM_EXCEPTION.getCode(),e.toString());
		}
		return message;
	}
	
	
	/**
	 * @Description:创建卡券
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日下午5:17:01 
	 * @param cardReq
	 * @param accessToken
	 * @return
	 */
	@Override
	public Message createWxCard(CardReq req, String accessToken) {
		// TODO Auto-generated method stub
		CardRep rep = wechatCardService.doCreateCard(req, accessToken);
		if(ResultCode.SUCCESS.getCode().equals(rep.getReturn_code())){
			return new Message(rep.getCard_id());
		}
		return new Message(rep.getErr_code(),rep.getErr_code_des());
	}

	/**
	 * @Description:创建微信卡券领取码
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:55:09 
	 * @param req
	 * @param accessToken
	 * @return
	 */
	@Override
	public Message createWxQrCode(CreateQrCodeReq req, String accessToken) {
		// TODO Auto-generated method stub
		CreateQrCodeRep rep = wechatCardService.doCreateQrCode(req, accessToken);
		if(ResultCode.SUCCESS.getCode().equals(rep.getReturn_code())){
			Map<String,String> retMap = new HashMap<String,String>();
			retMap.put("ticket", rep.getTicket());
			retMap.put("expireSeconds", rep.getExpire_seconds());
			retMap.put("url", rep.getUrl());
			retMap.put("showQrcodeUrl", rep.getShow_qrcode_url());
			return new Message(retMap);
		}
		return new Message(rep.getErr_code(),rep.getErr_code_des());
	}

	
	
}
