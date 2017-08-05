package com.yunpay.wx.req.pay;

import com.yunpay.common.utils.CommonUtil;

public class WechatWapReq extends WechatQrReq{
	//订单描述(必须)
    private String body = "";
    //商品详情
    private String detail = "";
    //附加信息
    private String attach = "";
    //交易金额(必须)
    private int total_fee = 0;
    //货币类型
  	private String fee_type = "";
    //提交订单ip(必须)
    private String spbill_create_ip = "";
    //订单优惠标记
    private String goods_tag = "";
    //指定支付方式
   	private String limit_pay = "";
	//交易起始时间
	private String time_start = "";
	//交易结束时间
	private String time_expire = "";
	//交易结果通知地址(必须)
	private String notify_url = "";
	//交易类型(必须)(JSAPI，NATIVE，APP)
	private String trade_type = "";
	//商品ID(否)
	private String product_id = "";
	//用户标识(否)trade_type=JSAPI，此参数必传
	private String openid = "";
	
	/**
	 * 构造扫码支付请求实体类
	 * 请求参数说明请参考该实体类和父类属性说明
	 * @param appId
	 * @param merchId
	 * @param subMerchId
	 * @param outTradeNo
	 * @param totalFee
	 * @param body
	 * @param deviceInfo
	 * @param spBillCreateIP
	 * @param goodsTag
	 * @param nonceStr
	 * @param attach
	 * @param notifyUrl
	 */
	public WechatWapReq(String appId,String merchId,String subMerchId,String outTradeNo,
			int totalFee, String body,String deviceInfo,String spBillCreateIP,
			String goodsTag,String attach,String notifyUrl,String openId) {
		//微信分配的公众号ID（开通公众号之后可以获取到）
		setAppid(appId);
		//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		setMch_id(merchId);
		//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		setSub_mch_id(subMerchId);
		//随机字符串，不长于32 位
		setNonce_str(CommonUtil.getRandomStringByLength(32));
		//要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
		setBody(body); 
		//商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
		setOut_trade_no(outTradeNo); // 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
		//订单总金额，单位为“分”，只能整数
		setTotal_fee(totalFee);	
		// 订单生成的机器IP
		setSpbill_create_ip(spBillCreateIP);
		//接收微信支付异步通知回调地址
		setNotify_url(notifyUrl);
		//取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
		setTrade_type("JSAPI");
		//trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
		setProduct_id(outTradeNo);
		//****************非必填选项***************************
		//商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
		setDevice_info(deviceInfo);
		//支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回，有助于商户自己可以注明该笔消费的具体内容，方便后续的运营和记录
		setAttach(attach);
		// 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
		setGoods_tag(goodsTag);
		//用户openId
		setOpenid(openId);
	}
	
	/**
	 * 构造扫码支付请求实体类
	 * 请求参数说明请参考该实体类和父类属性说明
	 * @param appId
	 * @param merchId
	 * @param subMerchId
	 * @param outTradeNo
	 * @param totalFee
	 * @param body
	 * @param deviceInfo
	 * @param spBillCreateIP
	 * @param goodsTag
	 * @param nonceStr          32位随机字串
	 * @param attach			附件信息
	 * @param notifyUrl			交易结果通知地址
	 * @param timeStart			订单生成日期yyyyMMddHHmmss
	 * @param timeExpire		订单生效截止日期yyyyMMddHHmmss
	 */
	public WechatWapReq(String appId,String merchId,String subMerchId,String outTradeNo,
			int totalFee, String body,String spBillCreateIP,
			String goodsTag,String attach,String notifyUrl,
			String timeStart,String timeExpire,String openId) {
		//微信分配的公众号ID（开通公众号之后可以获取到）
		setAppid(appId);
		//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		setMch_id(merchId);
		//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
		setSub_mch_id(subMerchId);
		//随机字符串，不长于32 位
		setNonce_str(CommonUtil.getRandomStringByLength(32));
		//要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
		setBody(body); 
		//商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
		setOut_trade_no(outTradeNo); // 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
		//订单总金额，单位为“分”，只能整数
		setTotal_fee(totalFee);	
		// 订单生成的机器IP
		setSpbill_create_ip(spBillCreateIP);
		//接收微信支付异步通知回调地址
		setNotify_url(notifyUrl);
		//取值如下：JSAPI，NATIVE，APP，WAP,详细说明见参数规定
		setTrade_type("JSAPI");
		//trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
		setProduct_id(outTradeNo);
		//****************非必填选项***************************
		//支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回，有助于商户自己可以注明该笔消费的具体内容，方便后续的运营和记录
		setAttach(attach);
		// 订单生成时间， 格式为yyyyMMddHHmmss，如2009年12 月25 日9 点10 分10
		// 秒表示为20091225091010。时区为GMT+8 beijing。该时间取自商户服务器
		setTime_start(timeStart);
		// 订单失效时间，格式同上yyyyMMddHHmmss
		setTime_expire(timeExpire);
		// 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
		setGoods_tag(goodsTag);
		//用户openId
		setOpenid(openId);
	}

	
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
