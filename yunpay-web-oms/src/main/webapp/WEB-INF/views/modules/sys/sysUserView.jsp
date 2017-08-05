<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<form>
		<div class="pageFormContent" layoutH="60">
					<p>
						<label class="control-label x90">操作员姓名：</label>
						<input type="text" name="realName" readonly="true" minlength="2" maxlength="45" size="30" value="${sysUser.realName }"/>
					</p>
					<p>
						<label class="control-label x90">操作员登录名：</label>
						<input type="text" name="loginName" readonly="true" minlength="2" maxlength="45" size="30" value="${sysUser.loginName }"/>
					</p>
					<p>
						<label class="control-label x90">创建时间：</label>
						<fmt:formatDate value="${sysUser.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</p>
					<p>
						<label class="control-label x90">手机号码：</label>
						<input type="text" name="mobileNo" readonly="true" minlength="2" maxlength="45" size="30" value="${sysUser.mobileNo }"/>
					</p>
					<p>
						<label class="control-label x90">状态：</label>
						<c:choose>
							<c:when test="${sysUser.status eq 'ACTIVE' }">激活</c:when>
							<c:when test="${sysUser.status eq 'UNACTIVE' }">冻结</c:when>
							<c:otherwise>--</c:otherwise>
						</c:choose>
					</p>
					<p>
						<label class="control-label x90">类型：</label>
						<c:choose>
							<c:when test="${sysUser.type eq 'ADMIN' }">普通操作员</c:when>
							<c:when test="${sysUser.type eq 'USER' }">超级管理员</c:when>
							<c:when test="${sysUser.type eq 'AGENT' }">代理商</c:when>
							<%-- <c:otherwise>--</c:otherwise> --%>
						</c:choose>
						<c:if test="${sysUser.type == '0' }">普通操作员</c:if>
						<c:if test="${sysUser.type == '1' }">超级管理员</c:if>
						<c:if test="${sysUser.type == '2' }">代理商</c:if>
					</p>
					<p>
						<label class="control-label x90">描述：</label>
						<textarea name="remark" maxlength="100" data-toggle="autoheight" rows="1" cols="30">${sysUser.remark }</textarea>
					</p>
						<fieldset style="width: 99%">
							<legend>关联的角色</legend>
							<c:forEach var="item" items="${rolesList}" varStatus="st">
								<c:choose>
									<c:when test="${sysUser.type eq 'ADMIN'}">
										<label> <input type="checkbox" <c:if test="${sysUser.type eq 'ADMIN'}">disabled="disabled"</c:if> cssClass="required" name="selectRole" id="${item.id }">${item.roleName }
										</label>
									</c:when>
									<c:when test="${sysUser.type eq 'USER'}">
										<label> <input type="checkbox" disabled="disabled" cssClass="required" name="selectRole" id="${item.id }">${item.roleName }
										</label>
									</c:when>
									<c:when test="${sysUser.type == '0'}">
										<label> <input type="checkbox" disabled="disabled" cssClass="required" name="selectRole" id="${item.id }">${item.roleName }
										</label>
									</c:when>
									<c:when test="${sysUser.type == '1'}">
										<label> <input type="checkbox" disabled="disabled" cssClass="required" name="selectRole" id="${item.id }">${item.roleName }
										</label>
									</c:when>
									<c:when test="${sysUser.type == '2'}">
										<label> <input type="checkbox" disabled="disabled" cssClass="required" name="selectRole" id="${item.id }">${item.roleName }
										</label>
									</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</c:forEach>
						</fieldset>
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
		for (var i = 0; i < array.length; i++) {
			$("#" + array[i]).attr("checked", "checked");
		}
	});
</script>