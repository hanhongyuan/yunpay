<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var DictAdd = {
	// 删除后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).navtab('refresh');
			$(this).alertmsg('ok', '添加成功！');
		}else{
			 $(this).alertmsg('error', '添加失败！');
		}
	}
};
</script>

<div class="pageContent">
	<form method="post" data-toggle="validate" action="${baseURL}/sys/dictcode/add" class="pageForm" data-toggle="validate" data-callback="DictAdd.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">

			<p>
				<label class="control-label x90">所属分类：</label>
				<select name="typeId" class="combox" data-rule="required">
				        <option value=""  selected = 'selected'>-请选择-</option>
				        
                        <c:forEach var="item" items="${allinfo}" varStatus="st">
                            <c:if test="${item.typeId eq '0' }">
                                <option value="${item.typeCode }">${item.typeName }</option>
                            </c:if>
                        </c:forEach>
                </select>
                <span class="required" style = "color:red;font-size:15px"><b>*</b></span>
			</p>
			<p>
				<label class="control-label x90">引用键值：</label>
				<input type="text" name="typeCode" class="required" value="${typeCode}" data-rule="required"/> 
			</p> 
			<p>
				<label class="control-label x90">显示名称：</label>
				<input type="text" name="typeName" class="required" value="${typeName}" data-rule="required"/> 
			</p>
			<p>
                <label class="control-label x90">排序号：</label>
                <input type="text" name="orderNo" value="${orderNo}" />
            </p>
            <p>
                <label class="control-label x90">备注：</label>
                <textarea name="remark" >${remark}</textarea>
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