package com.bootdo.member.controller;

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

import com.bootdo.member.domain.MemberDO;
import com.bootdo.member.service.MemberService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 会员信息表
 * 
 * @author ybbbbbbb
 * @email ybbbbbbb@qq.com
 * @date 2019-05-28 17:11:57
 */
 
@Controller
@RequestMapping("/member/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping()
	@RequiresPermissions("member:member:member")
	String Member(){
	    return "member/member/member";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("member:member:member")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MemberDO> memberList = memberService.list(query);
		for(MemberDO memberDO:memberList){
			memberDO.setIcon(CommParams.WEB_URL+memberDO.getIcon().replace("/app/test",""));
		}
		int total = memberService.count(query);
		PageUtils pageUtils = new PageUtils(memberList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("member:member:add")
	String add(){
	    return "member/member/add";
	}

	@GetMapping("/edit/{memId}")
	@RequiresPermissions("member:member:edit")
	String edit(@PathVariable("memId") String memId,Model model){
		MemberDO member = memberService.get(memId);
		model.addAttribute("member", member);
	    return "member/member/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("member:member:add")
	public R save( MemberDO member){
		if(memberService.save(member)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("member:member:edit")
	public R update( MemberDO member){
		memberService.update(member);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("member:member:remove")
	public R remove( String memId){
		if(memberService.remove(memId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("member:member:batchRemove")
	public R remove(@RequestParam("ids[]") String[] memIds){
		memberService.batchRemove(memIds);
		return R.ok();
	}
	
}
