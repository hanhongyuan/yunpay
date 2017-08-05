package com.yunpay.permission.service;

import java.text.ParseException;
import java.util.List;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.Card;
/**
 * 类名称		      卡券业务接口
 * 文件名称:     CardService.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年6月20日下午3:20:08
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface CardService{
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param card
	 * @return
	 * @throws ParseException 
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, Card card) throws  Exception;
	
	/**
	 * 查询所有的卡券
	 * @param card
	 * @return
	 */
	List<Card> getCardList(Card card);
	
	/**
	 * 通过名称查询卡券
	 * @param title
	 * @return
	 */
	Card getCardByName(String title);
	
	/**
	 * 通过id查询卡券
	 * @param id
	 * @return
	 */
	Card getCardById(Integer id);

	int updateCard(Card card);
}
