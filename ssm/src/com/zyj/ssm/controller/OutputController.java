package com.zyj.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyj.ssm.pojo.Input;
import com.zyj.ssm.pojo.Output;
import com.zyj.ssm.pojo.ProInOutput;
import com.zyj.ssm.service.OutputService;

@Controller
public class OutputController {
	@Autowired
	private OutputService os;
	
	@RequestMapping("/selectAllOutput.do")
	public String selectAllOutput(Model model) {
		List<Output> outputs = os.selectAllOutput();
		model.addAttribute("olist",outputs);
		return "searchOutput";
	}
	
	@RequestMapping("/insertOutput")
	public String insertOutput(Output output,int pid,Model model) {
//		model.addAttribute("msg","出库操作成功");
		os.insertOutput(output);
		return "forward:/updateOutCount.do?id="+pid+"&count="+output.getPcount();
	}
	
//	@RequestMapping("/insertInput.do")
//	public String insertInput(Input input,int pid,Model model){
//		is.insertInput(input);
////		return "forward:/selectAllInput.do";
//		return "forward:/updateCount.do?id="+pid+"&count="+input.getPcount();
//	}
	
	@RequestMapping("/selectOutputByKeyword.do")
	public String selectOutputByKeyword(ProInOutput proInOutput,Model model){
		List<Output> outputs = os.selectOutputByKeyword(proInOutput);
		int countTotal=0;
		double priceTotal=0;
		if(outputs!=null){
			for(Output output:outputs){
				countTotal++;
				priceTotal+=output.getPrice();
			}
		}
		model.addAttribute("countTotal",countTotal);
		model.addAttribute("priceTotal",priceTotal);
		model.addAttribute("olist",outputs);
		return "searchOutputResult";
	}
	
	@RequestMapping("/selectOutByName.do")
	public String selectOutByName(Model model){
		List<Output> outputs = os.selectOutByName();
		int countTotal=0;
		if(outputs!=null){
			for(Output output:outputs){
				countTotal++;
			}
		}
		model.addAttribute("countTotal",countTotal);
		model.addAttribute("olist",outputs);
		return "groupByOutputResult";
	}
}
