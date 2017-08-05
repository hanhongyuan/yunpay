package com.yunpay.serv.model;

import java.util.Date;

public class CardInfo {
	private Integer id;

	private String title;

	private String cardColor;

	private String subtitle;

	private Integer type; 				// 卡券类型 1：通用券  2、折扣券 3、代金券 4、礼品券 5、团购券
	
	private String orgNo;				//组织结构编码
	
	private String merNo;				//商户编号
	
	private Integer number;

	private Integer inventory;

	private Integer limitNum;

	private String background;

	private String logo;

	private Date startDate;

	private Date endDate;

	private String tel;

	private String operation;

	private String merchant;
	
	private String merchantName;			//卡券上显示的商户名称
	
	private String detail;					//优惠详情
	
	private String codetype;				//显示类型
	
	private String promotion_url_name;		//更多详情
	
	private String promotion_url;			//更多详情URL

	private Date createdAt;

	private Date updatedAt;

	private Double discount;				// 折扣额度
	
	private Double discountMoney;			// 抵扣金额
	
	private Double limitMoney;				// 达到最低金额抵扣
	
	private String customtitle;				// 自定义标题

	private String share;					// 卡券分享

	private String notice;					// 操作提示
	
	private String urltitle;				// 入口名称
	
	private String urldesc;					// 引导语
	
	private String urlcontent;				// 入口名称

	private Integer status;    				//1：待审核，2审核未通过，3审核通过
	
	private Integer defaultSend;    		//0：不投放，1投放  支付宝设置关注默认投放
	
	private String putchannel;				//投放平台
	
	private String weixin_card_id; 			//微信卡券ID 
	
	private String weixin_show_qrcode_url; 	//微信卡券二维码地址
	
	private String url;							//微信二位码地址
	
	private String  cardType; 				//卡券类型
	
	private String  alipassTemplateId;      //支付宝卡券模板ID
	
	private String  aliBackImg;				//支付宝卡券背景海报
	
	private String appId;    		//支付宝appID
	
	private Integer couponsType;    			//0 :普通券 ，1：朋友的券
	
	private String text_image_list;    			//朋友的券图文介绍
	
	private String time_limit;    				//时间限制
	
	private String use_condition;    			//朋友的券图文介绍
	
	private String accept_category;				//指定可用的商品类目
	
	private String reject_category;				//指定不可用的商品类目
	
	private String location_id_list;			//适用门店
	
	private String consume_share_card_list;		//核销后赠送卡券字段
	
	private String business_service;			//商家服务类型
	
	private boolean can_use_with_other_discount;				//不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写不可与其他优惠共享，默认为true
	
	private Integer deleteStatus;	// 是否删除（0否，1是）
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getCardColor() {
		return cardColor;
	}

	public void setCardColor(String cardColor) {
		this.cardColor = cardColor == null ? null : cardColor.trim();
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle == null ? null : subtitle.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background == null ? null : background.trim();
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo == null ? null : logo.trim();
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation == null ? null : operation.trim();
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant == null ? null : merchant.trim();
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getUrltitle() {
		return urltitle;
	}

	public void setUrltitle(String urltitle) {
		this.urltitle = urltitle;
	}

	public String getUrldesc() {
		return urldesc;
	}

	public void setUrldesc(String urldesc) {
		this.urldesc = urldesc;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(Double discountMoney) {
		this.discountMoney = discountMoney;
	}

	public Double getLimitMoney() {
		return limitMoney;
	}

	public void setLimitMoney(Double limitMoney) {
		this.limitMoney = limitMoney;
	}

	public String getCustomtitle() {
		return customtitle;
	}

	public void setCustomtitle(String customtitle) {
		this.customtitle = customtitle;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPutchannel() {
		return putchannel;
	}

	public void setPutchannel(String putchannel) {
		this.putchannel = putchannel;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	public String getWeixin_card_id() {
		return weixin_card_id;
	}

	public void setWeixin_card_id(String weixin_card_id) {
		this.weixin_card_id = weixin_card_id;
	}

	public String getWeixin_show_qrcode_url() {
		return weixin_show_qrcode_url;
	}

	public void setWeixin_show_qrcode_url(String weixin_show_qrcode_url) {
		this.weixin_show_qrcode_url = weixin_show_qrcode_url;
	}

	public String getUrlcontent() {
		return urlcontent;
	}

	public void setUrlcontent(String urlcontent) {
		this.urlcontent = urlcontent;
	}

	
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAlipassTemplateId() {
		return alipassTemplateId;
	}

	public void setAlipassTemplateId(String alipassTemplateId) {
		this.alipassTemplateId = alipassTemplateId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCodetype() {
		return codetype;
	}

	public void setCodetype(String codetype) {
		this.codetype = codetype;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public String getAliBackImg() {
		return aliBackImg;
	}

	public void setAliBackImg(String aliBackImg) {
		this.aliBackImg = aliBackImg;
	}

	public Integer getDefaultSend() {
		return defaultSend;
	}

	public void setDefaultSend(Integer defaultSend) {
		this.defaultSend = defaultSend;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getCouponsType() {
		return couponsType;
	}

	public void setCouponsType(Integer couponsType) {
		this.couponsType = couponsType;
	}

	public String getText_image_list() {
		return text_image_list;
	}

	public void setText_image_list(String text_image_list) {
		this.text_image_list = text_image_list;
	}

	public String getUse_condition() {
		return use_condition;
	}

	public void setUse_condition(String use_condition) {
		this.use_condition = use_condition;
	}

	public String getAccept_category() {
		return accept_category;
	}

	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getReject_category() {
		return reject_category;
	}

	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}

	public boolean isCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}

	public void setCan_use_with_other_discount(boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}

	public String getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(String time_limit) {
		this.time_limit = time_limit;
	}

	public String getLocation_id_list() {
		return location_id_list;
	}

	public void setLocation_id_list(String location_id_list) {
		this.location_id_list = location_id_list;
	}

	public String getConsume_share_card_list() {
		return consume_share_card_list;
	}

	public void setConsume_share_card_list(String consume_share_card_list) {
		this.consume_share_card_list = consume_share_card_list;
	}

	public String getBusiness_service() {
		return business_service;
	}

	public void setBusiness_service(String business_service) {
		this.business_service = business_service;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
}
