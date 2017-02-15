package com.cjsf.smsst.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cjsf.smsst.bean.Classs;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 班级数据相关处理类
 * @author Administrator
 */
public class ClassDao {
	//实例化DBUtils
	DBUtils db = new DBUtils();
	//操作结果标识变量
	private boolean result = false;
	/**
	 * @category 根据班级编号查询班级信息
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<Classs> selectByClassId(int class_id){
		db.myGetConnnection();
		String sql = "select * from classs where class_id="+class_id+"";
		db.myExecuteQuery(sql);
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
	/**
	 * @category 添加班级
	 * @author Administrator
	 * @param class_name
	 * @return boolean{true:添加班级成功,false:添加班级失败}
	 */
	public boolean addClass(String class_name){
		db.myGetConnnection();
		String sql = "INSERT INTO classs(class_name) VALUES('"+class_name+"')";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	
	/**
	 * @category 根据id删除班级
	 * @author Administrator
	 * @param class_id
	 * @return boolean{true:班级删除成功,false:班级删除失败}
	 */
	public boolean deleteClassById(int class_id){
		db.myGetConnnection();
		String sql = "DELETE FROM classs WHERE class_id="+class_id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	
	/**
	 * @category 根据班级id修改班级名称
	 * @author Administrator
	 * @param class_id,class_name
	 * @return boolean{true:修改班级成功,false:修改班级失败}
	 */
	public boolean updateClassById(int class_id,String class_name){
		db.myGetConnnection();
		String sql = "UPDATE classs SET class_name='"+class_name+"' WHERE class_id="+class_id+"";
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
		String sqln = "SELECT COUNT(*) FROM classs";
		return db.gLastPage(sqln);
	}
	/**
	 * @throws 班级数据包裹异常
	 * @exception SQLException
	 * @author Administrator
	 * @category 查询所有班级信息
	 * @return 班级信息集合
	 */
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

}
