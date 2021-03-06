package com.yunpay.wx.rep.card;

import com.yunpay.common.utils.EnumUtil.ResultCode;

public class AppBaseRep {
	
	//返回状态码(必须)
	private String return_code;
	//错误代码
	private String err_code;
	//错误代码描述
	private String err_code_des;
	
	public AppBaseRep(){}
	
	public AppBaseRep(String errCode,String errCodeDes){
		setReturn_code(ResultCode.FAIL.getCode());
		setErr_code(errCode);
		setErr_code_des(errCodeDes);
	}
	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	
	
}
