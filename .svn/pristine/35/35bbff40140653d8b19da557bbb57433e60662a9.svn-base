<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>

<script type="text/javascript">
function do_open_layout(event, treeId, treeNode) {
    $(event.target).bjuiajax('doLoad', {url:treeNode.url, target:treeNode.divid})
    event.preventDefault();
    
}
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="${baseURL }/sys/menu/list" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <%-- <div class="bjui-searchBar">
	            <label>
					<shiro:hasPermission name="sys:menu:add">
						<a id="addMenu" class="add" href="${baseURL}/sys/menu/addUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" rel="input" title="添加菜单">
						<button type="button" class="btn-blue" href="${baseURL}/sys/menu/addUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" title="添加菜单" data-icon="plus">添加菜单</button>
					</shiro:hasPermission>
				</label>
				<label>
					<shiro:hasPermission name="sys:menu:delete">
						<a id="delMenu" class="delete" href="${baseURL}/sys/menu/delete" callback="navTabAjax" data-toggle="dialog" rel="inputMenu" title="确定执行该删除操作吗？">
						<button type="button" class="btn-red" href="${baseURL}/sys/menu/delete" data-toggle="dialog" data-confirm-msg="确定执行该删除操作吗？" data-icon="times">删除</button>
						</a>
					</shiro:hasPermission>
				</label>
				<label>
					<!-- <a id="updateMenu" class="edit" href="javascript:onscreach();"> -->
						<button type="button" class="btn-green" data-icon="refresh" href="javascript:onscreach();">刷新</button>
					<a id="updateMenu" class="edit" href="${baseURL}/sys/menu/editUI" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" rel="input" title="修改菜单">
						<span>修改</span>
					</a>
				</label>
			
        </div> --%>
     </form>
</div>
<div class="bjui-pageContent" style="data-width:240px;">
	<div style="padding:20px;">
		<div style="float:left; data-width:200px;">
			<ul id="layout-tree" class="ztree" data-toggle="ztree" data-expand-all="true" data-on-click="do_open_layout" >
				${tree}
			</ul>
		</div>
		<div style="margin-left:210px; height:750px; overflow:hidden;">
	       		<div style="height:99%; overflow:hidden;">
	           		<fieldset style="height:100%;">
	                	<legend>菜单详情</legend>
		                <div id="layout_menu_list" style="height:94%; overflow:hidden;">
		                    
	                	</div>
	           		</fieldset>
	           	</div>
		</div>
	</div> 
</div>  
<script type="text/javascript">
	function onClickMenuNode(id) {
		$("#addMenu").attr("href", "sys/menu/addUI?pid=" + id);
		$("#delMenu").attr("href", "sys/menu/delete?menuId=" + id);
	}
	function onscreach() {
		$("#treeForm1").submit();
	}

	// 删除后的回调函数，刷新树形菜单
	function navTabAjax(json) {
		//navTabAjaxDone(json);
		navTab.reload();
	}
</script>

	<%-- <form id="treeForm1" onsubmit="return navTabSearch(this);" action="${baseURL }/sys/menu/list" method="post"></form>
	<div class="pageContent" style="padding: 5px">
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li>
							<a href="javascript:;">
								<span>菜单管理</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div>
					<div class="panelBar" style="width: 262px">
						<ul class="toolBar">
							<li>
								<shiro:hasPermission name="sys:menu:add">
									<a id="addMenu" class="add" href="${baseURL}/sys/menu/addUI" target="dialog" rel="input" width="600" height="400" title="添加菜单">
										<span>添加</span>
									</a>
								</shiro:hasPermission>
							</li>
							<li>
								<shiro:hasPermission name="sys:menu:delete">
									<a id="delMenu" class="delete" href="${baseURL}/sys/menu/delete" callback="navTabAjax" target="ajaxTodo" rel="inputMenu" title="确定执行该删除操作吗？">
										<span>删除</span>
									</a>
								</shiro:hasPermission>
							</li>
							<li>
								<a id="updateMenu" class="edit" href="javascript:onscreach();">
									<span>刷新</span>
								</a>
							</li>
						</ul>
					</div>
					<div layoutH="78" style="float: left; display: block; overflow: auto; width: 260px; border: solid 1px #CCC; line-height: 21px; background: #fff">${tree}</div>
					<div layoutH="78" id="jbsxBox" class="unitBox" style="margin-left: 266px;"></div>
				</div>
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function onClickMenuNode(id) {
		$("#addMenu").attr("href", "sys/menu/addUI?pid=" + id);
		$("#delMenu").attr("href", "sys/menu/delete?menuId=" + id);
	}
	function onscreach() {
		$("#treeForm1").submit();
	}

	// 删除后的回调函数，刷新树形菜单
	function navTabAjax(json) {
		//navTabAjaxDone(json);
		navTab.reload();
	}
</script> --%>