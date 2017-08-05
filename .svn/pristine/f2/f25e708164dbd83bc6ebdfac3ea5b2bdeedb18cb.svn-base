package com.yunpay.serv.route;

import org.springframework.stereotype.Service;

import com.yunpay.serv.service.pay.QrPayService;

/**
 * 抽象工厂
 * 文件名称:     AbstractFactory.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午2:36:29 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service
public interface AbstractFactory {
	
	public QrPayService getServiceByOrderfix(String codePrefix);
	
	public QrPayService getServiceByChannel(int channel);
	
}
