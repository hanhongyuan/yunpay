<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
long v = System.currentTimeMillis();
%>
<style type="text/css">
	.divr5_1 div p span{
	font-size: 13px;
	font-family: 宋体;
	font-weight:bold;
	color:white;
	line-height:24px;
}

.divr5_1 div{
	margin-top: 10px;
}

.divr5_2 div p span{
	font-size: 13px;
	font-family: 宋体;
	font-weight:bold;
	color:white;
	line-height:24px;
}

.divr5_2 div{
	margin-top: 10px;
}

.divr5_1 .right_p{
	padding-left: 127px;
}

.divr5_2 .right_p{
	padding-left: 127px;
}

</style>

<input type="hidden" value="${timeBegin}" id="timeBegin"/>
<input type="hidden" value="${timeEnd}" id="timeEnd"/>
<input type="hidden" value="${channel}" id="channel"/>

<div class="bjui-pageContent">
	<div class="divr5_1" style="margin-left:35px;
		<c:if test="${sumDateDeal.channel == '微信'}"> background: green; </c:if>
	 	<c:if test="${sumDateDeal.channel == '支付宝'}"> background: #FF7744; </c:if>" >
		<div>
			<p><span>&nbsp;&nbsp;<font class="font16">${sumDateDeal.channel}</font>&nbsp;&nbsp;${sumDateDeal.timeBegin}至${sumDateDeal.timeEnd}</span></p>
			<c:if test="${sumDateDeal.channel == '微信'}">
				<p><span class="right_p">${sumDateDeal.wechatCountTrans}笔</span></p>
				<p><span class="right_p"><fmt:formatNumber value="${sumDateDeal.wechatSumTrans}" type="currency"/></span></p>
			</c:if> 
			<c:if test="${sumDateDeal.channel == '支付宝'}">
				<p><span class="right_p">${sumDateDeal.alipayCountTrans}笔</span></p>
				<p><span class="right_p"><fmt:formatNumber value="${sumDateDeal.alipaySumTrans}" type="currency"/></span></p>
			</c:if> 
		</div>
	</div>
		
	<div style="margin:15px auto 0; width:820px;">
    	<div class="row" style="padding: 0 8px;">
    		 <!-- 日期范围交易报表-->
            <div class="panel panel-default" style="width:750px;height:300px;float;left;margin-top:140px;margin-left: 18px;" >	
                  <div id="date_report1" style="width:750px;height:300px;"   ></div>
            </div>
        </div>
        <div class="row" style="padding: 0 8px;" hidden="hidden" id="second" >
    		 <!-- 日期范围交易报表--> 
          <div class="col-md-6" >
              <div class="panel panel-default" style="margin-top: 30px; float;left;margin-left: 3px; width:750px;" >	
                     <div id="date_report2" style="width:750px;height:300px;"   ></div>
              </div>
          </div>
        </div> 
   </div>        
    	
</div> 

<script type="text/javascript">
var allUrl = "/yunpay-web-oms/";
var dateDealReportUrl = allUrl+"sys/merchantReport/printDateDeal";
var channel = $("#channel").val() == 'wechat' ? 'wechat':'alipay';
var timeBegin = $("#timeBegin").val();
var timeEnd = $("#timeEnd").val();
channelReport();

function channelReport(){
	$.ajax({
		type:"post", 
	    url: dateDealReportUrl, 
	    dataType: "json",
	    data:{	    	
	    	"timeBegin":timeBegin,
	    	"timeEnd":timeEnd,
	    	"channel":channel
	    	},	    
	    cache:false, 
	    async:false,  // 设置为ajax同步请求
	    success: function (result){
	    	var wechatDeal = new Array();        //用于接收微信的交易数据
	    	var alipayDeal = new Array();        //用于接收支付宝的交易数据
	    	var month=result.month;		         //表示查询跨度，1为一个月，2为两个月 		    	
	    	var monthFirst=result.monthFirst;	 //第一个月的月份	    		    			    		    	
	    	var days=result.firstMonthDays;      //第一个月最大天数
	    	var channel=result.channel;          //消费渠道
	    	var dateBegin=result.timeBeginDate;  //第一个月查询开始天数，如：2017/05/18，则该值为18
	    	var dateEnd=result.timeEndDate;      //第一个月查询结束天数，如：2017/05/18，则该值为18
	    	//绘制第一个月的交易数据图表
	    	for(var i=0; i<result.printListFirst.length; i++){
	    		var dateDeal1 = result.printListFirst[i][0];
	    		var dateDeal2 = result.printListFirst[i][1];
	    		wechatDeal.push(dateDeal1);
	    		alipayDeal.push(dateDeal2);    		
	    	}
	    	if(channel == 'wechat'){
	    		report("date_report1","微信",days,wechatDeal,dateBegin,dateEnd,monthFirst);
	    	}else{
	    		report("date_report1","支付宝",days,alipayDeal,dateBegin,dateEnd,monthFirst);
	    		}
	    	//将数组清空，等待接收第二个月的交易数据
	    	wechatDeal=[];
	    	alipayDeal=[];
	    	//当存在第二个月时，绘制第二个月的交易数据图表
	    	if(month==2){
	    		$("#second").removeAttr("hidden");                  //当存在第二个月时，将第二个月图表容器显现
	    		var monthSecond=result.monthSecond;	                //第二个月的月份
	    		days=result.secondMonthDays;                        //第二个月最大天数
	    		dateBegin=result.secondTimeBeginDate;               //第二个月查询开始天数，如：2017/05/18，则该值为18
		    	dateEnd=result.secondTimeEndDate;                   //第二个月查询结束天数，如：2017/05/18，则该值为18
	    		for(var i=0; i<result.printListSecond.length; i++){
		    		var dateDeal1 = result.printListSecond[i][0];
		    		var dateDeal2 = result.printListSecond[i][1];
		    		wechatDeal.push(dateDeal1);
		    		alipayDeal.push(dateDeal2);    		
		    	}
	    		if(channel == 'wechat'){
		    		report("date_report2","微信",days,wechatDeal,dateBegin,dateEnd,monthSecond);
		    	}else{
		    		report("date_report2","支付宝",days,alipayDeal,dateBegin,dateEnd,monthSecond);
		    		}		    	
	    	}
	    },
	    error:function(err){
			alert(err);
		}
	});
}


/**
 * 
 * 日期范围交易图表绘制函数
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
             /*        link: "http://www.baidu.com", //正标题链接 点击可在新窗口中打开  
                     
                    subtext: "From:http://www.xxx.com", //副标题  
                    sublink: "http://www.xxx.com", //副标题链接   */
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

