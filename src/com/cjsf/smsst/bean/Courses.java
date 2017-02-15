package com.cjsf.smsst.bean;
/**
 * @category 课程实体类
 * @author Administrator
 *
 */
public class Courses {
	//课程编号
	private int course_id;
	//课程名称
	private String course_name;
	
	public Courses(){
		
	}
	
	public Courses(int course_id,String course_name){
		this.course_id = course_id;
		this.course_name = course_name;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	
}
