package com.yunpay.serv;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yunpay.common.utils.CommonUtil;
import com.yunpay.wx.rep.pay.WechatBarRep;
import com.yunpay.wx.rep.pay.WechatRefundQueryRep;
import com.yunpay.wx.rep.pay.WechatRefundRep;
import com.yunpay.wx.rep.pay.WechatScanRep;
import com.yunpay.wx.req.pay.WechatBarReq;
import com.yunpay.wx.req.pay.WechatRefundQueryReq;
import com.yunpay.wx.req.pay.WechatRefundReq;
import com.yunpay.wx.req.pay.WechatScanReq;
import com.yunpay.wx.service.WechatQrPayService;

public class Test {
	
	private static final String APPID = "wx6bef25aa3a28fb20";
	private static final String MERCHID="1297474301";
	private static final String SUBMERCHID="1298031301";
	
	public static WechatQrPayService payService;
	
	@SuppressWarnings("resource")
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-context-service.xml");
	    payService = (WechatQrPayService) context.getBean("wechatQrPayService");
	    //String outTradeNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	    //Test.testBarOrder(outTradeNo);
	    //付款订单号=20170707163632
	    //第一次退款单号=20170707164951
	    //第二次退款单号=20170707165544
	    //第三次退款单号=20170707165841
	    //第四次退款单号=20170707170551
	    //Test.testRefundOrder("20170707163632");
	    Test.testRefundOrderQuery("651939228406755328");
	}
	
	
	/**
	 * 条码支付测试
	 * @Description: 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日下午3:10:37 
	 * @param outTradeNo
	 * @param authCode
	 */
	public static void testBarOrder(String outTradeNo){
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);// 创建输入流扫描器
			String authCode =scanner.nextLine(); 
			String ip = InetAddress.getLocalHost().getHostAddress();
			WechatBarReq barReq = new WechatBarReq(APPID,MERCHID,SUBMERCHID,outTradeNo,
					authCode,1,"bar pay","termid",ip,"test","test bar pay");
			String sign = CommonUtil.getSign(CommonUtil.toMap(barReq),"12345678qwertyuiasdfghjkzxcvbnm0");
			barReq.setSign(sign);
			WechatBarRep rep = payService.doWechatBarPay(barReq);
			System.out.println(rep.getResult_code());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testScanOrder(String outTradeNo){
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			
			WechatScanReq scanReq = new WechatScanReq(APPID,MERCHID,SUBMERCHID,outTradeNo,5,"bar pay",
					"termid",ip,"test","test bar pay","http://www.siecom.cn/pay/wechat/scanpay/notify");
			String sign = CommonUtil.getSign(CommonUtil.toMap(scanReq),"12345678qwertyuiasdfghjkzxcvbnm0");
			scanReq.setSign(sign);
			WechatScanRep rep = payService.doWechatScanPay(scanReq);
			System.out.println(rep.getResult_code());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testQueryOrder(String outTradeNo){
		
	}
	
	public static void testCloseOrder(String outTradeNo){
		
	}
	
	public static void testRefundOrder(String outTradeNo){
		String outRefundNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		System.out.println("-------------退款单号="+outRefundNo);
		WechatRefundReq req = new WechatRefundReq(APPID,MERCHID,SUBMERCHID,"",
				outTradeNo, outRefundNo, 10,1,"测试退款");
		String sign = CommonUtil.getSign(CommonUtil.toMap(req),"12345678qwertyuiasdfghjkzxcvbnm0");
		req.setSign(sign);
		WechatRefundRep rep = payService.doWechatRefund(req, 
				"E:/usr/local/yunpos/cert/1297474301/apiclient_cert.p12", "1297474301");
		System.out.println(rep.getReturn_code());
	}
	
	/**
	 * 根据支付订单查询退款信息
	 * @Description: 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日下午5:10:54 
	 * @param outTradeNo
	 */
	public static void testRefundOrderQuery(String outTradeNo){
		String nonceStr = CommonUtil.getRandomStringByLength(32);
		WechatRefundQueryReq req = new WechatRefundQueryReq(APPID,MERCHID,SUBMERCHID,"",
				outTradeNo,"","",nonceStr);
		String sign = CommonUtil.getSign(CommonUtil.toMap(req),"12345678qwertyuiasdfghjkzxcvbnm0");
		req.setSign(sign);
		WechatRefundQueryRep rep = payService.doWechatRefundQuery(req);
		System.out.println(rep.getReturn_code());
	}
	
	public static void testRefundOrderQuery2(String outRefundNo){
		WechatRefundQueryReq req = new WechatRefundQueryReq(APPID,MERCHID,SUBMERCHID,"",
				outRefundNo);
		String sign = CommonUtil.getSign(CommonUtil.toMap(req),"12345678qwertyuiasdfghjkzxcvbnm0");
		req.setSign(sign);
		WechatRefundQueryRep rep = payService.doWechatRefundQuery(req);
		System.out.println(rep.getReturn_code());
	}
	
}
