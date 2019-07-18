package com.bootdo.club.service.impl;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.dao.ClubDao;
import com.bootdo.club.dao.ClubUserDao;
import com.bootdo.club.domain.ClubQueryVo;
import com.bootdo.club.domain.ClubResDo;
import com.bootdo.club.service.ClubService;
import com.bootdo.common.utils.LogBuild;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.course.dao.CourseInfoDao;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liujie01 on 2019/7/8.
 */
@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubDao clubDao;

    @Autowired
    private CourseInfoDao courseInfoDao;


    @Autowired
    private ClubUserDao clubUserDao;

    private static final Logger logger = LoggerFactory.getLogger(ClubServiceImpl.class);

    @Override
    public PageUtils list(ClubQueryVo vo) {
        String mess="场地列表service";
        logger.info(LogBuild.getBuilder(mess,"开始")
                .kv("params",vo.toString()).build());
        PageUtils pageUtils = null;
        try {
            /**
             * 综合查询
             */
            if(!StringUtils.isEmpty(vo.getQueryName())){
                List<String> userIds=clubUserDao.selectByPames(vo.getQueryName());
                vo.setClubIds(userIds);
            }
            List<ClubResDo> cludDos = clubDao.selectList(vo);
            if(CollectionUtils.isEmpty(cludDos)){
                logger.info(LogBuild.getBuilder(mess,"查询结果为空")
                        .kv("cludDos",cludDos).build());
                return  new PageUtils(null, 0);
            }
            int total = clubDao.selectCount(vo);
            pageUtils = new PageUtils(cludDos, total);
        } catch (Exception e) {
            logger.error(LogBuild.getBuilder(mess,"系统异常")
                    .kv("Exception",e).build(),e);
            return  new PageUtils(null, 0);
        }
        return pageUtils;
    }

    @Override
    public ClubResDo get(String clubId) {
        String mess="id查询场地";
        logger.info(LogBuild.getBuilder(mess,"开始")
                .kv("clubId",clubId).build());
        ClubResDo clubDo= null;
        try {
            clubDo=clubDao.getById(clubId);
            if(clubDo==null){
                logger.info(LogBuild.getBuilder(mess,"查询结果为空")
                        .kv("clubId",clubId).build());
            }
            if(!StringUtils.isEmpty(clubDo.getBusinessType())){
                clubDo.setBusinessTypes(Arrays.asList(clubDo.getBusinessType().split(",")));
            }
            clubDo.setCourseTypes(courseInfoDao.getCourseType(clubId).stream()
                    .map(KeyValueBeanVo::getKey).collect(Collectors.toList()));
        } catch (Exception e) {
            logger.error(LogBuild.getBuilder(mess,"系统异常")
                    .kv("Exception",e).build(),e);
            return null;
        }

        return clubDo;
    }

    @Override
    public R updateClubDetails(ClubResDo clubDo) {
        String mess ="修改场地详情";

        logger.info(LogBuild.getBuilder(mess,"开始")
                .kv("clubDo",clubDo).build());
        if( clubDo ==null || StringUtils.isEmpty(clubDo.getClubId())){
            logger.info(LogBuild.getBuilder(mess,"开始")
                    .kv("clubDo",clubDo).build());
            return R.error(1,"参数异常");
        }
        /**
         * 修改负责人相关信息
         */
        try {
            clubUserDao.updateUserById(clubDo.getClubId(), clubDo.getCoachName(), clubDo.getNickName(),clubDo.getTel());
            if(!CollectionUtils.isEmpty(clubDo.getBusinessTypes())){
                StringBuilder str=new StringBuilder();
                for (String busType:clubDo.getBusinessTypes()) {
                    str.append(busType).append(",");
                }
                clubDo.setBusinessType(str.toString().substring(0,str.length()-1));
            }
            clubDao.updateClubById(clubDo);


        } catch (Exception e) {
            logger.error(LogBuild.getBuilder(mess,"系统异常")
                    .kv("Exception",e).build(),e);
           throw  new RuntimeException("系统异常",e);
        }
        return R.ok();

    }

    /**
     * 查询课程种类
     * @return
     */
    @Override
    public List<KeyValueBeanVo> getCourseType() {
        return  courseInfoDao.getCourseType(null);
    }
}
