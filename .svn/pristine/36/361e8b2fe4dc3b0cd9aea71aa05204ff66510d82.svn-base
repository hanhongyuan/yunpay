<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var editAttachment = {
	// 删除后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			$(this).dialog('closeCurrent');
			$(this).navtab('refresh');
			$(this).alertmsg('ok', '修改成功！');
		}else{
			 $(this).alertmsg('error', '修改失败！');
		}
	}
}; 
</script>
<div class="pageContent">
	<form method="post" action="${baseURL}/sys/merch/editAttachment?merchId=${merchId}" class="pageForm" enctype="multipart/form-data" data-toggle="validate" data-callback="editAttachment.navTabAjax">
		<div class="pageFormContent">
                  <table>
                  	<tr>
                  		<c:if test="${(attachment.licencePath != null) && ! ('' eq attachment.licencePath)}">
                  			<td><img src="${attachment.licencePath}" alt="营业执照" width="140px" height="100px" id="licencePath" /><span>营业执照</span></td>
                  		</c:if>
                  		<c:if test="${(attachment.cardPath != null) && ! ('' eq attachment.cardPath)}">
                  			<td><img src="${attachment.cardPath}" alt="身份证正面" width="140px" height="100px" id="cardPath" /><span>身份证正面</span></td>
                  		</c:if>
                  		<c:if test="${(attachment.cardBackPath != null) && ! ('' eq attachment.cardBackPath)}">
                  			<td><img src="${attachment.cardBackPath}" alt="身份证背面" width="140px" height="100px" id="cardBackPath" /><span>身份证背面</span></td>
                  		</c:if>
                  	</tr>
                  	<tr>
                  		<c:if test="${(attachment.photo1Path != null) && ! ('' eq attachment.photo1Path)}">
                  			<td><img src="${attachment.photo1Path}" alt="店铺照1" width="140px" height="100px" id="photo1Path" /><span>店铺照1</span></td>
                  		</c:if>
                  		<c:if test="${(attachment.cyxkzPath != null) && ! ('' eq attachment.cyxkzPath)}">
                  			<td><img src="${attachment.cyxkzPath}" alt="餐饮许可证照片" width="140px" height="100px" id="cyxkzPath" /><span>餐饮许可证照片</span></td>
                  		</c:if>
                  		<c:if test="${(attachment.singPath != null) && ! ('' eq attachment.singPath)}">
                  			<td><img src="${attachment.singPath}" alt="手持银行卡" width="140px" height="100px" id="singPath" /><span>手持银行卡</span></td>
                  		</c:if>
                  	</tr>
                  	<tr>
					 	<td colspan="3">
					        <label class="control-label x90">营业执照：</label>
					        <input id="file" type="file" name="licenceName" accept="video/*;capture=camcorder">
				        </td>
				    </tr>
					 <tr>
					 	<td colspan="3">
					        <label class="control-label x90">身份证正面：</label>
					        <input type="file" name="cardName" accept="video/*;capture=camcorder">
				        </td>
				    </tr>
				    <tr>
					 	<td colspan="3">
					        <label class="control-label x90">身份证背面：</label>
					        <input id="file" type="file" name="cardBackName" accept="video/*;capture=camcorder">
				        </td>
				    </tr>
				    <tr>
					 	<td colspan="3">
					        <label class="control-label x90">手持银行卡：</label>
					        <input id="file" type="file" name="singName" accept="video/*;capture=camcorder">
				        </td>
				    </tr>
					<tr>
					 	<td colspan="3">
					        <label class="control-label x90">餐饮许可证：</label>
					        <input id="file" type="file" name="cyxkzName" accept="video/*;capture=camcorder">
				        </td>
				    </tr>
				    <tr>
					 	<td colspan="3">
					        <label class="control-label x90">店铺照片1：</label>
					        <input id="file" type="file" name="merchPhoto1" accept="video/*;capture=camcorder">
				        </td>
				    </tr>
				</table>
		</div>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
		        <li><button type="submit" class="btn-default" data-icon="save" >保存</button></li>
		    </ul>
		</div>
	</form>
</div>