package com.bootdo.course.dao;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.course.domain.CourseInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 课程信息表
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-21 23:30:09
 */
@Mapper
public interface CourseInfoDao {

	CourseInfoDO get(String courseType);
	
	List<CourseInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CourseInfoDO courseInfo);
	
	int update(CourseInfoDO courseInfo);
	
	int remove(String course_type);
	
	int batchRemove(String[] courseTypes);

    List<KeyValueBeanVo> getCourseType(@Param("clubId") String clubId);
}
