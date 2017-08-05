package com.yunpay.permission.entity;

public class TermMonitorEntity {
    private int stmId;
    private String merchId;
    private String storeNo;
    private String termId;
    private String termSeq;
    private String msgType;
    private String msgContext;
    private String sendTime;
    private String msgRemark;
    
    public int getStmId() {
        return stmId;
    }
    public void setStmId(int stmId) {
        this.stmId = stmId;
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
    public String getTermId() {
        return termId;
    }
    public void setTermId(String termId) {
        this.termId = termId;
    }
    public String getTermSeq() {
        return termSeq;
    }
    public void setTermSeq(String termSeq) {
        this.termSeq = termSeq;
    }
    public String getMsgType() {
        return msgType;
    }
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    public String getMsgContext() {
        return msgContext;
    }
    public void setMsgContext(String msgContext) {
        this.msgContext = msgContext;
    }
    public String getSendTime() {
        return sendTime;
    }
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
    public String getMsgRemark() {
        return msgRemark;
    }
    public void setMsgRemark(String msgRemark) {
        this.msgRemark = msgRemark;
    }
}