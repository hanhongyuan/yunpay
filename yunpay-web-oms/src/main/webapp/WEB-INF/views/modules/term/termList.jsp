<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/term/list" method="post">
        <div class="bjui-searchBar">
            <label>商户名称：</label>
                        <input type="text" size="12" name="merchName" value="${param.merchName}" alt="模糊查询" class="form-control" />&nbsp;   
            <label>门店名称：</label>
                        <input type="text" size="12" name="storeName" value="${param.storeName}" alt="模糊查询" class="form-control" />&nbsp;
            <label>机器SN号：</label>&nbsp;
                        <input type="text" size="12" name="termSeq" value="${param.termSeq }" alt="模糊查询" class="form-control" />&nbsp;
            <label>终端号：</label>
                        <input type="text" size="12" name="termId" value="${param.termId }" alt="模糊查询" class="form-control" />&nbsp;
            <label>SAM卡号：</label>
                        <input type="text" size="12" name="pwdKeyboard" value="${param.pwdKeyboard }" alt="精准查询" class="form-control" />&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-blue"  href="${baseURL}/sys/term/addUI" data-maxable="false" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="添加">添加</button>
                <button type="button" class="btn-green" href="${baseURL}/sys/term/editUI?termId={#bjui-selected}" data-maxable="false" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="修改" >修改</button>
                <button type="button" class="btn-red"   href="${baseURL}/sys/term/delete?termId={#bjui-selected}" data-toggle="doajax" data-confirm-msg="确定要撤机吗？" data-id="dialog-normal" title="撤机" >撤机</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="" align="center">操作</th>
                <th data-order-field="merchName" align="center">商户名称</th>
                <th data-order-field="storeName" align="center">门店名称</th>
                <th data-order-field="termSeq" align="center">机器SN号</th>
                <th data-order-field="termId" align="center">终端号</th>
                <th data-order-field="transferType" align="center">通讯类型</th>
                <th data-order-field="pwdKeyboard" align="center">SAM卡号</th>
                <th data-order-field="createUser" align="center">建档人</th>
                <th data-order-field="createDate" align="center">建档时间</th>
                <th data-order-field="status" align="center">状态</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
	                <tr target="term" data-id="${item.termId }">
	                    <td>
	                       <c:if test="${item.status eq '01'}">
                                <a href="${baseURL}/sys/term/EditStatus?termSeq=${item.termSeq }&status=04" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要停用吗？">停用</a>
                           </c:if>
                           <c:if test="${item.status eq '04'}">
                                <a href="${baseURL}/sys/term/EditStatus?termSeq=${item.termSeq }&status=01" class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要启用吗？">启用</a>
                           </c:if>
	                    </td>
	                    <td>${item.merchName }</td>
	                    <td>${item.storeName }</td>
	                    <td>${item.termSeq }</td>
	                    <td>${item.termId}</td>
	                    <td>${item.transferType }</td>
	                    <td>${item.pwdKeyboard }</td>
	                    <td>${item.createUser }</td>
	                    <td>${item.createDate }</td>
	                    <td>
	                       <c:if test="${item.status eq '01'}">开通</c:if>
	                       <c:if test="${item.status eq '04'}">停用</c:if>
	                       <c:if test="${item.status eq '05'}">作废</c:if>
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