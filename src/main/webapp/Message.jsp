<%@page import="java.io.PrintWriter"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
</head>
<body>
<%

String msg=(String) request.getAttribute("msg");
PrintWriter pw=response.getWriter();
pw.println(msg);

%>
</body>
</html>