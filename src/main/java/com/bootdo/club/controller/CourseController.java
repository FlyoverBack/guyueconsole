package com.bootdo.club.controller;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.domain.CourseDO;
import com.bootdo.club.service.ClubService;
import com.bootdo.club.service.CourseService;
import com.bootdo.coach.service.CoachService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;

/**
 * 课程表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-21 17:01:41
 */
 
@Controller
@RequestMapping("/club/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private ClubService clubService;
	@Autowired
	private CoachService coachService;


	
	@GetMapping()
	@RequiresPermissions("club:course:course")
	String Course(){
	    return "club/course/course";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("club:course:course")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据

		return courseService.list(params);
	}
	
	@GetMapping("/add")
	@RequiresPermissions("club:course:add")
	String add(Model model){
		model.addAttribute("clubAll",clubService.getClubByAll());
		model.addAttribute("coachAll",coachService.getCoachAll());
		//model.addAttribute("clubAll",clubService.getClubByAll());
		return "club/course/add";
	}

	@GetMapping("/edit/{courseId}")
	@RequiresPermissions("club:course:edit")
	String edit(@PathVariable("courseId") String courseId,Model model){
		CourseDO course = courseService.get(courseId);
		model.addAttribute("course", course);
		model.addAttribute("courseList", course.getCourseLogDOList());
	    return "club/course/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("club:course:add")
	public R save( CourseDO course){
		if(courseService.save(course)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("club:course:edit")
	public R update( CourseDO course){
		return courseService.update(course);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("club:course:remove")
	public R remove( String courseId){
		return courseService.remove(courseId);
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("club:course:batchRemove")
	public R remove(@RequestParam("ids[]") String[] courseIds){
		courseService.batchRemove(courseIds);
		return R.ok();
	}


	@GetMapping( "/queryCoach")
	@ResponseBody
	@RequiresPermissions("club:course:add")
	public Map<String,Object> queryCoach(@RequestParam("clubId") String clubId){
		Map<String,Object> map  =new HashMap<>();
		List<Integer> integers = courseService.queryCoach(clubId);
		List<KeyValueBeanVo> keyValueBeanVos = courseService.queryClubCoach();
		if(!CollectionUtils.isEmpty(integers)){
			for (int i=keyValueBeanVos.size()-1;i>=0;i--){
                if (integers.contains(Integer.valueOf(keyValueBeanVos.get(i).getKey()))){
					keyValueBeanVos.remove(i);
				}
			}
		}
		map.put("courseList",keyValueBeanVos);
		return map;
	}





}
