<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员添加</title>
    <script type="text/javascript">
    	function checkForm()
    	{	
        	var userName = document.getElementById("name").value;
        	var pwd = document.getElementById("pwd").value;
        	if(userName == "")
        	{
        		alert("请输入登录名!");
        		return false;
            }
        	if(pwd == "")
        	{
        		alert("请输入密码!");
        		return false;
            }
            return true;
        }
    </script>
  </head>
  <body>
  	<center>
	   		<h1>管理员添加</h1>
	   		<h3><font color="red">${msg }</h3>
	   		<form action="${pageContext.request.contextPath }/addAdmin.do" method="post" onsubmit="return checkForm()">
	   			<table width="300">
	   				<tr>
	   					<td>登录名:</td>
	   					<td>
	   						<input name="name" id="name"/>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
	   					<td>
	   						<input type="password"  name="pwd" id="pwd" size="22"/>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>状&nbsp;&nbsp;&nbsp;&nbsp;态:</td>
	   					<td>
	   						<select name="state">
	   							<option value="0">普通</option>
								<option value="1">超级</option>
								<option value="-1">冻结</option>
							</select>
	   					</td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="2">
	   						<input type="submit" value="添  加"/>
	   					</td>
	   				</tr>
	   			</table>
	   		</form>
	   		<h2><a href="${pageContext.request.contextPath }/selectAll.do">返回主页</a></h2>
   	</center>
   	<%-- <c:set scope="session" ></c:set> --%>
  </body>
</html>
