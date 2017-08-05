<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="bjui-pageFooter">
	<div class="pages">
		<span>显示</span>
		<div class="selectPagesize">
			<select data-toggle="selectpicker" data-toggle-change="changepagesize" name="numPerPage"
				value="${pageBean.numPerPage}" onchange="navTabPageBreak({numPerPage:this.value})">
				<c:forEach begin="15" end="90" step="15" varStatus="s">
					<option value="${s.index}" ${pageBean.numPerPage eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select>
		</div>
		<span> 条,共<a style="color: red">${pageBean.totalCount}</a>条, 共${pageBean.totalPage}页, 当前第${pageBean.currentPage}页 </span>
	</div>
	<div class="pagination" targetType="navTab"
		totalCount="${pageBean.totalCount}" numPerPage="${pageBean.numPerPage}"
		pageNumShown="10"
		currentPage="${pageBean.currentPage}"></div>
</div>