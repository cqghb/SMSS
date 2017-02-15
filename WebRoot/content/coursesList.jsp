<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>classList</title>
    
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
    	ArrayList<Courses> courses = (ArrayList)request.getAttribute("course");
    %>
    <div id="left">
    	<jsp:include page="queryCour.jsp"></jsp:include>
    </div>
    <div id="right">
    	<table align="center" class="table table-striped table-bordered table-hover table-responsive">
	    	<thead>
	    		<tr>
	    			<th>课程编号</th>
	    			<th>课程名称</th>
	    			<th>
	    				<a href="<%=request.getContextPath() %>/content/addCourses.jsp" target="content" class="btn btn-primary">添加课程</a>
	    			</th>
	    		</tr>
	    	</thead>
	    	<tbody>
	    		<%
					if(courses!=null){
						for (int i = 0; i < courses.size(); i++) {
				%>
				<tr>	
					<td>
						<%=courses.get(i).getCourse_id()%>
					</td>
					<td>
						<%=courses.get(i).getCourse_name()%>
					</td>
					<td>
						<a href="<%=request.getContextPath() %>/content/updateCourses.jsp?course_id=<%=courses.get(i).getCourse_id()%>&course_name=<%=courses.get(i).getCourse_name()%>" class="btn btn-primary" target="content">修改</a>
						<a href="<%=request.getContextPath() %>/servlet/CoursesServlet?course_id=<%=courses.get(i).getCourse_id()%>&operation=delete" class="btn btn-primary">删除</a>
					</td>
				</tr>
				<%
						}
					}
				%>
	    	</tbody>
		</table>
		<div align="center">
			<a href="<%=request.getContextPath() %>/servlet/CoursesServlet?curPage=1&operation=select" target="content" class="btn btn-primary">首页</a>
			<a href="<%=request.getContextPath() %>/servlet/CoursesServlet?curPage=<%=pages-1 %>&operation=select" target="content" class="btn btn-primary">上一页</a>
			当前是:<%=pages %>页&nbsp;总共:<%=maxPage %>页
			<a href="<%=request.getContextPath() %>/servlet/CoursesServlet?curPage=<%=pages+1 %>&operation=select" target="content" class="btn btn-primary">下一页</a>
			<a href="<%=request.getContextPath() %>/servlet/CoursesServlet?curPage=<%=maxPage %>&operation=select" target="content" class="btn btn-primary">末页</a>
		</div>
    </div>
  </body>
</html>
