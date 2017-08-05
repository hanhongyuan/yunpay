<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<jsp:include page="../../../common/taglib/taglib.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="${baseURL }/static/BJUI/js/jquery-1.7.2.min.js"></script>
<script src="${baseURL }/static/BJUI/js/jquery-1.js"></script>
<script src="${baseURL }/static/BJUI/js/jquery.cookie.js"></script>
<script src="${baseURL }/static/BJUI/plugins/bootstrap.min.js"></script>
<link href="${baseURL }/static/BJUI/themes/css/bootstrap.min.css" rel="stylesheet" />
<script src="${baseURL }/static/js/login/login.js"></script>
<link href="${baseURL }/static/js/login/login.css" rel="stylesheet" />

<script type="text/javascript">
$(function(){
    var status = window.userLoginStauts;
    if (status != undefined){
        location.reload();
    }
});

//清除提示信息
function removeTitle(obj){
    $(obj).parent().find(".login_error").empty();
}

var liLen = 0;
$(function(){           
    liLen =  $("#login_content ul.adv_banner li").length;
    Time = setInterval("test()",3000);
    $(".listItem a").click(function(){
        var index = $(this).index();
        clearInterval(Time);
        $("#login_content ul.adv_banner li").eq(i).fadeOut(1000);
        $("#login_content ul.adv_banner li").eq(index).fadeIn(1000);
        i=index;
        $(".listItem a").eq(i).siblings().removeClass("selectedItem");
        $(".listItem a").eq(i).addClass("selectedItem");            
        Time = setInterval("test()",3000);
    });
});

var i = 0;  
function test(){
    var liObj = $("#login_content ul.adv_banner li");
    $(liObj[i]).fadeOut(1000);
    $(liObj[i+1]).fadeIn(1000);
    $(".listItem a").eq(i+1).siblings().removeClass("selectedItem");
    $(".listItem a").eq(i+1).addClass("selectedItem");

    i++;
    if(i == liLen -1){
        $(liObj[0]).fadeIn(1000);   
        $(".listItem a").eq(0).siblings().removeClass("selectedItem");
        $(".listItem a").eq(0).addClass("selectedItem");            
        i = 0;
    }       
}

</script>
</head>
<body>
    <!--[if lte IE 7]>
<style type="text/css">
#errorie {position: fixed; top: 0; z-index: 100000; height: 30px; background: #FCF8E3;}
#errorie div {width: 900px; margin: 0 auto; line-height: 30px; color: orange; font-size: 14px; text-align: center;}
#errorie div a {color: #459f79;font-size: 14px;}
#errorie div a:hover {text-decoration: underline;}
</style>
<div id="errorie">
    <div>您还在使用老掉牙的IE，请升级您的浏览器到 IE8以上版本 
        <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/ie-8-worldwide-languages">点击升级</a>&nbsp;&nbsp;强烈建议您更改换浏览器：<a href="http://down.tech.sina.com.cn/content/40975.html" target="_blank">谷歌 Chrome</a></div></div>
<![endif]-->
    <div id="login">
        <div id="login_header">
                <a href="http://www.siecom.cn/" target="_blank">
                <img src="${baseURL}/static/images/logo2.png" /></a>
                <span style="color: #000000; font-family: 宋体; font-size: 30px; position: absolute; margin-top: 30px;">至高通信管理平台</span>
        </div>
        
        <div id="login_content">
            <ul class="adv_banner">
                <li style="z-index: 30; display: none;">
                    <a href="javascript:void(0)" class="banner2"></a>
                </li>
                <li style="z-index: 20; display: list-item;">
                    <a href="javascript:void(0)" class="banner3"></a>
                </li>
                <li style="z-index: 10; display: none;">
                    <a href="javascript:void(0)" class="banner1"></a>
                </li>
                <li style="z-index:5;">
                    <a href="javascript:void(0)"><img style="background-color: white;"/> </a>
                </li>               
            </ul>
            <div class="listItem">
                <a href="javascript:void(0)" class=""></a>
                <a href="javascript:void(0)" class="selectedItem"></a>
                <a href="javascript:void(0)" class=""></a>
            </div>

            <div class="login_banner">
                <div class="loginForm">
                    <input type="hidden" value="${baseURL}" id="basePath" />
                    <form action="${baseURL}/login" method="post" id="login-form"  onsubmit="return EncryptPwd(this)">
                        <h2>登录入口</h2>
                        <div class="${empty message ? 'hide' : ''}">
	                        <button data-dismiss="alert" class="close">×</button>
	                        <div align="center" style="width: 227px;padding-top: 15px;"><font id="err_msg" color="#FF0000">${message}</font></div>
	                    </div>
                        <p class="">
                            <span id="input_userid"></span>
                            <label for="j_username">请输入用户名</label>
                            <input maxlength="20" id="j_username" name="loginName" onclick="removeTitle(this);" type="text" value="admin"/>
                        </p>
                        <p>
                            <span id="input_pwd"></span>
                            <label for="j_password">请输入密码</label>
                            <input class="login_input" id="j_password" name="passWd" onclick="removeTitle(this);" type="password" value="123456"/>
                        </p>
                        <c:if test="${captchaEbabled}">
                            <div id="p_img_noborder">
	                            <p id="p_imgcode">
	                                <label for="j_captcha">验证码</label>
	                                <input maxlength="4" width="115" class="code" id="j_captcha" name="captchaCode" onclick="removeTitle(this);" type="text"/>
	                             </p>
	                             <img id="captcha_img" alt="点击更换验证码" title="点击更换验证码" src="${baseURL}/rcCaptcha.jpg"  class="m" height="38" width="115"/>
	                            <!-- <img id="captcha_img" src="${baseURL }/rcCaptcha.jpg" alt="点击切换" height="38" width="115" /> -->
	                        </div>
                        </c:if>                        
                        	<div><button id="login_button" type="submit" ></button></div>
                    </form>
                </div>
            </div>
        </div>
        
        <div id="login_footer">
            <span>Copyright &copy; 2012 Siecom.All Right Reserved.</span>
            <span>
                <a href="http://www.siecom.cn/" target="_blank">深圳市至高通信技术发展有限公司</a> 
            </span>
            <span><img src="${baseURL}/static/images/telephone.png"/>服务电话:400-100-8282</span>
        </div>
    </div>  
</body>
</html>