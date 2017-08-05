package com.yunpay.permission.service;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.entity.Merchant;

@Service("MerchService")
public interface MerchService {
	
	/**
	 * 查询商户信息
	 * @param merchId
	 * @return
	 */
	Merchant queryMerchById(String merchId);
	
	/**
	 * 分页查询
	 * @param pageParam
	 * @param merchant
	 * @return
	 */
	PageBean<Merchant> listPage(PageParam pageParam,Map<String,Object> map);
	
	
	
	/**
	 * 根据条件查询
	* 
	* @param 
	* @return List<Merchant>
	* @throws
	 */
	List<Merchant> listBy(Map<String,Object> map);
	/**
	 * 获取所有的省市区数据
	 * @return
	 */
	Map<String,String> getAllProv();
	
	/**
	 * 获取省
	 * @param aratId：省区号
	 * @return
	 */
	List<Address> getProvince();
	
	/**
	 * 获取市
	 * @param aratId：市区号
	 * @return
	 */
	List<Address> getCity(int id);
	
	/**
	 * 获取区
	 * @param aratId ：区号
	 * @return
	 */
	List<Address> getArea(int id);
	
	/**
	 * 查询商户是否 进行了支付宝、微信配置
	 * * @param serialNo：商户号
	 * @param confType:配置类型：微信、支付宝
	 * @return
	 */
	Object isConfig(String merchId,String confType);
	

	/**
	 * 根据商户id查询微信、支付宝配置信息
	 * @param merchId
	 * @return
	 */
	Object queryConfigById(String merchId,String confType);
	
	/**
	 * 保存支付宝配置数据
	 * @return
	 */
	int savePayConfig(Object obj);
	
	/**
	 * 更新微信配置数据
	 * @return
	 */
	int updatePayConfig(Object obj);
}
