package com.bootdo.course.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 课程信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-21 23:30:09
 */
public class CourseInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//课程编号(类型)
	private String courseType;
	//课程名称
	private String courseName;
	//课程类型
	private String tryFlag;
	//备注2
	private String bz2;
	//场地类型
	private String clubType;
	//教练类型
	private String coachType;
	//课程简介
	private String brief;
	//课程详情
	private String detail;
	//适宜人群
	private String approp;
	//课程时间
	private String courseTime;
	//课程建议
	private String suggest;
	//课程照片
	private String infoPic;
	//起售数量
	private Integer minCount;
	//创建时间
	private Date upTime;
	//创建人
	private String upUser;
	//售课照片
	private String salePic;

	/**
	 * 设置：课程编号(类型)
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	/**
	 * 获取：课程编号(类型)
	 */
	public String getCourseType() {
		return courseType;
	}
	/**
	 * 设置：课程名称
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程名称
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 设置：课程类型
	 */
	public void setTryFlag(String tryFlag) {
		this.tryFlag = tryFlag;
	}
	/**
	 * 获取：课程类型
	 */
	public String getTryFlag() {
		return tryFlag;
	}
	/**
	 * 设置：备注2
	 */
	public void setBz2(String bz2) {
		this.bz2 = bz2;
	}
	/**
	 * 获取：备注2
	 */
	public String getBz2() {
		return bz2;
	}
	/**
	 * 设置：场地类型
	 */
	public void setClubType(String clubType) {
		this.clubType = clubType;
	}
	/**
	 * 获取：场地类型
	 */
	public String getClubType() {
		return clubType;
	}
	/**
	 * 设置：教练类型
	 */
	public void setCoachType(String coachType) {
		this.coachType = coachType;
	}
	/**
	 * 获取：教练类型
	 */
	public String getCoachType() {
		return coachType;
	}
	/**
	 * 设置：课程简介
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}
	/**
	 * 获取：课程简介
	 */
	public String getBrief() {
		return brief;
	}
	/**
	 * 设置：课程详情
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 获取：课程详情
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * 设置：适宜人群
	 */
	public void setApprop(String approp) {
		this.approp = approp;
	}
	/**
	 * 获取：适宜人群
	 */
	public String getApprop() {
		return approp;
	}
	/**
	 * 设置：课程时间
	 */
	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}
	/**
	 * 获取：课程时间
	 */
	public String getCourseTime() {
		return courseTime;
	}
	/**
	 * 设置：课程建议
	 */
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	/**
	 * 获取：课程建议
	 */
	public String getSuggest() {
		return suggest;
	}
	/**
	 * 设置：课程照片
	 */
	public void setInfoPic(String infoPic) {
		this.infoPic = infoPic;
	}
	/**
	 * 获取：课程照片
	 */
	public String getInfoPic() {
		return infoPic;
	}
	/**
	 * 设置：起售数量
	 */
	public void setMinCount(Integer minCount) {
		this.minCount = minCount;
	}
	/**
	 * 获取：起售数量
	 */
	public Integer getMinCount() {
		return minCount;
	}
	/**
	 * 设置：创建时间
	 */
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getUpTime() {
		return upTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getUpUser() {
		return upUser;
	}
	/**
	 * 设置：售课照片
	 */
	public void setSalePic(String salePic) {
		this.salePic = salePic;
	}
	/**
	 * 获取：售课照片
	 */
	public String getSalePic() {
		return salePic;
	}
}
