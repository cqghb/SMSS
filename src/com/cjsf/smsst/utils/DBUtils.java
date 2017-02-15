package com.cjsf.smsst.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @category  数据库操作工具类
 * @author Administrator
 *
 */
public class DBUtils {
	//当前页码
	private int curPage = 0;
	//每一页显示的数据条数
	private int rowsPage = 6;
	//最大页数
	private int maxPage = 0;
	//数据总条数
	private int lastPage = 0;
	private static Connection conn = null;
	private static Statement sta = null;
	private static ResultSet res = null;
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String uri = "jdbc:mysql://localhost/smss?user=root&password=helloser&useUnicode=true&characterEncoding=UTF-8";
	
	
	/**
	 * @author Administrator
	 * @category加载驱动，连接数据库
	 * @exception ClassNotFoundException，SQLException
	 * @throws 驱动文件未找到，或者连接数据库的地址信息有误
	 * @return conn
	 */
	public Connection myGetConnnection(){
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败!");
		}
		try {
			conn = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			System.out.println("数据库连接失败!");
		}
		return conn;
	}
	/**
	 * @category 获得该表的记录数目
	 * @author Administrator
	 * @param sql
	 * @return
	 */
	public int gLastPage(String sql){
		try {
			sta = conn.createStatement();
			res = sta.executeQuery(sql);
			if(res.next()){
				lastPage = res.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("sql执行失败!");
		}
		return lastPage;
	}
	/**
	 * @category 获取最大页码
	 * @author Administrator
	 * @param lastPage
	 * @param rowsPage
	 * @return
	 */
	public int gMaxPage(int lastPage,int rowsPage){
		if(lastPage%rowsPage==0){
			maxPage = lastPage/rowsPage;
		}
		if(lastPage%rowsPage!=0){
			maxPage = lastPage/rowsPage+1;
		}
		return maxPage;
	}
	
	
//	public int getCurPage(int lastPage){
//		if(){}
//	}
	/**
	 * @author Administrator
	 * @category 查询数据信息
	 * @exception SQLException
	 * @throws sql有误执行失败
	 * @param sql
	 */
	public void myExecuteQuery(String sql){
		try {
			sta = conn.createStatement();
			res = sta.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql执行失败!");
		}
		
	}
	
	/**
	 * @author Administrator
	 * @category  得到数据查询结果集
	 * @return res
	 */
	public ResultSet getRes(){
		return res;
	}
	/**
	 * @author Administrator
	 * @category 修改数据
	 * @exception SQLException
	 * @throws sql有误，执行失败
	 * @param sql
	 * @return 真 (成功)假(失败)
	 */
	public boolean myExecuteUpdate(String sql){
		boolean result = false;
		int num = -1;
		try {
			sta = conn.createStatement();
			num = sta.executeUpdate(sql);
			if(num>0){
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("sql执行失败!");
			result = false;
		}
		return result;
	}
	/**
	 * @category 关闭数据库连接
	 * @author Administrator
	 */
	public void myClose(){
		/**
		 * 关闭ResultSet
		 */
		if(res != null){
			try {
				res.close();
			} catch (SQLException e) {
				System.out.println("ResultSet关闭失败!");	
			}
		}
		/**
		 * 关闭Statement
		 */
		if(sta != null){
			try {
				sta.close();
			} catch (SQLException e) {
				System.out.println("Statement关闭失败!");	
			}
		}
		/**
		 * 关闭Connection
		 */
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connection关闭失败!");
			}
		}
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getRowsPage() {
		return rowsPage;
	}
	public void setRowsPage(int rowsPage) {
		this.rowsPage = rowsPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	
}
