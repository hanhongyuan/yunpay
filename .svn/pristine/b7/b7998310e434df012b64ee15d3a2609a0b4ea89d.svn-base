<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
	
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/user/list" method="post">
        <div class="bjui-searchBar">
            <label>操作员登录名：</label><input type="text" name="loginName" value="${param.loginName}" size="15" alt="精确查询" class="form-control" >&nbsp;
            <label>操作员姓名：</label><input type="text" name="realName" value="${param.realName}" size="15" alt="模糊查询" class="form-control" >&nbsp;
            <label>状态：</label>
				<select name="status" class="combox">
						<option value="">-全部-</option>
						<option value="ACTIVE" <c:if test="${param.status eq'ACTIVE' }">selected = 'selected'</c:if>>-激活-</option>
						<option value="UNACTIVE" <c:if test="${param.status eq'UNACTIVE' }">selected = 'selected'</c:if>>-冻结-</option>
				</select>
					
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
            <div>
            	<%-- <a class="add" href="${baseURL}/sys/user/addUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" rel="input" title="添加操作员"> --%>
                <button type="button" class="btn-blue" href="${baseURL}/sys/user/addUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="添加操作员" data-icon="plus">添加操作员</button>
                <div class="pull-right">
                <div class="btn-group">
                    <button type="button" class="btn-default dropdown-toggle" data-toggle="dropdown" data-icon="copy">批量操作<span class="caret"></span></button>
                    <ul class="dropdown-menu right" role="menu">
                        <li><a href="book1.xlsx" data-toggle="doexport" data-confirm-msg="确定要导出信息吗？">导出<span style="color: green;">全部</span></a></li>
                        <li><a href="book1.xlsx" data-toggle="doexportchecked" data-confirm-msg="确定要导出选中项吗？" data-idname="expids" data-group="ids">导出<span style="color: red;">选中</span></a></li>
                        <li class="divider"></li>
                        <li><a href="ajaxDone2.html" data-toggle="doajaxchecked" data-confirm-msg="确定要删除选中项吗？" data-idname="delids" data-group="ids">删除选中</a></li>
                    </ul>
                </div>
            </div>
            </div>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <!-- <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true"> -->
       <table class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed"> 
        <thead>
            <tr>
            	<th style="width:200px">操作</th>
               <!--  <th data-order-field="index" align="center">序号</th> -->
                <th>操作员编号</th>
                <th data-order-field="loginName">操作员登录名</th>
                <th data-order-field="realName">操作员姓名</th>
                <th data-order-field="mobileNo">手机号码</th>
                <th data-order-field="createTime">创建时间</th>
                <th data-order-field="status"  align="center">状态</th>
                <!-- <th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th> -->
            </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${pageBean.recordList}" varStatus="st">
				<!-- 普通操作员看不到超级管理员信息 -->
				<tr target="sid_user" rel="${id}">
					<td style="width:250px">
						<a href="${baseURL}/sys/user/viewUI?id=${item.id}" class="btn btn-green" title="查看【${item.loginName }】详情" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" style="color: blue">查看</a>
						<c:if test="${item.type eq '0' }">
									&nbsp;<a href="${baseURL}/sys/user/editUI?id=${item.id}" class="btn btn-green" title="修改【${item.loginName }】" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" rel="userUpdate" style="color: blue">修改</a>
									&nbsp;<a href="${baseURL}/sys/user/resetPwdUI?id=${item.id}" class="btn btn-green" title="重置【${item.loginName }】的密码" target="dialog" width="550" height="300" style="color: blue">重置密码</a>
									
									<c:if test="${item.type eq '0' && item.status==UserStatusEnum.ACTIVE.value}">
									&nbsp;<a href="${baseURL}/sys/user/changeStatus?id=${item.id}" class="btn btn-green" title="冻结【${item.loginName }】" target="ajaxTodo" style="color: blue">冻结</a>
									</c:if>

							<c:if test="${item.type eq '0' && item.status==UserStatusEnum.UNACTIVE.value}">
									&nbsp;<a href="${baseURL}/sys/user/changeStatus?id=${item.id}" class="btn btn-green" title="激活【${item.loginName }】" target="ajaxTodo" style="color: blue">激活</a>
									</c:if>

							<c:if test="${item.type eq '0' }">
									&nbsp;<a href="${baseURL}/sys/user/delete?id=${item.id}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定要删除该行信息吗？" >删除</a>
									</c:if>
						</c:if>
					</td>
					<%-- <td style=" width:20px">${st.index+1}</td> --%>
					<td>00${st.index+1}</td>
					<td>${item.loginName }</td>
					<td>${item.realName }</td>
					<td>${item.mobileNo }</td>
					<td>
						<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					</td>
					<td>
						<c:if test="${item.status eq UserStatusEnum.ACTIVE.value}">激活</c:if>
						<c:if test="${item.status eq UserStatusEnum.INACTIVE.value}">冻结</c:if>
					</td>
					<%-- <td><input type="checkbox" name="ids" data-toggle="icheck" value="${item.id}"></td> --%>
				</tr>
			</c:forEach>
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize" name="numPerPage"
			value="${pageBean.numPerPage}">
			<c:forEach begin="15" end="90" step="15" varStatus="s">
				<option value="${s.index}" ${pageBean.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
        </div>
        <span>&nbsp;条，共 ${pageBean.totalCount} 条,共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页 </span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${pageBean.totalCount}" data-page-size="${pageBean.numPerPage}" data-page-current="${pageBean.currentPage}">
    </div>
</div>
