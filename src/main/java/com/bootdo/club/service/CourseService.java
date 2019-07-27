package com.bootdo.club.service;


import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.domain.CourseDO;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;

import java.util.List;
import java.util.Map;

/**
 * 课程表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 17:01:41
 */
public interface CourseService {
	
	CourseDO get(String courseId);

	PageUtils list(Map<String, Object> params);
	
	int count(Map<String, Object> map);
	
	R update(CourseDO course);
	
	int save(CourseDO course);
	
	R remove(String courseId);
	
	int batchRemove(String[] courseIds);

	List<Integer> queryCoach(String clubId);

	List<KeyValueBeanVo> queryClubCoach();
}
