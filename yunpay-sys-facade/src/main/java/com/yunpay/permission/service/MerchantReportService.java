package com.yunpay.permission.service;
import java.util.List;
import java.util.Map;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.DealDetail;
import com.yunpay.permission.entity.SumDateDeal;
import com.yunpay.permission.entity.SumDayDeal;
import com.yunpay.permission.entity.PayTranLs;
public interface MerchantReportService {
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 商户交易报表的相关业务类
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月14日上午10:43:12 
	 * 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 *  2017年6月14日上午10:43:12      duan zhang quan   1.0     新建
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	
	/**
	 * 分页查询交易流水
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	PageBean<PayTranLs> list(PageParam pageParam,Map<String,Object> map);
	
	/**
	 * 按条件查询交易流水
	* 
	* @param 
	* @return List<PayTranLs>
	* @throws
	 */
	List<PayTranLs> listBy(Map<String,Object> map);
	
	
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
	* 日交易详细数据
	* @param 
	* @return PageBean<DealDetail>
	* @throws
	 */
	PageBean<DealDetail> dayDeal(PageParam pageParam,Map<String,Object> map) throws Exception;
	
	/**
	 * 
	* 
	*  日期范围交易详细数据
	* @param 
	* @return PageBean<DealDetail>
	* @throws
	 */
	PageBean<DealDetail> dateDeal(PageParam pageParam,Map<String,Object> map) throws Exception;
	
	
	/**
	 * 
	* 输出日交易图形报表数据
	* @param 
	* @return List<SumDayDeal>
	* @throws
	 */
	List<SumDayDeal> printDayDeal(Map<String,Object> map)  throws Exception;
	
	/**
	 * 
	* 输出日期范围交易图形报表数据
	* @param 
	* @return List<SumDayDeal>
	* @throws
	 */
	Map<String, Object> printDateDeal(Map<String,Object> map);

	/**
	* 
	* 处理查询日期条件
	* @param 
	* @return Map<String, Object>
	* @throws
	*/
	Map<String, Object> dateManager(Map<String, Object> map);
	

	/**
	 * 预留功能：
	 * 交易情况分析报表
	 */
}
