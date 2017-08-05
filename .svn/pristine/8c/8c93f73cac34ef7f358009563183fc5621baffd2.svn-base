package com.yunpay.permission.entity;

import java.util.Map;

/**
 * 
 * 功能： 作者： 柳伟华 公司： 汇商宏业 日期： 2013-4-18下午02:17:16
 * 
 * @版本： V1.0
 * @修改：
 */

public class BranchLevel {

	public static Map<String, String> map = new java.util.LinkedHashMap<String, String>();

	public enum ebranchType {
		ALL("0", "一级部门"), FENSHE("1", "二级部门"), YINGYETING("3", "三级部门");

		public String key;
		public String value;

		private ebranchType(String key, String value) {
			this.key = key;
			this.value = value;
		}

	}

	static {
		for (ebranchType ent : ebranchType.values()) {
			map.put(ent.key, ent.value);
		}
	}

}
