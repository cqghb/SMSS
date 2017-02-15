<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.Students" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/shore.css"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/web_sys/css/bootstrap.min.css">
  </head>
  
  <body>
  	<%
  		int pages = Integer.parseInt(request.getSession().getAttribute("curPage").toString());
  		int maxPage = Integer.parseInt(request.getSession().getAttribute("maxPage").toString());
  	 %>
    <%
    	ArrayList<Students> students = (ArrayList)request.getAttribute("students");
    %>
    <div id="left">
    	<jsp:include page="queryStu.jsp"></jsp:include>
    </div>
    <div id="right">
    	<table align="center" class="table table-striped table-bordered table-hover table-responsive">
	    	<thead>
	    		<tr>
	    			<th>学号</th>
	    			<th>姓名</th>
	    			<th>性别</th>
	    			<th>年龄</th>
	    			<th>班级</th>
	    			<th>
	    				<a href="<%=request.getContextPath() %>/content/addStudent.jsp" target="content" class="btn btn-primary">添加学生</a>
	    			</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<%
					if(students!=null){
						for (int i = 0; i < students.size(); i++) {
				%>
				<tr>	
					<td>
						<%=students.get(i).getId()%>
					</td>
					<td>
						<%=students.get(i).getName()%>
					</td>
					<td>
						<%
							int sex =students.get(i).getSex();
							String Sex=null;
						%>
						<%
							if(sex==1){
								Sex = "男";
							}
							if(sex==2){
								Sex = "女";
							}
						%>
						<%=Sex%>
					</td>
					<td>
						<%=students.get(i).getAge()%>
					</td>
					<td>
						<%!String n = ""; %>
						<%
							if(students.get(i).getClass_id()==1){
								n = "软件一班";
							}
							if(students.get(i).getClass_id()==2){
								n = "软件1班";
							}
						 %>
						<%=n %>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/content/updateStudent.jsp?id=<%=students.get(i).getId()%>&name=<%=students.get(i).getName()%>&sex=<%=students.get(i).getSex()%>&age=<%=students.get(i).getAge()%>&class_id=<%=students.get(i).getClass_id()%>&operation=update" class="btn btn-primary" target="content">修改</a>
						<a href="<%=request.getContextPath() %>/servlet/StudentServlet?id=<%=students.get(i).getId()%>&operation=delete" class="btn btn-primary">删除</a>
					</td>
				</tr>
				<%
						}
					}
				%>
	    	</tbody>
		</table>
		<div id="fy" align="center">
			<a href="<%=request.getContextPath() %>/servlet/StudentServlet?curPage=1&operation=select" target="content" class="btn btn-primary">首页</a>
			<a href="<%=request.getContextPath() %>/servlet/StudentServlet?curPage=<%=pages-1 %>&operation=select" target="content" class="btn btn-primary">上一页</a>
			当前是:<%=pages %>页&nbsp;总共:<%=maxPage %>页
			<a href="<%=request.getContextPath() %>/servlet/StudentServlet?curPage=<%=pages+1 %>&operation=select" target="content" class="btn btn-primary">下一页</a>
			<a href="<%=request.getContextPath() %>/servlet/StudentServlet?curPage=<%=maxPage %>&operation=select" target="content" class="btn btn-primary">末页</a>
		</div>
    </div>
   </body>
</html>
