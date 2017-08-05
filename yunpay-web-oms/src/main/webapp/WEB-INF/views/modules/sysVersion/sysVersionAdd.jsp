<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var AgentEdit = {
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
	<form method="post" action="${baseURL}/sys/sysVersion/add" class="pageForm" data-toggle="validate" enctype="multipart/form-data" data-callback="AgentEdit.navTabAjax">
		<div class="pageFormContent" layoutH="60">
		<table>
			<tr>
				<td>
					<label class="control-label x120">上传版本文件：</label>
					<input id="file" type="file" name="fileName" class="required" data-rule="required" accept="video/*;capture=camcorder">
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本号：</label>
					<input type="text" name="verNo" class="required" data-rule="required" value="${verNo}"  size="30">
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本名称：</label>
					<input type="text" name="verName" class="required" data-rule="required" value="${verName}"  maxlength="90" size="30">
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本类型：</label>
					<select name="verType" data-toggle="selectpicker">
                  			<option value="1" selected='selected'>主程序</option>
                  			<option value="2" >升级程序</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本说明：</label>
					<input type="text" name="verRmk" value="${sysVersion.verRmk}" maxlength="30" size="30" />
				</td>
			</tr>
		</table>
		</div>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
		        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
		    </ul>
		</div>
	</form>
</div>