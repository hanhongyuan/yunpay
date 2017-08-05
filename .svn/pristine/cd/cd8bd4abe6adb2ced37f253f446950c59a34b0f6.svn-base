package com.yunpay.permission.dao;

import java.util.List;
import com.yunpay.permission.entity.Card;

/**
 * 
 * 类名称                     商户卡券Dao接口
 * 文件名称:     CardDao.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年7月12日上午10:00:42
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
public interface CardDao extends PermissionBaseDao
{

	/**
	 * 按查询条件查询卡券列表
	 * 
	 * @param card
	 * @return
	 */
	List<Card> getCardList(Card card);

	/**
	 * 通过名称查询卡券
	 * 
	 * @param title
	 * @return
	 */
	Card getCardByName(String title);

	/**
	 * 通过id查询卡券
	 * 
	 * @param id
	 * @return
	 */
	Card getCardById(Integer id);

	int updateCard(Card card);
}
