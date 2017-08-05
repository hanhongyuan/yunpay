<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
%>
<script src="<%=baseURL%>static/js/biz-js/trans_ls.js"></script>
<script src="<%=baseURL%>static/BJUI/plugins/echarts/echarts.js" charset="UTF-8"></script>
<div class="bjui-pageHeader">
	
    <form id="pagerForm" data-toggle="ajaxsearch" method="post" action="${baseURL}/sys/merchantReport/list">
        <div class="bjui-searchBar">
            <label>支付日期：</label>
           	<input type="text" name="transTime1" value="${requestScope.transTime1}" data-toggle="datepicker" readonly style="width:120px;"/>--
           	<input type="text" name="transTime2"	 value ="${requestScope.transTime2}" data-toggle="datepicker" readonly style="width:120px;"/>
            <label>商户名称：</label><input type="text" value ="${requestScope.merchantName}" name="merchantName" size="15" alt="模糊查询" class="form-control" />&nbsp;
            <label>流水号：</label><input type="text" value ="${requestScope.transNum}" name="transNum"  size="25" alt="模糊查询" class="form-control" />&nbsp;
            <label>渠道：</label>
            	<select name="channel" class="selectpicker show-menu-arrow form-control">
            		<option value="">请选择渠道</option>
            		<option value="1" <c:if test="${requestScope.channel == '1'}">selected="selected"</c:if>> 支付宝  </option>  
            		<option value="2" <c:if test="${requestScope.channel == '2'}">selected="selected"</c:if>> 微信 </option>
            		<option value="3" <c:if test="${requestScope.channel == '3'}">selected="selected"</c:if>> 银联 </option>
            		<option value="4" <c:if test="${requestScope.channel == '4'}">selected="selected"</c:if>> 预存款</option> 
            	</select>
            <label>状态：</label>
            <select id="status" name="status" class="selectpicker show-menu-arrow form-control" >
            	<option value="">请选择状态</option>
        		<option value="0" <c:if test="${requestScope.status == '0'}">selected="selected"</c:if>>未付款</option> 
        		<option value="1" <c:if test="${requestScope.status == '1'}">selected="selected"</c:if>>付款中</option>
        		<option value="2" <c:if test="${requestScope.status == '2'}">selected="selected"</c:if>>已付款</option>
        		<option value="3" <c:if test="${requestScope.status == '3'}">selected="selected"</c:if>>已退款</option>
        		<option value="4" <c:if test="${requestScope.status == '4'}">selected="selected"</c:if>>退款中</option>
        		<option value="5" <c:if test="${requestScope.status == '5'}">selected="selected"</c:if>>退款失败</option>
        		<option value="6" <c:if test="${requestScope.status == '6'}">selected="selected"</c:if>>付款失败</option>
        		<option value="7" <c:if test="${requestScope.status == '7'}">selected="selected"</c:if>>已撤销</option>
        	</select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn btn-green"  title="导出交易流水" onclick="outExcel('excelForm');">导出</button>
            </div>
        </div>
    </form>
    
    <!-- excel导出需要的form -->
    <div style="display: none;">
    	<form id="excelForm"  method="post" action="${baseURL}/sys/merchantReport/exportExcel">
           	<input type="hidden" name="transTime1" value="${requestScope.transTime1}" />
           	<input type="hidden" name="transTime2"	 value ="${requestScope.transTime2}" />
            <input type="hidden" value ="${requestScope.merchantName}" name="merchantName"/>
            <input type="hidden" value ="${requestScope.transNum}" name="transNum" />
            <input type="hidden" name="channel" value="${requestScope.channel}"/>
            <input type="hidden" name="status" value="${requestScope.status}"/>
   		</form>
    </div>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" >
        <thead>
            <tr>
                <th align="center" data-order-field="serialNo">商户名称</th>
                <th align="left" data-order-field="registerName">门店名称</th>            
                <th align="left" data-order-field="contactMan">支付流水号</th>
                <th align="left" data-order-field="tel">平台流水</th>             
                <th align="left" data-order-field="prov">渠道流水</th>
                <th align="right" data-order-field="industryTypeId">原始金额</th>
                <th align="right" data-order-field="info_from">优惠金额</th>
                <th align="right" data-order-field="storeCount">实付金额</th>
                <th align="center" data-order-field="createdBy">渠道</th>
                <th align="center" data-order-field="createdAt">支付方式</th>
                <th align="center" data-order-field="status" align="center">支付状态</th>
                <th align="center" data-order-field="approve" align="center">支付时间</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
				<tr target="merch_id" data-id="${item.id}">
					<td align="center">${item.merchantName}</td>
					<td>${item.storeName}</td>
					<td align="left">${item.user_order_no}</td>
					<td align="left">${item.transNum }</td>
					<td align="left">${item.trade_no }</td>
					<td align="right"><fmt:formatNumber value="${item.totalPrice}" type="currency"/> </td>
					<td align="right"><fmt:formatNumber type="currency" value="${item.totalPrice - item.transPrice}"/>   </td>
					<td align="right"><fmt:formatNumber value="${item.transPrice}" type="currency"/> </td>
					<td align="center">
						<c:if test="${item.channel == '1'}">支付宝</c:if>  
						<c:if test="${item.channel == '2'}">微信</c:if> 
						<c:if test="${item.channel == '3'}">银联</c:if>  
						<c:if test="${item.channel == '4'}">预存款</c:if>  
					</td>
					<td align="center">
						<c:if test="${item.subChannel == '0'}">支付宝wap</c:if>
						<c:if test="${item.subChannel == '1'}">支付宝条码</c:if>
						<c:if test="${item.subChannel == '2'}">支付宝扫码</c:if>
						<c:if test="${item.subChannel == '3'}">微信wap</c:if>
						<c:if test="${item.subChannel == '4'}">微信条码</c:if>
						<c:if test="${item.subChannel == '5'}">微信扫码</c:if> 
					</td>   
					<td align="center">
						<c:if test="${item.status == '0'}"><font style="color: red;">未付款</font></c:if>  
						<c:if test="${item.status == '1'}">付款中</c:if>  
						<c:if test="${item.status == '2'}"><font style="color:green">已付款</font></c:if>
						<c:if test="${item.status == '3'}">已退款</c:if>
						<c:if test="${item.status == '4'}">退款中</c:if>
						<c:if test="${item.status == '5'}">退款失败</c:if>
						<c:if test="${item.status == '6'}">付款失败</c:if>
						<c:if test="${item.status == '7'}">撤销</c:if>
					</td>
					<td align="center"><fmt:formatDate value="${item.transTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	
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
            value="${pageBean.numPerPage}">
            <c:forEach begin="15" end="90" step="15" varStatus="s">
           		<option value="${s.index}" ${pageBean.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
            </c:forEach>
        </select>
        </div>
        <span>&nbsp;条，共 ${pageBean.totalCount}条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>