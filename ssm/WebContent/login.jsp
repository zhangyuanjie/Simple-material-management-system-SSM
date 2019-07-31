<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript">
    	function checkForm()
    	{	
        	var userName = document.getElementById("userName").value;
        	var pwd = document.getElementById("pwd").value;
        	if(userName == "")
        	{
        		alert("请输入用户名!");
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
  <body bgcolor="#00ccff">
  		<center>
  		<div style="margin-top:150px; font-size: 40px; color:white;">
  			物料管理系统
  		</div>
   		<div>
   			<h2><font color="red">${loginError }</font></h2>
   			<form action="${pageContext.request.contextPath }/login.do" method="post" onsubmit="return checkForm()">
   				<table >
   					<tr>
   						<td><font color="white">用户名：</font></td>
   						<td><input id="userName"  value="${loginName }" name="name" size="20"/></td>
   					</tr>
   					<tr>
   						<td><font color="white">密&nbsp;&nbsp;&nbsp;&nbsp;码：</font></td>
   						<td><input id="pwd" type="password" name="pwd" size="20"/></td>
   					</tr>
   					<!-- <tr>
   						<td>验证码：</td>
   						<td><input id="userName" name="userName" size="4"/>
   						<img  src="image.jsp" alt="" onclick="this.src='image.jsp?id='+Math.random()">
   						</td>
   					</tr> -->
   					<tr><td></td></tr>
   					<tr>
   						<td colspan="2" align="center">
   						<input type="submit" value="登录"/>
   						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   						<input type="reset" value="重置"/>
   						</td>
   					</tr>	
   				</table>
			</form>
   		</div>
   		</center>
  </body>
</html>
