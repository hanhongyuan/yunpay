package com.yunpay.permission.entity;

import java.util.Date;
/**
 * 类名称		      商户卡券实体类
 * 文件名称:     Card.java
 * 内容摘要: 
 * @author:   Zhao Xiaoman
 * @version:  1.0  
 * @Date:     2017年6月20日上午10:01:56
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日   Zhao Xiaoman       1.0       新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class Card {
	  private Integer id;//卡券Id
	  private String title;//卡券标题
	  private String cardColor;//卡券颜色
	  private String subtitle;//卡券副标题
	  private Integer type;//卡券类型 1、通用券 2、折扣券 3、代金券 4、礼品券 5、团购券
	  private Integer number;//卡券数量
	  private Integer inventory;//卡券库存
	  private String background;//卡券背景颜色
	  private String logo;//卡券logo
	  private Date startDate;//有效期开始时间
	  private Date endDate;//有效期结束时间
	  private String tel;//客服电话
	  private String operation;//操作说明使用须知
	  private String merchant;//商户信息
	  private Date createdAt;//产生时间
	  private Date updatedAt;//修改时间	  
	  private Double discount;//折扣额度
	  private Integer limitNum;//领券限制
	  private String share;//卡券分享1:用户可以分享领券链接;2:用户领券后可转赠其他好友 ;3 两个都选
	  private String notice;//操作提示
	  private Integer status;//状态，1：待审核，2审核未通过，3审核通过
	  private String putchannel;//投放平台:1、微信；2、支付宝
	  private String merNo;//商户编码
	  private String url;//二维码地址
	  private String merchantName;//卡券上显示的商户名称
	  private String detail;//优惠详情
	  private Integer useCondition;//使用条件：0、不与其他优惠券同享;1、与其他优惠券同享
	  private Integer wifi;//是否支持WIFI，0表示不支持，1表示支持
	  private Integer parking;//是否支持停车，0表示不支持，1表示支持
	  private Integer acceptPet;//是否接受宠物入内，0表示不接受，1表示接受
	  private Integer delivery;//是否支持外卖，0表示不支持，1表示支持
	  private String aliBackImg;//支付宝海报图片
	  
	  //以下两个变量非数据库字段，仅用于查询时接受数据
	  private String date_begin;//查询开始时间
	  private String date_end;//查询结束时间
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getCardColor()
	{
		return cardColor;
	}
	public void setCardColor(String cardColor)
	{
		this.cardColor = cardColor;
	}
	public String getSubtitle()
	{
		return subtitle;
	}
	public void setSubtitle(String subtitle)
	{
		this.subtitle = subtitle;
	}
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
	}
	public Integer getNumber()
	{
		return number;
	}
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	public Integer getInventory()
	{
		return inventory;
	}
	public void setInventory(Integer inventory)
	{
		this.inventory = inventory;
	}
	public String getBackground()
	{
		return background;
	}
	public void setBackground(String background)
	{
		this.background = background;
	}
	public String getLogo()
	{
		return logo;
	}
	public void setLogo(String logo)
	{
		this.logo = logo;
	}
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
	public Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	public String getOperation()
	{
		return operation;
	}
	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	public String getMerchant()
	{
		return merchant;
	}
	public void setMerchant(String merchant)
	{
		this.merchant = merchant;
	}
	public Date getCreatedAt()
	{
		return createdAt;
	}
	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt()
	{
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt)
	{
		this.updatedAt = updatedAt;
	}
	public Double getDiscount()
	{
		return discount;
	}
	public void setDiscount(Double discount)
	{
		this.discount = discount;
	}
	public Integer getLimitNum()
	{
		return limitNum;
	}
	public void setLimitNum(Integer limitNum)
	{
		this.limitNum = limitNum;
	}
	public String getShare()
	{
		return share;
	}
	public void setShare(String share)
	{
		this.share = share;
	}
	public String getNotice()
	{
		return notice;
	}
	public void setNotice(String notice)
	{
		this.notice = notice;
	}
	public Integer getStatus()
	{
		return status;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	public String getPutchannel()
	{
		return putchannel;
	}
	public void setPutchannel(String putchannel)
	{
		this.putchannel = putchannel;
	}
	public String getMerNo()
	{
		return merNo;
	}
	public void setMerNo(String merNo)
	{
		this.merNo = merNo;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getMerchantName()
	{
		return merchantName;
	}
	public void setMerchantName(String merchantName)
	{
		this.merchantName = merchantName;
	}
	public String getDetail()
	{
		return detail;
	}
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	public Integer getUseCondition()
	{
		return useCondition;
	}
	public void setUseCondition(Integer useCondition)
	{
		this.useCondition = useCondition;
	}
	public Integer getWifi()
	{
		return wifi;
	}
	public void setWifi(Integer wifi)
	{
		this.wifi = wifi;
	}
	public Integer getParking()
	{
		return parking;
	}
	public void setParking(Integer parking)
	{
		this.parking = parking;
	}
	public Integer getAcceptPet()
	{
		return acceptPet;
	}
	public void setAcceptPet(Integer acceptPet)
	{
		this.acceptPet = acceptPet;
	}
	public Integer getDelivery()
	{
		return delivery;
	}
	public void setDelivery(Integer delivery)
	{
		this.delivery = delivery;
	}
	public String getDate_begin()
	{
		return date_begin;
	}
	public void setDate_begin(String date_begin)
	{
		this.date_begin = date_begin;
	}
	public String getDate_end()
	{
		return date_end;
	}
	public void setDate_end(String date_end)
	{
		this.date_end = date_end;
	}
	public String getAliBackImg()
	{
		return aliBackImg;
	}
	public void setAliBackImg(String aliBackImg)
	{
		this.aliBackImg = aliBackImg;
	}	  
}
