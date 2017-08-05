package com.yunpay.serv.rep;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.yunpay.ali.rep.AliBarRep;
import com.yunpay.common.utils.AmountUtil;
import com.yunpay.common.utils.DateUtil;
import com.yunpay.common.utils.EnumUtil;
import com.yunpay.common.utils.EnumUtil.PayChannel;
import com.yunpay.common.utils.EnumUtil.TransType;
import com.yunpay.serv.model.PayTranLs;
import com.yunpay.union.rep.UnionBarRep;
import com.yunpay.wx.rep.pay.WechatBarRep;


/**
 * 条码支付返回参数结果类
 * 文件名称:     WechatMicropayRepDto.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年4月14日下午3:25:43 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年4月14日     Zeng Dongcheng   1.0     新建
 * 2017年7月7日	Zeng Dongcheng    1.1           修改         添加trade_msg属性，用于显示状态的描述
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
public class BarPayRepDto {
	
	private String dynamic_type = ""; // 1支付宝支付,2微信支付
	// 交易类型(0:支付;1:退款)
	private String trans_type = ""; 
	private String merchant_name = ""; // 商户名
	private String merchant_num = ""; // 商户号
	private String terminal_num = ""; // 终端号
	// 支付卡号(dynamic_type为微信时此处放openid，为支付宝时此处放支付宝账号)
	private String trans_card_num = ""; 
	private String total_fee = ""; // 交易金额(微信返回的total_fee)
	private String trans_amount = ""; // 实际交易金额(微信返回的cash_fee)
	private String user_order_no;	//商户订单号(此处为SDK提交的订单号)
	private String trace_num = ""; // 我方平台交易流水号
	private String transaction_id; //微信平台返回订单号
	private String trans_time = ""; // 支付完成时间
	private String is_subscribe;	//是否关注了公众号
	private String bank_type;	//付款银行
	private String attach;	//附加信息
	//交易状态(查询订单时返回)
	//0未支付，1支付中，2支付成功，3已退款，4退款中，5退款失败，6支付失败，7订单已取消
	private String trade_state;
	//支付状态说明
	private String trade_msg;
	
	
	public BarPayRepDto(){}
	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("dynamic_type=").append(dynamic_type);
		str.append("&trans_type=").append(trans_type);
		str.append("&merchant_name=").append(merchant_name);
		str.append("&merchant_num=").append(merchant_num);
		str.append("&terminal_num=").append(terminal_num);
		str.append("&trans_card_num=").append(trans_card_num);
		str.append("&total_fee=").append(total_fee);
		str.append("&trans_amount=").append(trans_amount);
		str.append("&user_order_no=").append(user_order_no);
		str.append("&trace_num=").append(trace_num);
		str.append("&transaction_id=").append(transaction_id);
		str.append("&trans_time=").append(trans_time);
		str.append("&is_subscribe=").append(is_subscribe);
		str.append("&bank_type=").append(bank_type);
		str.append("&attach=").append(attach);
		return str.toString();
	}
	
	/**
	 * 构造支付宝支付返回实体
	 * @param response
	 * @param sysTransaction
	 */
	public BarPayRepDto(AliBarRep aliBarRep,PayTranLs payTranLs){
		if ("10000".equals(aliBarRep.getCode()) || "10003".equals(aliBarRep.getCode()) ) {
			this.trans_type=TransType.PAY.getValue()+"";
			//微信参数(是否关注公众号)
			this.is_subscribe = "";
			this.dynamic_type = PayChannel.ALIPAY.getValue()+"";
			this.merchant_num = payTranLs.getMerchantNo();
			this.merchant_name = payTranLs.getMerchantName();
			//SDK提交的订单号
			this.user_order_no = payTranLs.getUser_order_no();
			this.terminal_num = payTranLs.getTerminalNum();
			this.attach = payTranLs.getAttach();
			if(aliBarRep.getCode().equals("10000")){
				//订单金额
				this.total_fee = aliBarRep.getTotal_amount();
				//实际支付金额
				this.trans_amount = aliBarRep.getReceipt_amount();
				//支付宝平台返回交易号
				this.transaction_id = aliBarRep.getTrade_no();
				//我方交易平台提交的订单号(支付宝原样返回)
				this.trace_num = aliBarRep.getOut_trade_no();
				//支付时间
				this.trans_time = DateUtil.formatDate(aliBarRep.getGmt_payment(), "yyyy-MM-dd HH:mm:ss");
				//买家支付宝账号
				this.trans_card_num = aliBarRep.getBuyer_logon_id();
				//交易使用的资金渠道
				this.bank_type=aliBarRep.getFund_channel();
			}
		}
	}
	
	/**
	 * 构造微信支付返回参数实体
	 * @param wechatBarRep
	 * @param payTranLs
	 */
	public BarPayRepDto(WechatBarRep wechatBarRep,PayTranLs payTranLs){
		try {
			//微信返回信息
			this.is_subscribe = wechatBarRep.getIs_subscribe();
			this.bank_type = wechatBarRep.getBank_type();
			this.total_fee = AmountUtil.changeF2Y(wechatBarRep.getTotal_fee());
			this.trans_amount = AmountUtil.changeF2Y(wechatBarRep.getCash_fee());
			this.transaction_id = wechatBarRep.getTransaction_id();
			this.trace_num = wechatBarRep.getOut_trade_no();
			this.trans_time = DateUtil.convertWxDateToCurr(wechatBarRep.getTime_end());
			this.trans_card_num = wechatBarRep.getOpenid();
			//平台返回信息
			this.trans_type=TransType.PAY.getValue()+"";
			this.dynamic_type = PayChannel.WECHAT.getValue()+"";
			this.merchant_num = payTranLs.getMerchantNo();
			this.merchant_name = payTranLs.getMerchantName();
			this.user_order_no = payTranLs.getUser_order_no();
			this.terminal_num = payTranLs.getTerminalNum();
			this.attach = payTranLs.getAttach();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 构造银联支付返回参数实体
	 * @param unionBarRep
	 * @param payTranLs
	 */
	public BarPayRepDto(UnionBarRep unionBarRep,PayTranLs payTranLs){
		try {
			this.total_fee = AmountUtil.changeF2Y(unionBarRep.getTxnAmt());
			this.trans_amount = AmountUtil.changeF2Y(unionBarRep.getTxnAmt());
			this.transaction_id = unionBarRep.getQueryId();
			this.trace_num = payTranLs.getTransNum();
			this.trans_time = DateUtil.convertWxDateToCurr(unionBarRep.getTxnTime());
			//平台返回信息
			this.trans_type=TransType.PAY.getValue()+"";
			this.dynamic_type = PayChannel.UNION.getValue()+"";
			this.merchant_num = payTranLs.getMerchantNo();
			this.merchant_name = payTranLs.getMerchantName();
			this.user_order_no = payTranLs.getUser_order_no();
			this.terminal_num = payTranLs.getTerminalNum();
			this.attach = payTranLs.getAttach();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 构造订单返回参数实体
	 * @param BarPayRepDto
	 */
	public BarPayRepDto(PayTranLs payTranLs){
		this.dynamic_type = payTranLs.getChannel()+"";
		this.user_order_no = payTranLs.getUser_order_no();
		this.transaction_id = payTranLs.getTrade_no();
		this.trade_state = payTranLs.getStatus()+"";
		this.trans_type = payTranLs.getTransType()+"";
		this.merchant_name = payTranLs.getMerchantName();
		this.merchant_num = payTranLs.getMerchantNo();
		this.terminal_num = payTranLs.getTerminalNum();
		this.trans_card_num = payTranLs.getTransCardNum();
		this.trace_num = payTranLs.getTransNum();
		this.trans_time = DateUtil.formatDate(payTranLs.getTransTime(),"yyyy-MM-dd HH:mm:ss");
		this.trans_amount = payTranLs.getTransPrice()+"";
		this.total_fee = payTranLs.getTotalPrice()+"";
		this.attach = payTranLs.getAttach();
		this.trade_msg = EnumUtil.getPayStatusNameByValue(payTranLs.getStatus());
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			Object obj;
			try {
				obj = field.get(this);
				if (obj != null) {
					if (field.getType() == int.class) {
						map.put(field.getName(), String.valueOf(obj));
					} else {
						map.put(field.getName(), (String) obj);
					}
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public String getDynamic_type() {
		return dynamic_type;
	}

	public void setDynamic_type(String dynamic_type) {
		this.dynamic_type = dynamic_type;
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getMerchant_num() {
		return merchant_num;
	}

	public void setMerchant_num(String merchant_num) {
		this.merchant_num = merchant_num;
	}

	public String getTerminal_num() {
		return terminal_num;
	}

	public void setTerminal_num(String terminal_num) {
		this.terminal_num = terminal_num;
	}

	public String getTrans_card_num() {
		return trans_card_num;
	}

	public void setTrans_card_num(String trans_card_num) {
		this.trans_card_num = trans_card_num;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}

	public String getUser_order_no() {
		return user_order_no;
	}

	public void setUser_order_no(String user_order_no) {
		this.user_order_no = user_order_no;
	}

	public String getTrace_num() {
		return trace_num;
	}

	public void setTrace_num(String trace_num) {
		this.trace_num = trace_num;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getTrans_time() {
		return trans_time;
	}

	public void setTrans_time(String trans_time) {
		this.trans_time = trans_time;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public String getTrade_msg() {
		return trade_msg;
	}

	public void setTrade_msg(String trade_msg) {
		this.trade_msg = trade_msg;
	}
	
	
	
}
