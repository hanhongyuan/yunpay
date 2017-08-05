package com.yunpay.permission.entity;

import com.yunpay.common.core.utils.DateUtils;

public class TermStatusEntity extends PermissionBaseEntity{
    private static final long serialVersionUID = -1282059233199379851L;
    private String termSeq;//终端序列号
    private String region;//城市编号
    private String area;//区
    private String termId;//终端编码
    private String merchId;//商户编码
    private String merchName;//商户名称
    private String storeNo;//门店编码
    private String storeName;//门店名称
    private String contractName;//联系人
    private String contractPhone;//联系电话
    private String firstTranDate;//首次交易日期
    private String endUseDate;//最后使用日期
    private String unusedDays;//未使用天数
    
    //查询专用
    private String minEndUseDate;   //最小最后使用时间
    private String maxEndUseDate;   //最大最后使用时间
    
    
    public String getMinEndUseDate() {
        return minEndUseDate;
    }
    public void setMinEndUseDate(String minEndUseDate) {
        this.minEndUseDate = minEndUseDate;
    }
    public String getMaxEndUseDate() {
        return maxEndUseDate;
    }
    public void setMaxEndUseDate(String maxEndUseDate) {
        this.maxEndUseDate = maxEndUseDate;
    }
    public String getTermSeq() {
        return termSeq;
    }
    public void setTermSeq(String termSeq) {
        this.termSeq = termSeq;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getTermId() {
        return termId;
    }
    public void setTermId(String termId) {
        this.termId = termId;
    }
    public String getMerchId() {
        return merchId;
    }
    public void setMerchId(String merchId) {
        this.merchId = merchId;
    }
    public String getMerchName() {
        return merchName;
    }
    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }
    public String getStoreNo() {
        return storeNo;
    }
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getContractName() {
        return contractName;
    }
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }
    public String getContractPhone() {
        return contractPhone;
    }
    public void setContractPhone(String contractPhone) {
        this.contractPhone = contractPhone;
    }
    public String getFirstTranDate() {
        return firstTranDate;
    }
    public void setFirstTranDate(String firstTranDate) {
        this.firstTranDate = DateUtils.formatToformat(firstTranDate, "yyyyMMdd", "yyyy-MM-dd");
    }
    public String getEndUseDate() {
        return endUseDate;
    }
    public void setEndUseDate(String endUseDate) {
        this.endUseDate = DateUtils.formatToformat(endUseDate, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
    }
    public String getUnusedDays() {
        return unusedDays;
    }
    public void setUnusedDays(String unusedDays) {
        this.unusedDays = unusedDays;
    }
}
