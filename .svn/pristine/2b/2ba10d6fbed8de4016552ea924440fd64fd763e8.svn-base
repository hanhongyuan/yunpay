<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/dictcode/list" method="post">
        <div class="bjui-searchBar">
            <label>引用键值：</label><input type="text" name="typeCode" value="${param.typeCode}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>显示名称：</label><input type="text" name="typeName" value="${param.typeName}" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>所属分类：</label>
                <select name="typeId" class="combox">
                        <option value=""  selected = 'selected'>-全部-</option>
                        
                        <c:forEach var="i" items="${allinfo}" varStatus="st">
	                        <c:if test="${i.typeId eq '0' }">
                                <option value="${i.typeCode }" <c:if test="${TypeCode == i.typeCode}"> selected = 'selected' </c:if>>${i.typeName }</option>
                            </c:if>
                        </c:forEach>
                </select>
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
                <button type="button" class="btn-blue" href="${baseURL}/sys/dictcode/addUI" data-maxable="false" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="添加">添加</button>
                <button type="button" class="btn btn-green" href="${baseURL}/sys/dictcode/editUI?sid={#bjui-selected}" data-maxable="false" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="修改">修改</button>
                <button type="button" class="btn btn-red" href="${baseURL}/sys/dictcode/delete?sid={#bjui-selected}" data-toggle="doajax" data-confirm-msg="确定要删除吗？" data-width="800" data-height="400" data-id="dialog-normal" title="删除">删除</button>
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
                <th data-order-field="typeId" align="center">所属分类</th>
                <th data-order-field="typeCode" align="center">引用键值</th>
                <th data-order-field="typeName" align="center">显示名称</th>
                <th data-order-field="orderNo" align="center">排序号</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
	                <tr target="dictcode"  data-id="${item.sid}">
	                    <td>${st.index+1}</td>
	                    <td>
	                       <c:forEach var="i" items="${allinfo}" varStatus="st">
	                           <c:if test="${item.typeId == i.typeCode}">
                                   ${i.typeName }
                               </c:if>
	                       </c:forEach>
	                    </td>
	                    <td>${item.typeCode}</td>
	                    <td>${item.typeName}</td>
	                    <td>${item.orderNo}</td>
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
        <span>&nbsp;条，共 ${pageBean.totalCount} 条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>

