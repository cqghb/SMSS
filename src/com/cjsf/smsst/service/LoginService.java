package com.cjsf.smsst.service;

import java.util.ArrayList;

import com.cjsf.smsst.bean.Admin;
import com.cjsf.smsst.dao.LoginDao;
/**
 * @category service层用户登录相关逻辑操作类
 * @author Administrator
 */
public class LoginService {

	//实例化LoginDao
	LoginDao ld = new LoginDao();
	//操作结果标识变量
	private boolean result = false;
	
	/**
	 * @category 根据id修改用户信息
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public boolean updateById(int name,String password,int id){
		return ld.updateById(name,password,id);
	}
	
	/**
	 * @category 根据id查找用户
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public ArrayList<Admin> selById(int id){
		return ld.selById(id);
	}
	/**
	 * @category 根据账号和密码查询登录用户信息
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public ArrayList<Admin> admin(int name,String password){
		return ld.admin(name,password);
	}
	/**
	 * @category 用户登录
	 * @author Administrator
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean LoginByNP(int name,String password){
		if(ld.LoginByNP(name, password)){
			result = true;
		}else{
			result = false;
		}
		return result;
	}
	/**
	 * @category 添加用户
	 * @author Administrator
	 * @param name,password
	 * @return boolean{true:添加班级成功,false:添加班级失败}
	*/
	public boolean addUser(int name,String password){
		result = ld.addUser(name,password);
		return result;
	}
	
	/**
	 * @category 根据id删除班级
	 * @author Administrator
	 * @param class_id
	 * @return boolean{true:班级删除成功,false:班级删除失败}
	
	public boolean deleteClassById(int class_id){
		result = cd.deleteClassById(class_id);
		return result;
	}
	 */
	/**
	 * @category 根据班级id修改班级名称
	 * @author Administrator
	 * @param class_id,class_name
	 * @return boolean{true:修改班级成功,false:修改班级失败}
	 
	public boolean updateClassById(int class_id,String class_name){
		result = cd.updateClassById(class_id, class_name);
		return result;
	}
	*/
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return
	public int gLastPage(){
		return cd.gLastPage();
	}
	*/
	/**
	 * @category 查询班级信息
	 * @author Administrator
	 * @return 班级信息集合
	 
	public ArrayList<Classs> viewClass(int rowsPage,int curPage){
		return cd.viewClass(rowsPage,curPage);
	}
	*/
}
