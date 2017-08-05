package com.yunpay.wx.service.impl;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.yunpay.common.utils.HttpUtil;
import com.yunpay.common.utils.Log;
import com.yunpay.wx.config.WechatCardConfig;
import com.yunpay.wx.rep.card.AccessTokenRep;
import com.yunpay.wx.rep.card.CreateQrCodeRep;
import com.yunpay.wx.rep.card.CardRep;
import com.yunpay.wx.rep.card.UploadImgRep;
import com.yunpay.wx.req.card.CreateQrCodeReq;
import com.yunpay.wx.req.card.CardReq;
import com.yunpay.wx.service.WechatCardService;

/**
 * 微信卡券核心业务实现类
 * 文件名称:     WechatCardServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月31日上午11:22:55 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月31日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service
public class WechatCardServiceImpl implements WechatCardService{

	/**
	 * @Description:获取access_token
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月31日上午11:23:09 
	 * @param appId      微信公众号appId
	 * @param appSecret  公众号密钥appSecret
	 * @return	access_token
	 */
	@Override
	public AccessTokenRep doAccessToken(String appId, String appSecret) {
		// TODO Auto-generated method stub
		String reqUrl = WechatCardConfig.ACCESS_TOKEN_API.replace("APPID", appId)
				.replace("APPSECRET", appSecret);
		JSONObject jsonObj = JSONObject.parseObject(HttpUtil.doGet(reqUrl, null, "UTF-8", false));
		Log.info("--------doAccessToken recv-------"+jsonObj);
		if(StringUtils.isNotBlank(jsonObj.getString("access_token"))){
			return new AccessTokenRep(jsonObj.getString("access_token"));
		}
		return new AccessTokenRep(jsonObj.getString("errcode"),jsonObj.getString("errmsg"));
	}

	/**
	 * 微信图片上传
	 * @Description:
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午9:55:02 
	 * @param accessToken
	 * @return
	 */
	@Override
	public UploadImgRep doUploadImg(String imgUrl,String accessToken) {
		// TODO Auto-generated method stub
		WritableResource resource = new FileSystemResource(new File(imgUrl));
		MultiValueMap<String,WritableResource> data = new LinkedMultiValueMap<String,WritableResource>();
		data.add("buffer", resource);
		String urlString = WechatCardConfig.UPLOAD_IMG_API.replace("ACCESS_TOKEN", accessToken);
		RestTemplate restTemplate = new RestTemplate();
		String recvMsg = restTemplate.postForObject(urlString, data, String.class);
		Log.info("--------doUploadImg recv-------"+recvMsg);
		JSONObject jsonObj = JSONObject.parseObject(recvMsg);
		if(StringUtils.isNotBlank(jsonObj.getString("url"))){
			return new UploadImgRep(jsonObj.getString("url"));
		}
		return new UploadImgRep(jsonObj.getString("errcode"),jsonObj.getString("errmsg"));
	}

	/**
	 * @Description:创建卡券
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日下午3:27:41 
	 * @param cardReq
	 * @param accessToken
	 * @return
	 */
	@Override
	public CardRep doCreateCard(CardReq cardReq, String accessToken) {
		// TODO Auto-generated method stub
		String urlString = WechatCardConfig.CARD_CREATE_API.replace("ACCESS_TOKEN", accessToken);
		JSONObject obj = new JSONObject();
		obj.put("card", cardReq);
		String reqParams = obj.toJSONString();
		Log.info("-------doCreateCard send--------"+reqParams);
		String recvMsg = HttpUtil.sendPostUrl(urlString, reqParams, "utf-8");
		Log.info("-------doCreateCard recv--------"+recvMsg);
		JSONObject jsonObj = JSONObject.parseObject(recvMsg);
		String errCode = jsonObj.getString("errcode");
		if(StringUtils.isNotBlank(errCode) && "0".equals(errCode)){
			return new CardRep(jsonObj.getString("card_id"));
		}
		return new CardRep(errCode,jsonObj.getString("errmsg"));
	}

	/**
	 * @Description:获取卡券投放领取码
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:38:50 
	 * @param codeReq
	 * @param accessToken
	 * @return
	 */
	@Override
	public CreateQrCodeRep doCreateQrCode(CreateQrCodeReq codeReq, String accessToken) {
		// TODO Auto-generated method stub
		String urlString = WechatCardConfig.CREATE_QRCODE_API.replace("ACCESS_TOKEN", accessToken);
		String reqParams =JSONObject.toJSONString(codeReq);
		Log.info("-------doCreateQrCode send--------"+reqParams);
		String recvMsg = HttpUtil.sendPostUrl(urlString, reqParams, "utf-8");
		Log.info("-------doCreateQrCode recv--------"+recvMsg);
		JSONObject jsonObj = JSONObject.parseObject(recvMsg);
		String errCode = jsonObj.getString("errcode");
		if(StringUtils.isNotBlank(errCode) && "0".equals(errCode)){
			String ticket = jsonObj.getString("ticket");
			String expireSeconds = jsonObj.getString("expire_seconds");
			String url = jsonObj.getString("url");
			String showQrcodeUrl = jsonObj.getString("show_qrcode_url"); 
			return new CreateQrCodeRep(ticket,expireSeconds,url,showQrcodeUrl);
		}
		return new CreateQrCodeRep(errCode,jsonObj.getString("errmsg"));
	}

}
