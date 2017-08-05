package com.yunpay.sdk.ctrl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.IdWorker;
import com.yunpay.common.utils.Log;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.PayChannel;
import com.yunpay.common.utils.EnumUtil.ResultCode;
import com.yunpay.serv.config.PayConfig;
import com.yunpay.serv.model.Merchant;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.req.WapPayReqDto;
import com.yunpay.serv.route.PayFactory;
import com.yunpay.serv.service.busi.MerchantService;
import com.yunpay.serv.service.pay.QrPayService;

/**
 * 文件名称:     OneBarPayCtrl.java
 * 内容摘要: 	一码付(静态二维码)
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月19日下午5:16:46 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月19日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@Controller
public class OneBarPayCtrl extends BaseCtrl{
	
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private PayFactory payFactory;
	
	/**
	 * @Description: 一码付扫码入口
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年6月27日下午2:54:36 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/pay/wappay")
	public String towappay(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String agent = request.getHeader("User-Agent").toLowerCase();
		//获取商户号
		String merchNum = request.getParameter("merchant_num");
		//微信扫码
		if(agent.indexOf("micromessenger")>0){
			//进入微信网页授权(静默授权，用户无感知)
			String requestUrl = PayConfig.WECHAT_AUTHCODE_URL.replace("APPID", PayConfig.WECHAT_APPID).
					replace("REDIRECT_URI", PayConfig.WECHAT_REDIRECT_URL).replace("STATE", merchNum);
			Log.info("------------requestUrl="+requestUrl);
			response.sendRedirect(requestUrl);
			return null;
		//支付宝扫码
		}else if(agent.indexOf("alipayclient")>0){
			request.setAttribute("merchant_num", merchNum);
			return "wappay/alipay";
		}
		return "wappay/alipay";
		
		
	}
	
	
	/**
	 * @Description:微信授权回调方法 
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月4日下午2:33:48 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/recvauth")
	public String recvAuth(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.debug("微信授权回调接收参数：" + reqParamMap);
		request.setAttribute("code", reqParamMap.get("code"));
		request.setAttribute("merchant_num", reqParamMap.get("state"));
		return "wappay/wechatpay";
	}
	
	
	/**
	 * @Description: 微信下单
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月4日下午2:34:01 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/dowechatwap",method=RequestMethod.POST)
	@ResponseBody
	public Object doWechatwap(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		String[] wapParam = {"total_fee","merchant_num","auth_code"};
		String valiString = CommonUtil.paramValidate(reqParamMap,wapParam);
		//判断必要参数是否为空
		if(StringUtils.isNotEmpty(valiString)){
			return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
		}
		try {
			WapPayReqDto wapPayReq = (WapPayReqDto) CommonUtil.convertMap(WapPayReqDto.class, reqParamMap);
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(wapPayReq.getMerchant_num());
			if (merchant == null) {
				return new Message(ErrorCode.ILLEGAL_MERCHANT_NUM.getCode(), ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());			
			}
			IdWorker iw = new IdWorker();
			String userOrderNo = iw.getId()+"";
			wapPayReq.setUser_order_no(userOrderNo);
			if(StringUtils.isBlank(reqParamMap.get("body"))){
				wapPayReq.setBody("wechat pay");
			}
			//获取微信支付业务类
			QrPayService payService = payFactory.getServiceByChannel(PayChannel.WECHAT.getValue());
			return payService.doWapPay(wapPayReq, merchant);
		} catch (Exception e) {
			Log.error("支付出现异常："+e);
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
	}
	
	/**
	 * @Description: 支付宝下单
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月4日下午2:34:15 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/pay/doaliwap",method=RequestMethod.POST)
	public String doAliwap(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Map<String,String> reqParamMap = this.getRequestParams(request);
		try {
			String[] wapParam = {"total_fee","merchant_num"};
			//判断必要参数是否为空
			String valiString = CommonUtil.paramValidate(reqParamMap,wapParam);
			if(StringUtils.isNotEmpty(valiString)){
				request.setAttribute("errmsg",valiString+"参数为空");
				return "wappay/error";
			}
			IdWorker iw = new IdWorker();
			String userOrderNo = iw.getId()+"";
			//对象转换
			WapPayReqDto wapPayReq = (WapPayReqDto) CommonUtil.convertMap(WapPayReqDto.class, reqParamMap);
			wapPayReq.setUser_order_no(userOrderNo);
			if(StringUtils.isBlank(reqParamMap.get("body"))){
				wapPayReq.setBody("alipay");
			}
			//获取商户信息
			Merchant merchant = merchantService.queryMerchInfo(wapPayReq.getMerchant_num());
			if (merchant == null) {
				request.setAttribute("errmsg", ErrorCode.ILLEGAL_MERCHANT_NUM.getDes());
				return "wappay/error";	
			}
			QrPayService payService = payFactory.getServiceByChannel(PayChannel.ALIPAY.getValue());
			Message msg = payService.doWapPay(wapPayReq, merchant);
			if(ResultCode.SUCCESS.getCode().equals(msg.getResult_code())){
				String formText = (String)msg.getData();
				PrintWriter out=response.getWriter();
				response.setContentType("text/html;charset=utf-8");
				out.write(formText);//直接将完整的表单html输出到页面
				out.flush();
				out.close();
				return null;
			}
		} catch (Exception e) {
			Log.error("支付出现异常：", e);
			request.setAttribute("errmsg",ErrorCode.SYSTEM_EXCEPTION.name());
			return "wappay/error";
		}
		request.setAttribute("errmsg",ErrorCode.TRADE_FAIL.getDes());
		return "wappay/error";
	}
	
	/**
	 * @Description: 支付宝支付前端跳转通知
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年7月19日上午9:26:57 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/pay/alipay/wapreturn")
	public String aliWapReturn(HttpServletRequest request, HttpServletResponse response){
		Log.info("######receive alipay wap return message!");
		try {
			// 获取支付宝POST过来反馈信息
			Map<String, String> params = getRequestParams(request);
			//String trade_status = params.get("trade_status");
			String trade_no = params.get("trade_no");
			if(StringUtils.isNotBlank(trade_no)){
				return "wappay/ok";
			}
		}catch(Exception e){
			request.setAttribute("errmsg", "支付结果接收异常，请与商家确认支付结果");
			return "wappay/error";
		}
		request.setAttribute("errmsg", "支付结果未指，请与商家确认支付结果");
		return "wappay/error";
	}
	
	
}
