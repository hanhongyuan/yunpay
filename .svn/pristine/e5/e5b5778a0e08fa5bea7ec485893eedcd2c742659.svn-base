package com.yunpay.serv.rep;

import com.yunpay.serv.model.RefundTranLs;

/**
 * 退款申请返回结果类
 * 文件名称:     RefundRepDto.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月11日下午1:48:15 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月11日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class RefundRepDto {
	//商户号（非空）
	private String merchant_num ; 
	//原支付流水号（非空）
	private String user_order_no;
	//退款申请流水号（非空）
	private String user_refund_no;
	//我方平台退款流水号
	private String trace_refund_num;
	//退款金额(单位：元)
	private String refund_fee ;
	
	
	public RefundRepDto(){
		
	}
	
	public RefundRepDto(RefundTranLs refundTranLs){
		this.merchant_num = refundTranLs.getMerchantNo();
		this.user_order_no = refundTranLs.getOldUserOrderNo();
		this.user_refund_no = refundTranLs.getUserRefundNo();
		this.trace_refund_num = refundTranLs.getTransNum();
		this.refund_fee = refundTranLs.getRefundFee().toString();
	}
	
	public String getMerchant_num() {
		return merchant_num;
	}
	public void setMerchant_num(String merchant_num) {
		this.merchant_num = merchant_num;
	}
	public String getUser_order_no() {
		return user_order_no;
	}
	public void setUser_order_no(String user_order_no) {
		this.user_order_no = user_order_no;
	}
	public String getUser_refund_no() {
		return user_refund_no;
	}
	public void setUser_refund_no(String user_refund_no) {
		this.user_refund_no = user_refund_no;
	}
	public String getTrace_refund_num() {
		return trace_refund_num;
	}
	public void setTrace_refund_num(String trace_refund_num) {
		this.trace_refund_num = trace_refund_num;
	}
	public String getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(String refund_fee) {
		this.refund_fee = refund_fee;
	} 
	
	
	
	
}
