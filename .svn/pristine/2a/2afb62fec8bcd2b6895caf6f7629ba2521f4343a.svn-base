<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<form  action="" class="pageForm" >
		<div class="pageFormContent">
			<p>
				<label class="control-label x120">卡券颜色：</label>
				<input type="color" name="cardColor"  value="${card.cardColor}"  width="300px"	height="50px"	readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">卡券标题：</label>
				<input type="text" name="title"  value="${card.title}"  size="30"	readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">有效期：</label>
				<input type="text" name="startDate"  value="<fmt:formatDate value="${card.startDate}" pattern="yyyy-MM-dd"/>"  size="14" readonly="readonly"/>
				--
				<input type="text" name="endDate"    value="<fmt:formatDate value="${card.endDate}" pattern="yyyy-MM-dd"/>"  size="14" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">领取限制：</label>
				<input type="text" name="limitNum"    value="${card.limitNum}"  size="12" readonly="readonly"/>
				<label >数 量：</label>
				<input type="text" name="inventory"     value="${card.inventory}"  size="13" readonly="readonly"/>
			</p>			
			<p>
				<label class="control-label x120">使用条件：</label>
				<c:if test="${card.useCondition == 0}">
				<input type="text" name="useCondition"     value="不与其他优惠券同享"  size="30" readonly="readonly"/>
				</c:if>
				<c:if test="${card.useCondition == 1}">
				<input type="text" name="useCondition"     value="与其他优惠券同享"  size="30" readonly="readonly"/>
				</c:if>				
			</p>
			<p>
				<label class="control-label x120">封面图片：</label>
				<input type="image" name="logo"  src="${card.logo}"  width="300px" height="80px" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">封面介绍：</label>
				<input type="text" name="subtitle"     value="${card.subtitle}" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">优惠说明：</label>
				<input type="text" name="detail"     value="${card.detail}" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">使用须知：</label>
				<input type="text" name="operation"     value="${card.operation}" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">商户电话：</label>
				<input type="text" name="tel"     value="${card.tel}" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">商户服务：</label>
				<input type="checkbox" name="wifi"         <c:if test="${card.wifi==0}">      checked="checked"</c:if> readonly="readonly"/>免费WIFI
				<input type="checkbox" name="parking"      <c:if test="${card.parking==0}">   checked="checked"</c:if> readonly="readonly"/>免费停车
				<input type="checkbox" name="acceptPet"    <c:if test="${card.acceptPet==0}"> checked="checked"</c:if> readonly="readonly"/>可带宠物
				<input type="checkbox" name="delivery"     <c:if test="${card.delivery==0}">  checked="checked"</c:if> readonly="readonly"/>可外卖
			</p>
			<p>
				<label class="control-label x120">操作提示：</label>
				<input type="text" name="notice"     value="${card.notice}" maxlength="30" size="30" readonly="readonly"/>
			</p>
			<p>
				<label class="control-label x120">卡券分享：</label>
				<input type="checkbox" name="share"  <c:if test="${card.share==1 ||card.share==3}"> checked="checked"</c:if> readonly="readonly"/>用户可以分享领券链接
				<input type="checkbox" name="share1" <c:if test="${card.share==2 ||card.share==3}"> checked="checked"</c:if> readonly="readonly"/>用户领券后可转赠其他好友
			</p>
		</div>	
		<div class="bjui-pageFooter"	align="center">
		    <ul >
		        <li><button type="button" class="btn-close" data-icon="close">确定</button></li>		        
		    </ul>
		</div>	
	</form>
</div>