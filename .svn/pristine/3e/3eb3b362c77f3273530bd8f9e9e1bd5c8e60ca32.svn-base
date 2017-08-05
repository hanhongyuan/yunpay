<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
 var MerchEdit = {
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
	<form method="post" action="${baseURL}/sys/merch/merchEdit?merchId=${merch.merchId}" class="pageForm" data-toggle="validate" data-callback="MerchEdit.navTabAjax">
		<div class="pageFormContent">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			
			<p>
				<label class="control-label x90">营业执照名称：</label>
				<input type="text" name="registerName" size="25" value="${merch.registerName }" maxlength="25" data-rule="required" class="required"/>
			</p>
			<p>
				<label class="control-label x90">商户名称：</label>
				<input type="text" name="nameShort" size="25" value="${merch.nameShort }" maxlength="15" data-rule="required" class="required"/>
			</p>
			<p>
				<label class="control-label x90">联系电话：</label>
				<input type="text" name="linkTel" size="25" value="${merch.linkTel }" maxlength="30" data-rule="required mobile" data-msg-mobile="联系电话格式不正确" class="required"/>
			</p>
			<p>
				<label class="control-label x90">所在省市：</label>
				<select name="provice"  id="add_contractInfo_provice"  data-toggle="selectpicker" data-nextselect="#add_contractInfo_region" data-refurl="${baseURL}/sys/merch/regionAddUI?code={value}">
					<option value="">--请选择--</option>
						<c:forEach var ="provice" items="${proviceList }">
					       <option value="${provice.code }" <c:if test="${merch.provice eq provice.code }">selected = 'selected' </c:if> >${provice.name }</option>
					    </c:forEach>
				</select>
				<select name="region"  id="add_contractInfo_region"  data-toggle="selectpicker" data-nextselect="#add_contractInfo_area" data-refurl="${baseURL}/sys/merch/areaAddUI?code={value}">
					<option value="">--请选择--</option>
						<c:forEach var ="region" items="${regionList }">
					       <option value="${region.code }" <c:if test="${merch.region eq region.code }">selected = 'selected' </c:if> > ${region.name }</option>
					    </c:forEach>
				</select>
				<select name="areaNo"  id="add_contractInfo_area" data-toggle="selectpicker" data-emptytxt="--地区--" data-rule="required">
					<option value="">--请选择--</option>
						<c:forEach var ="area" items="${areaList }">
					       <option value="${area.code }" <c:if test="${merch.areaNo eq area.code }">selected = 'selected' </c:if>>${area.name }</option>
					    </c:forEach>
				</select>
				<span style="color:red">*</span>
			</p>
			<p>
						<%-- <tr>
							<td>
								<label class="control-label x90">行业分类：</label>
								<select name="merType"  id="add_contractInfo_mcctype" data-toggle="selectpicker" data-nextselect="#add_contractInfo_childtype" data-refurl="${baseURL}/sys/merch/merchTypeAddUI?code={value}">
									<option value="">--请选择--</option>
									        <c:forEach var ="merchType" items="${merTypeList }">
									       		<option value="${merchType.code }">${merchType.name }</option>
									    	</c:forEach>
									
								</select>
								<select name="childType"  id="add_contractInfo_childtype" class="required combox" >
									<option value="">--请选择--</option>
										<c:forEach var ="type" items="${typeList }">
									       <option value="${type.code }">${type.name }</option>
									    </c:forEach>
								</select>
								<span style="color:red">*</span>
			
							</td>
						</tr> --%>
						
					<label class="control-label x90">开户名：</label>
					<input type="text" name="accountName" size="25" value="${merch.accountName }" maxlength="30" class="required" data-rule="required"/>
				</p>
				<p>
					<label class="control-label x90">开户账号：</label>
					<input type="text" name="accountNo" size="25" value="${merch.accountNo }" maxlength="30" class="required" data-rule="required"/>
				</p>
				<p>
					<label class="control-label x90">开户行：</label>
					<input type="text" name="accountBank" size="25" value="${merch.accountBank }" maxlength="30" class="required" data-rule="required"/>
				</p>
				<p>
					<label class="control-label x90">商户地址：</label>
					<input type="text" name="merchAddr" size="25" value="${merch.merchAddr }" maxlength="30" class="required" data-rule="required"/>
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