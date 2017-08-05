package com.yunpay.serv.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.yunpay.common.utils.Log;
import com.yunpay.serv.model.RefundTranLs;
import com.yunpay.serv.route.PayFactory;
import com.yunpay.serv.service.busi.RefundTranLsService;
import com.yunpay.serv.service.pay.QrPayService;

/**
 * 定时查询退款订单任务
 * 文件名称:     RefundOrderTask.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月12日下午3:34:48 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月12日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
//@Component
public class RefundOrderTask {
	
	@Autowired
	private RefundTranLsService refundTranLsService;
	@Autowired
	private PayFactory payFactory;
	
	/**
	 * 启动时执行一次，后每隔1分钟执行一次
	 * @Description: 退款订单结果查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月12日下午3:36:44
	 */
	@Scheduled(fixedRate = 1000*60)   
    public void refundOrderQuery(){
		//查询60分钟内状态为支付中的订单
		List<RefundTranLs> RefundTranLsList = refundTranLsService.selectAllSynRefundLs(60);
		for(RefundTranLs refundTranLs : RefundTranLsList ){
			Log.debug("----------正在查询退款申请订单transNum="+refundTranLs.getTransNum()+"------------");
			QrPayService payService = payFactory.getServiceByChannel(refundTranLs.getChannel());
			payService.doRefundQuery(refundTranLs);
		}
    }
}
