package com.bootdo.coach.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 会员信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-22 09:22:03
 */
public class CoachDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//教练ID
	private String coachId;
	//会员号
	private String no;
	//姓名
	private String name;
	//昵称
	private String nickName;
	//年龄
	private Integer age;
	//电话
	private String tel;
	//身高
	private BigDecimal height;
	//体重
	private BigDecimal weight;
	//生日
	private Date birthday;
	//性别
	private String sex;
	//头像路径
	private String icon;
	//评分
	private Float score;
	//评论
	private String comment;
	//教练类别
	private Integer type;
	//介绍
	private String introduction;
	//注册时间
	private Date registrationTime;
	//状态
	private Integer status;

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
	 * 设置：会员号
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 获取：会员号
	 */
	public String getNo() {
		return no;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：身高
	 */
	public void setHeight(BigDecimal height) {
		this.height = height;
	}
	/**
	 * 获取：身高
	 */
	public BigDecimal getHeight() {
		return height;
	}
	/**
	 * 设置：体重
	 */
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	/**
	 * 获取：体重
	 */
	public BigDecimal getWeight() {
		return weight;
	}
	/**
	 * 设置：生日
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取：生日
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：头像路径
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：头像路径
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：评分
	 */
	public void setScore(Float score) {
		this.score = score;
	}
	/**
	 * 获取：评分
	 */
	public Float getScore() {
		return score;
	}
	/**
	 * 设置：评论
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：评论
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 设置：教练类别
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：教练类别
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：介绍
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：介绍
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：注册时间
	 */
	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegistrationTime() {
		return registrationTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
}
