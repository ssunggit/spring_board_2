<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
    [세션]<br>
	전화번호 : ${tel}<br>
	이름: ${name} 
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
