package com.bootdo.memberLesson.controller;

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

import com.bootdo.memberLesson.domain.MemberLessonDO;
import com.bootdo.memberLesson.service.MemberLessonService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 会员课时表
 *
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-07-18 14:53:19
 */

@Controller
@RequestMapping("/memberLesson/memberLesson")
public class MemberLessonController {
    @Autowired
    private MemberLessonService memberLessonService;

    @GetMapping()
    @RequiresPermissions("memberLesson:memberLesson:memberLesson")
    String MemberLesson() {
        return "memberLesson/memberLesson/memberLesson";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("memberLesson:memberLesson:memberLesson")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<MemberLessonDO> memberLessonList = memberLessonService.list(query);
        int total = memberLessonService.count(query);
        PageUtils pageUtils = new PageUtils(memberLessonList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("memberLesson:memberLesson:add")
    String add() {
        return "memberLesson/memberLesson/add";
    }

    @GetMapping("/edit/{memId}")
    @RequiresPermissions("memberLesson:memberLesson:edit")
    String edit(@PathVariable("memId") String memId, Model model) {
        MemberLessonDO memberLesson = memberLessonService.get(memId);
        model.addAttribute("memberLesson", memberLesson);
        return "memberLesson/memberLesson/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("memberLesson:memberLesson:add")
    public R save(MemberLessonDO memberLesson) {
        if (memberLessonService.save(memberLesson) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("memberLesson:memberLesson:edit")
    public R update(MemberLessonDO memberLesson) {
        memberLessonService.update(memberLesson);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("memberLesson:memberLesson:remove")
    public R remove(String memId) {
        if (memberLessonService.remove(memId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("memberLesson:memberLesson:batchRemove")
    public R remove(@RequestParam("ids[]") String[] memIds) {
        memberLessonService.batchRemove(memIds);
        return R.ok();
    }

}
