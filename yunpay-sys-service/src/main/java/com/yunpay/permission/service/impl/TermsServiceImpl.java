package com.yunpay.permission.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.permission.dao.TermsDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.TermLsEntity;
import com.yunpay.permission.service.TermsService;

@Service("TermsService")
public class TermsServiceImpl implements TermsService{
	@Autowired 
	TermsDao termDao;
	
	@SuppressWarnings("rawtypes")
    @Override
    public PageBean listPage(PageParam pageParam, TermEntity termEntity) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("termSeq", termEntity.getTermSeq());       //终端序列号
        paramMap.put("appTermNo", termEntity.getAppTermNo());   //应用终端号
        paramMap.put("samCardNo", termEntity.getSamCardNo());   //SAM卡号
        paramMap.put("macStatus", termEntity.getMacStatus());   //单据状态
        return termDao.listPage(pageParam, paramMap);
    }
	
	public TermEntity selectByPrimaryKey(int id) {
        return termDao.selectByPrimaryKey(id);
    }
	
	public List<TermEntity> findMacselect() {
        return termDao.findMacselect();
    }
	
	public int addMacTerm(TermEntity termEntity){
	    return termDao.addMacTerm(termEntity);
	}
	
	public int delMacTerm(String termSeq){
	    return termDao.delMacTerm(termSeq);
	}

	public int editMacTerm(TermEntity termEntity){
        return termDao.editMacTerm(termEntity);
    }
	
	public TermEntity selectbytermSeq(TermEntity termEntity){
	    Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("termSeq", termEntity.getTermSeq());
	    paramMap.put("appTermNo", termEntity.getAppTermNo());
	    paramMap.put("samCardNo", termEntity.getSamCardNo());
	    return termDao.selectbytermSeq(paramMap);
	}
	
	@SuppressWarnings("rawtypes")
    @Override
    public PageBean TermLslistPage(PageParam pageParam, TermLsEntity termLsEntity) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("termId", termLsEntity.getTermId());                   //终端编码
        paramMap.put("termLsSeq", termLsEntity.getTermSeq());               //终端序列号
        paramMap.put("firm", termLsEntity.getFirm());                       //厂商
        paramMap.put("typeId", termLsEntity.getTypeId());                   //型号
        paramMap.put("merchName", termLsEntity.getMerchName());             //品牌名称
        paramMap.put("storeName", termLsEntity.getStoreName());             //门店名称
        paramMap.put("dealType", termLsEntity.getDealType());               //操作类型
        paramMap.put("contract_begin", termLsEntity.getContract_begin());   //开始时间
        paramMap.put("contract_end", termLsEntity.getContract_end());       //结束时间
        return termDao.TermLslistPage(pageParam, paramMap);
    }
	
	public List<TermLsEntity> selectdealtype(){
        return termDao.selectdealtype();
    }
	
	public List<ComboxValue> selectfirm(){
        return termDao.selectfirm();
    }
	
	public List<ComboxValue> findtypeId(String code){
        return termDao.findtypeId(code);
    }
	
}
