<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<form id="editSysMenu1" method="post" action="${baseURL }/sys/menu/edit" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<div class="pageFormContent" layoutH="150">
			<input type="hidden" name="navTabId" value="listSysMenu">
			<input type="hidden" name="forwardUrl" value="">

			<input type="hidden" id="menuId" name="id" value="${sysMenu.id }" />
			<input type="hidden" name="version" value="${sysMenu.version }" />
			<input type="hidden" name="level" value="${sysMenu.level }" />
			<input type="hidden" name="isLeaf" value="${sysMenu.isLeaf }" />

			<p style="width: 99%">
				<label>上级菜单：</label>
				<input type="text" name="parent.name" value="${sysMenu.parent.name}" readonly="true" size="30" />
				<input type="hidden" name="parent.id" value="${sysMenu.parent.id}" />
				<span class="info"></span>
			</p>
			<p style="width: 99%">
				<label>菜单名称：</label>
				<input type="text" name="name" class="required" maxlength="90" value="${sysMenu.name }" size="30" />
			</p>
			<p style="width: 99%">
				<label>菜单编号：</label>
				<input type="text" name="number" class="required number" maxlength="20" value="${sysMenu.number }" size="30" />
			</p>
			<p style="width: 99%">
				<label>请求URL：</label>
				<input type="text" name="url" maxlength="150" value="${sysMenu.url }" size="50" />
			</p>

			<p style="width: 99%">
				<label>navTabId：</label>
				<input type="text" name="targetName" maxlength="50" value="${sysMenu.targetName}" size="30" />
			</p>
			<z:permission value="sys:user:edit">
				<div class="buttonActive" style="margin-left: 130px; margin-top: 30px;">
					<div class="buttonContent">
						<button type="submit">保存</button>
					</div>
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