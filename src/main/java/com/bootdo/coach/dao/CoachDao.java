package com.bootdo.coach.dao;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.coach.domain.CoachDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 教练信息表
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-12 13:39:16
 */
@Mapper
public interface CoachDao {

	CoachDO get(String coachId);
	
	List<Map<String,Object>> list(Map<String, Object> map);

	List<Map<String,Object>> courseList(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(CoachDO coach);
	
	int update(CoachDO coach);
	
	int remove(String coach_Id);
	
	int batchRemove(String[] coachIds);

    List<KeyValueBeanVo> getListByIds(@Param("coachIds") List<String> coachIds);

    List<KeyValueBeanVo> getCoachAll();
}
