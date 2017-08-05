<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String merchantNum = request.getParameter("merchant_num");
%>
<!DOCTYPE html>
<html>
<head>
    <title>一码付-支付宝</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="initial-scale=1.0, width=device-width, user-scalable=no" />
	<link rel="icon" href="<%=basePath%>images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="../static/css/wxzf.css">
	
</head>
  
<body>
  	<form id="alipayForm" method="post" action="<%=basePath%>pay/doaliwap">
	  	<div class="header"></div>
		<div class="wenx_xx">
			<div class="mz">一码付-支付宝</div>
		  	<!-- <div class="wxzf_price">￥0.00</div> -->
		</div>
		<div>
		   <div class="textMoney">金额(¥)</div>
		   <div class="control_conts">
		   		<input name="total_fee" class="ali_txt" placeholder="请输入数字金额，单位元" readonly="readonly" style="ime-mode:disabled;" type="text" value="">
		   		<input type="hidden" name="merchant_num" value="<%=merchantNum%>" />
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
	</form>  
</body>
<script type="text/javascript" src="../static/js/jquery.min.js"></script>
<script type="text/javascript" src="../static/js/alipay.js"></script>
<script type="text/javascript" >
	$(function(){
		//初始化参数 信息 及事件
		Alipay.init();   
	});
</script>
</html>
