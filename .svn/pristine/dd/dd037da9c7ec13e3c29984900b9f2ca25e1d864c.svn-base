package com.yunpay.wx.req.card;

import com.alibaba.fastjson.JSONObject;

/**
 * 兑换券
 * 文件名称:     GiftCardReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日下午2:20:36 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class GiftCardReq extends CardReq{
	
	//兑换券专用，填写兑换内容的名称。
	//private String gift;
	private JSONObject gift;

	public JSONObject getGift() {
		return gift;
	}

	/**
	 * @Description: 设置兑换券提交内容
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:20:37 
	 * @param gift 兑换券详情
	 * @param baseInfo 卡券基本信息
	 */
	public void setGift(String gift,CardBaseInfo baseInfo) {
		this.gift = new JSONObject();
		this.gift.put("gift", gift);
		this.gift.put("base_info", baseInfo);
	}
	
	
	
	
	
}
