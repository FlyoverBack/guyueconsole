package com.bootdo.coach.service;

import com.bootdo.coach.domain.CoachDO;

import java.util.List;
import java.util.Map;

/**
 * 会员信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-22 09:22:03
 */
public interface CoachService {
	
	CoachDO get(String coachId);
	
	List<CoachDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CoachDO coach);
	
	int update(CoachDO coach);
	
	int remove(String coachId);
	
	int batchRemove(String[] coachIds);
}
