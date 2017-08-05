<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
<div class="pageContent">
    <table>
			<tr>
				<td height="25">
		           	<label class="control-label x110">商户编码：</label>
		           	<label>${onTranInfo.merchId}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">终端编码：</label>
		           	<label>${onTranInfo.termId}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">卡号：</label>
		            <label>${onTranInfo.cardNo}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">卡类型：</label>
		           	<label>${onTranInfo.cardType}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">批次号：</label>
		            <label>${onTranInfo.batchNo}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">交易流水：</label>
		           	<label>${onTranInfo.tranSerial}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">原始交易流水：</label>
		            <label>${onTranInfo.origSerial}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">终端流水：</label>
		           	<label>${onTranInfo.termSerial}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易金额：</label>
		            <label>${onTranInfo.tranAmt}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">原始交易金额：</label>
		           	<label>${onTranInfo.origTranAmt}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		           	<label class="control-label x110">卡余额：</label>
		           	<label>${onTranInfo.remainTranAmt}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">交易标志：</label>
		           	<label>${onTranInfo.tranFlag}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		           	<label class="control-label x110">系统参考号：</label>
		           	<label>${onTranInfo.referNo}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">授权号：</label>
		           	<label>${onTranInfo.authNo}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		           	<label class="control-label x110">授权日期：</label>
		           	<label>${onTranInfo.authDate}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">授权金额：</label>
		           	<label>${onTranInfo.authAmt}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		           	<label class="control-label x110">发卡机构代码：</label>
		           	<label>${onTranInfo.acqInst}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">应用交易计数器：</label>
		           	<label>${onTranInfo.atc}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		           	<label class="control-label x110">批次状态：</label>
		           	<label>${onTranInfo.batchStatus}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">批次结果：</label>
		           	<label>${onTranInfo.batchResult}</label>
				</td>
			</tr>
	
			<tr>
				<td height="25">
		            <label class="control-label x110">交易类型：</label>
		            <label>${onTranInfo.tranType}</label>
				</td>
				<td height="25">
		            <label class="control-label x110">交易时间：</label>
		            <label>${onTranInfo.tranTime}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易ATC：</label>
		            <%-- <label>${onTranInfo.tac}</label> --%>
				</td>
				<td height="25">
		           	<label class="control-label x110">SAM卡交易序号：</label>
		           	<%-- <label>${onTranInfo.samSeq}</label> --%>
				</td>
			</tr>
			
			<tr>
				<td height="25">
		            <label class="control-label x110">清算标志：</label>
		            <label>${onTranInfo.settleFlag}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">清算日期：</label>
		           	<label>${onTranInfo.settleDate}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易状态：</label>
		            <label>
						<c:choose>
		                	<c:when test="${onTranInfo.tranStatus=='1' }">
		                		成功
		                	</c:when>
		                	<c:otherwise>
		                		失败
		                	</c:otherwise>
		                </c:choose>
					</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">手机号码：</label>
		           	<label>${onTranInfo.phoneNo}</label>
				</td>
			</tr>
		</table>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
		    </ul>
		</div>
</div>
