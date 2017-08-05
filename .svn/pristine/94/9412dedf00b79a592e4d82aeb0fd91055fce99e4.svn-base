package com.yunpay.wx.req.card;

import com.alibaba.fastjson.JSONObject;

/**
 * 折扣券
 * 文件名称:     DisCardReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日下午2:18:58 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class DisCardReq extends CardReq{
	//折扣券专用，表示打折额度（百分比）。填30就是七折。
	//private int discount;
	private JSONObject discount;

	
	public JSONObject getDiscount() {
		return discount;
	}
	
	/**
	 * @Description: 设置折扣券提交内容
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:22:27 
	 * @param baseInfo 卡券基本信息
	 * @param discount 表示打折额度（百分比）。填30就是七折
	 */
	public void setDiscount(CardBaseInfo baseInfo,int discount) {
		this.discount = new JSONObject();
		this.discount.put("discount", discount);
		this.discount.put("base_info", baseInfo);
	}
	
	
}
