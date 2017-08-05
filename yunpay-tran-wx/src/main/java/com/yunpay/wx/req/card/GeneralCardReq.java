package com.yunpay.wx.req.card;

import com.alibaba.fastjson.JSONObject;

/**
 * 优惠券
 * 文件名称:     GeneralCardReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日下午2:21:48 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class GeneralCardReq {
	//优惠券专用，填写优惠详情。
	//private String default_detail;
	private JSONObject general_coupon;

	public JSONObject getGeneral_coupon() {
		return general_coupon;
	}

	/**
	 * @Description: 设置优惠券提交内容
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:21:55 
	 * @param defaultDetail 优惠券详情
	 * @param baseInfo  卡券基本信息
	 */
	public void setGeneral_coupon(String defaultDetail,CardBaseInfo baseInfo) {
		this.general_coupon = new JSONObject();
		this.general_coupon.put("default_detail", defaultDetail);
		this.general_coupon.put("base_info", baseInfo);
	}

	
	
}
