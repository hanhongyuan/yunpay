$(function(){   
	$.ajax({
		type:"post", 
    	dataType: "text", 
	    url: rechargeTimeurl, 
	    contentType: "application/x-www-form-urlencoded; charset=utf-8",
	    success: function (result){ 
	    	var jsonobj = JSON.parse(result);
	    	var busiNameArray = new Array();
	        var tranNumArray = new Array();
	    	for(var i=0;i<jsonobj.length;i++){
	    		busiNameArray[i] = jsonobj[i].busiName;
		    	tranNumArray[i] = jsonobj[i].tranNum;
	    	}   
	        function fetchData(cb) {
	            // 通过 setTimeout 模拟异步加载
	            setTimeout(function () {
	                cb({
	                    categories:busiNameArray,
	                    data: tranNumArray
	                }); 
	            }, 1000);
	        } 
	    	
		    var chart = document.getElementById('recharge-time-pie');      
		    var echart = echarts.init(chart);
		    var option = {
		    	    tooltip : {
		    	        trigger: 'item',
		    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    	    }, 
		    	    legend: {
		    	        orient: 'vertical',
		    	        right: 'right',
		    	        data: []
		    	    },
		    	    series : [
		    	           {
		    	            name: '访问来源',
		    	            type: 'pie',
		    	            radius : '60%',
		    	            center: ['40%', '65%'],
		    	            data:[{value:name}],
		    	            itemStyle: {
		    	                emphasis: {
		    	                    shadowBlur: 10,
		    	                    shadowOffsetX: 0,
		    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		    	                },
		    	                /*normal:{ 
		    	                    label:{ 
			    	                      show: true, 
			    	                      formatter: '{b} : {c} ({d}%)' 
			    	                    }, 
		    	                    labelLine :{show:true} 
		    	                  } */
		    	            }
		    	        }
		    	    ]
		    	};
			    echart.showLoading();
		        fetchData(function (data) {  
			     	echart.hideLoading(); 
			     	echart.setOption({
			     		legend: {
			                data: data.categories
			            },
			            series: [{
			                 // 根据名字对应到相应的系列
			            	 name: '交易金额',
                             data: (function () {
                            	 var res = [];
                                 var len = data.data.length;
                                 while (len--) {
                                     res.push({
                                         name: data.categories[len],
                                         value: data.data[len]
                                     });
                                 }
                                 return res;
                                 })()
			                 }]
			             });
			        }); 
			  echart.setOption(option);   
	    	}
		}); 
}); 