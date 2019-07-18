package com.bootdo.club.domain;

import java.util.Date;

/**
 * Created by liujie01 on 2019/7/15.
 *
 * 场地负责人实体
 */
public class User {
    /**
     * userId同场地ID关联
     */
    private String userId;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     *  登录名称
     */
    private String userName;

    private String password;

    private String userTel;
    /**
     * 登录渠道
     */
    private Integer chn;
    /**
     *最后一次登陆时间
     */
    private Date lastLogin;

    private String openId;

    private String tryFlag;

    private Integer userType;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getChn() {
        return chn;
    }

    public void setChn(Integer chn) {
        this.chn = chn;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTryFlag() {
        return tryFlag;
    }

    public void setTryFlag(String tryFlag) {
        this.tryFlag = tryFlag;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userTel='" + userTel + '\'' +
                ", chn=" + chn +
                ", lastLogin=" + lastLogin +
                ", openId='" + openId + '\'' +
                ", tryFlag='" + tryFlag + '\'' +
                ", userType=" + userType +
                '}';
    }
}
