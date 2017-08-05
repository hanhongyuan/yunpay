package com.yunpay.union.service.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.Log;
import com.yunpay.union.config.SDKConfig;
import com.yunpay.union.rep.UnionBarRep;
import com.yunpay.union.rep.UnionQueryRep;
import com.yunpay.union.rep.UnionScanRep;
import com.yunpay.union.req.UnionBarReq;
import com.yunpay.union.req.UnionQueryReq;
import com.yunpay.union.req.UnionScanReq;
import com.yunpay.union.service.UnionQrPayService;
import com.yunpay.union.utils.UnionUtil;

/**
 * 银联二维码支付处理核心业务类
 * 文件名称:     UnionQrPayServiceImpl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月6日上午10:53:47 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月6日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Service("unionQrPayService")
public class UnionQrPayServiceImpl implements UnionQrPayService{

	/**
	 * @Description:银联条码支付
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午10:53:24 
	 * @param req
	 * @return
	 */
	@Override
	public UnionBarRep doUnionBarPay(UnionBarReq req) {
		// TODO Auto-generated method stub
		Map<String,String> contentData = CommonUtil.toMap(req);
		Map<String, String> reqData = UnionUtil.sign(contentData,"UTF-8");
		String requestAppUrl = SDKConfig.getConfig().getBackRequestUrl();
		Map<String, String> rspData = UnionUtil.post(reqData,requestAppUrl,"UTF-8");
		Log.debug("银联条码支付请求报文："+reqData.toString());
		Log.debug("银联条码支付返回报文："+rspData.toString());
		UnionBarRep unionBarRep=null;
		if(!rspData.isEmpty()){
			if(UnionUtil.validate(rspData, "UTF-8")){
				Log.debug("验证签名成功");
				try {
					unionBarRep =(UnionBarRep)CommonUtil.convertMap(UnionBarRep.class,rspData);
				} catch (IllegalAccessException | InstantiationException
						| InvocationTargetException | IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					unionBarRep = new UnionBarRep("01","银联结果转换失败");
				}
			}else{
				Log.error("验证签名失败");
				unionBarRep = new UnionBarRep("01","验证签名失败");
			}
		}else{
			//未返回正确的http状态
			Log.error("未获取到返回报文或返回http状态码非200");
			unionBarRep = new UnionBarRep("01","未获取到银联返回报文");
		}
		return unionBarRep;
	}

	/**
	 * @Description:银联扫码支付下单
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日上午10:50:17 
	 * @param req
	 * @return
	 */
	@Override
	public UnionScanRep doUnionScanPay(UnionScanReq req) {
		// TODO Auto-generated method stub
		Map<String,String> contentData = CommonUtil.toMap(req);
		Map<String, String> reqData = UnionUtil.sign(contentData,"UTF-8");
		String requestAppUrl = SDKConfig.getConfig().getBackRequestUrl();
		Map<String, String> rspData = UnionUtil.post(reqData,requestAppUrl,"UTF-8");
		Log.debug("银联扫码下单请求报文："+reqData.toString());
		Log.debug("银联扫码下单返回报文："+rspData.toString());
		UnionScanRep unionScanRep=null;
		if(!rspData.isEmpty()){
			if(UnionUtil.validate(rspData, "UTF-8")){
				Log.debug("验证签名成功");
				try {
					unionScanRep =(UnionScanRep)CommonUtil.convertMap(UnionScanRep.class,rspData);
				} catch (IllegalAccessException | InstantiationException
						| InvocationTargetException | IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					unionScanRep = new UnionScanRep("01","银联结果转换失败");
				}
			}else{
				Log.error("验证签名失败");
				unionScanRep = new UnionScanRep("01","验证签名失败");
			}
		}else{
			//未返回正确的http状态
			Log.error("未获取到返回报文或返回http状态码非200");
			unionScanRep = new UnionScanRep("01","未获取到银联返回报文");
		}
		return unionScanRep;
	}

	/**
	 * @Description:银联订单查询
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月6日下午3:08:49 
	 * @param req
	 * @return
	 */
	@Override
	public UnionQueryRep doUnionQuery(UnionQueryReq req) {
		// TODO Auto-generated method stub
		Map<String,String> contentData = CommonUtil.toMap(req);
		Map<String, String> reqData = UnionUtil.sign(contentData,"UTF-8");
		String requestAppUrl = SDKConfig.getConfig().getSingleQueryUrl();
		Map<String, String> rspData = UnionUtil.post(reqData,requestAppUrl,"UTF-8");
		Log.debug("银联订单查询请求报文："+reqData.toString());
		Log.debug("银联订单查询返回报文："+rspData.toString());
		UnionQueryRep rep=null;
		if(!rspData.isEmpty()){
			if(UnionUtil.validate(rspData, "UTF-8")){
				Log.debug("验证签名成功");
				try {
					rep =(UnionQueryRep)CommonUtil.convertMap(UnionQueryRep.class,rspData);
				} catch (IllegalAccessException | InstantiationException
						| InvocationTargetException | IntrospectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					rep = new UnionQueryRep("01","银联结果转换失败");
				}
			}else{
				Log.error("验证签名失败");
				rep = new UnionQueryRep("01","验证签名失败");
			}
		}else{
			//未返回正确的http状态
			Log.error("未获取到返回报文或返回http状态码非200");
			rep = new UnionQueryRep("01","未获取到银联返回报文");
		}
		return rep;
	}
	

}
