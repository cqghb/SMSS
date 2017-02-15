package com.cjsf.smsst.bean;

public class ScoreSelects {
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
	//班级名称
	private String class_name;
	//课程编号
	private int course_id;
	//课程名称
	private String course_name;
	//成绩编号
	private int score_id;
	//成绩
	private double score_num;
	/**
	 * @category 无参构造方法
	 * @author Administrator
	 */
	public ScoreSelects(){
		
	}
	/**
	 * @category 有参构造方法
	 * @author Administrator
	 */
	public ScoreSelects(int id,String class_name,String name,int sex,int age,int class_id,int course_id,String course_name,int score_id,double score_num){
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.class_id = class_id;
		this.class_name = class_name;
		this.course_id = course_id;
		this.course_name = course_name;
		this.score_id = score_id;
		this.score_num = score_num;
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
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
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

	public int getScore_id() {
		return score_id;
	}

	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}

	public double getScore_num() {
		return score_num;
	}

	public void setScore_num(double score_num) {
		this.score_num = score_num;
	}
}
