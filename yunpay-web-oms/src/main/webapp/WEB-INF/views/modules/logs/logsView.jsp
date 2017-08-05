<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<form>
		<div class="pageFormContent" layoutH="60">

			<p style="width: 99%">
				<label>用户ID：</label>
				<label>${loginfo.user_id }</label>
			</p>
			<p style="width: 99%">
				<label>登录名：</label>
				<label>${loginfo.login_name }</label>
			</p>
			<p style="width: 99%">
				<label>操作者姓名：</label>
				<label>${loginfo.user_name }</label>
			</p>
			<p style="width: 99%">
				<label>操作时间：</label>
				<label>
				    <fmt:formatDate value="${loginfo.log_time }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</label>
			</p>
			<p style="width: 99%">
				<label>用户类型：</label>
				<label>
				    <c:if test="${loginfo.user_type eq '-1'}"></c:if>
				    <c:if test="${loginfo.user_type eq '0'}">管理台用户</c:if>
				    <c:if test="${loginfo.user_type eq '1'}">企业用户</c:if>
				    <c:if test="${loginfo.user_type eq '2'}">Web用户</c:if>
				    <c:if test="${loginfo.user_type eq '3'}"></c:if>
				</label>
			</p>
			<p style="width: 99%">
                <label>日志类型：</label>
                <label>${loginfo.log_type_name }</label>
            </p>
            <p style="width: 99%">
                <label>功能编码：</label>
                <label>${loginfo.function_code }</label>
            </p>
            <p style="width: 99%">
                <label>功能描述：</label>
                <label>${loginfo.log_content }</label>
            </p>
            <p style="width: 99%">
                <label>模块编码：</label>
                <label>${loginfo.module_code }</label>
            </p>
            <p style="width: 99%">
                <label>IP地址：</label>
                <label>${loginfo.ip }</label>
            </p>
            <p style="width: 99%">
                <label>操作结果：</label>
                <label>
	                <c:if test="${loginfo.result eq '1'}">成功</c:if>
	                <c:if test="${loginfo.result eq '2'}">失败</c:if>
	                <c:if test="${loginfo.result eq '3'}">异常</c:if>
                </label>
            </p>
            <p style="width: 99%">
                <label>操作信息：</label>
                <label>${loginfo.msg }</label>
            </p>

		</div>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
		    </ul>
		</div>
	</form>
</div>