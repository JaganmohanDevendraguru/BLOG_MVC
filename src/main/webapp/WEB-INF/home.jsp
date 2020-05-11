<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>
<c:set var="name" value="Jagan"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/popper.js/umd/popper.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Home Page</title>
</head>
<body>
<p>Home page</p>
<c:out value="${context}" />
<c:out value="${name}" />
</body>
</html>