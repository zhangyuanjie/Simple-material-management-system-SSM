package com.zyj.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyj.ssm.pojo.Input;
import com.zyj.ssm.pojo.ProInOutput;
import com.zyj.ssm.pojo.Provider;
import com.zyj.ssm.service.InputService;
import com.zyj.ssm.service.ProviderService;

@Controller
public class InputController {

	@Autowired
	private InputService is;
	
	@Autowired
	private ProviderService ps;
	
	@RequestMapping("/insertInput.do")
	public String insertInput(Input input,int pid,Model model){
		is.insertInput(input);
//		return "forward:/selectAllInput.do";
		return "forward:/updateInCount.do?id="+pid+"&count="+input.getPcount();
	}
	
	@RequestMapping("/selectAllInput.do")
	public String selectAllInput(Model model){
		List<Input> inputs = is.selectAllInput();
		List<Provider> providers = ps.selectAll();
		model.addAttribute("proList",providers);
		model.addAttribute("ilist",inputs);
		return "searchInput";
	}
	
	@RequestMapping("/selectInputByKeyword.do")
	public String selectInputByKeyword(ProInOutput proInOutput,Model model){
		List<Input> inputs = is.selectInputByKeyword(proInOutput);
		int countTotal=0;
		double priceTotal=0;
		if(inputs!=null){
			for(Input input:inputs){
				countTotal++;
				priceTotal+=input.getPrice();
			}
		}
		model.addAttribute("countTotal",countTotal);
		model.addAttribute("priceTotal",priceTotal);
		model.addAttribute("ilist",inputs);
		return "searchInputResult";
	}
	
	@RequestMapping("/selectInByName.do")
	public String selectInByName(Model model){
		List<Input> inputs = is.selectInByName();
		int countTotal=0;
		double priceTotal=0;
		if(inputs!=null){
			for(Input input:inputs){
				countTotal++;
				priceTotal+=input.getPrice();
			}
		}
		model.addAttribute("countTotal",countTotal);
		model.addAttribute("priceTotal",priceTotal);
		model.addAttribute("ilist",inputs);
		return "groupByInputResult";
	}
}
