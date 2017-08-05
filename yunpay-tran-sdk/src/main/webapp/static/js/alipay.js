// 存放主要交互逻辑的js代码
// javascript 模块化(package.类.方法)
var Alipay = {
	init :function() {
		//默认获取输入框焦点时 弹出键盘 按钮是灰色 禁用状态
		var consMoney = $(".ali_txt");
		var keypadDiv = $(".ftc_wzsf");
		var aBtn = $("a.ljzf_but");
		var payNow = $("#payNow");
		var reg = new RegExp("^[0-9]+(.[0-9]{0,2})?$","gi");
		//金额光标定位
		consMoney.focus();
		//显示数字面板
		keypadDiv.show();
		//弹出数字输入面板
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
				aBtn.css({"background":"#0ae"});
				consMoney.val(totalMoney); //设置值到输入框 
				if (handleFlag && totalMoney >= 0.01) {
					Alipay.handlerPay(totalMoney); 
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
	
	handlerPay:function(totalMoney) {
		//先判断金额 是否禁用按钮 与按钮颜色  
		if (Alipay.strIsNull(totalMoney) && totalMoney > 0) {
			$('#payNow').one('click', function () { 
				//禁止按钮
				$(this).css({"background":"#888"});
				$('#alipayForm').submit();
			});
		} 
	}
};
