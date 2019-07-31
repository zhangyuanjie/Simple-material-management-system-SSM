package com.zyj.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyj.ssm.pojo.Provider;
import com.zyj.ssm.service.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderController {

	@Autowired
	private ProviderService ps;
	
	@RequestMapping("/selectAllIn.do")
	public String selectAllIn(Model model){
		List<Provider> providers = ps.selectAll();
		if(providers==null){
			model.addAttribute("msg","查询失败");
		}else{
			model.addAttribute("proList",providers);
		}
		return "input";
	}
	
	@RequestMapping("/selectAllOut.do")
	public String selectAllOut(Model model){
		List<Provider> providers = ps.selectAll();
		if(providers==null){
			model.addAttribute("msg","查询失败");
		}else{
			model.addAttribute("proList",providers);
		}
		return "output";
	}
	
	@RequestMapping("/showInsertProvider.do")
	public String showInsertProvider(){
		return "addGys";
	}
	
	@RequestMapping("/insertProvider.do")
	public String insertProvider(Provider provider,Model model){
		ps.insertProvider(provider);
		model.addAttribute("msg","添加供应商成功！");
		return "forward:/provider/showInsertProvider.do";
	}
}
