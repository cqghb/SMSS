package com.cjsf.smsst.service;

import java.util.ArrayList;

import com.cjsf.smsst.bean.Courses;
import com.cjsf.smsst.dao.CoursesDao;
/**
 * @category service层课程相关操作类
 * @author Administrator
 *
 */
public class CoursesService {

	//实例化CoursesDao
	CoursesDao cd = new CoursesDao();
	//操作结果标识变量
	private boolean result = false;
	/**
	 * @category 根据课程名称查询课程信息
	 * @author Administrator
	 * @param course_name
	 * @return
	 */
	public ArrayList<Courses> selBCoueName(String course_name){
		return cd.selBCoueName(course_name);
	}
	/**
	 * @category 添加课程信息
	 * @author Administrator
	 * @param courses_name
	 * @return boolean{true:课程信息添加成功,false:课程信息添加失败}
	 */
	public boolean addCourse(String course_name){
		result = cd.addCourse(course_name);
		return result;
	}
	
	/**
	 * @category 根据课程编号删除课程信息
	 * @author Administrator
	 * @param courses_id
	 * @return boolean{true:课程信息删除成功,false:课程信息删除失败}
	 */
	public boolean deleteCourseById(int course_id){
		result = cd.deleteCourseById(course_id);
		return result;
	}
	
	/**
	 * @category 根据课程编号修改课程信息
	 * @author Administrator
	 * @param courses_id,courses_name
	 * @return boolean{true:课程信息修改成功,false:课程信息修改失败}
	 */
	public boolean updateCourseById(int course_id,String course_name){
		result = cd.updateCourseById(course_id, course_name);
		return result;
	}
	
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return
	 */
	public int gLastPage(){
		return cd.gLastPage();
	}
	/**
	 * @category 查询所有课程信息
	 * @author Administrator
	 * @return 课程结果集
	 */
	public ArrayList<Courses> viewCourses(int rowsPage,int curPage){
		return cd.viewCourses(rowsPage,curPage);
	}
}
