<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
</script>
	
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/tranType/list" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
            <label>交易类型码：</label><input type="text" name="tranType" value="${param.tranType}" size="20" class="form-control" />&nbsp;
            <label>类型名称：</label><input type="text" name="tranDesc" value="${param.tranDesc}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>应用类型：</label><select name="appType" data-toggle="selectpicker">
            						<option value="">--请选择--</option>
            						<c:forEach var="itms" items="${appifnoList}" varStatus="st">
				                        <option value="${itms.name}" <c:if test="${tranType.appType == itms.name }">selected = 'selected'</c:if>>${itms.name}</option>
				                    </c:forEach>
			                      </select>		
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-blue" href="${baseURL}/sys/tranType/addUI" data-toggle="dialog" data-width="650" data-height="400" data-id="dialog-normal" title="添加" data-icon="plus">添加</button>
                <button type="button" href="${baseURL}/sys/tranType/editUI?tranType={#bjui-selected}" class="btn btn-green" title="修改【${model.tranDesc}】" data-toggle="dialog" data-width="650" data-height="400" data-id="dialog-normal">修改</button>
				<button type="button" href="${baseURL}/sys/tranType/delete?tranType={#bjui-selected}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除【${model.tranDesc}】吗？" >删除</button>
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
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" ><!-- data-selected-multi="true" -->
        <thead>
            <tr>
                <th data-order-field="tranType" align="center">交易类型码</th>
                <th data-order-field="appType">应用名称</th>
                <th data-order-field="tranDesc">类型名称</th>
                <th data-order-field="tranAuth">交易授权控制</th>
                <th data-order-field="tranKind">交易类别</th>
                <th data-order-field="tranPFlag">交易处理标志</th>
                <th data-order-field="tranCd">借贷标志</th>
                <th data-order-field="settleFlag">清算标志</th>
                <th data-order-field="origTranType">原始交易类型</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="model" items="${pageBean.recordList}" varStatus="st">
				<!-- 普通操作员看不到超级管理员信息 -->
				<tr target="tranCode" data-id="${model.tranType}">
					<td >${model.tranType}</td>
	                <td>${model.appType}</td>
	                <td>${model.tranDesc}</td>
	                <td>${model.tranAuth}</td>
	                <td>${model.tranKind}</td>
	                <td>${model.tranPFlag}</td>
	                <td>
	                	<c:if test="${model.tranCd == 1}">借记</c:if>
	                    <c:if test="${model.tranCd == 2}">贷记</c:if>
	                </td>
	                <td>
	                	<c:if test="${model.settleFlag ==0}">否</c:if>
	                	<c:if test="${model.settleFlag ==1}">是</c:if>
	                </td>
	                <td>${model.origTranType}</td>
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
			value="${pageBean.numPerPage}" onchange="navTabPageBreak({numPerPage:this.value})">
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
