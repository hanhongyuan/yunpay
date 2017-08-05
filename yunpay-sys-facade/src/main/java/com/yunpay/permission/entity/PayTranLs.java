package com.yunpay.permission.entity;
import java.util.Date;
import com.yunpay.common.core.utils.ExcelField;
public class PayTranLs  extends PermissionBaseEntity{
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 支付交易记录,关联表:t_pay_tran_ls
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年6月21日上午9:56:12 
	 * 修改历史:  
	 * 修改日期                     修改人员                                   版本	            修改内容  
	 * ----------------------------------------------  
	 * 2017年4月14日     duan zhang quan   1.0     新建
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	@ExcelField(title = "序号")
	private int id;  //主键
	@ExcelField(title = "渠道")
	private String channel;  //支付渠道,，1支付宝，2微信，3银联，4：预存款
	@ExcelField(title = "支付方式")
	private String subChannel;  //细分渠道(支付方式)，0-支付宝wap、1-支付宝条码，2-支付宝扫码 3-微信wap 4微信条码 5 微信扫码
	private String title;    // 商品名称
	@ExcelField(title = "商户名称")
	private String merchantName;  // 商户名
	private String serialNo;  //商户编号
	private String agentSerialNo; //代理商编号
	private String terminalNum;   // 终端号
	private String transCardNum; // 支付帐号（支付宝账户、银联卡号、微信财付通帐号）
	@ExcelField(title = "平台流水")
	private String transNum;  // 交易流水号(平台流水(支付后台产生的))
	private String outer_transNum;  // 外部交易流水号，比如：如果支付方式是微信支付，就是财付通的交易单号
	@ExcelField(title = "支付时间")
	private Date transTime;  // 交易时间
	@ExcelField(title = "优惠金额")
	private float discountPrice;
	@ExcelField(title = "实付金额")
	private float transPrice; // 实际交易金额（小数点后两位）
	@ExcelField(title = "原始金额")
	private float totalPrice;  // 订单金额（小数点后两位）
	private Integer scanType;  //扫描类型，正扫：QR_CODE_OFFLIN，反扫：BARCODE_PAY_OFFLINE
	private String couponCode; // 卡券核销码
	private Integer transType;  // 交易类型，0:支付，1:退款
	private Integer orderId; // 原支付订单号
	@ExcelField(title = "支付流水号")
	private String user_order_no; // 商户订单号(支付流水号（调用方上产生的订单号）)
	private String info; // 备注
	@ExcelField(title = "渠道流水")
	private String trade_no;// 第三方支付订单号（支付宝交易号trade_no/微信支付订单号transaction_id）(渠道流水（微信、支付宝产生的流水号）)
	private String subject;//订单简要描述（支付宝订单标题subject /微信商品描述body）
	private String syncNotify;  // 外部商户同步回写地址
	private String asynNotify;   // 外部商户异步回写地址
	private String scanNotify;  // 外部商户条码支付异步回调地址
	private String barNotify;  // 外部商户条码支付异步回调地址
	private String openid;      // 第三方openid
	private String merchantNo;  // 平台商户号
	private String cashierNo;  // 收银员编码
	private String orgNo;  // 组织结构编码
	private String showUrl;  // 商品展示地址
	private String payBusType;  //支付业务类型：0-普通支付 1-激活码购买支付 2-充值支付
	private String attach;   // 业务附加参数JSON格式{key:value,key:value}
	@ExcelField(title = "支付状态")
	private String status;  // 付款状态， 0：未付款，1：付款中，2：已付款 ，3：已退款，4：退款中，5：退款失败，6：付款失败，7：取消订单
	@ExcelField(title = "门店名称")
	private String storeName;  //门店名称  (不与表对应的字段)

	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getSubChannel() {
		return subChannel;
	}
	public void setSubChannel(String subChannel) {
		this.subChannel = subChannel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getAgentSerialNo() {
		return agentSerialNo;
	}
	public void setAgentSerialNo(String agentSerialNo) {
		this.agentSerialNo = agentSerialNo;
	}
	public String getTerminalNum() {
		return terminalNum;
	}
	public void setTerminalNum(String terminalNum) {
		this.terminalNum = terminalNum;
	}
	public String getTransCardNum() {
		return transCardNum;
	}
	public void setTransCardNum(String transCardNum) {
		this.transCardNum = transCardNum;
	}
	public String getTransNum() {
		return transNum;
	}
	public void setTransNum(String transNum) {
		this.transNum = transNum;
	}
	public String getOuter_transNum() {
		return outer_transNum;
	}
	public void setOuter_transNum(String outer_transNum) {
		this.outer_transNum = outer_transNum;
	}
	public Date getTransTime() {
		return transTime;
	}
	public void setTransTime(Date transTime) {
		this.transTime = transTime;
	}
	public float getTransPrice() {
		return transPrice;
	}
	public void setTransPrice(float transPrice) {
		this.transPrice = transPrice;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getScanType() {
		return scanType;
	}
	public void setScanType(Integer scanType) {
		this.scanType = scanType;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Integer getTransType() {
		return transType;
	}
	public void setTransType(Integer transType) {
		this.transType = transType;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSyncNotify() {
		return syncNotify;
	}
	public void setSyncNotify(String syncNotify) {
		this.syncNotify = syncNotify;
	}
	public String getAsynNotify() {
		return asynNotify;
	}
	public void setAsynNotify(String asynNotify) {
		this.asynNotify = asynNotify;
	}
	public String getScanNotify() {
		return scanNotify;
	}
	public void setScanNotify(String scanNotify) {
		this.scanNotify = scanNotify;
	}
	public String getBarNotify() {
		return barNotify;
	}
	public void setBarNotify(String barNotify) {
		this.barNotify = barNotify;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getCashierNo() {
		return cashierNo;
	}
	public void setCashierNo(String cashierNo) {
		this.cashierNo = cashierNo;
	}
	public String getOrgNo() {
		return orgNo;
	}
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}
	public String getShowUrl() {
		return showUrl;
	}
	public void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}
	public String getPayBusType() {
		return payBusType;
	}
	public void setPayBusType(String payBusType) {
		this.payBusType = payBusType;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getUser_order_no() {
		return user_order_no;
	}
	public void setUser_order_no(String user_order_no) {
		this.user_order_no = user_order_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
