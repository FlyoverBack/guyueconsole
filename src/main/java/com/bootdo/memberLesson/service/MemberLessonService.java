package com.bootdo.memberLesson.service;

import com.bootdo.memberLesson.domain.MemberLessonDO;

import java.util.List;
import java.util.Map;

/**
 * 会员课时表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 14:53:19
 */
public interface MemberLessonService {
	
	MemberLessonDO get(String memId);
	
	List<MemberLessonDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberLessonDO memberLesson);
	
	int update(MemberLessonDO memberLesson);
	
	int remove(String memId);
	
	int batchRemove(String[] memIds);
}
