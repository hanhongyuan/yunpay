package com.yunpay.wx.rep.card;

import com.yunpay.common.utils.EnumUtil.ResultCode;

public class CreateQrCodeRep extends AppBaseRep{
	
	//二维码ticket,可在有效期内获取二维码图片
	private String ticket;
	//二维码有效期
	private String expire_seconds;
	//二维码图片解析后的地址
	private String url;
	//二维码显示地址，点击后跳转二维码页面
	private String show_qrcode_url;
	
	/**
	 * 构造成功结果
	 * @param ticket
	 * @param expireSeconds
	 * @param url
	 * @param showQrcodeUrl
	 */
	public CreateQrCodeRep(String ticket,String expireSeconds,String url,String showQrcodeUrl){
		setReturn_code(ResultCode.SUCCESS.getCode());
		setTicket(ticket);
		setExpire_seconds(expireSeconds);
		setUrl(url);
		setShow_qrcode_url(showQrcodeUrl);
	}
	
	/**
	 * 构造失败结果
	 * @param errCode
	 * @param errCodeDes
	 */
	public CreateQrCodeRep(String errCode,String errCodeDes){
		super(errCode,errCodeDes);
	}
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShow_qrcode_url() {
		return show_qrcode_url;
	}
	public void setShow_qrcode_url(String show_qrcode_url) {
		this.show_qrcode_url = show_qrcode_url;
	}
	
	
	
}
