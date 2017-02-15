<%@ page language="java" import="java.util.*,com.cjsf.smsst.bean.Classs" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>class page</title>
    
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
    	ArrayList<Classs> c = (ArrayList)request.getAttribute("c");
    %>
    <table class="table table-striped table-bordered table-hover table-responsive">
    	<thead>
    		<tr>
    			<th>班级编号</th>
    			<th>班级名称</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr>
    			<td>
    				<%=c.get(0).getClass_id() %>
    			</td>
    			<td>
    				<%=c.get(0).getClass_name() %>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2">
    			  	 <a target="content" href="<%=request.getContextPath()%>/servlet/ClassServlet?operation=select" class="btn btn-info">返回</a>
    			</td>
    		</tr>
    	</tbody>
    </table>
    
  </body>
</html>
