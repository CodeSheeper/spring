<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'person.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="PersonServlet"  method="post">
  <table>
    <tr><td>id</td><td>name</td></tr>
    <c:forEach items="${list }" var="p">
     <tr><td>${p1.id }</td><td>${p1.name }</td></tr>
    </c:forEach>
  </table>
  当前第<input type="text" name="curpage" value="${curPage}">页
      
           跳转到:第<input type="text" name="page">页<span>每页</span><input type="text" name="count">条
           <input type="submit"value="跳转">
        </form>
  </body>
</html>
