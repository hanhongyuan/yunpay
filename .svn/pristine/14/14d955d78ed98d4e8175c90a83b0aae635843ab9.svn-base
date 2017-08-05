<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/upgradePlan/lookup" method="post">
        <div class="bjui-searchBar">
            <label>门店编号：</label><input type="text" name="storeNo" value="${param.storeNo }" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>门店名称：</label><input type="text" name="storeName" value="${param.storeName }" size="15" alt="模糊查询" class="form-control" />&nbsp;
            <label>终端序号：</label><input type="text" name="termSeq" value="${param.termSeq }" size="10" alt="模糊查询" class="form-control" />&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <input type="checkbox" name="lookupType" value="1" data-toggle="icheck" data-label="追加" checked>
            <button type="button" class="btn-blue" data-toggle="lookupback" data-lookupid="ids" data-warn="请至少选择一项" data-icon="check-square-o">选择选中</button>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th width="28px;"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
                <th width="155px;" data-order-field="merchId" align="center">门店编号</th>
                <th data-order-field="storeName" align="center">门店名称</th>
                <th width="100px" data-order-field="termSeq" align="center">终端序号</th>
                <th data-order-field="address" align="center">商户地址</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
                    <tr target="TermMerch">
                        <td><input type="checkbox" name="ids" data-toggle="icheck" value="{infoMsg:'${item.termSeq}'}"></td>
                        <td>${item.storeNo}</td>
                        <td>${item.storeName}</td>
                        <td>${item.termSeq}</td>
                        <td>${item.address}</td>
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