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
	<form method="post" action="${baseURL}/sys/agent/edit" class="pageForm" data-toggle="validate" data-callback="AgentEdit.navTabAjax">
		<div class="pageFormContent">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">

			<p>
				<label class="control-label x120">代理商编码：</label>
				<input type="text" name="agentSerialNo" class="required" data-rule="required length[3~100]" value="${agent.agentSerialNo}"  size="30">
			</p>
			<p>
				<label class="control-label x120">代理商名称：</label>
				<input type="text" name="companyName" class="required" data-rule="required length[2~50]" value="${agent.companyName}"  size="30">
			</p>
			<p>
				<label class="control-label x120">联系人：</label>
				<input type="text" name="contactMan" class="required" data-rule="required" value="${agent.contactMan}" maxlength="90" size="30" />
			</p>
			<p>
				<label class="control-label x120">联系电话：</label>
				<input type="text" name="tel" class="required" data-rule="required mobile" data-msg-mobile="联系电话格式不正确" value="${agent.tel}" maxlength="30" size="30" />
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