package com.yunpay.ali.req;

/**
 * 支付宝退款查询请求参数类
 * 文件名称:     AliRefundQueryReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月11日下午4:35:35 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月11日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliRefundQueryReq extends AliQrReq{
	//原支付宝交易号
	private String trade_no;
	//退款流水号
	private String out_request_no;
	
	public AliRefundQueryReq(){
		
	}
	
	public AliRefundQueryReq(String appId,String privateKey,String alipayPublicKey,
			String out_trade_no,String trade_no,String out_request_no){
		setAppId(appId);
		setPrivateKey(privateKey);
		setAlipayPublicKey(alipayPublicKey);
		setOut_trade_no(out_trade_no);
		setTrade_no(trade_no);
		setOut_request_no(out_request_no);
	}
	
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getOut_request_no() {
		return out_request_no;
	}
	public void setOut_request_no(String out_request_no) {
		this.out_request_no = out_request_no;
	}
	
	
}
