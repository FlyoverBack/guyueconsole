package com.bootdo.club.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.club.domain.CourseLogDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 20:43:26
 */
@Mapper
@Component
public interface CourseLogDao {

	CourseLogDO get(Integer id);
	
	List<CourseLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseLogDO courseLog);
	
	int update(CourseLogDO courseLog);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
