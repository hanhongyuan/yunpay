<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
     $(selector).bjuiajax('refreshLayout', ture);
}

var Termyybd = {
        //的回调函数，刷新当前页面
        navTabAjax: function(json) {
            if(json.statusCode=='200')
            {
                $(this).navtab('refresh');
                $(this).alertmsg('ok', '删除成功！');
                $('#sta').val("2");
                var status = window.app_add_type;
                if(status == "101"){
                    $('#term_add_yybd').click();
                }else if(status == "102"){
                    $('#term_edit_yybd').click();
                }
            }else{
                 $(this).alertmsg('error', json.message);
            }
        }
    };

</script>


    <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed">
        <thead>
            <tr>
                <th data-order-field="" align="center">操作</th>
                <th data-order-field="appName" align="center">应用名称</th>
                <th data-order-field="appTermNo" align="center">应用终端号</th>
                <th data-order-field="appSamCard" align="center">SAM卡号</th>
                <th data-order-field="appTermSeq" align="center">应用终端序列</th>
                <th data-order-field="" align="center">状态</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${appTerm }" varStatus="st">
                    <tr target="term">
                        <td width="120px">
                           <c:choose>
                                <c:when test="${!empty item.termId}">
                                    <a href="${baseURL}/sys/term/editTermAppInfo?type=103&termSeq=${TermSeq }&appTermNo=${item.appTermNo}&termId=${termId }&appCode=${item.appCode }&termAppId=${item.termAppId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除绑定吗？" data-callback="Termyybd.navTabAjax">删除</a>
                                    <a href="${baseURL}/sys/term/editTermAppInfo?type=102&termAppId=${item.termAppId}&termSeq=${TermSeq }&appTermNo=${item.appTermNo}&merchId=${merchId }&termId=${termId }&appCode=${item.appCode }&appName=${item.appName }&appSamCard=${item.appSamCard }&appTermSeq=${item.termAppSeq }" class="btn btn-green" data-toggle="dialog" data-width="430" data-height="600">修改</a>
                                </c:when>
                                <c:when test="${empty item.termId}">
                                    <a href="${baseURL}/sys/term/editTermAppInfo?type=101&termSeq=${TermSeq }&appTermNo=${termId}&merchId=${merchId }&termId=${termId }&appCode=${item.appCode }&appName=${item.appName }" class="btn btn-green" data-toggle="dialog" data-width="430" data-height="600">添加绑定</a>
                                </c:when>
                           </c:choose>
                        </td>
                        <td>${item.appName }</td>
                        <td>${item.appTermNo }</td>
                        <td>${item.appSamCard }</td>
                        <td>${item.termAppSeq}</td>
                        <td>
                           <c:choose>
                                <c:when test="${!empty item.termId}">已绑定</c:when>
                                <c:when test="${empty item.termId}">未绑定</c:when>
                           </c:choose>
                        </td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
