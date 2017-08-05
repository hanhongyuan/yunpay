<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
 var AttachmentAdd = {
	// 删除后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			//$(this).dialog('closeCurrent');
			$(this).navtab('refresh');
			$(this).alertmsg('ok', '上传附件成功！');
		}else{
			 $(this).alertmsg('error', '上传附件失败！');
		}
	}
}; 
</script>
<div class="pageContent" id="dup">
	<form method="post" action="${baseURL}/sys/merch/upLoad" class="pageForm" data-toggle="validate" enctype="multipart/form-data" >
		<div class="pageFormContent" >
			<fieldset style="height:50%;">
              <legend><h4>上传附件</h4></legend>
	                  <table>
						 <tr>
						 	<td>
						        <label class="control-label x90">身份证正面：</label>
						        <input id="file" type="file" name="cardName"  data-rel="required" accept="video/*;capture=camcorder" />
					        </td>
					    </tr>
					    <tr>
						 	<td>
						        <label class="control-label x90">身份证背面：</label>
						        <input id="file" type="file" name="cardBackName"  data-rel="required" accept="video/*;capture=camcorder"/>
					        </td>
					    </tr>
					    <tr>
						 	<td>
						        <label class="control-label x90">营业执照：</label>
						        <input id="file" type="file" name="licenceName" data-rel="required" accept="video/*;capture=camcorder">
					        </td>
					    </tr>
					    <tr>
						 	<td>
						        <label class="control-label x90">手持银行卡：</label>
						        <input id="file" type="file" name="singName" data-rel="required" accept="video/*;capture=camcorder">
					        </td>
					    </tr>
						<tr>
						 	<td>
						        <label class="control-label x90">餐饮许可证：</label>
						        <input id="file" type="file" name="cyxkzName" accept="video/*;capture=camcorder">
					        </td>
					    </tr>
					    <tr>
						 	<td>
						        <label class="control-label x90">店铺照片1：</label>
						        <input id="file" type="file" name="merchPhoto1" accept="video/*;capture=camcorder">
					        </td>
					    </tr>
					     <tr>
						 	<td>
						        <label class="control-label x90">店铺照片2：</label>
						        <input id="file" type="file" name="merchPhoto2" accept="video/*;capture=camcorder">
					        </td>
					    </tr>
					    <tr>
						 	<td>
						        <button type="button" class="btn-close" data-icon="close">取消</button>
						        <button type="submit" class="btn-default" data-icon="save" >保存</button>
					        </td>
					    </tr>
					</table>
           </fieldset>
		</div>
	</form>
</div>