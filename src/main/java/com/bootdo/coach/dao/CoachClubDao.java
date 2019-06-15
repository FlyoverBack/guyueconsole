package com.bootdo.coach.dao;

import com.bootdo.coach.domain.CoachClubDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * VIEW
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-11 17:05:57
 */
@Mapper
public interface CoachClubDao {

	CoachClubDO get(String coachName);
	
	List<CoachClubDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CoachClubDO coachClub);
	
	int update(CoachClubDO coachClub);
	
	int remove(String coach_name);
	
	int batchRemove(String[] coachNames);
}
