<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/logs/list" method="post">
        <div class="bjui-searchBar">
            <label>登录名：</label><input type="text" name="login_name" value="${param.login_name}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>操作时间：</label>
            <input type="text" name="contract_begin" value="${param.contract_begin}" data-toggle="datepicker" readonly style="width:120px;"/>
            --
            <input type="text" name="contract_end" value="${param.contract_end}" data-toggle="datepicker" readonly style="width:120px;"/>
            <label>操作类型：</label>
                <select name="log_type" class="combox">
                        <option value=""  selected = 'selected'>-全部-</option>
                        
                        <c:forEach var="i" items="${allinfo}" varStatus="st">
                            <option value="${i.log_type }" <c:if test="${log_type == i.log_type}"> selected = 'selected' </c:if>>
	                            ${i.log_type_name}
                            </option>
                        </c:forEach>
                </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-green" href="${baseURL}/sys/logs/view?logid={#bjui-selected}" data-toggle="dialog" data-maxable="false" data-width="800" data-height="400" data-id="dialog-normal" title="查看" >查看</button>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <!-- <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true"> -->   
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th align="center">编号</th>
                <th data-order-field="log_time" align="center">操作时间</th>
                <th data-order-field="log_type" align="center">日志类型</th>
                <th data-order-field="log_content" align="center">功能描述</th>
                <th data-order-field="ip" align="center">ip地址</th>
                <th data-order-field="login_name" align="center">登录名</th>
                <th data-order-field="user_name" align="center">操作者名称</th>
                <th data-order-field="result" align="center">操作结果</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
	                <tr target="logs" data-id="${item.log_id}">
	                    <td>${st.index+1}</td>
	                    <td>
	                       <fmt:formatDate value="${item.log_time }" pattern="yyyy-MM-dd HH:mm:ss"/>
	                    </td>
	                    <td>
	                       <c:forEach var="i" items="${allinfo}" varStatus="st">
                                <c:if test="${item.log_type eq i.log_type}">
                                    ${i.log_type_name}
                                </c:if>
	                       </c:forEach>
	                    </td>
	                    <td>${item.log_content }</td>
	                    <td>${item.ip }</td>
	                    <td>${item.login_name }</td>
	                    <td>${item.user_name }</td>
	                    <td>
	                        <c:if test="${item.result eq '1'}">成功</c:if>
                            <c:if test="${item.result eq '2'}">失败</c:if>
                            <c:if test="${item.result eq '3'}">异常</c:if>
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