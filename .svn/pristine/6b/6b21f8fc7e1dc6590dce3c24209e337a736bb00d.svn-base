package com.yunpay.ali.rep;

/**
 * 支付宝二维码支付返回公共类
 * 文件名称:     AliQrRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午5:06:07 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AliQrRep {
	//网关返回码(必需)
	private String code;
	//返回描述(必需)
	private String msg;
	//业务返回码
	private String sub_code;
	//返回描述
	private String sub_msg;
	//(必需)
	private String sign;
	
	
	public AliQrRep(){
		
	}
	
	/**
	 * 构造系统错误封装
	 * @param code
	 * @param msg
	 * @param sub_code
	 * @param sub_msg
	 */
	public AliQrRep(String code,String msg,String sub_code,String sub_msg){
		this.code = code;
		this.msg = msg;
		this.sub_code = sub_code;
		this.sub_msg = sub_msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSub_code() {
		return sub_code;
	}
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	public String getSub_msg() {
		return sub_msg;
	}
	public void setSub_msg(String sub_msg) {
		this.sub_msg = sub_msg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
