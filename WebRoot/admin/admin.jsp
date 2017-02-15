<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.Admin" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>admin</title>
    
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
  	<%
  		ArrayList<Admin> a = (ArrayList)request.getSession().getAttribute("ad");
  	 %>
  	 <table align="center" class="table  table-striped table-bordered table-hover table-responsive">
  	 	<tr>
  	 		<th>编号:</th>
  	 		<td>
  	 			<%=a.get(0).getId() %>
  	 		</td>
  	 	</tr>
  	 	<tr>
  	 		<th>账号:</th>
  	 		<td>
  	 			<%=a.get(0).getName() %>
  	 		</td>
  	 	</tr>
  	 	<tr>
  	 		<th>密码:</th>
  	 		<td>
  	 			<%=a.get(0).getPassword() %>
  	 		</td>
  	 	</tr>
  	 </table>
	<script type="text/javascript">
		window.onload=function(){
			//var thCode = document.getElementsByTagName("tr");
			//for(var i=0;i<thCode.length;i++){
				//if(i%2 != 0){
					//thCode[i].style.background="red";
				//}
			//}
			
		};
	</script>
  </body>
</html>
