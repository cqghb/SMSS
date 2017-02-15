package com.cjsf.smsst.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjsf.smsst.service.CoursesService;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 课程控制类
 * @author Administrator
 */
public class CoursesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CoursesServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//操作指示变量
		String operation = request.getParameter("operation");
		//实例化DBUtils
		DBUtils db = new DBUtils();
		//实例化ClassService
		CoursesService cs = new CoursesService();
		//获得当前页码
		int curPage = db.getCurPage();
		//获得每一页要显示的条数
		int rowsPage = db.getRowsPage();
		//获得最大页码
		int maxPage = db.getMaxPage();
		//获得表中数据的总条数
		int lastPage = db.getLastPage();
		if(request.getParameter("curPage")==null){
			curPage = 1;
		}else{
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		/**
		 * 查看所有班级信息
		 */
		if(operation.equals("select")){
			lastPage = cs.gLastPage();
			maxPage = db.gMaxPage(lastPage, rowsPage);
			if(curPage<1){
				curPage = 1;
			}
			if(curPage>maxPage){
				curPage = maxPage;
			}
			request.getSession().setAttribute("curPage",curPage);
			request.getSession().setAttribute("maxPage",maxPage);
			request.setAttribute("course", cs.viewCourses(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/coursesList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据id修改班级信息
		 */
		if(operation.equals("update")){
			//接收页面传过来的班级id
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			//接收页面传过来的班级名称
			String course_name = new String(request.getParameter("course_name").getBytes("ISO-8859-1"),"UTF-8");
			cs.updateCourseById(course_id, course_name);
			db.myClose();
			//再次执行查询所有班级
			request.setAttribute("course", cs.viewCourses(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/coursesList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据id删除班级
		 */
		if(operation.equals("delete")){
			//接收页面传过来的班级id
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			cs.deleteCourseById(course_id);
			db.myClose();
			//再次执行查询所有班级
			request.setAttribute("course", cs.viewCourses(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/coursesList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 添加班级
		 */
		if(operation.equals("add")){
			//接收页面传过来的班级名称
			String course_name = new String(request.getParameter("course_name").getBytes("ISO-8859-1"),"UTF-8");
			cs.addCourse(course_name);
			db.myClose();
			//再次执行查询所有班级
			request.setAttribute("course", cs.viewCourses(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/coursesList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据课程名称查询课程信息
		 */
		if(operation.equals("selBCourName")){
			String course_name = new String(request.getParameter("course_name").getBytes("ISO-8859-1"),"UTF-8");
			System.out.println("课程名"+course_name);
			request.setAttribute("course", cs.selBCoueName(course_name));
			request.getRequestDispatcher("../content/course.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

	public void init() throws ServletException {
	}

}
