package com.bootdo.memberCourse.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 会员课程表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 15:29:35
 */
public class MemberCourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//会员ID
	private String memId;
	//课程编号
	private String courseId;
	//总课时数
	private Integer totalLesson;
	//已消费课时数
	private Integer used;
	//剩余课时数
	private Integer rem;
	//课程状态
	private Integer status;
	//备注1
	private String bz1;
	//课程ID
	private String kcId;
	//购买时间
	private Date buyTime;
	//购买次数
	private Integer buyCount;

	/**
	 * 设置：会员ID
	 */
	public void setMemId(String memId) {
		this.memId = memId;
	}
	/**
	 * 获取：会员ID
	 */
	public String getMemId() {
		return memId;
	}
	/**
	 * 设置：课程编号
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程编号
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * 设置：总课时数
	 */
	public void setTotalLesson(Integer totalLesson) {
		this.totalLesson = totalLesson;
	}
	/**
	 * 获取：总课时数
	 */
	public Integer getTotalLesson() {
		return totalLesson;
	}
	/**
	 * 设置：已消费课时数
	 */
	public void setUsed(Integer used) {
		this.used = used;
	}
	/**
	 * 获取：已消费课时数
	 */
	public Integer getUsed() {
		return used;
	}
	/**
	 * 设置：剩余课时数
	 */
	public void setRem(Integer rem) {
		this.rem = rem;
	}
	/**
	 * 获取：剩余课时数
	 */
	public Integer getRem() {
		return rem;
	}
	/**
	 * 设置：课程状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：课程状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注1
	 */
	public void setBz1(String bz1) {
		this.bz1 = bz1;
	}
	/**
	 * 获取：备注1
	 */
	public String getBz1() {
		return bz1;
	}
	/**
	 * 设置：课程ID
	 */
	public void setKcId(String kcId) {
		this.kcId = kcId;
	}
	/**
	 * 获取：课程ID
	 */
	public String getKcId() {
		return kcId;
	}
	/**
	 * 设置：购买时间
	 */
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	/**
	 * 获取：购买时间
	 */
	public Date getBuyTime() {
		return buyTime;
	}
	/**
	 * 设置：购买次数
	 */
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	/**
	 * 获取：购买次数
	 */
	public Integer getBuyCount() {
		return buyCount;
	}
}
