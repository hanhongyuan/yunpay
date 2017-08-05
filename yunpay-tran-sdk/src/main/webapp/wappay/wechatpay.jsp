<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>一码付-微信</title>
<meta charset="utf-8" />
<meta name="viewport" content="initial-scale=1.0, width=device-width, user-scalable=no" />
<link rel="icon" href="<%=basePath%>images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="../static/css/wxzf.css">
</head>
<!-- 
 * 在微信浏览器里面打开H5网页中执行JS调起支付。接口输入输出数据格式为JSON。
 * 成功调起支付需要三个步骤：
 * 步骤1：网页授权获取用户openid
 * 步骤2：使用统一支付接口，获取prepay_id
 * 步骤3：使用jsapi调起支付
 -->
<body>
<div class="header">
</div>
<div class="wenx_xx">
  <div class="mz">一码付-微信</div>
  <!-- <div class="wxzf_price">￥0.00</div> -->
</div>
<!-- <div class="skf_xinf"> --> 
<div>
   <div class="textMoney">金额(¥)</div>
   <div class="control_conts">
   		<input name="consMoney" class="w_txt" placeholder="请输入数字金额，单位元" readonly="readonly" style="ime-mode:disabled;" type="text" value="">
   </div> 
</div> 
	<div class="all_w">
		<a href="#" id="payNow" class="ljzf_but">立即支付</a>
	</div>
	<div class="js-footer" style="min-height: 1px;">
		<div>
			<div class="footer">
				<div class="copyright">
					<div class="ft-links">
					  	<span class="pf-copyright" >由<span style="color:#f57c00;">至高通信</span>提供技术服务</span>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--浮动层-->

<div class="ftc_wzsf">
  <div class="numb_box">
    <div class="xiaq_tb"><img class="close" src="../static/img/jftc_14.jpg" height="10"> </div>
    <ul class="nub_ggg">
      <li><a href="javascript:void(0);">1</a></li>
      <li><a href="javascript:void(0);" class="zj_x">2</a></li>
      <li><a href="javascript:void(0);">3</a></li>
      <li><a href="javascript:void(0);">4</a></li>
      <li><a href="javascript:void(0);" class="zj_x">5</a></li>
      <li><a href="javascript:void(0);">6</a></li>
      <li><a href="javascript:void(0);">7</a></li>
      <li><a href="javascript:void(0);" class="zj_x">8</a></li>
      <li><a href="javascript:void(0);">9</a></li>
      <li><a href="javascript:void(0);">.</a></li>
      <li><a href="javascript:void(0);" class="zj_x">0</a></li>
      <li><span class="del" ><img src="../static/img/jftc_18.jpg"></span></li>
    </ul>
  </div>
  <div class="hbbj"></div>
</div>
</body>
<script type="text/javascript" src="../static/js/jquery.min.js"></script>
<script type="text/javascript" src="../static/js/wechat.js"></script>
<script type="text/javascript" >
$(function(){
	//参数 设置
  	var code = "<%=request.getAttribute("code") %>";
	var merchantNum = "<%=request.getAttribute("merchant_num") %>";
	var reqUrl ="<%=basePath%>pay/dowechatwap"; 
   	var datas = {code:""+code+"",merchant_num:""+merchantNum+"",url:""+reqUrl+""};
   	
	//初始化参数 信息 及事件
	Wechat.init(datas);   
});
</script>
</html>