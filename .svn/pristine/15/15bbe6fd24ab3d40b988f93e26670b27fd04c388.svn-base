<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var DictEdit = {
	// 删除后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).navtab('refresh');
			$(this).alertmsg('ok', '修改成功！');
		}else{
			 $(this).alertmsg('error', '修改失败！');
		}
	}
};
</script>

<div class="pageContent">
	<form method="post" data-toggle="validate" action="${baseURL}/sys/dictcode/edit" class="pageForm" data-toggle="validate" data-callback="DictEdit.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="sid" value="${dictEntity.sid }" />

			<p>
				<label class="control-label x90">所属分类：</label>
				<c:forEach var="i" items="${allinfo}" varStatus="st">
					<c:if test="${dictEntity.typeId == i.typeCode }">
					    <label class="control-label x180">${i.typeName }</label>
					</c:if>
				</c:forEach>
			</p>
			<p>
                <label class="control-label x90">引用键值：</label>
                <label>${dictEntity.typeCode }</label>
            </p>
            <p>
                <label class="control-label x90">显示名称：</label>
                <input type="text" name="typeName" class="required"  value="${dictEntity.typeName}" data-rule="required"/>
            </p>
            <p>
                <label class="control-label x90">排序号：</label>
                <input type="text" name="orderNo" value="${dictEntity.orderNo}" />
            </p>
			<p style="height: 50px;">
				<label class="control-label x90">备注：</label>
				<textarea name="remark" >${dictEntity.remark}</textarea>
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
