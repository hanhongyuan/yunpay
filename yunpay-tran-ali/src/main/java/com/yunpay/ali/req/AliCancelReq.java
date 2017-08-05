package com.yunpay.ali.req;

/**
 * 支付宝订单撤销请求参数类
 * 文件名称:     AliCancelReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月26日上午10:11:51 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月26日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliCancelReq extends AliQrReq{
	//支付宝交易号
	private String trade_no;
	
	public AliCancelReq(){
		
	}
	
	/**
	 * 构造订单撤销请求参数
	 * @param appId
	 * @param privateKey
	 * @param alipayPublicKey
	 * @param out_trade_no
	 * @param trade_no
	 */
	public AliCancelReq(String appId,String privateKey,String alipayPublicKey,
			String out_trade_no,String trade_no){
		setAppId(appId);
		setPrivateKey(privateKey);
		setAlipayPublicKey(alipayPublicKey);
		setOut_trade_no(out_trade_no);
		setTrade_no(trade_no);
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	
	
}
