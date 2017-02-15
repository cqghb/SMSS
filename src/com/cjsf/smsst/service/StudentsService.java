package com.cjsf.smsst.service;

import java.util.ArrayList;

import com.cjsf.smsst.bean.Students;
import com.cjsf.smsst.dao.StudentsDao;
/**
 * @category service层学生相关逻辑操作类
 * @author Administrator
 */
public class StudentsService {
	//实例化StudentsDao
	StudentsDao stud = new StudentsDao();
	//操作结果标识变量
	private boolean result = false;
	
	
	/**
	 * @category 获取指定姓名和班级的学生的个数
	 * @author Administrator
	 * @param name
	 * @param class_id
	 * @return
	 */
	public int gLastPage(String name,int class_id){
		return stud.gLastPage(name, class_id);
	}
	
	/**
	 * @category 根据账号和班级编号模糊查找学生
	 * @author Administrator
	 * @param name
	 * @param class_id
	 * @return
	 */
	public ArrayList<Students> selBNC(int rowsPage,int curPage,String name,int class_id){
		return stud.selBNC(rowsPage, curPage, name, class_id);
	}
	/**
	 * @category 根据账号和班级编号查找学生
	 * @author Administrator
	 * @param name
	 * @param class_id
	 * @return
	 */
	public ArrayList<Students> selBNC(String name,int class_id){
		return stud.selBNC(name, class_id);
	}
	/**
	 * @author Administrator
	 * @category 添加学生
	 * @param id,name,sex,age,class_id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean addStudent(String name,int sex,int age,int class_id){
		result = stud.addStudent(name, sex, age, class_id);
		return result;
	}
	/**
	 * @author Administrator
	 * @category 根据id删除学生
	 * @param id
	 * @return boolean{true:成功,false:失败}
	 */
	public boolean deleteStudentById(int id){
		result = stud.deleteStudentById(id);
		return result;
	}
	/**
	 * @author Administrator
	 * @category 修改学生信息
	 * @param id,name,sex,age,class_id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean updateStudentById(int id,String name,int sex,int age,int class_id){
		result = stud.updateStudentById(id, name, sex, age, class_id);
		return result;
	}
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return
	 */
	public int gLastPage(){
		return stud.gLastPage();
	}
	
	
	/**
	 * @category 查询学生信息
	 * @author Administrator
	 * @return
	 */
	public ArrayList<Students> viewStudents(int rowsPage,int curPage){
		return stud.viewStudents(rowsPage,curPage);
	}
}
