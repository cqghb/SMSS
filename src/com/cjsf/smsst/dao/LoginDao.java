package com.cjsf.smsst.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cjsf.smsst.bean.Admin;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 用户登录数据相关处理类
 * @author Administrator
 */
public class LoginDao {
	//实例化DBUtils
	DBUtils db = new DBUtils();
	//操作结果标识变量
	private boolean result = false;
	/**
	 * @category 根据id修改用户信息
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public boolean updateById(int name,String password,int id){
		db.myGetConnnection();
		String sql = "UPDATE admin SET name="+name+",password='"+password+"' where id="+id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	/**
	 * @category 根据id查找用户
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public ArrayList<Admin> selById(int id){
		db.myGetConnnection();
		String sql = "select * from admin where id="+id+"";
		db.myExecuteQuery(sql);
		ArrayList<Admin> ads = new ArrayList<Admin>();
		try {
			if(db.getRes().next()){
				Admin a = new Admin();
				a.setId(db.getRes().getInt(1));
				a.setName(db.getRes().getInt(2));
				a.setPassword(db.getRes().getString(3));
				ads.add(a);
			}
			return ads;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	 * @category 根据账号和密码查询登录用户信息
	 * @author Administrator
	 * @param id
	 * @return
	 */
	public ArrayList<Admin> admin(int name,String password){
		db.myGetConnnection();
		String sql = "select * from admin where name="+name+" and password='"+password+"'";
		db.myExecuteQuery(sql);
		ArrayList<Admin> ads = new ArrayList<Admin>();
		try {
			if(db.getRes().next()){
				Admin a = new Admin();
				a.setId(db.getRes().getInt(1));
				a.setName(db.getRes().getInt(2));
				a.setPassword(db.getRes().getString(3));
				ads.add(a);
				
			}
			return ads;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	 * @category 用户登录
	 * @author Administrator
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean LoginByNP(int name,String password){
		db.myGetConnnection();
		String sql = "SELECT * FROM admin WHERE name='"+name+"' AND password='"+password+"'";
		db.myExecuteQuery(sql);
		try {
			if(db.getRes().next()){
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
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
		db.myGetConnnection();
		String sql = "INSERT INTO admin(name,password) VALUES("+name+",'"+password+"')";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	 
	/**
	 * @category 根据id删除班级
	 * @author Administrator
	 * @param class_id
	 * @return boolean{true:班级删除成功,false:班级删除失败}
	 
	public boolean deleteClassById(int class_id){
		db.myGetConnnection();
		String sql = "DELETE FROM classs WHERE class_id="+class_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	*/
	/**
	 * @category 根据班级id修改班级名称
	 * @author Administrator
	 * @param class_id,class_name
	 * @return boolean{true:修改班级成功,false:修改班级失败}
	 
	public boolean updateClassById(int class_id,String class_name){
		db.myGetConnnection();
		String sql = "UPDATE classs SET class_name='"+class_name+"' WHERE class_id="+class_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}*/
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return
	
	public int gLastPage(){
		db.myGetConnnection();
		String sqln = "SELECT COUNT(*) FROM classs";
		return db.gLastPage(sqln);
	}
	 */
	/**
	 * @throws 班级数据包裹异常
	 * @exception SQLException
	 * @author Administrator
	 * @category 查询所有班级信息
	 * @return 班级信息集合
	 
	public ArrayList<Classs> viewClass(int rowsPage,int curPage){
		db.myGetConnnection();
		String sql = "select * from classs order by class_id limit "+((curPage-1)*rowsPage)+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放班级信息
		ArrayList<Classs> big = new ArrayList<Classs>();
		try{
			while(db.getRes().next())
			{
				//实例化Classs
				Classs c = new Classs();
				c.setClass_id(db.getRes().getInt(1));
				c.setClass_name(db.getRes().getString(2));
				big.add(c);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("班级信息包裹失败!");
			return null;
		}
	}
*/
}
