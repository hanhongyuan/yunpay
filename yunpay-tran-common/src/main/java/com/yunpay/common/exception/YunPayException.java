package com.yunpay.common.exception;

/**
 * 自定义异常类
 * 文件名称:     YunPayException.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月31日下午6:00:31 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月31日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class YunPayException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public YunPayException(){
		super();
	}
	
	public YunPayException(String errMsg){
		super(errMsg);
	}
	
	public YunPayException(String errMsg,Throwable cause){
		super(errMsg,cause);
	}
	
	public YunPayException(Throwable cause){
		super(cause);
	}
}
