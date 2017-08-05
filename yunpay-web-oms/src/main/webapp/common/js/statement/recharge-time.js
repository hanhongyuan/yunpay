$(function(){    
	$("#recharge-time-today").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeTimeTodayurl, 
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
		        
		        var chart = document.getElementById('recharge-time-histogram');      
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
		                    name:'刷卡次数',
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
			                 name: '刷卡次数',
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
		    url: rechargeTimeTodayurl, 
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
	
	$("#recharge-time-yesterday").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeTimeYesterdayurl, 
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
		        
		        var chart = document.getElementById('recharge-time-histogram');      
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
		                    name:'刷卡次数',
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
			                 name: '刷卡次数',
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
		    url: rechargeTimeYesterdayurl, 
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
	
	$("#recharge-time-week").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeTimeWeekurl, 
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
		        
		        var chart = document.getElementById('recharge-time-histogram');      
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
		                    name:'刷卡次数',
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
			                 name: '刷卡次数',
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
		    url: rechargeTimeWeekurl, 
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
	
	$("#recharge-time-month").click(function(){ 
		$.ajax({
			type:"post", 
			dataType: "text", 
		    url: rechargeTimeMonthurl, 
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
		        
		        var chart = document.getElementById('recharge-time-histogram');      
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
		                    name:'刷卡次数',
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
			                 name: '刷卡次数',
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
		    url: rechargeTimeMonthurl, 
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