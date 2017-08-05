<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../../../../common/taglib/taglib.jsp"%>
[
	{"value":"", "label":"--请选择--"}
	<c:if test="${!empty dataList}">,</c:if>
	<c:forEach var ="data" items="${dataList }" varStatus="status">
    	{"value":"${data.id}", "label":"${data.title}"}<c:if test="${status.index +1 != dataList.size()}">,</c:if>
    </c:forEach> 
]
