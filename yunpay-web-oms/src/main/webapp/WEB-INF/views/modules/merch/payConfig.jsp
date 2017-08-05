<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
	<ul class="nav nav-tabs" id="payConfig_tab">
		<li class="active"><a href="#Wechat" data-toggle="tab">微信配置</a></li>
		<li><a href="#alipay" data-toggle="tab">支付宝配置</a></li>
	</ul>
	<div id="payConfig_tabContent" class="tab-content" style="width: 650;">
		<div class="tab-pane fade in active" id="Wechat" style="height: 320px;">  <!--  data-callback="MenuAdd.navTabAjax" -->
			<form method="post" id="Wechat_form" method="post" action="${baseURL}/sys/merchant/savePayConfig?serialNo=${wechatConfig.merchantNo}&confType=wechat" class="pageForm" data-toggle="validate" >
				<input type="hidden" name="id" value="${wechatConfig.id}">
				<div class="pageFormContent" layoutH="60">
					<p style="width: 99%"><label class="control-label x100">Appid：</label><input type="text" class="required" data-rule="required"  name="appId" value="${wechatConfig.appId}" />
						<span class="info"></span>
					</p>
					<p style="width: 99%"><label class="control-label x100">微信商户号:</label><input type="text" name="wxAppAppId" class="required"  maxlength="90" data-rule="required" value="${wechatConfig.wxAppAppId}" />
					</p>
					<p style="width: 99%">
						<label class="control-label x100">apiSecret：</label>
						<input type="text" name="apiSecret" id="" class="required" data-rule="required" maxlength="90" value="${wechatConfig.apiSecret}" />
					</p>
					<p style="width: 99%">
						<label class="control-label x100">appSecret：</label>
						<input type="text" name="appSecret" id=""  maxlength="90" class="required" data-rule="required" value="${wechatConfig.appSecret}" />
					</p>
					<p style="width: 99%">
						<label class="control-label x100">证书路径：</label><input type="text" name="certLocalPath" maxlength="50"  data-rule="required" class="required" value="${wechatConfig.certLocalPath}" />
					</p>
					<p style="width: 99%">
						<label class="control-label x100">证书密钥：</label><input type="text" name="certPassword" maxlength="50"  data-rule="required" class="required" value="${wechatConfig.certPassword}" />
					</p>
					<p align="center">
					<button type="submit" class="btn-default" data-icon="save">保存</button>
					<button type="button" class="btn-close" data-icon="close">取消</button>
					
					</p>
				</div>
				
			</form>
		</div>
		
		<div class="tab-pane fade" id="alipay" style="height: 320px;">
				<form method="post" id="alipay_form" method="post" action="${baseURL}/sys/merchant/savePayConfig?serialNo=${alipayConfig.merchantNo}&confType=alipay" class="pageForm" data-toggle="validate">
				<input type="hidden" name="id" value="${alipayConfig.id}">
				<div class="pageFormContent" layoutH="60">
					<p style="width: 99%">
						<label class="control-label x90">支付宝商户号：</label><input type="text" class="required" name="pid" data-rule="required" value="${alipayConfig.pid}" />
						<span class="info"></span>
					</p>
					<p style="width: 99%">
						<label class="control-label x90">门店应用appid:</label><input type="text" class="required" data-rule="required" name="storeAppId" class="required" maxlength="90" data-rule="required" value="${alipayConfig.storeAppId}" />
					</p>
					<p style="width: 99%">
						<label class="control-label x90">支付宝公钥：</label><input type="text" class="required" data-rule="required" id="alipayPublicKey" name="alipayPublicKey" class="required number" data-rule="required" maxlength="20" value="${alipayConfig.alipayPublicKey}" />
					</p>
					<p style="width: 99%">
						<label class="control-label x90">商户公钥：</label><textarea rows="3" class="required"  data-rule="required" id="appPublicKey" cols="60" name="appPublicKey"  class="required" data-rule="required" >${alipayConfig.appPublicKey}</textarea>
					</p>
					<p style="width: 99%">
						<label class="control-label x90">商户私钥：</label><textarea rows="3" class="required" data-rule="required" id="appPrivateKey" cols="60" name="appPrivateKey"  class="required" data-rule="required">${alipayConfig.appPrivateKey}</textarea>
					</p>
					
					<p align="center">
		    		
		    		
		    			<button type="submit" class="btn-default" data-icon="save">保存</button>
		    				<input type="button" class="btn-default" onclick="generateKey(${alipayConfig.merchantNo},0)" value="商户公私钥生成">
		    					<button type="button" class="btn-close" data-icon="close">取消</button>
		    		</p>
				</div>
				
			</form>
		</div>
	</div>
</div>