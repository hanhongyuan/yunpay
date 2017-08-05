package com.yunpay.permission.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.MerchDao;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.entity.Merchant;
import com.yunpay.permission.service.MerchService;
/**
 * 商户信息 业务类
 * @author duan zhang quan
 *
 */
@Service("MerchServiceImpl")
public class MerchServiceImpl implements MerchService{
	@Autowired
	private MerchDao merchDao;

	/**
	 * 分页查询商户数据
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PageBean<Merchant> listPage(PageParam pageParam, Map<String,Object> map) {
		
		return merchDao.listPage(pageParam, map);
	}
	
	/**
	 * 根据条件查询
	* 
	* @param 
	* @return List<Merchant>
	* @throws
	 */
	@Override
	public List<Merchant> listBy(Map<String,Object> map){
		return this.merchDao.listBy(map);
	}

	/**
	 * 查询商户详细信息
	 * 
	 */
	@Override
	public Merchant queryMerchById(String merchId) {
		return merchDao.queryMerchById(merchId);
	}
	
	/**
	 * 获取所有的省市区数据
	 * @return
	 */
	@Override
	public Map<String,String> getAllProv(){
		Map<String,String> map = new HashMap<String,String>();
		List <Address> address = merchDao.getAllProv();
		for(int i=0; i<address.size(); i++){
			String id = String.valueOf(address.get(i).getId());
			String title = address.get(i).getTitle();
			map.put(id,title);
		}
		return map;
	}
	

	@Override
	public List<Address> getProvince() {
		return merchDao.getProvince();
	}

	/**
	 * 获取市
	 * @param aratId：市区号
	 * @return
	 */
	@Override
	public List<Address> getCity(int id){
		return merchDao.getCity(id);
	}
	
	/**
	 * 获取区
	 * @param aratId ：区号
	 * @return
	 */
	@Override
	public List<Address> getArea(int id){
		return this.merchDao.getArea(id);
	}

	/**
	 * 查询商户是否 进行了支付宝、微信配置
	 * @param merchId
	 * @return
	 */
	@Override
	public Object isConfig(String merchId,String confType) {
		return this.merchDao.isConfig(merchId, confType);
	}

	/**
	 * 根据商户id查询微信、支付宝配置信息
	 * @param merchId
	 * @return
	 */
	@Override
	public Object queryConfigById(String merchId,String confType) {
		return this.merchDao.queryConfigById(merchId, confType);
	}
	
	
	/**
	 * 保存支付宝配置数据
	 * @return
	 */
	@Override
	public int savePayConfig(Object obj){
		return this.merchDao.savePayConfig(obj);
	}
	
	/**
	 * 更新微信配置数据
	 * @return
	 */
	@Override
	public int updatePayConfig(Object obj){
		return this.merchDao.updatePayConfig(obj);
	}
	
	
	
	

	

}
