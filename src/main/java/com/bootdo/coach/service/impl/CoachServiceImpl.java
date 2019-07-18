package com.bootdo.coach.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.coach.dao.CoachDao;
import com.bootdo.coach.domain.CoachDO;
import com.bootdo.coach.service.CoachService;



@Service
public class CoachServiceImpl implements CoachService {
	@Autowired
	private CoachDao coachDao;
	
	@Override
	public CoachDO get(String coachId){
		return coachDao.get(coachId);
	}
	
	@Override
	public List<Map<String,Object>> list(Map<String, Object> map){
		return coachDao.list(map);
	}

	@Override
	public List<Map<String, Object>> courseList(Map<String, Object> map) {
		return coachDao.courseList(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return coachDao.count(map);
	}
	
	@Override
	public int save(CoachDO coach){
		return coachDao.save(coach);
	}
	
	@Override
	public int update(CoachDO coach){
		return coachDao.update(coach);
	}
	
	@Override
	public int remove(String coachId){
		return coachDao.remove(coachId);
	}
	
	@Override
	public int batchRemove(String[] coachIds){
		return coachDao.batchRemove(coachIds);
	}
	
}
