package com.bootdo.club.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by liujie01 on 2019/7/9.
 * 列表页和详情页  查询条件vo
 */
    public class ClubResDo  {


    private  String clubId;

    private  String  clubName;

    private  String  tel;

    private  String  realName;

    private  String  coachName;
    /**
     * 微信昵称
     */
    private  String nickName;
    /**
     * 状态
     */
    private  String  clubStatus;

    private  Integer  clubType;

    private  Date    registrationTime;

 /*   *//**
     * 场地提成
     *//*
    private BigDecimal  clubRoyalty;*/

    /**
     * 门店面积
     */
    private  Float  area;
    /**
     * 门店电话
     */
    private  Long clubTel;


    private  String openTime;


    private  String closeTime;


    private  String address;


    private  BigDecimal la;

    private String businessType;


    private BigDecimal lo;


    private String jcss;


    private  String  photo;


    private  String  icon;

    /**
     * 课程列表
     */
    private List<String >  courseTypes;
    /**
     * 营业类型
     */
    private List<String>  businessTypes;


    private  Byte clubTcType;


    private Integer clubTc;

    public Byte getClubTcType() {
        return clubTcType;
    }

    public void setClubTcType(Byte clubTcType) {
        this.clubTcType = clubTcType;
    }

    public Integer getClubTc() {
        return clubTc;
    }

    public void setClubTc(Integer clubTc) {
        this.clubTc = clubTc;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Long getClubTel() {
        return clubTel;
    }

    public void setClubTel(Long clubTel) {
        this.clubTel = clubTel;
    }

    public String getOpenTime() {
        return openTime;
    }



    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLa() {
        return la;
    }

    public void setLa(BigDecimal la) {
        this.la = la;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public BigDecimal getLo() {
        return lo;
    }

    public void setLo(BigDecimal lo) {
        this.lo = lo;
    }

    public String getJcss() {
        return jcss;
    }

    public void setJcss(String jcss) {
        this.jcss = jcss;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getCourseTypes() {
        return courseTypes;
    }

    public void setCourseTypes(List<String> courseTypes) {
        this.courseTypes = courseTypes;
    }

    public List<String> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<String> businessTypes) {
        this.businessTypes = businessTypes;
    }


    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getClubStatus() {
        return clubStatus;
    }

    public void setClubStatus(String clubStatus) {
        this.clubStatus = clubStatus;
    }


    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Integer getClubType() {
        return clubType;
    }

    public void setClubType(Integer clubType) {
        this.clubType = clubType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ClubResDo{" +
                "clubId='" + clubId + '\'' +
                ", clubName='" + clubName + '\'' +
                ", tel='" + tel + '\'' +
                ", realName='" + realName + '\'' +
                ", coachName='" + coachName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", clubStatus='" + clubStatus + '\'' +
                ", clubType=" + clubType +
                ", registrationTime=" + registrationTime +
                ", area=" + area +
                ", clubTel=" + clubTel +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", address='" + address + '\'' +
                ", la=" + la +
                ", businessType='" + businessType + '\'' +
                ", lo=" + lo +
                ", jcss='" + jcss + '\'' +
                ", photo='" + photo + '\'' +
                ", icon='" + icon + '\'' +
                ", courseTypes=" + courseTypes +
                ", businessTypes=" + businessTypes +
                ", clubTcType=" + clubTcType +
                ", clubTc=" + clubTc +
                '}';
    }
}
