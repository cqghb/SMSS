package com.cjsf.smsst.bean;
/**
 * @category 用户实体类
 * @author Administrator
 *
 */
public class Admin {
	//用户编号
	private int id;
	//用户账号
	private int name;
	//用户密码
	private String password;
	public Admin(){
		
	}
	
	public Admin(int id,int name,String password){
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
