package com.cjsf.smsst.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cjsf.smsst.service.LoginService;
import com.cjsf.smsst.utils.DBUtils;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		
		boolean result = false;
		String operation = request.getParameter("operation");
		DBUtils db = new DBUtils();
		LoginService ls = new LoginService();
		
		
//		//获得当前页码
//		int curPage = db.getCurPage();
//		//获得每一页要显示的条数
//		int rowsPage = db.getRowsPage();
//		//获得最大页码
//		int maxPage = db.getMaxPage();
//		//获得表中数据的总条数
//		int lastPage = db.getLastPage();
//		if(request.getParameter("curPage")==null){
//			curPage = 1;
//		}else{
//			curPage = Integer.parseInt(request.getParameter("curPage"));
//		}
		/**
		 * 用户登录
		 */
		if(operation.equals("login")){
			int name = Integer.parseInt(request.getParameter("name"));
			String password1 = new String(request.getParameter("password1").getBytes("ISO-8859-1"),"UTF-8");
			if(ls.LoginByNP(name, password1)){
				request.getSession().setAttribute("admin", ls.admin(name, password1));
				response.sendRedirect("../index.jsp");
			}else{
				response.sendRedirect("../login.jsp");
			}
			db.myClose();
		}
		/**
		 * 添加用户
		 */
		if(operation.equals("add")){
			int name = Integer.parseInt(request.getParameter("name"));
			String password1 = new String(request.getParameter("password1").getBytes("ISO-8859-1"),"UTF-8");
			//String password2 = new String(request.getParameter("password2").getBytes("ISO-8859-1"),"UTF-8");
			result = ls.addUser(name, password1);
			if(result){
				response.sendRedirect("../login.jsp");
			}else{
				response.sendRedirect("../admin/addUser.jsp");
			}
		}
		/**
		 * 根据id查看用户
		 */
		if(operation.equals("selectById")){
			int id = Integer.parseInt(request.getParameter("id"));
			request.getSession().setAttribute("ad", ls.selById(id));
			response.sendRedirect("../admin/admin.jsp");
		}
		
		if(operation.equals("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			int name = Integer.parseInt(request.getParameter("name"));
			String password1 = new String(request.getParameter("password1").getBytes("ISO-8859-1"),"UTF-8");
			//request.getSession().setAttribute("admin",ls.updateById(name,password1,id));
			boolean a = ls.updateById(name,password1,id);
			if(a){
				request.getSession().setAttribute("ad", ls.selById(id));
				//request.getSession().setAttribute("admin", ls.admin(name, password1));
				response.sendRedirect("../main/content.jsp");
			}
			
		}
		//用户注销
		if(operation.equals("deleSession")){
			HttpSession httpsession = request.getSession();
			httpsession.invalidate();
			response.sendRedirect("../login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
