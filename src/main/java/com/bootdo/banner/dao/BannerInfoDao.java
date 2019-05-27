package com.bootdo.banner.dao;

import com.bootdo.banner.domain.BannerInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-23 14:43:14
 */
@Mapper
public interface BannerInfoDao {

	BannerInfoDO get(Integer id);
	
	List<BannerInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerInfoDO bannerInfo);
	
	int update(BannerInfoDO bannerInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
