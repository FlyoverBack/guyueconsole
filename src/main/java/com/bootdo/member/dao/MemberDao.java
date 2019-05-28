package com.bootdo.member.dao;

import com.bootdo.member.domain.MemberDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员信息表
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-28 17:11:57
 */
@Mapper
public interface MemberDao {

	MemberDO get(String memId);
	
	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(String mem_Id);
	
	int batchRemove(String[] memIds);
}
