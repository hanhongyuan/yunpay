package com.yunpay.sdk.ctrl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xml.sax.SAXException;

import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.Log;
import com.yunpay.common.utils.XmlUtil;

/**
 * 卡券业务异步通知接收类
 * 文件名称:     CardNotifyCtrl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月2日下午4:55:49 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月2日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Controller
public class CardNotifyCtrl extends BaseCtrl{
	
	
	/**
	 * @Description: 微信卡券异步通知入口
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月2日下午4:58:39 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping("/card/wechat/notify")
	public void wechatCardNotify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String echoStr = request.getParameter("echostr");
		if(StringUtils.isNotBlank(echoStr)){
			super.Print(response, echoStr);
			return;
		}
		String recvInfo = CommonUtil.inputStreamToString(request.getInputStream());
		try {
			Map<String, String> responseMap = XmlUtil.getMapFromXML(recvInfo);
			Log.info("------------"+responseMap.toString());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("wechat card exception"+e.toString());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("wechat card exception"+e.toString());
		}
		
	}
}
