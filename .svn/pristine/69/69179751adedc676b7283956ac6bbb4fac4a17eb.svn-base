package com.yunpay.permission.dao;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.DealDetail;
import com.yunpay.permission.entity.SumDateDeal;
import com.yunpay.permission.entity.SumDayDeal;
import com.yunpay.permission.entity.PayTranLs;
public interface MerchantReportDao extends PermissionBaseDao<PayTranLs>  {
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月16日上午9:56:12 
	 * 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年6月16日     duan zhang quan   1.0     新建
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	
	
	
	/**
	 *日交易汇总
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	List<SumDayDeal> sumDayDeal(Map<String,Object> map);
	
	
	/**
	 *日期范围交易汇总
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	List<SumDateDeal> sumDateDeal(Map<String,Object> map);
	
	
	/**
	 * 
	* 
	*  日交易详细数据
	* @param 
	* @return PageBean<DealDetail>
	* @throws
	 */
	PageBean<DealDetail> dayDeal(PageParam pageParam,Map<String,Object> map);
	
	/**
	 * 
	* 
	*  日期范围交易详细数据
	* @param 
	* @return PageBean<DealDetail>
	* @throws
	 */
	PageBean<DealDetail> dateDeal(PageParam pageParam,Map<String,Object> map);
	


	/**
	 * 
	* 输出日交易图形报表数据
	* @param 
	* @return List<SumDayDeal>
	* @throws
	 */
	List<SumDayDeal> printDayDeal(Map<String,Object> map);
	
	/**
	 * 
	* 输出日期范围交易图形报表数据
	* @param 
	* @return List<SumDayDeal>
	* @throws
	 */
	Date getLastTranTime();
	
	/**
	 * 
	 * 取得最后交易时间
	 * @param 
	 * @return Date
	 * @throws
	 */
	List<SumDateDeal> printDateDeal(Map<String,Object> map);

	/**
	 * 预留功能：
	 * 交易情况分析报表
	 */
}
