package com.yunpay.permission.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.CardDao;
import com.yunpay.permission.entity.Card;
import com.yunpay.permission.entity.CardReceive;
import com.yunpay.permission.service.CardService;
/**
 * 
 * 类名称                     商户卡券领取业务接口实现类
 * 文件名称:     CardServiceImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:56:08
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("CardService")
public class CardServiceImpl implements CardService
{
	@Autowired
	private CardDao cardDao;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageBean listPage(PageParam pageParam, Card card) throws Exception
	{
		Map<String, Object> paramMap = new HashMap<String, Object>(); // 业务条件查询参数
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (StringUtils.isNotBlank(card.getDate_begin()) || StringUtils.isNotBlank(card.getDate_end()))
		{
			Date _begin = StringUtils.isNotBlank(card.getDate_begin()) ? fmt.parse(dateManager(card.getDate_begin(), 1))
					: fmt.parse("1900-01-01 00:00:00");
			Date _end = (StringUtils.isNotBlank(card.getDate_end()) ? fmt.parse(dateManager(card.getDate_end(), 2))
					: new Date());
			paramMap.put("startDate", _begin);
			paramMap.put("endDate", _end);
		}
		paramMap.put("type", card.getType());
		paramMap.put("merchantName", card.getMerchantName());
		PageBean<CardReceive> pageBean = cardDao.listPage(pageParam, paramMap);
		return pageBean;
	}

	@Override
	public List<Card> getCardList(Card card)
	{
		return this.cardDao.getCardList(card);
	}

	@Override
	public Card getCardByName(String title)
	{
		return cardDao.getCardByName(title);
	}

	@Override
	public Card getCardById(Integer id)
	{
		return this.cardDao.getCardById(id);
	}

	@Override
	public int updateCard(Card card)
	{
		return cardDao.updateCard(card);
	}

	/*
	 * 查询日期追加时间
	 */
	private String dateManager(String date, Integer type)
	{
		if (type == 1)
		{
			date += " 00:00:00";
		}
		if (type == 2)
		{
			date += " 23:59:59";
		}
		return date;
	}

}
