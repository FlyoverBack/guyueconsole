package com.bootdo.club.service;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.domain.ClubQueryVo;
import com.bootdo.club.domain.ClubResDo;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by liujie01 on 2019/7/8.
 */

public interface ClubService {

    PageUtils list(ClubQueryVo vo);

    ClubResDo get(String clubId);

    R updateClubDetails(ClubResDo clubDo);

    List<KeyValueBeanVo> getCourseType();
}
