<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>

<script type="text/javascript">
var MenuEdit = {
	// 删除后的回调函数，刷新树形菜单
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).bjuiajax('refreshDiv', 'layout_menu_list');
			$(this).alertmsg('ok', '修改成功！');
		}else{
			 $(this).alertmsg('error', '修改失败！');
		}
	}
};
</script>
<div class="pageContent">
	<form method="post" action="${baseURL }/sys/menu/edit" class="pageForm" data-toggle="validate" data-callback="MenuEdit.navTabAjax">
		<div class="pageFormContent" layoutH="150">
			<input type="hidden" name="navTabId" value="listSysMenu">
			<input type="hidden" name="forwardUrl" value="">

			<input type="hidden" id="menuId" name="id" value="${sysMenu.id }" />
			<input type="hidden" name="version" value="${sysMenu.version }" />
			<input type="hidden" name="level" value="${sysMenu.level }" />
			<input type="hidden" name="isLeaf" value="${sysMenu.isLeaf }" />

			<p style="width: 99%">
				<label class="control-label x90">上级菜单：</label>
				<input type="text" name="parent.name" value="${sysMenu.parent.name}" readonly size="30" />
				<input type="hidden" name="parent.id" value="${sysMenu.parent.id}" />
				<span class="info"></span>
			</p>
			<p style="width: 99%">
				<label class="control-label x90">菜单名称：</label>
				<input type="text" name="name" class="required" data-rule="required" maxlength="90" value="${sysMenu.name }" size="30" />
			</p>
			<p style="width: 99%">
				<label class="control-label x90">菜单编号：</label>
				<input type="text" name="number" class="required" data-rule="required" maxlength="20" value="${sysMenu.number }" size="30" />
			</p>
			<p style="width: 99%">
				<label class="control-label x90">请求URL：</label>
				<input type="text" name="url" maxlength="150" class="required" data-rule="required" value="${sysMenu.url }" size="50" />
			</p>

			<p style="width: 99%">
				<label class="control-label x90">navTabId：</label>
				<input type="text" name="targetName" maxlength="50" value="${sysMenu.targetName}" size="30" />
			</p>
			<z:permission value="sys:user:edit">
					<div class="bjui-pageFooter">
					    <ul>
					        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
					        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
					    </ul>
					</div>
			</z:permission>
		</div>
	</form>
</div>
<script type="text/javascript">
	function submitForm2() {
		$("#editSysMenu1").submit();
	}
</script>