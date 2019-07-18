package com.bootdo.club.controller;

import com.bootdo.base.domain.KeyValueBeanVo;
import com.bootdo.club.domain.ClubQueryVo;
import com.bootdo.club.domain.ClubResDo;
import com.bootdo.club.service.ClubService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by liujie01 on 2019/7/8.
 */
@Controller
@RequestMapping("/club/clubInfo")
public class ClubController {

    @Autowired
    private ClubService cludService;



    @GetMapping()
    @RequiresPermissions("club:club:clubList")
    public  String cludList(){
       return "club/club/clubList";
    }


    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("club:club:clubList")
     public PageUtils list(ClubQueryVo vo){
        return  cludService.list(vo);
    }


    @GetMapping("/edit/{clubId}")
    @RequiresPermissions("club:club:edit")
    String edit(@PathVariable("clubId") String clubId, Model model) {
        ClubResDo clubDo = cludService.get(clubId);
        List<KeyValueBeanVo> lists=new ArrayList<>(8);
        lists.add(new KeyValueBeanVo("0","全部"));
        lists.add(new KeyValueBeanVo("1","周一"));
        lists.add(new KeyValueBeanVo("2","周二"));
        lists.add(new KeyValueBeanVo("3","周三"));
        lists.add(new KeyValueBeanVo("4","周四"));
        lists.add(new KeyValueBeanVo("5","周五"));
        lists.add(new KeyValueBeanVo("6","周六"));
        lists.add(new KeyValueBeanVo("7","周日"));
        List<KeyValueBeanVo> courseTypes=cludService.getCourseType();

        //todo  以上放枚举
        model.addAttribute("courseTypes", courseTypes);
        model.addAttribute("businessType", lists);
        model.addAttribute("clubDo", clubDo);
        return "club/club/edit";
    }




    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @RequiresPermissions("club:club:edit")
    public R update(ClubResDo clubDo){
        return cludService.updateClubDetails(clubDo);
    }





}
