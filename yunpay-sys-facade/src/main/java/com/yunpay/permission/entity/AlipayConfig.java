package com.yunpay.permission.entity;
public class AlipayConfig extends PermissionBaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 文件名称:
	 * 内容摘要:  商户支付宝配置,映射表：t_alipay_config
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月14日上午16:02:12 
	 * 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年4月14日     duan zhang quan   1.0     新建
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	private String sellerEmail;  // 支付宝账号（签约的支付宝账号）
	private String pid;  // 支付宝商户合作伙伴ID
	private String alipaymrikey;  //支付宝安全校验码
	private String merchantPrivateKey;  // 商户秘钥（openssl生成的公钥，支付请求时用于签名）
	private String alipayPublicKey; // 支付宝公钥（用于验签使用）
	private String appPublicKey;  //商户公钥（App支付宝商户公钥）
	private String appPrivateKey;  // 商户私钥
	private String merchanSynNotify; // 支付宝wap第三方同步回调地址
	private String merchanAsynNotify; // 支付宝wap第三方异步回调地址
	private String merchantBarNotify;  // 商户条码支付异步回调地址
	private String merchantScanNotify;  // 商户扫码异步回调地址
	private String synNotify;  // 支付宝wap平台同步回调地址
	private String asynNotify;  // 支付宝wap平台异步回调地址
	private String devPublicKey;  // 开发者公钥（服务窗用）
	private String devGetway;  // 开发者网关（服务窗用）
	private String token;  // 令牌
	private String pagentId;  // 父级对应的代理id
	private String mark;  //支付方式标识
	private String info;  //描述信息
	private String orgNo;
	private String merchantNo ;// 关联的商户号
	private String appId; // 支付宝分配的服务窗ID
	private String meralipsPrivateKey; // 商户卡券秘钥（openssl生成的公钥，支付请求时用于签名）
	private String meralipsPublicKey;  // 商户卡券公钥
	private String alipassPublicKey;  //支付宝卡券公钥（用于验签使用）
	private String storeAppPublicKey;  //门店应用公钥(支付宝公钥)
	private String storeAppPrivateKey;  // 门店应用私钥
	private String storeAppId;  // 店铺应用id
	private String storeMerchantPublicKey; //商户公钥
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAlipaymrikey() {
		return alipaymrikey;
	}
	public void setAlipaymrikey(String alipaymrikey) {
		this.alipaymrikey = alipaymrikey;
	}
	public String getMerchantPrivateKey() {
		return merchantPrivateKey;
	}
	public void setMerchantPrivateKey(String merchantPrivateKey) {
		this.merchantPrivateKey = merchantPrivateKey;
	}
	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}
	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}
	public String getAppPublicKey() {
		return appPublicKey;
	}
	public void setAppPublicKey(String appPublicKey) {
		this.appPublicKey = appPublicKey;
	}
	public String getAppPrivateKey() {
		return appPrivateKey;
	}
	public void setAppPrivateKey(String appPrivateKey) {
		this.appPrivateKey = appPrivateKey;
	}
	public String getMerchanSynNotify() {
		return merchanSynNotify;
	}
	public void setMerchanSynNotify(String merchanSynNotify) {
		this.merchanSynNotify = merchanSynNotify;
	}
	public String getMerchanAsynNotify() {
		return merchanAsynNotify;
	}
	public void setMerchanAsynNotify(String merchanAsynNotify) {
		this.merchanAsynNotify = merchanAsynNotify;
	}
	public String getMerchantBarNotify() {
		return merchantBarNotify;
	}
	public void setMerchantBarNotify(String merchantBarNotify) {
		this.merchantBarNotify = merchantBarNotify;
	}
	public String getMerchantScanNotify() {
		return merchantScanNotify;
	}
	public void setMerchantScanNotify(String merchantScanNotify) {
		this.merchantScanNotify = merchantScanNotify;
	}
	public String getSynNotify() {
		return synNotify;
	}
	public void setSynNotify(String synNotify) {
		this.synNotify = synNotify;
	}
	public String getAsynNotify() {
		return asynNotify;
	}
	public void setAsynNotify(String asynNotify) {
		this.asynNotify = asynNotify;
	}
	public String getDevPublicKey() {
		return devPublicKey;
	}
	public void setDevPublicKey(String devPublicKey) {
		this.devPublicKey = devPublicKey;
	}
	public String getDevGetway() {
		return devGetway;
	}
	public void setDevGetway(String devGetway) {
		this.devGetway = devGetway;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPagentId() {
		return pagentId;
	}
	public void setPagentId(String pagentId) {
		this.pagentId = pagentId;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMeralipsPrivateKey() {
		return meralipsPrivateKey;
	}
	public void setMeralipsPrivateKey(String meralipsPrivateKey) {
		this.meralipsPrivateKey = meralipsPrivateKey;
	}
	public String getMeralipsPublicKey() {
		return meralipsPublicKey;
	}
	public void setMeralipsPublicKey(String meralipsPublicKey) {
		this.meralipsPublicKey = meralipsPublicKey;
	}
	public String getAlipassPublicKey() {
		return alipassPublicKey;
	}
	public void setAlipassPublicKey(String alipassPublicKey) {
		this.alipassPublicKey = alipassPublicKey;
	}
	public String getStoreAppPublicKey() {
		return storeAppPublicKey;
	}
	public void setStoreAppPublicKey(String storeAppPublicKey) {
		this.storeAppPublicKey = storeAppPublicKey;
	}
	public String getStoreAppPrivateKey() {
		return storeAppPrivateKey;
	}
	public void setStoreAppPrivateKey(String storeAppPrivateKey) {
		this.storeAppPrivateKey = storeAppPrivateKey;
	}
	public String getStoreAppId() {
		return storeAppId;
	}
	public void setStoreAppId(String storeAppId) {
		this.storeAppId = storeAppId;
	}
	public String getStoreMerchantPublicKey() {
		return storeMerchantPublicKey;
	}
	public void setStoreMerchantPublicKey(String storeMerchantPublicKey) {
		this.storeMerchantPublicKey = storeMerchantPublicKey;
	}
	
	
	
}
