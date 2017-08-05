<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<script type="text/javascript">
var MerchNoticeAdd = {
	    // 删除后的回调函数，刷新当前页面
	    navTabAjax: function(json) {
	        if(json.statusCode=='200')
	        {
	            $(this).dialog('closeCurrent');
	            $(this).navtab('refresh');
	            $(this).alertmsg('ok', '添加成功！');
	        }else{
	             $(this).alertmsg('error', '添加失败！');
	        }
	    }
	};
</script>
    
<div class="bjui-pageContent tableContent">
    <form action="${baseURL }/sys/merchant/add" data-toggle="validate" class="pageForm" data-callback="MerchNoticeAdd.navTabAjax">
		<div class="pageFormContent" layoutH="60">
			<p>
				<label>通知类型：</label> 
				<select name="noticeType" class="combox" data-rule="required">
					<option value="" selected='selected'>-全部-</option>
					<option value="1">系统广告</option>
					<option value="2">网站广告</option>
					<option value="3">滚动通知</option>
				</select> 
				<span class="required" style="color: red; font-size: 15px"><b>*</b></span>
			</p>
			<p>
				<label>通知级别：</label> 
				<select name="noticeGrade" class="combox" data-rule="required">
					<option value="" selected='selected'>-全部-</option>
					<option value="1">普通</option>
					<option value="2">重要</option>
				</select> 
				<span class="required" style="color: red; font-size: 15px"><b>*</b></span>
			</p>
			<p>
				<label>通知标题：</label>
				<input type="text" name="noticeTitle" size="20" class="form-control" data-rule="required" /> 
				<span class="required" style="color: red; font-size: 15px"><b>*</b></span>
			</p>
			<p>
				<label>通知简文：</label>
				<input type="text" name="noticeShortMsg" size="30" class="form-control" data-rule="required" /> 
				<span class="required" style="color: red; font-size: 15px"><b>*</b></span>
			</p>
			<p>
				<label>生效日期：</label>
				<input type="text" name="useDate" data-toggle="datepicker" readonly style="width:120px;" class="form-control" />
			</p>
			<p>
				<label>通知内容：</label>
				<textarea name="noticeMsg" ></textarea>
			</p>
		</div>
		<div class="bjui-pageFooter">
            <ul>
                <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
                <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
            </ul>
        </div>
    </form>
</div>