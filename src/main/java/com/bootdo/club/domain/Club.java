package com.bootdo.club.domain;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liujie01 on 2019/7/9.
 *
 *场地实体
 *
 */

public class Club {


    private String clubId;

    private String clubName;

    private BigDecimal la;

    private BigDecimal lo;

    private String  address;

    private String  clubTel;

    private String  photo;

    private Integer coachType;

    private Float area;

    private Date openTime;

    private Date closeTime;

    private Date createTime;

    private  String jcss;

    private  Integer clubStatus;


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

    public BigDecimal getLa() {
        return la;
    }

    public void setLa(BigDecimal la) {
        this.la = la;
    }

    public BigDecimal getLo() {
        return lo;
    }

    public void setLo(BigDecimal lo) {
        this.lo = lo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClubTel() {
        return clubTel;
    }

    public void setClubTel(String clubTel) {
        this.clubTel = clubTel;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getCoachType() {
        return coachType;
    }

    public void setCoachType(Integer coachType) {
        this.coachType = coachType;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getJcss() {
        return jcss;
    }

    public void setJcss(String jcss) {
        this.jcss = jcss;
    }

    public Integer getClubStatus() {
        return clubStatus;
    }

    public void setClubStatus(Integer clubStatus) {
        this.clubStatus = clubStatus;
    }

    @Override
    public String toString() {
        return "ClubVo{" +
                "clubId='" + clubId + '\'' +
                ", clubName='" + clubName + '\'' +
                ", la=" + la +
                ", lo=" + lo +
                ", address='" + address + '\'' +
                ", clubTel='" + clubTel + '\'' +
                ", photo='" + photo + '\'' +
                ", coachType=" + coachType +
                ", area=" + area +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", createTime=" + createTime +
                ", jcss='" + jcss + '\'' +
                ", clubStatus=" + clubStatus +
                '}';
    }
}
