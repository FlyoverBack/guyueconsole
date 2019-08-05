package com.bootdo.club.domain;

import java.util.Date;

/**
 * Created by liujie01 on 2019/7/15.
 */
public class UserIcons{

    private String  userId;
    /**
     * 图片名称
     */
    private String  iconName;
    /**
     * 图片路径
     */
    private String  iconUrl;

    private String  userIconsType;

    private Date  upTime;

    private String bz1;

    private String bz2;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getUserIconsType() {
        return userIconsType;
    }

    public void setUserIconsType(String userIconsType) {
        this.userIconsType = userIconsType;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public String getBz1() {
        return bz1;
    }

    public void setBz1(String bz1) {
        this.bz1 = bz1;
    }

    public String getBz2() {
        return bz2;
    }

    public void setBz2(String bz2) {
        this.bz2 = bz2;
    }

    @Override
    public String toString() {
        return "UserIconsVo{" +
                "userId='" + userId + '\'' +
                ", iconName='" + iconName + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", userIconsType='" + userIconsType + '\'' +
                ", upTime=" + upTime +
                ", bz1='" + bz1 + '\'' +
                ", bz2='" + bz2 + '\'' +
                '}';
    }
}
