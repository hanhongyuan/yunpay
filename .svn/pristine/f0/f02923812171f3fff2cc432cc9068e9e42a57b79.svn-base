package com.yunpay.wx.req.card;

import com.alibaba.fastjson.JSONObject;

/**
 * 团购券
 * 文件名称:     GrouponCardReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日下午2:16:10 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class GrouponCardReq extends CardReq{
	//团购券专用，团购详情。
	//private String deal_detail;
	private JSONObject groupon;

	public JSONObject getGroupon() {
		return groupon;
	}

	/**
	 * @Description: 设置团购券提交内容
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:20:15 
	 * @param detailInfo  卡券详情
	 * @param baseInfo  卡券基本信息
	 */
	public void setGroupon(String detailInfo,CardBaseInfo baseInfo) {
		this.groupon = new JSONObject();
		this.groupon.put("deal_detail", detailInfo);
		this.groupon.put("base_info", baseInfo);
	}
	
	
	
}
