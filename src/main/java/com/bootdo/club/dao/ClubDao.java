package com.bootdo.club.dao;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.domain.Club;
import com.bootdo.club.domain.ClubQueryVo;
import com.bootdo.club.domain.ClubResDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by liujie01 on 2019/7/8.
 */
@Mapper
@Component
public interface ClubDao {


    List<ClubResDo> selectList(ClubQueryVo vo) ;


    int selectCount(ClubQueryVo vo) ;

    ClubResDo getById(@Param("clubId") String clubId);

    void updateClubById(ClubResDo clubDo);

    List<Club> getListByIds(@Param("clubIds")List<String> collect);

    Club getClubById(@Param("clubId") String clubId);

    List<KeyValueBeanVo> getClubByAll();

    List<String> queryClubByName(@Param("clubName") String clubName);
}
