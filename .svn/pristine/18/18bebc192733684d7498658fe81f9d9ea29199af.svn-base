package com.yunpay.permission.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.CardReceiveDao;
import com.yunpay.permission.entity.CardReceive;
import com.yunpay.permission.service.CardReceiveService;
/**
 * 
 * 类名称                      商户卡券领取信息业务接口实现类
 * 文件名称:     CardReceiveServiceImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:55:14
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("CardReceiveService")
public class CardReceiveServiceImpl implements CardReceiveService{
	@Autowired
	private CardReceiveDao cardReceiveDao;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, CardReceive cardReceive) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数			
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(StringUtils.isNotBlank(cardReceive.getDate_begin())||StringUtils.isNotBlank(cardReceive.getDate_end())){
			Date _begin = StringUtils.isNotBlank(cardReceive.getDate_begin())?fmt.parse(dateManager(cardReceive.getDate_begin(),1)):fmt.parse("1900-01-01 00:00:00");
			Date _end =(StringUtils.isNotBlank(cardReceive.getDate_end())?fmt.parse(dateManager(cardReceive.getDate_end(),2)):new Date());			
			paramMap.put("startDate", _begin);
			paramMap.put("endDate", _end);			
		}	
		paramMap.put("cardId", cardReceive.getCardId());
		PageBean<CardReceive> pageBean=cardReceiveDao.listPage(pageParam, paramMap);
		return pageBean;
	}
	
	/*
	 * 查询日期追加时间
	 */
	private String dateManager(String date,Integer type)
	{
		if(type == 1){
			date+=" 00:00:00";
		}
		if(type == 2){
			date+=" 23:59:59";
		}
		return date;
	}
	
	
}
