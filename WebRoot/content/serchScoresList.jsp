<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.ScoreSelects" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>serchScoresList</title>
    
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
    	ArrayList<ScoreSelects> scores = (ArrayList)request.getAttribute("scores");
    %>
   
   	<table align="center" class="table table-striped table-bordered table-hover table-responsive">
    	<thead>
    		<tr>
    			<th>成绩编号</th>
    			<th>学号</th>
    			<th>姓名</th>
    			<th>性别</th>
    			<th>班级</th>
    			<th>课程</th>
    			<th>成绩</th>
    			<th>
    				<a href="<%=request.getContextPath() %>/content/addScore.jsp" target="content" class="btn btn-primary">添加成绩</a>
    			</th>
    		</tr>
    	</thead>
    	<tbody>
    		<%
				if(scores!=null){
					for (int i = 0; i < scores.size(); i++) {
			%>
			<tr>
				<td>
					<%=scores.get(i).getScore_id() %>
				</td>	
				<td>
					<%=scores.get(i).getId()%>
				</td>
				<td>
					<%=scores.get(i).getName()%>
				</td>
				<td>
					<%=scores.get(i).getSex() %>
				</td>
				<td>
					<%=scores.get(i).getClass_name()%>
				</td>
				<td>
					<%=scores.get(i).getCourse_name()%>
				</td>
				<td>
					<%=scores.get(i).getScore_num()%>
				</td>
				<td>
					<a href="<%=request.getContextPath() %>/content/updateScore.jsp?score_id=<%=scores.get(i).getScore_id() %>&id=<%=scores.get(i).getId()%>&name=<%=scores.get(i).getName()%>&sex=<%=scores.get(i).getSex() %>&class_name=<%=scores.get(i).getClass_name() %>&class_id=<%=scores.get(i).getClass_id()%>&course_name=<%=scores.get(i).getCourse_name()%>&score_num=<%=scores.get(i).getScore_num()%>&course_id=<%=scores.get(i).getCourse_id() %>" class="btn btn-primary" target="content">修改</a>
					<a href="<%=request.getContextPath() %>/servlet/ScoreSelectsServlet?score_id=<%=scores.get(i).getScore_id() %>&operation=delete" class="btn btn-primary">删除</a>
				</td>
			</tr>
			<%
					}
				}
			%>
    	</tbody>
	</table>
  </body>
</html>
