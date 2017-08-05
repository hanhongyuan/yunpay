package com.yunpay.permission.entity;

public class TermAppEntity {
    private String termId;
    private String merchId;
    private String operId;
    private String lmkTmk;
    private String zmkTmk;
    private String bestPayZmkTmk;
    private String tmkCheckValue;
    private String lmkTpk;
    private String lmkTak;
    private String tmkTpk;
    private String tmkTak;
    private String batchNo;
    private String updateTime;
    private String appCode;//应用编号
    private String issuerMerchId;
    
    
    public String getIssuerMerchId() {
        return issuerMerchId;
    }
    public void setIssuerMerchId(String issuerMerchId) {
        this.issuerMerchId = issuerMerchId;
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
    public String getOperId() {
        return operId;
    }
    public void setOperId(String operId) {
        this.operId = operId;
    }
    public String getLmkTmk() {
        return lmkTmk;
    }
    public void setLmkTmk(String lmkTmk) {
        this.lmkTmk = lmkTmk;
    }
    public String getZmkTmk() {
        return zmkTmk;
    }
    public void setZmkTmk(String zmkTmk) {
        this.zmkTmk = zmkTmk;
    }
    public String getBestPayZmkTmk() {
        return bestPayZmkTmk;
    }
    public void setBestPayZmkTmk(String bestPayZmkTmk) {
        this.bestPayZmkTmk = bestPayZmkTmk;
    }
    public String getTmkCheckValue() {
        return tmkCheckValue;
    }
    public void setTmkCheckValue(String tmkCheckValue) {
        this.tmkCheckValue = tmkCheckValue;
    }
    public String getLmkTpk() {
        return lmkTpk;
    }
    public void setLmkTpk(String lmkTpk) {
        this.lmkTpk = lmkTpk;
    }
    public String getLmkTak() {
        return lmkTak;
    }
    public void setLmkTak(String lmkTak) {
        this.lmkTak = lmkTak;
    }
    public String getTmkTpk() {
        return tmkTpk;
    }
    public void setTmkTpk(String tmkTpk) {
        this.tmkTpk = tmkTpk;
    }
    public String getTmkTak() {
        return tmkTak;
    }
    public void setTmkTak(String tmkTak) {
        this.tmkTak = tmkTak;
    }
    public String getBatchNo() {
        return batchNo;
    }
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public String getAppCode() {
        return appCode;
    }
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
    @Override
    public String toString() {
        return "TermAppEntity [termId=" + termId + ", merchId=" + merchId
                + ", operId=" + operId + ", lmkTmk=" + lmkTmk + ", zmkTmk="
                + zmkTmk + ", bestPayZmkTmk=" + bestPayZmkTmk
                + ", tmkCheckValue=" + tmkCheckValue + ", lmkTpk=" + lmkTpk
                + ", lmkTak=" + lmkTak + ", tmkTpk=" + tmkTpk + ", tmkTak="
                + tmkTak + ", batchNo=" + batchNo + ", updateTime="
                + updateTime + ", appCode=" + appCode + "]";
    }
    
    
}
