package com.cjsf.smsst.bean;
/**
 * @category 班级实体类
 * @author Administrator
 *
 */
public class Classs {
	//班级编号
	private int class_id;
	//班级名称
	private String class_name;
	
	public Classs(){
		
	}
	
	public Classs(int class_id,String class_name){
		this.class_id = class_id;
		this.class_name = class_name;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
}
