package com.zyj.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.zyj.ssm.pojo.Bigtype;
import com.zyj.ssm.pojo.Smalltype;
import com.zyj.ssm.service.BigTypeService;
import com.zyj.ssm.service.SmalltypeService;

@Controller
public class SmalltypeController {
	@Autowired
	private SmalltypeService ss;
	
	@Autowired
	private BigTypeService bs;
	
	/*@RequestMapping("/selectAllSmalltype.do")
	public String selectAllSmalltype(Model model){
		List<Smalltype> smalltypes = ss.selectAllSmalltype();
		model.addAttribute("sList",smalltypes);
		return "";
	}
	*/
	@RequestMapping("/selectByBid.do")
	public void selectByBid(Integer bid,HttpServletResponse response){
		List<Smalltype> small_list = ss.selectByBid(bid);
		//System.out.println("sssss:" + small_list.size());
		JSONArray array = new JSONArray(); //创建json数组
		for(Smalltype small : small_list){
			JSONObject jobj = new JSONObject();//json对象
			try {
				jobj.put("sid", small.getId());
				jobj.put("sname", small.getName());
				array.add(jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			//System.out.println("fff:" + array.toString());
			//向页面返回内容
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(array.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/showInsertSmalltype.do")
	public String showInsertSmall(Model model){
		List<Bigtype> bigtypes = bs.selectAll();
		model.addAttribute("bigList",bigtypes);
		return "addSmallType";
	}
	
	@RequestMapping("/insertSmalltype.do")
	public String insertSmalltype(Smalltype smalltype,Model model){
		ss.insertSmalltype(smalltype);
		return "forward:/showInsertProduct.do";
	}
}
