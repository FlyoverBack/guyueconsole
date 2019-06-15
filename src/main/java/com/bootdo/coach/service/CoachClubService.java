package com.bootdo.coach.service;

import com.bootdo.coach.domain.CoachClubDO;

import java.util.List;
import java.util.Map;

/**
 * VIEW
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-11 17:05:57
 */
public interface CoachClubService {
	
	CoachClubDO get(String coachName);
	
	List<CoachClubDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CoachClubDO coachClub);
	
	int update(CoachClubDO coachClub);
	
	int remove(String coachName);
	
	int batchRemove(String[] coachNames);
}
