<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var str = "";
function do_openCheck_layout(event, treeId, treeNode) {
    /* $(event.target).bjuiajax('doLoad', {url:treeNode.url, target:treeNode.divid});
    event.preventDefault(); */   
    /* var treeObj = $.fn.zTree.getZTreeObj("layout-treeCheck");
	var nodes = treeObj.getSelectedNodes();
	alert(nodes.length);
	for (var i=0, l=nodes.length; i < l; i++) {
		treeObj.checkNode(nodes[i], true, true);
	} 
	alert(treeNode.checked);
	//$("#"+treeId+"_check").iCheck('check'); */
    
}

function zTreeOnCheck(event, treeId, treeNode) {
	var treeObj = $.fn.zTree.getZTreeObj("layout-treeCheck");
	var nodes = treeObj.getChangeCheckedNodes();
	for(var i=0;i< nodes.length;i++) {
			var val =($("#"+nodes[i].tId+"_a").attr("href"));
			var thrId = val.substring(val.indexOf("=")+1);
			str += thrId + ",";
	};
};
var setting = {
	callback: {
		onCheck: zTreeOnCheck
	}
};

function submitForm() {
	if(str == null || str == ""){
		alertMsg.error("关联的权限不能为空!");
		return;
	}
	$("#selectVal").val(str);
	$("#form").submit();
}


	
</script>
<div class="pageContent">
<form method="post" action="${baseURL}/sys/role/assignMenu" class="pageForm" data-toggle="validate">
	<div class="pageFormContent">
	<input type="hidden" name="navTabId" value="jsgl">
	<input type="hidden" name="callbackType" value="closeCurrent">
	<input type="hidden" name="roleId" value="${role.id }" />
	<input type="hidden" name="selectVal" id="selectVal" value="">
	<input type="hidden" name="reolID" id="reolID" value="${menuIds}">
		
		<div class="tabs" style="width:100%;float:left;" >
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>分配菜单</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div>
					<div id="treeDiv" style="float:left; display:block;overflow:auto; width:100%;height:200px; border:solid 1px #CCC; line-height:21px; background:#fff">
					    <%-- <fieldset style="width:99%">
							<legend>全选<input type="checkbox"  name="selectAll" id="selectAll" ></legend>
							<c:forEach items="${menuList}" var="item"> 
							     <label>
									<input type="checkbox" class="selectMenu" name="selectMenu" id="menuId${item.id }" value="${item.id }" >${item.name }
								</label>
							</c:forEach>
						</fieldset> --%>
						<ul id="layout-treeCheck" class="ztree" data-toggle="ztree"
						 data-expand-all="true" data-on-click="do_openCheck_layout"
						  data-check-enable="true" data-options="{onCheck:'zTreeOnCheck'}">
							${tree}
						</ul>
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
					<div style="float:left; display:block; overflow:auto; width:389px; border:solid 1px #CCC; line-height:21px; background:#fff" id="userDiv">
						<table class="table-hover" data-width="100%" >
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
		        <li><button type="submit" class="btn-default" data-icon="save" onclick="submitForm();">保存</button></li>
		    </ul>
		</div>
	</form>
</div>
<script type="text/javascript">
/* $(document).ready(function() {
	var treeObjOne = $.fn.zTree.getZTreeObj("layout-treeCheck");
	var nodesOne = treeObjOne.getNodes();
	var arry = treeObjOne.transformToArray(nodesOne);
	//var val1 =($("#"+arry[1].tId).attr("href"));
	//var str1 = $("#reolID").val();
	var array = new Array();
	array = str1.split(",");
	for(var x=0;x<arry.length;x++){
		for ( var j = 0; j < array.length-1; j++) {
			
		}
	}  
}); */
</script> 
