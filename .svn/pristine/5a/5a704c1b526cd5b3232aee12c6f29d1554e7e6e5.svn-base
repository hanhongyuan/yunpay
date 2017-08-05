<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<% String  baseURL = "/yunpay-web-oms/"; %>
<script src="<%=baseURL%>static/js/biz-js/store.js" ></script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/store/list" method="post">
        <div class="bjui-searchBar">
            <label>门店名称：</label><input type="text" name="storeName" value="${param.storeName }" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>商户名称：</label><input type="text" name="registerName" value="${param.registerName }" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>联系人：</label><input type="text" name="contactMan" value="${param.contactMan}" size="10" alt="模糊查询" class="form-control" />&nbsp;
            <label>手机：</label><input type="text" name="tel" value="${param.tel}" size="10" alt="精确查询" class="form-control" />&nbsp;           
            <label class="control-label x90">行政区域：</label>  
            	<select id="provName" name="provName" class="selectpicker show-menu-arrow form-control" onchange="getCity($(this))">
            		<option value="">请选择省份</option>
        			<c:forEach var="item" items="${requestScope.provMap}" varStatus="i" >
        			<option value="${item.key}" <c:if test="${requestScope.prov==item.key}"> selected="selected" </c:if> >${item.value}</option>
        			</c:forEach>
        		</select>
        		<select id="cityName" name="cityName" class="selectpicker show-menu-arrow form-control" onchange="getArea($(this))">
        			<option value="">请选择市</option>
        			<c:forEach var="item" items="${requestScope.cityMap}" varStatus="i" >
        			<option value="${item.key}" <c:if test="${requestScope.city==item.key}"> selected="selected" </c:if> >${item.value}</option>
        			</c:forEach>
        		</select>
        		<select id="areaName" name="areaName" class="selectpicker show-menu-arrow form-control">
        			<option value="">请选择区</option>
        			<c:forEach var="item" items="${requestScope.areaMap}" varStatus="i" >
        			<option value="${item.key}" <c:if test="${requestScope.area==item.key}"> selected="selected" </c:if> >${item.value}</option>
        			</c:forEach>
        		</select>            	
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-blue"  href="${baseURL}/sys/store/addUI" data-toggle="dialog" data-maxable="false" data-width="800" data-height="400" data-id="dialog-normal" title="添加">添加</button>
                <button type="button" class="btn-green" href="${baseURL}/sys/store/editUI?storeNo={#bjui-selected}" data-maxable="false" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="修改" >修改</button>
                <button type="button" class="btn-red"   href="${baseURL}/sys/store/delete?storeNo={#bjui-selected}" data-toggle="doajax" data-confirm-msg="确定要删除吗？" data-id="dialog-normal" title="删除" >删除</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <!-- <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true"> -->   
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="storeNo" align="center">门店号</th>
                <th data-order-field="storeName" align="center">门店名称</th>
                <th data-order-field="registerName" align="center">商户名称</th>
                <th data-order-field="contactMan" align="center">联系人</th>
                <th data-order-field="tel" align="center">联系人电话</th>
                <th data-order-field="region" align="center">行政区域</th>
                <th data-order-field="address" align="center">详细地址</th>                
                <th data-order-field="createdAt" align="center">录入时间</th>
                <th data-order-field="createdAt" align="center">信息来源</th>
                <th data-order-field="status" align="center">状态</th>
                <th data-order-field="" align="center">操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
	                <tr target="Store" data-id="${item.id}">
	                    <td>${item.storeNo}</td>
	                    <td>${item.storeName}</td>
	                    <td>${item.registerName}</td>
	                    <td>${item.contactMan}</td>
	                    <td>${item.tel}</td>
	                    <td>${item.provName}-${item.cityName}-${item.areaName}</td>
	                    <td>${item.address}</td> 
	                    <td><fmt:formatDate value="${item.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
	                    <td>
							<c:if test="${item.informationSources ==1}">商户系统</c:if>
							<c:if test="${item.informationSources ==0}">平台系统</c:if>
						</td>
	                    <td>
	                       <c:if test="${item.status==0}">停用</c:if>	                      
	                       <c:if test="${item.status==1}">启用</c:if>
	                    </td>
	                    <td>
	                    	<c:if test="${item.status==0}">
                                <a href="${baseURL}/sys/store/EditStatus?id=${item.id}&status=1" class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要停用吗？">启用</a>
                        	</c:if>
	                    	<c:if test="${item.status==1}">
                                <a href="${baseURL}/sys/store/EditStatus?id=${item.id}&status=0" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要启用吗？">停用</a>                        		
                        	</c:if>
                        	<button type="button" href="${baseURL}/sys/store/delete?storeNo=${item.storeNo}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >删除</button>
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