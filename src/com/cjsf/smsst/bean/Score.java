package com.cjsf.smsst.bean;
/**
 * @category 成绩实体类 
 * @author Administrator
 */
public class Score {
	//成绩编号
	private int score_id;
	//学号
	private int id;
	//课程编号
	private int course_id;
	//成绩
	private double score_num;
	
	public Score(){
		
	}
	
	public Score(int score_id,int id,int course_id,double score_num){
		this.score_id = score_id;
		this.id = id;
		this.course_id = course_id;
		this.score_num = score_num;
	}

	public int getScore_id() {
		return score_id;
	}

	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public double getScore_num() {
		return score_num;
	}

	public void setScore_num(double score_num) {
		this.score_num = score_num;
	}
	
	
}
