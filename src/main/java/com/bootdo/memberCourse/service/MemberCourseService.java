package com.bootdo.memberCourse.service;

import com.bootdo.memberCourse.domain.MemberCourseDO;

import java.util.List;
import java.util.Map;

/**
 * 会员课程表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 15:29:35
 */
public interface MemberCourseService {
	
	MemberCourseDO get(String kcId);
	
	List<MemberCourseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberCourseDO memberCourse);
	
	int update(MemberCourseDO memberCourse);
	
	int remove(String kcId);
	
	int batchRemove(String[] kcIds);
}
