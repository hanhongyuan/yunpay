<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>接口测试</title>
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="static/bootstrap/css/bootstrapValidator.min.css">
<script src="static/bootstrap/js/jquery-1.11.2.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/bootstrap/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="http://cdn.staticfile.org/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<style>
	.icp{
		position: fixed; /*or前面的是absolute就可以用*/  
      		bottom: 10px;  
      		left:50%;
	}
</style>
<script>
$(document).ready(function() {
	$("#card_type").change(function(){
		var selectVal = $(this).val();
	    $("div[id^='TAG']").attr("class","form-group hidden");  
		$("#TAG_"+selectVal).attr("class","form-group");
	});
	$("#card_date_type").change(function(){
		var selectVal = $(this).val();
	    $("div[id^='DATE_TYPE']").attr("class","form-group hidden");  
		$("#"+selectVal).attr("class","form-group");
	});
	
	
	$("#logoresult").hide();
	$("#cardresult").hide();
	
	/*******************条码支付测试提交**********************/
    $('#logoform').bootstrapValidator({
	    message: '输入的信息未通过有效验证',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	        
	    }
	}).on('success.form.bv', function(e) {
	    // Prevent form submission
	    e.preventDefault();
	    // Get the form instance
	    var $form = $(e.target);
	    // Get the BootstrapValidator instance
	    var bv = $form.data('bootstrapValidator');
	    // Use Ajax to submit form data
	    $.post($form.attr('action'), $form.serialize(), function(result) {
	       	if(result.result_code=="SUCCESS"){
	       		//alert("支付成功|"+JSON.stringify(result.data));
	       		$("#logoresult").text("成功|"+JSON.stringify(result.data));
	       		$("#logoresult").attr("class","alert-success");
	       		
	       	}else{
	       		$("#logoresult").text("错误码："+result.err_code+"错误原因"+result.err_code_des);
	       		$("#logoresult").attr("class","alert-danger");
	       	}
	       	$("#logoresult").show();
	    }, 'json');
	});
	
    /*******************扫码支付测试提交**********************/
    $('#cardform').bootstrapValidator({
       message: '输入的信息未通过有效验证',
       feedbackIcons: {
           valid: 'glyphicon glyphicon-ok',
           invalid: 'glyphicon glyphicon-remove',
           validating: 'glyphicon glyphicon-refresh'
       },
       fields: {
           
       }
   }).on('success.form.bv', function(e) {
       // Prevent form submission
       e.preventDefault();
       // Get the form instance
       var $form = $(e.target);
       // Get the BootstrapValidator instance
       var bv = $form.data('bootstrapValidator');
       // Use Ajax to submit form data
       $.post($form.attr('action'), $form.serialize(), function(result) {
          	if(result.result_code=="SUCCESS"){
          		$("#cardresult").text("成功|"+JSON.stringify(result.data));
          		$("#cardresult").attr("class","alert-success");
          	}else{
          		$("#cardresult").text("错误码："+result.err_code+"错误原因"+result.err_code_des);
          		$("#cardresult").attr("class","alert-danger");
          	}
          	$("#cardresult").show();
       }, 'json');
   });
});
</script>
</head>
<body>

<div class="container">
  <h2>接口测试</h2>
  <ul class="nav nav-tabs">
    <li><a data-toggle="tab" href="#upload_cardlog">卡券logo</a></li>
    <li class="active"><a data-toggle="tab" href="#create_card">添加卡券</a></li>
  </ul>

  <div class="tab-content">
    <div id="upload_cardlog" class="tab-pane fade">
    	<br>
    	<div class="panel panel-default">
			<div class="panel-body">
				<form  id="logoform" class="form-horizontal"  role="form" action="card/upload/logo">
					<div class="form-group">
	                    <label class="col-lg-3 control-label">商户号*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="merchant_num" name="merchant_num" value="999910031001993593" data-bv-notempty data-bv-notempty-message="商户号"/>
	                        <input type="hidden" name="sign" value="1" />
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-3 control-label">卡券logo*</label>
	                    <div class="col-lg-5">
	                        
	                    </div>
	                </div>
			        <div class="form-group">
	                    <div class="col-lg-9 col-lg-offset-3">
	                        <button type="submit" class="btn btn-success">提交</button>
	                    </div>
	                </div>
	                <div id="logoresult" class="alert alert-success" ></div>
			    </form>
			</div>
		</div>
    </div>
    <div id="create_card" class="tab-pane fade in active">
    	<br>
    	<div class="panel panel-default">
			<div class="panel-body">
				<form  id="cardform" class="form-horizontal"  role="form" action="card/create/card">
					<div class="form-group">
	                    <label class="col-lg-2 control-label">卡券类型</label>
	                    <div class="col-xs-6">
			            	<select class="form-control" name="card_type" id="card_type" data-bv-notempty data-bv-notempty-message="卡券类型">	
				       			<option value="GROUPON" selected="selected" >团购券</option>
				       			<option value="CASH">现金券</option>
				       			<option value="DISCOUNT">折扣券</option>
				       			<option value="GIFT">兑换券</option>
				       			<option value="GENERAL_COUPON">优惠券</option>
			             	</select>
		                </div>
	                </div>
					<div class="form-group">
	                    <label class="col-lg-2 control-label">卡券标题*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="title" name="title" value="" maxlength="10"
	                        placeholder="请输入卡券标题 ，如：1元现金券" data-bv-notempty data-bv-notempty-message="卡券标题"/>
	                    </div>
	                </div>
					<div class="form-group">
	                    <label class="col-lg-2 control-label">商户号*</label>
	                    <div class="col-lg-3">
	                        <input type="text" class="form-control" id="merchant_num" name="merchant_num" value="999910031001993593"
	                        placeholder="请输入商户号，如：999910031001993593" data-bv-notempty data-bv-notempty-message="商户号"/>
	                        <input type="hidden" name="sign" value="1" />
	                    </div>
	                    <label class="col-lg-1 control-label">商户名称*</label>
	                    <div class="col-lg-3">
	                        <input type="text" class="form-control" id="merchant_name" name="merchant_name" value="盈承信息" 
	                        maxlength="12"  data-bv-notempty data-bv-notempty-message="商户名称"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">卡券logo地址*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="login_url" name="login_url" value="http://mmbiz.qpic.cn/mmbiz_jpg/FVibS3ibBAISOneJBtFUMsRqENxGuLm2nvYpySoLnqQnsafbtrgVcYDFSBovVv8a0OiasmF3UoZ6hXrVgEqMZz0Zw/0" 
	                        data-bv-notempty data-bv-notempty-message="卡券logo"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">使用提醒*</label>
	                    <div class="col-lg-3">
	                        <input type="text" class="form-control" id="notice" name="notice" value="使用时向服务员出示此券" 
	                        data-bv-notempty data-bv-notempty-message="使用提醒"/>
	                    </div>
	                    <label class="col-lg-1 control-label">使用说明*</label>
	                    <div class="col-lg-3">
	                        <input type="text" class="form-control" id="description" name="description" value="不可与其他优惠同享" 
	                        data-bv-notempty data-bv-notempty-message="使用说明"/>
	                    </div>
	                </div>
	                 <div class="form-group">
	                    <label class="col-lg-2 control-label">卡券颜色*</label>
	                    <div class="col-lg-5">
	                    	<select class="form-control" name="color" id="color" data-bv-notempty data-bv-notempty-message="请选择颜色">	
				       			<option value="Color010" selected="selected" >Color010</option>
				       			<option value="Color020">Color020</option>
				       			<option value="Color030">Color030</option>
				       			<option value="Color040">Color040</option>
				       			<option value="Color050">Color050</option>
				       			<option value="Color060">Color060</option>
				       			<option value="Color070">Color070</option>
				       			<option value="Color080">Color080</option>
				       			<option value="Color081">Color081</option>
				       			<option value="Color082">Color082</option>
				       			<option value="Color090">Color090</option>
				       			<option value="Color100">Color100</option>
				       			<option value="Color101">Color101</option>
				       			<option value="Color102">Color102</option>
			             	</select>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">投放码类型*</label>
	                    <div class="col-lg-5">
	                    	<select class="form-control" name="code_type" id="code_type" data-bv-notempty data-bv-notempty-message="请选择投放码">	
				       			<option value="CODE_TYPE_BARCODE" selected="selected" >一维码</option>
				       			<option value="CODE_TYPE_QRCODE">二维码</option>
				       			<option value="CODE_TYPE_ONLY_BARCODE">一维码无Code</option>
				       			<option value="CODE_TYPE_ONLY_QRCODE">二维码无Code</option>
			             	</select>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">投放数量*</label>
	                    <div class="col-lg-5">
	                        <input type="number" class="form-control" id="quantity" name="quantity"  value="1000" data-bv-notempty data-bv-notempty-message="投放数量"/>       
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">卡券有效期类型*</label>
	                    <div class="col-xs-6">
			            	<select class="form-control" name="card_date_type" id="card_date_type" data-bv-notempty data-bv-notempty-message="卡券有效期类型">	
				       			<option value="DATE_TYPE_FIX_TERM" selected="selected" >按领用日期范围</option>
				       			<option value="DATE_TYPE_FIX_TIME_RANGE">按固定日期范围</option>
			             	</select>
		                </div>
	                </div>
	                 <div id="DATE_TYPE_FIX_TERM" class="form-group">
	                 	<label class="col-lg-2 control-label">领取后多少天开始生效*</label>
	                    <div class="col-lg-3">
	                        <input type="number" class="form-control" id="fixed_begin_term" name="fixed_begin_term"  value="0" data-bv-notempty data-bv-notempty-message="领取后多少天开始生效"/>       
	                    </div>
	                    <label class="col-lg-2 control-label">领取后多少天内有效*</label>
	                    <div class="col-lg-3">
	                        <input type="number" class="form-control" id="fixed_term" name="fixed_term"  value="60" data-bv-notempty data-bv-notempty-message="领取后多少天内有效"/>       
	                    </div>
	                </div>
	                <div id="DATE_TYPE_FIX_TIME_RANGE" class="form-group hidden">
	                    <label class="col-lg-2 control-label">有效时间起*</label>
	                    <div class="col-lg-3">
	                        <input type="text" class="form-control" id="begin_timestamp" name="begin_timestamp"  value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) %>" data-bv-notempty data-bv-notempty-message="有效时间起"/>       
	                    </div>
	                    <label class="col-lg-2 control-label">有效时间止*</label>
	                    <div class="col-lg-3">
	                        <input type="text" class="form-control" id="end_timestamp" name="end_timestamp"  value="" data-bv-notempty data-bv-notempty-message="有效时间止"/>       
	                    </div>
	                </div>
	                <!-- 团购券专属项 -->
	                <div id="TAG_GROUPON" class="form-group">
	                    <label class="col-lg-2 control-label">团购券详情*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="deal_detail" name="deal_detail"  value="测试团购券" data-bv-notempty data-bv-notempty-message="团购券详情"/>       
	                    </div>
	                </div>
	                <!-- 现金券专属项 -->
	                <div id="TAG_CASH" class="form-group hidden">
	                    <label class="col-lg-2 control-label">最低消费额(分)*</label>
	                    <div class="col-lg-3">
	                        <input type="number" class="form-control" id="least_cost" name="least_cost"  value="101" data-bv-notempty data-bv-notempty-message="抵用金额"/>       
	                    </div>
	                    <label class="col-lg-2 control-label">减免金额(分)*</label>
	                    <div class="col-lg-3">
	                        <input type="number" class="form-control" id="reduce_cost" name="reduce_cost"  value="100" data-bv-notempty data-bv-notempty-message="减免金额"/>       
	                    </div>
	                </div>
	                <!-- 折扣券专属项 -->
	                 <div id="TAG_DISCOUNT" class="form-group hidden">
	                    <label class="col-lg-2 control-label">折扣(30表示7折)*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="discount" name="discount"  value="30" data-bv-notempty data-bv-notempty-message="折扣"/>       
	                    </div>
	                </div>
	                <!-- 兑换券专属项 -->
	                <div id="TAG_GIFT" class="form-group hidden">
	                    <label class="col-lg-2 control-label">兑换券详情*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="gift" name="gift"  value="测试兑换券" data-bv-notempty data-bv-notempty-message="兑换券详情"/>       
	                    </div>
	                </div>
	                <!-- 优惠券专属项 -->
	                <div id="TAG_GENERAL_COUPON" class="form-group hidden">
	                    <label class="col-lg-2 control-label">优惠券详情*</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="default_detail" name="default_detail"  value="测试优惠券" data-bv-notempty data-bv-notempty-message="优惠券详情"/>       
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">客服电话</label>
	                    <div class="col-lg-5">
	                        <input type="text" class="form-control" id="service_phone" name="service_phone" placeholder="请输入客服电话，如：0755-2233445"  value="" />       
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">领取数量限制</label>
	                    <div class="col-lg-3">
	                        <input type="number" class="form-control" id="get_limit" name="get_limit"  value="5" />       
	                    </div>
	                    <label class="col-lg-2 control-label">核销数量限制</label>
	                    <div class="col-lg-3">
	                        <input type="number" class="form-control" id="use_limit" name="use_limit"  value="5" />       
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label class="col-lg-2 control-label">支持分享</label>
	                    <div class="col-lg-3 checkbox" >
	                        <label><input type="checkbox" id="can_share" 
	                        name="can_share"  value="1" checked/>支持请打勾 </label>  
	                    </div>
	                    <label class="col-lg-2 control-label">支持转赠</label>
	                    <div class="col-lg-3 checkbox">
	                        <label><input type="checkbox"  id="can_give_friend" 
	                        name="can_give_friend" value="1" checked/>支持请打勾</label>
	                    </div>
	                </div>
			        <div class="form-group">
	                    <div class="col-lg-9 col-lg-offset-3">
	                        <button type="submit" class="btn btn-success">提交</button>
	                    </div>
	                </div>
	                <div id="cardresult" class="alert alert-success" ></div>
			    </form>
			</div>
		</div>
    </div>
  </div>
</div>
<div class="icp">
	<a href="http://www.miitbeian.gov.cn/">粤ICP备17070748号</a>
</div>
</body>
</html>