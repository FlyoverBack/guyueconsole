package com.bootdo.banner.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-23 14:43:14
 */
public class BannerInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//标题
	private String title;
	//banner图片
	private String bannerImgUrl;
	//详情图片
	private String detailImgUrl;
	//跳转页面
	private String redirectUrl;
	//排序
	private Integer orderNum;
	//创建时间
	private Date createTime;
	//开始时间
	private Date beginTime;
	//结束时间
	private Date endTime;
	//备注1
	private String bz1;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：banner图片
	 */
	public void setBannerImgUrl(String bannerImgUrl) {
		this.bannerImgUrl = bannerImgUrl;
	}
	/**
	 * 获取：banner图片
	 */
	public String getBannerImgUrl() {
		return bannerImgUrl;
	}
	/**
	 * 设置：详情图片
	 */
	public void setDetailImgUrl(String detailImgUrl) {
		this.detailImgUrl = detailImgUrl;
	}
	/**
	 * 获取：详情图片
	 */
	public String getDetailImgUrl() {
		return detailImgUrl;
	}
	/**
	 * 设置：跳转页面
	 */
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	/**
	 * 获取：跳转页面
	 */
	public String getRedirectUrl() {
		return redirectUrl;
	}
	/**
	 * 设置：排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrderNum() {
		return orderNum;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：开始时间
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getBeginTime() {
		return beginTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndTime() {
		return endTime;
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
}
