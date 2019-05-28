package com.bootdo.member.service;

import com.bootdo.member.domain.MemberDO;

import java.util.List;
import java.util.Map;

/**
 * 会员信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-28 17:11:57
 */
public interface MemberService {
	
	MemberDO get(String memId);
	
	List<MemberDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(String memId);
	
	int batchRemove(String[] memIds);
}
