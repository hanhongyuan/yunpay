package com.yunpay.sdk.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.yunpay.union.config.SDKConfig;
import com.yunpay.union.utils.CertUtil;

/**
 * 银联配置初始化
 * 文件名称:     InitConfigServlet.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月18日下午3:19:38 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月18日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class InitConfigServlet  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 从classpath加载acp_sdk.properties文件
		SDKConfig.getConfig().loadPropertiesFromSrc();
		CertUtil.init();
		super.init();
	}
}
