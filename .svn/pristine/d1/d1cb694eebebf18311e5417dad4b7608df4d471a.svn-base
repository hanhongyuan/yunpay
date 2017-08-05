<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
//删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
$(document).on('bjui.beforeLoadDialog', function(e) {
    var $dialog = $(e.target);
    
    
})
</script>
	
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/tranInfo/tranInfoList" method="post" >
        <div class="bjui-searchBar">
	        <p>
				<label>商户号：</label><input type="text" name="merchId"  value="${param.merchId}" size="15"  maxlength="20" class="form-control"/>
				<label>终端号：</label><input type="text" name="termId" value="${param.termId}" size="15"  maxlength="8" class="form-control"/>
				<label>批次号：</label><input type="text" name="batchNo" value="${param.batchNo}" size="15"  maxlength="10" class="form-control"/>
			</p>
			<label>交易类型：</label>
			<select name="tranType" data-toggle="selectpicker">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${ tranTypeList}">
					<option value="${item.code }" <c:if test="${typeCode eq item.code }">selected='selected'</c:if> >${item.name }</option>
				</c:forEach>
			</select>
			<label>交易状态：</label>
			<select name="tranStatus" data-toggle="selectpicker">
				<option value="">--请选择--</option>
				<option value="0" <c:if test="${status eq '0' }">selected='selected'</c:if>>预计</option>
				<option value="1" <c:if test="${status eq '1' }">selected='selected'</c:if>>成功</option>
				<option value="2" <c:if test="${status eq '2' }">selected='selected'</c:if>>失败</option>
			</select>
			<label>交易日期：</label>
			<input type="text" name="date1" value="${date1}" data-toggle="datepicker" readonly style="width:120px;"/>
           	--
           	<input type="text" name="date2" value="${date2}" data-toggle="datepicker" readonly style="width:120px;"/>
			<button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
			<button type="button" class="btn-default" href="${baseURL}/sys/tranInfo/tranInfoExcel" data-toggle="doexport" data-id="dialog-normal" data-confirm-msg="确定要导出吗？" title="导出" ><i class="fa fa-download"></i>导出</button>
		</div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-top" data-toggle="tablefixed" style="width:90%"><!-- data-selected-multi="true" -->
        <thead>
            <tr>
            	<th width="5%">查看</th>
            	<th width="4%">交易标志</th>
            	<th width="9%">商户编码</th>
				<th width="11%">商户名称</th>
				<th width="11%">门店名称</th>
				<th width="5%">终端编码</th>
				<th width="9%">交易类型</th>
				<th width="5%">交易金额</th>
				<th width="5%">卡余额</th>
				<th width="5%">交易状态</th>
				<th width="10%">交易时间</th>
				<th width="10%">上送时间</th>
				<th width="5%">卡号</th>
				<th width="5%">批次号</th>
				<!-- <th width="5%">流水号</th> -->
            </tr>
        </thead>
        <tbody>		         	
			<c:forEach var="model" items="${pageBean.recordList}" varStatus="st">
				<tr>
					<td class="center"><a class="btn btn-green" title="查看" data-toggle="dialog" data-width="900" data-height="420" data-id="dialog-normal" href="${baseURL }/sys/tranInfo/traninfoView?tranSerial=${model.tranSerial}&termId=${model.termId}&tranDate=${model.tranDate}&resultType=${model.resultType}&tranType=${model.tranTypeCode}"> 查看</a></td>
					<td class="center">
						<c:if test="${model.resultType == '1'}">脱机</c:if>
						<c:if test="${model.resultType == '2'}">联机</c:if>
					</td>
					<td class="center">${model.merchId}</td>
					<td>${model.merchName}</td>
					<td>${model.storeName}</td>
	                <td class="center">${model.termId}</td>
	                <td class="center">${model.tranType}</td>
	                <td class="right">${model.tranAmt}</td>
	                <td class="right">${model.cardBalance}</td>
		            <td class="center" <c:if test="${model.tranStatus=='1' }"> style="color:green;"</c:if> <c:if test="${model.tranStatus=='2' }"> style="color:red;"</c:if>>    
		                <c:choose>
		                	<c:when test="${model.tranStatus=='1' }">
		                		成功
		                	</c:when>
		                	<c:when test="${model.tranStatus=='2' }">
		                		失败
		                	</c:when>
		                	<c:otherwise>
		                		预计
		                	</c:otherwise>
		                </c:choose>
		            </td>
	                <td class="center">${model.tranTime}</td>
	                <td class="center">${model.setDate}</td>
	                <td class="center">${model.cardNo}</td>
	                <td class="center">${model.batchNo}</td>
				<%-- <td class="center">${model.tranSerial}</td> --%>
				</tr>
			</c:forEach>
		</tbody>
    </table>
</div>
<div class="bjui-pageFooter">
	<div >
		<table class="table table-bordered table-hover table-striped table-top">
			<c:if test="${pageBean.recordList.size() >0}">
				<thead>
					<tr>
			             <th style="color:red;">合计</th>
			             <th colspan="6"></th>
			             <th class="right"></th>
			             <th class="right" style="color:red;">${totalCount.sumTotal1}</th>
			             <th colspan="6"></th>
					</tr>
				</thead>
			</c:if>
		</table>
	</div>
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
