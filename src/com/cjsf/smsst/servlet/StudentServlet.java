package com.cjsf.smsst.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjsf.smsst.service.StudentsService;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 学生控制类
 * @author Administrator
 */
public class StudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public StudentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");
		
		StudentsService	stus = new StudentsService();
		DBUtils db = new DBUtils();
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
		 * 查询学生信息
		 */
		if(operation.equals("select")){
			lastPage = stus.gLastPage();
			maxPage = db.gMaxPage(lastPage, rowsPage);
			if(curPage<1){
				curPage = 1;
			}
			if(curPage>maxPage){
				curPage = maxPage;
			}
			request.setAttribute("students",stus.viewStudents(rowsPage,curPage));
			request.getSession().setAttribute("curPage",curPage);
			request.getSession().setAttribute("maxPage",maxPage);
			request.getRequestDispatcher("../content/studentsList.jsp").forward(request, response);;
			db.myClose();
		}
		/**
		 * 根据id修改学生信息
		 */
		if(operation.equals("update")){
			int id = Integer.parseInt(request.getParameter("id"));
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			int sex = Integer.parseInt(request.getParameter("sex"));
			int age = Integer.parseInt(request.getParameter("age"));
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			stus.updateStudentById(id, name, sex, age, class_id);
			request.setAttribute("students",stus.viewStudents(rowsPage,curPage));
			RequestDispatcher dispatcher=request.getRequestDispatcher("../content/studentsList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据id删除学生信息
		 */
		if(operation.equals("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			stus.deleteStudentById(id);
			request.setAttribute("students",stus.viewStudents(rowsPage,curPage));
			RequestDispatcher dispatcher=request.getRequestDispatcher("../content/studentsList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 添加学生
		 */
		if(operation.equals("add")){
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			int sex = Integer.parseInt(request.getParameter("sex"));
			int age = Integer.parseInt(request.getParameter("age"));
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			stus.addStudent(name, sex, age, class_id);
			request.setAttribute("students",stus.viewStudents(rowsPage,curPage));
			RequestDispatcher dispatcher=request.getRequestDispatcher("../content/studentsList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据账号和班级模糊查找学生
		 */
		if(operation.equals("selBNC")){
			
			String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			request.getSession().setAttribute("students1",stus.selBNC(name, class_id));
			request.getRequestDispatcher("../content/student.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
