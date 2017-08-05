package com.yunpay.serv.model;


public class WechatConfig {
    private Integer id;

    private String appId;

    private String mchId;		//签约在服务商下模式商户号
    
    private String subMchId;	//签约普通模式商户号
    
    private Byte mchType;

    private String parentMchNo;

    private String certLocalPath;
   
    private String certPassword;
    
    private String merchantScanNotify;

    private String info;
    
    private String mark;

    private Byte status;

    private String merchantNo;
    
    private String storeAppId;
    
    //服务商
    public static Byte mchType_service = 0;
	//商户
    public static Byte mchType_mch = 1;
    
    public String orgNo;
    
    private String wxAppAppId;

    private String wxAppMchId;		
    
    private String wxAppApiSecret;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getSubMchId() {
		return subMchId;
	}

	public void setSubMchId(String subMchId) {
		this.subMchId = subMchId;
	}

	public Byte getMchType() {
		return mchType;
	}

	public void setMchType(Byte mchType) {
		this.mchType = mchType;
	}

	public String getParentMchNo() {
		return parentMchNo;
	}

	public void setParentMchNo(String parentMchNo) {
		this.parentMchNo = parentMchNo;
	}

	public String getCertLocalPath() {
		return certLocalPath;
	}

	public void setCertLocalPath(String certLocalPath) {
		this.certLocalPath = certLocalPath;
	}

	public String getCertPassword() {
		return certPassword;
	}

	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}

	public String getMerchantScanNotify() {
		return merchantScanNotify;
	}

	public void setMerchantScanNotify(String merchantScanNotify) {
		this.merchantScanNotify = merchantScanNotify;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getStoreAppId() {
		return storeAppId;
	}

	public void setStoreAppId(String storeAppId) {
		this.storeAppId = storeAppId;
	}

	public static Byte getMchType_service() {
		return mchType_service;
	}

	public static void setMchType_service(Byte mchType_service) {
		WechatConfig.mchType_service = mchType_service;
	}

	public static Byte getMchType_mch() {
		return mchType_mch;
	}

	public static void setMchType_mch(Byte mchType_mch) {
		WechatConfig.mchType_mch = mchType_mch;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getWxAppAppId() {
		return wxAppAppId;
	}

	public void setWxAppAppId(String wxAppAppId) {
		this.wxAppAppId = wxAppAppId;
	}

	public String getWxAppMchId() {
		return wxAppMchId;
	}

	public void setWxAppMchId(String wxAppMchId) {
		this.wxAppMchId = wxAppMchId;
	}

	public String getWxAppApiSecret() {
		return wxAppApiSecret;
	}

	public void setWxAppApiSecret(String wxAppApiSecret) {
		this.wxAppApiSecret = wxAppApiSecret;
	}
}