package com.yunpay.permission.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.yunpay.permission.dao.MerchDao;
import com.yunpay.permission.entity.Address;
import com.yunpay.permission.entity.Agent;
import com.yunpay.permission.entity.AlipayConfig;
import com.yunpay.permission.entity.Merchant;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.WechatConfig;

@Repository("MerchDao")
public class MerchDaoImpl extends PermissionBaseDaoImpl<Merchant> implements MerchDao{
	
	@Override
	public Merchant queryMerchById(String merchId) {
		return super.getSqlSession().selectOne(getStatement("queryMerchById"), merchId);
	}
	
	@Override
	public Agent getAgentByCode(String agentSerialNo) {
		return super.getSqlSession().selectOne(getStatement("getAgentByCode"), agentSerialNo);
	}

	
	public int updateStstus(Merchant merchant){
		return super.getSqlSession().update(getStatement("updateStstus"), merchant);
	}
	

	@Override
	public List<TermEntity> queryMerchTerm(String merchId) {
		return super.getSqlSession().selectList(getStatement("queryMerchTerm"),merchId);
	}

	@Override
	public int updateTermStatus(Merchant merchant) {
		return super.getSqlSession().update(getStatement("updateTermStatus"),merchant);
	}

	
	/**
	 * 获取所有的省市区数据
	 * @return
	 */
	@Override
	/**
	 * 获取所有的省市区数据
	 * @return
	 */
	public List<Address> getAllProv(){
		return super.getSqlSession().selectList(getStatement("getAllProv"));
	}

	@Override
	public List<Address> getProvince() {
		return super.getSqlSession().selectList(getStatement("getProvince"));
	}

	@Override
	public List<Address> getCity(int id) {
		
		return super.getSqlSession().selectList(getStatement("getCity"),id);
	}

	@Override
	public List<Address> getArea(int id) {
		
		return super.getSqlSession().selectList(getStatement("getArea"),id);
	}
	
	/**
	 * 查询是否进行了支付宝或微信配置
	 */
	public Object isConfig(String merchId,String confType){
		Object obj = null;
		if(confType.equals("wechat")){
			obj = super.getSqlSession().selectOne(getStatement("isConfigWechat"), merchId);
			if(obj == null){
				return new WechatConfig();
			}else{
				return obj;
			}
				
		}else if(confType.equals("alipay")){
			obj = super.getSqlSession().selectOne(getStatement("isConfigAlipay"), merchId);
			if(obj == null){
				return new AlipayConfig();
			}else{
				return obj;
			}
		}else{
			return null;
		}
	}
		
	/**
	 * 查询微信或支付宝配置
	 */
	public Object queryConfigById(String merchId,String confType){
		if(confType.equals("wechat")){
			return super.getSqlSession().selectOne(getStatement("queryWechatConfig"), merchId);
		}else if(confType.equals("alipay")){
			return super.getSqlSession().selectOne(getStatement("queryAlipayConfig"), merchId);
		}else{
			return null;
		}
	}
	
	/**
	 * 保存微信或者支付宝配置数据
	 * @return
	 */
	public int savePayConfig(Object obj){
		 if(obj instanceof AlipayConfig){
			 AlipayConfig alipay = (AlipayConfig)obj;
			 return super.getSqlSession().insert("saveAlipayConfig",alipay);
		 }
		 else if(obj instanceof WechatConfig){
			 WechatConfig wechat = (WechatConfig)obj;
			 return super.getSqlSession().insert("saveWechatConfig",wechat); 
		 }
		 else{
			 return 0;
		 }
	}
	
	/**
	 * 更新微信或者支付宝配置
	 * @param obj
	 * @return
	 */
	public int updatePayConfig(Object obj){
		 if(obj instanceof AlipayConfig){
			 AlipayConfig alipay = (AlipayConfig)obj;
			 return super.getSqlSession().update("updateAlipayConfig",alipay);
		 }
		 else if(obj instanceof WechatConfig){
			 WechatConfig wechat = (WechatConfig)obj;
			 return super.getSqlSession().update("updateWechatConfig",wechat); 
		 }
		 else{
			 return 0;
		 }
	}
}
