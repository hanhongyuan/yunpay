package com.yunpay.permission.entity;

public class MccStoreEntity extends PermissionBaseEntity{
    private static final long serialVersionUID = 1802263885530930973L;
    //统计日期
    private String makeDate;
    //省
    private String provice;
    //市
    private String region;
    //分类1(生活服务)
    private String mccType1;
    //分类2(运动健身)
    private String mccType2;
    //分类3(旅游酒店)
    private String mccType3;
    //分类4(商超购物)
    private String mccType4;
    //分类5(娱乐休闲)
    private String mccType5;
    //分类6(生活服务)
    private String mccType6;
    //扩展分类(未定义)
    private String mccType7;
    //扩展分类(未定义)
    private String mccType8;
    //当前总数
    private String totalNum;
    
    //查询用到的
    private String Contract_begin;
    private String Contract_end;
    
    public String getContract_begin() {
        return Contract_begin;
    }
    public void setContract_begin(String contract_begin) {
        Contract_begin = contract_begin;
    }
    public String getContract_end() {
        return Contract_end;
    }
    public void setContract_end(String contract_end) {
        Contract_end = contract_end;
    }
    public String getMakeDate() {
        return makeDate;
    }
    public void setMakeDate(String makeDate) {
        this.makeDate = makeDate;
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
    public String getMccType1() {
        return mccType1;
    }
    public void setMccType1(String mccType1) {
        this.mccType1 = mccType1;
    }
    public String getMccType2() {
        return mccType2;
    }
    public void setMccType2(String mccType2) {
        this.mccType2 = mccType2;
    }
    public String getMccType3() {
        return mccType3;
    }
    public void setMccType3(String mccType3) {
        this.mccType3 = mccType3;
    }
    public String getMccType4() {
        return mccType4;
    }
    public void setMccType4(String mccType4) {
        this.mccType4 = mccType4;
    }
    public String getMccType5() {
        return mccType5;
    }
    public void setMccType5(String mccType5) {
        this.mccType5 = mccType5;
    }
    public String getMccType6() {
        return mccType6;
    }
    public void setMccType6(String mccType6) {
        this.mccType6 = mccType6;
    }
    public String getMccType7() {
        return mccType7;
    }
    public void setMccType7(String mccType7) {
        this.mccType7 = mccType7;
    }
    public String getMccType8() {
        return mccType8;
    }
    public void setMccType8(String mccType8) {
        this.mccType8 = mccType8;
    }
    public String getTotalNum() {
        return totalNum;
    }
    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }
}
