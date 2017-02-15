<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
  </head>
  
  <body>
    <div align="center">
    	<h2>欢迎登录</h2>
    	<div>
    		<form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post" class="form-group" role="form">
    			<div class="form form-group">
					<input class="form-control" type="hidden" name="operation" value="login" />
				</div>
				<div class="form form-inline">
					<label for="name">账号:</label>
					<input id="name" class="form-control" type="text" placeholder="请输入账号" maxlength="6" name="name" autofocus="autofocus" required="required" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
				</div>
				<div class="form form-inline">
					<label for="password1">密码:</label>
					<input id="password1" class="form-control" type="password" placeholder="请输入密码" maxlength="3" name="password1" autofocus="autofocus" required="required"/>
				</div>
				<div class="form form-inline">
					<input id="empName1" class="btn btn-primary" type="reset" value="重置"/>
					<input id="empName1" class="btn btn-primary" type="submit" value="登录" onclick="return yz();"/>
				</div>
    		</form>
    	</div>
    	<div>
    		<a href="admin/addUser.jsp">新用户</a>
    		<!-- <a href="admin/zhMA.jsp">忘记密码</a> -->
    	</div>
    </div>
    <script type="text/javascript">
    	function yz(){
    		var result = true;
    		var name = document.getElementById("name").value;
    		var password = document.getElementById("password1").value;
    		if(name==""){
    			result = false;
    			alert("账号不能为空,请重新输入!");
    		}else if(password==""){
    			result = false;
    			alert("密码不能为空,请重新输入!");
    		}else if(password.length>3){
    			result = false;
    			alert("密码长度为0到3,请重新输入!");
    		}
    		return result;
    	}
    </script>
  </body>
</html>
