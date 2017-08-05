package com.yunpay.wx.service;
import com.yunpay.wx.rep.pay.WechatBarRep;
import com.yunpay.wx.rep.pay.WechatCloseRep;
import com.yunpay.wx.rep.pay.WechatNotifyRep;
import com.yunpay.wx.rep.pay.WechatQueryRep;
import com.yunpay.wx.rep.pay.WechatRefundQueryRep;
import com.yunpay.wx.rep.pay.WechatRefundRep;
import com.yunpay.wx.rep.pay.WechatReverseRep;
import com.yunpay.wx.rep.pay.WechatScanRep;
import com.yunpay.wx.rep.pay.WechatWapRep;
import com.yunpay.wx.req.pay.WechatBarReq;
import com.yunpay.wx.req.pay.WechatCloseReq;
import com.yunpay.wx.req.pay.WechatQueryReq;
import com.yunpay.wx.req.pay.WechatRefundQueryReq;
import com.yunpay.wx.req.pay.WechatRefundReq;
import com.yunpay.wx.req.pay.WechatReverseReq;
import com.yunpay.wx.req.pay.WechatScanReq;
import com.yunpay.wx.req.pay.WechatWapReq;
/**
 * 微信二维码支付核心接口类
 * 文件名称:     WechatQrPayService.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月19日下午4:03:10 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月19日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public interface WechatQrPayService {
	/**
	 * @Description: 微信条码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:22:26 
	 * @param wechatBarReq
	 * @param certPath
	 * @param certPwd
	 * @return
	 */
	public WechatBarRep doWechatBarPay(WechatBarReq wechatBarReq);
	
	
	/**
	 * @Description: 微信扫码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:22:40 
	 * @param wechatScanReq
	 * @param certPath
	 * @param certPwd
	 * @return
	 */
	public WechatScanRep doWechatScanPay(WechatScanReq wechatScanReq);
	
	/**
	 * @Description:微信wap支付 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日上午9:52:55 
	 * @param whecatWapReq
	 * @param certPath
	 * @param certPwd
	 * @return
	 */
	public WechatWapRep doWechatWapPay(WechatWapReq whecatWapReq);
	
	
	/**
	 * @Description: 微信订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:22:02 
	 * @param wechatQueryReq
	 * @param certPath
	 * @param certPwd
	 * @return
	 */
	public WechatQueryRep doWechatQuery(WechatQueryReq wechatQueryReq);
	
	
	/**
	 * @Description: 微信订单撤销
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:35:30 
	 * @param wechatReverseReq
	 * @param certPath
	 * @param certPwd
	 * @return
	 */
	public WechatReverseRep doWechatReverse(WechatReverseReq wechatReverseReq,String certPath,String certPwd);
	
	
	/**
	 * @Description:微信订单关闭 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日下午1:53:08 
	 * @param wechatCloseReq
	 * @return
	 */
	public WechatCloseRep doWechatClose(WechatCloseReq wechatCloseReq);
	
	
	/**
	 * @Description: 微信退款申请
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日下午2:17:46 
	 * @param wechatRefundReq
	 * @return
	 */
	public WechatRefundRep doWechatRefund(WechatRefundReq wechatRefundReq,String certPath,String certPwd);
	
	
	/**
	 * @Description: 微信退款查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日下午2:38:31 
	 * @param wechatRefundQeuryReq
	 * @return
	 */
	public WechatRefundQueryRep doWechatRefundQuery(WechatRefundQueryReq wechatRefundQeuryReq);
	
	
	/**
	 * @Description: 微信异步通知结果解析
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日下午5:15:48 
	 * @param recvInfo
	 * @return
	 */
	public WechatNotifyRep analysisWechatNotify(String recvInfo);
}
