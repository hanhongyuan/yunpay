package com.yunpay.wx.req.card;

import com.alibaba.fastjson.JSONObject;

/**
 * 代金券
 * 文件名称:     CashCardReq.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月1日下午2:17:05 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月1日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class CashCardReq extends CardReq{
	private JSONObject cash;
	//代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
	//private int least_cost;
	//代金券专用，表示减免金额。（单位为分）
	//private int reduce_cost;
	
	
	
	public JSONObject getCash() {
		return cash;
	}
	
	/**
	 * @Description: 设置代金券提交内容
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午2:23:03 
	 * @param leastCost  表示起用金额（单位为分）,如果无起用门槛则填0
	 * @param reduceCost 代金券专用，表示减免金额（单位为分）
	 * @param baseInfo
	 */
	public void setCash(int leastCost,int reduceCost,CardBaseInfo baseInfo) {
		cash = new JSONObject();
		cash.put("least_cost", leastCost);
		cash.put("reduce_cost", reduceCost);
		cash.put("base_info", baseInfo);
	}
	
	
	
}
