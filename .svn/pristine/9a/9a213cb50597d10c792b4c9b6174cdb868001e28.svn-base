<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var MenuDel = {
	// 删除后的回调函数，刷新树形菜单
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).bjuiajax('refreshDiv', 'layout_menu_list');
			$(this).alertmsg('ok', '删除成功！');
		}else{
			 $(this).alertmsg('error', '删除失败！');
		}
	}
};
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/area/view" method="post">
    	<input type="hidden" name="pageNum" value="${pageParam.pageNum}" />
		<input type="hidden" name="numPerPage" value="${pageParam.numPerPage}" />
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar" >
           <%-- <label>菜单名称：</label><input type="text" name="areaCode" value="${areaCode}" size="30" class="form-control" />
           <label>区域名称：</label><input type="text" name="areaName" value="${areaName}" size="30" class="form-control" />
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a> --%>
            <div>
            	<%-- <a class="add" href="${baseURL}/sys/user/addUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" rel="input" title="添加操作员"> --%>
                <button type="button" class="btn-blue" href="${baseURL}/sys/menu/addUI?id=${sysMenu.id}" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="添加菜单" data-icon="plus">添加菜单</button>
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
            	<th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
                <th data-order-field="name">菜单名称</th>
                <th data-order-field="number">菜单编号</th>
                <th data-order-field="url">请求URL</th>
                <th data-order-field="targetName">navTabId</th>
                <th data-order-field="creater">创建人</th>
                <th data-order-field="createTime">创建时间</th>
                <th width="350">操作</th>
                <!-- <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th> -->
            </tr>
        </thead>
        <tbody>
			<%-- <c:forEach var="item" items="${sysMenu}"> --%>
				<tr>
					<td><input type="checkbox" name="ids" data-toggle="icheck" value="${sysMenu.id}"></td>
					<td>${sysMenu.name }</td>
					<td>${sysMenu.number}</td>
					<td>${sysMenu.url}</td>
					<td>${sysMenu.targetName}</td>
					<td>${sysMenu.creater}</td>
					<td>
						<fmt:formatDate value="${sysMenu.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>
						<a href="${baseURL}/sys/menu/delete?menuId=${sysMenu.id}" class="btn btn-red" data-callback="MenuDel.navTabAjax" data-toggle="doajax" data-confirm-msg="确定要删除【${sysMenu.name}】吗?">删除</a>
						<a href="${baseURL}/sys/menu/editUI?id=${sysMenu.id}" class="btn btn-green" data-confirm-msg="修改【${sysMenu.name}】" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal">修改</a>	
					</td>
				</tr>
			<%-- </c:forEach> --%>
		</tbody>
    </table>
</div>
 <div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize" name="numPerPage"
			value="${pageBean.numPerPage}" onchange="navTabPageBreak({numPerPage:this.value})">
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

<!-- <script type="text/javascript">
	// 删除后的回调函数，刷新树形菜单
	function navTabAjax(json) {
		//navTabAjaxDone(json);
		navTab.reload();
	}
</script>
</html> -->