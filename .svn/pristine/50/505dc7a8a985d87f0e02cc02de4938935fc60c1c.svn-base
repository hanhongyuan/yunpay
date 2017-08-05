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
			$(this).alertmsg('ok', '修改成功！');
		}else{
			 $(this).alertmsg('error', '修改失败！');
		}
	}
};
</script>

<div class="pageContent">
	<form method="post" action="${baseURL}/sys/sysVersion/edit?verId=${sysVersion.verId}" class="pageForm" data-toggle="validate" data-callback="AgentEdit.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">

		<table>
			<tr>
				<td>
					<label class="control-label x120">版本号：</label>
					<input type="text" name="verNo"  value="${sysVersion.verNo}" readonly maxlength="20" size="30">
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本名称：</label>
					<input type="text" name="verName" class="required" data-rule="required" value="${sysVersion.verName}"  maxlength="30" size="30">
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本类型：</label>
					<select name="verType" data-toggle="selectpicker">
                  			<option value="1" <c:if test="${sysVersion.verType == '1'}">selected='selected'</c:if>>主程序</option>
                  			<option value="2" <c:if test="${sysVersion.verType == '2'}">selected='selected'</c:if>>升级程序</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label class="control-label x120">版本说明：</label>
					<input type="text" name="verRmk" value="${sysVersion.verRmk}" maxlength="90" size="30" />
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