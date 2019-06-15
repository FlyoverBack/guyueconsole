package com.bootdo.coach.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.coach.dao.CoachClubDao;
import com.bootdo.coach.domain.CoachClubDO;
import com.bootdo.coach.service.CoachClubService;



@Service
public class CoachClubServiceImpl implements CoachClubService {
	@Autowired
	private CoachClubDao coachClubDao;
	
	@Override
	public CoachClubDO get(String coachName){
		return coachClubDao.get(coachName);
	}
	
	@Override
	public List<CoachClubDO> list(Map<String, Object> map){
		return coachClubDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return coachClubDao.count(map);
	}
	
	@Override
	public int save(CoachClubDO coachClub){
		return coachClubDao.save(coachClub);
	}
	
	@Override
	public int update(CoachClubDO coachClub){
		return coachClubDao.update(coachClub);
	}
	
	@Override
	public int remove(String coachName){
		return coachClubDao.remove(coachName);
	}
	
	@Override
	public int batchRemove(String[] coachNames){
		return coachClubDao.batchRemove(coachNames);
	}
	
}
