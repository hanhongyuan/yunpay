package com.yunpay.serv.service.pay;

import java.util.Map;

/**
 * 支付回调业务处理类
 * 文件名称:     PayNotifyService.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月27日下午5:23:17 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月27日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface PayNotifyService {
	
	/**
	 * @Description:微信支付回调通知业务处理 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日下午5:22:54 
	 * @param recvMsg
	 */
	public boolean wechatScanNotify(String recvInfo);
	
	/**
	 * @Description: 支付宝支付回调通知业务处理
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月4日上午11:28:19 
	 * @param recvParam
	 * @return
	 */
	public boolean alipayScanNotify(Map<String,String> recvParam);
	
	
	/**
	 * @Description: 银联支付回调通知业务处理
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日上午8:49:08 
	 * @param recvParam
	 * @return
	 */
	public boolean unionScanNotify(Map<String,String> recvParam);
}
