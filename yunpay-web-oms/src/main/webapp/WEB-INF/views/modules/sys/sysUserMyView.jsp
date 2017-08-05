<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<form>
		<div class="pageFormContent" layoutH="60">
					<p>
						<label class="control-label x90">姓名：</label>
						<span>${user.realName}</span>
					</p>
					<p>
						<label class="control-label x90">登录名：</label>
						<span>${user.loginName}</span>
					</p>
					<p>
						<label class="control-label x90">手机号码：</label>
						<span>${user.mobileNo}</span>
					</p>
					<p>
						<label class="control-label x90">备注：</label>
						<span>${user.remark}</span>
					</p>
		</div>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
		       <!--  <li><button type="submit" class="btn-default" data-icon="save">保存</button></li> -->
		    </ul>
		</div>
	</form>
</div>
