<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
$(document).on('bjui.beforeLoadDialog', function(e) {
    var $dialog = $(e.target);    
});
</script>
	
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/agent/list" method="post"><br>
        <div class="bjui-searchBar">
            <label>代理商名称：</label><input type="text" name="companyName" value="${param.companyName}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>联系人：</label><input type="text" name="contactMan" value="${param.contactMan}" size="20" alt="模糊查询" class="form-control" />&nbsp;		
            <label>手机：</label><input type="text" name="tel" value="${param.tel}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a><br><br>
            <div>
            	<button type="button" class="btn-blue" href="${baseURL}/sys/agent/addUI" data-toggle="dialog" data-width="650" data-height="350" data-id="dialog-normal" title="添加代理商" >录入</button>
            	<button type="button" href="${baseURL}/sys/agent/editUI?agentSerialNo={#bjui-selected}" class="btn btn-green" title="编辑" data-toggle="dialog" data-width="650" data-height="350" data-id="dialog-normal">编辑</button>
            	<button type="button" href="${baseURL}/sys/agent/checkUI?agentSerialNo={#bjui-selected}" class="btn btn-green" title="查看" data-toggle="dialog" data-width="650" data-height="350" data-id="dialog-normal">查看</button>
            	<button type="button" href="${baseURL}/sys/agent/delete?agentSerialNo={#bjui-selected}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >导出</button>
<!--                 <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown" data-icon="copy">批量操作<span class="caret"></span></button>
                    <ul class="dropdown-menu right" role="menu">
                        <li><a href="book1.xlsx" data-toggle="doexport" data-confirm-msg="确定要导出信息吗？">导出<span style="color: green;">全部</span></a></li>
                        <li><a href="book1.xlsx" data-toggle="doexportchecked" data-confirm-msg="确定要导出选中项吗？" data-idname="expids" data-group="ids">导出<span style="color: red;">选中</span></a></li>
                        <li class="divider"></li>
                        <li><a href="ajaxDone2.html" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids">删除选中</a></li>
                    </ul>
                </div>
            </div> -->  
            </div>  
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed"><!-- data-selected-multi="true" -->
        <thead>
            <tr	>
                <th data-order-field="agentSerialNo" align="center">代理商编码</th>
                <th data-order-field="companyName" align="center">代理商名称</th>
                <th data-order-field="contactMan" align="center">联系人</th>
                <th data-order-field="tel" align="center">联系电话</th>
                <th data-order-field="superiorAgent" align="center">上级代理商</th>
                <th data-order-field="region" align="center">行政区域</th>
                <th data-order-field="address" align="center">详细地址</th>
                <th data-order-field="informationSources" align="center">信息来源</th>
                <th data-order-field="status" align="center">状态</th>                
                <th data-order-field="auditStatus" align="center">审核状态</th>
                <th data-order-field="createdAt" align="center">录入时间</th>
                <th data-order-field="" align="center">操作</th>                
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
				<!-- 普通操作员看不到超级管理员信息 -->
				<tr target="agentId" data-id="${item.agentId}">
					<td>${item.agentSerialNo}</td>
					<td>${item.companyName }</td>
					<td>${item.contactMan }</td>
					<td>${item.tel }</td>
					<td>${item.superiorAgent }</td>
					<td>${item.prov}-${item.city}-${item.area}</td>
					<td>${item.address }</td>					
					<td>
						<c:if test="${item.informationSources ==1}">商户系统</c:if>
						<c:if test="${item.informationSources ==0}">平台系统</c:if>
					</td>
					<td>
						<c:if test="${item.status ==1}">启用</c:if>
						<c:if test="${item.status ==0}">停用</c:if>
					</td>
					<td>
						<c:if test="${item.auditStatus ==0}">审核中</c:if>
						<c:if test="${item.auditStatus ==1}">审核通过</c:if>
						<c:if test="${item.auditStatus ==2}">回退</c:if>
						<c:if test="${item.auditStatus ==3}">驳回</c:if>
					</td>
					<td	><fmt:formatDate value="${item.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td>
						<c:if test="${item.status==0}">
                        	<a href="${baseURL}/sys/agent/EditStatus?agentId=${item.agentId}&status=1" class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要启用吗？">启用</a>
                        </c:if>
	                    <c:if test="${item.status==1}">
                        	<a href="${baseURL}/sys/agent/EditStatus?agentId=${item.agentId}&status=0" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要停用吗？">停用</a>
                        </c:if>
							<button type="button" href="${baseURL}/sys/agent/delete?agentSerialNo=${item.agentSerialNo}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >删除</button>
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
            <select data-toggle="selectpicker" data-toggle-change="changepagesize" name="numPerPage" value="${pageBean.numPerPage}">
			<c:forEach begin="15" end="90" step="15" varStatus="s">
				<option value="${s.index}" ${pageBean.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
        </div>
        <span>&nbsp;条，共 ${pageBean.totalCount} 条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页 </span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>
