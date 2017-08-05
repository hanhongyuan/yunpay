package com.yunpay.serv.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.yunpay.serv.model.Merchant;



/**
 * 商户信息Dao
 * 文件名称:     MerchDao.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月21日下午2:28:00 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月21日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Repository("merchantDao")
public interface MerchantDao{
	
	@Select("select * from t_merchant where merchantNo = #{merchantNo}")
	public Merchant queryMerchInfo(String merchNo);
}
