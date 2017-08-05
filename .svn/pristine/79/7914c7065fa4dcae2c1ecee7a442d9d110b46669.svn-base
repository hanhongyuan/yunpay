package com.yunpay.serv.service.busi.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.serv.dao.MerchantDao;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.service.busi.MerchantService;

/**
 * 商户信息业务类
 * 文件名称:     MerchantServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月22日下午2:21:46 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月22日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDao merchantDao;
	
	/**
	 * @Description: 根据商户号查询商户信息
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月22日下午2:22:04 
	 * @param merchNo 商户号
	 * @return
	 */
	@Override
	public Merchant queryMerchInfo(String merchNo) {
		// TODO Auto-generated method stub
		return merchantDao.queryMerchInfo(merchNo);
	}
}
