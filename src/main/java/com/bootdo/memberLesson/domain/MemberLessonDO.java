package com.bootdo.memberLesson.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 会员课时表
 *
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 14:53:19
 */
public class MemberLessonDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //会员id
    private String memId;
    //课程编号
    private String saleId;
    //序号
    private Integer seqNo;
    //场地id
    private String clubId;
    //状态(null:待预约，0：待上课，1：上课中，2：已签到，3：教练旷课，4：教练取消，5：学员取消)
    private Integer status;
    //开始时间
    private Date startTime1;
    //结束时间
    private Date endTime1;
    //实际开始时间
    private Date startTime2;
    //实际结束时间
    private Date endTime2;
    //教练id
    private String coachId;
    //上课场地
    private String realClub;
    //上课教练
    private String realCoach;
    //备注1
    private String bz1;
    //备注2
    private String bz2;
    //更新时间
    private Date chTime;
    //课程id
    private String kcId;
    //价格
    private BigDecimal price;

    /**
     * 设置：会员id
     */
    public void setMemId(String memId) {
        this.memId = memId;
    }

    /**
     * 获取：会员id
     */
    public String getMemId() {
        return memId;
    }

    /**
     * 设置：课程编号
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    /**
     * 获取：课程编号
     */
    public String getSaleId() {
        return saleId;
    }

    /**
     * 设置：序号
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     * 获取：序号
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     * 设置：场地id
     */
    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    /**
     * 获取：场地id
     */
    public String getClubId() {
        return clubId;
    }

    /**
     * 设置：状态(null:待预约，0：待上课，1：上课中，2：已签到，3：教练旷课，4：教练取消，5：学员取消)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：状态(null:待预约，0：待上课，1：上课中，2：已签到，3：教练旷课，4：教练取消，5：学员取消)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置：开始时间
     */
    public void setStartTime1(Date startTime1) {
        this.startTime1 = startTime1;
    }

    /**
     * 获取：开始时间
     */
    public Date getStartTime1() {
        return startTime1;
    }

    /**
     * 设置：结束时间
     */
    public void setEndTime1(Date endTime1) {
        this.endTime1 = endTime1;
    }

    /**
     * 获取：结束时间
     */
    public Date getEndTime1() {
        return endTime1;
    }

    /**
     * 设置：实际开始时间
     */
    public void setStartTime2(Date startTime2) {
        this.startTime2 = startTime2;
    }

    /**
     * 获取：实际开始时间
     */
    public Date getStartTime2() {
        return startTime2;
    }

    /**
     * 设置：实际结束时间
     */
    public void setEndTime2(Date endTime2) {
        this.endTime2 = endTime2;
    }

    /**
     * 获取：实际结束时间
     */
    public Date getEndTime2() {
        return endTime2;
    }

    /**
     * 设置：教练id
     */
    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    /**
     * 获取：教练id
     */
    public String getCoachId() {
        return coachId;
    }

    /**
     * 设置：上课场地
     */
    public void setRealClub(String realClub) {
        this.realClub = realClub;
    }

    /**
     * 获取：上课场地
     */
    public String getRealClub() {
        return realClub;
    }

    /**
     * 设置：上课教练
     */
    public void setRealCoach(String realCoach) {
        this.realCoach = realCoach;
    }

    /**
     * 获取：上课教练
     */
    public String getRealCoach() {
        return realCoach;
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
     * 设置：更新时间
     */
    public void setChTime(Date chTime) {
        this.chTime = chTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getChTime() {
        return chTime;
    }

    /**
     * 设置：课程id
     */
    public void setKcId(String kcId) {
        this.kcId = kcId;
    }

    /**
     * 获取：课程id
     */
    public String getKcId() {
        return kcId;
    }

    /**
     * 设置：价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取：价格
     */
    public BigDecimal getPrice() {
        return price;
    }
}
