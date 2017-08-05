<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var DictAdd = {
    // 删除后的回调函数，刷新当前页面
    navTabAjax: function(json) {
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
	<form method="post" data-toggle="validate" action="${baseURL}/sys/store/add" class="pageForm" data-callback="DictAdd.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<input type="hidden" name="navTabId" value="jsgl">
			<input type="hidden" name="callbackType" value="closeCurrent">
			<input type="hidden" name="forwardUrl" value="">
			
			<input type="hidden" id="store_add_merchId" name="MerchId" value="">
			
			<p>
				<label class="control-label x90">门店名称：</label>
				<input type="text" name="storeName" value="${storeName }" data-rule="required" /> 
                <span class="required" style = "color:red;font-size:15px"><b>*</b></span>
			</p>
			<p>
				<label class="control-label x90">所属商户：</label>
				<input type="text" id="store_add_nameShort" name="nameShort" data-title="查找带回" value="${nameShort }" readonly data-toggle="lookup" data-url="${baseURL }/sys/store/lookupmerchId" data-width="850" data-height="600" data-title="查找带回"/> 
				<span class="required" style = "color:red; font-size:15px"><b>*</b></span>
			</p> 
			
			<p>
				<label class="control-label x90">省&市：</label>
				<select name="provice" class="combox" id="store_add_provice" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#store_add_select_region" data-refurl="${baseURL}/sys/store/findregion?code={value}" data-rule="required" >
                        <option value="" selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${ProviceList }" varStatus="st">
                            <option id="op_store_add_provice" value="${item.code }">${item.name }</option>
                        </c:forEach>
                </select>
                <select name="region" class="combox" id="store_add_select_region" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#store_add_select_area" data-refurl="${baseURL}/sys/store/findarea?code={value}" data-rule="required" >
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${RegionList }" varStatus="st">
                            <option value="${item.code }" >${item.name }</option>
                        </c:forEach>
                </select>
                <span class="required" style = "color:red;font-size:15px"><b>*</b></span>
			</p>
			
			<p>
                <label class="control-label x90">区域&商圈：</label>
                <select name="area" class="combox" id="store_add_select_area" data-toggle="selectpicker" data-emptytxt="--请选择--" data-nextselect="#store_add_select_areaid" data-refurl="${baseURL}/sys/store/findareaid?code={value}">
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${AreaList }" varStatus="st">
                            <option value="${item.code }">${item.name }</option>
                        </c:forEach>
                </select>
                <select name="areaId" class="combox" id="store_add_select_areaid" data-toggle="selectpicker" data-emptytxt="--请选择--" >
                        <option value=""  selected = 'selected'>--请选择--</option>
                        <c:forEach var="item" items="${AreaIdList }" varStatus="st">
                            <option value="${item.code }">${item.name }</option>
                        </c:forEach>
                </select>
            </p>
            <p>
                <label class="control-label x90">联系人：</label>
                <input type="text" name="contractName" value="${contractName}" data-rule="required"  /> 
                <span class="required" style = "color:red;font-size:15px"><b>*</b></span>
            </p>
            <p>
                <label class="control-label x90">联系电话：</label>
                <input type="text" name="contactPhone" value="${contactPhone}" data-rule="mobile"  /> 
                <span class="required" style = "color:red;font-size:15px"><b>*</b></span>
            </p>
            <p>
                <label class="control-label x90">门店地址：</label>
                <input type="text" name="address" value="${address}" data-rule="required" /> 
                <span class="required" style = "color:red;font-size:15px"><b>*</b></span>
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