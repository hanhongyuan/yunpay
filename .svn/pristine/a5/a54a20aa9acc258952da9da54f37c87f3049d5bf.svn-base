<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
[<c:forEach var ="data" items="${chartsList}" varStatus="status">
   	{"areaName":"${data.areaName}","tranNum":"${data.tranNum}",
   	"tranAmount":"${data.tranAmount}","typeName":"${data.typeName}","busiName":"${data.busiName}"}
   	<c:if test="${status.index +1 != chartsList.size()}">,</c:if>
</c:forEach> 
]