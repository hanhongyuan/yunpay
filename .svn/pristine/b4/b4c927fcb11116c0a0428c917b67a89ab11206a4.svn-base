package com.yunpay.permission.service;
import java.util.Map;
import com.yunpay.permission.entity.Address;

/**
 * 类名称		      行政区域业务接口类
 * 文件名称:     AddressService.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年6月16日下午3:44:00
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月16日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface AddressService {	
	/**
	 * 获取所有的省市区数据
	 * @return
	 */
	Map<Integer,String> getAllProv();
	
	/**
	 * 获取省
	 * @return
	 */
	Map<Integer,String> getProvList();
	
	/**
	 * 根据省id获取市
	 * @param id：
	 * @param 
	 * @return
	 */
	Map<Integer,String> getCityList(int id);
	
	/**
	 * 根据市id获取区县
	 * @param id
	 * @return
	 */
	Map<Integer,String> getAreaList(int id);	
	/**
	 * 根据区域编码获取区域
	 * @param code ：区号
	 * @return
	 */
	Address getByCode(String code);	
	/**
	 * 根据区域名称获取区域
	 * @param title
	 * @return
	 */
	Address getByTitle(String title);
	/**
	 * 根据区域名称获取区域
	 * @param title
	 * @return
	 */
	Address getById(Integer id);
}
