package com.bootdo.club.dao;

import com.bootdo.club.domain.ClubQueryVo;
import com.bootdo.club.domain.ClubResDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liujie01 on 2019/7/8.
 */

public interface ClubDao {


    List<ClubResDo> selectList(ClubQueryVo vo) ;


    int selectCount(ClubQueryVo vo) ;

    ClubResDo getById(@Param("clubId") String clubId);

    void updateClubById(ClubResDo clubDo);
}
