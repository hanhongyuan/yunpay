<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消费情况</title>
<style>
span1{
	float: right; 
	margin-top:-6px;
}
d{
	color: red;
	font-size: 13px;
}
</style>
</head>
<body>
<div class="bjui-pageContent">
	<div style="margin:15px auto 0; width:96%;">
    	<div class="row" style="padding: 0 8px;">
     	   <div class="col-md-6">
	           	<div class="panel panel-default">
	                <div class="panel-heading">
	                	<h3 class="panel-title">1消费情况-区域 
	                	<span1>	
	                		<button type="button" class="btn-green" id="consume-area-today">今 天</button>
							<button type="button" class="btn-green" id="consume-area-yesterday">昨 天</button>
							<button type="button" class="btn-green" id="consume-area-week">近一周</button>
							<button type="button" class="btn-green" id="consume-area-month">近一月</button>
						</span1>
	                	</h3>
	                </div>
	                <div class="panel-body">
	                	<div id="consume-area-histogram" style="width:100%;height:300px;"></div>
	                	<div id="consume-area-pie" style="width:100%;height:300px;"></div> 
	                </div>
          		</div>
           </div>
 		   <div class="col-md-6">
              <div class="panel panel-default">
                  <div class="panel-heading">
                  	<h3 class="panel-title">1充值情况-区域 
                  	<span1>
                  	 	<button type="button" class="btn-green" id="recharge-area-today">今 天</button>
						<button type="button" class="btn-green" id="recharge-area-yesterday">昨 天</button>
						<button type="button" class="btn-green" id="recharge-area-week">近一周</button>
						<button type="button" class="btn-green" id="recharge-area-month">近一月</button>
					</span1>
                  	</h3>
                  </div>
                  <div class="panel-body">
                      <div id="recharge-area-histogram" style="width:100%;height:300px;"></div>
               		  <div id="recharge-area-pie" style="width:100%;height:300px;"></div> 
                  </div>
              </div>
          </div>
           <div class="col-md-6">
              <div class="panel panel-default">
                  <div class="panel-heading">
                  	<h3 class="panel-title">2消费情况-行业  
                  	<span1>
						<button type="button" class="btn-green" id="consume-industry-today">今 天</button>
						<button type="button" class="btn-green" id="consume-industry-yesterday">昨 天</button>
						<button type="button" class="btn-green" id="consume-industry-week">近一周</button>
						<button type="button" class="btn-green" id="consume-industry-month">近一月</button>
					</span1>
                  	</h3>
                  </div>
                  <div class="panel-body">
                      <div id="consume-industry-histogram" style="width:100%;height:300px;"></div>
               		  <div id="consume-industry-pie" style="width:100%;height:300px;"></div>
                  </div>
              </div>
          </div>
           <div class="col-md-6">
              <div class="panel panel-default">
                  <div class="panel-heading">
                  	<h3 class="panel-title">2充值情况-行业 
                  	<span1>
                  	 	<button type="button" class="btn-green" id="recharge-industry-today">今 天</button>
						<button type="button" class="btn-green" id="recharge-industry-yesterday">昨 天</button>
						<button type="button" class="btn-green" id="recharge-industry-week">近一周</button>
						<button type="button" class="btn-green" id="recharge-industry-month">近一月</button>
					</span1>
                  	</h3>
                  </div>
                  <div class="panel-body">
                      <div id="recharge-industry-histogram" style="width:100%;height:300px;"></div>
               		  <div id="recharge-industry-pie" style="width:100%;height:300px;"></div>
                  </div>
              </div>
           </div>
           <div class="col-md-6">
              <div class="panel panel-default">
                  <div class="panel-heading">
                  	<h3 class="panel-title">3消费情况-时间
                  	<span1>
                  	 	<button type="button" class="btn-green" id="consume-time-today">今 天</button>
						<button type="button" class="btn-green" id="consume-time-yesterday">昨 天</button>
						<button type="button" class="btn-green" id="consume-time-week">近一周</button>
						<button type="button" class="btn-green" id="consume-time-month">近一月</button>
					</span1>
                  	</h3>
                  </div>
                  <div class="panel-body">
                      <div id="consume-time-histogram" style="width:100%;height:300px;"></div>
               		  <div id="consume-time-pie" style="width:100%;height:300px;"></div>
                  </div>
              </div>
           </div>
           <div class="col-md-6">
              <div class="panel panel-default">
                  <div class="panel-heading">
                  	<h3 class="panel-title">3充值情况-时间 
                  	<span1>
                  	 	<button type="button" class="btn-green" id="recharge-time-today">今 天</button>
						<button type="button" class="btn-green" id="recharge-time-yesterday">昨 天</button>
						<button type="button" class="btn-green" id="recharge-time-week">近一周</button>
						<button type="button" class="btn-green" id="recharge-time-month">近一月</button>
					</span1>
                  	</h3>
                  </div>
                  <div class="panel-body">
                      <div id="recharge-time-histogram" style="width:100%;height:300px;"></div>
               		  <div id="recharge-time-pie" style="width:100%;height:300px;"></div>
                  </div>
              </div>
          </div> 
        </div>
    </div>
</div> 
 
	<!--以下是消费、充值ajax请求路径-->
	<script type="text/javascript">
		var consumeAreaurl = "${baseURL}/sys/chartController/AreaInfolist";
		var consumeIndustryurl = "${baseURL}/sys/chartController/IndustryInfolist"; 
		var consumeTimeurl = "${baseURL}/sys/chartController/TimeInfolist"; 
		var rechargeAreaurl = "${baseURL}/sys/chartController/RechargeAreaInfolist";
		var rechargeIndustryurl = "${baseURL}/sys/chartController/RechargeIndustryInfolist";
		var rechargeTimeurl = "${baseURL}/sys/chartController/RechargeTimeInfolist";
		
		var consumeAreaTodayurl = "${baseURL}/sys/chartController/AreaTodaylist";
		var consumeAreaYesterdayurl = "${baseURL}/sys/chartController/AreaYesterdaylist";
		var consumeAreaWeekurl = "${baseURL}/sys/chartController/AreaWeeklist";
		var consumeAreaMonthurl = "${baseURL}/sys/chartController/AreaMonthlist";
		
		var consumeIndustryTodayurl = "${baseURL}/sys/chartController/IndustryTodaylist";
		var consumeIndustryYesterdayurl = "${baseURL}/sys/chartController/IndustryYesterdaylist";
		var consumeIndustryWeekurl = "${baseURL}/sys/chartController/IndustryWeeklist";
		var consumeIndustryMonthurl = "${baseURL}/sys/chartController/IndustryMonthlist";
		
		var consumeTimeTodayurl = "${baseURL}/sys/chartController/TimeTodaylist";
		var consumeTimeYesterdayurl = "${baseURL}/sys/chartController/TimeYesterdaylist";
		var consumeTimeWeekurl = "${baseURL}/sys/chartController/TimeWeeklist";
		var consumeTimeMonthurl = "${baseURL}/sys/chartController/TimesMonthlist";
		
		var rechargeAreaTodayurl = "${baseURL}/sys/chartController/rechargeAreaTodaylist";
		var rechargeAreaYesterdayurl = "${baseURL}/sys/chartController/rechargeAreaYesterdaylist";
		var rechargeAreaWeekurl = "${baseURL}/sys/chartController/rechargeAreaWeeklist";
		var rechargeAreaMonthurl = "${baseURL}/sys/chartController/rechargeAreaMonthlist";
		
		var rechargeindustryTodayurl = "${baseURL}/sys/chartController/rechargeIndustryTodaylist";
		var rechargeindustryYesterdayurl = "${baseURL}/sys/chartController/rechargeIndustryYesterdaylist";
		var rechargeindustryWeekurl = "${baseURL}/sys/chartController/rechargeIndustryWeeklist";
		var rechargeindustryMonthurl = "${baseURL}/sys/chartController/rechargeIndustryMonthlist";
		
		var rechargeTimeTodayurl = "${baseURL}/sys/chartController/rechargeTimeTodaylist";
		var rechargeTimeYesterdayurl = "${baseURL}/sys/chartController/rechargeTimeYesterdaylist";
		var rechargeTimeWeekurl = "${baseURL}/sys/chartController/rechargeTimeWeeklist";
		var rechargeTimeMonthurl = "${baseURL}/sys/chartController/rechargeTimeMonthlist";
	</script>
	<!-- 以下是echarts官方插件提供的图形js   另有ajax请求数据 -->
	<!-- echarts插件必须先加载div中元素  再去执行Js 放到ready()中-->
	<!-- 点击今天、昨日、近一周、近一月消费情况 -区域 -->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/consume-area.js"> </script>
	<!-- 点击今天、昨日、近一周、近一月消费情况 -行业-->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/consume-industry.js"> </script>
	<!-- 点击今天、昨日、近一周、近一月消费情况 -时间-->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/consume-time.js"> </script>
	<!-- 点击今天、昨日、近一周、近一月充值情况 -区域-->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/recharge-area.js"> </script>
	<!-- 点击今天、昨日、近一周、近一月充值情况 -行业-->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/recharge-industry.js"> </script>
	<!-- 点击今天、昨日、近一周、近一月充值情况 -时间-->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/recharge-time.js"> </script>
	<!-- 消费情况-区域 -->
	<script type="text/javascript"  src="<%=basePath%>common/js/statement/consume-area-histogram.js"> </script>
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/consume-area-pie.js"></script>
	<!-- 充值情况-区域 -->
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/recharge-area-histogram.js"></script>
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/recharge-area-pie.js"></script>
	<!-- 消费情况-行业 -->
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/consume-industry-histogram.js"></script>
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/consume-industry-pie.js"></script>
	<!-- 充值情况-行业 -->
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/recharge-industry-histogram.js"></script>
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/recharge-industry-pie.js"></script>
	<!-- 消费情况-时间 -->
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/consume-time-histogram.js"></script>
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/consume-time-pie.js"></script>
	<!-- 充值情况-时间 -->
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/recharge-time-histogram.js"></script>
	<script type="text/javascript"	src="<%=basePath%>common/js/statement/recharge-time-pie.js"></script> 
</body>
</html>