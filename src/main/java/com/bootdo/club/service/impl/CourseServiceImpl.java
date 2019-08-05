package com.bootdo.club.service.impl;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.dao.ClubDao;
import com.bootdo.club.dao.CourseDao;
import com.bootdo.club.dao.CourseLogDao;
import com.bootdo.club.domain.Club;
import com.bootdo.club.domain.ClubResDo;
import com.bootdo.club.domain.CourseDO;
import com.bootdo.club.domain.CourseLogDO;
import com.bootdo.club.service.CourseService;
import com.bootdo.coach.dao.CoachDao;
import com.bootdo.coach.domain.CoachDO;
import com.bootdo.common.utils.*;
import com.bootdo.course.dao.CourseInfoDao;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class CourseServiceImpl implements CourseService {


	@Autowired
	private CourseDao courseDao;
	@Autowired
	private ClubDao clubDao;
	@Autowired
	private CoachDao coachDao;
	@Autowired
	private CourseLogDao courseLogDao;




	private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	@Override
	public CourseDO get(String courseId){
		String mess="查询课程详情";
		if(StringUtils.isEmpty(courseId)){
			logger.info(LogBuild.getBuilder(mess,"参数不能为空").build());
			return null;
		}
		CourseDO courseDO = null;
		try {
			courseDO = courseDao.get(courseId);
			if(courseDO ==null || StringUtils.isEmpty(courseDO.getCourseId())){
              logger.info(LogBuild.getBuilder(mess,"没有结果数据")
                      .kv("courseId",courseId).build());
              return  null;
            }
			Club club = clubDao.getClubById(courseDO.getClubId());
			courseDO.setClubName(club.getClubName());
			Map<String,Object> map=new HashMap<>();
			map.put("courseId",courseId);
			List<CourseLogDO> list = courseLogDao.list(map);
			if(!CollectionUtils.isEmpty(list)){
                courseDO.setCourseLogDOList(list);
            }
		} catch (Exception e) {
			logger.info(LogBuild.getBuilder(mess,"系统异常").kv("Exception",e).build(),e);
			return  null;
		}
		return courseDO;
	}
	
	@Override
	public PageUtils list(Map<String, Object> params){
        String mess="场地课程列表查询";
		PageUtils pageUtils = null;
		try {

			String clubName = (String)params.get("queryName");
			if(!StringUtils.isEmpty(clubName)){
				List<String> ids=clubDao.queryClubByName(clubName);
				params.put("clubIds",ids);
			}
			Query query = new Query(params);
			List<CourseDO> courseList = courseDao.list(query);
			if(CollectionUtils.isEmpty(courseList)){
				logger.info(LogBuild.getBuilder(mess,"查询结果为空")
						.kv("query",query).build());
				return pageUtils;
			}
			List<String> clubIds = courseList.stream().filter(coachDo-> !StringUtils.isEmpty(coachDo.getClubId()))
					.map(CourseDO::getClubId).collect(Collectors.toList());
			List<Club> clubs=clubDao.getListByIds(clubIds);
			Map<String, List<Club>> clubMap = clubs.stream()
					.collect(Collectors.groupingBy(Club::getClubId));
			List<String> coachIds = courseList.stream().filter(coachDo ->!StringUtils.isEmpty(coachDo.getCoachId()))
					.map(CourseDO::getCoachId).collect(Collectors.toList());
			List<KeyValueBeanVo> courses=coachDao.getListByIds(coachIds);
			Map<String, List<KeyValueBeanVo>> courseMap = courses.stream()
					.collect(Collectors.groupingBy(KeyValueBeanVo::getKey));
			courseList.stream().forEach(courseDO -> {
				courseDO.setClubName(CollectionUtils.isEmpty(clubMap.get(courseDO.getClubId()))?"":
						clubMap.get(courseDO.getClubId()).get(0).getClubName());
				courseDO.setCoachName(CollectionUtils.isEmpty(courseMap.get(courseDO.getCoachId()))?"":
						courseMap.get(courseDO.getCoachId()).get(0).getValue());
			} );
			int total = courseDao.count(query);
			pageUtils = new PageUtils(courseList, total);
		} catch (Exception e) {
           logger.error(LogBuild.getBuilder(mess,"系统异常").build(),e);
		}
		return pageUtils;
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseDao.count(map);
	}
	
	@Override
	public R update(CourseDO course){
		String mess ="修改场地课程";
		try {
			course.setUpdateTime(new Date());
			if(courseDao.update(course) <1){
				logger.info(LogBuild.getBuilder(mess,"状态变更异常").kv("course",course).build());
				return R.error(500,"状态变更异常");
			}
			CourseLogDO courseLogDo=new CourseLogDO();
			courseLogDo.setCourseId(course.getCourseId());
			courseLogDo.setCoursePrice(course.getPrice());
			courseLogDo.setCourseStatus(course.getStatus());
			courseLogDo.setCreateTime(new Date());
			courseLogDo.setType(2);
			courseLogDo.setReasons(course.getReasons());
			courseLogDo.setCreateUser(1);

			//todo userid
			courseLogDao.save(courseLogDo);
		} catch (Exception e) {
			logger.error(LogBuild.getBuilder(mess,"系统异常").kv("Exception",e).build(),e);
			throw  new RuntimeException(mess+"异常 ，回滚状态");
		}
		return  R.ok();
	}
	
	@Override
	public int save(CourseDO course){
		String s = System.currentTimeMillis() + "";
		course.setCourseId(s);
		ClubResDo byId = clubDao.getById(course.getClubId());
		course.setClubType(byId.getClubType());
		CoachDO coachDO = coachDao.get(course.getCoachId());
		course.setCoachName(coachDO.getName());
		course.setCoachType(coachDO.getType());
		course.setCreateTime(new Date());
		return courseDao.save(course);
	}
	
	@Override
	public R remove(String courseId){
		String mess ="删除场地课程";
		if(courseDao.remove(courseId)<1){
			logger.info(LogBuild.getBuilder(mess,"删除失败").kv("courseId",courseId).build());
			return R.error(500,"删除失败");
		};
		//todo 增加log表日志
		return R.ok();
	}
	
	@Override
	public int batchRemove(String[] courseIds){
		return courseDao.batchRemove(courseIds);
	}

	@Override
	public List<Integer> queryCoach(String clubId) {
		return  courseDao.queryCoach(clubId);
	}

	@Override
	public List<KeyValueBeanVo> queryClubCoach() {
		return  courseDao.queryClubCoach();
	}


}
