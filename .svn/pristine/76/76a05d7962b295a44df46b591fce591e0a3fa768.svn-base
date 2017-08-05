<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
     $(selector).bjuiajax('refreshLayout', ture);
}
</script>

<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="detailId" align="center">明细编号</th>
                <th data-order-field="planId" align="center">计划编号</th>
                <th data-order-field="termSeq" align="center">终端序列号</th>
                <th data-order-field="updStatus" align="center">更新状态</th>
                <th data-order-field="beginDate" align="center">开始更新时间</th>
                <th data-order-field="updDate" align="center">更新完成时间</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
                    <tr target="UpgradeDetailPlan">
                        <td>${item.detailId }</td>
                        <td>${item.planId }</td>
                        <td>${item.termSeq }</td>
                        <td>
                            <c:if test="${item.updStatus eq '1'}">开启</c:if>
                            <c:if test="${item.updStatus eq '2'}">暂停</c:if>
                            <c:if test="${item.updStatus eq '3'}">作废</c:if>
                            <c:if test="${item.updStatus eq '4'}">更新成功</c:if>
                            <c:if test="${item.updStatus eq '5'}">更新失败</c:if>
                        </td>
                        <td><fmt:formatDate value="${item.beginDate }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${item.updDate }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
        <span>&nbsp;条，共 ${pageBean.totalCount}条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>