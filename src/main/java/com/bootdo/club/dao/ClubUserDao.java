package com.bootdo.club.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liujie01 on 2019/7/15.
 */

public interface ClubUserDao  {
    void updateUserById(@Param("clubId") String clubId,
                               @Param("realName") String realName,
                               @Param("nikeName") String nikeName,
                               @Param("tel") String tel) ;

    List<String> selectByPames(@Param("queryName") String queryName);
}
