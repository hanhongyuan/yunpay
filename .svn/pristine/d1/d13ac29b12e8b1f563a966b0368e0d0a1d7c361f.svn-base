/** 
 * 商户交易汇总 的业务 js
 * 
 */
// 获取今天 or 昨天日期
function showDate(type,inputId){
	//昨天的时间
	var day1 = new Date();
	day1.setTime(day1.getTime()-24*60*60*1000);
	var m1 = day1.getMonth()+1;
	var d1 = day1.getDate();
	if(m1 <10){
		m1 = "0"+m1;
	}
	if(d1 <10){
		d1 = "0"+d1;
	}
	var s1 = day1.getFullYear()+"-" + m1 + "-" + d1;
	//今天的时间
	var day2 = new Date();
	day2.setTime(day2.getTime());
	var m2 = day2.getMonth()+1;
	var d2 = day2.getDate();
	if(m2 <10){
		m2 = "0"+m2;
	}
	if(d2 < 10){
		d2 = "0"+d2;
	}
	var s2 = day2.getFullYear()+"-" + m2 + "-" + d2;
	
	if(type == '今天'){
		$("#"+inputId).val(s2);
	}else if(type == '昨天'){
		$("#"+inputId).val(s1);
	}
}

// 获取本周、本季度、本月、上月的开始日期、结束日期
function setDate(type,inputId1,inputId2){
	if(type == '本周'){
		$("#"+inputId1).val(getWeekStartDate());
		$("#"+inputId2).val(getWeekEndDate());
	}else if(type == '上周'){
		$("#"+inputId1).val(getLastWeekStartDate());
		$("#"+inputId2).val(getLastWeekEndDate());
	}else if(type == '本月'){
		$("#"+inputId1).val(getMonthStartDate());
		$("#"+inputId2).val(getMonthEndDate());
	}else if(type == '上月'){
		$("#"+inputId1).val(getLastMonthStartDate());
		$("#"+inputId2).val(getLastMonthEndDate());
	}
}


/**
 * 获取本周、本季度、本月、上月的开始日期、结束日期
 */
var now = new Date(); //当前日期
var nowDayOfWeek = now.getDay(); //今天本周的第几天
var nowDay = now.getDate(); //当前日
var nowMonth = now.getMonth(); //当前月
var nowYear = now.getYear(); //当前年
nowYear += (nowYear < 2000) ? 1900 : 0; //
var lastMonthDate = new Date(); //上月日期
lastMonthDate.setDate(1);
lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);
var lastYear = lastMonthDate.getYear();
var lastMonth = lastMonthDate.getMonth();
//格式化日期：yyyy-MM-dd
function formatDate(date) {
    var myyear = date.getFullYear();
    var mymonth = date.getMonth() + 1;
    var myweekday = date.getDate();
    if (mymonth < 10) {
        mymonth = "0" + mymonth;
    }
    if (myweekday < 10) {
        myweekday = "0" + myweekday;
    }
    return (myyear + "-" + mymonth + "-" + myweekday);
}

//获得某月的天数
function getMonthDays(myMonth) {
    var monthStartDate = new Date(nowYear, myMonth, 1);
    var monthEndDate = new Date(nowYear, myMonth + 1, 1);
    var days = (monthEndDate - monthStartDate) / (1000 * 60 * 60 * 24);
    return days;
}
//获得本季度的开始月份
function getQuarterStartMonth() {
    var quarterStartMonth = 0;
    if (nowMonth < 3) {
        quarterStartMonth = 0;
    }
    if (2 < nowMonth && nowMonth < 6) {
        quarterStartMonth = 3;
    }
    if (5 < nowMonth && nowMonth < 9) {
        quarterStartMonth = 6;
    }
    if (nowMonth > 8) {
        quarterStartMonth = 9;
    }
    return quarterStartMonth;
}
//获得本周的开始日期
function getWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek);
    return formatDate(weekStartDate);
}

//获得本周的结束日期
function getWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay + (6 - nowDayOfWeek));
    return formatDate(weekEndDate);
}


//获得上周的开始日期
function getLastWeekStartDate() {
    var weekStartDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek - 7);
    return formatDate(weekStartDate);
}
//获得上周的结束日期
function getLastWeekEndDate() {
    var weekEndDate = new Date(nowYear, nowMonth, nowDay - nowDayOfWeek - 1);
    return formatDate(weekEndDate);
}


//获得本月的开始日期
function getMonthStartDate() {
    var monthStartDate = new Date(nowYear, nowMonth, 1);
    return formatDate(monthStartDate);
}

//获得本月的结束日期
function getMonthEndDate() {
    var monthEndDate = new Date(nowYear, nowMonth, getMonthDays(nowMonth));
    return formatDate(monthEndDate);
}

//获得上月开始时间
function getLastMonthStartDate() {
    var lastMonthStartDate = new Date(nowYear, lastMonth, 1);
    return formatDate(lastMonthStartDate);
}
//获得上月结束时间
function getLastMonthEndDate() {
    var lastMonthEndDate = new Date(nowYear, lastMonth, getMonthDays(lastMonth));
    return formatDate(lastMonthEndDate);
}

//获得本季度的开始日期
function getQuarterStartDate() {
    var quarterStartDate = new Date(nowYear, getQuarterStartMonth(), 1);
    return formatDate(quarterStartDate);
}
//获得本季度的结束日期
function getQuarterEndDate() {
    var quarterEndMonth = getQuarterStartMonth() + 2;
    var quarterStartDate = new Date(nowYear, quarterEndMonth,
            getMonthDays(quarterEndMonth));
    return formatDate(quarterStartDate);
}