<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
long v = System.currentTimeMillis();
request.setCharacterEncoding("UTF-8");  // 请求后台时设定的编码格式
response.setCharacterEncoding("UTF-8");
%>
<script src="<%=baseURL%>static/js/biz-js/dateUtil.js"></script>  
<link rel="stylesheet" href="<%=baseURL%>static/BJUI/themes/css/transReport.css?v=<%=v %> "> 
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" method="post" action="${baseURL}/sys/merchantReport/dealReport?type=1">
        <div class="bjui-searchBar">
            <label>日期：</label>
           	<input type="text" id="transTime" name="transTime" value="${transTime}" data-toggle="datepicker"  style="width:120px;"/>
            <label>商户名称：</label>
            <input type="text" id="merchantName"  name="merchantName" value ="${merchantName}" size="15" alt="模糊查询" class="form-control" />&nbsp;&nbsp;&nbsp;
          	<button type="button" name="todayTransTime" class="btn-default" data-icon="search" onclick="showDate('今天','transTime')">今天</button>&nbsp;
          	<button type="button" name="upTransTime" class="btn-default" data-icon="search" onclick="showDate('昨天','transTime')">昨天</button>&nbsp;
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>

<div class="bjui-pageContent tableContent" >
		<div class="divr5_1" style="margin-top: 10px;" data-url="${baseURL}/sys/merchantReport/dayReportPage?channel=wechat&transTime=${transTime}&merchantName=${merchantName}" 
		title="微信日交易报表"
		data-toggle="dialog" data-width="760" data-height="570" data-id="dialog-normal" data-title="微信日交易报表">
				<div >
					<p><span>&nbsp;&nbsp;<font class="font16">微信</font>&nbsp;&nbsp;&nbsp;&nbsp;${sumDayDeal[0].transTime}</span></p>
					<p><span class="right_p">${sumDayDeal[0].wechatCountTrans}笔</span></p>
					<p><span class="right_p"><fmt:formatNumber value="${sumDayDeal[0].wechatSumTrans}" type="currency"/></span></p>
				</div>
		</div> 
 
 		<div class="divr5_2" style="margin-top: 10px;" data-url="${baseURL}/sys/merchantReport/dayReportPage?channel=alipay&transTime=${transTime}&merchantName=${merchantName}" 
 		title="支付宝日交易报表"
		data-toggle="dialog" data-width="760" data-height="570" data-id="dialog-normal" data-title="支付宝日交易报表">
				<div >
					<p><span>&nbsp;&nbsp;<font class="font16">支付宝</font> &nbsp;&nbsp;&nbsp;${sumDayDeal[1].transTime}</span></p>
					<p><span class="right_p">${sumDayDeal[1].alipayCountTrans}笔</span></p>
					<p><span class="right_p"><fmt:formatNumber value="${sumDayDeal[1].alipaySumTrans}" type="currency"/></span></p>
				</div>
		</div>
		<div style="border-bottom:1px #c3ced5 solid; margin-top: 140px;"></div>
     <table class="table table-bordered table-hover" data-toggle="tablefixed">
        <thead>
            <tr>
                <th align="center" data-order-field="serialNo">商户名称</th>
                <th align="center" data-order-field="registerName">微信金额</th>            
                <th align="center" data-order-field="contactMan">微信笔数</th>
                <th align="center" data-order-field="tel">支付宝金额</th>             
                <th align="center" data-order-field="prov">支付宝笔数</th>
                <th align="center" data-order-field="industryTypeId">操作</th>
            </tr>
        </thead>
        <tbody>
        
                
        	<c:forEach var="item" items="${dayDeal.recordList}" varStatus="st">
				<tr> 
					<td align="center">${item.merchantName}</td>
					<td align="right"><fmt:formatNumber value="${item.wechatSumTrans}" type="currency"/> </td>
					<td align="right">${item.wechatCountTrans }</td>
					<td align="right"><fmt:formatNumber value="${item.alipaySumTrans}" type="currency"/>  </td>
					<td align="right">${item.alipayCountTrans }</td>
					
					<td align="center">
					
					<button type="button"  data-url="${baseURL}/sys/merchantReport/dayDealReport?transTime=${transTime}&merchantName=${merchantName}" 
					 class="btn btn-green"
					data-icon="search" data-toggle="dialog" data-width="1400" data-height="590" data-id="dialog-normal"  data-title="日交易报表">查看详情</button>
					
					
					
					
					
					</td>
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
            value="${dayDeal.numPerPage}">
            <c:forEach begin="15" end="90" step="15" varStatus="s">
           		<option value="${s.index}" ${dayDeal.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
            </c:forEach>
        </select>
        </div>
        <span>&nbsp;条，共 ${dayDeal.totalCount}条,共${dayDeal.totalPage}页, 当前第${dayDeal.currentPage}页</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${dayDeal.totalCount}" data-page-size="${dayDeal.numPerPage}" data-page-current="${dayDeal.currentPage}">
    </div>
</div>

<script>
</script>