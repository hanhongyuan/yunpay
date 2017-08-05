<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var UpgradePlanEdit = {
	    // 删除后的回调函数，刷新当前页面
	    navTabAjax: function(json) {
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

<div class="tableContent">
    <form method="post" action="${baseURL}/sys/upgradePlan/edit" class="pageForm" data-toggle="validate" data-callback="UpgradePlanEdit.navTabAjax">
        <fieldset style="height:100%;">
            <legend>计划信息</legend>
                <input type="hidden" name="planId" value="${UpgradePlan.planId}" />
                <input type="hidden" name="planStatus" value="${UpgradePlan.planStatus}" />
                
		        <table>
					<tr>
						<td><label class="control-label x120">计划名称：</label></td>
						<td><input type="text" name="planName" class="required" value="${UpgradePlan.planName }" data-rule="required" ></td>
					</tr>
					<tr>
						<td><label class="control-label x120">版本号：</label></td>
						<td>
						    <select name="verId" class="combox" class="required" data-rule="required">
                                <option value=""  selected = 'selected'>--请选择--</option>
                                
                                <c:forEach var="i" items="${verInfo }" varStatus="st">
                                    <option value="${i.code }" <c:if test="${UpgradePlan.verId eq i.code }">selected = 'selected'</c:if> >${i.name}</option>
                                </c:forEach>
                            </select>
						</td>
					</tr>
					<tr>
						<td><label class="control-label x120">开始时间：</label></td>
						<td><input type="text" name="beginDate" value="${UpgradePlan.beginDate }" data-toggle="datepicker" readonly style="width:176px;" class="required" data-rule="required" ></td>
					</tr>
					<tr>
						<td><label class="control-label x120">备注：</label></td>
						<td><input type="text" name="planRemark" value="${UpgradePlan.planRemark }" ></td>
					</tr>
				</table>
		</fieldset>
		<fieldset style="height:100%;">
            <legend><button type="button" data-maxable="false" data-title="查找带回" data-toggle="lookupbtn" data-url="${baseURL }/sys/upgradePlan/lookup" data-width="900" data-height="610" class="btn-default">计划详情</button></legend>
            <p>
                <label class="control-label x120">详细信息：</label>
                <textarea name="infoMsg" rows="4" cols="50">${infoMsg }</textarea>
            </p>
        </fieldset>
        
        <div class="bjui-pageFooter">
            <ul>
                <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
                <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
            </ul>
        </div>
    </form>
</div>