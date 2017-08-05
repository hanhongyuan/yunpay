// 存放主要交互逻辑的js代码
// javascript 模块化(package.类.方法)
var Wechat = {
	init :function( param) {
		//默认获取输入框焦点时 弹出键盘 按钮是灰色 禁用状态
		var consMoney = $(".w_txt");
		var keypadDiv = $(".ftc_wzsf");
		var aBtn = $("a.ljzf_but");
		var payNow = $("#payNow");
		var reg = new RegExp("^[0-9]+(.[0-9]{0,2})?$","gi");
		consMoney.focus();
		keypadDiv.show();
		consMoney.focus(function() {
			keypadDiv.show();
		});
		//设置关闭事件
		$(".close").click(function(){
			keypadDiv.hide();
		});
		// 1 获取点击数据 的值  2设置立即支付按钮为亮色  2赋值 给输入金额框 最大位数限制
		aBtn.css({"background":"#888"});
		var handleFlag = true;
		var queryArrs = new Array();
		var totalMoney = 0;
		$(".nub_ggg li a").click(function( value){
			var queryValue = $(this).text(); 
			queryArrs.push(queryValue);
			totalMoney = queryArrs.join("");
			var validRes = totalMoney.match(reg);
			if(validRes){
				aBtn.css({"background":"#44bf16"});
				consMoney.val(totalMoney); //设置值到输入框 
				if (handleFlag && totalMoney >= 0.01) {
					Wechat.handlerPay(param,totalMoney); 
					handleFlag = false;
				} 
			    return;
			}else{
				queryArrs.pop();
				alert("请输入有效的支付金额!");
				return;
			} 
		});
		
		$(".nub_ggg li .del").click(function(){
			if(queryArrs.length>0){
				//删除 
				//queryArrs.splice( queryArrs.length-1,1); 
				queryArrs.pop();
				totalMoney = queryArrs.join("");
				consMoney.val(totalMoney);
			}
			if(queryArrs.length==0){
				aBtn.css({"background":"#888"});
		    	payNow.unbind(); //移除所有 
		    	handleFlag = true;
			}
			 
		});
	},
	strIsNull:function( arg1){ //在js中if条件为null/undefined/0/NaN/""表达式时，统统被解释为false,此外均为true .为空判断函数
		return !arg1 && arg1!==0 && typeof arg1!=="boolean"?false:true;
	},
	onBrideReady:function(result) {
		WeixinJSBridge.invoke(
	       'getBrandWCPayRequest', {
		   "appId" : result.data.appId ,     //公众号名称，由商户传入     
		   "timeStamp": result.data.timeStamp ,         //时间戳，自1970年以来的秒数     
		   "nonceStr": result.data.nonceStr, //随机串     
		   "package" : result.data.packages ,     
		   "signType": result.data.signType ,   //微信签名方式  
		   "paySign": result.data.paySign      //微信签名 
		   },
		   function(res){  
		       if(res.err_msg == "get_brand_wcpay_request:ok" ) {// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。 
		    	   	//console.info("微信支付成功!");
		    	   	WeixinJSBridge.call("closeWindow");
				}else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
					//console.info("用户取消支付!");  
					WeixinJSBridge.call("closeWindow");
				}else{  
					//console.info("支付失败!"); 
					WeixinJSBridge.call("closeWindow");
				}     
		   }
		); 		
	},
	handlerPay:function( datas, totalMoney) {
		//先判断金额 是否禁用按钮 与按钮颜色  
		if (Wechat.strIsNull(totalMoney) && totalMoney > 0) {
			$('#payNow').one('click', function () { 
				var queryArrs = new Array();
				var queryValue = $(".w_txt").val(); 
				queryArrs.push(queryValue);
				totalMoney = queryArrs.join("");   
				//禁止按钮
				$(this).css({"background":"#888"});
				//发送请求
				reqDatas = {auth_code:""+datas.code+"",merchant_num:""+datas.merchant_num+"",total_fee:""+totalMoney+""};
				$.post(datas.url, reqDatas, 
					function (result) {
						if (Wechat.strIsNull(result)){
							if(result.result_code=="SUCCESS"){
								//在回调函数种执行交互流程
				     			if (typeof WeixinJSBridge == "undefined"){
				     			   if( document.addEventListener ){
				     			       document.addEventListener('WeixinJSBridgeReady', function( result) {Wechat.onBrideReady(result);}, false);
				     			   }else if (document.attachEvent){
				     			       document.attachEvent('WeixinJSBridgeReady', function( result) {Wechat.onBrideReady(result);}); 
				     			       document.attachEvent('onWeixinJSBridgeReady', function( result) {Wechat.onBrideReady(result);});
				     			   }
				     			}else{
				     				Wechat.onBrideReady( result);
				     			} 
							}
							else{
								alert(result.err_code_des);
							}
						}
			    	}
			    );
			});
		} 
	}
};
