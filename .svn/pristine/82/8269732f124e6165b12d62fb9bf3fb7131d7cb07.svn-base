<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
</script>
	
<div class="pageContent" >
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/card/receiveList" method="post"><br>
        <div class="bjui-searchBar">
            <label>领取日期</label>
            <input type="text" name="date_begin" value="${cardReceive.date_begin}" size="15"  class="form-control" data-toggle="datepicker"/>&nbsp;
            <label></label>
            <input type="text" name="date_end" value="${cardReceive.date_end}" size="15"  class="form-control" data-toggle="datepicker"/>&nbsp;            
            <input type="hidden" name="cardId" value="${cardReceive.cardId}" size="20"  class="form-control" readonly="readonly"/>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a><br><br>
            <div>
            	<button type="button" href="${baseURL}/sys/card/delete?id={#bjui-selected}" class="btn btn-blue" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >导出</button>
            </div>  
        </div>
    </form>
</div>
<div class="pageContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed"><!-- data-selected-multi="true" -->
        <thead>
            <tr	>
                <th data-order-field="title" align="center">卡券名称</th>
                <th data-order-field="appidUserId" align="center">领取者ID</th>
                <th data-order-field="status" align="center">状态</th>
                <th data-order-field="createdAt" align="center">领取时间</th>                              
                <th data-order-field="useTime" align="center">核销时间</th> 
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">				
				<tr target="id" data-id="${item.id}">
					<td>${item.title }</td>
					<td>${item.appidUserId }</td>
					<td>
						<c:if test="${item.status ==0}">未使用</c:if>
						<c:if test="${item.status ==1}">已使用</c:if>
						<c:if test="${item.status ==2}">已过期</c:if>
						<c:if test="${item.status ==3}">已删除</c:if>				
					</td>
					<td	><fmt:formatDate value="${item.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td	><fmt:formatDate value="${item.useTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
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
