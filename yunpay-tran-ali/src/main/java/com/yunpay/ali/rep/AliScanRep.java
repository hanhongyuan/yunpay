package com.yunpay.ali.rep;

/**
 * 支付宝扫码支付返回类
 * 文件名称:     AliScanRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午5:06:29 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliScanRep extends AliQrRep{
	//平台订单号(必需)
	private String out_trade_no ;
	//二维码串(必需)
	private String qr_code;
	
	public AliScanRep(){
		
	}
	
	/**
	 * 构造系统错误结果封装
	 * @param code
	 * @param msg
	 * @param sub_code
	 * @param sub_msg
	 */
	public AliScanRep(String code,String msg,String sub_code,String sub_msg){
		super(code,msg,sub_code,sub_msg);
	}
	
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getQr_code() {
		return qr_code;
	}
	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}
	
	
}
