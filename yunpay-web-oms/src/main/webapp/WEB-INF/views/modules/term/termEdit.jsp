<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var app_add_type = "102";
// 删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
     $(selector).bjuiajax('refreshLayout', ture);
}

var TermAdd = {
        // 删除后的回调函数，刷新当前页面
        navTabAjax: function(json) {
            if(json.statusCode=='200')
            {
                $(this).navtab('refresh');
                $(this).alertmsg('ok', '修改成功！');
                $('#sta').val("2");
            }else{
                 $(this).alertmsg('error', json.message);
            }
        }
    };
$(function(){
    $('#term_edit_yybd').attr("href","${baseURL}/sys/term/termyybd?seq=${Term.termSeq }");
})
</script>

<div class="bjui-pageContent">
    <ul class="nav nav-tabs" role="tablist">
        <li class="active"><a href="#home" role="tab" data-toggle="tab">POS基本信息</a></li>
        <li><a href="" role="tab" data-toggle="ajaxtab" id="term_edit_yybd" data-target="#profile" data-reload="true">应用绑定</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane fade active in" id="home">
            <input type="hidden" name="sta" id="sta" value="${sta }" />
            <form method="post" data-toggle="validate" action="${baseURL}/sys/term/editterm" class="pageForm" data-toggle="validate" data-callback="TermAdd.navTabAjax">
        <div class="pageFormContent" layoutH="60">
            <p>
                <label class="control-label x90">机器SN号：</label>
                <label>${Term.termSeq }</label>
                <input type="hidden" name="termSeq" value="${Term.termSeq }" />
            </p>
            <p>
                <label class="control-label x90">终端号：</label>
                <label>${Term.termId }</label>
            </p>
            <p>
                <label class="control-label x90">归属门店：</label>
                <label>${Term.storeName }</label>
            </p> 
            <p>
                <label class="control-label x90">厂商&型号：</label>
                <select name="firm" class="combox" id="term_add_firm" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#term_add_select_typeid" data-refurl="${baseURL}/sys/term/findtypeId?code={value}" data-rule="required" >
                        <option value="" selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${FirmList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${item.code == Term.firm}">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
                <select name="typeId" class="combox" id="term_add_select_typeid" data-toggle="selectpicker" data-emptytxt="--请选择--" data-rule="required" >
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${TypeIdList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${item.code == Term.typeId}">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
            </p>
            <p>
                <label class="control-label x90">通讯方式：</label>
                <select name="transferType" class="combox" id="term_add_provice" data-toggle="selectpicker" data-emptytxt="--请选择--"  data-rule="required">
                        <option value="" selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${TransferTypeList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${item.code == Term.transferType}">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
            </p>
            <p>
                <label class="control-label x90">gprs卡号：</label>
                <input type="text" name="gprsNo" value="${Term.gprsNo }" /> 
            </p> 
            <p>
                <label class="control-label x90">备注：</label>
                <input type="text" name="remark" value="${Term.remark }" /> 
            </p>
        </div>
        <div class="bjui-pageFooter">
            <ul>
                <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
                <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
            </ul>
        </div>
    </form>
        </div>
        <div class="tab-pane fade" id="profile">
            <!-- Ajax加载 -->
        </div>
    </div>
</div>