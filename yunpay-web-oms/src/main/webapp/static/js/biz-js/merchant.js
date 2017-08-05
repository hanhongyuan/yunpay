/**
 * 商户管理的业务js
 */

var allUrl = "/yunpay-web-oms/";
/**
 * 根据省份获取市信息
 */
function getCity(id){
	var value = $(id).val();
	if(value == ''){
		$("#city").html("<option value=''>请选择市</option>");
		$("#area").html("<option value=''>请选择区</option>");
		return;
	}else{
		$.ajax({
		    url:allUrl+'sys/merchant/getCity?id='+value,
		    type:'POST', //GET
		    async:true,  
		    timeout:5000,   
		    dataType:'json',   
		    beforeSend:function(xhr){},
		    success:function(data,textStatus,jqXHR){
		    	$("#city").html("");
		    	for(var id in data){
		    		$("#city")
		    		.append("<option value='"+id+"'>"+data[id]+"</option>"); 
		    	}
		    	// 选择市时自动查询出下面的区信息
		    	getArea($("#city"));
		    },
		    error:function(xhr,textStatus){
		    },
		    complete:function(){
		    }
		});
	}
}


/**
 * 根据市获取区信息
 */
function getArea(id){
		var value = $(id).val();
		$.ajax({
		    url:allUrl+'sys/merchant/getArea?id='+value,
		    type:'POST',
		    async:false,  
		    timeout:5000,   
		    dataType:'json',   
		    beforeSend:function(xhr){},
		    success:function(data,textStatus,jqXHR){
		    	$("#area").html("");
		    	for(var id in data){
		    		$("#area")
		    		.append("<option value='"+id+"'>"+data[id]+"</option>"); 
		    	}
		    },
		    error:function(xhr,textStatus){
		    },
		    complete:function(){
		    }
		});
}


/**
 * 生成支付配置的公钥、私钥
 * merchantNo:商户号
 * type : 0-支付 1-卡券
 */
function generateKey(merchantNo,type){
	$("#appPublicKey").val("");
	$("#appPrivateKey").val("");
	$.ajax({
	    url:allUrl+'sys/merchant/alipay/generateKey',
	    type:'POST',
	    async:false,  
	    timeout:5000,   
	    data:{
	    	"merchantNo":merchantNo,
	    	"type":type
	    },
	    dataType:'json',   
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	var publicKey = data.publicKey;
	    	var privateKey = data.privateKey;
	    	$("#appPublicKey").val(publicKey);
	    	$("#appPrivateKey").val(privateKey);
	    },
	    error:function(xhr,textStatus){
	    	alert(textStatus);
	    },
	    complete:function(){
	    }
	});
}

//导出交易流水
function outExcel(obj){
	$("#"+obj).submit();
}
