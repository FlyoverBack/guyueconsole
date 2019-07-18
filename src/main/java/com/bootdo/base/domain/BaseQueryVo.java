package com.bootdo.base.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by liujie01 on 2019/7/9.
 *
 *  query条件 公共类
 *
 */
public class BaseQueryVo {
    /**
     * 多个条件查询
     */
    private  String queryName;
    /**
     * 创建开始时间
     */
    private  String  creatStartTime;
    /**
     * 创建结束时间
     */
    private  String  creatEndTime;


    private Integer offset;

    private  Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getCreatStartTime() {
        return creatStartTime;
    }

    public void setCreatStartTime(String creatStartTime) {
        this.creatStartTime = creatStartTime;
    }

    public String getCreatEndTime() {
        return creatEndTime;
    }

    public void setCreatEndTime(String creatEndTime) {
        this.creatEndTime = creatEndTime;
    }
}
