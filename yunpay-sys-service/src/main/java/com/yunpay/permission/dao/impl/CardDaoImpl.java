package com.yunpay.permission.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.yunpay.permission.dao.CardDao;
import com.yunpay.permission.entity.Card;
/**
 * 
 * 类名称                     商户卡券DAO实现类
 * 文件名称:     CardDaoImpl.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午9:46:19
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */

@SuppressWarnings("rawtypes")
@Repository("CardDao")
public class CardDaoImpl extends PermissionBaseDaoImpl implements CardDao
{

	@Override
	public List<Card> getCardList(Card card)
	{
		return super.getSqlSession().selectList(getStatement("getCardList"), card);
	}

	@Override
	public Card getCardByName(String title)
	{
		return super.getSqlSession().selectOne(getStatement("getCardByName"), title);
	}

	@Override
	public Card getCardById(Integer id)
	{
		return super.getSqlSession().selectOne(getStatement("getCardById"), id);
	}

	@Override
	public int updateCard(Card card)
	{
		return super.getSqlSession().update(getStatement("updateCard"), card);
	}

}
