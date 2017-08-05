package com.yunpay.permission.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作员类型
 *
 * 深圳市前海汇商惠电子商务有限公司
 * 
 * 
 */
public enum UserTypeEnum {

	/** 普通用户 **/
	USER("普通用户"),
	/** 超级管理员 **/
	ADMIN("超级管理员"),
	/** 代理商 **/
	AGENT("代理商");

	/** 描述 */
	private String desc;

	private UserTypeEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static UserTypeEnum getEnum(String value) {
		UserTypeEnum resultEnum = null;
		UserTypeEnum[] enumAry = UserTypeEnum.values();
		for (int i = 0; i < enumAry.length; i++) {
			if (enumAry[i].name().equals(value)) {
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}

	public static Map<String, Map<String, Object>> toMap() {
		UserTypeEnum[] ary = UserTypeEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].name()));
			map.put("value", ary[num].name());
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList() {
		UserTypeEnum[] ary = UserTypeEnum.values();
		List list = new ArrayList();
		for (int i = 0; i < ary.length; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("value", ary[i].name());
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}

}
