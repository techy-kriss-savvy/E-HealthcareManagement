<%@page import="com.model.PatientDao"%>
<%@page import="com.model.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient List</title>
</head>
<body>
<%
String pgid=request.getParameter("page");
int pid=Integer.parseInt(pgid);
int id=pid;
int total=5;

if(id==1){}
else{
	id=id-1;
	id=id*total+1;
}
out.println("<h2> Page No: "+ pid+"</h2>");
List<Patient> list=PatientDao.getRecords(id,total);
out.println("<table><tr><th>PID</th><th>Doctor</th><th>Condition</th></tr>");
for(Patient p:list){
	out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getDoctor()+"</td><td>"+p.getConditions()+"</td></tr>");
}
  out.println("</table>");

%>
<a href="View.jsp?page=1">1</a>
<a href="View.jsp?page=2">2</a>
<a href="View.jsp?page=3">3</a>
</body>
</html>