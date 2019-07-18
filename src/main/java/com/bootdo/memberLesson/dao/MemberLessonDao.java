package com.bootdo.memberLesson.dao;

import com.bootdo.memberLesson.domain.MemberLessonDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员课时表
 *
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 14:53:19
 */
@Mapper
public interface MemberLessonDao {

    MemberLessonDO get(String memId);

    List<MemberLessonDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MemberLessonDO memberLesson);

    int update(MemberLessonDO memberLesson);

    int remove(String mem_id);

    int batchRemove(String[] memIds);
}
