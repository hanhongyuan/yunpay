<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var PermissionAdd = {
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
	<form method="post" action="${baseURL}/sys/permission/add" class="pageForm" data-toggle="validate" data-callback="PermissionAdd.navTabAjax">
		<div class="pageFormContent" layoutH="58">
			<input type="hidden" name="navTabId" value="qxgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">

			<p>
				<label class="control-label x90">权限名称：</label>
				<input type="text" name="permissionName" class="required" data-rule="required length[3~50]" size="30" />
			</p>
			<p>
				<label class="control-label x90">权限标识：</label>
				<input type="text" name="permission" class="required" data-rule="required length[3~50]" size="30" />
				<span class="info"></span>
			</p>
			<p style="width: 99%">
				<label></label>
				<span style="color: red;">提示：权限标识添加后将不可修改，请确保添加信息的准确性！</span>
			</p>
			<p style="height: 50px;">
				<label class="control-label x90">权限描述：</label>
				<textarea rows="3" cols="27" name="remark" class="required" data-rule="required length[3~60]"></textarea>
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
<script type="text/javascript">
	function submitForm() {
		$("#form1").submit();
	}

	// 查找带回的拓展功能
	$.extend({
		bringBackSuggest : function(args) {
			$("input[name='menu.id']").val(args["id"]);
			$("input[name='menu.name']").val(args["name"]);
		},
		bringBack : function(args) {
			$.bringBackSuggest(args);
			$.pdialog.closeCurrent();
		}
	});
</script>
