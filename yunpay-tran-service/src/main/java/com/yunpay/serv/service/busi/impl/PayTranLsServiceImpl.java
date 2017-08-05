package com.yunpay.serv.service.busi.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.utils.EnumUtil.PayChannel;
import com.yunpay.common.utils.EnumUtil.PayStatus;
import com.yunpay.common.utils.EnumUtil.SubChannel;
import com.yunpay.common.utils.EnumUtil.TransType;
import com.yunpay.common.utils.IdWorker;
import com.yunpay.serv.dao.PayTranLsDao;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.serv.req.QrPayReqDto;
import com.yunpay.serv.req.WapPayReqDto;
import com.yunpay.serv.service.busi.PayTranLsService;

/**
 * 交易流水业务类
 * 文件名称:     PayTranLsServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月22日下午1:37:27 
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
public class PayTranLsServiceImpl implements PayTranLsService{
	
	@Autowired
	private PayTranLsDao payTranLsDao;

	/**
	 * 创建二维码支付流水
	 * @Description:
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月21日下午6:07:01 
	 * @param qrPayReq
	 * @param merchant
	 * @param subChannel
	 * @return
	 */
	@Override
	public PayTranLs createQrTranLs(QrPayReqDto qrPayReq, Merchant merchant,
			SubChannel subChannel) {
		// TODO Auto-generated method stub
		IdWorker iw = new IdWorker();
		PayTranLs payTranLs = new PayTranLs();
		String orderNo = iw.getId() + "";
		if(subChannel==SubChannel.WACHAT_BAR){
			//微信条码
			payTranLs.setChannel(PayChannel.WECHAT.getValue());
			payTranLs.setSubChannel(SubChannel.WACHAT_BAR.getValue());
			payTranLs.setTitle(SubChannel.WACHAT_BAR.getName());
			payTranLs.setInfo(SubChannel.WACHAT_BAR.getName());
			payTranLs.setStatus(PayStatus.PAYING.getValue());
		}else if(subChannel==SubChannel.WACHAT_SCAN){
			//微信扫码
			payTranLs.setChannel(PayChannel.WECHAT.getValue());
			payTranLs.setSubChannel(SubChannel.WACHAT_SCAN.getValue());
			payTranLs.setTitle(SubChannel.WACHAT_SCAN.getName());
			payTranLs.setInfo(SubChannel.WACHAT_SCAN.getName());
			payTranLs.setStatus(PayStatus.UNPAY.getValue());
		}else if(subChannel==SubChannel.ALIPAY_BAR){
			//支付宝条码
			payTranLs.setChannel(PayChannel.ALIPAY.getValue());
			payTranLs.setSubChannel(SubChannel.ALIPAY_BAR.getValue());
			payTranLs.setTitle(SubChannel.ALIPAY_BAR.getName());
			payTranLs.setInfo(SubChannel.ALIPAY_BAR.getName());
			payTranLs.setStatus(PayStatus.PAYING.getValue());
		}else if(subChannel==SubChannel.ALIPAY_SCAN){
			//支付宝扫码
			payTranLs.setChannel(PayChannel.ALIPAY.getValue());
			payTranLs.setSubChannel(SubChannel.ALIPAY_SCAN.getValue());
			payTranLs.setTitle(SubChannel.ALIPAY_SCAN.getName());
			payTranLs.setInfo(SubChannel.ALIPAY_SCAN.getName());
			payTranLs.setStatus(PayStatus.UNPAY.getValue()); 
		}else if(subChannel==SubChannel.UNION_BAR){
			//银联条码
			payTranLs.setChannel(PayChannel.UNION.getValue());
			payTranLs.setSubChannel(SubChannel.UNION_BAR.getValue());
			payTranLs.setTitle(SubChannel.UNION_BAR.getName());
			payTranLs.setInfo(SubChannel.UNION_BAR.getName());
			payTranLs.setStatus(PayStatus.PAYING.getValue());
		}else if(subChannel==SubChannel.UNION_SCAN){
			//银联扫码
			payTranLs.setChannel(PayChannel.UNION.getValue());
			payTranLs.setSubChannel(SubChannel.UNION_SCAN.getValue());
			payTranLs.setTitle(SubChannel.UNION_SCAN.getName());
			payTranLs.setInfo(SubChannel.UNION_SCAN.getName());
			payTranLs.setStatus(PayStatus.UNPAY.getValue());
		}
		//调用方异步通知地址
		payTranLs.setAsynNotify(qrPayReq.getNotify_url());
		payTranLs.setMerchantName(merchant.getRegisterName());
		payTranLs.setSerialNo(merchant.getMerchantNo());
		payTranLs.setAgentSerialNo(merchant.getAgentSerialNo());
		payTranLs.setTerminalNum(qrPayReq.getTerminal_unique_no());
		payTranLs.setTransNum(orderNo);
		payTranLs.setTransTime(new Date());
		payTranLs.setTotalPrice(Float.valueOf(qrPayReq.getTotal_fee()));//订单金额
		payTranLs.setTransPrice(Float.valueOf(qrPayReq.getTotal_fee()));//实际支付金额
		payTranLs.setTransType(TransType.PAY.getValue()); // 交易类型，0:支付，1:退款
		payTranLs.setUser_order_no(qrPayReq.getUser_order_no());
		payTranLs.setSubject(qrPayReq.getBody());
		payTranLs.setMerchantNo(merchant.getMerchantNo());
		payTranLs.setOrgNo(merchant.getOrgNo());
		payTranLs.setAttach(qrPayReq.getAttach());
		payTranLsDao.insert(payTranLs);
		return payTranLs;
	}
	
	/**
	 * @Description:创建wap支付流水
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月20日下午4:09:22 
	 * @param wapPayReq
	 * @param merchant
	 * @param payChannel
	 * @return
	 */
	public PayTranLs createWapTranLs(WapPayReqDto wapPayReq,Merchant merchant,PayChannel payChannel){
		// TODO Auto-generated method stub
		IdWorker iw = new IdWorker();
		PayTranLs payTranLs = new PayTranLs();
		String orderNo = iw.getId() + "";
		if(payChannel==PayChannel.WECHAT){
			//微信wap支付
			payTranLs.setChannel(PayChannel.WECHAT.getValue());
			payTranLs.setSubChannel(SubChannel.WACHT_WAP.getValue());
			payTranLs.setTitle(SubChannel.WACHT_WAP.getName());
			payTranLs.setInfo(SubChannel.WACHT_WAP.getName());
			payTranLs.setStatus(PayStatus.UNPAY.getValue());
		}else if(payChannel==PayChannel.ALIPAY){
			//支付宝wap
			payTranLs.setChannel(PayChannel.ALIPAY.getValue());
			payTranLs.setSubChannel(SubChannel.ALIPAY_WAP.getValue());
			payTranLs.setTitle(SubChannel.ALIPAY_WAP.getName());
			payTranLs.setInfo(SubChannel.ALIPAY_WAP.getName());
			payTranLs.setStatus(PayStatus.UNPAY.getValue());
			//调用方页面跳转地址
			payTranLs.setSyncNotify(wapPayReq.getReturn_url());
		}else{
			//银联wap
			payTranLs.setChannel(PayChannel.UNION.getValue());
			payTranLs.setSubChannel(SubChannel.UNION_WAP.getValue());
			payTranLs.setTitle(SubChannel.UNION_WAP.getName());
			payTranLs.setInfo(SubChannel.UNION_WAP.getName());
			payTranLs.setStatus(PayStatus.UNPAY.getValue());
		}
		//调用方异步通知地址
		payTranLs.setAsynNotify(wapPayReq.getNotify_url());
		payTranLs.setMerchantName(merchant.getRegisterName());
		payTranLs.setSerialNo(merchant.getMerchantNo());
		payTranLs.setAgentSerialNo(merchant.getAgentSerialNo());
		payTranLs.setTransNum(orderNo);
		payTranLs.setTransTime(new Date());
		payTranLs.setTotalPrice(Float.valueOf(wapPayReq.getTotal_fee()));//订单金额
		payTranLs.setTransPrice(Float.valueOf(wapPayReq.getTotal_fee()));//实际支付金额
		payTranLs.setTransType(TransType.PAY.getValue()); // 交易类型，0:支付，1:退款
		payTranLs.setUser_order_no(wapPayReq.getUser_order_no());
		payTranLs.setSubject(wapPayReq.getBody());
		payTranLs.setMerchantNo(merchant.getMerchantNo());
		payTranLs.setOrgNo(merchant.getOrgNo());
		payTranLs.setAttach(wapPayReq.getAttach());
		payTranLsDao.insert(payTranLs);
		return payTranLs;
	}

	/**
	 * @Description:修改交易流水
	 * @author:   	Zeng Dongcheng
	 * @Date:       2017年6月22日下午1:37:49 
	 * @param payTranLs
	 * @return
	 */
	@Override
	public PayTranLs updatePayTranLs(PayTranLs payTranLs) {
		// TODO Auto-generated method stub
		payTranLsDao.updateByPrimaryKeySelective(payTranLs);
		return payTranLs;
	}


	/**
	 * @Description:根据商户订单号和商户号查询订单信息
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月20日下午4:13:06 
	 * @param userOrderNo
	 * @param merchantNo
	 * @return
	 */
	@Override
	public PayTranLs findTranLsByOrderNo(String userOrderNo, String merchantNo) {
		// TODO Auto-generated method stub
		return payTranLsDao.findTranLsByOrderNo(userOrderNo, merchantNo);
	}
	
	/**
	 * @Description:根据平台支付流水号查询订单信息
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月20日下午4:13:41 
	 * @param transNum
	 * @return
	 */
	@Override
	public PayTranLs findTranLsByTransNum(String transNum) {
		// TODO Auto-generated method stub
		return payTranLsDao.findTranLsByTransNum(transNum);
	}

	/**
	 * @Description:修改交易状态
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月20日下午4:14:00 
	 * @param id
	 * @param status
	 * @return
	 */
	@Override
	public int updTranStatus(int id, int status) {
		// TODO Auto-generated method stub
		return payTranLsDao.updTranStatus(id, status);
	}

	/**
	 * @Description: 查询时间区间内的待同步的订单
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月20日下午4:14:13 
	 * @param intervalTime
	 * @return
	 */
	@Override
	public List<PayTranLs> selectAllSynPayLs(Integer intervalTime) {
		// TODO Auto-generated method stub
		return payTranLsDao.selectAllSynPayLs(intervalTime);
	}


}
