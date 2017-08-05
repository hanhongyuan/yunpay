<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
     $(selector).bjuiajax('refreshLayout', ture);
}
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/upgradePlan/upgradePlanList" method="post">
        <div class="bjui-searchBar">
            <label>计划编号：</label><input type="text" name="planId" value="${param.planId}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>计划名称：</label><input type="text" name="planName" value="${param.planName}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>状态：</label>
                <select name="planStatus" class="combox">
                        <option value=""  selected = 'selected'>--全部--</option>
                        <option value="1" <c:if test="${planStatus eq '1' }">selected = 'selected'</c:if> >启动</option>
                        <option value="2" <c:if test="${planStatus eq '2' }">selected = 'selected'</c:if> >暂停</option>
                        <option value="3" <c:if test="${planStatus eq '3' }">selected = 'selected'</c:if> >作废</option>
                        <option value="4" <c:if test="${planStatus eq '4' }">selected = 'selected'</c:if> >完成</option>
                </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-blue" href="${baseURL}/sys/upgradePlan/addUI" data-toggle="dialog" data-maxable="false" data-width="800" data-height="400" data-id="dialog-normal" title="新增计划" >新增计划</button>
                <button type="button" class="btn-green" href="${baseURL}/sys/upgradePlan/editUI?planId={#bjui-selected}" data-toggle="dialog" data-maxable="false" data-width="800" data-height="400" data-id="dialog-normal" title="修改" >修改</button>
                <button type="button" class="btn-red" href="${baseURL}/sys/upgradePlan/delUpgradePlan?planId={#bjui-selected}" data-toggle="doajax" data-confirm-msg="确定要删除吗？" data-maxable="false" title="删除" >删除</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th align="center">操作</th>
                <th data-order-field="planId" align="center">计划编号</th>
                <th data-order-field="planName" align="center">计划名称</th>
                <th data-order-field="verName" align="center">版本名称</th>
                <th data-order-field="verNo" align="center">版本编号</th>
                <th data-order-field="beginDate" align="center">开始时间</th>
                <th data-order-field="createUser" align="center">创建人</th>
                <th data-order-field="plancreateTime" align="center">创建时间</th>
                <th data-order-field="planStatus" align="center">计划状态</th>
                <th data-order-field="percent" align="center">完成进度</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
                    <tr target="UpgradePlan" data-id="${item.planId}">
                        <td>
                            <button type="button" class="btn-default" href="${baseURL}/sys/upgradePlan/viewUpgradePlan?planId=${item.planId}"  data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal">查看接收详情</button>
                            <c:if test="${item.planStatus eq '1' }"><button type="button" class="btn btn-blue" href="${baseURL}/sys/upgradePlan/EditStatus?planId=${item.planId}&planStatus=2" data-toggle="doajax" data-confirm-msg="确定要暂停吗？">暂停</button></c:if>
                            <c:if test="${item.planStatus eq '2' }"><button type="button" class="btn btn-green" href="${baseURL}/sys/upgradePlan/EditStatus?planId=${item.planId}&planStatus=1" data-toggle="doajax" data-confirm-msg="确定要启动吗？">启动</button></c:if>
                            <c:if test="${item.planStatus eq '3' }"><button type="button" class="btn btn-green" href="${baseURL}/sys/upgradePlan/EditStatus?planId=${item.planId}&planStatus=1" data-toggle="doajax" data-confirm-msg="确定要启动吗？">启动</button></c:if>
                            <button type="button" class="btn btn-red" href="${baseURL}/sys/upgradePlan/EditStatus?planId=${item.planId}&planStatus=3" data-toggle="doajax" data-confirm-msg="确定要作废吗？">作废</button>
                        </td>
                        <td>${item.planId }</td>
                        <td>${item.planName }</td>
                        <td>${item.verName }</td>
                        <td>${item.verNo }</td>
                        <td>${item.beginDate }</td>
                        <td>${item.createUser }</td>
                        <td><fmt:formatDate value="${item.createTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <c:if test="${item.planStatus eq '1' }">启动</c:if>
	                        <c:if test="${item.planStatus eq '2' }">暂停</c:if>
	                        <c:if test="${item.planStatus eq '3' }">作废</c:if>
	                        <c:if test="${item.planStatus eq '4' }">完成</c:if>
                        </td>
                        <td>${item.percent }</td>
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