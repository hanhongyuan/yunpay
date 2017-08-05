package com.yunpay.sdk.ctrl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.yunpay.common.exception.YunPayException;
import com.yunpay.common.utils.EnumUtil.CardCodeType;
import com.yunpay.common.utils.EnumUtil.CardDateType;
import com.yunpay.common.utils.EnumUtil.CardType;
import com.yunpay.common.utils.EnumUtil.ErrorCode;
import com.yunpay.common.utils.EnumUtil.ResultCode;
import com.yunpay.common.utils.CommonUtil;
import com.yunpay.common.utils.Log;
import com.yunpay.serv.rep.Message;
import com.yunpay.serv.req.card.CardReqDto;
import com.yunpay.serv.service.card.CardService;
import com.yunpay.wx.req.card.CardBaseInfo;
import com.yunpay.wx.req.card.CashCardReq;
import com.yunpay.wx.req.card.CreateQrCodeReq;

/**
 * 卡券模板类
 * 文件名称:     CardTemplateCtrl.java
 * 内容摘要: 
 * @author:   Zeng Dongcheng
 * @version:  1.0  
 * @Date:     2017年7月31日下午6:02:23 
 * 
 * 修改历史:  
 * 修改日期                     修改人员                                   版本	            修改内容  
 * ----------------------------------------------  
 * 2017年7月31日     Zeng Dongcheng   1.0     新建
 *
 * 版权:   版权所有(C)2017
 * 公司:   深圳市至高通信技术发展有限公司
 */
@RestController
public class CardCtrl extends BaseCtrl{
	
	private static final String APPID = "wxcbf364c912dd0987";
	
	private static final String APPSECRET = "824a09a0964de75b98ce54fbddda7ec9";
	
	private static final String IMGURL = "http://mmbiz.qpic.cn/mmbiz_jpg/FVibS3ibBAISOneJBtFUMsRqENxGuLm2nvYpySoLnqQnsafbtrgVcYDFSBovVv8a0OiasmF3UoZ6hXrVgEqMZz0Zw/0";
	
	private static final String CARDID = "p_waUv3hxxKxlY1Uh4NeGlGO9LsQ";
	
	@Autowired
	private CardService cardService;
	
	
	/**
	 * @Description: 测试获取access_token
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午11:20:44 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/card/create/token",method=RequestMethod.GET)
    public Object doAccessToken(HttpServletRequest request, HttpServletResponse response){
		Message message;
		try{
			String accessToken = cardService.recvAccessToken(APPID, APPSECRET);
			message = new Message(accessToken);
		}catch(YunPayException e){
			message = new Message(ResultCode.EXCEPTION.getCode(),e.toString());
		}
		return message;
    }
	
	/**
	 * @Description: 测试图片上传
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日上午11:20:34 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/card/upload/logo",method=RequestMethod.POST)
	public Object doUploadImg(@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.debug("卡券logo上传" + reqParamMap);
		//非空参数验证
		String[] validParam = {"sign","merchant_num"};
		String valiString = CommonUtil.paramValidate(reqParamMap,validParam);
		if(StringUtils.isNotEmpty(valiString)){
			return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
		} 
		return cardService.cardImgUpload(reqParamMap.get("merchant_num"), file);
	}
	
	
	/**
	 * @Description: 创建卡券
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日下午5:18:01 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/card/create/card")
	public Object doCreateCard(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> reqParamMap = this.getRequestParams(request);
		Log.debug("创建卡券请求参数" + reqParamMap);
		//必传项
		String[] baseParam = {"sign","merchant_num","merchant_name","card_type","login_url",
				"code_type","title","color","notice","description","quantity","card_date_type"};
		List<String> validParam = new ArrayList<String>();
		for(String param : baseParam){
			validParam.add(param);
		}
		String cardType = reqParamMap.get("card_type");
		if(CardType.GROUPON.getCode().equals(cardType)){
			//团购券
			validParam.add("deal_detail");
		}else if(CardType.GIFT.getCode().equals(cardType)){
			//现金券
			validParam.add("least_cost");
			validParam.add("reduce_cost");
		}else if(CardType.DISCOUNT.getCode().equals(cardType)){
			//折扣券
			validParam.add("discount");
		}else if(CardType.GIFT.getCode().equals(cardType)){
			//兑换券
			validParam.add("gift");
		}else{
			//优惠券
			validParam.add("default_detail");
		}
		if(CardDateType.FIX_TIME_RANGE.getCode().equals(reqParamMap.get("card_date_type"))){
			//固定时间范围
			validParam.add("begin_timestamp");
			validParam.add("end_timestamp");
		}else{
			//领取时间范围
			validParam.add("fixed_term");
			validParam.add("fixed_begin_term");
		}
		//参数验证
		String valiString = CommonUtil.paramValidate(reqParamMap,(String[])validParam.toArray());
		if(StringUtils.isNotEmpty(valiString)){
			return new Message(ErrorCode.PARAM_IS_NULL.getCode(),valiString+"参数为空");
		} 
		try {
			CardReqDto cardReq = (CardReqDto)CommonUtil.convertMap(CardReqDto.class,reqParamMap);
			return new Message(cardReq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Message(ErrorCode.SYSTEM_EXCEPTION.name(), ErrorCode.SYSTEM_EXCEPTION.getDes());
		}
	}
	
	
	/**
	 * @Description: 创建卡券
	 * @author:   Zeng Dongcheng
	 * @Date:     2017年8月1日下午5:18:01 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/card/create/qrcode")
	public Object doCreateQrcode(HttpServletRequest request, HttpServletResponse response){
		String accessToken="";
		try{
			accessToken = cardService.recvAccessToken(APPID, APPSECRET);
		}catch(YunPayException e){
			return new Message(ResultCode.EXCEPTION.getCode(),e.toString());
		}
		String cardId = request.getParameter("cardId");
		CreateQrCodeReq req = new CreateQrCodeReq();
		req.setAction_name("QR_CARD");
		req.setAction_info(CARDID);
		if(StringUtils.isNotBlank(cardId)){
			req.setAction_info(cardId);
		}
		System.out.println("--------------accessToken-----------"+accessToken);
		return cardService.createWxQrCode(req, accessToken);
	}
	
	public static void main(String args[]){
		CashCardReq cardReq = new CashCardReq();
		//必填项
		cardReq.setCard_type("CASH");
		CardBaseInfo baseInfo = new CardBaseInfo();
		baseInfo.setLogo_url(IMGURL);
		baseInfo.setCode_type(CardCodeType.QRCODE.getCode());
		baseInfo.setBrand_name("移领科技");
		baseInfo.setTitle("1元兑换券");
		baseInfo.setColor("Color020");
		baseInfo.setNotice("请出示二维码");
		baseInfo.setDescription("不可与其他优惠同享");
		baseInfo.setSku(1000);
		baseInfo.setDate_info(CardDateType.FIX_TERM.getCode(), null, null, 60, 0);
		//非必填项
		baseInfo.setService_phone("0755-2233445");
		baseInfo.setUse_all_locations(true);
		//baseInfo.setCenter_title("立即使用");
		//baseInfo.setCenter_sub_title("立即享受优惠");
		//baseInfo.setCenter_url("www.gnete.cn");
		baseInfo.setGet_limit(10);
		baseInfo.setUse_limit(4);
		baseInfo.setCan_share(true);
		baseInfo.setCan_give_friend(true);
		cardReq.setCash(100, 100, baseInfo);
		
	}
	
}
