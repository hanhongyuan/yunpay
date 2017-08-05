<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<form method="post" action="${baseURL}/sys/user/editPwd" class="pageForm" data-toggle="validate">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="navTabId" value="czygl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			
				<input type="hidden" name="id" value="${user.id}" />
				<input type="hidden" name="loginName" value="${user.loginName}" />
				
				<p>
					<label class="control-label x90">登录名：</label>
					<span>${user.loginName }</span>
				</p>
				<!-- <p>
					<label class="control-label x90">旧密码：</label>
					<input type="password" id="newPwd" name="loginPwd" class="required"  maxlength="20" size="20" />
				</p> -->
				<p>
					<label class="control-label x90">新密码：</label>
					<input type="password"  name="newPwd" class="required" data-rule="密码:required;length[6~20]" size="20" />
				</p>
				<p>
					<label class="control-label x90">确认新密码：</label>
					<input type="password" id="newPwd" class="required" size="20" data-rule="确认密码:required;match(newPwd)" />
				</p>
		</div>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
		        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
		    </ul>
		</div>
	</form>
</div>
