<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员管理</title>
   	<script type="text/javascript">
   		function del(id)
   		{
   	   		if(confirm("确定删除吗?"))
   	   		{
   	   			window.location.href="${pageContext.request.contextPath }/deleteAdmin.do?id="+id;
   	   	   	}
   	   		
   	   	}
   		function upd(id)
   		{
   	   		window.location.href="${pageContext.request.contextPath }/showUpdateAdmin.do?id="+id;
   	   	}
   	</script>
  </head>
  <body>
  	<center>
	  	<div>
	   		<h1>管理员管理</h1>
	   		<h3>${msg }</h3>
	   		<span><a href="${pageContext.request.contextPath }/showAddAdmin.do">添加管理员</a></span>
	   		<table width="500" cellspacing="0" border="1">
	   			<tr>
	   				<td>编号</td>
	   				<td>名称</td>
	   				<td>状态</td>
	   				<td colspan="2">操作</td>
	   			</tr>
	   			
	   				<c:forEach items="${alist}" var="a">
	   				<tr valign="middle">
	   					<td>${a.id }</td>
		   			
		   				<td>${a.name }</td>

		   				<c:if test="${a.state == 1}">
		   					<td>超级</td>
		   				</c:if>	
		   				<c:if test="${a.state == 0}">
		   					<tD>普通</td>
		   				</c:if>	
		   				<c:if test="${a.state == -1}">
		   					<tD>冻结</td>
		   				</c:if>	
		   				<td>
		   					<input type="button" value="修改" ${a.id==admin.id?"disabled":""} onclick="upd(${a.id})"/>
		   				</td>
		   				<td>
			   				<input type="button" value="删除" ${a.id==admin.id?"disabled":""} onclick="del(${a.id})"/>
						</td>
					</tr>
	   				</c:forEach>
	   				

	   		</table>
	   		<p/>
	   		
	   		<span><a href="${pageContext.request.contextPath }/selectAll.do">返回主页</a></span>
	   	</div>
   	</center>
  </body>
</html>
