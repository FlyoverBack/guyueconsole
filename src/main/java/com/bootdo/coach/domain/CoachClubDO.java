package com.bootdo.coach.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * VIEW
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-11 17:05:57
 */
public class CoachClubDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//姓名
	private String coachName;
	//电话
	private String tel;
	//昵称
	private String nickName;
	//教练类别
	private Integer type;
	//店名名称
	private String clubName;
	//状态
	private Integer status;
	//注册时间
	private Date registrationTime;

	/**
	 * 设置：姓名
	 */
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}
	/**
	 * 获取：姓名
	 */
	public String getCoachName() {
		return coachName;
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
	 * 设置：店名名称
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	/**
	 * 获取：店名名称
	 */
	public String getClubName() {
		return clubName;
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
}
