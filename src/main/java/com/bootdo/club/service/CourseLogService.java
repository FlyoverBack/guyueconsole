package com.bootdo.club.service;


import com.bootdo.club.domain.CourseLogDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 20:43:26
 */
public interface CourseLogService {
	
	CourseLogDO get(Integer id);
	
	List<CourseLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseLogDO courseLog);
	
	int update(CourseLogDO courseLog);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
