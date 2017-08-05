package com.yunpay.permission.service.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunpay.common.core.page.PageBean;
import com.yunpay.common.core.page.PageParam;
import com.yunpay.common.core.utils.DateUtils;
import com.yunpay.permission.dao.StoreDao;
import com.yunpay.permission.dao.SysTermDao;
import com.yunpay.permission.entity.ComboxValue;
import com.yunpay.permission.entity.IssuerSZTEntity;
import com.yunpay.permission.entity.MerchantInfo;
import com.yunpay.permission.entity.StoreEntity;
import com.yunpay.permission.entity.TermAppEntity;
import com.yunpay.permission.entity.TermEntity;
import com.yunpay.permission.entity.TermMonitorEntity;
import com.yunpay.permission.service.SysTermService;

@Service("SysTermService")
public class SysTermServiceImpl implements SysTermService{
	@Autowired 
	SysTermDao termDao;
	@Autowired 
    StoreDao storeDao;
	
    @SuppressWarnings("rawtypes")
    public PageBean listPage(PageParam pageParam, TermEntity termEntity) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("merchName", termEntity.getMerchName());   //商户名称
        paramMap.put("storeName", termEntity.getStoreName());   //门店名称
        paramMap.put("termSeq", termEntity.getTermSeq());       //机器SN号
        paramMap.put("termId", termEntity.getTermId());         //终端号
        paramMap.put("pwdKeyboard", termEntity.getPwdKeyboard());//SAM卡号
        return termDao.listPage(pageParam, paramMap);
    }
    
    @Override
    public int editTermStatus(String termSeq,String status){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("termSeq", termSeq);
        paramMap.put("status", status);
        termDao.editTermStatus(paramMap);
        if(status.equals("01")){
            paramMap.put("KeyStatus", "1");
        }else {
            paramMap.put("KeyStatus", "0");
        }
        termDao.editTermliStatus(paramMap);
        return 1;
    }
    
    @Override
    public TermAppEntity getTermKey(String termId,String appCode){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("appCode", appCode);
        paramMap.put("termId", termId);
        return termDao.getTermKey(paramMap);
    }
    
    public boolean delTermAppInfo(TermEntity term){
        String termAppId = term.getTermAppId();
        TermEntity T=termDao.queTermAppInfo(termAppId);
        if(T!= null){
            termDao.delTermAppKeyInfoBytermId(T.getAppTermNo());
        }
        
//        //查询长沙移动签到表记录
//        T=termDao.queAppTermSeq(termAppId);
//        if(T !=null && "02".equals(T.getAppCode())){
//            //长沙移动终端删除绑定
//            termDao.delBATCHMANAGEMENT(T.getAppTermSeq());
//        }
        
        termDao.delTermAppInfo(termAppId);
        return true;
    }
    
    @Override
    public int addTermAppInfo(TermEntity term,TermAppEntity termApp){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        String appCode = term.getAppCode();
        String termSeq = term.getTermSeq();
        String appTermSeq = term.getAppTermSeq();
        String appSamCard = term.getAppSamCard();
        String appTermNo = term.getAppTermNo();
        
        paramMap.put("appCode", appCode);
        paramMap.put("appTermNo", appTermNo);
        if(appCode.equals("05")||appCode.equals("08")){
            
        }else{
             //判断应用终端是否已存在
             if(termDao.validAppTerm(paramMap).size() >0){
                 return 1;
             }
             //判断终端SAM卡号是否存在
             if(null!=appSamCard && !"".equals(appSamCard)){
                 if(termDao.validAppSamCard(appSamCard).size() >0){
                     return 2;
                 }
             }
             //判断终端应用序列是否存在
             if(null!=appTermSeq && !"".equals(appTermSeq)){
                 if(termDao.validTermAppSeq(appTermSeq).size() >0){
                     return 3;
                 }
             }
        }
        
        //1、绑定应用
        paramMap.put("termSeq", termSeq);
        paramMap.put("appTermSeq", appTermSeq);
        paramMap.put("status", "01");
        paramMap.put("appSamcard", appSamCard);
        termDao.addtermapp(paramMap);
        
//        //如果是长沙移动终端则添加绑定<移动签到信息表 SD_BATCHMANAGEMENT_INFO >
//        if(appCode!=null && appCode.trim().equals("02")) {
//            TermAppEntity termAppinfo = termDao.findTermAppInfo(termSeq);
//            Map<String, Object> Map = new HashMap<String, Object>();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Map.put("termDate", sdf.format(new Date()));
//            Map.put("termId", appTermSeq);
//            Map.put("termNo", appTermNo);
//            Map.put("merchId", termAppinfo.getIssuerMerchId());
//            Map.put("lmkTak", "1");
//            Map.put("lmkTpk", "1");
//            Map.put("batchNo", "000001");
//            Map.put("aid", "0000000000000000");
//            Map.put("appVersion", "20101210000000");
//            Map.put("parameterVersion", "20090601000000");
//            Map.put("operId", "01000000");
//            Map.put("posTermId", termAppinfo.getTermId());
//            Map.put("posMerchId", termAppinfo.getMerchId());
//            termDao.addBATCHMANAGEMENTInfo(Map);
//        }
        if(appCode.equals("01")||appCode.equals("08")||appCode.equals("11")){
            //2、删除秘钥
            paramMap.put("termId", term.getTermId());
            termDao.delTermAppKeyInfo(paramMap);
            //3、插入秘钥
            paramMap.put("merchId", termApp.getMerchId());
            paramMap.put("operId", termApp.getOperId());
            paramMap.put("lmkTmk", termApp.getLmkTmk());
            paramMap.put("zmkTmk", termApp.getZmkTmk());
            paramMap.put("tmkCheckValue", termApp.getTmkCheckValue());
            paramMap.put("lmkTpk", termApp.getLmkTpk());
            paramMap.put("lmkTak", termApp.getLmkTak());
            paramMap.put("tmkTpk", termApp.getTmkTpk());
            paramMap.put("tmkTak", termApp.getTmkTak());
            paramMap.put("batchNo", termApp.getBatchNo());
            paramMap.put("updateTime", termApp.getUpdateTime());
            termDao.addTermAppKeyInfo(paramMap);
        }
        return 4;
    }
    
    public int editTermAppInfo(TermEntity term,TermAppEntity termApp){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("termSeq", term.getTermSeq());
        paramMap.put("appCode", term.getAppCode());
        paramMap.put("appTermSeq", term.getAppTermSeq());
        paramMap.put("appTermNo", term.getAppTermNo());
        paramMap.put("appSamcard", term.getAppSamCard());
        paramMap.put("termId", term.getTermId());
        paramMap.put("termAppId", term.getTermAppId());
        
        if(term.getAppCode().equals("05")||term.getAppCode().equals("08")){
            
        }else{
             //判断应用终端是否已存在
             if(termDao.validApp(paramMap).size() >0){
                 return 5;
             } 
            
             //1、根据termAppId查询数据
             TermEntity termEntity = termDao.queTermAppInfoById(term.getTermAppId());
             //2、对比新旧数据，看appSamcard、appTermSeq、appTermNo是否有改动
             //3、判断改动是否唯一
             if(!(termEntity.getTermSeq().equals(term.getTermSeq()))){
               //判断终端应用序列是否存在
                 if(null!=term.getTermSeq() && !"".equals(term.getTermSeq())){
                     if(termDao.validTermAppSeq(term.getTermSeq()).size() >0){
                         return 3;
                     }
                 }
             }
             //3、判断改动是否唯一
             if(!(termEntity.getAppTermNo().equals(term.getAppTermNo()))){
                 //判断应用终端是否已存在
                 if(termDao.validAppTerm(paramMap).size() >0){
                     return 1;
                 }
             }
             //3、判断改动是否唯一
             if(!(termEntity.getAppSamCard().equals(term.getAppSamCard()))){
               //判断终端SAM卡号是否存在
                 if(null!=term.getAppSamCard() && !"".equals(term.getAppSamCard())){
                     if(termDao.validAppSamCard(term.getAppSamCard()).size() >0){
                         return 2;
                     }
                 }
             }
        }
        //1、修改应用 termSeq
        termDao.edittermapp(paramMap);
        if(term.getAppCode().equals("01")||term.getAppCode().equals("08")||term.getAppCode().equals("11")){
            //2、修改秘钥
            paramMap.put("merchId", termApp.getMerchId());
            paramMap.put("operId", termApp.getOperId());
            paramMap.put("lmkTmk", termApp.getLmkTmk());
            paramMap.put("zmkTmk", termApp.getZmkTmk());
            paramMap.put("tmkCheckValue", termApp.getTmkCheckValue());
            paramMap.put("lmkTpk", termApp.getLmkTpk());
            paramMap.put("lmkTak", termApp.getLmkTak());
            paramMap.put("tmkTpk", termApp.getTmkTpk());
            paramMap.put("tmkTak", termApp.getTmkTak());
            paramMap.put("batchNo", termApp.getBatchNo());
            paramMap.put("updateTime", termApp.getUpdateTime());
            termDao.editTermAppKeyInfo(paramMap);
        }
        return 4;
    }
    
    @Override
    public List<TermEntity> findTermApp(String termSeq) {
        return termDao.findTermApp(termSeq);
    }
    
    @Override
    public TermEntity findTermId(String prefix) {
        return termDao.findTermId(prefix);
    }
    
    @Override
    public TermEntity findTermIdbySeq(String termSeq) {
        return termDao.findTermIdbySeq(termSeq);
    }
    
    @Override
    public String addTerm(TermEntity term){
        String termSeq = term.getTermSeq();
        //校验物理终端是否唯一
        TermEntity termEntities = termDao.checkTermSeq(termSeq);
        if ( termEntities != null){
            return "终端序列号已存在，不能重复!";
        } 
        //获取TermId
        String prefix = term.getStoreNo().substring(0, 4);
        term.setTermId(termDao.findTermId(prefix).getTermId());
        //1、插入终端基本信息表 sd_merch_term
        termDao.addTerm(term);
        //2、修改机器表sd_machine_info状态为2
        Map<String, Object> infoMap = new HashMap<String, Object>();
            infoMap.put("termSeq", termSeq);
            infoMap.put("macStatus", "2");
        termDao.updateMachineInfo(infoMap);
        //3、往机器装撤机流水表sd_merch_term_ls中插入装机记录
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("termId", term.getTermId());
        paramMap.put("merchId", term.getMerchId());
        paramMap.put("status", term.getStatus());
        paramMap.put("firm", term.getFirm());
        paramMap.put("typeId", term.getTypeId());
        paramMap.put("setPerson",term.getSetPerson());
        paramMap.put("posRent", term.getPosRent());
        paramMap.put("posDeposit", term.getPosDeposit());
        paramMap.put("storeNo", term.getStoreNo());
        paramMap.put("setDate",term.getSetDate());
        paramMap.put("termSeq", term.getTermSeq());
        paramMap.put("remark", term.getRemark());
        paramMap.put("oprUser", term.getCreateUser());
        paramMap.put("storageFlag",term.getStorageFlag());
        paramMap.put("oprDate", term.getCreatetime());
        paramMap.put("gprsNo", term.getGprsNo());
        paramMap.put("transferType", term.getTransferType());
        paramMap.put("isPwdkey", term.getIsPwdkey());
        paramMap.put("pwdKeyboard", term.getPwdKeyboard());
        paramMap.put("isReadcard", term.getIsReadcard());
        paramMap.put("readCardno", term.getReadCardno());
        paramMap.put("seqId", term.getSeqId());
        paramMap.put("dealType", "1");
        termDao.insertTermLs(paramMap);
        return "TRUE";
    }
    
    @Override
    public int editTerm(TermEntity term){
        return termDao.editTerm(term);
    }

    @Override
    public TermEntity selectByPrimaryKey(String merchId) {
        return termDao.selectByPrimaryKey(merchId);
    }
    
    @Override
    public List<ComboxValue> findfirm() {
        return termDao.findfirm();
    }
    
    @Override
    public List<ComboxValue> findtypeId(String firmCode) {
        return termDao.findtypeId(firmCode);
    }
    
    @Override
    public List<ComboxValue> findtransferType() {
        return termDao.findtransferType();
    }
    
    @SuppressWarnings("unused")
    @Override
    public boolean deleteByPrimaryKey(String termId,String createUser) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TermEntity term = termDao.selectByPrimaryKey(termId);
        String termSeq = term.getTermSeq();
        if (term == null) {
            return false;
        }
        //1、先删除终端基本信息(sd_merch_term)
        termDao.deleteByPrimaryKey(termId);
        //2、再删除终端应用信息(sd_term_app)
        termDao.deleteTermApp(termSeq);
        //3、再删除终端秘钥信息(sd_term_key)
        termDao.deleteTermKey(termId);
        //4、再修改机器入库表中机器状态(sd_machine_info)为入库状态
        Map<String, Object> infoMap = new HashMap<String, Object>();
            infoMap.put("termSeq", termSeq);
            infoMap.put("macStatus", "1");
        termDao.updateMachineInfo(infoMap);
        //5、最后往装撤机流水表(sd_merch_term_ls)添加撤机流水
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("termId", term.getTermId());
        paramMap.put("merchId", term.getMerchId());
        paramMap.put("status", term.getStatus());
        paramMap.put("firm", term.getFirm());
        paramMap.put("typeId", term.getTypeId());
        paramMap.put("setPerson",term.getSetPerson());
        paramMap.put("posRent", term.getPosRent());
        paramMap.put("posDeposit", term.getPosDeposit());
        paramMap.put("storeNo", term.getStoreNo());
        paramMap.put("setDate",term.getSetDate());
        paramMap.put("termSeq", term.getTermSeq());
        paramMap.put("remark", term.getRemark());
        paramMap.put("oprUser", createUser);
        paramMap.put("storageFlag",term.getStorageFlag());
        paramMap.put("oprDate", sdf.format(new Date()));
        paramMap.put("gprsNo", term.getGprsNo());
        paramMap.put("transferType", term.getTransferType());
        paramMap.put("isPwdkey", term.getIsPwdkey());
        paramMap.put("pwdKeyboard", term.getPwdKeyboard());
        paramMap.put("isReadcard", term.getIsReadcard());
        paramMap.put("readCardno", term.getReadCardno());
        paramMap.put("seqId", term.getSeqId());
        paramMap.put("dealType", "3");
//        //删除长沙移动签到表
//        termDao.delSign(paramMap);
//        //删除注册码表
//        termDao.delCode(termSeq);
//        Iterator<Map.Entry<String, Object>> entries = paramMap.entrySet().iterator();  
//        while (entries.hasNext()) {  
//            Map.Entry<String, Object> entry = entries.next();  
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
//        }  
        
        if(termDao.insertTermLs(paramMap) < 1){
            return false;
        }
        return true;
    }
    
    @SuppressWarnings("rawtypes")
    public PageBean listStore(PageParam pageParam, StoreEntity storeEntity){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("id", storeEntity.getId());
        paramMap.put("StoreName", storeEntity.getStoreName());
        return storeDao.listPage(pageParam,paramMap);
    }
    
    public boolean addtermMonitor(TermMonitorEntity termMonitor){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("merchId", termMonitor.getMerchId());
        paramMap.put("storeNo", termMonitor.getStoreNo());
        paramMap.put("termId", termMonitor.getTermId());
        paramMap.put("termSeq", termMonitor.getTermSeq());
        paramMap.put("msgType", termMonitor.getMsgType());
        paramMap.put("msgContext", termMonitor.getMsgContext());
        paramMap.put("msgRemark", termMonitor.getMsgRemark());
        if(termDao.addtermMonitor(paramMap) > 0){
            return true;
        }
        return false;
    }
    
    public List<Map<String,Object>> queryMerchSettle(String beginDate,String endDate,String merchId){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("beginDate", beginDate);
        paramMap.put("endDate", endDate);
        paramMap.put("merchId", merchId);
        
        List<IssuerSZTEntity> merchSetList = termDao.queryMerchSettle(paramMap);
        List<Map<String,Object>> rtnMerchSetList=null;
        if(merchSetList!=null && merchSetList.size()>0){
            rtnMerchSetList = new ArrayList<Map<String,Object>>();
            for(int i=0;i<merchSetList.size();i++){
                
                NumberFormat currency = NumberFormat.getNumberInstance();
                currency.setMaximumFractionDigits(2);
                currency.setMinimumFractionDigits(2);
                Map<String,Object> merchSet = new HashMap<String,Object>();
                String billNo = String.valueOf(merchSetList.get(i).getBillId());
                String busiCode = billNo.substring(billNo.length()-2);
                if("37".equals(busiCode)){
                    merchSet.put("billType", "深圳通消费");
                    double inFee = merchSetList.get(i).getInFee().doubleValue();
                    merchSet.put("payFee",currency.format(0-inFee));
                    merchSet.put("setAmt", currency.format(merchSetList.get(i).getOutAmt()));
                }
                else{
                    merchSet.put("billType", "深圳通充值");
                    merchSet.put("payFee", currency.format(merchSetList.get(i).getOutFee()));
                    merchSet.put("setAmt", currency.format(merchSetList.get(i).getOutFee()));
                }
                merchSet.put("tranNum", merchSetList.get(i).getTranNum());
                merchSet.put("tranAmt", currency.format(merchSetList.get(i).getTranAmt()));
                
                merchSet.put("beginDate", merchSetList.get(i).getSetBeginDate());
                merchSet.put("endDate", merchSetList.get(i).getSetEndDate());
                rtnMerchSetList.add(merchSet);
            }
        }
        return rtnMerchSetList;
    }
    
    public long queryMerchValidErrNum(String termSeq){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("validDate", DateUtils.today());
        paramMap.put("termSeq", termSeq);
        return termDao.queryMerchValidErrNum(paramMap);
    }
    
    public boolean validMerchInfo(MerchantInfo merchantInfo,String termSeq){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        MerchantInfo tarMerch = termDao.getMerchInfo(merchantInfo.getMerchId());
        
        String validStatus="0";
        boolean validRes = false;
        if(tarMerch!=null){
            if(merchantInfo.getAccountName().equals(tarMerch.getAccountName())
                    && merchantInfo.getAccountNo().equals(tarMerch.getAccountNo())
                    && merchantInfo.getLinktal().equals(tarMerch.getLinktal())){
                validStatus="1";
                validRes = true;
            }
        }
        paramMap.put("merchId", merchantInfo.getMerchId());
        paramMap.put("termSeq", termSeq);
        paramMap.put("validStatus", validStatus);
        paramMap.put("validDate",DateUtils.today());
        termDao.addMerchValid(paramMap);
        return validRes;
    }
}
