package com.bootdo.coach.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.system.service.UserService1;
import com.bootdo.utils.getSeqNo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.bootdo.coach.domain.CoachClubDO;
import com.bootdo.coach.service.CoachClubService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * VIEW
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-06-20 23:18:01
 */
 
@Controller
@RequestMapping("/coach/coachClub")
public class CoachClubController {
	private static final Logger logger = LoggerFactory.getLogger(CoachClubController.class);
	@Autowired
	private CoachClubService coachClubService;
	@Autowired
	private UserService1 userService1;
	
	@GetMapping()
	@RequiresPermissions("coach:coachClub:coachClub")
	String CoachClub(){
	    return "coach/coachClub/coachClub";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("coach:coachClub:coachClub")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CoachClubDO> coachClubList = coachClubService.list(query);
		int total = coachClubService.count(query);
		PageUtils pageUtils = new PageUtils(coachClubList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("coach:coachClub:add")
	String add(){
	    return "coach/coachClub/add";
	}

	@GetMapping("/edit/{coachId}")
	@RequiresPermissions("coach:coachClub:edit")
	String edit(@PathVariable("coachId") String coachId,Model model){
		CoachClubDO coachClub = coachClubService.get(coachId);
		model.addAttribute("coachClub", coachClub);
	    return "coach/coachClub/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("coach:coachClub:add")
	public R save( CoachClubDO coachClub){
		if(coachClubService.save(coachClub)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("coach:coachClub:edit")
	public R update( CoachClubDO coachClub){
		coachClubService.update(coachClub);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("coach:coachClub:remove")
	public R remove( String coachId){
		if(coachClubService.remove(coachId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("coach:coachClub:batchRemove")
	public R remove(@RequestParam("ids[]") String[] coachIds){
		coachClubService.batchRemove(coachIds);
		return R.ok();
	}
	@ResponseBody
	@RequestMapping(value = "/initCoachId")
	public String initCoachId(){
		int index = 0;
		String maxId=userService1.getMaxId(2);
		logger.info("maxId==="+maxId);
		if(maxId!=null) {
			index = Integer.parseInt(maxId.substring(8));
		}
		String id= getSeqNo.getId(12,index,2);

		return id;
	}
}
