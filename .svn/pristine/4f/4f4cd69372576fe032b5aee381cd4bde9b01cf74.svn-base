package com.yunpay.permission.dao;
import java.util.List;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.entity.Agent;
import com.yunpay.permission.entity.Merchant;
import com.yunpay.permission.entity.TermEntity;
public interface MerchDao extends PermissionBaseDao<Merchant>{
	
	/**
	 * 查询商户信息
	 * @param merchId
	 * @return
	 */
	Merchant queryMerchById(String merchId);
	
	/**
	 * 查询该商户下的终端信息
	 * @param merchId
	 * @return
	 */
	List<TermEntity> queryMerchTerm(String merchId);
	
	/**
	 * 修改终端状态
	 * @param merchant
	 * @return
	 */
	int updateTermStatus(Merchant merchant);
	
	/**
	 * 通过code查询代理商
	 * @param agentSerialNo
	 * @return
	 */
	Agent getAgentByCode(String agentSerialNo);
	
	/**
	 * 获取所有的省市区数据
	 * @return
	 */
	List<Address> getAllProv();
	
	/**
	 * 获取省
	 * @return
	 */
	List<Address> getProvince();
	
	/**
	 * 获取市
	 * @param id：市区号
	 * @param 
	 * @return
	 */
	List<Address> getCity(int id);
	
	/**
	 * 获取区
	 * @param id ：区号
	 * @return
	 */
	List<Address> getArea(int id);
	
	
	/**
	 * 查询商户是否 进行了支付宝、微信配置
	 * @param merchId
	 * @return
	 */
	Object isConfig(String merchId,String confType);
		
	/**
	 * 根据商户id查询微信支付宝配置信息
	 * @param merchId
	 * @return
	 */
	Object queryConfigById(String merchId,String confType);

	/**
	 * 保存微信或者支付宝配置数据
	 * @return
	 */
	public int savePayConfig(Object obj);
	
	/**
	 * 更新微信或者支付宝配置
	 * @param obj
	 * @return
	 */
	public int updatePayConfig(Object obj);
	
	

	


	

	
	
}
