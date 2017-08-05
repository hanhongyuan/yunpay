<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">

$(document).ready(function() {
	 $("#attachAdd").hide();
});
 var MerchAdd = {
	// 成功后的回调函数，刷新当前页面
	navTabAjax: function(json) {
		//navTabAjaxDone(json);
		if(json.statusCode=='200')
		{
			url = '${baseURL}/sys/merch/attachmentUpLoad?merchId='+json.merchId;
    		$('#attachAdd form').attr('action',url);
    		$(this).alertmsg('ok', '添加成功！');
			$("#merchAdd").hide();
			$("#attachAdd").show();
		}else{
			 $(this).alertmsg('error', '添加失败！');
		}
	}
}; 
 var AttachmentAdd = {
			// 删除后的回调函数，刷新当前页面
			navTabAjax: function(json) {
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
<div class="pageContent">
	<div id="merchAdd">
	<form method="post" action="${baseURL}/sys/merch/merchAdd" class="pageForm" data-toggle="validate" data-callback="MerchAdd.navTabAjax" >
		<div class="pageFormContent">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
                  <table class="table table-bordered table-hover table-striped table-top" >
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">营业执照名称：</label>
							<input type="text" name="registerName" size="25" value="${registerName }" maxlength="25" data-rule="required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">商户名称：</label>
							<input type="text" name="nameShort" size="25" value="${shortName }" maxlength="15" data-rule="required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">联系人：</label>
							<input type="text" name="linkman" size="25" value="${linkman }" maxlength="30" data-rule="required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">联系电话：</label>
							<input type="text" name="linkTel" size="25" value="${linkTel }" maxlength="30" data-rule="mobile" data-msg-mobile="联系电话格式不正确" class="required input-nm"/>
						</td>
					</tr>
					<tr style="line-height: 35px">
						<td>
							<label class="control-label x90">所在省市：</label>
							<select name="provice"  id="add_contractInfo_provice"  data-toggle="selectpicker" data-rule="required" data-nextselect="#add_contractInfo_region"  data-refurl="${baseURL}/sys/merch/regionAddUI?code={value}">
								<option value="">--请选择--</option>
									<c:forEach var ="provice" items="${proviceList }">
								       <option value="${provice.code }">${provice.name }</option>
								    </c:forEach>
							</select>
							<select name="region"  id="add_contractInfo_region"  data-toggle="selectpicker" data-rule="required" data-nextselect="#add_contractInfo_area"  data-refurl="${baseURL}/sys/merch/areaAddUI?code={value}" >
								<option value="">--请选择--</option>
									<c:forEach var ="region" items="${regionList }">
								       <option value="${region.code }">${region.name }</option>
								    </c:forEach>
							</select>
							<select name="areaNo"  id="add_contractInfo_area" data-toggle="selectpicker" data-rule="required" data-emptytxt="--地区--">
								<option value="">--请选择--</option>
									<c:forEach var ="area" items="${areaList }">
								       <option value="${area.code }">${area.name }</option>
								    </c:forEach>
							</select>
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">行业分类：</label>
							<select name="merType"  id="add_contractInfo_mcctype" data-toggle="selectpicker" data-nextselect="#add_contractInfo_childtype" data-refurl="${baseURL}/sys/merch/merchTypeAddUI?code={value}">
								<option value="">--请选择--</option>
								        <c:forEach var ="merchType" items="${merTypeList }">
								       		<option value="${merchType.code }">${merchType.name }</option>
								    	</c:forEach>
							</select>
							<select name="childType"  id="add_contractInfo_childtype" data-toggle="selectpicker">
								<option value="">--请选择--</option>
									<c:forEach var ="type" items="${typeList }">
								       <option value="${type.code }">${type.name }</option>
								    </c:forEach>
							</select>
							<span style="color:red">*</span>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">开户名：</label>
							<input type="text" name="accountName" size="25" value="${accountName }" maxlength="30" data-rule="required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">开户账号：</label>
							<input type="text" name="accountNo" size="25" value="${accountNo }" maxlength="30" data-rule="账号:required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">确认账号：</label>
							<input type="text" id="accountNo" size="25" value="${bankName }" maxlength="30" data-rule="确认账号:required;match(accountNo)" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px"> 
							<label class="control-label x90">开户行：</label>
							<input type="text" name="accountBank" size="25" value="${accountBank }" maxlength="30" data-rule="required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90">商户地址：</label>
							<input type="text" name="merchAddr" size="25" value="${merchAddr }" maxlength="30" data-rule="required" class="required input-nm"/>
						</td>
					</tr>
					<tr>
						<td style="line-height: 35px">
							<label class="control-label x90"></label>
							<button type="submit" class="btn-default" data-icon="save" >保存</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn-close" data-icon="close">取消</button>
						</td>
					</tr>
				</table>
		</div>
	</form>
	</div>
	<div id="attachAdd">
		<form method="post" class="pageForm" action="" data-toggle="validate" enctype="multipart/form-data" data-callback="AttachmentAdd.navTabAjax">
		<div class="pageFormContent">
              <table>
				 <tr>
				 	<td>
				        <label class="control-label x90">身份证正面：</label>
				        <input id="file" type="file" name="cardName"  data-rule="required" accept="video/*;capture=camcorder" />
			        </td>
			    </tr>
			    <tr>
				 	<td>
				        <label class="control-label x90">身份证背面：</label>
				        <input id="file" type="file" name="cardBackName"  data-rule="required" accept="video/*;capture=camcorder"/>
			        </td>
			    </tr>
			    <tr>
				 	<td>
				        <label class="control-label x90">营业执照：</label>
				        <input id="file" type="file" name="licenceName" data-rule="required" accept="video/*;capture=camcorder">
			        </td>
			    </tr>
			    <tr>
				 	<td>
				        <label class="control-label x90">手持银行卡：</label>
				        <input id="file" type="file" name="singName" data-rule="required" accept="video/*;capture=camcorder">
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
					<td style="line-height: 35px">
						<label class="control-label x90"></label>
						<button type="submit" class="btn-default" data-icon="save" >保存</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn-close" data-icon="close">取消</button>
					</td>
				</tr>
			</table>
		</div>
		<!-- <div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
		        <li><button type="submit" class="btn-default" data-icon="save" >保存</button></li>
		    </ul>
		</div> -->
	</form> 
	</div>
</div>