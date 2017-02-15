package com.cjsf.smsst.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cjsf.smsst.bean.ScoreSelects;
import com.cjsf.smsst.utils.DBUtils;

/**
 * @category 学生成绩数据操作类
 * @author Administrator
 */
public class ScoreSelectsDao {

	// 实例化DBUtils
	DBUtils db = new DBUtils();
	//操作结果标识变量
	private boolean result = false;
	
	/**
	 * @author Administrator
	 * @category 添加学生
	 * @param id,name,sex,age,class_id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean addScore(int id, int class_id, int course_id, double score_num){
		db.myGetConnnection();
		String sql = "INSERT INTO score(id,course_id,score_num,class_id) VALUES("+id+","+course_id+","+score_num+","+class_id+")";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	
	public boolean deleteScoreByScore_id(int score_id){
		db.myGetConnnection();
		String sql = "DELETE FROM score where score_id="+score_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return
	 */
	public int gLastPage() {
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM courses AS co JOIN(SELECT s.id,s.name,s.class_id,sc.course_id,sc.score_num FROM students AS s JOIN score AS sc ON s.id=sc.id) AS n ON co.course_id=n.course_id";
		return db.gLastPage(sqln);
	}

	/**
	 * 
	 * @category 查询所有学生成绩
	 * @author Administrator
	 * @return
	 */
	public ArrayList<ScoreSelects> viewScore(int rowsPage,int curPage){
		db.myGetConnnection();
		String sql = "SELECT * FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id ORDER BY stu.id LIMIT "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放成绩信息
		ArrayList<ScoreSelects> big = new ArrayList<ScoreSelects>();
		try{
			while(db.getRes().next())
			{
				//实例化Score
				ScoreSelects ss = new ScoreSelects();
				ss.setScore_id(db.getRes().getInt("score_id"));
				ss.setId(db.getRes().getInt("id"));
				ss.setName(db.getRes().getString("name"));
				ss.setSex(db.getRes().getInt("sex"));
				ss.setClass_id(db.getRes().getInt("class_id"));
				ss.setClass_name(db.getRes().getString("class_name"));
				ss.setCourse_id(db.getRes().getInt("course_id"));
				ss.setCourse_name(db.getRes().getString("course_name"));
				ss.setScore_num(db.getRes().getDouble("score_num"));
				
				
				big.add(ss);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("成绩信息包裹失败!");
			return big;
		}
	}

	/**
	 * @category 根据成绩编号修改成绩
	 * @param score_id,score_num
	 * @author Administrator
	 * @return 
	 */
	public boolean updateScoreByScore_id(int score_id, int score_num) {
		db.myGetConnnection();
		String sql = "update score set score_num="+score_num+" where score_id="+score_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}

	/**
	 * @category 查询指定班级的学生成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(int class_id) {
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+"";
		return db.gLastPage(sqln);
	}

	/**
	 * @category 查询指定班级的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> selectBClass_id(int class_id,int rowsPage,int curPage) {
		db.myGetConnnection();
		String sql = "SELECT * FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" ORDER BY sc.id LIMIT "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放成绩信息
		ArrayList<ScoreSelects> big = new ArrayList<ScoreSelects>();
		try{
			while(db.getRes().next())
			{
				//实例化Score
				ScoreSelects ss = new ScoreSelects();
				ss.setScore_id(db.getRes().getInt("score_id"));
				ss.setId(db.getRes().getInt("id"));
				ss.setName(db.getRes().getString("name"));
				ss.setSex(db.getRes().getInt("sex"));
				ss.setClass_id(db.getRes().getInt("class_id"));
				ss.setClass_name(db.getRes().getString("class_name"));
				ss.setCourse_id(db.getRes().getInt("course_id"));
				ss.setCourse_name(db.getRes().getString("course_name"));
				ss.setScore_num(db.getRes().getDouble("score_num"));
				
				
				big.add(ss);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("成绩信息包裹失败!");
			return big;
		}
	}

	/**
	 * @category 查询指定班级和学生姓名的成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(String name, int class_id) {
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" AND stu.name='"+name+"'";
		return db.gLastPage(sqln);
	}

	/**
	 * @category 查询指定班级的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> selectBNCI(String name, int class_id,int rowsPage,int curPage) {
		db.myGetConnnection();
		String sql = "SELECT * FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" AND stu.name='"+name+"' ORDER BY sc.id LIMIT "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放成绩信息
		ArrayList<ScoreSelects> big = new ArrayList<ScoreSelects>();
		try{
			while(db.getRes().next())
			{
				//实例化Score
				ScoreSelects ss = new ScoreSelects();
				ss.setScore_id(db.getRes().getInt("score_id"));
				ss.setId(db.getRes().getInt("id"));
				ss.setName(db.getRes().getString("name"));
				ss.setSex(db.getRes().getInt("sex"));
				ss.setClass_id(db.getRes().getInt("class_id"));
				ss.setClass_name(db.getRes().getString("class_name"));
				ss.setCourse_id(db.getRes().getInt("course_id"));
				ss.setCourse_name(db.getRes().getString("course_name"));
				ss.setScore_num(db.getRes().getDouble("score_num"));
				
				
				big.add(ss);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("成绩信息包裹失败!");
			return big;
		}
	}

	/**
	 * @category 查询指定班级和学号的学生成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(int id, int class_id) {
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" AND sc.id="+id+"";
		return db.gLastPage(sqln);
	}

	/**
	 * @category 查询指定班级和学号的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> selectBICI(int id, int class_id,int rowsPage,int curPage) {
		db.myGetConnnection();
		String sql = "SELECT * FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" AND sc.id="+id+" ORDER BY sc.id LIMIT "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放成绩信息
		ArrayList<ScoreSelects> big = new ArrayList<ScoreSelects>();
		try{
			while(db.getRes().next())
			{
				//实例化Score
				ScoreSelects ss = new ScoreSelects();
				ss.setScore_id(db.getRes().getInt("score_id"));
				ss.setId(db.getRes().getInt("id"));
				ss.setName(db.getRes().getString("name"));
				ss.setSex(db.getRes().getInt("sex"));
				ss.setClass_id(db.getRes().getInt("class_id"));
				ss.setClass_name(db.getRes().getString("class_name"));
				ss.setCourse_id(db.getRes().getInt("course_id"));
				ss.setCourse_name(db.getRes().getString("course_name"));
				ss.setScore_num(db.getRes().getDouble("score_num"));
				
				
				big.add(ss);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("成绩信息包裹失败!");
			return big;
		}
	}

	/**
	 * @category 查询指定班级和学号姓名的学生成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(int id, String name, int class_id) {
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" AND sc.id="+id+" AND stu.name='"+name+"'";
		return db.gLastPage(sqln);
	}

	/**
	 * @category 查询指定班级和学号姓名的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> SelBINCI(int id, String name, int class_id,int rowsPage,int curPage) {
		db.myGetConnnection();
		String sql = "SELECT * FROM score AS sc LEFT JOIN students AS stu ON sc.id=stu.id LEFT JOIN classs AS cla ON sc.class_id=cla.class_id LEFT JOIN courses AS cou ON sc.course_id=cou.course_id WHERE sc.class_id="+class_id+" AND sc.id="+id+" AND stu.name='"+name+"' ORDER BY sc.id LIMIT "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放成绩信息
		ArrayList<ScoreSelects> big = new ArrayList<ScoreSelects>();
		try{
			while(db.getRes().next())
			{
				//实例化Score
				ScoreSelects ss = new ScoreSelects();
				ss.setScore_id(db.getRes().getInt("score_id"));
				ss.setId(db.getRes().getInt("id"));
				ss.setName(db.getRes().getString("name"));
				ss.setSex(db.getRes().getInt("sex"));
				ss.setClass_id(db.getRes().getInt("class_id"));
				ss.setClass_name(db.getRes().getString("class_name"));
				ss.setCourse_id(db.getRes().getInt("course_id"));
				ss.setCourse_name(db.getRes().getString("course_name"));
				ss.setScore_num(db.getRes().getDouble("score_num"));
				
				
				big.add(ss);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("成绩信息包裹失败!");
			return big;
		}
	}
}
