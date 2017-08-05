package com.yunpay.permission.Utils;

import java.text.DecimalFormat;

/**
 * 用于转换类型
 * 
 * */
public class FloatUtil {

    /**
     * 将String转成float再转成String返回去
     * str 需要转换的string
     * len 保留小数点后的位数
     * */
    public static String Stringtofloat(String str,int len){
        
        /*String fmt ="0.";
        for (int i = 0; i < len; i++) {
            fmt += "0";
        }/*
        //当传进来的数据为0 空  ""的时候不予处理
        if(str.equals("") || str == "0" || str == null || len == 1){
            return str;
        }*/
        DecimalFormat decimalFormat=new DecimalFormat("##0.00");
        String  formatResult=decimalFormat.format(Float.parseFloat(str));
        return formatResult;
     } 
    
//    /**
//     * 将两个String转成float进行加减再转成String返回去
//     * str1 需要转换的string1
//     * str2 需要转换的string2
//     * sta  1为加法 2为减法
//     * */
//    public static String StringReckon(String str1,String str2,String sta){
//        
//        //当传进来的数据为空  ""的时候不予处理
//        if(str1.equals("") || str1 == null || str2.equals("") || str2 == null ){
//            return "";
//        }
//        System.out.println("转前：");
//        System.out.println(str1);
//        System.out.println(str2);
//        System.out.println("转后：");
//        System.out.println(Float.parseFloat(str1));
//        System.out.println(Float.parseFloat(str2));
//        float a = 0;
//        if(sta.equals("1")){
//            System.out.println("加法");
//            a = Float.parseFloat(str1) + Float.parseFloat(str2);
//        }
//        
//        if (sta.equals("2")) {
//            System.out.println("减法");
//            a = Float.parseFloat(str1) + Float.parseFloat(str2);
//        }
//       
//        DecimalFormat decimalFormat=new DecimalFormat("##0.00");
//        String  formatResult=decimalFormat.format(a);
//        System.out.println("结果" + formatResult);
//        return formatResult;
//     }
}
