<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var RoleEdit = {
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
	<form action="${baseURL}/sys/role/edit" class="pageForm" data-toggle="validate" data-callback="RoleEdit.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">

			<input type="hidden" name="id" value="${sysRole.id }">

			<p>
				<label class="control-label x90">角色名称：</label>
				<input type="text" name="roleName" class="required" data-rule="required length[3~20]" size="30" value="${sysRole.roleName }">
			</p>

			<p>
				<label class="control-label x90">角色编码：</label>
				<input type="text" name="roleCode" class="required" data-rule="required length[3~20]" size="30" value="${sysRole.roleCode }">
			</p>

			<p style="height: 50px;">
				<label class="control-label x90">角色描述：</label>
				<textarea rows="5" cols="27" name="remark" class="required" data-rule="required length[3~300]">${sysRole.remark }</textarea>
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
