package com.yunpay.permission.dao.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.MerchantReportDao;
import com.yunpay.permission.entity.DealDetail;
import com.yunpay.permission.entity.SumDateDeal;
import com.yunpay.permission.entity.SumDayDeal;
import com.yunpay.permission.entity.PayTranLs;
@Repository("MerchantReportDao")
public class MerchantReportDaoImpl extends PermissionBaseDaoImpl<PayTranLs> implements  MerchantReportDao{
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月21日上午9:56:12 
	 * 
	 * 修改历史:  
	 * 修改日期             修改人员            版本	     修改内容  
	 * ----------------------------------------------  
	 * 2017年6月21日     duan zhang quan   1.0     新建
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
	@Override
	public List<SumDayDeal> sumDayDeal(Map<String, Object> map) {
		return super.getSqlSession().selectList(getStatement("sumDayDeal"), map);
	}

	
	/**
	 *日期范围交易汇总
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	@Override
	public List<SumDateDeal> sumDateDeal(Map<String, Object> map) {
		List<SumDateDeal> list=super.getSqlSession().selectList(getStatement("sumDateDeal"),map);		
		return sort(list, (String)map.get("timeBegin"), (String)map.get("timeEnd"));
	}
		
		/**
		* 日交易详细数据
		* @param 
		* @return PageBean<DealDetail>
		* @throws
		 */
		@SuppressWarnings("unchecked")
		public PageBean<DealDetail> dayDeal(PageParam pageParam,Map<String,Object> map){
			// 统计总记录数
			String sqlIdByCount = "countDayDeal";
			// 分页查询
			String sqlIdByListPage = "dayDeal";
			PageBean<DealDetail> pageBean = this.listPage(pageParam, sqlIdByCount, sqlIdByListPage, map);
			return pageBean;
		}
		
		/**
		*  日期范围交易详细数据
		* @param 
		* @return PageBean<DealDetail>
		* @throws
		 */
		@SuppressWarnings("unchecked")
		public PageBean<DealDetail> dateDeal(PageParam pageParam,Map<String,Object> map){
			// 统计总记录数
			String sqlIdByCount = "countDateDeal";
			// 分页查询
			String sqlIdByListPage = "dateDeal";
			PageBean<DealDetail> pageBean = this.listPage(pageParam, sqlIdByCount, sqlIdByListPage, map);
			return pageBean;
		}
		

		/**
		 * 
		* 输出日交易图形报表数据
		* @param 
		* @return List<SumDayDeal>
		* @throws
		 */
		public List<SumDayDeal> printDayDeal(Map<String,Object> map){
			return super.getSqlSession().selectList(getStatement("printDayDeal"), map);
		}
		/**
		 * 
		 * 输出最后交易时间
		 * @param 
		 * @return Date
		 * @throws
		 */
		public Date getLastTranTime(){
			return super.getSqlSession().selectOne(getStatement("getLastTranTime"));
		}
		
		/**
		 * 
		* 输出日期范围交易图形报表数据
		* @param 
		* @return List<SumDayDeal>
		* @throws
		 */
		public List<SumDateDeal> printDateDeal(Map<String,Object> map){
			return super.getSqlSession().selectList(getStatement("printDateDeal"), map);
		}
		
		 @Override
		 @SuppressWarnings({ "unchecked", "rawtypes" })
		   public PageBean listPage(PageParam pageParam,String type,String pag, Map<String, Object> paramMap) {
			 	if(pageParam == null){
			 		return new PageBean();
			 	}else{
			 	     if (paramMap == null) {
				            paramMap = new HashMap<String, Object>();
				        }
				        // 统计总记录数
				        int totalCount = super.getSqlSession().selectOne(getStatement(type), paramMap);
				        
				        // 校验当前页数
				        int currentPage = PageBean.checkCurrentPage(totalCount, pageParam.getPageSize(), pageParam.getPageCurrent());
				        pageParam.setPageCurrent(currentPage); // 为当前页重新设值
				        // 校验页面输入的每页记录数numPerPage是否合法
				        int numPerPage = PageBean.checkNumPerPage(pageParam.getPageSize()); // 校验每页记录数
				        pageParam.setPageSize(numPerPage); // 重新设值

				        // 根据页面传来的分页参数构造SQL分页参数
				     // 根据页面传来的分页参数构造SQL分页参数
				        paramMap.put("pageIndex", (pageParam.getPageCurrent() - 1) * pageParam.getPageSize());      //当前页数
				        paramMap.put("pageSize", pageParam.getPageSize());            //每页显示多少条数据
				        // 获取分页数据集
				        List<Object> list = super.getSqlSession().selectList(getStatement(pag), paramMap);
				        
				        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
				        if (isCount != null && "1".equals(isCount.toString())) {
				            Map<String, Object> countResultMap = super.getSqlSession().selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
				            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount, list, countResultMap);
				        } else {
				            // 构造分页对象
				            return new PageBean(pageParam.getPageCurrent(), pageParam.getPageSize(), totalCount, list);
				        }
				    }
			 	}
			/**
			 * 将结果按先微信后支付宝排序，查询结果为空时构造一个默认值。
			 * @param list
			 * @param timeBegin
			 * @param timeEnd
			 * @return
			 */
			private List<SumDateDeal> sort(List<SumDateDeal> list,String timeBegin,String timeEnd)
			{
				SumDateDeal suma=new SumDateDeal();
				SumDateDeal sumb=new SumDateDeal();
				if(list.size()==0){
					suma.setChannel("微信");
					sumb.setChannel("支付宝");						
				}else if(list.size()==1){
					if("微信".equals(list.get(0).getChannel())){
						suma = list.get(0);	
						sumb.setChannel("支付宝");
					}else{
						suma.setChannel("微信");
						sumb = list.get(0);					
					}
				}else if(list.size()==2){
					if("微信".equals(list.get(0).getChannel())){
						suma = list.get(0);
						sumb = list.get(1);				
					}else{
						suma = list.get(1);
						sumb = list.get(0);
					}
				}
				suma.setTimeBegin(timeBegin);
				sumb.setTimeBegin(timeBegin);
				suma.setTimeEnd(timeEnd);
				sumb.setTimeEnd(timeEnd);
				list.clear();
				list.add(suma);
				list.add(sumb);
				return list;
			}

}
