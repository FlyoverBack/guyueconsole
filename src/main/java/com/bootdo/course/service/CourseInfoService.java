package com.bootdo.course.service;

import com.bootdo.course.domain.CourseInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 课程信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-21 23:30:09
 */
public interface CourseInfoService {
	
	CourseInfoDO get(String courseType);
	
	List<CourseInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseInfoDO courseInfo);
	
	int update(CourseInfoDO courseInfo);
	
	int remove(String courseType);
	
	int batchRemove(String[] courseTypes);
}
