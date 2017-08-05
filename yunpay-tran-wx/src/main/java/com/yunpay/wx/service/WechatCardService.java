package com.yunpay.wx.service;

import com.yunpay.wx.rep.card.AccessTokenRep;
import com.yunpay.wx.rep.card.CreateQrCodeRep;
import com.yunpay.wx.rep.card.CardRep;
import com.yunpay.wx.rep.card.UploadImgRep;
import com.yunpay.wx.req.card.CreateQrCodeReq;
import com.yunpay.wx.req.card.CardReq;

/**
 * 卡券业务接口类
 * 文件名称:     WechatCardService.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月31日下午4:05:38 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月31日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface WechatCardService {
	
	/**
	 * @Description: 获取微信access_token
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午9:53:59 
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public AccessTokenRep doAccessToken(String appId,String appSecret);
	
	
	/**
	 * @Description: 微信图片上传
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午9:54:40 
	 * @param imgUrl	本地图片路径
	 * @param accessToken 
	 * @return
	 */
	public UploadImgRep doUploadImg(String imgUrl,String accessToken);
	
	/**
	 * @Description: 创建卡券
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日下午3:15:55 
	 * @param cardReq
	 * @param accessToken
	 * @return
	 */
	public CardRep doCreateCard(CardReq cardReq,String accessToken);
	
	
	/**
	 * @Description: 获取卡券投放领取码
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:38:05 
	 * @param codeReq
	 * @param accessToken
	 * @return
	 */
	public CreateQrCodeRep doCreateQrCode(CreateQrCodeReq codeReq,String accessToken);
	
}
