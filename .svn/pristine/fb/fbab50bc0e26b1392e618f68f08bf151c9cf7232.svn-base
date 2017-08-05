<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var MenuAdd = {
	// 删除后的回调函数，刷新树形菜单
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).bjuiajax('refreshDiv', 'layout_menu_list');
			$(this).alertmsg('ok', '添加成功！');
		}else{
			 $(this).alertmsg('error', '添加失败！');
		}
	}
};
</script>

<div class="pageContent">
	<form method="post" action="${baseURL }/sys/menu/add" class="pageForm" data-toggle="validate" data-callback="MenuAdd.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="navTabId" value="listSysMenu">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">

			<p style="width: 99%">
				<label class="control-label x90">上级菜单：</label>
				<input type="text" name="parent.name" value="${sysMenu.parent.name}" readonly />
				<input type="hidden" name="parent.id" value="${sysMenu.id}" />
				<input type="hidden" name="parent.level" value="${sysMenu.parent.level}" />
				<span class="info"></span>
			</p>
			<p style="width: 99%">
				<label class="control-label x90">菜单名称:</label>
				<input type="text" name="name" class="required" maxlength="90" data-rule="required" value="${sysMenu.name}" />
			</p>
			<p style="width: 99%">
				<label class="control-label x90">菜单编号：</label>
				<input type="text" name="number" class="required number" data-rule="required" maxlength="20" value="${sysMenu.number}" />
			</p>
			<p style="width: 99%">
				<label class="control-label x90">请求URL：</label>
				<input type="text" name="url" maxlength="150" class="required" data-rule="required" value="${sysMenu.url}" size="50" />
			</p>
			<p style="width: 99%">
				<label class="control-label x90">navTabId：</label>
				<input type="text" name="targetName" maxlength="50" value="${sysMenu.targetName}" />
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