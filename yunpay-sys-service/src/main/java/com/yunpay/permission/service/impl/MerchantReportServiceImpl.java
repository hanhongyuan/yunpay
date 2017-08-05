package com.yunpay.permission.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.permission.dao.MerchantReportDao;
import com.yunpay.permission.entity.DealDetail;
import com.yunpay.permission.entity.PayTranLs;
import com.yunpay.permission.entity.SumDateDeal;
import com.yunpay.permission.entity.SumDayDeal;
import com.yunpay.permission.service.MerchantReportService;
@Repository("MerchantReportService")
public class MerchantReportServiceImpl implements MerchantReportService {
	
	@Autowired
	private MerchantReportDao merchantReportDao;
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年4月14日上午9:56:12 
	 * 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年4月14日     duan zhang quan   1.0     新建
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
	@SuppressWarnings("unchecked")
	@Override
	public PageBean<PayTranLs> list(PageParam pageParam,Map<String,Object> map) {
		return this.merchantReportDao.listPage(pageParam, map);
	}
	
	/**
	 * 按条件查询交易流水
	* 
	* @param 
	* @return List<PayTranLs>
	* @throws
	 */
	@Override
	public List<PayTranLs> listBy(Map<String,Object> map){
		return this.merchantReportDao.listBy(map);
	}
	
	/**
	 *日交易汇总
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	@Override
	public List<SumDayDeal> sumDayDeal(Map<String, Object> map) {
		return this.merchantReportDao.sumDayDeal( map);
	}
	
	/**
	 *日期范围交易汇总
	 * @param pageParam
	 * @param merchant
	 * @return
	 * @throws  
	 */
	@Override
	public List<SumDateDeal> sumDateDeal(Map<String, Object> map)  {
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		List<SumDateDeal> sumList=this.merchantReportDao.sumDateDeal(map);

		
		Calendar calendar = Calendar.getInstance();    
		calendar.setTime((Date)map.get("transTimeEnd")); 
		if(calendar.get(Calendar.HOUR)==0&&calendar.get(Calendar.MINUTE)==0&&calendar.get(Calendar.SECOND)==0){
			calendar.add(Calendar.DATE, -1); //当前时间减去一天
		}		  

		for(int i=0;i<sumList.size();i++){
			SumDateDeal sum=sumList.get(i);
			sum.setTimeBegin(formatter.format((Date)map.get("transTimeBegin")));
			sum.setTimeEnd(formatter.format(calendar.getTime()));
			sumList.set(i, sum);
		}
		return sumList;
	}


	/**
	 *日交易详细分页查询 
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	@Override
	public PageBean<DealDetail> dayDeal(PageParam pageParam,Map<String,Object> map) throws Exception{
		PageBean<DealDetail> pageBean = this.merchantReportDao.dayDeal(pageParam, map);
		List<DealDetail> list = pageBean.getRecordList();
		LinkedList<DealDetail> linked = new LinkedList<DealDetail>(list);
		// 重新排列结果集,合计的数据放到最后一行
		if(list.size() >0){
			int index = -1;
			DealDetail obj = null;
			for(int i=0; i<linked.size(); i++){
				if("合计".equals(linked.get(i).getMerchantName())){
					obj = linked.get(i);
					index = i;
					linked.remove(index);
					break;
				}
			}
			linked.addLast(obj);
			pageBean.setRecordList(linked);
			return pageBean;
		}else{
			throw new NullPointerException("ArrayList is null");
		}
		
	}

	/**
	 *日期范围交易详细分页查询 
	 * @param pageParam
	 * @param merchant
	 * @return
	 * @throws 
	 */
	@Override
	public PageBean<DealDetail> dateDeal(PageParam pageParam,Map<String,Object> map) throws Exception{
		PageBean<DealDetail> pageBean = this.merchantReportDao.dateDeal(pageParam,map);
		List<DealDetail> list = pageBean.getRecordList();
		LinkedList<DealDetail> linked = new LinkedList<DealDetail>(list);
		// 重新排列结果集,合计的数据放到最后一行
		if(list.size() >0){
			int index = -1;
			DealDetail obj = null;
			for(int i=0; i<linked.size(); i++){
				if("合计".equals(linked.get(i).getMerchantName())){
					obj = linked.get(i);
					index = i;
					linked.remove(index);
					break;
				}
			}
			linked.addLast(obj);
			pageBean.setRecordList(linked);
			return pageBean;
		}else{
			throw new NullPointerException("ArrayList is null");
		}
		
		
	}


	/**
	 * @throws Exception 
	 * 
	 * 输出日交易图形报表数据
	 * 
	 * @param
	 * @return List<SumDayDeal>
	 * @throws
	 */
	public List<SumDayDeal> printDayDeal(Map<String, Object> map) throws Exception {
		List<String> timeList = new ArrayList<String>();
		String transTime = (String)map.get("transTime");
		// 添加0-23点的时间段
		for (int i = 0; i < 24; i++) {
			String time = String.valueOf(i);
			if (i > 0 && i < 10) {
				time = "0" + time;
			}
			timeList.add(time);
		}
		// 默认查询当天的交易
		if (transTime == null) {
			transTime = DateUtils.today();
			map.put("transTime", transTime);
		}
		map.put("unionList", timeList);
		List<SumDayDeal> data = this.merchantReportDao.printDayDeal(map);
		// 一个队列，用于存放交易数据
		List<SumDayDeal> queue = new ArrayList<SumDayDeal>();
		this.listFilter(data, queue);
		return queue;
	}
	
	/**
	 * 
	* 集合数据过滤,以00-23点之间 的 间隔2小时内的区间数据进行汇总
	* @param 
	* @return void
	* @throws
	 */
	private void listFilter(List<SumDayDeal> data,List<SumDayDeal> queue) throws Exception{   
		if(data != null){
			String wechat = "微信";
			String alipay = "支付宝";
			List<SumDayDeal> wechatList = new ArrayList<SumDayDeal>();
			List<SumDayDeal> alipayList = new ArrayList<SumDayDeal>();
			int totalLenth = data.size();
			int length = (totalLenth / 2);
			for(int i=0; i<totalLenth; i++){   // 总记录数 
				String channel = data.get(i).getChannel();
				if(channel.equals(wechat)){
					for(int n = 0; n<length; n++){ 	// 总共要计算的次数 
						// 指定索引
						int index = n * 2;  
						// 每次取多少条记录
						int limit = (n * 2) + 2;
						// 最后一次只统计一条记录
						if(n == length-1){
							index = totalLenth - 2;
							limit = index+1;
						}
						// timeStart-timeEnd： 0-2  ,2-4 ,  4-6 .....
						String timeStart = String.valueOf(index);
						if(index <10){
							timeStart = "0"+timeStart;
						}
						String timeEnd = String.valueOf(limit);
						if(limit <10){
							timeEnd = "0"+timeEnd;
						}
						//String transTime = timeStart+"-"+timeEnd;
						String transTime = String.valueOf(index);
						// 每次对相邻的两条记录进行区间汇总
						int sum = 0;
						for(int j=index; j<=limit; j++){  
							SumDayDeal s = data.get(j);
							int currentSum = s.getWechatCountTrans();
							sum = sum + currentSum;
						}
						wechatList.add(new SumDayDeal(wechat,transTime,sum,0));
					}
				}
				else if(channel.equals(alipay)){
					for(int n = 0; n<length; n++){ 	// 总共要计算的次数 
						// 指定索引
						int index = n * 2;  
						// 每次取多少条记录
						int limit = (n * 2) + 2;
						if(n == length-1){
							index = totalLenth - 2;
							limit = index + 1;
						}
						// timeStart-timeEnd： 0-2  ,2-4 ,  4-6 .....
						String timeStart = String.valueOf(index);
						if(index <10){
							timeStart = "0"+timeStart;
						}
						String timeEnd = String.valueOf(limit);
						if(limit <10){
							timeEnd = "0"+timeEnd;
						}
						String transTime = timeStart+"-"+timeEnd;
						// 每次对相邻的两条记录进行区间汇总
						int sum = 0;
						for(int j=index; j<=limit; j++){  
							SumDayDeal s = data.get(j);
							int currentSum = s.getAlipayCountTrans();
							sum = sum + currentSum;
						}
						alipayList.add(new SumDayDeal(alipay,transTime,0,sum));
					}
				}
				break;
			}
			queue.addAll(wechatList);
			queue.addAll(alipayList);
		}else{
			throw new NullPointerException("ArrayList is null");
		}
	}
	

	
   /**
	* 
	* 输出日期范围交易图形报表数据
	* @param 
	* @return List<SumDayDeal>
	* @throws
	*/
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> printDateDeal(Map<String,Object> map){
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd ");		
		List<List<SumDateDeal>> printListFirst=new ArrayList<>();
		List<List<SumDateDeal>> printListSecond=new ArrayList<>();
		Map<String, Object> checkMap=new HashMap<>();
		checkMap.putAll(map);
		Map<String, Object> recordMap=new HashMap<>();
		//将查询时间划分成两个月
		Map<String, Object> timeMap=determineMonth(checkMap);
		//结果中插入交易渠道查询条件		
		if(checkMap.get("channel")!=null){			
			recordMap.put("channel", checkMap.get("channel"));		
		}
		//month用于判断时间跨度，1为一个月，2为两个月
		recordMap.put("month", (int)timeMap.get("month"));
		//monthFirst:月份，第一个月
		recordMap.put("monthFirst", (int)timeMap.get("monthFirst"));		
		//输出每月的最大天数，时间跨度为一个月时，第二个月最大天数设置为0
		recordMap.put("firstMonthDays", (int)timeMap.get("firstMonthDays"));
		recordMap.put("secondMonthDays", (int)timeMap.get("secondMonthDays"));
		//输出查询开始天数和结束天数
		recordMap.put("timeBeginDate", (int)timeMap.get("timeBeginDate"));
		recordMap.put("timeEndDate", (int)timeMap.get("timeEndDate"));
		//将第一个月每天的数据查询出来，加到printListFirst，不在时间范围内的直接用构造函数给0值,最后加到recordMap中
		for(int i=(int)timeMap.get("timeBeginDate");i<=(int)timeMap.get("timeEndDate");i++){
			List<SumDateDeal> useList=new ArrayList<>();
			Date transTimeBeginFirst=((Map<Integer,Date>)timeMap.get("timeMapBeginFirst")).get(i);
			Date transTimeEndFirst=((Map<Integer,Date>)timeMap.get("timeMapEndFirst")).get(i);			
			checkMap.put("transTimeBegin", transTimeBeginFirst);
			checkMap.put("transTimeEnd", transTimeEndFirst);
			checkMap.put("timeBegin", format.format(transTimeBeginFirst));
			checkMap.put("timeEnd", format.format(transTimeEndFirst));
			useList=this.merchantReportDao.sumDateDeal(checkMap);
			printListFirst.add(useList);
						
		}
		//当时间跨度为两个月时，将第二个月每天的数据查询出来，加到printListSecond，不在时间范围内的直接用构造函数给0值,最后加到recordMap中
		if((int)timeMap.get("month")==2){
			for(int i=(int)timeMap.get("secondTimeBeginDate");i<=(int)timeMap.get("secondTimeEndDate");i++){
				List<SumDateDeal> useList=new ArrayList<>();
				Date transTimeBeginSecond=((Map<Integer,Date>)timeMap.get("timeMapBeginSecond")).get(i);
				Date transTimeEndSecond=((Map<Integer,Date>)timeMap.get("timeMapEndSecond")).get(i);				
				checkMap.put("transTimeBegin", transTimeBeginSecond);
				checkMap.put("transTimeEnd", transTimeEndSecond);
				checkMap.put("timeBegin", format.format(transTimeBeginSecond));
				checkMap.put("timeEnd", format.format(transTimeEndSecond));
				useList=this.merchantReportDao.sumDateDeal(checkMap);
				printListSecond.add(useList);								
			}
			//monthSecond:月份，第二个月
			recordMap.put("monthSecond", (int)timeMap.get("monthSecond"));
			//输出第二个月查询开始和结束的天数
			recordMap.put("secondTimeBeginDate", (int)timeMap.get("secondTimeBeginDate"));
			recordMap.put("secondTimeEndDate", (int)timeMap.get("secondTimeEndDate"));
		}		
		recordMap.put("printListFirst", printListFirst);
		recordMap.put("printListSecond", printListSecond);		
		return recordMap;
	}
	
	/**
	* 
	* 处理查询日期条件
	* @param 
	* @return Map<String, Object>
	* @throws
	*/
	@Override	
	public Map<String, Object> dateManager(Map<String,Object> map)  {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();	
		Map<String, Object> usemap=map;
		Date transTimeBegin=null;
		Date transTimeEnd = null;
		
		try
		{	if(StringUtils.isBlank((String)usemap.get("timeBegin"))){
			transTimeBegin=null;
			}else{
				Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
				Boolean matches=pattern.matcher((String)usemap.get("timeBegin")).matches();
				if(matches){
					transTimeBegin = fmt.parse((String)usemap.get("timeBegin"));				
				}else{
					transTimeBegin=null;
				}
			}
			
			transTimeEnd=StringUtils.isBlank((String)usemap.get("timeEnd"))?null:fmt.parse((String)usemap.get("timeEnd"));	
		} catch (ParseException e)
		{
			e.printStackTrace();
		}		
		if(transTimeBegin==null){			
			if(transTimeEnd==null)
			{
				transTimeEnd = merchantReportDao.getLastTranTime();
				calendar.setTime(transTimeEnd);
				if(calendar.get(Calendar.MONTH)==0)
				{
					calendar.set(calendar.get(Calendar.YEAR)-1, 11, 1, 0, 0, 0);
				}
				else
				{
					calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)-1, 1, 0, 0, 0);
				}			
				transTimeBegin =calendar.getTime();
			}
			else
			{
				calendar.setTime(transTimeEnd);
				Calendar calendar1 = Calendar.getInstance();	
				calendar1.setTime(transTimeEnd);				
				calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DATE)+1, 0, 0, 0);
				transTimeEnd =calendar1.getTime(); 
				if(calendar.get(Calendar.MONTH)==0)
				{
					calendar.set(calendar.get(Calendar.YEAR)-1, 11, 1, 0, 0, 0);
				}
				else
				{
					calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)-1, 1, 0, 0, 0);
				}			
				transTimeBegin =calendar.getTime();				
			}			
		}
		else if(transTimeBegin!=null&&transTimeEnd==null)
		{
			calendar.setTime(transTimeBegin);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH)+1;
			if(month==12)
			{
				calendar.set(year+1, 0, 32, 0, 0, 0);
			}
			else
			{
				calendar.set(year, month, getDaysPerMonth(year, month+1)+1, 0, 0, 0);
			}			
			transTimeEnd =calendar.getTime();
		}
		else
		{
			calendar.setTime(transTimeEnd);
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)+1, 0, 0, 0);
			transTimeEnd =calendar.getTime();
		}
		usemap.put("transTimeBegin", transTimeBegin);
		usemap.put("transTimeEnd", transTimeEnd);
		return usemap;
	}
	
   /**
	* 
	* 取得每月的天数
	* @param year，month
	* @return int
	* @throws
	*/	
	private static Integer getDaysPerMonth(Integer year, Integer month)  
	{  
	    Calendar a = Calendar.getInstance();  
	    a.set(Calendar.YEAR, year);  
	    a.set(Calendar.MONTH, month-1);  
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天  
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天  
	    Integer dayNum= a.get(Calendar.DATE);  
	    return dayNum;  
	} 
	/**
	 * 
	 * 分割查询时间到两个月
	 * @param timeBegin，timeEnd
	 * @return Map<String,Object>
	 * @throws
	 */	
	private static Map<String,Object> determineMonth(Map<String,Object> map)  
	{  
		Calendar a = Calendar.getInstance();  
		Calendar b = Calendar.getInstance();		
		Map<String,Object> mapMonth =new HashMap<String, Object>();
		a.setTime((Date)map.get("transTimeBegin"));		
		b.setTime((Date)map.get("transTimeEnd"));
		b.add(Calendar.SECOND, -2);
		//输出第一个月的月份
		mapMonth.put("monthFirst", a.get(Calendar.MONTH)+1);	
		//输出第一个月需查询的开始天数
		mapMonth.put("timeBeginDate", a.get(Calendar.DATE));		
		//跨两个月输出第一个月每天查询的时间，未跨两个月，输出该月每天查询的时间
		Map<Integer,Date> timeMapBeginFirst=new HashMap<Integer,Date>();
		Map<Integer,Date> timeMapBeginSecond=new HashMap<Integer,Date>();
		Map<Integer,Date> timeMapEndFirst=new HashMap<Integer,Date>();
		Map<Integer,Date> timeMapEndSecond=new HashMap<Integer,Date>();
		for(int i=1;i<=getDaysPerMonth(a.get(Calendar.YEAR), a.get(Calendar.MONTH)+1);i++){
			Calendar c = Calendar.getInstance();
			c.set(a.get(Calendar.YEAR), a.get(Calendar.MONTH), i, 0, 0, 0);
			timeMapBeginFirst.put(i, c.getTime());
			c.set(a.get(Calendar.YEAR), a.get(Calendar.MONTH), i+1, 0, 0, 0);
			timeMapEndFirst.put(i, c.getTime());
		}		
		if(a.get(Calendar.MONTH)!=b.get(Calendar.MONTH)){			
			//用于判断是否划分成两个月，1一个月，2为两个月
			mapMonth.put("month", 2);
			//输出第二个月的月份
			mapMonth.put("monthSecond", a.get(Calendar.MONTH)+2);	
			//输出第一个月需查询结束的天数
			mapMonth.put("timeEndDate", getDaysPerMonth(a.get(Calendar.YEAR), a.get(Calendar.MONTH)+1));
			//输出第二个月需查询开始的天数
			mapMonth.put("secondTimeBeginDate", 1);
			//输出第二个月需查询结束的天数
			mapMonth.put("secondTimeEndDate", b.get(Calendar.DATE));
			//跨两个月，输出第二个月每天查询的时间，
			for(int i=1;i<=getDaysPerMonth(b.get(Calendar.YEAR), b.get(Calendar.MONTH))+1;i++){
				Calendar c = Calendar.getInstance();
				c.set(b.get(Calendar.YEAR), b.get(Calendar.MONTH), i, 0, 0, 0);
				timeMapBeginSecond.put(i, c.getTime());
				c.set(b.get(Calendar.YEAR), b.get(Calendar.MONTH), i+1, 0, 0, 0);
				timeMapEndSecond.put(i, c.getTime());
			}			
			//输出每月的最大天数
			mapMonth.put("firstMonthDays", getDaysPerMonth(a.get(Calendar.YEAR), a.get(Calendar.MONTH)+1));			
			mapMonth.put("secondMonthDays", getDaysPerMonth(b.get(Calendar.YEAR), b.get(Calendar.MONTH)+1));
		} else{			
			//用于判断是否划分成两个月，1一个月，2为两个月
			mapMonth.put("month", 1);	
			//输出第一个月需查询结束的天数
			mapMonth.put("timeEndDate", b.get(Calendar.DATE));
			//输出每月的最大天数
			mapMonth.put("firstMonthDays", getDaysPerMonth(a.get(Calendar.YEAR), a.get(Calendar.MONTH)+1));
			mapMonth.put("secondMonthDays", 0);			
		}		
		mapMonth.put("timeMapBeginFirst", timeMapBeginFirst);
		mapMonth.put("timeMapEndFirst", timeMapEndFirst);
		mapMonth.put("timeMapBeginSecond", timeMapBeginSecond);
		mapMonth.put("timeMapEndSecond", timeMapEndSecond);
		
		return mapMonth;  
	} 
}
