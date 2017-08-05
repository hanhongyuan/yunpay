package com.yunpay.serv.rep;

import com.yunpay.common.utils.DateUtil;
import com.yunpay.common.utils.EnumUtil;
import com.yunpay.serv.model.RefundTranLs;

/**
 * 退款查询返回结果类
 * 文件名称:     RefundQueryRepDto.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月11日下午1:47:23 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月11日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class RefundQueryRepDto {
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
	//退款状态(0发起退款,1退款中2已退款3退款失败)
	private String refund_state;
	//状态说明
	private String refund_msg;
	//退款发起时间
	private String refund_time;
	//退款成功时间
	private String refund_success_time;
	
	
	public RefundQueryRepDto(RefundTranLs refundTranLs){
		this.merchant_num = refundTranLs.getMerchantNo();
		this.user_order_no = refundTranLs.getOldUserOrderNo();
		this.user_refund_no = refundTranLs.getUserRefundNo();
		this.trace_refund_num = refundTranLs.getTransNum();
		this.refund_fee = refundTranLs.getRefundFee().toString();
		this.refund_state = refundTranLs.getStatus()+"";
		this.refund_msg = EnumUtil.getRefundStatusByValue(refundTranLs.getStatus());
		this.refund_time =DateUtil.formatDate(refundTranLs.getTransTime(),"yyyy-MM-dd HH:mm:ss"); ;
		this.refund_success_time = refundTranLs.getRefundSuccessTime();
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
	public void setOld_order_no(String user_order_no) {
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
	public String getRefund_state() {
		return refund_state;
	}
	public void setRefund_state(String refund_state) {
		this.refund_state = refund_state;
	}
	public String getRefund_success_time() {
		return refund_success_time;
	}
	public void setRefund_success_time(String refund_success_time) {
		this.refund_success_time = refund_success_time;
	}
	public String getRefund_msg() {
		return refund_msg;
	}
	public void setRefund_msg(String refund_msg) {
		this.refund_msg = refund_msg;
	}
	public String getRefund_time() {
		return refund_time;
	}
	public void setRefund_time(String refund_time) {
		this.refund_time = refund_time;
	}
	
	
}
