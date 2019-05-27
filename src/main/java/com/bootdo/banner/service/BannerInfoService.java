package com.bootdo.banner.service;

import com.bootdo.banner.domain.BannerInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-23 14:43:14
 */
public interface BannerInfoService {
	
	BannerInfoDO get(Integer id);
	
	List<BannerInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerInfoDO bannerInfo);
	
	int update(BannerInfoDO bannerInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
