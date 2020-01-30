<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
//This is called a Scriptlet
String str = "Kabali Shivaji";
%>
<h1><%= str %></h1>

<center>

<%

for(int i=1; i<=6; i++)
{
	%>
	<font size="<%=i %>"> Hello everyone</font><br/>
	<%
}
%>
</center>
</body>
</html>