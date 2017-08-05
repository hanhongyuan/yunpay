package com.yunpay.ali.rep;

import java.util.Date;

/**
 * 支付宝条码支付返回类
 * 文件名称:     AliBarRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午5:05:55 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliBarRep extends AliQrRep{
	//支付宝订单号(必须)
	private String trade_no;
	//平台提交订单号(必须)
	private String out_trade_no;
	//买家支付宝账号 (必须)
	private String buyer_logon_id ;
	//交易金额 (必须)
	private String total_amount ;
	//实收金额 (必须)
	private String receipt_amount ;
	//买家付款的金额
	private String buyer_pay_amount ;
	//交易支付时间(必须)
	private Date gmt_payment;
	//交易使用的资金渠道(必须)
	private String fund_channel;
	//该支付工具类型所使用的金额 (必须)
	private String amount ;
	//渠道实际付款金额(必须)
	private String real_amount ;
	//买家在支付宝的用户id(必须)
	private String buyer_user_id;
	
	public AliBarRep(){
		
	}
	
	/**
	 * 构造系统错误结果封装
	 * @param code
	 * @param msg
	 * @param sub_code
	 * @param sub_msg
	 */
	public AliBarRep(String code,String msg,String sub_code,String sub_msg){
		super(code,msg,sub_code,sub_msg);
	}
	
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}
	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getReceipt_amount() {
		return receipt_amount;
	}
	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}
	public String getBuyer_pay_amount() {
		return buyer_pay_amount;
	}
	public void setBuyer_pay_amount(String buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}
	public Date getGmt_payment() {
		return gmt_payment;
	}
	public void setGmt_payment(Date gmt_payment) {
		this.gmt_payment = gmt_payment;
	}
	public String getFund_channel() {
		return fund_channel;
	}
	public void setFund_channel(String fund_channel) {
		this.fund_channel = fund_channel;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReal_amount() {
		return real_amount;
	}
	public void setReal_amount(String real_amount) {
		this.real_amount = real_amount;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}
	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}
	
	
}
