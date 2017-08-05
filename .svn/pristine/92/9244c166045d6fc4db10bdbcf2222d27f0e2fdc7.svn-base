package com.yunpay.wx.rep.pay;

/**
 * 微信订单查询返回结果
 * 文件名称:     WechatReverseRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月23日下午2:32:28 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月23日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatReverseRep extends WechatQrRep{
	//是否需要继续调用撤销，Y-需要，N-不需要
	private String recall;
	
	public WechatReverseRep(){
		
	}
	
	/**
	 * 用于构造系统中返回的错误信息
	 * @param return_code
	 * @param return_msg
	 * @param err_code
	 * @param err_code_des
	 */
	public WechatReverseRep(String return_code,String return_msg,String err_code,String err_code_des){
		super( return_code, return_msg, err_code, err_code_des);
	}

	public String getRecall() {
		return recall;
	}

	public void setRecall(String recall) {
		this.recall = recall;
	}
	
	
}
