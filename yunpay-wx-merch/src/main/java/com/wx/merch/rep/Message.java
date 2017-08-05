package com.wx.merch.rep;

import com.yunpay.common.utils.EnumUtil.ResultCode;

public class Message {
	//业务响应码
	private String result_code = "";		
	//返回信息描述
	private String result_msg = "";		
	//错误代码
	private String err_code = "";	
	//错误代码
	private String err_code_des = "";
	//返回业务参数(实体对象)
	private Object data;	
	
	/**
	 * 无参构造
	 */
	public Message(){
		super();
	}
	

	/**
	 * 默认返回成功
	 * @param data  对象数据
	 */
	public Message(Object data){
		this.result_code = ResultCode.SUCCESS.getCode();
		this.result_msg = ResultCode.SUCCESS.getDes();
		this.data = data;
	}
	
	/**
	 * 默认返回失败
	 * @param err_code       错误码
	 * @param err_code_desc  错误描述
	 */
	public Message(String err_code,String err_code_desc){
		this.result_code = ResultCode.FAIL.getCode();
		this.result_msg = ResultCode.FAIL.getDes();
		this.err_code = err_code;
		this.err_code_des = err_code_desc;
	}
	
	/**
	 * 自定义返回失败
	 * @param result_code  结果码
	 * @param result_msg   结果描述
	 * @param err_code     错误码
	 * @param err_code_desc错误描述
	 */
	public Message(String result_code,String result_msg,String err_code,String err_code_desc){
		this.result_code = result_code;
		this.result_msg = result_msg;
		this.err_code = err_code;
		this.err_code_des = err_code_desc;
	}
	

	
	/**
	 * 自定义返回成功
	 * @param result_code 结果码
	 * @param result_msg  结果描述
	 * @param data     	    对象数据
	 */
	public Message(String result_code,String result_msg,Object data){
		this.result_code = result_code;
		this.result_msg = result_msg;
		this.data = data;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getResult_msg() {
		return result_msg;
	}

	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
