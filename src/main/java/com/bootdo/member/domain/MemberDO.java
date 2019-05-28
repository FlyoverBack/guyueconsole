package com.bootdo.member.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 会员信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-28 17:11:57
 */
public class MemberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//会员ID
	private String memId;
	//会员名称
	private String name;
	//会员号
	private String no;
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
	//
	private Integer type;

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
	 * 设置：会员名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：会员名称
	 */
	public String getName() {
		return name;
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
	 * 设置：
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public Integer getType() {
		return type;
	}
}
