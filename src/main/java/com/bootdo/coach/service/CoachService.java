package com.bootdo.coach.service;

import com.bootdo.coach.domain.CoachDO;

import java.util.List;
import java.util.Map;

/**
 * 教练信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-12 13:39:16
 */
public interface CoachService {
	
	CoachDO get(String coachId);
	
	List<Map<String,Object>> list(Map<String, Object> map);

	List<Map<String,Object>> courseList(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CoachDO coach);
	
	int update(CoachDO coach);
	
	int remove(String coachId);
	
	int batchRemove(String[] coachIds);
}
