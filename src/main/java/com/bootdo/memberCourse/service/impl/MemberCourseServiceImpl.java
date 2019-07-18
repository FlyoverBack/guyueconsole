package com.bootdo.memberCourse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.memberCourse.dao.MemberCourseDao;
import com.bootdo.memberCourse.domain.MemberCourseDO;
import com.bootdo.memberCourse.service.MemberCourseService;


@Service
public class MemberCourseServiceImpl implements MemberCourseService {
    @Autowired
    private MemberCourseDao memberCourseDao;

    @Override
    public MemberCourseDO get(String kcId) {
        return memberCourseDao.get(kcId);
    }

    @Override
    public List<MemberCourseDO> list(Map<String, Object> map) {
        return memberCourseDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return memberCourseDao.count(map);
    }

    @Override
    public int save(MemberCourseDO memberCourse) {
        return memberCourseDao.save(memberCourse);
    }

    @Override
    public int update(MemberCourseDO memberCourse) {
        return memberCourseDao.update(memberCourse);
    }

    @Override
    public int remove(String kcId) {
        return memberCourseDao.remove(kcId);
    }

    @Override
    public int batchRemove(String[] kcIds) {
        return memberCourseDao.batchRemove(kcIds);
    }

}
