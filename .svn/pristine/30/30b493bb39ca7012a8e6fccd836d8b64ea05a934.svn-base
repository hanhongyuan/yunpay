package com.yunpay.permission.entity;


import com.yunpay.common.core.utils.DateUtils;

/**
 * 签到监控实体类
 * @author tf
 *
 */
public class SignMonitor {

	//交易日期
		public String tranDate;
		//交易时间
		public String tranTime;
		//批次号
		private String batchNo;
		//商户号
		private String merchId;
		//终端号
		private String termId;
		//终端序列号
		private String termSeq;
		//固件程序版本
		private String progreameVer;
		//银联证书
		private String unionpayCer;
		//操作员代码
		private String userId;
		//ESAM卡号
		private String esamCard;
		//黑名单版本
		private String blacklistVer;
		//计价参数版本
		private String farVer;
		//基本参数版本
		private String parVer;
		private String obligate1;
		private String obligate2;
		//pos流水
		private String posSerial;
		//平台流水
		private String pospSerial;
		//状态 01：成功； 02：失败
		private String recordStatus;
		//更新时间
		private String updateTime;
		//门店编码
		private String storeNo;
		//门店名称
		private String storeName;
		//折扣率
		private Double discountScale;
		//查询条件
		private String date1;
		private String date2;
		
		public String getDate1() {
			return date1;
		}
		public void setDate1(String date1) {
			this.date1 = date1;
		}
		public String getDate2() {
			return date2;
		}
		public void setDate2(String date2) {
			this.date2 = date2;
		}
		public String getTranDate() {
			return tranDate;
		}
		public void setTranDate(String tranDate) {
			if(tranDate.length() == 14){
				this.tranDate = DateUtils.formatToformat(tranDate, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss");
			}else{
				this.tranDate = tranDate;
			}
		}
		public String getTranTime() {
			return tranTime;
		}
		public void setTranTime(String tranTime) {
			this.tranTime = tranTime;
		}
		public String getBatchNo() {
			return batchNo;
		}
		public void setBatchNo(String batchNo) {
			this.batchNo = batchNo;
		}
		public String getMerchId() {
			return merchId;
		}
		public void setMerchId(String merchId) {
			this.merchId = merchId;
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
		public String getProgreameVer() {
			return progreameVer;
		}
		public void setProgreameVer(String progreameVer) {
			this.progreameVer = progreameVer;
		}
		public String getUnionpayCer() {
			return unionpayCer;
		}
		public void setUnionpayCer(String unionpayCer) {
			this.unionpayCer = unionpayCer;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getEsamCard() {
			return esamCard;
		}
		public void setEsamCard(String esamCard) {
			this.esamCard = esamCard;
		}
		public String getBlacklistVer() {
			return blacklistVer;
		}
		public void setBlacklistVer(String blacklistVer) {
			this.blacklistVer = blacklistVer;
		}
		public String getFarVer() {
			return farVer;
		}
		public void setFarVer(String farVer) {
			this.farVer = farVer;
		}
		public String getParVer() {
			return parVer;
		}
		public void setParVer(String parVer) {
			this.parVer = parVer;
		}
		public String getObligate1() {
			return obligate1;
		}
		public void setObligate1(String obligate1) {
			this.obligate1 = obligate1;
		}
		
		public String getPosSerial() {
			return posSerial;
		}
		public void setPosSerial(String posSerial) {
			this.posSerial = posSerial;
		}
		public String getPospSerial() {
			return pospSerial;
		}
		public void setPospSerial(String pospSerial) {
			this.pospSerial = pospSerial;
		}
		
		public String getUpdateTime() {
			return updateTime;
		}
		public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		}
		public String getObligate2() {
			return obligate2;
		}
		public void setObligate2(String obligate2) {
			this.obligate2 = obligate2;
		}
		public String getRecordStatus() {
			return recordStatus;
		}
		public void setRecordStatus(String recordStatus) {
			this.recordStatus = recordStatus;
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
		public Double getDiscountScale() {
			return discountScale;
		}
		public void setDiscountScale(Double discountScale) {
			this.discountScale = discountScale;
		}
}
