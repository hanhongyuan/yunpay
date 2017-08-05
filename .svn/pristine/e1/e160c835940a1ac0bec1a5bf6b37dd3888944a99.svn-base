/**
 * 省市区三级联动js
 */


var allUrl = "/yunpay-web-oms/";
/**
 * 根据省份获取市信息
 */
function getCity(id){
	var value = $(id).val();
	$.ajax({
	    url:allUrl+'sys/store/getCity?id='+value,
	    type:'POST', //GET
	    async:true,  
	    timeout:5000,   
	    dataType:'json',   
	    beforeSend:function(xhr){},
	    success:function(data,textStatus,jqXHR){
	    	$("#cityName").html("");
	    	for(var id in data){
	    		$("#cityName")
	    		.append("<option value='"+id+"'>"+data[id]+"</option>"); 
	    	}
	    	// 选择市时自动查询出下面的区信息
	    	getArea($("#cityName"));
	    },
	    error:function(xhr,textStatus){
	    },
	    complete:function(){
	    }
	});
}


/**
 * 根据市获取区信息
 */
function getArea(id){
		var value = $(id).val();
		$.ajax({
		    url:allUrl+'sys/store/getArea?id='+value,
		    type:'POST',
		    async:false,  
		    timeout:5000,   
		    dataType:'json',   
		    beforeSend:function(xhr){},
		    success:function(data,textStatus,jqXHR){
		    	$("#areaName").html("");
		    	for(var id in data){
		    		$("#areaName")
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

//删除后的回调函数，刷新树形菜单
function navTabAjax(json) {
	 $(selector).bjuiajax('refreshLayout', ture);
}
$(document).on('bjui.beforeLoadDialog', function(e) {
    var $dialog = $(e.target);
})

 */



