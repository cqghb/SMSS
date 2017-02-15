package com.cjsf.smsst.bean;
/**
 * @category 学生实体类
 * @author Administrator
 *
 */
public class Students {
	//学号
	private int id;
	//姓名
	private String name;
	//性别{1:男,2:女}
	private int sex;
	//年龄
	private int age;
	//班级id
	private int class_id;
	
	public Students(){
		
	}
	
	public Students(int id,String name,int sex,int age,int class_id){
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.class_id = class_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	
}
