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
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/agent/list" method="post">
        <div class="bjui-searchBar">
            <label>版本号：</label>
			<input type="text" name="verNo" value="${param.verNo}" size="20" maxlength="20"/>
			<label>版本名称：</label>
			<input type="text" name="verName" value="${param.verName}" size="20" maxlength="20"/>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
            	<button type="button" class="btn-blue" href="${baseURL}/sys/sysVersion/addUI" data-toggle="dialog" data-width="600" data-height="300" data-id="dialog-normal" title="新增版本" >添加</button>
            	<button type="button" href="${baseURL}/sys/sysVersion/editUI?verId={#bjui-selected}" class="btn btn-green" title="修改" data-toggle="dialog" data-width="600" data-height="300" data-id="dialog-normal">修改</button>
            	<button type="button" href="${baseURL}/sys/sysVersion/delete?verId={#bjui-selected}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >删除</button>
            	<button type="button" href="" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >测试</button>
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
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed"><!-- data-selected-multi="true" -->
         <thead>
			<tr>
				<th>版本号</th>
				<th>版本名称</th>
				<th>版本类型</th>
				<th>实际存储文件名称</th>
				<th>版本文件名称</th>
				<th>版本说明</th>
				<th>添加人</th>
				<th>添加日期</th>
			</tr>
		 </thead>
		 <tbody>		         	
			<c:forEach var="model" items="${pageBean.recordList }" varStatus="st">
				<tr target="ver_id" data-id="${model.verId}">
					<td>${model.verNo}</td>
	              	<td>${model.verName}</td>
	              	<td>
	              		<c:if test="${model.verType =='1'}">主程序</c:if>
	              		<c:if test="${model.verType =='2'}">升级程序</c:if>
	              	</td>
	                <td>${model.verSavename}</td>
	              	<td>${model.verFilename}</td>
	              	<td>${model.verRmk}</td>
	              	<td>${model.createUser}</td>
	              	<td>${model.createTime}</td>
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
        <span>&nbsp;条，共 ${pageBean.totalCount} 条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页 </span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>
