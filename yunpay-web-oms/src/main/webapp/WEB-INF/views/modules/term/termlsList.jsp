<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL}/sys/termls/list" method="post">
        <div class="bjui-searchBar">
            <table>
                <tr>
                    <td>
                        <label>操作日期：</label>
		                <input type="text" name="contract_begin" value="${param.contract_begin}" data-toggle="datepicker" readonly style="width:120px;"/> --
		                <input type="text" name="contract_end" value="${param.contract_end}" data-toggle="datepicker" readonly style="width:120px;"/>
                    </td>
                    <td>
                        <label>终端编码：</label>
                        <input type="text" size="12" name="termId" value="${param.termId}" size="20" alt="模糊查询" class="form-control" />
                    </td>
                    <td>
                        <label>终端序列号：</label>
                        <input type="text" size="12" name="termSeq" value="${param.termSeq }" size="20" alt="模糊查询" class="form-control" />
                    </td>
                    <td>
                        <label>厂商&型号：</label>
                        <select name="firm" class="combox" id="term_list_firm" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#term_list_typeId" data-refurl="${baseURL}/sys/termls/findtypeId?code={value}" >
                                <option value=""  selected = 'selected'>--请选择--</option>
                                
                                <c:forEach var="i" items="${firmList }" varStatus="st">
                                    <option value="${i.code }" <c:if test="${firm == i.code }">selected = 'selected'</c:if> >${i.name}</option>
                                </c:forEach>
                        </select>
                        <select name="typeId" class="combox" id="term_list_typeId" data-toggle="selectpicker" data-emptytxt="--请选择--" >
                                <option value=""  selected = 'selected'>--请选择--</option>
                                
                                <c:forEach var="i" items="${typeIdList }" varStatus="st">
                                    <option value="${i.code }" <c:if test="${typeId == i.code }">selected = 'selected'</c:if> >${i.name}</option>
                                </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>品牌名称：</label>
                        <input type="text" size="12" name="merchName" value="${param.merchName }" size="20" alt="模糊查询" class="form-control" />
                    </td>
                    <td>
                        <label>门店名称：</label>
                        <input type="text" size="12" name="storeName" value="${param.storeName }" size="20" alt="模糊查询" class="form-control" />
                    </td>
                    <td>
                        <label>&nbsp;&nbsp;&nbsp;操作类型：</label>
                        <select name="dealType" class="combox">
                                <option value=""  selected = 'selected'>--请选择--</option>
                                
                                <c:forEach var="i" items="${dealtypeList }" varStatus="st">
                                    <option value="${i.dealType }"  <c:if test="${dealType == i.dealType }">selected = 'selected'</c:if> >
                                        <c:if test="${i.dealType eq '1'}">新装机</c:if>
                                        <c:if test="${i.dealType eq '3'}">撤机</c:if>  
                                    </option>
                                </c:forEach>
                        </select>
                    </td>
                    <td>
                        <button type="submit" class="btn-default" data-icon="search">查询</button>
                        <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="termSeq" align="center">终端序列号</th>
                <th data-order-field="termId" align="center">终端编码</th>
                <th data-order-field="merchName" align="center">品牌名称</th>
                <th data-order-field="storeName" align="center">门店名称</th>
                <th data-order-field="firm" align="center">厂商型号</th>
                <th data-order-field="gprsNo" align="center">GPRS卡号</th>
                <th data-order-field="dealType" align="center">操作类型</th>
                <th data-order-field="oprUser" align="center">操作人</th>
                <th data-order-field="oprDate" align="center">操作时间</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
	                <tr target="logs">
	                    <td>${item.termSeq }</td>
	                    <td>${item.termId }</td>
	                    <td>${item.merchName }</td>
	                    <td>${item.storeName }</td>
	                    <td>${item.firm }${item.typeId }</td>
	                    <td>${item.gprsNo }</td>
	                    <td>
	                       <c:if test="${item.dealType eq '1'}">新装机</c:if>
                           <c:if test="${item.dealType eq '3'}">撤机</c:if>
                        </td>
	                    <td>${item.oprUser }</td>
	                    <td>${item.oprDate }</td>
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