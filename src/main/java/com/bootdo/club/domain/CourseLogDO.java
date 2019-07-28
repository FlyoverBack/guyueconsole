package com.bootdo.club.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 20:58:16
 */
public class CourseLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String courseId;
	//1  新增 2 修改 3删除
	private Integer type;
	//
	private Integer courseStatus;
	//修改原因
	private String reasons;
	//
	private BigDecimal coursePrice;
	//修改人
	private Date createTime;
	//修改时间
	private Integer createUser;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * 设置：1  新增 2 修改 3删除
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1  新增 2 修改 3删除
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setCourseStatus(Integer courseStatus) {
		this.courseStatus = courseStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getCourseStatus() {
		return courseStatus;
	}
	/**
	 * 设置：修改原因
	 */
	public void setReasons(String reasons) {
		this.reasons = reasons;
	}
	/**
	 * 获取：修改原因
	 */
	public String getReasons() {
		return reasons;
	}
	/**
	 * 设置：
	 */
	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getCoursePrice() {
		return coursePrice;
	}
	/**
	 * 设置：修改人
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：修改人
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：修改时间
	 */
	public Integer getCreateUser() {
		return createUser;
	}
}
