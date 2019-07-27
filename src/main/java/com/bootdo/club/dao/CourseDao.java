package com.bootdo.club.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.domain.CourseDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * 课程表
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 17:01:41
 */
@Mapper
@Component
public interface CourseDao {

	CourseDO get(String courseId);
	
	List<CourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseDO course);
	
	int update(CourseDO course);
	
	int remove(String course_id);
	
	int batchRemove(String[] courseIds);

	List<Integer> queryCoach(@Param("clubId") String clubId);

	List<KeyValueBeanVo> queryClubCoach();
}
