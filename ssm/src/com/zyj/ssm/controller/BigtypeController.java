package com.zyj.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyj.ssm.pojo.Bigtype;
import com.zyj.ssm.service.BigTypeService;

@Controller
public class BigtypeController {

	@Autowired
	private BigTypeService bs;
	
	@RequestMapping("/selectAllBigtype.do")
	public String selectAll(Model model){
		List<Bigtype> bigtypes = bs.selectAll();
		model.addAttribute("bigList",bigtypes);
		return "index";
	}
	
	@RequestMapping("/showInsertBigtype.do")
	public String showInsertBigtype(){
		return "addBigType";
	}
	
	@RequestMapping("/insertBigtype.do")
	public String insertBigtype(Bigtype bigtype, Model model){
		bs.insertBigtype(bigtype);
		return "forward:/showInsertProduct.do";
	}
}
