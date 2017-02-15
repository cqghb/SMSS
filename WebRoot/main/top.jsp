<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.Admin" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
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
  
  <body style="background-color:#91BDE9">
  	<%
  		ArrayList<Admin> a = (ArrayList)request.getSession().getAttribute("admin");
  	 %>
  	 <div class="container-fluid">
  	 	
	  	
	  	<div class="row">
	  		<div class="col-sm-12">
	 			<h3 align="center">学生成绩管理系统</h3>
	  		</div>
	  	</div>
	  	<!-- 
	  	<div id="Time" class="col-sm-3">
	  		<script type="text/javascript">
	  			//var date = new Date();
	  			//document.write(date.toLocaleString());
	  			//document.write(formatDate(date,"yyyy-MM-dd mm:hh"));
	  			Date.prototype.format = function(format){ //author: meizz
				  var o = {
				    "M+" : this.getMonth()+1, //month
				    "d+" : this.getDate(),    //day
				    "h+" : this.getHours(),   //hour
				    "m+" : this.getMinutes(), //minute
				    "s+" : this.getSeconds(), //second
				    "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
				    "S" : this.getMilliseconds() //millisecond
				  };
				  if(/(y+)/.test(format)) format=format.replace(RegExp.$1,
				    (this.getFullYear()+"").substr(4 - RegExp.$1.length));
				  for(var k in o)if(new RegExp("("+ k +")").test(format))
				    format = format.replace(RegExp.$1,
				      RegExp.$1.length==1 ? o[k] :
				        ("00"+ o[k]).substr((""+ o[k]).length));
				  return format;
				};
				document.write(new Date().format("yyyy-MM-dd hh:mm:ss"));
	  		</script>
	  	</div>
	  	 -->
	  <div class="row">
	  	<div class="col-sm-3">
	  		<span style="color:red; padding-bottom: -30px;">欢迎<%=a.get(0).getName() %></span>
	  	</div>
	  	<div class="col-sm-1">
	  		<a href="<%=request.getContextPath() %>/servlet/LoginServlet?operation=selectById&id=<%=a.get(0).getId() %>" class="" target="content">我的信息</a>
	  	</div>
		  <div class="col-sm-1">
		  	<a href="<%=request.getContextPath() %>/admin/updatePass.jsp?id=<%=a.get(0).getId() %>&name=<%=a.get(0).getName() %>&password=<%=a.get(0).getPassword() %>" class="" target="content">信息修改</a>
		  </div>
		  <div class="col-sm-1">
		  	<a href="<%=request.getContextPath() %>/servlet/LoginServlet?operation=deleSession" class="" target="_top">退出系统</a>
		  </div>
		</div>
  	 </div>
  </body>
</html>
