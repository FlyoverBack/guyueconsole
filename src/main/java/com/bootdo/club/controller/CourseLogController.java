package com.bootdo.club.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.club.domain.CourseLogDO;
import com.bootdo.club.service.CourseLogService;
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

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 20:58:16
 */
 
@Controller
@RequestMapping("/system/courseLog")
public class CourseLogController {
	@Autowired
	private CourseLogService courseLogService;
	
	@GetMapping()
	@RequiresPermissions("system:courseLog:courseLog")
	String CourseLog(){
	    return "system/courseLog/courseLog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:courseLog:courseLog")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseLogDO> courseLogList = courseLogService.list(query);
		int total = courseLogService.count(query);
		PageUtils pageUtils = new PageUtils(courseLogList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:courseLog:add")
	String add(){
	    return "system/courseLog/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:courseLog:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		CourseLogDO courseLog = courseLogService.get(id);
		model.addAttribute("courseLog", courseLog);
	    return "system/courseLog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:courseLog:add")
	public R save( CourseLogDO courseLog){
		if(courseLogService.save(courseLog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:courseLog:edit")
	public R update( CourseLogDO courseLog){
		courseLogService.update(courseLog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:courseLog:remove")
	public R remove( Integer id){
		if(courseLogService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:courseLog:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		courseLogService.batchRemove(ids);
		return R.ok();
	}
	
}
