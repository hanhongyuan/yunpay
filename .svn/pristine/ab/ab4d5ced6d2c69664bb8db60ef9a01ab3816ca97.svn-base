package com.yunpay.wx.req.pay;

import com.yunpay.common.utils.CommonUtil;


/**
 * 微信条码(刷卡)支付请求类(商户扫用户)
 * 文件名称:     ScanPayReqData.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月16日下午3:39:24 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月16日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class WechatBarReq extends WechatQrReq{
	//订单描述(必须)
    private String body = "";
    //商品详情
    private String detail = "";
    //附加信息
    private String attach = "";
    //交易金额(必须)
    private int total_fee = 0;
    //货币类型
  	private String fee_type = "";
    //提交订单ip(必须)
    private String spbill_create_ip = "";
    //订单优惠标记
    private String goods_tag = "";
    //指定支付方式
   	private String limit_pay = "";
    //支付码
    private String auth_code = "";
    
    /**
     * 无参实例
     */
    public WechatBarReq(){
    	super();
    }
    
    /**
     * 构造条码支付请求实体
     * @param appId
     * @param merchId
     * @param subMerchId
     * @param outTradeNo
     * @param authCode
     * @param totalFee
     * @param body
     * @param deviceInfo
     * @param spBillCreateIP
     * @param goodsTag
     * @param attach
     */
	public WechatBarReq(String appId,String merchId,String subMerchId,String outTradeNo,String authCode, 
			int totalFee, String body,String deviceInfo,String spBillCreateIP,
			String goodsTag,String attach) {
    	//微信分配的公众号ID（开通公众号之后可以获取到）
    	setAppid(appId);
    	//微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
    	setMch_id(merchId);
    	//子商户微信支付分配的商户号ID（开通公众号的微信支付功能之后可以获取到）
    	setSub_mch_id(subMerchId);
    	//这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
    	//调试的时候可以在微信上打开“钱包”里面的“刷卡”，将扫码页面里的那一串14位的数字输入到这里来，进行提交验证
    	//记住out_trade_no这个订单号可以将这一笔支付进行退款
    	setAuth_code(authCode);
    	//要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
    	setBody(body);
    	//支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回，有助于商户自己可以注明该笔消费的具体内容，方便后续的运营和记录
    	setAttach(attach);
    	//商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
    	setOut_trade_no(outTradeNo);
    	//订单总金额，单位为“分”，只能整数
    	setTotal_fee(totalFee);
    	//商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
    	setDevice_info(deviceInfo);
    	//订单生成的机器IP
    	setSpbill_create_ip(spBillCreateIP);
    	//商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
    	setGoods_tag(goodsTag);
    	//随机字符串，不长于32 位
    	setNonce_str(CommonUtil.getRandomStringByLength(32));
    	//根据API给的签名规则进行签名
    	//String sign = CommonUtil.getSign(CommonUtil.toMap(this),apiSecret);
    	//setSign(sign);//把签名数据设置到Sign这个属性中
    }

	
	
    public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public int getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    /*
    public Map<String,String> toMap(){
    	Class curClass = this.getClass();
        Map<String,String> map = new HashMap<String, String>();
        Field[] fields = curClass.getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if (field.getType() == String.class) {
            		map.put(field.getName(), (String) obj);
				} else {
					map.put(field.getName(), String.valueOf(obj));
				}
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Class superClass = curClass.getSuperclass();// 父类
        Field[] supperfields = superClass.getDeclaredFields();
        for (Field field : supperfields) {
        	field.setAccessible(true);
            try {
            	Object obj = field.get(this);
                if (field.getType() == String.class) {
            		map.put(field.getName(), (String) obj);
				} else {
					map.put(field.getName(), String.valueOf(obj));
				}
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
   	*/
}
