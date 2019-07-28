package com.bootdo.club.service.impl;

import com.bootdo.club.dao.CourseLogDao;
import com.bootdo.club.domain.CourseLogDO;
import com.bootdo.club.service.CourseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class CourseLogServiceImpl implements CourseLogService {
	@Autowired
	private CourseLogDao courseLogDao;
	
	@Override
	public CourseLogDO get(Integer id){
		return courseLogDao.get(id);
	}
	
	@Override
	public List<CourseLogDO> list(Map<String, Object> map){
		return courseLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return courseLogDao.count(map);
	}
	
	@Override
	public int save(CourseLogDO courseLog){
		return courseLogDao.save(courseLog);
	}
	
	@Override
	public int update(CourseLogDO courseLog){
		return courseLogDao.update(courseLog);
	}
	
	@Override
	public int remove(Integer id){
		return courseLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return courseLogDao.batchRemove(ids);
	}
	
}
