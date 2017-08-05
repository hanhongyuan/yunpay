package com.yunpay.permission.entity;

public class StoreTranEntity extends PermissionBaseEntity{
    private static final long serialVersionUID = 1802263885530930973L;
    private String merchId;//商户
    private String merchName;//商户名称
    private String storeNo;//门店
    private String storeName;//门店名称
    private String provice;//省
    private String region;//市
    private String area;//区
    private String busiarea;//商圈
    private String tranNum;//交易笔数
    private Double tranAmount;//交易金额(累计)
    private Double avgAmount;//客单价
    private String startTranDate;//首次交易日期
    private String endTranDate;//最后交易日期
    private String maxTranNum;//峰值笔数
    private String numTranDate;//峰值日期
    private Double maxTranAmount;//峰值金额
    private String amountTranDate;//峰值金额日期
    private String totalTranDay;//累计交易天数
    private String totalUntranDay;//未交易天数
    private String contracter;//业务员
    
    //查询专用
    private String minavgAmount;    //最小客单价
    private String maxavgAmount;    //最大客单价
    private String mintranAmount;   //最小交易金额
    private String maxtranAmount;   //最大交易金额
    private String mintranNum;      //最小交易笔数
    private String maxtranNum;      //最大交易笔数
    private String dataType;        //商户情况
    private String dataType1;        //商户情况
    
    
    
    public String getDataType1() {
        return dataType1;
    }
    public void setDataType1(String dataType1) {
        this.dataType1 = dataType1;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getMinavgAmount() {
        return minavgAmount;
    }
    public void setMinavgAmount(String minavgAmount) {
        this.minavgAmount = minavgAmount;
    }
    public String getMaxavgAmount() {
        return maxavgAmount;
    }
    public void setMaxavgAmount(String maxavgAmount) {
        this.maxavgAmount = maxavgAmount;
    }
    public String getMintranAmount() {
        return mintranAmount;
    }
    public void setMintranAmount(String mintranAmount) {
        this.mintranAmount = mintranAmount;
    }
    public String getMaxtranAmount() {
        return maxtranAmount;
    }
    public void setMaxtranAmount(String maxtranAmount) {
        this.maxtranAmount = maxtranAmount;
    }
    public String getMintranNum() {
        return mintranNum;
    }
    public void setMintranNum(String mintranNum) {
        this.mintranNum = mintranNum;
    }
    public String getMaxtranNum() {
        return maxtranNum;
    }
    public void setMaxtranNum(String maxtranNum) {
        this.maxtranNum = maxtranNum;
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
    public String getProvice() {
        return provice;
    }
    public void setProvice(String provice) {
        this.provice = provice;
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
    public String getBusiarea() {
        return busiarea;
    }
    public void setBusiarea(String busiarea) {
        this.busiarea = busiarea;
    }
    public String getTranNum() {
        return tranNum;
    }
    public void setTranNum(String tranNum) {
        this.tranNum = tranNum;
    }
    public Double getTranAmount() {
        return tranAmount;
    }
    public void setTranAmount(Double tranAmount) {
        this.tranAmount = tranAmount;
    }
    public Double getAvgAmount() {
        return avgAmount;
    }
    public void setAvgAmount(Double avgAmount) {
        this.avgAmount = avgAmount;
    }
    public String getStartTranDate() {
        return startTranDate;
    }
    public void setStartTranDate(String startTranDate) {
        this.startTranDate = startTranDate;
    }
    public String getEndTranDate() {
        return endTranDate;
    }
    public void setEndTranDate(String endTranDate) {
        this.endTranDate = endTranDate;
    }
    public String getMaxTranNum() {
        return maxTranNum;
    }
    public void setMaxTranNum(String maxTranNum) {
        this.maxTranNum = maxTranNum;
    }
    public String getNumTranDate() {
        return numTranDate;
    }
    public void setNumTranDate(String numTranDate) {
        this.numTranDate = numTranDate;
    }
    public Double getMaxTranAmount() {
        return maxTranAmount;
    }
    public void setMaxTranAmount(Double maxTranAmount) {
        this.maxTranAmount = maxTranAmount;
    }
    public String getAmountTranDate() {
        return amountTranDate;
    }
    public void setAmountTranDate(String amountTranDate) {
        this.amountTranDate = amountTranDate;
    }
    public String getTotalTranDay() {
        return totalTranDay;
    }
    public void setTotalTranDay(String totalTranDay) {
        this.totalTranDay = totalTranDay;
    }
    public String getTotalUntranDay() {
        return totalUntranDay;
    }
    public void setTotalUntranDay(String totalUntranDay) {
        this.totalUntranDay = totalUntranDay;
    }
    public String getContracter() {
        return contracter;
    }
    public void setContracter(String contracter) {
        this.contracter = contracter;
    }
}
