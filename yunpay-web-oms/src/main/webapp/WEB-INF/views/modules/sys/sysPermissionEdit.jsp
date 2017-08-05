<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var PermissionEdit = {
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
	<form method="post" action="${baseURL}/sys/permission/edit" class="pageForm" data-toggle="validate" data-callback="PermissionEdit.navTabAjax">
		<div class="pageFormContent" layoutH="58">
			<input type="hidden" name="navTabId" value="qxgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			<input type="hidden" name="id" value="${sysPermission.id }">

			<p>
				<label class="control-label x90">权限名称：</label>
				<input type="text" name="permissionName" value="${sysPermission.permissionName }" class="required" data-rule="required length[3~50]" size="30" />
			</p>
			<p>
				<label class="control-label x90">权限标识：</label>
				<input type="text" value="${sysPermission.permission }" readonly="readonly" size="30" maxlength="50" />
			</p>
			<p style="height: 50px;">
				<label class="control-label x90">权限描述：</label>
				<textarea rows="3" cols="27" name="remark" class="required" data-rule="required length[3~60]">${sysPermission.remark}</textarea>
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
