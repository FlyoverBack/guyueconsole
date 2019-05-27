package com.bootdo.banner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.banner.dao.BannerInfoDao;
import com.bootdo.banner.domain.BannerInfoDO;
import com.bootdo.banner.service.BannerInfoService;



@Service
public class BannerInfoServiceImpl implements BannerInfoService {
	@Autowired
	private BannerInfoDao bannerInfoDao;
	
	@Override
	public BannerInfoDO get(Integer id){
		return bannerInfoDao.get(id);
	}
	
	@Override
	public List<BannerInfoDO> list(Map<String, Object> map){
		return bannerInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bannerInfoDao.count(map);
	}
	
	@Override
	public int save(BannerInfoDO bannerInfo){
		return bannerInfoDao.save(bannerInfo);
	}
	
	@Override
	public int update(BannerInfoDO bannerInfo){
		return bannerInfoDao.update(bannerInfo);
	}
	
	@Override
	public int remove(Integer id){
		return bannerInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return bannerInfoDao.batchRemove(ids);
	}
	
}
