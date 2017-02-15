package com.cjsf.smsst.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cjsf.smsst.bean.Students;
import com.cjsf.smsst.utils.DBUtils;
/**
 * @category 学生表操作类
 * @author Administrator
 *
 */
public class StudentsDao {
	//实例化DBUtils
	DBUtils db = new DBUtils();
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
		db.myGetConnnection();
		String sqln = "SELECT * FROM students WHERE name LIKE '"+name+"%' AND class_id="+class_id+"";
		return db.gLastPage(sqln);
	}
	/**
	 * @category 根据账号和班级编号模糊查找学生
	 * @author Administrator
	 * @param name
	 * @param class_id
	 * @return
	 */
	public ArrayList<Students> selBNC(int rowsPage,int curPage,String name,int class_id){
		db.myGetConnnection();
		String sql = "select * from students order by id limit "+((curPage-1)*rowsPage)+","+rowsPage+" WHERE name LIKE '"+name+"%' AND class_id="+class_id+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放学生信息
		ArrayList<Students> big = new ArrayList<Students>();
		try{
			while(db.getRes().next())
			{
				//实例化Students
				Students s = new Students();
				s.setId(db.getRes().getInt(1));
				s.setName(db.getRes().getString(2));
				s.setSex(db.getRes().getInt(3));
				s.setAge(db.getRes().getInt(4));
				s.setClass_id(db.getRes().getInt(5));
				big.add(s);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("学生信息包裹失败!");
			return null;
		}
	}
	/**
	 * @category 根据账号和班级编号查找学生
	 * @author Administrator
	 * @param name
	 * @param class_id
	 * @return
	 */
	public ArrayList<Students> selBNC(String name,int class_id){
		db.myGetConnnection();
		String sql = "select * from students where name='"+name+"' and class_id="+class_id+"";
		db.myExecuteQuery(sql);
		ArrayList<Students> stu = new ArrayList<Students>();
		try {
			//实例化Students
			Students s = new Students();
			if(db.getRes().next()){
				
				s.setId(db.getRes().getInt(1));
				s.setName(db.getRes().getString(2));
				s.setSex(db.getRes().getInt(3));
				s.setAge(db.getRes().getInt(4));
				s.setClass_id(db.getRes().getInt(5));
				stu.add(s);
			}else{
				s.setId(0);
				s.setName("NULL");
				s.setSex(0);
				s.setAge(0);
				s.setClass_id(0);
				stu.add(s);
			}
			return stu;
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * @author Administrator
	 * @category 添加学生
	 * @param id,name,sex,age,class_id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean addStudent(String name,int sex,int age,int class_id){
		db.myGetConnnection();
		String sql = "INSERT INTO students(name,sex,age,class_id) VALUES('"+name+"',"+sex+","+age+","+class_id+")";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	/**
	 * @author Administrator
	 * @category 根据id删除学生
	 * @param id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean deleteStudentById(int id){
		db.myGetConnnection();
		String sql = "DELETE FROM students WHERE id="+id+"";
		result = db.myExecuteUpdate(sql);
		return result;
	}
	/**
	 * @author Administrator
	 * @category 修改学生信息
	 * @param id,name,sex,age,class_id
	 * @return boolean true:成功，false:失败
	 */
	public boolean updateStudentById(int id,String name,int sex,int age,int class_id){
		 db.myGetConnnection();
		 String sql = "UPDATE students SET name='"+name+"',sex="+sex+",age="+age+",class_id="+class_id+" WHERE id="+id+"";
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
		String sqln = "SELECT COUNT(*) FROM students";
		return db.gLastPage(sqln);
	}
	
	/**
	 * @throws sql语句有误
	 * @exception SQLException
	 * @author Administrator
	 * @category 查询学生信息
	 * @return 学生集合
	 */
	public ArrayList<Students> viewStudents(int rowsPage,int curPage){
		int begin = (curPage-1)*rowsPage;
		String sql = "select * from students order by id limit "+begin+","+rowsPage+"";
		db.myExecuteQuery(sql);
		//实例化ArrayList存放学生信息
		ArrayList<Students> big = new ArrayList<Students>();
		
		try{
			while(db.getRes().next())
			{
				//实例化Students
				Students s = new Students();
				s.setId(db.getRes().getInt(1));
				s.setName(db.getRes().getString(2));
				s.setSex(db.getRes().getInt(3));
				s.setAge(db.getRes().getInt(4));
				s.setClass_id(db.getRes().getInt(5));
				big.add(s);
			}
			return big;
		}catch (SQLException e) {
			System.out.println("学生信息包裹失败!");
			return null;
		}
	}
}
