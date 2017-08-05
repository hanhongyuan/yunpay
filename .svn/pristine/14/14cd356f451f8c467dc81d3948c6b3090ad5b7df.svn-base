<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/permission/list" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>权限名称：</label><input type="text" name="permissionName" value="${param.permissionName}" size="20" alt="模糊查询" class="form-control" >&nbsp;
            <label>权限标识：</label><input type="text" name="permission" value="${param.permission}" size="20" alt="精确查询" class="form-control" >&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-blue" href="${baseURL}/sys/permission/addUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="添加权限" data-icon="plus">添加权限</button>
                <button type="button" href="${baseURL}/sys/permission/editUI?id={#bjui-selected}" class="btn btn-green" title="修改权限" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal">修改</button>
				<button type="button" href="${baseURL}/sys/permission/delete?permissionId={#bjui-selected}" class="btn btn-red" data-confirm-msg="确定要删除该权限吗?" data-toggle="doajax">删除</button>
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
</div>
<div class="bjui-pageContent tableContent">
    <!-- <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true"> -->
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="index" align="center">序号</th>
                <th data-order-field="permissionName">权限名称</th>
                <th data-order-field="permission">权限标识</th>
                <th data-order-field="remark">描述</th>
                <th data-order-field="createTime">创建时间</th>
                <!-- <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th> -->
            </tr>
        </thead>
        <tbody>
			<c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
				<tr target="sid_user" data-id="${item.id}">
					<td>${st.index+1}</td>
					<td>${item.permissionName }</td>
					<td>${item.permission }</td>
					<td>${item.remark}</td>
					<td>
						<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<%-- <td><input type="checkbox" name="ids" data-toggle="icheck" value="${item.id}"></td> --%>
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
			value="${pageBean.numPerPage}" >
			<c:forEach begin="15" end="90" step="15" varStatus="s">
				<option value="${s.index}" ${pageBean.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
        </div>
        <span>&nbsp;条，共 ${pageBean.totalCount} 条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>
<<script type="text/javascript">
<!--
	function navTabPageBreak(numPerPage){
	
}
//-->
</script>

