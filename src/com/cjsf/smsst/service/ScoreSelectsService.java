package com.cjsf.smsst.service;

import java.util.ArrayList;

import com.cjsf.smsst.bean.ScoreSelects;
import com.cjsf.smsst.dao.ScoreSelectsDao;

/**
 * @category 学生成绩业务逻辑类
 * @author Administrator
 */
public class ScoreSelectsService {
	//实例化ScoreSelects
	ScoreSelectsDao ssd = new ScoreSelectsDao();
	//操作结果标识变量
	private boolean result = false;
	/**
	 * @category 添加学生成绩
	 * @author Administrator
	 * @param id,course_id,score_num,class_id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean addScore(int id, int class_id, int course_id, double score_num) {
		result = ssd.addScore(id, class_id, course_id, score_num);
		return result;
	}
	/**
	 * @category 根据学号和课程编号删除学生成绩
	 * @author Administrator
	 * @param id,course_id,score_num,class_id
	 * @return boolean {true:成功,false:失败}
	 */
	public boolean deleteScoreByScore_id(int score_id) {
		result = ssd.deleteScoreByScore_id(score_id);
		return result;
	}
	/**
	 * @category 获得表中数据的总条数
	 * @author Administrator
	 * @return int {大于0:成功,小于0:失败}
	 */
	public int gLastPage(){
		return ssd.gLastPage();
	}
	/**
	 * @category 查看所有学生所有成绩
	 * @author Administrator
	 * @return 返回学生成绩集合
	 */
	public ArrayList<ScoreSelects> viewScore(int rowsPage,int curPage){
		return ssd.viewScore(rowsPage,curPage);
	}
	/**
	 * @category 根据成绩编号修改成绩
	 * @param score_id,score_num
	 * @author Administrator
	 * @return 
	 */
	public boolean updateScoreByScore_id(int score_id, int score_num) {
		return ssd.updateScoreByScore_id(score_id,score_num);
	}
	/**
	 * @category 查询指定班级的学生成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(int class_id) {
		return ssd.gLastPageBZD(class_id);
	}
	/**
	 * @category 查询指定班级的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return 
	 */
	public ArrayList<ScoreSelects> selectBClass_id(int class_id,int rowsPage,int curPage) {
		return ssd.selectBClass_id(class_id,rowsPage,curPage);
	}
	/**
	 * @category 查询指定班级的学生姓名的成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(String name, int class_id) {
		return ssd.gLastPageBZD(name,class_id);
	}
	/**
	 * @category 查询指定班级的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> selectBNCI(String name, int class_id,int rowsPage,int curPage) {
		return ssd.selectBNCI(name,class_id,rowsPage,curPage);
	}
	/**
	 * @category 查询指定班级和学号的学生成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(int id, int class_id) {
		return ssd.gLastPageBZD(id,class_id);
	}
	/**
	 * @category 查询指定班级和学号的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> selectBICI(int id, int class_id,int rowsPage,int curPage) {
		return ssd.selectBICI(id,class_id,rowsPage,curPage);
	}
	/**
	 * @category 查询指定班级和学号姓名的学生成绩数据条数
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public int gLastPageBZD(int id, String name, int class_id) {
		return ssd.gLastPageBZD(id,name,class_id);
	}
	/**
	 * @category 查询指定班级和学号姓名的学生成绩集合
	 * @author Administrator
	 * @param class_id
	 * @return
	 */
	public ArrayList<ScoreSelects> SelBINCI(int id, String name, int class_id,int rowsPage,int curPage) {
		return ssd.SelBINCI(id,name,class_id,rowsPage,curPage);
	}

}
