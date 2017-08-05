<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var UserAdd = {
	// 删除后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).navtab('refresh');
			$(this).alertmsg('ok', '添加成功！');
		}else{
			 $(this).alertmsg('error', json.message);
		}
	}
};
</script>

<div class="pageContent">
	<form method="post" action="${baseURL}/sys/user/add" class="pageForm" data-toggle="validate" data-callback="UserAdd.navTabAjax">
		<div class="pageFormContent" layoutH="60">
		    <input type="hidden" name="navTabId" value="czygl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			<!-- <input type="hidden" name="selectVal" id="selectVal" > -->
			<input type="hidden" name="status" value="ACTIVE" >
			<p>
				<label></label>
				<span style="color:red;">提示：操作员添加后将不可删除，登录名不可修改，请确保添加信息的准确性！</span>
			</p>
			<p>
				<label class="control-label x90">操作员姓名：</label>
				<input type="text" name="realName" value="${realName}" class="required" data-rule="required"  maxlength="45" size="30" />
			</p>
			<p>
				<label class="control-label x90">操作员登录名：</label>
				<input type="text" name="loginName" value="${loginName}" class="required" data-rule="required" maxlength="30" size="30" />
			</p>
			<p>
				<label class="control-label x90">密码：</label>
				<input type="password" name="loginPwd" value="${loginPwd}" class="required" data-rule="required" maxlength="20" size="30" />
				<span class="info"></span>
			</p>
			<p>
					<label class="control-label x90">所属部门：</label>
					<!-- <input type="text" name="instName" value="" class="required" maxlength="20" size="30" /> -->
					<input id="look_branch_name" class="doc_lookup" type="text" data-rule="required" data-url="${baseURL }/sys/user/addBranchUI" name="branchName" value="${instName}" readonly data-toggle="lookup" data-width="600" data-height="400" title="选择部门" size="30">
			</p>
			<p>
				<label class="control-label x90">上级用户ID：</label>
				<select name="parentId" data-toggle="selectpicker">
					<c:forEach var="item" items="${sysUserList }">
                        <option value="${item.id }" <c:if test="${item.id eq '1' }">selected='selected'</c:if>>${item.realName }</option>
                	</c:forEach>
                </select>
                <span style="color:red">*</span>
			</p>
			<p>
				<label class="control-label x90">手机号码：</label>
				<input type="text" name="mobileNo" value="${mobileNo}" class="required" data-rule="required mobile" maxlength="12" size="30" />
			</p>
			<p>
				<label class="control-label x90">操作员类型：</label>
				<select name="type" data-toggle="selectpicker">
                        <option value="0" selected="selected">普通用户</option>
                        <option value="2">代理商</option>
                </select>
                <span style="color:red">*</span>
			</p>
			<p>
				<label class="control-label x90">描述：</label>
				<textarea name="remark" maxlength="100"  data-toggle="autoheight" rows="1" cols="30" style="height:42px;width:200px">${remark}</textarea>
			</p>
			<p>
				<label class="control-label x90">选择角色：</label>
				<select name="selectVal" data-toggle="selectpicker" class="required" data-rule="required">
					<option value="" >--请选择角色--</option>
                    <c:forEach items="${rolesList}" var="item">
                    	<option value="${item.id }">${item.roleName }</option>
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
	
</script>