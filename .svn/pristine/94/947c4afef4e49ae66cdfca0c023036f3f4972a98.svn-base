package com.yunpay.wx.req.pay;

import com.yunpay.common.utils.CommonUtil;

/**
 * 微信订单查询请求类
 * 文件名称:     WechatQueryReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月23日下午1:58:32 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月23日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatQueryReq extends WechatQrReq{
	//微信的订单号
	private String transaction_id;
	
	/**
	 * 构造订单查询请求参数
	 * @param appId
	 * @param merchId
	 * @param subMerchId
	 * @param transactionId
	 * @param outTradeNo
	 * @param nonceStr
	 */
	public WechatQueryReq(String appId,String merchId,String subMerchId,String transactionId,
			String outTradeNo){
		setAppid(appId);
		setMch_id(merchId);
		setSub_mch_id(subMerchId);
		setTransaction_id(transactionId);
		setOut_trade_no(outTradeNo);
		setNonce_str(CommonUtil.getRandomStringByLength(32));
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	
	
}
