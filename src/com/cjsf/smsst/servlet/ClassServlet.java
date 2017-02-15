package com.cjsf.smsst.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjsf.smsst.service.ClassService;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 班级控制类
 * @author Administrator
 */
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ClassServlet() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//操作指示变量
		String operation = request.getParameter("operation");
		//实例化DBUtils
		DBUtils db = new DBUtils();
		//实例化ClassService
		ClassService cs = new ClassService();
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
			request.setAttribute("classs", cs.viewClass(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/classList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据id修改班级信息
		 */
		if(operation.equals("update")){
			//接收页面传过来的班级id
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			//接收页面传过来的班级名称
			String class_name = new String(request.getParameter("class_name").getBytes("ISO-8859-1"),"UTF-8");
			cs.updateClassById(class_id, class_name);
			db.myClose();
			//再次执行查询所有班级
			request.setAttribute("classs", cs.viewClass(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/classList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据id删除班级
		 */
		if(operation.equals("delete")){
			//接收页面传过来的班级id
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			cs.deleteClassById(class_id);
			db.myClose();
			//再次执行查询所有班级
			request.setAttribute("classs", cs.viewClass(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/classList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 添加班级
		 */
		if(operation.equals("add")){
			//接收页面传过来的班级名称
			String class_name = new String(request.getParameter("class_name").getBytes("ISO-8859-1"),"UTF-8");
			cs.addClass(class_name);
			db.myClose();
			//再次执行查询所有班级
			request.setAttribute("classs", cs.viewClass(rowsPage,curPage));
			RequestDispatcher dispatcher = request.getRequestDispatcher("../content/classList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据班级编号查询班级信息
		 */
		if(operation.equals("selBClassId")){
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			request.setAttribute("c", cs.selectByClassId(class_id));
			request.getRequestDispatcher("../content/class.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}

}
