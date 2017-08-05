package com.yunpay.permission.entity;

import com.yunpay.common.core.utils.DateUtils;

public class UnusualTranEntity extends PermissionBaseEntity{
    private static final long serialVersionUID = -2739004419656315892L;
    
    private String merchId;
    private String storeNo;
    private String shortName;
    private String storeName;
    private String termId;
    private String tranDate;
    private String tranTime;
    private String batchNo;
    private String tranSerial;
    private String cardNo;
    private Double tranAmt;
    private String confirmDate;
    private String confirmUser;
    private String confirmResult;
    
    private String contract_begin;
    private String contract_end;
    
    public String getContract_begin() {
        return contract_begin;
    }
    public void setContract_begin(String contract_begin) {
        this.contract_begin = contract_begin;
    }
    public String getContract_end() {
        return contract_end;
    }
    public void setContract_end(String contract_end) {
        this.contract_end = contract_end;
    }
    public String getMerchId() {
        return merchId;
    }
    public void setMerchId(String merchId) {
        this.merchId = merchId;
    }
    public String getStoreNo() {
        return storeNo;
    }
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }
    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getTermId() {
        return termId;
    }
    public void setTermId(String termId) {
        this.termId = termId;
    }
    public String getTranDate() {
        return tranDate;
    }
    public void setTranDate(String tranDate) {
        this.tranDate = DateUtils.formatToformat(tranDate, "yyyyMMdd", "yyyy-MM-dd");
    }
    public String getTranTime() {
        return tranTime;
    }
    public void setTranTime(String tranTime) {
        this.tranTime = DateUtils.formatToformat(tranTime, "HHmmss", "HH:mm:ss");
    }
    public String getBatchNo() {
        return batchNo;
    }
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
    public String getTranSerial() {
        return tranSerial;
    }
    public void setTranSerial(String tranSerial) {
        this.tranSerial = tranSerial;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public Double getTranAmt() {
        return tranAmt;
    }
    public void setTranAmt(Double tranAmt) {
        this.tranAmt = tranAmt;
    }
    public String getConfirmDate() {
        return confirmDate;
    }
    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }
    public String getConfirmUser() {
        return confirmUser;
    }
    public void setConfirmUser(String confirmUser) {
        this.confirmUser = confirmUser;
    }
    public String getConfirmResult() {
        return confirmResult;
    }
    public void setConfirmResult(String confirmResult) {
        this.confirmResult = confirmResult;
    }
}
