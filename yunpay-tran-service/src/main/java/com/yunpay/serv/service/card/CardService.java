package com.yunpay.serv.service.card;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.yunpay.common.exception.YunPayException;
import com.yunpay.serv.rep.Message;
import com.yunpay.wx.req.card.CardReq;
import com.yunpay.wx.req.card.CreateQrCodeReq;



public abstract class CardService {
	
	
	
	/**
	 * @Description:获取微信access_token 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午11:12:09 
	 * @param appId
	 * @param appSecret
	 * @return
	 * @throws YunPayException
	 */
	public abstract String recvAccessToken(String appId,String appSecret);
	
	
	/**
	 * @Description: 卡券上传
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月3日下午2:54:50 
	 * @param merchantNum
	 * @param file
	 * @return
	 */
	public abstract Message cardImgUpload(String merchantNum,CommonsMultipartFile file);
	
	
	/**
	 * @Description: 创建微信卡券
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:51:02 
	 * @param req
	 * @param accessToken
	 * @return
	 */
	public abstract Message createWxCard(CardReq req,String accessToken);
	
	/**
	 * @Description: 创建卡券领取码
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:51:12 
	 * @param req
	 * @param accessToken
	 * @return
	 */
	public abstract Message createWxQrCode(CreateQrCodeReq req,String accessToken);
	
}
