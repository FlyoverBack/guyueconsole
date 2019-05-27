package com.bootdo.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.course.dao.CourseInfoDao;
import com.bootdo.course.domain.CourseInfoDO;
import com.bootdo.course.service.CourseInfoService;



@Service
public class CourseInfoServiceImpl implements CourseInfoService {
	@Autowired
	private CourseInfoDao courseInfoDao;
	
	@Override
	public CourseInfoDO get(String courseType){
		return courseInfoDao.get(courseType);
	}
	
	@Override
	public List<CourseInfoDO> list(Map<String, Object> map){
		return courseInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseInfoDao.count(map);
	}
	
	@Override
	public int save(CourseInfoDO courseInfo){
		return courseInfoDao.save(courseInfo);
	}
	
	@Override
	public int update(CourseInfoDO courseInfo){
		return courseInfoDao.update(courseInfo);
	}
	
	@Override
	public int remove(String courseType){
		return courseInfoDao.remove(courseType);
	}
	
	@Override
	public int batchRemove(String[] courseTypes){
		return courseInfoDao.batchRemove(courseTypes);
	}
	
}
