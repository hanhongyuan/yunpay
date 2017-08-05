<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>

<script type="text/javascript">
function do_open_layout(event, treeId, treeNode) {
    $(event.target).bjuiajax('doLoad', {url:treeNode.url, target:treeNode.divid})
    event.preventDefault();
}

function branchBringBack(branchName){
    $("#recharge_add_nameShort").val(branchName);
}
//删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
</script>
<div class="bjui-pageContent">
    <div style="padding:20px;">
            <div style="float:left; data-width:200px;">
            	<ul id="user-tree" class="ztree" data-toggle="ztree" data-expand-all="true" data-on-click="do_open_layout">
            	<li data-id="${rootBranch.instId}" data-pid="${rootBranch.instUp}" >${rootBranch.instName}</li>
            		${branchTreeHtml}
            	</ul>
            </div>
      </div> 
</div>  


