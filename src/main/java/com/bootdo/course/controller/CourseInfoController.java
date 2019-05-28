package com.bootdo.course.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.common.utils.CommParams;
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

import com.bootdo.course.domain.CourseInfoDO;
import com.bootdo.course.service.CourseInfoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 课程信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-21 23:30:09
 */
 
@Controller
@RequestMapping("/course/courseInfo")
public class CourseInfoController {

	private static final Logger logger = LoggerFactory.getLogger(CourseInfoController.class);

	@Autowired
	private CourseInfoService courseInfoService;
	
	@GetMapping()
	@RequiresPermissions("course:courseInfo:courseInfo")
	String CourseInfo(){
	    return "course/courseInfo/courseInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("course:courseInfo:courseInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CourseInfoDO> courseInfoList = courseInfoService.list(query);
		for(CourseInfoDO courseInfoDO:courseInfoList){
			courseInfoDO.setInfoPic(CommParams.WEB_URL+courseInfoDO.getInfoPic().replace("/app/test",""));
		}
		int total = courseInfoService.count(query);
		PageUtils pageUtils = new PageUtils(courseInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("course:courseInfo:add")
	String add(){
	    return "course/courseInfo/add";
	}

	@GetMapping("/edit/{courseType}")
	@RequiresPermissions("course:courseInfo:edit")
	String edit(@PathVariable("courseType") String courseType,Model model){
		CourseInfoDO courseInfo = courseInfoService.get(courseType);
		logger.info("--------------------"+courseInfo.toString());
		model.addAttribute("courseInfo", courseInfo);
	    return "course/courseInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("course:courseInfo:add")
	public R save( CourseInfoDO courseInfo){
		if(courseInfoService.save(courseInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("course:courseInfo:edit")
	public R update( CourseInfoDO courseInfo){
		courseInfoService.update(courseInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("course:courseInfo:remove")
	public R remove( String courseType){
		if(courseInfoService.remove(courseType)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("course:courseInfo:batchRemove")
	public R remove(@RequestParam("ids[]") String[] courseTypes){
		courseInfoService.batchRemove(courseTypes);
		return R.ok();
	}
	
}
