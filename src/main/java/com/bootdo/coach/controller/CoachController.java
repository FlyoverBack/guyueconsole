package com.bootdo.coach.controller;

import java.util.List;
import java.util.Map;

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

import com.bootdo.coach.domain.CoachDO;
import com.bootdo.coach.service.CoachService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 会员信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-22 09:22:03
 */
 
@Controller
@RequestMapping("/coach/coach")
public class CoachController {
	@Autowired
	private CoachService coachService;
	
	@GetMapping()
//	@RequiresPermissions("coach:coach:coach")
	String Coach(){
	    return "coach/coach/coach";
	}
	
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("coach:coach:coach")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CoachDO> coachList = coachService.list(query);
		int total = coachService.count(query);
		PageUtils pageUtils = new PageUtils(coachList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
//	@RequiresPermissions("coach:coach:add")
	String add(){
	    return "coach/coach/add";
	}

	@GetMapping("/edit/{coachId}")
//	@RequiresPermissions("coach:coach:edit")
	String edit(@PathVariable("coachId") String coachId,Model model){
		CoachDO coach = coachService.get(coachId);
		model.addAttribute("coach", coach);
	    return "coach/coach/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("coach:coach:add")
	public R save( CoachDO coach){
		if(coachService.save(coach)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
//	@RequiresPermissions("coach:coach:edit")
	public R update( CoachDO coach){
		coachService.update(coach);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
//	@RequiresPermissions("coach:coach:remove")
	public R remove( String coachId){
		if(coachService.remove(coachId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
//	@RequiresPermissions("coach:coach:batchRemove")
	public R remove(@RequestParam("ids[]") String[] coachIds){
		coachService.batchRemove(coachIds);
		return R.ok();
	}
	
}
