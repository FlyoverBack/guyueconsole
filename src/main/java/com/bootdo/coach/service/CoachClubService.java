package com.bootdo.coach.service;

import com.bootdo.coach.domain.CoachClubDO;

import java.util.List;
import java.util.Map;

/**
 * VIEW
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-20 23:18:01
 */
public interface CoachClubService {
	
	CoachClubDO get(String coachId);
	
	List<CoachClubDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CoachClubDO coachClub);
	
	int update(CoachClubDO coachClub);
	
	int remove(String coachId);
	
	int batchRemove(String[] coachIds);
}
