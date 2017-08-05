package com.yunpay.ali.req;

public class AliCloseReq extends AliQrReq{
	//支付宝交易号
	private String trade_no;
	
	public AliCloseReq(){
		
	}
	
	/**
	 * 构造订单撤销请求参数
	 * @param appId
	 * @param privateKey
	 * @param alipayPublicKey
	 * @param out_trade_no
	 * @param trade_no
	 */
	public AliCloseReq(String appId,String privateKey,String alipayPublicKey,
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
