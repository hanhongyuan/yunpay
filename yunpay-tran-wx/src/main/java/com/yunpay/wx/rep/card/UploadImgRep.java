package com.yunpay.wx.rep.card;

import com.yunpay.common.utils.EnumUtil.ResultCode;

/**
 * 微信图片上传返回结果类
 * 文件名称:     UploadImgRep.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日上午9:53:36 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class UploadImgRep extends AppBaseRep{
	//微信返回图片地址
	private String url;
	
	public UploadImgRep(String url){
		setReturn_code(ResultCode.SUCCESS.getCode());
		setUrl(url);
	}
	
	public UploadImgRep(String errCode,String errCodeDes){
		super(errCode,errCodeDes);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
