package com.yunpay.permission.service;

import java.text.ParseException;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.CardReceive;

/**
 * 类名称		       商户卡券领取信息业务接口
 * 文件名称:     CardReceiveService.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年6月21日下午5:49:09
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月21日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface CardReceiveService{

	/**
	 * 分页查询
	 * @param pageParam
	 * @param cardReceive
	 * @return
	 * @throws ParseException 
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, CardReceive cardReceive) throws  Exception;
}
