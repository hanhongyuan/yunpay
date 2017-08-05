package com.yunpay.permission.entity;

import java.util.Date;
/**
 * 类名称		       商户卡券领取信息实体类
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
public class CardReceive {
	  private Integer id;//所领取的每张卡券id
	  private String appidUserId;//领取该卡券的会员Id
	  private String title;//卡券名称
	  private Integer status;//状态，0：未使用，1：已使用，2：已过期,3:已删除
	  private Integer cardId;//卡券id，关联t_card_template
	  private Date createdAt;//产生时间
	  private Date startTime;//有效期开始时间
	  private Date endTime;//有效期结束时间
	  private Double quota;//使用的消费额度限制
	  private Date useTime;//使用时间
	  
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
	public String getAppidUserId()
	{
		return appidUserId;
	}
	public void setAppidUserId(String appidUserId)
	{
		this.appidUserId = appidUserId;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public Integer getStatus()
	{
		return status;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	public Integer getCardId()
	{
		return cardId;
	}
	public void setCardId(Integer cardId)
	{
		this.cardId = cardId;
	}
	public Date getCreatedAt()
	{
		return createdAt;
	}
	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}
	public Date getStartTime()
	{
		return startTime;
	}
	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}
	public Date getEndTime()
	{
		return endTime;
	}
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	public Double getQuota()
	{
		return quota;
	}
	public void setQuota(Double quota)
	{
		this.quota = quota;
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
	public Date getUseTime()
	{
		return useTime;
	}
	public void setUseTime(Date useTime)
	{
		this.useTime = useTime;
	}
	  

}
