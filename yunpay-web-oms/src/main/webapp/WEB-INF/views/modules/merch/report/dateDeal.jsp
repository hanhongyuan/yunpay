<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
long v = System.currentTimeMillis();
%>

<input type="hidden" value="${timeBegin}" id="timeBegin"/>
<input type="hidden" value="${timeEnd}" id="timeEnd"/>
<input type="hidden" value="${merchantName}" id="merchantName"/>
<div class="bjui-pageContent">
	<div class="divr5_1"  style="margin-left: 36px;"  >
			<div>
				<p><span>&nbsp;&nbsp;<font class="font16">微信</font>&nbsp;&nbsp;&nbsp;${sumDateDeal[0].timeBegin}至${sumDateDeal[0].timeEnd}</span></p>
				<p><span class="right_p" style="padding-left: 112px;">${sumDateDeal[0].wechatCountTrans}笔</span></p>
				<p><span class="right_p" style="padding-left: 112px;"><fmt:formatNumber value="${sumDateDeal[0].wechatSumTrans}" type="currency"/></span></p>
			</div>
	</div>
	<div class="divr5_2" style="margin-left: 520px;">
			<div>
				<p><span>&nbsp;&nbsp;<font class="font16">支付宝</font>&nbsp;&nbsp;${sumDateDeal[1].timeBegin}至${sumDateDeal[1].timeEnd}</span></p>
				<p><span class="right_p" style="padding-left: 128px;">${sumDateDeal[1].alipayCountTrans}笔</span></p>
				<p><span class="right_p" style="padding-left: 128px;"><fmt:formatNumber value="${sumDateDeal[1].alipaySumTrans}" type="currency"/></span></p>
			</div>
	</div>
	<div style="margin:15px auto 0; width:750px;">
    	<div class="row" style="padding: 0 8px;">
         
              <div class="panel panel-default" style="width:750px;height:300px; margin-left: -415px;float;left;margin-top:140px;" >
                      <!-- 微信日期范围交易报表-->
	                 <div id="wechatfirst" style="width:750px;height:300px;" ></div>
              </div>
        
          
       
              <div class="panel panel-default" style="width:750px;height:300px; margin-left: 405px;float;right;margin-top:-320px;" >
 					<!-- 支付宝日期范围交易报表 -->
                      <div id="alipayfirst" style="width:750px;height:300px;"  ></div>
              </div>
        
        </div>
        <div class="row" style="padding: 0 8px;margin-top:350px;" id="second" hidden="hidden" >
         
              <div class="panel panel-default" style="width:750px;height:300px; margin-left: -415px;float;left;margin-top:-340px;" >
                      <!-- 微信日期范围交易报表-->
	                 <div id="wechatsecond" style="width:750px;height:300px;" ></div>
              </div>
       
          
         
              <div class="panel panel-default" style="width:750px;height:300px; margin-left: 405px;float;right;margin-top:-320px;" >
 					<!-- 支付宝日期范围交易报表 -->
                      <div id="alipaysecond" style="width:750px;height:300px;"></div>
              </div>         
        </div>
    </div>
</div> 


<script>
var allUrl = "/yunpay-web-oms/";
var dateDealReportUrl = allUrl+"sys/merchantReport/printDateDeal";
var timeBegin=$("#timeBegin").val();
var timeEnd=$("#timeEnd").val();
var merchantName=$("#merchantName").val();
merchantReport();

function merchantReport(){
	$.ajax({
		type:"post", 
	    url: dateDealReportUrl, 
	    dataType: "json",
	    data:{	    	
	    	"timeBegin":timeBegin,
	    	"timeEnd":timeEnd,	    	
	    	"merchantName":merchantName
	    	},	    
	    cache:false, 
	    async:false,  // 设置为ajax同步请求
	    success: function (result){
	    	var wechatDeal = new Array();
	    	var alipayDeal = new Array();
	    	var month=result.month;	
	    	var monthFirst=result.monthFirst;	 //第一个月的月份
	    	var days=result.firstMonthDays;
	    	var dateBegin=result.timeBeginDate;
	    	var dateEnd=result.timeEndDate;
	    	
	    	for(var i=0; i<result.printListFirst.length; i++){
	    		var dateDeal1 = result.printListFirst[i][0];
	    		var dateDeal2 = result.printListFirst[i][1];
	    		wechatDeal.push(dateDeal1);
	    		alipayDeal.push(dateDeal2);    		
	    	}	    	
	    	report("wechatfirst","微信",days,wechatDeal,dateBegin,dateEnd,monthFirst);
	    	report("alipayfirst","支付宝",days,alipayDeal,dateBegin,dateEnd,monthFirst);
	    	wechatDeal=[];
	    	alipayDeal=[];
	    	if(month==2){
	    		$("#second").removeAttr("hidden");
	    		var monthSecond=result.monthSecond;	                //第二个月的月份
	    		days=result.secondMonthDays;
	    		dateBegin=result.secondTimeBeginDate;
		    	dateEnd=result.secondTimeEndDate;
	    		for(var i=0; i<result.printListSecond.length; i++){
		    		var dateDeal1 = result.printListSecond[i][0];
		    		var dateDeal2 = result.printListSecond[i][1];
		    		wechatDeal.push(dateDeal1);
		    		alipayDeal.push(dateDeal2);    		
		    	}
		    	report("wechatsecond","微信",days,wechatDeal,dateBegin,dateEnd,monthSecond);
		    	report("alipaysecond","支付宝",days,alipayDeal,dateBegin,dateEnd,monthSecond);
	    	}
	    },
	    error:function(err){
			alert(err);
		}
	});
}

/**
 * 
 * 日期范围交易报表
 */
function report(divId,channel,days,deal,dateBegin,dateEnd,monthNum){
	    	//图表渲染的容器对象  
            var chartContainer = document.getElementById(divId);  
            //加载图表  
            var myChart = echarts.init(chartContainer);  
            myChart.setOption({  
                //图表标题  
                title: {  
                	//正标题 
            		text: monthNum+"月份"+channel+"交易数据曲线图",              			  
               		x: "center", //标题水平方向位置  
                    /* subtext: "From:http://www.xxx.com", //副标题  
                    sublink: "http://www.xxx.com", //副标题链接  */  
                    //正标题样式  
                    textStyle: {  
                        fontSize:20  
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
		                  name: '日期',
		                  data : (function(){
	                        		var res =[];
	                        		for (var i = 1; i <= days; i++) {
	                        			res.push(i.toString()); 
	                        		}	                        		
	                        		return res;
	                            })(),
		                  axisTick: {
		                        alignWithLabel: true
		                    }
		                }
		     ],
     
            //Y轴配置  
            yAxis: [  
                    {  
                        type: 'value',  
                        splitArea: { show: true },  
                        name:"交易笔数"  
                    }  
                ], 
                
          
            //图表Series数据序列配置  
            series: [  
                    {  
                        name: channel+'交易统计',  
                        type: 'line',  
                        data: (function(){
                        			var res = [];
                        			for(var i=0; i<days; i++){
                        				if(i<(dateBegin-1)||i>=dateEnd){
                        					res.push("");
                        				}else{
                        					var j=i-dateBegin+1;
                        					if(channel=="微信"){
                            					res.push(deal[j].wechatCountTrans);
                            				}else{
                            					res.push(deal[j].alipayCountTrans);
                            				}
                        				}                        				
                        			}
                        			return res;
                        		})() 
                    }
                	]
        }); 
}
</script>
	