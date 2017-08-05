<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
$(function(){
    var code = '${AppCode }';
    if(code == "01" || code == "08" || code == "11"){
    	$('#lmkTmk').attr('data-rule','required');
        $('#lmkTmk').attr('class','required');
        
        $('#zmkTmk').attr('data-rule','required');
        $('#zmkTmk').attr('class','required');
        
        $('#tmkCheckValue').attr('data-rule','required');
        $('#tmkCheckValue').attr('class','required');
        
        $('#lmkTpk').attr('data-rule','required');
        $('#lmkTpk').attr('class','required');
        
        $('#lmkTak').attr('data-rule','required');
        $('#lmkTak').attr('class','required');
        
        $('#tmkTpk').attr('data-rule','required');
        $('#tmkTpk').attr('class','required');
        
        $('#tmkTak').attr('data-rule','required');
        $('#tmkTak').attr('class','required');
        
        $('#batchNo').attr('data-rule','required');
        $('#batchNo').attr('class','required');
    }
} );

var TermAppAdd = {
    //回调函数，刷新当前页面
    navTabAjax: function(json) {
        if(json.statusCode=='200')
        {
            $(this).dialog('closeCurrent');
            $(this).alertmsg('ok', '操作成功！');
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

<div class="bjui-pageContent tableContent">
    <form id="pagerForm" data-toggle="validate" action="${baseURL}/sys/term/addTermAppInfo" method="post" data-callback="TermAppAdd.navTabAjax">
		<input type="hidden" name="type" value="${Type }" />
		<input type="hidden" name="merchId" value="${MerchId }" />
		<input type="hidden" name="appCode" id="appCode" value="${AppCode }" />
		<input type="hidden" name="termId"  value="${TermId }" />
		<input type="hidden" name="termSeq" value="${TermSeq }" />
		<input type="hidden" name="termAppId" value="${TermAppId }" />
		<div>
			<p>
				<label class="control-label x110">应用名称：</label> 
				<label>${AppName }</label> 
			</p>
			<p>
                <label class="control-label x110">应用终端号：</label> 
                <c:choose>
                    <c:when test="${AppCode eq '01'}"><input type="text" name="appTermNo" id="appTermNo" value="${AppTermNo }" maxlength="20" class="required" data-rule="required;length[~8, true];mobile" data-rule-mobile="[/^\w+$/, '应用终端号只能为字母、数字和下划线']"/></c:when>
                    <c:otherwise><input type="text" name="appTermNo" id="appTermNo" value="${AppTermNo }" maxlength="20" class="required" data-rule="required"/></c:otherwise>
                </c:choose>
            </p>
            <p>
                <label class="control-label x110">SAM卡号：</label>
                <c:choose>
                    <c:when test="${AppCode eq '01'}"><input type="text" name="appSamCard" id="appSamCard" value="${appSamCard }" maxlength="20" class='required' data-rule='required;mobile' data-rule-mobile="[/^\w+$/, 'SAM卡号只能为字母、数字和下划线']"/></c:when>
                    <c:otherwise><input type="text" name="appSamCard" id="appSamCard" value="${appSamCard }" maxlength="20"/></c:otherwise>
                </c:choose>
            </p>
			<p>
				<label class="control-label x110">应用终端序号：</label> 
				<input type="text" name="appTermSeq" id="appTermSeq" value="${appTermSeq }" data-rule='mobile' data-rule-mobile="[/^\w+$/, '应用终端号只能为字母、数字和下划线']" maxlength="20" />
			</p>
			<hr style="height:1px;border:none;border-top:1px solid #555555;" />
           
           <!-- 秘钥信息 -->
			<p>
			    <c:choose>
			         <c:when test="${AppCode eq '05'}"><label class="control-label x110">微信分配的公众账号ID：</label></c:when>
			         <c:when test="${AppCode eq '08'}"><label class="control-label x110">支付宝公钥：</label></c:when>
			         <c:otherwise><label class="control-label x110">lmk保护的tmk：</label></c:otherwise>
			    </c:choose>
			    <c:choose>
			         <c:when test="${AppCode eq '01'}">
			             <c:if test="${!empty termApp.lmkTmk}"><input type="text" name="lmkTmk" value="${termApp.lmkTmk }" id="lmkTmk" /></c:if>
                         <c:if test="${empty termApp.lmkTmk}"><input type="text" name="lmkTmk" value="1" id="lmkTmk" /></c:if>
			         </c:when>
			         <c:otherwise><input type="text" name="lmkTmk" value="${termApp.lmkTmk }" id="lmkTmk" /></c:otherwise>
			    </c:choose>
			</p>
			
			<c:choose>
			     <c:when test="${AppCode eq '04'}">
			         <p>
                        <label  class="control-label x110">汇商zmk保护的tmk：</label>
		                <c:choose>
		                     <c:when test="${AppCode eq '01'}">
		                        <c:if test="${!empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:if>
                                <c:if test="${empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="1" id="zmkTmk" /></c:if>
		                     </c:when>
		                     <c:otherwise><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:otherwise>
		                </c:choose>
		             </p>
		             <p>  
                        <label  class="control-label x110">翼支付zmk保护的tmk：</label>
                        <c:choose>
                             <c:when test="${AppCode eq '01'}">
                                <c:if test="${!empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:if>
                                <c:if test="${empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="1" id="zmkTmk" /></c:if>
                             </c:when>
                             <c:otherwise><input type="text" name="bestPayZmkTmk" value="${termApp.bestPayZmkTmk }" id="zmkTmk" /></c:otherwise>
                        </c:choose>
		            </p>
			     </c:when>
			     
			     <c:when test="${AppCode eq '08'}">
                     <p>
                        <label  class="control-label x110">商户私钥：</label>
                        <c:choose>
                             <c:when test="${AppCode eq '01'}">
                                <c:if test="${!empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:if>
                                <c:if test="${empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="1" id="zmkTmk" /></c:if>
                             </c:when>
                             <c:otherwise><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk"/></c:otherwise>
                        </c:choose>
                     </p>
                 </c:when>
                 
                 <c:when test="${AppCode eq '05'}">
                     <p>
                        <label  class="control-label x110">微信支付密钥：</label>
                        <c:choose>
                             <c:when test="${AppCode eq '01'}">
                                <c:if test="${!empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:if>
                                <c:if test="${empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="1" id="zmkTmk" /></c:if>
                             </c:when>
                             <c:otherwise><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk"/></c:otherwise>
                        </c:choose>
                     </p>
                 </c:when>
                 
                 <c:otherwise>
                     <p>
                        <label  class="control-label x110">zmk保护的tmk：</label>
                        <c:choose>
                             <c:when test="${AppCode eq '01'}">
                                <c:if test="${!empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:if>
                                <c:if test="${empty termApp.zmkTmk}"><input type="text" name="zmkTmk" value="1" id="zmkTmk" /></c:if>
                             </c:when>
                             <c:otherwise><input type="text" name="zmkTmk" value="${termApp.zmkTmk }" id="zmkTmk" /></c:otherwise>
                        </c:choose>
                     </p>
                 </c:otherwise>
			</c:choose>
			
			<p>
                <label  class="control-label x110">tmk校验值：</label>
                <c:choose>
                     <c:when test="${AppCode eq '01'}">
                        <c:if test="${!empty termApp.tmkCheckValue}"><input type="text" name="tmkCheckValue" value="${termApp.tmkCheckValue }" id="tmkCheckValue" /></c:if>
                        <c:if test="${empty termApp.tmkCheckValue}"><input type="text" name="tmkCheckValue" value="1" id="tmkCheckValue" /></c:if>
                     </c:when>
                     <c:otherwise><input type="text" name="tmkCheckValue" value="${termApp.tmkCheckValue }" id="tmkCheckValue" /></c:otherwise>
                </c:choose>
            </p>
           
            <p>
                <c:choose>
                     <c:when test="${AppCode eq '05'}"><label class="control-label x110">微信分配的商户号：</label></c:when>
                     <c:when test="${AppCode eq '08'}"><label class="control-label x110">当面付id（appid）：</label></c:when>
                     <c:otherwise><label  class="control-label x110">lmk保护的tpk：</label></c:otherwise>
                </c:choose>
                <c:choose>
                     <c:when test="${AppCode eq '01'}">
                        <c:if test="${!empty termApp.lmkTpk}"><input type="text" name="lmkTpk" value="${termApp.lmkTpk }" id="lmkTpk" /></c:if>
                        <c:if test="${empty termApp.lmkTpk}"><input type="text" name="lmkTpk" value="1" id="lmkTpk" /></c:if>
                     </c:when>
                     <c:otherwise><input type="text" name="lmkTpk" value="${termApp.lmkTpk }" id="lmkTpk" /></c:otherwise>
                </c:choose>
            </p>
            
            <p>
                <c:choose>
                     <c:when test="${AppCode eq '05'}"><label class="control-label x110">微信支付证书密码：</label></c:when>
                     <c:when test="${AppCode eq '08'}"><label  class="control-label x110">签约账号对应id：</label></c:when>
                     <c:otherwise><label  class="control-label x110">lmk保护的tak：</label></c:otherwise>
                </c:choose>
                <c:choose>
                     <c:when test="${AppCode eq '01'}">
                        <c:if test="${!empty termApp.lmkTak}"><input type="text" name="lmkTak" value="${termApp.lmkTak }" id="lmkTak" /></c:if>
                        <c:if test="${empty termApp.lmkTak}"><input type="text" name="lmkTak" value="1" id="lmkTak" /></c:if>
                     </c:when>
                     <c:otherwise><input type="text" name="lmkTak" value="${termApp.lmkTak }" id="lmkTak" /></c:otherwise>
                </c:choose>
            </p>
            
            <p>
                <label  class="control-label x110">tmk保护的tpk：</label>
                <c:choose>
                     <c:when test="${AppCode eq '01'}">
                        <c:if test="${!empty termApp.tmkTpk}"><input type="text" name="tmkTpk" value="${termApp.tmkTpk }" id="tmkTpk" /></c:if>
                        <c:if test="${empty termApp.tmkTpk}"><input type="text" name="tmkTpk" value="1" id="tmkTpk" /></c:if>
                     </c:when>
                     <c:otherwise><input type="text" name="tmkTpk" value="${termApp.tmkTpk }" id="tmkTpk" /></c:otherwise>
                </c:choose>
            </p>
            
            <p>
                <label  class="control-label x110">tmk保护的tak：</label>
                <c:choose>
                     <c:when test="${AppCode eq '01'}">
                        <c:if test="${!empty termApp.tmkTak}"><input type="text" name="tmkTak" value="${termApp.tmkTak }" id="tmkTak" /></c:if>
                        <c:if test="${empty termApp.tmkTak}"><input type="text" name="tmkTak" value="1" id="tmkTak" /></c:if>
                     </c:when>
                     <c:otherwise><input type="text" name="tmkTak" value="${termApp.tmkTak }" id="tmkTak" /></c:otherwise>
                </c:choose>
            </p>
            
            <p>
                <label  class="control-label x110">批次号：</label>
                <c:choose>
                     <c:when test="${AppCode eq '01'}">
                        <c:if test="${!empty termApp.batchNo}"><input type="text" name="batchNo" value="${termApp.batchNo }" id="batchNo" data-rule="length[6~, true]" /></c:if>
                        <c:if test="${empty termApp.batchNo}"><input type="text" name="batchNo" value="000001" id="batchNo" data-rule="length[6~, true]" /></c:if>
                     </c:when>
                     <c:otherwise><input type="text" name="batchNo" value="${termApp.batchNo }" id="batchNo" data-rule="length[6~, true]"/></c:otherwise>
                </c:choose>
            </p>
            
           <div class="bjui-pageFooter">
               <ul>
                   <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
                   <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
               </ul>
           </div>
       </div>
    </form>
</div>
