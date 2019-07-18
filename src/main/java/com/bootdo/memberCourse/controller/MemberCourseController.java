package com.bootdo.memberCourse.controller;

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

import com.bootdo.memberCourse.domain.MemberCourseDO;
import com.bootdo.memberCourse.service.MemberCourseService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 会员课程表
 *
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 15:29:35
 */

@Controller
@RequestMapping("/memberCourse/memberCourse")
public class MemberCourseController {
    @Autowired
    private MemberCourseService memberCourseService;

    @GetMapping()
    @RequiresPermissions("memberCourse:memberCourse:memberCourse")
    String MemberCourse() {
        return "memberCourse/memberCourse/memberCourse";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("memberCourse:memberCourse:memberCourse")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MemberCourseDO> memberCourseList = memberCourseService.list(query);
        int total = memberCourseService.count(query);
        PageUtils pageUtils = new PageUtils(memberCourseList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("memberCourse:memberCourse:add")
    String add() {
        return "memberCourse/memberCourse/add";
    }

    @GetMapping("/edit/{kcId}")
    @RequiresPermissions("memberCourse:memberCourse:edit")
    String edit(@PathVariable("kcId") String kcId, Model model) {
        MemberCourseDO memberCourse = memberCourseService.get(kcId);
        model.addAttribute("memberCourse", memberCourse);
        return "memberCourse/memberCourse/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("memberCourse:memberCourse:add")
    public R save(MemberCourseDO memberCourse) {
        if (memberCourseService.save(memberCourse) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("memberCourse:memberCourse:edit")
    public R update(MemberCourseDO memberCourse) {
        memberCourseService.update(memberCourse);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("memberCourse:memberCourse:remove")
    public R remove(String kcId) {
        if (memberCourseService.remove(kcId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("memberCourse:memberCourse:batchRemove")
    public R remove(@RequestParam("ids[]") String[] kcIds) {
        memberCourseService.batchRemove(kcIds);
        return R.ok();
    }

}
