var COOKIE_NAME = 'sys__username';
$(function() {
    //choose_bg();
	//changeCode();
	if ($.cookie(COOKIE_NAME)){
	    $("#j_username").val($.cookie(COOKIE_NAME));
	    $("#j_password").focus();
	    $("#j_remember").attr('checked', true);
	} else {
		$("#j_username").focus();
	}
	 $("#captcha_img").click(function(){
		changeCode();
	}); 
	$("#login_form").submit(function(){
		var issubmit = true;
		var i_index  = 0;
		$(this).find('.in').each(function(i){
			if ($.trim($(this).val()).length == 0) {
				$(this).css('border', '1px #ff0000 solid');
				issubmit = false;
				if (i_index == 0)
					i_index  = i;
			}
		});
		if (!issubmit) {
			$(this).find('.in').eq(i_index).focus();
			return false;
		}
		var $remember = $("#j_remember");
		if ($remember.attr('checked')) {
			$.cookie(COOKIE_NAME, $("#j_username").val(), { path: '/', expires: 15 });
		} else {
			$.cookie(COOKIE_NAME, null, { path: '/' });  //删除cookie
		}
		$("#login_ok").attr("disabled", true).val('登陆中..');
		var password = HMAC_SHA256_MAC($("#j_username").val(), $("#j_password").val());
		$("#j_password").val(HMAC_SHA256_MAC($("#j_randomKey").val(), password));
        return false;
	});
});
function genTimestamp(){
	var time = new Date();
	return time.getTime();
}
function changeCode(){
	//$("#captcha_img").attr("src", "/captcha.jpeg?t="+genTimestamp());
	var basePath = $("#basePath").val();
	$("#captcha_img").attr("src",basePath+'/rcCaptcha.jpg?'+ new Date().getTime());
		 
}
function choose_bg() {
	var bg = Math.floor(Math.random() * 9 + 1);
	//$('body').css('background-image', 'url(images/loginbg_0'+ bg +'.jpg)');
}

/**
 * 
 */


$(function(){
	$('#j_username').focus();
	$('#j_password').val('');
	$('#j_captcha').val('');
	$('.loginForm input').each(function(){
		input_inf($(this));
		$(this).focus(function(){
			input_inf($(this));
			$(this).parent().addClass('active');
		});
		$(this).blur(function(){
			input_inf($(this));
			$(this).parent().removeClass('active');
		});
		$(this).bind('input propertychange',function(){
			$(this).next().remove();
			input_inf($(this));
		});
	});
	var errorid ="";
	var errormsg ="" ;
	if(errorid)
	{
		$('#'+errorid).parent().append('<div class="login_error"><div class="login_error_msg">'+errormsg+'</div><div class="login_error_b"></div></div>');
	}
});
function input_inf(obj)
{
	if(obj.val() == '')
		obj.prev().show();
	else
		obj.prev().hide();
}
function form_sub(){
	var obj = document.getElementById('login-form');
	if(EncryptPwd(obj))
		obj.submit();
	else
		return;
}
function EncryptPwd(form) {
	if(!$('#j_username').val())
	{
		$('#j_username').next().remove();
		$('#j_username').parent().append('<div class="login_error"><div class="login_error_msg">请输入用户名！</div><div class="login_error_b"></div></div>');
		$('#j_username').focus();
		return false;
	}
	if(!$('#j_password').val())
	{
		$('#j_password').next().remove();
		$('#j_password').parent().append('<div class="login_error"><div class="login_error_msg">请输入用户密码！</div><div class="login_error_b"></div></div>');
		$('#j_password').focus();
		return false;
	}
	if(!$('#j_captcha').val())
	{
		$('#j_captcha').next().remove();
		$('#j_captcha').parent().append('<div class="login_error"><div class="login_error_msg">请输入验证码！</div><div class="login_error_b"></div></div>');
		$('#j_captcha').focus();
		return false;
	}
	$("#login-form-password").val(hex_md5(hex_md5($('#j_password').val())));
	return true;
}