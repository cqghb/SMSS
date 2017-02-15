<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.Students" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>student</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
  </head>
  
  <body>
    <%
    	ArrayList<Students> s1 = (ArrayList)request.getSession().getAttribute("students1");
    %>
    <table align="center" class="table  table-striped table-bordered table-hover table-responsive">
  		<thead>
  			<tr>
  				<th>学号</th>
    			<th>姓名</th>
    			<th>性别</th>
    			<th>年龄</th>
    			<th>班级</th>
  			</tr>
  		</thead>
  		<tbody>
  			<%
  			for(int i=0;i<s1.size();i++){
  			%>
  			<tr>
  				<td>
  					<%!
  						String id = "";
  					%>
  					<%
  						int id1 = s1.get(i).getId();
  						if(id1==0){
  							id = "NULL";
  						}else{
  							id = String.valueOf(id1);
  						}
  					 %>
  					<%=id %>
  				</td>
  				<td>
  					<%=s1.get(i).getName() %>
  				</td>
  				<td>
  					<%!
  						String sexhh = null;
  					%>
  					<%
  						int sex = s1.get(i).getSex();
  						if(sex==1){
  							sexhh = "男";
  						}else if(sex==2){
  							sexhh = "女";
  						}else if(sex==0){
  							sexhh = "NULL";
  						}
  					%>
  					<%=sexhh %>
  				</td>
  				<td>
  					<%!
  						String age = "";
  					%>
  					<%
  						int age1 = s1.get(i).getAge();
  						if(age1==0){
  							age = "NULL";
  						}else{
  							age = String.valueOf(age1);
  						}
  					 %>
  					<%=age %>
  				</td>
  				<td>
  					<%!
  						String classname = null;
  					%>
  					<%
  						int cn = s1.get(i).getClass_id();
  						if(cn==1){
  							classname = "软件一班";
  						}else if(cn==2){
  							classname = "软件1班";
  						}else if(cn==0){
  							classname = "NULL";
  						}
  					%>
  					<%=classname %>
  				</td>
  			</tr>
  			<%} %>
  		</tbody>
  	 </table>
  	 <a target="content" href="<%=request.getContextPath()%>/servlet/StudentServlet?operation=select" class="btn btn-info">返回</a>
  </body>
</html>
