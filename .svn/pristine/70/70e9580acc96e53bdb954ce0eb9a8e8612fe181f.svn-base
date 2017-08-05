<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

</script>
	
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/card/list" method="post"><br>
        <div class="bjui-searchBar">
            <label>创建日期</label>
            <input type="text" name="date_begin" value="${card.date_begin}" size="15"  class="form-control" data-toggle="datepicker"/>&nbsp; --
            <label></label>
            <input type="text" name="date_end" value="${card.date_end}" size="15"  class="form-control" data-toggle="datepicker"/>&nbsp;
            <label>商户名称：</label>
            <input type="text" name="merchantName" value="${card.merchantName}" size="20"  class="form-control" />&nbsp;		
            <label>卡券类型：</label>
            <select name="type" class="selectpicker show-menu-arrow form-control" >            	
            	<option value="" selected="selected">请选择</option>
            	<option value="1" <c:if test="${card.type == 1}">selected="selected"</c:if>>通用券</option>
            	<option value="2" <c:if test="${card.type == 2}">selected="selected"</c:if>>折扣券</option>
            	<option value="3" <c:if test="${card.type == 3}">selected="selected"</c:if>>代金券</option>
            	<option value="4" <c:if test="${card.type == 4}">selected="selected"</c:if>>礼品券</option>
            	<option value="5" <c:if test="${card.type == 5}">selected="selected"</c:if>>团购券</option>        		
        	</select>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a><br><br>
            <div>
            	<button type="button" data-url="${baseURL}/sys/card/checkUI?id={#bjui-selected}" class="btn btn-green" title="查看" data-toggle="dialog" data-width="500" data-height="700" data-id="dialog-normal">查看</button>
            	<button type="button" href="${baseURL}/sys/card/delete?id={#bjui-selected}" class="btn btn-blue" data-toggle="doajax" data-confirm-msg="确定要删除吗？" >导出</button>
            </div>  
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed"><!-- data-selected-multi="true" -->
        <thead>
            <tr	>
                <th data-order-field="merchantName" align="center">商户名称</th>
                <th data-order-field="title" align="center">卡券名称</th>
                <th data-order-field="type" align="center">卡券类型</th>
                <th data-order-field="putchannel" align="center">投放平台</th>
                <th data-order-field="termOfValidity" align="center">卡券有效期</th>
                <th data-order-field="createdAt" align="center">创建时间</th>                              
                <th data-order-field="status" align="center">审核状态</th>                
                <th data-order-field="" align="center">操作</th>                
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">				
				<tr target="id" data-id="${item.id}">
					<td>${item.merchantName}</td>
					<td>${item.title }</td>
					<td>
						<c:if test="${item.type ==1}">通用券</c:if>
						<c:if test="${item.type ==2}">折扣券</c:if>
						<c:if test="${item.type ==3}">代金券</c:if>
						<c:if test="${item.type ==4}">礼品券</c:if>
						<c:if test="${item.type ==5}">团购券</c:if>					
					</td>
					<td>
						<c:if test="${item.putchannel eq '1'}">微信</c:if>
						<c:if test="${item.putchannel eq '2'}">支付宝</c:if>
					</td>
					<td><fmt:formatDate value="${item.startDate }" pattern="yyyy-MM-dd"/>至
						<fmt:formatDate value="${item.endDate }" pattern="yyyy-MM-dd"/>
					</td>
					<td	><fmt:formatDate value="${item.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					
					<td>
						<c:if test="${item.status ==1}">待审核</c:if>
						<c:if test="${item.status ==2}">审核未通过</c:if>
						<c:if test="${item.status ==3}">审核通过</c:if>
					</td>					
					<td>						
                        <a href="${baseURL}/sys/card/QRcodeUI?id=${item.id}" class="btn btn-green" data-toggle="dialog" data-width="500" data-height="500" data-id="dialog-normal" title="领取码" >领取码</a>
                        <a href="${baseURL}/sys/card/receiveList?cardId=${item.id}" class="btn btn-blue" data-toggle="dialog" data-width="1000" data-height="800" data-id="dialog-normal" title="领取记录" >领取记录</a>                        
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
