package com.yunpay.wx.req.card;

import com.alibaba.fastjson.JSONObject;

public class CreateQrCodeReq {
	
	private String action_name="QR_CARD";
	//二维码有效期
	private String expire_seconds;
	//投放信息
	private JSONObject action_info;
	
	
	
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public String getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public JSONObject getAction_info() {
		return action_info;
	}
	
	/**
	 * @Description: 设置卡券投放详情
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:26:34 
	 * @param cardId  卡券id
	 * @param isUniqueCode  是否只能
	 */
	public void setAction_info(String cardId) {
		JSONObject card = new JSONObject();
		card.put("card_id", cardId);
		this.action_info = new JSONObject();
		this.action_info.put("card", card);
	}
	
	
	
}
