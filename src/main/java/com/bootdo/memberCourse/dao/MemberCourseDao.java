package com.bootdo.memberCourse.dao;

import com.bootdo.memberCourse.domain.MemberCourseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员课程表
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 15:29:35
 */
@Mapper
public interface MemberCourseDao {

	MemberCourseDO get(String kcId);
	
	List<MemberCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberCourseDO memberCourse);
	
	int update(MemberCourseDO memberCourse);
	
	int remove(String kc_id);
	
	int batchRemove(String[] kcIds);
}
