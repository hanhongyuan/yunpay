<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var DictEdit = {
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
	<form method="post" action="${baseURL}/sys/store/edit" class="pageForm" data-toggle="validate" data-callback="DictEdit.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="storeNo" value="${StoreInfo.storeNo }">

			<p>
				<label class="control-label x90">归属商户：</label>
				<input name="nameShort" value="${StoreInfo.nameShort }" readonly />
			</p>
			<p>
                <label class="control-label x90">门店名称：</label>
                <input name="storeName" value="${StoreInfo.storeName }" data-rule="required" />
            </p>
            <p>
                <label class="control-label x90">省&市：</label>
                <select name="provice" class="combox" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#store_add_select_region" data-refurl="${baseURL}/sys/store/findregion?code={value}">
                        <option value="" selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${ProviceList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${StoreInfo.provice eq item.name }">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
                <select name="region" class="combox" id="store_add_select_region" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#store_add_select_area" data-refurl="${baseURL}/sys/store/findarea?code={value}">
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${RegionList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${StoreInfo.region eq item.name }">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
            </p>
            <p>
                <label class="control-label x90">区域&商圈：</label>
                <select name="area" class="combox" id="store_add_select_area" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#store_add_select_areaid" data-refurl="${baseURL}/sys/store/findareaid?code={value}">
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${AreaList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${StoreInfo.area eq item.name }">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
                <select name="areaId" class="combox" id="store_add_select_areaid" data-toggle="selectpicker" data-emptytxt="--请选择--" >
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${AreaIdList }" varStatus="st">
                            <option value="${item.code }" <c:if test="${StoreInfo.areaId eq item.name }">selected = 'selected'</c:if> >${item.name }</option>
                        </c:forEach>
                </select>
            </p>
			<p>
				<label class="control-label x90">联系人：</label>
				<input name="contractName" value="${StoreInfo.contractName }" />
			</p>
			<p>
                <label class="control-label x90">联系电话：</label>
                <input name="contactPhone" value="${StoreInfo.contactPhone }" />
            </p>
            <p>
                <label class="control-label x90">门店地址：</label>
                <textarea name="address">${StoreInfo.address }</textarea>
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
