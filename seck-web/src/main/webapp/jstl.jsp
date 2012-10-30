<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>JSTL</h2>
<c:forEach items="${Output}" var="j">
		${j.value}<br />
</c:forEach>
</body>
</html>