package com.cjsf.smsst.service;

import java.util.ArrayList;

import com.cjsf.smsst.bean.Classs;
import com.cjsf.smsst.dao.ClassDao;
/**
 * @category service层班级相关逻辑操作类
 * @author Administrator
 */
public class ClassService {

	//实例化ClassDao
	ClassDao cd = new ClassDao();
	//操作结果标识变量
	private boolean result = false;
	/**
	 * @category 根据班级编号查询班级信息
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<Classs> selectByClassId(int class_id){
		return cd.selectByClassId(class_id);
	}
	/**
	 * @category 添加班级
	 * @author Administrator
	 * @param class_name
	 * @return boolean{true:添加班级成功,false:添加班级失败}
	 */
	public boolean addClass(String class_name){
		result = cd.addClass(class_name);
		return result;
	}
	
	/**
	 * @category 根据id删除班级
	 * @author Administrator
	 * @param class_id
	 * @return boolean{true:班级删除成功,false:班级删除失败}
	 */
	public boolean deleteClassById(int class_id){
		result = cd.deleteClassById(class_id);
		return result;
	}
	
	/**
	 * @category 根据班级id修改班级名称
	 * @author Administrator
	 * @param class_id,class_name
	 * @return boolean{true:修改班级成功,false:修改班级失败}
	 */
	public boolean updateClassById(int class_id,String class_name){
		result = cd.updateClassById(class_id, class_name);
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
	 * @category 查询班级信息
	 * @author Administrator
	 * @return 班级信息集合
	 */
	public ArrayList<Classs> viewClass(int rowsPage,int curPage){
		return cd.viewClass(rowsPage,curPage);
	}
}
