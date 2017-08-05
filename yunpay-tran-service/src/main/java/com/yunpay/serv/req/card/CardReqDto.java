package com.yunpay.serv.req.card;

/**
 * 创建卡券请求参数
 * 文件名称:     CardReqDto.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年8月3日下午5:00:30 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年8月3日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class CardReqDto {
	/***************必传项部分************/
	//商户号
	private String merchant_num;
	//商户名称
	private String merchant_name;
	//卡券类型
	private String card_type;
	//卡券logo
	private String login_url;
	//卡券领取码类型
	private String code_type;
	//卡券标题
	private String title;
	//卡券颜色
	private String color;
	//卡券使用提醒
	private String notice;
	//卡券使用说明
	private String description;
	//发行数量
	private String quantity;
	//生效时间类型
	private String card_date_type;
	//表示自领取后多少天内有效(不支持0)
	private Integer fixed_term;
	//表示自领取后多少天开始生效，0表示领取后当天生效
	private Integer fixed_begin_term;
	//卡券有效期(始)
	private String begin_timestamp;
	//卡券有效期(止)
	private String end_timestamp;
	
	/***************条件必传部分************/
	//card_type=GROUPON时必传
	//团购券详情 
	private String deal_detail;
	
	//card_type=CASH时必传
	//满足该金额可用
	private Integer least_cost;
	//减免金额
	private Integer reduce_cost;
	
	//card_type=DISCOUNT时必传
	//折扣 传30表示7折
	private Integer discount;
	
	//card_type=GIFT时必传
	//填写兑换内容的名称
	private String gift;
	
	//card_type=GENERAL_COUPON时必传
	//填写优惠详情
	private String default_detail;
	
	/***************非必传项部分************/
	//客服电话
	private String service_phone;
	//领券数量限制
	private Integer get_limit=1;
	//核券数量限制
	private Integer use_limit=1;
	//卡券能否分享
	private String can_share="1";
	//卡券可否转赠
	private String can_give_friend="1";
	
	
	public String getMerchant_num() {
		return merchant_num;
	}
	public void setMerchant_num(String merchant_num) {
		this.merchant_num = merchant_num;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getLogin_url() {
		return login_url;
	}
	public void setLogin_url(String login_url) {
		this.login_url = login_url;
	}
	public String getCode_type() {
		return code_type;
	}
	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBegin_timestamp() {
		return begin_timestamp;
	}
	public void setBegin_timestamp(String begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}
	public String getEnd_timestamp() {
		return end_timestamp;
	}
	public void setEnd_timestamp(String end_timestamp) {
		this.end_timestamp = end_timestamp;
	}
	public String getService_phone() {
		return service_phone;
	}
	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}
	public Integer getGet_limit() {
		return get_limit;
	}
	public void setGet_limit(Integer get_limit) {
		this.get_limit = get_limit;
	}
	public Integer getUse_limit() {
		return use_limit;
	}
	public void setUse_limit(Integer use_limit) {
		this.use_limit = use_limit;
	}
	public String getCan_share() {
		return can_share;
	}
	public void setCan_share(String can_share) {
		this.can_share = can_share;
	}
	public String getCan_give_friend() {
		return can_give_friend;
	}
	public void setCan_give_friend(String can_give_friend) {
		this.can_give_friend = can_give_friend;
	}
	public String getDeal_detail() {
		return deal_detail;
	}
	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}
	public Integer getLeast_cost() {
		return least_cost;
	}
	public void setLeast_cost(Integer least_cost) {
		this.least_cost = least_cost;
	}
	public Integer getReduce_cost() {
		return reduce_cost;
	}
	public void setReduce_cost(Integer reduce_cost) {
		this.reduce_cost = reduce_cost;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public String getDefault_detail() {
		return default_detail;
	}
	public void setDefault_detail(String default_detail) {
		this.default_detail = default_detail;
	}
	
	public String getCard_date_type() {
		return card_date_type;
	}
	public void setCard_date_type(String card_date_type) {
		this.card_date_type = card_date_type;
	}
	public Integer getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(Integer fixed_term) {
		this.fixed_term = fixed_term;
	}
	public Integer getFixed_begin_term() {
		return fixed_begin_term;
	}
	public void setFixed_begin_term(Integer fixed_begin_term) {
		this.fixed_begin_term = fixed_begin_term;
	}
	
	
}
