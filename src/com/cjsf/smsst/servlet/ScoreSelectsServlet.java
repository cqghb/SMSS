package com.cjsf.smsst.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cjsf.smsst.service.ScoreSelectsService;
import com.cjsf.smsst.bean.ScoreSelects;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 学生成绩控制类
 * @author Administrator
 *
 */
public class ScoreSelectsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ScoreSelectsServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//操作指示变量
		String operation = request.getParameter("operation");
		//实例化ScoreSelectsService
		ScoreSelectsService sss = new ScoreSelectsService();
		//实例化DBUtils
		DBUtils db = new DBUtils();
		ArrayList<ScoreSelects> scores = new ArrayList<ScoreSelects>();
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
		lastPage = sss.gLastPage();
		maxPage = db.gMaxPage(lastPage, rowsPage);
		if(curPage<1){
			curPage = 1;
		}
		if(curPage>maxPage){
			curPage = maxPage;
		}
		request.setAttribute("curPage",curPage);
		request.setAttribute("maxPage",maxPage);
		/**
		 * 查看所有成绩信息
		 */
		if(operation.equals("select")){
			request.setAttribute("scores",sss.viewScore(rowsPage,curPage));
			RequestDispatcher dispatcher=request.getRequestDispatcher("../content/scoresList.jsp");
			dispatcher.forward(request, response);
			db.myClose();
		}
		/**
		 * 根据成绩编号修改成绩
		 */
		if(operation.equals("update")){
			boolean result = false;
			//接收页面传过来的成绩编号
			int score_id = Integer.parseInt(request.getParameter("score_id"));
			int score_num = Integer.parseInt(request.getParameter("score_num"));
			result = sss.updateScoreByScore_id(score_id,score_num);
			request.setAttribute("scores",sss.viewScore(rowsPage,curPage));
			if(result){
				RequestDispatcher dispatcher=request.getRequestDispatcher("../content/scoresList.jsp");
				dispatcher.forward(request, response);
				db.myClose();
			}else{
				db.myClose();
				request.getRequestDispatcher("../content/scoresList.jsp").forward(request, response);
			}
		}
		/**
		 * 根据成绩编号删除成绩
		 */
		if(operation.equals("delete")){
			boolean result = false;
			int score_id = Integer.parseInt(request.getParameter("score_id"));
			result = sss.deleteScoreByScore_id(score_id);
			request.setAttribute("scores",sss.viewScore(rowsPage,curPage));
			if(result){
				request.getRequestDispatcher("../content/scoresList.jsp").forward(request, response);
				db.myClose();
			}else{
				db.myClose();
				request.getRequestDispatcher("../content/scoresList.jsp").forward(request, response);
			}
		}
		/**
		 * 添加学生成绩
		 */
		if(operation.equals("add")){
			boolean result = false;
			int id = Integer.parseInt(request.getParameter("id"));
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			double score_num = Double.parseDouble(request.getParameter("score_num"));
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			result = sss.addScore(id,class_id,course_id,score_num);
			request.setAttribute("scores",sss.viewScore(rowsPage,curPage));
			if(result){
				request.getRequestDispatcher("../content/scoresList.jsp").forward(request, response);
				db.myClose();
			}else{
				db.myClose();
				request.getRequestDispatcher("../content/scoresList.jsp").forward(request, response);
			}
		}
		//根据条件查询学成绩信息
		if(operation.equals("query")){
			int class_id = Integer.parseInt(request.getParameter("class_id"));
			if(request.getParameter("id")==null||request.getParameter("id").equals("")){
				if(request.getParameter("name")==null||request.getParameter("name").equals("")){
					lastPage = sss.gLastPageBZD(class_id);
					if(request.getParameter("curPage")==null){
						curPage = 1;
					}else{
						curPage = Integer.parseInt(request.getParameter("curPage"));
					}
					maxPage = db.gMaxPage(lastPage, rowsPage);
					if(curPage<1){
						curPage = 1;
					}
					if(curPage>maxPage){
						curPage = maxPage;
					}
					
					//班级来查
					scores = sss.selectBClass_id(class_id,rowsPage,curPage);
					request.setAttribute("scores",scores);
					request.setAttribute("curPage",curPage);
					request.setAttribute("maxPage",maxPage);
					request.setAttribute("class_id",class_id);
					request.getRequestDispatcher("../content/serchScoresClassId.jsp").forward(request, response);
					db.myClose();
				}else{
					String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
					//班级和姓名来查
					scores = sss.selectBNCI(name,class_id,rowsPage,curPage);
					request.setAttribute("scores",scores);
					request.getRequestDispatcher("../content/serchScoresList.jsp").forward(request, response);
					db.myClose();
				}
			}else if(request.getParameter("name")==null||request.getParameter("name").equals("")){
				int id = Integer.parseInt(request.getParameter("id"));
				//学号和班级来查
				scores = sss.selectBICI(id,class_id,rowsPage,curPage);
				request.setAttribute("scores",scores);
				request.getRequestDispatcher("../content/serchScoresList.jsp").forward(request, response);
				db.myClose();
			}else{
				
				int id = Integer.parseInt(request.getParameter("id"));
				String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
				//学号班级姓名来查
				scores = sss.SelBINCI(id,name,class_id,rowsPage,curPage);
				request.setAttribute("scores",scores);
				request.getRequestDispatcher("../content/serchScoresList.jsp").forward(request, response);
				db.myClose();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
	}

}
