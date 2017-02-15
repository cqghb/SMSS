package com.cjsf.smsst.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cjsf.smsst.bean.Courses;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category dao层课程相关操作类
 * @author Administrator
 *
 */
public class CoursesDao {
	
	//实例化DBUtils
	DBUtils db = new DBUtils();
	//操作结果标识变量
	private boolean result = false;
	/**
	 * @category 根据课程名称查询课程信息
	 * @author Administrator
	 * @param course_name
	 * @return
	 */
	public ArrayList<Courses> selBCoueName(String course_name){
		db.myGetConnnection();
		String sql = "select * from courses where course_name='"+course_name+"'";
		db.myExecuteQuery(sql);
		ArrayList<Courses> cour = new ArrayList<Courses>();
		try {
			if(db.getRes().next()){
				Courses c = new Courses();
				c.setCourse_id(db.getRes().getInt(1));
				c.setCourse_name(db.getRes().getString(2));
				cour.add(c);
			}
			return cour;
		} catch (SQLException e) {
			return null;
		}
		
	}
	/**
	 * @category 添加课程信息
	 * @author Administrator
	 * @param courses_name
	 * @return boolean{true:课程信息添加成功,false:课程信息添加失败}
	 */
	public boolean addCourse(String course_name){
		db.myGetConnnection();
		String sql = "INSERT INTO courses(course_name) VALUES('"+course_name+"')";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	
	/**
	 * @category 根据课程编号删除课程信息
	 * @author Administrator
	 * @param courses_id
	 * @return boolean{true:课程信息删除成功,false:课程信息删除失败}
	 */
	public boolean deleteCourseById(int course_id){
		db.myGetConnnection();
		String sql = "DELETE FROM courses WHERE course_id="+course_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return
	 */
	public int gLastPage(){
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM courses";
		return db.gLastPage(sqln);
	}
	/**
	 * @author Administrator
	 * @category 根据课程编号修改课程信息
	 * @param course_id,course_name
	 * @return boolean{true:课程信息修改成功,false:课程信息修改失败}
	 */
	public boolean updateCourseById(int course_id,String course_name){
		db.myGetConnnection();
		String sql = "UPDATE courses SET course_name='"+course_name+"' WHERE course_id="+course_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	
	/**
	 * @category 查询所有课程信息
	 * @author Administrator
	 * @throws 课程信息包裹失败
	 * @exception SQLException
	 * @return 课程结果集
	 */
	public ArrayList<Courses> viewCourses(int rowsPage,int curPage){
		db.myGetConnnection();
		
		String sql = "select * from courses order by course_id limit "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放课程信息
		ArrayList<Courses> big = new ArrayList<Courses>();
		try{
			while(db.getRes().next())
			{
				//实例化Courses
				Courses c = new Courses();
				c.setCourse_id(db.getRes().getInt(1));
				c.setCourse_name(db.getRes().getString(2));
				big.add(c);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("课程信息包裹失败!");
			return null;
		}
	}
}
