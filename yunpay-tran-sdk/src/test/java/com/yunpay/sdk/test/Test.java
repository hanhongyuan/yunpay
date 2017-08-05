package com.yunpay.sdk.test;

import com.yunpay.common.utils.EnumUtil.PayStatus;

public class Test {
	public static void main(String args[]){
		System.out.println(PayStatus.valueOf("UNPAY").getValue());
	}
}
