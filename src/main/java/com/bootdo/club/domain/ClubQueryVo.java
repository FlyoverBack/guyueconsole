package com.bootdo.club.domain;

import com.bootdo.base.domain.BaseQueryVo;

import java.util.List;

/**
 * Created by liujie01 on 2019/7/15.
 * 查询实体类
 */
public class ClubQueryVo extends BaseQueryVo{

    private String  clubId;

    private String locationId;

    private List<String> clubIds;

    private String  status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getClubIds() {
        return clubIds;
    }

    public void setClubIds(List<String> clubIds) {
        this.clubIds = clubIds;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "ClubQueryVo{" +
                "locationId='" + locationId + '\'' +
                '}';
    }
}
