$(function(){    
	$("#recharge-industry-today").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeindustryTodayurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result);
		    	var typeNameArray = new Array();
		        var tranNumArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
			    	tranNumArray[i] = jsonobj[i].tranNum;
		    	}
		        function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranNumArray
		                }); 
		            }, 1000);
		        } 
		        
		        var chart = document.getElementById('recharge-industry-histogram');      
		        var echart = echarts.init(chart);
		        var option = {
		            color: ['#3398DB'],
		            tooltip : {
		                trigger: 'axis',
		                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		                }
		            },
		            grid: {
		                left: '3%',
		                right: '4%',
		                bottom: '3%',
		                containLabel: true,
		                barWidth:'10%'
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    data : [],
		                    axisTick: {
		                        alignWithLabel: true
		                    }
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value'
		                }
		            ],
		            series : [
		                {
		                    name:'访问',
		                    type:'bar',
		                    barWidth: '20%',
		                    itemStyle: {normal: {
		                        label : {show:true,position:'top',formatter:'{c} %'}
		                    }},
		                    data:[]
		                }
		            ]
		        };
		        echart.showLoading();
		        fetchData(function (data) { 
			     	echart.hideLoading(); 
			     	echart.setOption({
			             xAxis: {
			                 data: data.categories
			             },
			             series: [{
			                 // 根据名字对应到相应的系列
			                 name: '销量',
			                 data: data.data 
			                 }]
			             });
			        }); 
		         echart.setOption(option);
		        } 
		});
		$.ajax({
			type:"post", 
	    	dataType: "text", 
		    url: rechargeindustryTodayurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result); 
		    	var typeNameArray = new Array();
	            var tranAmountArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
		    		tranAmountArray[i] = jsonobj[i].tranAmount;
		    	} 
		    	function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranAmountArray
		                }); 
		            }, 1000);
		        } 
		    	
			    var chart = document.getElementById('recharge-industry-pie');      
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
			    	                normal:{ 
			    	                    label:{ 
				    	                      show: true, 
				    	                      formatter: '{b} : {c} ({d}%)' 
				    	                    }, 
			    	                    labelLine :{show:true} 
			    	                  } 
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
	
	$("#recharge-industry-yesterday").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeindustryYesterdayurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result);
		    	var typeNameArray = new Array();
		        var tranNumArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
			    	tranNumArray[i] = jsonobj[i].tranNum;
		    	}
		        function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranNumArray
		                }); 
		            }, 1000);
		        } 
		        
		        var chart = document.getElementById('recharge-industry-histogram');      
		        var echart = echarts.init(chart);
		        var option = {
		            color: ['#3398DB'],
		            tooltip : {
		                trigger: 'axis',
		                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		                }
		            },
		            grid: {
		                left: '3%',
		                right: '4%',
		                bottom: '3%',
		                containLabel: true,
		                barWidth:'10%'
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    data : [],
		                    axisTick: {
		                        alignWithLabel: true
		                    }
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value'
		                }
		            ],
		            series : [
		                {
		                    name:'访问',
		                    type:'bar',
		                    barWidth: '20%',
		                    itemStyle: {normal: {
		                        label : {show:true,position:'top',formatter:'{c} %'}
		                    }},
		                    data:[]
		                }
		            ]
		        };
		        echart.showLoading();
		        fetchData(function (data) { 
			     	echart.hideLoading(); 
			     	echart.setOption({
			             xAxis: {
			                 data: data.categories
			             },
			             series: [{
			                 // 根据名字对应到相应的系列
			                 name: '销量',
			                 data: data.data 
			                 }]
			             });
			        }); 
		         echart.setOption(option);
		        } 
		});
		$.ajax({
			type:"post", 
	    	dataType: "text", 
		    url: rechargeindustryYesterdayurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result); 
		    	var typeNameArray = new Array();
	            var tranAmountArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
		    		tranAmountArray[i] = jsonobj[i].tranAmount;
		    	} 
		    	function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranAmountArray
		                }); 
		            }, 1000);
		        } 
		    	
			    var chart = document.getElementById('recharge-industry-pie');      
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
			    	                normal:{ 
			    	                    label:{ 
				    	                      show: true, 
				    	                      formatter: '{b} : {c} ({d}%)' 
				    	                    }, 
			    	                    labelLine :{show:true} 
			    	                  } 
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
	
	$("#recharge-industry-week").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeindustryWeekurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result);
		    	var typeNameArray = new Array();
		        var tranNumArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
			    	tranNumArray[i] = jsonobj[i].tranNum;
		    	}
		        function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranNumArray
		                }); 
		            }, 1000);
		        } 
		        
		        var chart = document.getElementById('recharge-industry-histogram');      
		        var echart = echarts.init(chart);
		        var option = {
		            color: ['#3398DB'],
		            tooltip : {
		                trigger: 'axis',
		                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		                }
		            },
		            grid: {
		                left: '3%',
		                right: '4%',
		                bottom: '3%',
		                containLabel: true,
		                barWidth:'10%'
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    data : [],
		                    axisTick: {
		                        alignWithLabel: true
		                    }
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value'
		                }
		            ],
		            series : [
		                {
		                    name:'访问',
		                    type:'bar',
		                    barWidth: '20%',
		                    itemStyle: {normal: {
		                        label : {show:true,position:'top',formatter:'{c} %'}
		                    }},
		                    data:[]
		                }
		            ]
		        };
		        echart.showLoading();
		        fetchData(function (data) { 
			     	echart.hideLoading(); 
			     	echart.setOption({
			             xAxis: {
			                 data: data.categories
			             },
			             series: [{
			                 // 根据名字对应到相应的系列
			                 name: '销量',
			                 data: data.data 
			                 }]
			             });
			        }); 
		         echart.setOption(option);
		        } 
		});
		$.ajax({
			type:"post", 
	    	dataType: "text", 
		    url: rechargeindustryWeekurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result); 
		    	var typeNameArray = new Array();
	            var tranAmountArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
		    		tranAmountArray[i] = jsonobj[i].tranAmount;
		    	} 
		    	function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranAmountArray
		                }); 
		            }, 1000);
		        } 
		    	
			    var chart = document.getElementById('recharge-industry-pie');      
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
			    	                normal:{ 
			    	                    label:{ 
				    	                      show: true, 
				    	                      formatter: '{b} : {c} ({d}%)' 
				    	                    }, 
			    	                    labelLine :{show:true} 
			    	                  } 
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
	
	$("#recharge-industry-month").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeindustryMonthurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result);
		    	var typeNameArray = new Array();
		        var tranNumArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
			    	tranNumArray[i] = jsonobj[i].tranNum;
		    	}
		        function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranNumArray
		                }); 
		            }, 1000);
		        } 
		        
		        var chart = document.getElementById('recharge-industry-histogram');      
		        var echart = echarts.init(chart);
		        var option = {
		            color: ['#3398DB'],
		            tooltip : {
		                trigger: 'axis',
		                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		                }
		            },
		            grid: {
		                left: '3%',
		                right: '4%',
		                bottom: '3%',
		                containLabel: true,
		                barWidth:'10%'
		            },
		            xAxis : [
		                {
		                    type : 'category',
		                    data : [],
		                    axisTick: {
		                        alignWithLabel: true
		                    }
		                }
		            ],
		            yAxis : [
		                {
		                    type : 'value'
		                }
		            ],
		            series : [
		                {
		                    name:'访问',
		                    type:'bar',
		                    barWidth: '20%',
		                    itemStyle: {normal: {
		                        label : {show:true,position:'top',formatter:'{c} %'}
		                    }},
		                    data:[]
		                }
		            ]
		        };
		        echart.showLoading();
		        fetchData(function (data) { 
			     	echart.hideLoading(); 
			     	echart.setOption({
			             xAxis: {
			                 data: data.categories
			             },
			             series: [{
			                 // 根据名字对应到相应的系列
			                 name: '销量',
			                 data: data.data 
			                 }]
			             });
			        }); 
		         echart.setOption(option);
		        } 
		});
		$.ajax({
			type:"post", 
	    	dataType: "text", 
		    url: rechargeindustryMonthurl, 
		    contentType: "application/x-www-form-urlencoded; charset=utf-8",
		    success: function (result){ 
		    	var jsonobj = JSON.parse(result); 
		    	var typeNameArray = new Array();
	            var tranAmountArray = new Array();
		    	for(var i=0;i<jsonobj.length;i++){
		    		typeNameArray[i] = jsonobj[i].typeName;
		    		tranAmountArray[i] = jsonobj[i].tranAmount;
		    	} 
		    	function fetchData(cb) {
		            // 通过 setTimeout 模拟异步加载
		            setTimeout(function () {
		                cb({
		                    categories:typeNameArray,
		                    data: tranAmountArray
		                }); 
		            }, 1000);
		        } 
		    	
			    var chart = document.getElementById('recharge-industry-pie');      
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
			    	                normal:{ 
			    	                    label:{ 
				    	                      show: true, 
				    	                      formatter: '{b} : {c} ({d}%)' 
				    	                    }, 
			    	                    labelLine :{show:true} 
			    	                  } 
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
});