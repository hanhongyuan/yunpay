<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
     $(selector).bjuiajax('refreshLayout', ture);
}

function bringBack(merchId,merchName,provice,region){
    $("#store_add_nameShort").val(merchName);
    $("#store_add_merchId").val(merchId);
    
    $("#store_add_provice option").each(function(){
    	var txt = $(this).text();
    	if(provice==txt){
    		$(this).attr("selected",true);
    		$("#store_add_provice").change();
    	}
    });
    
    setTimeout(function(){
    	$("#store_add_select_region option").each(function(index){
            var txt = $(this).text();
            if(region==txt){
                $(this).attr("selected",true);
                $("#store_add_select_region").change();
            }
        });
    }, 500);
    
}

</script>

<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/store/lookupmerchId" method="post">
        <div class="bjui-searchBar">
            <label>商户编号：</label><input type="text" name="merchId" value="${param.merchId }" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <label>商户名称：</label><input type="text" name="nameShort" value="${param.nameShort }" size="20" alt="模糊查询" class="form-control" />&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="merchId" align="center">商户编号</th>
                <th data-order-field="registerName" align="center">营业执照名称</th>
                <th data-order-field="nameShort" align="center">商户名称</th>
                <!-- <th data-order-field="merType" align="center">行业</th> -->
                <th data-order-field="provice" align="center">城市</th>
                <th data-order-field="" align="center">查找带回</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
                    <tr target="merch">
                        <td>${item.merchId}</td>
                        <td>${item.registerName}</td>
                        <td>${item.nameShort}</td>
                        <td>
                            ${item.merType}
                            <c:if test="${!empty item.childType}">- ${item.childType}</c:if>
                        </td>
                        <td>
                            ${item.provice}
                            <c:if test="${!empty item.region}">- ${item.region}</c:if>
                        </td>
                        <td>
                        <!-- data-args="{merchId:'${item.merchId}',nameShort:'${item.nameShort}',provice:'${item.provice}',region:'${item.region}'}"  -->
                            <a onclick="javascript:bringBack(&quot;${item.merchId}&quot;,&quot;${item.nameShort}&quot,&quot;${item.provice}&quot;,&quot;${item.region}&quot;);" data-args="{}" data-toggle="lookupback" class="btn btn-blue" title="选择本项" data-icon="check">选择</a>
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