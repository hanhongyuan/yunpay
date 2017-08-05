<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
long v = System.currentTimeMillis();
%>
<link rel="stylesheet" href="<%=baseURL%>static/BJUI/themes/css/transReport.css?v=<%=v%> "> 
<<style type="text/css">
	.divr5_1 .right_p3{
			padding-left: 117px;
	}
	.divr5_2 .right_p3{
			padding-left: 134px;
	}
</style>
<input type="hidden" value="${transTime}" id="transTime"/>
<input type="hidden" value="${merchantName}" id="merchantName"/> 	
 	

<div class="bjui-pageContent">
	<div class="divr5_1" style="margin-left: 31px;" >
		<div >
			<p><span>&nbsp;&nbsp;<font class="font16">微信</font>&nbsp;&nbsp;&nbsp;&nbsp;${sumDayDeal[0].transTime}</span></p>
			<p><span class="right_p3">${sumDayDeal[0].wechatCountTrans}笔</span></p>
			<p><span class="right_p3"><fmt:formatNumber value="${sumDayDeal[0].wechatSumTrans}" type="currency"/></span></p>
		</div>
	</div>
	<div class="divr5_2" style="margin-left: 364px;">
		<div >
			<p><span>&nbsp;&nbsp;<font class="font16">支付宝</font>&nbsp;&nbsp;&nbsp;&nbsp;${sumDayDeal[1].transTime}</span></p>
			<p><span class="right_p3">${sumDayDeal[1].alipayCountTrans}笔</span></p>
			<p><span class="right_p3"><fmt:formatNumber value="${sumDayDeal[1].alipaySumTrans}" type="currency"/></span></p>
		</div>
	</div>
	
	<div style="margin:15px auto 0; width:560px;">
    	<div class="row" style="padding: 0 8px;">
          		
              <div class="panel panel-default" style="width:600px;height:340px; margin-left: -366px;float;left;margin-top:150px;" >
                      <!-- 微信 日交易报表-->
	                 <div id="wechatReport" style="width:600px;height:340px;" ></div>
              </div>

              <div class="panel panel-default" style="width:580px;height:340px; margin-left: 300px;float;right;margin-top:-360px;">
 					<!-- 支付宝日交易报表 -->
                      <div id="alipayReport" style="width:580px;height:340px; " ></div>
              </div>
        
        </div>
    </div>
</div> 


<script>
// 不知道什么原因，单独放在一个文件中就无法使用，所以就在页面直接写脚本了
var allUrl = "/yunpay-web-oms/";
var dayDealReportUrl = allUrl+"sys/merchantReport/printDayDeal";

var wechat = new Array();
var alipay = new Array();

/**
 * 获取微信、支付宝的交易汇总数据
 */
function getTransData(){
	$.ajax({
		type:"post", 
	    url: dayDealReportUrl, 
	    dataType: "json",
	    data:{
	    	"transTime":$("#transTime").val(),
	    	"merchantName":$("#merchantName").val()
	    },
	    cache:false, 
	    async:false,  // 设置为ajax同步请求
	    success: function (result){
	    	for(var i=0; i<result.length; i++){
	    		var dayDeal = result[i];
	    		if(dayDeal.channel == '微信'){
	    			wechat.push(dayDeal);
	    		}else if(dayDeal.channel == '支付宝'){
	    			alipay.push(dayDeal);
	    		}
	    	}
	    },
		error:function(err){
			alert(err);
		}
	});
}


/**
 * 微信日交易报表
 */
function wechatReport(){
	//图表渲染的容器对象  
	var chartContainer = document.getElementById("wechatReport");
    //加载图表  
    var myChart = echarts.init(chartContainer);  
    myChart.setOption({  
        //图表标题  
        title: {  
             text: "微信日交易趋势图", //正标题  
             x: "center", //标题水平方向位置  
     /*        link: "http://www.baidu.com", //正标题链接 点击可在新窗口中打开  
            x: "center", //标题水平方向位置  
            subtext: "From:http://www.xxx.com", //副标题  
            sublink: "http://www.xxx.com", //副标题链接   */
            //正标题样式  
            textStyle: {  
                fontSize:15  
            },  
            //副标题样式  
            subtextStyle: {  
                fontSize:12,  
                color:"red"  
            }  
    },  
    //数据提示框配置  
    tooltip: {  
        trigger: 'axis' //触发类型，默认数据触发，见下图，可选为：'item' | 'axis' 
    },  
  /*   //图例配置  
    legend: {  
        data: ['蒸发量', '降水量'], //这里需要与series内的每一组数据的name值保持一致  
        y:"bottom"  
    },   */
    //工具箱配置  
      toolbox: {  
        show : true,  
        feature : {  
            mark : {show: true}, // 辅助线标志，上图icon左数1/2/3，分别是启用，删除上一条，删除全部  
            dataView : {show: true, readOnly: false},// 数据视图，上图icon左数8，打开数据视图  
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},// 图表类型切换，当前仅支持直角系下的折线图、柱状图转换，上图icon左数6/7，分别是切换折线图，切换柱形图  
            restore : {show: true}, // 还原，复位原始图表，上图icon左数9，还原  
            saveAsImage : {show: true} // 保存为图片，上图icon左数10，保存  
        }  
    },   
    calculable: true,  
    xAxis : [
              {
                  type: 'category',
                  name: '时间段',
                  data : ['00-02','02-04','04-06','06-08','08-10','10-12','12-14','14-16','16-18','18-20','20-22','22-23'],
                   axisTick: {
                        alignWithLabel: true
                    }, 
                   axisLine: {onZero: true},
                   splitLine:{  
                      show:true,
                      lineStyle:{
              		    color:'#DDDDDD',
              		    width: 2
              		 }
                  }, 
                   minInterval:1,
                  boundaryGap: false
                }
       
     ],
     grid: {
         left: '2%',
         bottom: '3%',
         containLabel: true
     },
     

    //Y轴配置  
    yAxis: [  
            {  
                type: 'value',  
                splitArea: { show: true },  
                name: '交易笔数',
                axisLine: {onZero: true}
             
            }  
        ], 
        
  
    //图表Series数据序列配置  
    series: [  
            {  
                name: '交易笔数',  
                type: 'line',  
                smooth: true,
                data: (function(){
                	var res = [];
                	for(var i=0; i<wechat.length; i++){
                		res.push({
                			name:wechat[i].transTime,
                			value:wechat[i].wechatCountTrans
                		});
                	}
                	return res;
                })() 
            }
            
        ]
}); 
   
}



/**
 * 支付宝日交易报表
 */
function alipayReport(){
	//图表渲染的容器对象  
	var chartContainer = document.getElementById("alipayReport");
    //加载图表  
    var myChart = echarts.init(chartContainer);  
    myChart.setOption({  
        //图表标题  
        title: {  
             text: "支付宝日交易趋势图", //正标题  
             x: "center", //标题水平方向位置  
     /*        link: "http://www.baidu.com", //正标题链接 点击可在新窗口中打开  
            x: "center", //标题水平方向位置  
            subtext: "From:http://www.xxx.com", //副标题  
            sublink: "http://www.xxx.com", //副标题链接   */
            //正标题样式  
            textStyle: {  
                fontSize:15  
            },  
            //副标题样式  
            subtextStyle: {  
                fontSize:12,  
                color:"red"  
            }  
    },  
    //数据提示框配置  
    tooltip: {  
        trigger: 'axis' //触发类型，默认数据触发，见下图，可选为：'item' | 'axis' 
    },  
  /*   //图例配置  
    legend: {  
        data: ['蒸发量', '降水量'], //这里需要与series内的每一组数据的name值保持一致  
        y:"bottom"  
    },   */
    //工具箱配置  
     toolbox: {  
        show : true,  
        feature : {  
            mark : {show: true}, // 辅助线标志，上图icon左数1/2/3，分别是启用，删除上一条，删除全部  
            dataView : {show: true, readOnly: false},// 数据视图，上图icon左数8，打开数据视图  
            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},// 图表类型切换，当前仅支持直角系下的折线图、柱状图转换，上图icon左数6/7，分别是切换折线图，切换柱形图  
            restore : {show: true}, // 还原，复位原始图表，上图icon左数9，还原  
            saveAsImage : {show: true} // 保存为图片，上图icon左数10，保存  
        }  
    },  
    calculable: true,  
    xAxis : [
              {
                  type: 'category',
                  name: '时间段',
                  data : ['00-02','02-04','04-06','06-08','08-10','10-12','12-14','14-16','16-18','18-20','20-22','22-23'],
                  axisTick: {
                        alignWithLabel: true
                    },
                  axisLine: {onZero: true},
                  splitLine:{  
                      show:true,
                      lineStyle:{
              		    color:'#DDDDDD',
              		    width: 2
              		 }
                  },
                  minInterval:1,
                  boundaryGap: false,
                }
       
     ],
     grid: {
         left: '2%',
   
         bottom: '3%',
         containLabel: true
     },
     

    //Y轴配置  
    yAxis: [  
            {  
                type: 'value',  
                splitArea: { show: true },  
                name: '交易笔数',
                axisLine: {onZero: true}
             
            }  
        ], 
        
  
    //图表Series数据序列配置  
    series: [  
            {  
                name: '交易笔数',  
                type: 'line',  
                smooth: true,
                data: (function(){
                	var res = [];
                	for(var i=0; i<alipay.length; i++){
       
                		res.push({
                			name:alipay[i].transTime,
                			value:alipay[i].alipayCountTrans
                		});
                		
                	}
                	return res;
                })() 
            }
            
        ]
}); 
}

getTransData();
wechatReport();
alipayReport();

</script>
	