package com.yunpay.permission.dao.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yunpay.permission.dao.SysTermDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.IssuerSZTEntity;
import com.yunpay.permission.entity.MerchantInfo;
import com.yunpay.permission.entity.TermAppEntity;
import com.yunpay.permission.entity.TermEntity;


@Repository("SysTermDao")
public class SysTermDaoImpl extends PermissionBaseDaoImpl<TermEntity> implements SysTermDao {
	
	@Override
	public TermEntity selectByPrimaryKey(String termId) {
		return super.getSqlSession().selectOne(getStatement(SQL_SELECT_BY_ID), termId);	
	}
	
	@Override
    public int deleteByPrimaryKey(String termId) {
        return super.getSqlSession().delete(getStatement(SQL_DELETE_BY_ID), termId);
	    //return 1;
    }
	
	@Override
    public int deleteTermApp(String termseq) {
        return super.getSqlSession().delete(getStatement("deleteTermApp"), termseq);   
	    //return 1;
    }
	
	@Override
    public int deleteTermKey(String termId) {
        return super.getSqlSession().delete(getStatement("deleteTermKey"), termId);   
	    //return 1;
    }
	
	@Override
    public int updateMachineInfo(Map<String, Object> paramMap) {
        return super.getSqlSession().delete(getStatement("updateMachineInfo"), paramMap);  
	    //return 1;
    }
	
	@Override
    public int insertTermLs(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("insertTermLs"), paramMap);   
    }
	
	@Override
    public int delSign(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("delSign"), paramMap);   
    }
	
	@Override
    public int delCode(String termseq) {
        return super.getSqlSession().insert(getStatement("delCode"), termseq);   
    }
	
	@Override
	public List<TermEntity> Findall(){
	    return super.getSqlSession().selectList(getStatement("findall"));
	}
	
	@Override
	public List<ComboxValue> findfirm() {
        return super.getSqlSession().selectList(getStatement("findfirm"));
    }
	
	@Override
    public List<ComboxValue> findtypeId(String firmCode) {
        return super.getSqlSession().selectList(getStatement("findtypeId"),firmCode);
    }
	
	@Override
	public List<ComboxValue> findtransferType() {
        return super.getSqlSession().selectList(getStatement("findtransferType"));
    }
	
	@Override
	public int addTerm(TermEntity term){
	    return super.getSqlSession().insert(getStatement("addTerm"),term);
	}
	
	@Override
    public int editTerm(TermEntity term){
        return super.getSqlSession().update(getStatement("editTerm"),term);
    }
	
	@Override
    public int editTermStatus(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("editTermStatus"), paramMap);  
    }
	
	@Override
    public int editTermliStatus(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("editTermliStatus"), paramMap);  
    }
	
	@Override
    public TermEntity queTermAppInfo(String TermAppId) {
        return super.getSqlSession().selectOne(getStatement("queTermAppInfo"), TermAppId);  
    }
	
	@Override
    public TermEntity queAppTermSeq(String TermAppId) {
        return super.getSqlSession().selectOne(getStatement("queAppTermSeq"), TermAppId);  
    }
	
	@Override
    public int delBATCHMANAGEMENT(String AppTermSeq) {
        return super.getSqlSession().delete(getStatement("delBATCHMANAGEMENT"), AppTermSeq);  
    }
	
	@Override
    public int delTermAppInfo(String TermAppId) {
        return super.getSqlSession().delete(getStatement("delTermAppInfo"), TermAppId);  
    }
	
	@Override
    public int delTermAppKeyInfoBytermId(String termId) {
        return super.getSqlSession().delete(getStatement("delTermAppKeyInfoBytermId"), termId);  
    }
	
	@Override
    public TermEntity checkTermSeq(String termSeq) {
        return super.getSqlSession().selectOne(getStatement("checkTermSeq"),termSeq);
    }
	
	@Override
    public TermEntity findTermId(String prefix) {
        return super.getSqlSession().selectOne(getStatement("findTermId"),prefix);
    }
	
	public TermEntity findTermIdbySeq(String termSeq) {
        return super.getSqlSession().selectOne(getStatement("findTermIdbySeq"),termSeq);
    }
	
	@Override
    public int checkGPRSNo(String GPRSNo) {
        return super.getSqlSession().selectOne(getStatement("checkGPRSNo"),GPRSNo);
    }
	
	@Override
    public TermAppEntity getTermKey(Map<String, Object> paramMap) {
        return super.getSqlSession().selectOne(getStatement("getTermKey"), paramMap);  
    }
	
	@Override
    public int delTermAppKeyInfo(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("delTermAppKeyInfo"), paramMap);  
    }
	
	@Override
    public int addtermapp(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("addtermapp"), paramMap);  
    }
	
	@Override
    public TermAppEntity findTermAppInfo(String termSeq) {
        return super.getSqlSession().selectOne(getStatement("findTermAppInfo"), termSeq);  
    }
	
	@Override
    public int addBATCHMANAGEMENTInfo(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("addBATCHMANAGEMENTInfo"), paramMap);  
    }
	
	public TermEntity queTermAppInfoById(String TermAppId){
	    return super.getSqlSession().selectOne(getStatement("queTermAppInfoById"), TermAppId);  
	}
	
	public List<TermEntity> validApp(Map<String, Object> paramMap){
	    return super.getSqlSession().selectList(getStatement("validApp"), paramMap);  
	}
	
	@Override
    public int edittermapp(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("edittermapp"), paramMap);  
    }
	
	@Override
    public List<TermEntity> validAppTerm(Map<String, Object> paramMap) {
        return super.getSqlSession().selectList(getStatement("validAppTerm"), paramMap);  
    }
	
	@Override
    public List<TermEntity> validAppSamCard(String AppSamCard){
        return super.getSqlSession().selectList(getStatement("validAppSamCard"), AppSamCard);  
    }
	
	@Override
    public List<TermEntity> validTermAppSeq(String AppTermSeq) {
        return super.getSqlSession().selectList(getStatement("validTermAppSeq"), AppTermSeq);  
    }
	
	@Override
    public int addTermAppKeyInfo(Map<String, Object> paramMap) {
        return super.getSqlSession().insert(getStatement("addTermAppKeyInfo"), paramMap);  
    }
	
	@Override
    public int editTermAppKeyInfo(Map<String, Object> paramMap) {
        return super.getSqlSession().update(getStatement("editTermAppKeyInfo"), paramMap);  
    }
	
	@Override
	public List<TermEntity> findTermApp(String termSeq){
	    return super.getSqlSession().selectList(getStatement("findTermApp"),termSeq);
	}
	
	public int addtermMonitor(Map<String, Object> paramMap){
	    return super.getSqlSession().insert(getStatement("addtermMonitor"),paramMap);
	}
	
	public List<IssuerSZTEntity> queryMerchSettle(Map<String, Object> paramMap){
	    return super.getSqlSession().selectList(getStatement("queryMerchSettle"),paramMap);
	}
    
	public long queryMerchValidErrNum(Map<String, Object> paramMap){
	    return super.getSqlSession().selectOne(getStatement("queryMerchValidErrNum"),paramMap);
	}
	
	public MerchantInfo getMerchInfo(String merchId){
	    return super.getSqlSession().selectOne(getStatement("getMerchInfo"),merchId);
	}
	
	public int addMerchValid(Map<String, Object> paramMap){
	    return super.getSqlSession().insert(getStatement("addMerchValid"),paramMap);
	}
}
