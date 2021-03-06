package com.yunpay.common.utils;

/**
 * 系统枚举
 * 文件名称:     EnumUtils.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年6月20日下午2:36:05 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年6月20日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class EnumUtil {
	
	/**
	 * 支付渠道
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月20日下午1:57:11 
	 */
	public enum PayChannel {
		//支付宝
		ALIPAY("alipay",1),
		//微信
		WECHAT("wechat",2),
		//银联
		UNION("union",3);
		
		private String name;
		private Integer value;
		//构造方法
	    private PayChannel(String name,Integer value) {
	    	this.name = name;
	    	this.value = value;
	    }
	    
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Integer getValue() {
			return value;
		}
		
		public void setValue(Integer value) {
			this.value = value;
		}
	}
	
	/**
	 * 支付方式
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月20日下午1:57:11 
	 */
	public enum  SubChannel {
		ALIPAY_WAP("支付宝Wap",0),ALIPAY_BAR("支付宝条码支付",1),ALIPAY_SCAN("支付宝扫码支付",2),
		WACHT_WAP("微信Wap",3),WACHAT_BAR("微信条码支付",4),WACHAT_SCAN("微信扫码支付",5),
		ALIPAY_DIRECT("支付宝及时支付",6),
		UNION_WAP("银联Wap",7),UNION_BAR("银联条码支付",8),UNION_SCAN("银联扫码支付",9);
		
		private String name;
		private Integer value;
		
	    private SubChannel(String name,Integer value){
	    	this.value = value;
	    	this.name = name;
	    }
	    //构造方法
	    private SubChannel(Integer value) {
	    	this.value = value;
	    }
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		public Integer getValue() {
			return value;
		}
		
		public void setValue(Integer value) {
			this.value = value;
		}

		
	}
	
	/**
	 * 返回结果
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月20日下午1:57:11 
	 */
	public enum ResultCode{
		SUCCESS("SUCCESS","成功"),	
		FAIL("FAIL","失败"),	//失败
		EXCEPTION("ERR","系统异常"),
		PROCCESSING("PROC","处理中");
		
		//构造方法
	    private ResultCode(String code, String des) {
	    	this.code = code;
	    	this.des = des;
	    }
		
		private String code;
		private String des;
		
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getDes() {
			return des;
		}
		public void setDes(String des) {
			this.des = des;
		}
	}
	
	/**
	 * 交易类型0：支付 1：退款
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月20日下午1:57:11 
	 */
	public enum TransType{
		PAY(0),REFUND(1);
		private Integer value;
		//构造方法
	    private TransType(Integer value) {
	     this.value = value;
	    }
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
	}
	
	/**
	 * 退款状态
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月20日下午1:57:11 
	 */
	public enum RefundStatus{
		UNREFUND(0,"发起退款"),REFUNDING(1,"退款中"),REFUNDED(2,"已退款"),FAILREFUND(3,"退款失败");
		
		private Integer value;
		private String name;
		
		//构造方法
	    private RefundStatus(Integer value,String name) {
	    	this.value = value;
	    	this.name = name;
	    }
		
		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public enum PayStatus{
		UNPAY(0,"未支付"),PAYING(1,"支付中"),PAYED(2,"已支付"),REFUNDED(3,"已退款"),
			REFUNDING(4,"退款中"),FAILREFUND(5,"退款失败"),FAILPAY(6,"支付失败"),CANCEL(7,"已撤销"),
			CLOSED(8,"已关闭"),UNKNOWN(9,"状态未知");
		private Integer value;
		private String name;
		//构造方法
	    private PayStatus(Integer value,String name) {
	    	this.value = value;
	    	this.name = name;
	    }
		
		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	/**
	 * @Description: 根据value获取支付状态name
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月7日上午10:14:06 
	 * @param value
	 * @return
	 */
    public static String getPayStatusNameByValue(int value) {  
    	PayStatus[] enums = PayStatus.values();  
        for (int i = 0; i < enums.length; i++) {  
            if (enums[i].getValue()==value) {  
                return enums[i].getName();  
            }  
        }  
        return "";  
    } 
    
    /**
     * @Description: 根据value获取退款状态name
     * @author:   Zeng Dongcheng
     * @Date:     2017年7月11日下午3:08:40 
     * @param value
     * @return
     */
    public static String getRefundStatusByValue(int value){
    	RefundStatus[] enums = RefundStatus.values();
    	 for (int i = 0; i < enums.length; i++) {  
             if (enums[i].getValue()==value) {  
                 return enums[i].getName();  
             }  
         }  
         return "";  
    }
	
	/**
	 * 错误码
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月20日下午1:57:11 
	 */
	public enum  ErrorCode {
		PARAM_IS_NULL("PARAM_IS_NULL","传递参数为空"),
		ORDER_NOT_EXIST("ORDER_NOT_EXIST","支付流水订单不存在"),
		SYSTEM_EXCEPTION("SYSTEM_EXCEPTION","系统错误"),
		ILLEGAL_SIGN_TYPE("ILLEGAL_SIGN_TYPE","签名类型错误"),
		ILLEGAL_MERCHANT_NUM("ILLEGAL_MERCHANT_NUM","商户号不存在"),
		ILLEGAL_SIGN("ILLEGAL_SIGN","签名错误"),
		ILLEGAL_PAYCONFIG("ILLEGAL_PAYCONFIG","支付信息未配置"),
		USER_ORDER_NO_EXIST("USER_ORDER_NO_EXIST","商户订单号已存在"),
		
		SYSCASHIER_NOT_EXIST("SYSCASHIER_NOT_EXIST","收银员不存在"),
		PARENT_PAYCONFIG_NOT_FIND("PARENT_PAYCONFIG_NOT_FIND","无服务商支付信息配置"),
		USER_CARD_ERROR("USER_CARD_ERROR","卡券核销错误"),
		USER_TOTALFEE_ERROR("USER_TOTALFEE_ERROR","卡券核销后无需支付"),
		TRADE_FAIL("TRADE_FAIL","交易失败"),
		USER_ORDER_NO_NOT_EXIST("USER_ORDER_NO_NOT_EXIST","商户订单号不存在"),
		REFUNDED("REFUNDED","已退款，不可重复退款"),
		CANCELED("CANCELED","已撤销,不可重复撤销"),
		STORE_NOT_EXIST("STORE_NOT_EXIST","门店不存在"),
		PAY_CODE_ERROR("PAY_CODE_ERROR","支付码异常"),
		CHANNEL_PAY_ERR("CHANNEL_PAY_ERR","渠道返回异常"),
		
		//关闭订单
		ORDERPAIED("ORDERPAIED","订单已支付，不能发起关单"),
		ORDERNOTEXIST("ORDERNOTEXIST","订单不存在"),
		ORDERCLOSED("ORDERCLOSED","订单已关闭!"),
		
		//撤销订单
		REVERSE_FAIL("REVERSE_FAIL","撤销订单失败"), 
		VERIFY_ERROR("VERIFY_ERROR","校验错误"),
		ORDER_PAYING("ORDER_PAYING","支付中"),
		REVERSED("REVERSED","订单已撤销!"),
		//支付结果未确定
		NOT_CONSUM_STATUS("NOT_CONSUM_STATUS","支付结果未知"),
		
		REFUND_ORDER_NO_EXIST("Refund_ORDER_NO_EXIST","退款单号已存在"),
		REFUND_FEE_ERR("REFUND_FEE_ERR","退款金额不能大于订单总额"),
		REFUND_ORDERNO_NOT_EXIST("REFUND_ORDERNO_NOT_EXIST","退款单号不存在");
		
		private String code;
		private String des;
		 
		//构造方法
	    private ErrorCode(String code, String des) {
	    	this.code = code;
	    	this.des = des;
	    }

		public String getCode() {
			return code;
		}

		public void setName(String code) {
			this.code = code;
		}

		public String getDes() {
			return des;
		}

		public void setDes(String des) {
			this.des = des;
		}
	}
	
	/**
	 * 微信卡券类型
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年08月01日下午1:57:11 
	 */
	public enum CardType{
		GROUPON("GROUPON","团购券"),
		CASH("CASH","现金券"),
		DISCOUNT("DISCOUNT","折扣券"),
		GIFT("GIFT","兑换券"),
		GENERAL_COUPON("GENERAL_COUPON","优惠券");
		
		private String code;
		private String name;
		//构造方法
	    private CardType(String code,String name) {
	    	this.code = code;
	    	this.name = name;
	    }
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	/**
	 * 微信卡券核销码类型
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年08月01日下午1:57:11 
	 */
	public enum CardCodeType{
		TEXT("CODE_TYPE_TEXT","文本"),
		BARCODE("CODE_TYPE_BARCODE","一维码"),
		QRCODE("CODE_TYPE_QRCODE","二维码"),
		ONLY_QRCODE("CODE_TYPE_ONLY_QRCODE","二维码无code显示"),
		ONLY_BARCODE("CODE_TYPE_ONLY_BARCODE","一维码无code显示"),
		NONE("CODE_TYPE_NONE","不显示code和条形码类型");
		private String code;
		private String name;
		//构造方法
	    private CardCodeType(String code,String name) {
	    	this.code = code;
	    	this.name = name;
	    }
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	/**
	 * 卡券有效期类型
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年08月01日下午1:57:11 
	 */
	public enum CardDateType{
		FIX_TIME_RANGE("DATE_TYPE_FIX_TIME_RANGE","固定日期区间"),
		FIX_TERM("DATE_TYPE_FIX_TERM","固定时长");
		
		private String code;
		private String name;
		//构造方法
	    private CardDateType(String code,String name) {
	    	this.code = code;
	    	this.name = name;
	    }
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
}
