package com.bootdo.banner.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.CommParams;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.banner.domain.BannerInfoDO;
import com.bootdo.banner.service.BannerInfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-23 14:43:14
 */
 
@Controller
@RequestMapping("/banner/bannerInfo")
public class BannerInfoController {
	@Autowired
	private BannerInfoService bannerInfoService;
	
	@GetMapping()
	@RequiresPermissions("banner:bannerInfo:bannerInfo")
	String BannerInfo(){
	    return "banner/bannerInfo/bannerInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("banner:bannerInfo:bannerInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BannerInfoDO> bannerInfoList = bannerInfoService.list(query);
		for(BannerInfoDO bannerInfoDO: bannerInfoList){
			bannerInfoDO.setBannerImgUrl(CommParams.WEB_URL+bannerInfoDO.getBannerImgUrl().replace("/app/test",""));
			bannerInfoDO.setDetailImgUrl(CommParams.WEB_URL+bannerInfoDO.getDetailImgUrl().replace("/app/test",""));
		}
		int total = bannerInfoService.count(query);
		PageUtils pageUtils = new PageUtils(bannerInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("banner:bannerInfo:add")
	String add(){
	    return "banner/bannerInfo/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("banner:bannerInfo:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		BannerInfoDO bannerInfo = bannerInfoService.get(id);
		model.addAttribute("bannerInfo", bannerInfo);
	    return "banner/bannerInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("banner:bannerInfo:add")
	public R save( BannerInfoDO bannerInfo){
		if(bannerInfoService.save(bannerInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("banner:bannerInfo:edit")
	public R update( BannerInfoDO bannerInfo){
		bannerInfoService.update(bannerInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("banner:bannerInfo:remove")
	public R remove( Integer id){
		if(bannerInfoService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("banner:bannerInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		bannerInfoService.batchRemove(ids);
		return R.ok();
	}
	
}
