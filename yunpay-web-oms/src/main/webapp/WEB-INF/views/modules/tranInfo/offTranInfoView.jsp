<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../common/taglib/taglib.jsp"%>
	
<div class="bjui-pageContent tableContent">
    <table>
			<tr>
				<td height="25">
		           	<label class="control-label x110">商户编码：</label>
		           	<label>${offTranInfo.merchId}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">终端编码：</label>
		           	<label>${offTranInfo.termId}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">卡号：</label>
		            <label>${offTranInfo.cardNo}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">卡类型：</label>
		           	<label>${offTranInfo.cardType}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">批次号：</label>
		            <label>${offTranInfo.batchNo}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">流水：</label>
		           	<label>${offTranInfo.tranSerial}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易金额：</label>
		            <label>${offTranInfo.tranAmt}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">卡余额：</label>
		           	<label>${offTranInfo.cardBalance}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易类型：</label>
		            <label>${offTranInfo.tranType}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">交易小类：</label>
		           	<label>${offTranInfo.tranSubd}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易时间：</label>
		            <label>${offTranInfo.tranDate}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">卡交易序号：</label>
		           	<label>${offTranInfo.cardSeq}</label>
				</td>
			</tr>
			
			<tr>
				<td height="25">
		            <label class="control-label x110">交易ATC：</label>
		            <label>${offTranInfo.tac}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">SAM卡交易序号：</label>
		           	<label>${offTranInfo.samSeq}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">包名称：</label>
		            <label style="width:300px">${offTranInfo.fileName}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">包大小：</label>
		           	<label>${offTranInfo.fileSize}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">清算标志：</label>
		            <label>${offTranInfo.settleFlag}</label>
				</td>
				<td height="25">
		           	<label class="control-label x110">清算日期：</label>
		           	<label>${offTranInfo.settleDate}</label>
				</td>
			</tr>
			<tr>
				<td height="25">
		            <label class="control-label x110">交易状态：</label>
		            <label>
		            	<c:choose>
		                	<c:when test="${offTranInfo.tranStatus=='1' }">
		                		成功
		                	</c:when>
		                	<c:otherwise>
		                		失败
		                	</c:otherwise>
		                </c:choose>
		            </label>
				</td>
				<td height="25">
		           	<label class="control-label x110">备注：</label>
		           	<label>${offTranInfo.remark}</label>
				</td>
			</tr>
		</table>
		<div class="bjui-pageFooter">
		    <ul>
		        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
		    </ul>
		</div>
</div>
