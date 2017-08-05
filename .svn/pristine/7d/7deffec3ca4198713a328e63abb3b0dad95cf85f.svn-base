<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var UserEdit = {
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
	<form method="post" action="${baseURL}/sys/user/edit" class="pageForm" data-toggle="validate" data-callback="UserEdit.navTabAjax">
		<div class="pageFormContent">
		    <input type="hidden" name="navTabId" value="czygl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			
			<input type="hidden" name="id" value="${sysUser.id }">
			<!-- <input type="hidden" name="selectVal" id="selectVal" value=""> -->
			
		<p>
			<label class="control-label x110">操作员姓名：</label>
			<input type="text" name="realName" class="required"  maxlength="45" size="30" value="${sysUser.realName }"/>
		</p>
		<p>
			<label class="control-label x110">操作员登录名：</label>
			<input type="text" name="loginName" class="required" readonly  maxlength="45" size="30" value="${sysUser.loginName }"/>
		</p>
		<p>
			<label class="control-label x110">手机号码：</label>
			<input type="text" name="mobileNo" data-rel="required mobile" maxlength="12" size="30" value="${sysUser.mobileNo }"/>
		</p>
		<p>
			<label class="control-label x110">状态：</label>
			<c:choose>
				<c:when test="${sysUser.status eq UserStatusEnum.ACTIVE.value}">激活</c:when>
				<c:when test="${sysUser.status eq UserStatusEnum.INACTIVE.value}">冻结</c:when>
				<c:otherwise>--</c:otherwise>
			</c:choose>
		</p>
		<p>
			<label class="control-label x110">操作员类型：</label>
			<c:choose>
				<c:when test="${sysUser.type eq '0' }">普通操作员</c:when>
				<c:when test="${sysUser.type eq '1' }">超级管理员</c:when>
				<c:otherwise>代理商</c:otherwise>
			</c:choose>
		</p>
		<p>
			<label class="control-label x110">描述：</label>
			<textarea name="remark" class="form-control autosize" maxlength="100" rows="1" cols="30" style="overflow:hidden;resize:horizontal;height:52px;width:200px">${sysUser.remark }</textarea>
			<%-- <fieldset style="width:99%">
				<legend>选择角色<font color="red">*</font></legend>
				<c:forEach items="${rolesList}" var="v">
					<label>
						<input type="checkbox" class="selectUserRole" name="selectRole" id="roleId${v.id }" value="${v.id }">${v.roleName }
					</label>
				</c:forEach>
			</fieldset> --%>
		</p>
		<p>
			<label class="control-label x110">选择角色：</label>
			<select name="selectVal" data-toggle="selectpicker" class="required" data-rule="required">
				<option value="" >--请选择角色--</option>
                   <c:forEach items="${rolesList}" var="item">
                   	<option value="${item.id }" <c:if test="${owenedRoleIds == item.id }">selected = 'selected'</c:if> >${item.roleName }</option>
				<%-- <label>
					<input class="selectUserRole" type="checkbox" name="selectRole" value="${item.id }">${item.roleName }
				</label> --%>
				</c:forEach>
               </select>
               <span style="color:red">*</span>
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
	//回显
	$(document).ready(function() {
		var str = "${owenedRoleIds}";
		var array = new Array();
		array = str.split(",");
		for ( var i = 0; i < array.length; i++) {
			$("#roleId" + array[i]).attr("checked", "checked");
		}
	});

	function submitForm() {
		var str = "";
		$(":checkbox:checked").each(function() {
			if ($(this).hasClass('selectUserRole')){
				// 加样式判断，避免与其他复选框冲突
				str += $(this).val() + ",";
			}
		});
		if(str == null || str == ""){
			alertMsg.error("操作员关联的角色不能为空");
			return;
		}
		$("#selectVal").val(str);
		$("#form").submit();
	}
	
</script>