package com.yunpay.permission.entity;

public class Address {
	/**
	 * 
	 * 文件名称:
	 * 内容摘要: 用于显示省市区级联数据的实体类,关联表：t_sys_area; sys_address
	 * @author:   duan zhang quan
	 * @version:  1.0  
	 * @Date:     2017年4月14日上午9:56:12 
	 * 修改历史:  
	 * 修改日期             修改人员            版本	     修改内容  
	 * ----------------------------------------------  
	 * 2017年6月12日     duan zhang quan   1.0     新建
	 *
	 * 版权:   版权所有(C)2017
	 * 公司:   深圳市至高通信技术发展有限公司
	 */
	private int id;  // 主键
	private String title;  // 省市区名称
	private int porder;    // 顺序
	private int parentid;  // 父id
	private String code;   // 区号
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPorder() {
		return porder;
	}
	public void setPorder(int porder) {
		this.porder = porder;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
