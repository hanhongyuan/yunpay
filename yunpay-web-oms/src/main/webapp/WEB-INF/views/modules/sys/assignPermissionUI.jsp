<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
<form method="post" action="${baseURL}/sys/role/assignPermission" class="pageForm" data-toggle="validate">
	<div class="pageFormContent" layoutH="60">
	<input type="hidden" name="navTabId" value="jsgl">
	<input type="hidden" name="callbackType" value="closeCurrent">
	<input type="hidden" name="roleId" value="${role.id }" />
	<input type="hidden" name="selectVal" id="permissiontVal" value="">
		
		<div class="tabs" style="width:100%;float:left;" >
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>分配权限</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div>
					<div id="treeDiv" layoutH="100" style="float:left; display:block;overflow:auto; width:100%;height:200px; border:solid 1px #CCC; line-height:21px; background:#fff">
					    <fieldset style="width:99%">
							<legend>全选<input type="checkbox"  name="selectAll" id="selectAll" ></legend>
							<c:forEach items="${permissionList}" var="v">
								<label>
									<input type="checkbox" class="selectPer" name="selectPer" id="perId${v.id }" value="${v.id }">${v.permissionName }
								</label>
							</c:forEach>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 用户 -->
		<div class="tabs" style="width: 400px;float:left; " >
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>关联了此角色的操作员</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div>
					<div layoutH="100" style="float:left; display:block; overflow:auto; width:389px; border:solid 1px #CCC; line-height:21px; background:#fff" id="userDiv">
						<table class="table-hover" targetType="navTab" asc="asc" desc="desc" width="100%" layoutH="123">
							<thead>
								<tr>
									<th>序号</th>
									<th>登录名</th>
									<th>用户姓名</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${userList}" varStatus="st">
									<tr target="sid_user" rel="${id}">
									    <td>${st.index+1}</td>
										<td>${item.loginName }</td>
										<td>${item.realName }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
		        <li><button type="submit" class="btn-default" onclick="submitForm();" data-icon="save">保存</button></li>
		    </ul>
		</div>
	</form>
</div>
<script type="text/javascript">
//回显
$(document).ready(function() {
	var permissionStr = "${permissionIds}";
	var array = new Array();
	array = permissionStr.split(",");
	for ( var i = 0; i < array.length; i++) {
		$("#perId" + array[i]).attr("checked", "checked");
	}
	
	$("#selectAll").click(function(){
		if($("#selectAll").is(':checked')){
			$("input[name='selectPer']").attr("checked","checked"); 
		}else{
			$("input[name='selectPer']").removeAttr("checked");
		}
	}); 
});


function submitForm() {
	var strId = "";
	$(":checkbox:checked").each(function() {
		if ($(this).hasClass('selectPer')){
			// 加样式判断，避免与其他复选框冲突
			strId += $(this).val() + ",";
		}
	});
	if(strId == null || strId == ""){
		alertMsg.error("关联的权限不能为空!");
		return;
	}
	$("#permissiontVal").val(strId);
	$("#form").submit();
}
</script>
