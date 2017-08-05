package com.yunpay.serv;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yunpay.common.utils.IdWorker;
import com.yunpay.serv.dao.MerchantDao;
import com.yunpay.serv.dao.PayTranLsDao;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.model.PayTranLs;

public class TestCase1 {
	
	
	private static MerchantDao merchantDao;
	private static PayTranLsDao payTranLsDao;
	
	//junit之前init spring
	@SuppressWarnings("resource")
	@BeforeClass
	public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/spring-context-service.xml");
        merchantDao = (MerchantDao)context.getBean("merchantDao");
        payTranLsDao = (PayTranLsDao)context.getBean("payTranLsDao");
    }

	@Test
	public void testQueryMerch() {
		Merchant merchant = merchantDao.queryMerchInfo("999910041001466888");
		Assert.assertNotNull(merchant);
	}
	
	@Test
	public void testQueryTranLs(){
		PayTranLs payTranLs = payTranLsDao.findTranLsByOrderNo("6252064384095461376", "999910031001993593");
		Assert.assertNotNull(payTranLs);
	}
	
	@Test
	public void testAddTranLs(){
		IdWorker iw = new IdWorker();
		PayTranLs payTranLs = new PayTranLs();
		payTranLs.setTransNum(iw.getId()+"");
		payTranLs.setChannel(1);
		int i = payTranLsDao.insert(payTranLs);
		Assert.assertTrue(i>0);
	}
}
