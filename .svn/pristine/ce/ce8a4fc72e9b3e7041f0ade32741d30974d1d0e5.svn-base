package com.yunpay.permission.dao;

import java.util.List;
import java.util.Map;

import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.IssuerSZTEntity;
import com.yunpay.permission.entity.MerchantInfo;
import com.yunpay.permission.entity.TermAppEntity;
import com.yunpay.permission.entity.TermEntity;

public interface SysTermDao extends PermissionBaseDao<TermEntity> {
    
    public List<TermEntity> Findall();
    
    public TermEntity selectByPrimaryKey(String termId);
    
    //检查termSeq的唯一性
    public TermEntity checkTermSeq(String termseq);
    

    //获取TermId
    public TermEntity findTermId(String prefix);
    
    //获取TermId
    public TermEntity findTermIdbySeq(String termseq);
    
    
    //检查GPRSNo的唯一性
    public int checkGPRSNo(String GPRSNo);
    
    //添加Term
    public int addTerm(TermEntity term);
    
    //修改Term
    public int editTerm(TermEntity term);
    
    /**
     * 撤机的五步
     * 1、先删除终端基本信息(sd_merch_term)
     * */
    public int deleteByPrimaryKey(String termId);
    //2、再删除终端应用信息(sd_term_app)
    public int deleteTermApp(String termseq);
    //3、再删除终端秘钥信息(sd_term_key)
    public int deleteTermKey(String termId);
    //4、再修改机器入库表中机器状态(sd_machine_info)为入库状态
    public int updateMachineInfo(Map<String, Object> paramMap);
    //5、最后往装撤机流水表(sd_merch_term_ls)添加撤机流水
    public int insertTermLs(Map<String, Object> paramMap);
	
    public int delSign(Map<String, Object> paramMap);
    //删除注册码表
    public int delCode(String termSeq);
	/**
     * 根据merchId修改终端的状态
     * @param merchId
     * @param status 状态
     * @return
     */
    public int editTermStatus(Map<String, Object> paramMap);
    
    public int editTermliStatus(Map<String, Object> paramMap);
    
    //查询绑定应用
    public TermEntity queTermAppInfo(String TermAppId);
    
    //删除绑定应用
    public int delTermAppInfo(String TermAppId);
    
    //判断应用终端是否已存在
    public List<TermEntity> validAppTerm(Map<String, Object> paramMap);
    
    //判断应用终端是否已存在
    public List<TermEntity> validAppSamCard(String AppSamCard);
    
    //判断终端应用序列是否存在
    public List<TermEntity> validTermAppSeq(String AppTermSeq);
    
    //根据termAppId查询数据
    public TermEntity queTermAppInfoById(String TermAppId);
    
    //判断终端信息是否存在
    public List<TermEntity> validApp(Map<String, Object> paramMap);
    
    //根据termId删除秘钥
    public int delTermAppKeyInfoBytermId(String termId);
    
    //查询长沙移动签到表记录
    public TermEntity queAppTermSeq(String TermAppId);
    
    //长沙移动终端删除绑定
    public int delBATCHMANAGEMENT(String TermAppId);
    
    //根据termseq 和 termid 查询秘钥
    public TermAppEntity getTermKey(Map<String, Object> paramMap);
    
    //删除秘钥
    public int delTermAppKeyInfo(Map<String, Object> paramMap);
    
    //绑定应用
    public int addtermapp(Map<String, Object> paramMap);
    
    //长沙移动终端
    public TermAppEntity findTermAppInfo(String termSeq);
    
    //添加长沙移动终端
    public int addBATCHMANAGEMENTInfo(Map<String, Object> paramMap);
    
    //修改应用
    public int edittermapp(Map<String, Object> paramMap);
    
    //插入秘钥
    public int addTermAppKeyInfo(Map<String, Object> paramMap);
    
    //修改秘钥
    public int editTermAppKeyInfo(Map<String, Object> paramMap);
    
    public List<TermEntity> findTermApp(String termSeq);
    //厂商下拉
    public List<ComboxValue> findfirm();
    
    //型号下拉
    public List<ComboxValue> findtypeId(String firmCode);
    
    //通讯方式下拉
    public List<ComboxValue> findtransferType();
    
    
    //自助终端信息上送
    public int addtermMonitor(Map<String, Object> paramMap);
    
    public List<IssuerSZTEntity> queryMerchSettle(Map<String, Object> paramMap);
    
    public long queryMerchValidErrNum(Map<String, Object> paramMap);
    
    public MerchantInfo getMerchInfo(String merchId);
    
    public int addMerchValid(Map<String, Object> paramMap);
    
}
