<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
long v = System.currentTimeMillis();
%>
<link rel="stylesheet" href="<%=baseURL%>static/BJUI/themes/css/transReport.css?v=<%=v%> "> 
<script src="<%=baseURL%>static/js/biz-js/dateUtil.js"></script>  
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" method="post" action="${baseURL}/sys/merchantReport/dealReport?type=2">
        <div class="bjui-searchBar">
            <label>日期:</label>
            <input type="text" id="timeBegin" name="timeBegin" value ="${timeBegin}" data-toggle="datepicker" placeholder="只能查询任意相邻两个月" readonly style="width:200px;"/>
            --
           	<input type="text" id="timeEnd" name="timeEnd"	 value ="${timeEnd}" data-toggle="datepicker" readonly style="width:200px;" />&nbsp;
            <label>商户名称：</label><input type="text" value ="${merchantName}" name="merchantName" size="15" alt="模糊查询" class="form-control" />&nbsp;&nbsp;&nbsp;
          	<button type="button" name="TransTime" class="btn-default" data-icon="search" onclick="setDate('本周','timeBegin','timeEnd')">本周</button>&nbsp;
          	<button type="button" name="TransTime" class="btn-default" data-icon="search" onclick="setDate('上周','timeBegin','timeEnd')">上周</button>&nbsp;
          	<button type="button" name="TransTime" class="btn-default" data-icon="search" onclick="setDate('本月','timeBegin','timeEnd')">本月</button>&nbsp;
          	<button type="button" name="TransTime" class="btn-default" data-icon="search" onclick="setDate('上月','timeBegin','timeEnd')">上月</button>&nbsp;
            <button type="submit" id="sub" class="btn-default" data-icon="search" onclick="myFunction();return myFunction()">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">  
	<div class="divr5_1" data-url="${baseURL}/sys/merchantReport/dateReportPage?channel=wechat&timeBegin=${timeBegin}&timeEnd=${timeEnd}" title="微信日期范围交易报表"
		data-title="微信日期范围交易报表" data-toggle="dialog" data-width="900" data-height="900" data-id="dialog-normal">
			<div>
					<p><span>&nbsp;&nbsp;<font class="font16">微信</font>&nbsp;&nbsp;&nbsp;${sumDateDeal[0].timeBegin}至${sumDateDeal[0].timeEnd}</span></p>
					<p><span class="right_p">${sumDateDeal[0].wechatCountTrans}笔</span></p>
					<p><span class="right_p"><fmt:formatNumber value="${sumDateDeal[0].wechatSumTrans}" type="currency"/></span></p>
			</div>
		</div> 
 
 		<div class="divr5_2" data-url="${baseURL}/sys/merchantReport/dateReportPage?channel=alipay&timeBegin=${timeBegin}&timeEnd=${timeEnd}" title="支付宝日期范围交易报表"
 		data-title="支付宝日期范围交易报表" data-toggle="dialog" data-width="900" data-height="900" data-id="dialog-normal">
			<div>
					<p><span>&nbsp;&nbsp;<font class="font16">支付宝</font>&nbsp;&nbsp;${sumDateDeal[1].timeBegin}至${sumDateDeal[1].timeEnd}</span></p>
					<p><span class="right_p">${sumDateDeal[1].alipayCountTrans}笔</span></p>
					<p><span class="right_p"><fmt:formatNumber value="${sumDateDeal[1].alipaySumTrans}" type="currency"/></span></p>
			</div>
		</div>
		<div style="border-bottom:1px #c3ced5 solid; margin-top: 140px;"></div>
    <table class="table table-bordered table-hover" data-toggle="tablefixed" >
        <thead>
            <tr>
                <th align="center" data-order-field="merchantName">商户名称</th>
                <th align="center" data-order-field="wechatSumTrans">微信金额</th>            
                <th align="center" data-order-field="wechatCountTrans">微信笔数</th>
                <th align="center" data-order-field="alipaySumTrans">支付宝金额</th>             
                <th align="center" data-order-field="alipayCountTrans">支付宝笔数</th>
                <th align="center" data-order-field="">操作</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="item" items="${dateDeal.recordList}" varStatus="st">
				<tr> 
					<td align="center">${item.merchantName}</td>
					<td align="right"><fmt:formatNumber value="${item.wechatSumTrans}" type="currency"/>    </td>
					<td align="right">${item.wechatCountTrans }</td>
					<td align="right"><fmt:formatNumber value="${item.alipaySumTrans}" type="currency"/>  </td>
					<td align="right">${item.alipayCountTrans }</td>
					
					<td align="center"><button  data-url="${baseURL}/sys/merchantReport/dateDealReport?timeBegin=${timeBegin}&timeEnd=${timeEnd}&merchantName=${item.merchantName}" data-title="商户日期范围交易报表"
					type="button" name="todayTransTime" class="btn btn-green" data-icon="search" onclick="" data-toggle="dialog" data-width="1700" data-height="900" data-id="dialog-normal">查看详情</button></td>
				</tr>
			</c:forEach>
			
			
			
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize" name="numPerPage"
            value="${dateDeal.numPerPage}">
            <c:forEach begin="15" end="90" step="15" varStatus="s">
           		<option value="${s.index}" ${dateDeal.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
            </c:forEach>
        </select>
        </div>
        <span>&nbsp;条，共 ${dateDeal.totalCount}条,共${dateDeal.totalPage}页, 当前第${dateDeal.currentPage}页</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${dateDeal.totalCount}" data-page-size="${dateDeal.numPerPage}" data-page-current="${dateDeal.currentPage}">
    </div>
</div>
<script type="text/javascript">
//1、当查询时间不在相邻两个月内时，结束时间变为空，需要重新输入;2、任意一个为空时，则为默认查询最近有交易的相邻两个月
 function myFunction()
{	 
	var timeBegin = $("#timeBegin").val();
	var timeEnd = $("#timeEnd").val();
	if(timeEnd=="查询时间不在相邻两个月内"||timeEnd=="结束时间不得小于开始时间"){
		return false;
	}
	if (timeBegin==null||timeEnd==null||timeBegin==""||timeEnd=="") {
		return true;
	}else{
		timeBegin = new Date(timeBegin.replace(/\-/g,"\/"));
		timeEnd = new Date(timeEnd.replace(/\-/g,"\/"));
		switch (compare(timeBegin,timeEnd)) {
		case 0:
			return true;
			break;
		case 1:
			$("#timeEnd").val("查询时间不在相邻两个月内");
			return false;
			break;
		case 2:
			$("#timeEnd").val("结束时间不得小于开始时间");			
			return false;
			break;
		default:
			break;
		}
	}
}

 //当查询时间范围是否在相邻两个月内，返回值：0，在范围内，1，不在范围内，2，开始时间大于结束时间
function compare(timeBegin,timeEnd){	
	if(timeBegin>timeEnd){
		return 2;
	}else{
		if(timeEnd.getFullYear()-timeBegin.getFullYear()==0){
			if(timeEnd.getMonth()-timeBegin.getMonth()<=1){
				return 0;
			}
		}
		if(timeEnd.getFullYear()-timeBegin.getFullYear()==1){
			if(timeEnd.getMonth()==0&&timeBegin.getMonth()==11)
			return 0;
		}
		return 1;
	}	
}

</script>
