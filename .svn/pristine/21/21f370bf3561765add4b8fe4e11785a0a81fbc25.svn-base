package com.yunpay.permission.service;

import java.util.List;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.IssuerEntity;
import com.yunpay.permission.entity.IssuerSZTEntity;
import com.yunpay.permission.entity.SetBillFlow;
import com.yunpay.permission.entity.TotalCount;

public interface SysIssuerService {
    
    //发卡方明细表 
    @SuppressWarnings("rawtypes")
    PageBean listPage(PageParam pageParam, IssuerEntity issuer,String status);
    
    //深圳通消费
    /**
     * String type 用来 区别是查询深圳通消费还是查询深圳通充值
     * */
    @SuppressWarnings("rawtypes")
    PageBean listIssuerSZT(PageParam pageParam, IssuerSZTEntity issuerSZT,String status,String type);
    
    //统计深圳通数据
    TotalCount IssuerSZTCount(PageParam pageParam, IssuerSZTEntity issuerSZT,String status,String type);
    
    //深圳通查看
    IssuerSZTEntity ViewIssuerBill(String BillId);
    List<IssuerSZTEntity> ViewIssuerBillList(String BillId);
    
    //深圳通导出
    @SuppressWarnings("rawtypes")
    PageBean IssuerBillExcel(PageParam pageParam, String type);
    
    //查看
    IssuerSZTEntity ViewIssuer(String BillId,String table);
    List<IssuerSZTEntity> ViewIssuerList(String BillId,String table);
    TotalCount CountIssuerBillList(String BillId,String table);
    //统计
    TotalCount IssuerCount(PageParam pageParam, IssuerSZTEntity issuerSZT,String status,String table);
    
    //消费
    @SuppressWarnings("rawtypes")
    PageBean listIssuer(PageParam pageParam, IssuerSZTEntity issuerSZT,String status,String table);
    
    //查询交易类型下拉
    public List<ComboxValue> findtranTypeList(String TypeCode);
    
    //出单
    public boolean outIssuerBill(SetBillFlow billFlow,String table);
    
    //核销
    public boolean checkIssuerBill(SetBillFlow billFlow,String setFactAmt,String table);
    
}
