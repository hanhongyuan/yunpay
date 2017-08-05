<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var TranTypeAdd = {
	// 删除后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).navtab('refresh');
			$(this).alertmsg('ok', '添加成功！');
		}else{
			 $(this).alertmsg('error', '添加失败！');
		}
	}
};
</script>

<div class="pageContent">
	<form method="post" action="${baseURL}/sys/tranType/add" class="pageForm" data-toggle="validate" data-callback="TranTypeAdd.navTabAjax">
		<div class="pageFormContent">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			<p>
				<label class="control-label x120">交易类型码：</label>
				<input type="text" name="tranType" class="required" data-rule="required" value="${tranType}" maxlength="90" size="30">
			</p>
			<p>
				<label class="control-label x120">类型名称：</label>
				<input type="text" name="tranDesc" class="required" data-rule="required" value="${tranDesc}" maxlength="90" size="30" />
			</p>
			<p>
				<label class="control-label x120">交易授权控制：</label>
				<input type="text" name="tranAuth" value="${tranAuth}" maxlength="30" size="30" />
			</p>
			<p>
				<label class="control-label x120">交易类别：</label>
				<input type="text" name="tranKind" value="${tranKind}" maxlength="90" size="30" />				
			</p>
			<p>
				<label class="control-label x120">交易处理标志：</label>
				<input type="text" name="tranPFlag" value="${tranPFlag}" maxlength="90" size="30" />				
			</p>
			<p>
				<label class="control-label x120">借贷标志：</label>
	               <select name="tranCd" data-toggle="selectpicker">
	               <option value="" selected="selected">--请选择--</option>
	                   <option value="1">借记</option>
	                   <option value="2">贷记</option>
	             </select>
	        </p>
	        <p>
				 <label class="control-label x120">应用类型：</label>
				 <select name="appType" data-toggle="selectpicker">
						<option value="" selected="selected">--请选择--</option>
						<c:forEach var="itms" items="${appifnoList}" varStatus="st">
	                		<option value="${itms.code}">${itms.name}</option>
	            		</c:forEach>
	             </select> 
			</p>
			<p>
				<label class="control-label x120">原始交易类型：</label>
	                  <select name="origTranType" data-toggle="selectpicker">
	                  	<option value="" selected="selected">--请选择--</option>
	                   <c:forEach var="itms" items="${tranTypeList}" varStatus="st">
	                       <option value="${itms.code }">${itms.name }</option>
	                   </c:forEach>
	                  </select>  
			</p>
			<p>
				<label class="control-label x120">清算标志：</label>
				<input type="radio" name="settleFlag" value="1" data-toggle="icheck" data-label="是" />
				<input type="radio" name="settleFlag" value="0" data-toggle="icheck" data-label="否" checked />
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