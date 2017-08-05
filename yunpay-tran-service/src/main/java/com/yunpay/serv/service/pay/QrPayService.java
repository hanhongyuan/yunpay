package com.yunpay.serv.service.pay;

import org.springframework.stereotype.Service;

import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.req.QrPayReqDto;
import com.yunpay.serv.req.QrRefundReqDto;
import com.yunpay.serv.req.WapPayReqDto;

/**
 * 二维码支付(条码和扫码)服务接口类
 * 文件名称:     QrPayService.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月23日下午2:42:19 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月23日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service
public abstract class QrPayService {
	
	/**
	 * @Description: 条码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:42:46 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	public abstract Message doBarPay(QrPayReqDto qrPayReq,Merchant merchant);
	
	/**
	 * @Description:扫码支付 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:42:58 
	 * @param qrPayReq
	 * @param merchant
	 * @return
	 */
	public abstract Message doScanPay(QrPayReqDto qrPayReq,Merchant merchant);
	
	/**
	 * @Description:wap支付 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日上午11:30:55 
	 * @param wapPayReq
	 * @param merchant
	 * @return
	 */
	public abstract Message doWapPay(WapPayReqDto wapPayReq,Merchant merchant);
	
	/**
	 * @Description: 订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:43:08 
	 * @param payTranLs
	 * @return
	 */
	public abstract Message doOrderQuery(PayTranLs payTranLs);
	
	
	/**
	 * @Description: 订单关闭
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月12日下午5:55:46 
	 * @param payTranLs
	 * @return
	 */
	public abstract Message doOrderClose(PayTranLs payTranLs);
	
	/**
	 * @Description: 订单撤销
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月23日下午2:43:22 
	 * @param payTranLs
	 * @return
	 */
	public abstract Message doOrderReverse(PayTranLs payTranLs);
	
	
	/**
	 * @Description: 订单退款申请
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月10日下午3:22:52 
	 * @param qrRefundReq
	 * @return
	 */
	public abstract Message doOrderRefund(QrRefundReqDto qrRefundReq,PayTranLs payTranLs);
	
	
	/**
	 * @Description:退款查询 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月11日上午11:23:47 
	 * @param refundTranLs
	 * @return
	 */
	public abstract Message doRefundQuery(RefundTranLs refundTranLs);
	
}
