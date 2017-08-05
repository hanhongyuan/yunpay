<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<%
String  baseURL = "/yunpay-web-oms/";
%>
<link rel="stylesheet" href="<%=baseURL%>static/BJUI/plugins/bootstrapSelect/bootstrap-select.css">

<script src="<%=baseURL%>static/js/biz-js/merchant.js" type="text/javascript"></script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" method="post" action="${baseURL}/sys/merchant/list">
        <div class="bjui-searchBar">
            <label>商户号：</label><input type="text" name="serialNo" value="${requestScope.serialNo}" size="15" alt="模糊查询" class="form-control" />&nbsp;
            <label>商户名称：</label><input type="text" name="registerName" value="${requestScope.registerName}" size="15" alt="模糊查询" class="form-control" />&nbsp;
            <label>联系人：</label><input type="text" name="contactMan" value="${requestScope.contactMan}" size="15" alt="模糊查询" class="form-control" />&nbsp;
            <label>手机：</label><input type="text" name="tel" value="${requestScope.tel}" size="15" alt="模糊查询" class="form-control" />&nbsp;
            
            <label>区域：</label>
            <select id="province" name="prov" class="selectpicker show-menu-arrow form-control" onchange="getCity($(this))"><option value="">请选择省份</option>
        	<c:forEach var="item" items="${requestScope.provinceMap}" varStatus="i" >
        	<option value="${item.key}" <c:if test="${requestScope.prov eq item.key}"> selected="selected" </c:if> >${item.value}</option>  
        	</c:forEach>
        	</select>
        	
        	<select id="city" name="city" class="selectpicker show-menu-arrow form-control" onchange="getArea($(this))">
        	<option value="">请选择市</option>
        	<c:forEach var="item" items="${requestScope.cityList}" varStatus="i" >
        	<option value="${item.id}" <c:if test="${requestScope.city eq item.id}"> selected="selected" </c:if> > ${item.title}</option>
        	</c:forEach>
        	</select>
        	
        	<select id="area" name="area" class="selectpicker show-menu-arrow form-control">
        	<option value="">请选择区</option>
        	<c:forEach var="item" items="${requestScope.areaList}" varStatus="i" >
        	<option value="${item.id}" <c:if test="${requestScope.area eq item.id}"> selected="selected" </c:if> > ${item.title}</option>
        	</c:forEach>
        	</select>
        	
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
            	<button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/editUI?serialNo={#bjui-selected}" title="录入商户信息" data-toggle="dialog" data-width="600" data-height="400" data-id="dialog-normal">录入</button>
            	<button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/editUI?serialNo={#bjui-selected}" title="编辑商户信息" data-toggle="dialog" data-width="600" data-height="400" data-id="dialog-normal">编辑</button>
                <button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/editAttachmentUI?serialNo={#bjui-selected}" title="商户账户信息" data-toggle="dialog" data-width="800" data-height="500" data-id="dialog-normal">账户信息</button>
                <button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/editAttachmentUI?serialNo={#bjui-selected}" title="商户附件信息" data-toggle="dialog" data-width="800" data-height="500" data-id="dialog-normal">附件信息</button>
                <button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/payConfig?serialNo={#bjui-selected}" title="支付配置" data-toggle="dialog" data-width="1000" data-height="420" data-id="dialog-normal">支付配置</button>
                <button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/editAttachmentUI?serialNo={#bjui-selected}" title="查看商户信息" data-toggle="dialog" data-width="800" data-height="600" data-id="dialog-normal">查看</button>
                <button type="button" class="btn btn-green" onclick="outExcel('merchExcelForm')">导出</button>
                <div class="pull-right">
                
                <div class="btn-group">
                    <button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown" data-icon="copy">批量操作<span class="caret"></span></button>
                    <ul class="dropdown-menu right" role="menu">
                        <li><a href="book1.xlsx" data-toggle="doexport" data-confirm-msg="确定要导出信息吗？">导出<span style="color: green;">全部</span></a></li>
                        <li><a href="book1.xlsx" data-toggle="doexportchecked" data-confirm-msg="确定要导出选中项吗？" data-idname="expids" data-group="ids">导出<span style="color: red;">选中</span></a></li>
                        <li class="divider"></li>
                        <li><a href="ajaxDone2.html" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids">删除选中</a></li>
                    </ul>
                </div>
            </div>
            </div>
        </div>
    </form>
    
    <!-- excel导出需要的Form -->
    <div id="merchExcelDiv" style="display: none;">
    	<form id="merchExcelForm"  method="post" action="${baseURL}/sys/merchant/exportExcel">
            <input type="hidden" name="serialNo" value="${requestScope.serialNo}"  />
            <input type="hidden" name="registerName" value="${requestScope.registerName}"  />
            <input type="hidden" name="contactMan" value="${requestScope.contactMan}"  />
            <input type="hidden" name="tel" value="${requestScope.tel}" />
        	<input type="hidden"   name="prov" value="${requestScope.prov}"/>
        	<input type="hidden"   name="city" value="${requestScope.city}"/>
        	<input type="hidden"   name="area" value="${requestScope.area}"/>
    	</form>
    </div>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" ><!-- data-selected-multi="true" -->
        <thead>
            <tr>
                <th align="center" data-order-field="serialNo" >商户号</th>
                <th align="center" data-order-field="registerName">商户名称</th>            
                <th align="center" data-order-field="contactMan">联系人</th>
                <th align="center" data-order-field="tel">手机号码</th>             
                <th align="center" data-order-field="prov">省市区</th>
                <th align="center" data-order-field="industryTypeId">所属行业</th>
                <th align="center" data-order-field="info_from">信息来源</th>
                <th align="center" data-order-field="storeCount">门店数量</th>
                <th align="center" data-order-field="createdBy">录入人</th>
                <th align="center" data-order-field="createdAt">录入时间</th>
                <th align="center" data-order-field="status" align="center">状态</th>
                <th align="center" data-order-field="checkStatus" align="center">审核状态</th>
                <th align="center" align="center">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
				<tr target="merch_id" data-id="${item.serialNo}">
					<td align="center">${item.serialNo}</td>
					<td>${item.registerName }</td>
					<td align="center">${item.contactMan }</td>
					<td>${item.tel }</td>
					<td align="center">${item.prov}</td>
					<td align="center">${item.industryTypeId}</td>
					<td align="center"><c:if test="${item.info_from == '1'}">平台系统 </c:if><c:if test="${item.info_from == '2'}">代理商系统 </c:if></td>
					<td align="center">${item.storeCount}</td>
					<td align="center"> ${item.createdBy}</td>
					<td align="center"><fmt:formatDate value="${item.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td align="center"><c:if test="${item.status == '0'}">停用 </c:if><c:if test="${item.status == '1'}">启用 </c:if></td>
					<td align="center"><c:if test="${item.checkStatus == '1'}">审批通过 </c:if><c:if test="${item.checkStatus == '0'}">审批退回 </c:if></td>
					<td align="center">
					     <button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/editAttachmentUI?serialNo={#bjui-selected}" title="停用商户" data-toggle="dialog" data-width="800" data-height="500" data-id="dialog-normal">停用</button>
						 <button type="button" class="btn btn-green" href="${baseURL}/sys/merchant/delete?serialNo={#bjui-selected}" title="删除商户信息" data-toggle="dialog" data-width="800" data-height="500" data-id="dialog-normal">删除</button>
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