<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
      <link rel="stylesheet" type="text/css" href="${ctx}/css/test01.css">
      <script type="text/javascript" src="${ctx}/js/jquery-1.12.4.js"></script>
      <script type="text/javascript" src="${ctx}/js/test01.js"></script>
        <script type="text/javascript" src="${ctx}/js/person.js"></script>
        <script type="text/javascript" src="${ctx}/js/serializeForm.js"></script>
        <script type="text/javascript">
          var basePath = "${ctx}";
           </script>
  </head>
  
  <body>
        <div id="div1">
		<table id="showdata" border="1">
		  <tr>
			       <td>id</td>
			       <td class="name">姓名</td>
			       <td class="age">年龄</td>
			        <td colspan="2" style="text-align:center;vertical-align:middle;">添加</td>
			       </tr>
			<c:forEach items="${plist}" var="p1">
				<tr>
				 	<td>${p1.id}</td> 
					<td >${p1.name}</td>
				    <td class="age">${p1.age}</td>
					<td id="del"><a href="javascript:void(0)" onclick="del(${p1.id})">删除</a></td>
					<td id="update"><a href="javascript:void(0)" onclick="update(${p1.id})">修改</a></td>
				</tr>
			</c:forEach>
		</table>
         </div>




	<div id="div2">
		<form id="add" name="addform">
			<fieldset>
				<legend>添加</legend>
				<table>
					<tr>
						<td>添加名字:</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>添加年龄:</td>
						<td><input type="text" name="age"></td>
					</tr>
					<tr>
						<td><input type="button" value="添加" onclick="add()"></td>
						<td><input type="reset" value="重置"></td>
					</tr>
				</table>
			</fieldset>
			<input type="hidden" name="opr" value="add">
		</form>
	</div>

	<div id="div3">
		<form id="update" name="updateform">
			<fieldset>
			 <legend>修改</legend>
			 <table>
			 	<tr>
						<td>id</td>
						<td><input type="text" name="id" readonly="readonly"></td>
					</tr>
			<tr>
				<td>新名字:</td>
				<td><input type="text" name="name" ></td>
			</tr>
			<tr>
				<td>新年龄:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td><input type="button" value="修改" onclick="update()"></td>
				<td><input type="reset" value="重置" ></td>
			</tr>
			</table>
		</fieldset>
		<input type="hidden" name="opr" value="update">
		</form>
	</div>
</body>
</html>
