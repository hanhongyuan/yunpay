package com.yunpay.ali.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.yunpay.common.utils.Log;


public class AlipayUtil {
	/**
	 * @Description: 除去数组中的空值和签名参数
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月4日上午11:15:59 
	 * @param sArray
	 * @return
	 */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>();
        if (sArray == null || sArray.size() <= 0) {
            return null;
        }
        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (StringUtils.isEmpty(value) || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
        return result;
    }

    /**
     * @Description: 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @author:   Zeng Dongcheng
     * @Date:     2017年7月4日上午11:16:34 
     * @param params
     * @return
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
    
    /**
     * 根据反馈回来的信息，生成签名结果
     * @param Params 通知返回来的参数数组
     * @param sign 比对的签名结果
     * @return 生成的签名结果
     */
	public static boolean getRSASignVerify(Map<String, String> Params, String sign,String publicKey) {
    	//过滤空值、sign与sign_type参数
    	Map<String, String> sParaNew = AlipayUtil.paraFilter(Params);
        //获取待签名字符串
        String preSignStr = AlipayUtil.createLinkString(sParaNew);
        Log.debug("支付宝异步通知待签名数据："+preSignStr);
        //获得签名验证结果
        boolean isSign = false;
		try {
			isSign = AlipaySignature.rsaCheckContent(preSignStr, sign, publicKey,"GBK");
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return isSign;
    }
}
