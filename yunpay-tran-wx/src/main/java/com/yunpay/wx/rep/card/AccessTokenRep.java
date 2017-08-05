package com.yunpay.wx.rep.card;

import com.yunpay.common.utils.EnumUtil.ResultCode;
/**
 * 获取access_token返回结果类
 * 文件名称:     AccessTokenRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日上午9:49:37 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class AccessTokenRep extends AppBaseRep{
	
	private String access_token;
	
	public AccessTokenRep(String accessToken){
		setReturn_code(ResultCode.SUCCESS.getCode());
		setAccess_token(accessToken);
	}
	
	public AccessTokenRep(String errCode,String errCodeDes){
		super(errCode,errCodeDes);
	}
	
	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	
	
}
