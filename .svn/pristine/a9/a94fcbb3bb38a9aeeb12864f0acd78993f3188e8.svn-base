<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
//删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
     $(selector).bjuiajax('refreshLayout', ture);
}
$(document).on('bjui.beforeLoadDialog', function(e) {
    var $dialog = $(e.target);
    
    
});
</script>
    
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/merchant/merchNoticeList" method="post" >
        <div class="bjui-searchBar">
            <label>通知标题：</label><input type="text" name="noticeTitle" value="${param.noticeTitle}" size="15" alt="模糊查询" class="form-control" />&nbsp;
            <label>通知类型：</label>
                <select name="noticeType" class="combox">
                        <option value=""  selected = 'selected'>-全部-</option>
                        <option value="1" <c:if test="${noticeType eq '1' }">selected = 'selected'</c:if> >系统广告</option>
                        <option value="2" <c:if test="${noticeType eq '2' }">selected = 'selected'</c:if> >网站广告</option>
                        <option value="3" <c:if test="${noticeType eq '3' }">selected = 'selected'</c:if> >滚动通知</option>
                </select>
            <label>通知级别：</label>
                <select name="noticeGrade" class="combox">
                        <option value=""  selected = 'selected'>-全部-</option>
                        <option value="1" <c:if test="${noticeGrade eq '1' }">selected = 'selected'</c:if> >普通</option>
                        <option value="2" <c:if test="${noticeGrade eq '2' }">selected = 'selected'</c:if> >重要</option>
                </select>    
            <label>通知状态：</label>
                <select name="noticeStatus" class="combox">
                        <option value=""  selected = 'selected'>-全部-</option>
                        <option value="1" <c:if test="${noticeStatus eq '1' }">selected = 'selected'</c:if> >启动</option>
                        <option value="2" <c:if test="${noticeStatus eq '2' }">selected = 'selected'</c:if> >暂停</option>
                </select>    
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn btn-blue" data-href="${baseURL}/sys/merchant/addUI"  data-toggle="dialog" data-width="850" data-height="500" data-id="dialog-normal">添加</button>
                <button type="button" class="btn btn-green" data-href="${baseURL}/sys/merchant/editUI?noticeId={#bjui-selected}" data-toggle="dialog" data-width="850" data-height="500" data-id="dialog-normal">修改</button>
                <button type="button" class="btn btn-red" href="${baseURL}/sys/merchant/delete?noticeId={#bjui-selected}" data-toggle="doajax" data-confirm-msg="确定要删除吗？">删除</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed"><!-- data-selected-multi="true" -->
        <thead>
            <tr>
                <th data-order-field="" align="center" width="180px">操作</th>
                <th data-order-field="noticeTitle" align="center">通知标题</th>
                <th data-order-field="noticeType" align="center">通知类型</th>
                <th data-order-field="noticeShortMsg" align="center">通知简文</th>
                <th data-order-field="useDate" align="center">生效日期</th>
                <th data-order-field="noticeGrade" align="center">通知级别</th>
                <th data-order-field="noticeStatus" align="center">通知状态</th>
                <th data-order-field="createUser" align="center">添加人</th>
                <th data-order-field="createDate" align="center">添加时间</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
                <tr data-target="merch_id" data-id="${item.noticeId }">
                    <td>
                        <button type="button" class="btn-default" data-href="${baseURL}/sys/merchant/viewNoticeRecv?noticeId=${item.noticeId}"  data-toggle="dialog" data-width="600" data-height="400" data-id="dialog-normal">查看接收详情</button>
                        <c:if test="${item.noticeStatus eq '1'}">
                            <a href="${baseURL}/sys/merchant/editStutas?noticeId=${item.noticeId}&status=2" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要停用吗？">停用</a>
                        </c:if>
                        <c:if test="${item.noticeStatus eq '2'}">
                            <a href="${baseURL}/sys/merchant/editStutas?noticeId=${item.noticeId}&status=1" class="btn btn-green" data-toggle="doajax" data-confirm-msg="确定要启用吗？">启用</a>
                        </c:if>
                    </td>
                    <td>${item.noticeTitle }</td>
                    <td>
                        <c:if test="${item.noticeType eq '1'}">系统广告</c:if>
                        <c:if test="${item.noticeType eq '2'}">网站广告</c:if>
                        <c:if test="${item.noticeType eq '3'}">滚动通知</c:if>
                    </td>
                    <td>${item.noticeShortMsg }</td>
                    <td>${item.useDate}</td>
                    <td>
                        <c:if test="${item.noticeGrade eq '1'}">普通</c:if>
                        <c:if test="${item.noticeGrade eq '2'}">重要</c:if>
                    </td>
                    <td>
                        <c:if test="${item.noticeStatus eq '1'}">启动</c:if>
                        <c:if test="${item.noticeStatus eq '2'}">暂停</c:if>
                    </td>
                    <td>${item.createUser}</td>
                    <td>${item.createDate}</td>
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
