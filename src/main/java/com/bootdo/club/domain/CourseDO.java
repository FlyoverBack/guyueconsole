package com.bootdo.club.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 课程表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 17:01:41
 */
public class CourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//课程编号
	private String courseId;
	//课程类型
	private String type;
	//课程名称
	private String name;
	//课程价格
	private BigDecimal price;
	//课程折扣
	private BigDecimal discount;
	//课程状态
	private Integer status;
	//教练ID
	private String coachId;
	//教练名称
	private String coachName;
	//教练类型
	private Integer coachType;
	//场地ID
	private String clubId;
	//场地名称
	private String clubName;
	//场地类型
	private Integer clubType;
	//是否体验课
	private String tryFlag;
	//备注2
	private String bz2;
	//备注1
	private String bz1;
	//
	private Date updateTime;
	//
	private Integer updateUser;
	//
	private Date createTime;
	//
	private Integer createUser;

	private List<CourseLogDO> courseLogDOList;

    private String  reasons;
    //状态  0 否  1 是
	private Byte  oorderType;

	public Byte getOorderType() {
		return oorderType;
	}

	public void setOorderType(Byte oorderType) {
		this.oorderType = oorderType;
	}

	public String getReasons() {
		return reasons;
	}

	public void setReasons(String reasons) {
		this.reasons = reasons;
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
	 * 设置：课程类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：课程类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：课程名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：课程名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：课程价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：课程价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：课程折扣
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	/**
	 * 获取：课程折扣
	 */
	public BigDecimal getDiscount() {
		return discount;
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
	 * 设置：教练ID
	 */
	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}
	/**
	 * 获取：教练ID
	 */
	public String getCoachId() {
		return coachId;
	}
	/**
	 * 设置：教练类型
	 */
	public void setCoachType(Integer coachType) {
		this.coachType = coachType;
	}
	/**
	 * 获取：教练类型
	 */
	public Integer getCoachType() {
		return coachType;
	}
	/**
	 * 设置：场地ID
	 */
	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	/**
	 * 获取：场地ID
	 */
	public String getClubId() {
		return clubId;
	}
	/**
	 * 设置：场地类型
	 */
	public void setClubType(Integer clubType) {
		this.clubType = clubType;
	}
	/**
	 * 获取：场地类型
	 */
	public Integer getClubType() {
		return clubType;
	}
	/**
	 * 设置：是否体验课
	 */
	public void setTryFlag(String tryFlag) {
		this.tryFlag = tryFlag;
	}
	/**
	 * 获取：是否体验课
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
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateUser() {
		return createUser;
	}


	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public List<CourseLogDO> getCourseLogDOList() {
		return courseLogDOList;
	}

	public void setCourseLogDOList(List<CourseLogDO> courseLogDOList) {
		this.courseLogDOList = courseLogDOList;
	}

	@Override
	public String toString() {
		return "CourseDO{" +
				"courseId='" + courseId + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", price=" + price +
				", discount=" + discount +
				", status=" + status +
				", coachId='" + coachId + '\'' +
				", coachName='" + coachName + '\'' +
				", coachType=" + coachType +
				", clubId='" + clubId + '\'' +
				", clubName='" + clubName + '\'' +
				", clubType=" + clubType +
				", tryFlag='" + tryFlag + '\'' +
				", bz2='" + bz2 + '\'' +
				", bz1='" + bz1 + '\'' +
				", updateTime=" + updateTime +
				", updateUser=" + updateUser +
				", createTime=" + createTime +
				", createUser=" + createUser +
				", courseLogDOList=" + courseLogDOList +
				'}';
	}
}
