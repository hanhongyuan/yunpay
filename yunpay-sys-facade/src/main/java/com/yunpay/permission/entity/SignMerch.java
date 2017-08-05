package com.yunpay.permission.entity;

import java.math.BigDecimal;

/**
 * 商户日报表实体类
 * @author tf
 *
 */
public class SignMerch {

	//统计日期
		private String makeDate;
		//省
		private String provice;
		private String proviceCode;
		//城市
		private String region;
		private String regionCode;
		//商户签约数
		private String merSignNum;
		//商户解约数
		private String merCancelNum;
		//当前商户总数
		private String merTotalNum;
		//门店签约数
		private String storeSignNum;
		//门店解约数
		private String storeCancelNum;
		//当前门店总数
		private String storeTotalNum;
		//终端签约数
		private String termSignNum;
		//终端解约数
		private String termCancelNum;
		//当前终端总数
		private String termTotalNum;
		
		//当天交易笔数(上送)
		private String sendNum;
		//当天交易金额(上送)
		private BigDecimal sendAmount;
		//交易商户数(上送)
		private String sendMerchNum;
		//交易门店数(上送)
		private String sendStoreNum;
		//交易终端数(上送)
		private String sendTermNum;
		//使用终端
		private String useTermNum;
		
		//当天交易笔数
		private String tranNum;
		//当天交易金额
		private BigDecimal tranAmount;
		//交易商户数
		private String tranMerchNum;
		//交易门店数
		private String tranStoreNum;
		//交易终端数
		private String tranTermNum;
		//当天清算充值笔数
		private BigDecimal tranNumRecharge;
		//当前清算充值金额
		private BigDecimal tranAmtRecharge;
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
		public BigDecimal getTranNumRecharge() {
			return tranNumRecharge;
		}
		public void setTranNumRecharge(BigDecimal tranNumRecharge) {
			this.tranNumRecharge = tranNumRecharge;
		}
		public BigDecimal getTranAmtRecharge() {
			return tranAmtRecharge;
		}
		public void setTranAmtRecharge(BigDecimal tranAmtRecharge) {
			this.tranAmtRecharge = tranAmtRecharge;
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
		public String getProviceCode() {
			return proviceCode;
		}
		public void setProviceCode(String proviceCode) {
			this.proviceCode = proviceCode;
		}
		public String getRegionCode() {
			return regionCode;
		}
		public void setRegionCode(String regionCode) {
			this.regionCode = regionCode;
		}
		public String getMerSignNum() {
			return merSignNum;
		}
		public void setMerSignNum(String merSignNum) {
			this.merSignNum = merSignNum;
		}
		public String getMerCancelNum() {
			return merCancelNum;
		}
		public void setMerCancelNum(String merCancelNum) {
			this.merCancelNum = merCancelNum;
		}
		public String getMerTotalNum() {
			return merTotalNum;
		}
		public void setMerTotalNum(String merTotalNum) {
			this.merTotalNum = merTotalNum;
		}
		public String getStoreSignNum() {
			return storeSignNum;
		}
		public void setStoreSignNum(String storeSignNum) {
			this.storeSignNum = storeSignNum;
		}
		public String getStoreCancelNum() {
			return storeCancelNum;
		}
		public void setStoreCancelNum(String storeCancelNum) {
			this.storeCancelNum = storeCancelNum;
		}
		public String getStoreTotalNum() {
			return storeTotalNum;
		}
		public void setStoreTotalNum(String storeTotalNum) {
			this.storeTotalNum = storeTotalNum;
		}
		public String getTermSignNum() {
			return termSignNum;
		}
		public void setTermSignNum(String termSignNum) {
			this.termSignNum = termSignNum;
		}
		public String getTermCancelNum() {
			return termCancelNum;
		}
		public void setTermCancelNum(String termCancelNum) {
			this.termCancelNum = termCancelNum;
		}
		public String getTermTotalNum() {
			return termTotalNum;
		}
		public void setTermTotalNum(String termTotalNum) {
			this.termTotalNum = termTotalNum;
		}
		public String getTranNum() {
			return tranNum;
		}
		public void setTranNum(String tranNum) {
			this.tranNum = tranNum;
		}
		
		public BigDecimal getTranAmount() {
			return tranAmount;
		}
		public void setTranAmount(BigDecimal tranAmount) {
			this.tranAmount = tranAmount;
		}
		public String getTranMerchNum() {
			return tranMerchNum;
		}
		public void setTranMerchNum(String tranMerchNum) {
			this.tranMerchNum = tranMerchNum;
		}
		public String getTranStoreNum() {
			return tranStoreNum;
		}
		public void setTranStoreNum(String tranStoreNum) {
			this.tranStoreNum = tranStoreNum;
		}
		public String getTranTermNum() {
			return tranTermNum;
		}
		public void setTranTermNum(String tranTermNum) {
			this.tranTermNum = tranTermNum;
		}
		public String getSendNum() {
			return sendNum;
		}
		public void setSendNum(String sendNum) {
			this.sendNum = sendNum;
		}
		public BigDecimal getSendAmount() {
			return sendAmount;
		}
		public void setSendAmount(BigDecimal sendAmount) {
			this.sendAmount = sendAmount;
		}
		public String getSendMerchNum() {
			return sendMerchNum;
		}
		public void setSendMerchNum(String sendMerchNum) {
			this.sendMerchNum = sendMerchNum;
		}
		public String getSendStoreNum() {
			return sendStoreNum;
		}
		public void setSendStoreNum(String sendStoreNum) {
			this.sendStoreNum = sendStoreNum;
		}
		public String getSendTermNum() {
			return sendTermNum;
		}
		public void setSendTermNum(String sendTermNum) {
			this.sendTermNum = sendTermNum;
		}
		public String getUseTermNum() {
			return useTermNum;
		}
		public void setUseTermNum(String useTermNum) {
			this.useTermNum = useTermNum;
		}
}
