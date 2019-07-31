package com.zyj.ssm.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyj.ssm.pojo.Bigtype;
import com.zyj.ssm.pojo.Products;
import com.zyj.ssm.service.BigTypeService;
import com.zyj.ssm.service.ProductsService;
import com.zyj.ssm.util.PageUtils;

@Controller
public class ProductsController {

	private PageUtils pageUtils = new PageUtils();
	@Autowired
	private ProductsService ps;
	
	@Autowired
	private BigTypeService bs;
	
	@RequestMapping("/selectAll.do")
	public String selectAll(Model model,Integer cp){
		System.out.println("co:"+cp);
		
		//给分页组件设置内容
		pageUtils.setPageSize(20);
		if(cp==null){
			pageUtils.setCurrentPage(1);
		}else {
			pageUtils.setCurrentPage(cp);
		}
		
		pageUtils.setTotal(ps.selectCount());//设置总记录数
		int pageTotal = pageUtils.getTotal()%pageUtils.getPageSize()==0?
				pageUtils.getTotal()/pageUtils.getPageSize():
					pageUtils.getTotal()/pageUtils.getPageSize()+1;
		pageUtils.setPageTotal(pageTotal);//设置页数
		List<Products> products = ps.selectAll(
				new RowBounds((pageUtils.getCurrentPage()-1)*pageUtils.getPageSize(),
						pageUtils.getPageSize()));
		
		if(products == null){
			model.addAttribute("msg","数据加载不到请重试");
		}else {
			model.addAttribute("pList",products);
			
			model.addAttribute("p",pageUtils);
			model.addAttribute("URL","selectAll.do");
		}
		List<Bigtype> bigtypes = bs.selectAll();
		model.addAttribute("bigList",bigtypes);
		return "index";
	}
	
	// 根据输入的名字进行查询
	@RequestMapping("/selectByName.do")
	public String selectByName(String keyword,Model model) {
		List<Products> products = ps.selectByName(keyword);
		if(products==null){
			model.addAttribute("msg","没有找到相关数据");
		}else{
			model.addAttribute("pList",products);
		}
		return "searchResult";
	}
	
	// 根据输入的关键字进行查询
//	@RequestMapping("/selectByKeyword.do")
//	public String selectByKeyword(String keyword,Products product, Model model) {
//		if(product.getBid()==0){
//			List<Products> products = ps.selectByName(keyword);
//			if (products == null) {
//				model.addAttribute("msg", "没有找到相关数据");
//			} else {
//				model.addAttribute("pList", products);
//			}
//		}else {
//			List<Products> products = ps.selectByKeyword(product);
//			if (products == null) {
//				model.addAttribute("msg", "没有找到相关数据");
//			} else {
//				model.addAttribute("pList", products);
//			}
//		}
//		return "searchResult";
//	}
	
	// 根据输入的关键字进行查询
	@RequestMapping("/selectByKeyword.do")
	public String selectByKeyword(Products product, Model model) {
		List<Products> products = ps.selectByKeyword(product);
		List<Bigtype> bigtypes = bs.selectAll();
		model.addAttribute("bigList",bigtypes);
		if(products==null){
			model.addAttribute("msg","没有找到相关数据");
		}else{
			model.addAttribute("pList",products);
		}
		return "searchResult";
	}
	
	// 根据id来检索入库物料信息
	@RequestMapping("/selectByIdIn.do")
	public String selectByIdIn(int id,Model model){
		Products product = ps.selectById(id);
		if(product==null){
			model.addAttribute("msg","没有找到相关数据");
		}else{
			model.addAttribute("p",product);
		}
		return "forward:/provider/selectAllIn.do";
	}

	// 根据id来检索出库物料信息
	@RequestMapping("/selectByIdOut.do")
	public String selectByIdOut(int id, Model model) {
		Products product = ps.selectById(id);
		if (product == null) {
			model.addAttribute("msg", "没有找到相关数据");
		} else {
			model.addAttribute("p", product);
		}
		return "forward:/provider/selectAllOut.do";
	}

	@RequestMapping("/updateInCount.do")
	public String updateInCount(Products products, Model model) {
		ps.updateInCount(products);
		return "forward:/selectAllInput.do";
	}

	@RequestMapping("/updateOutCount.do")
	public String updateOutCount(Products products, Model model) {
		ps.updateOutCount(products);
		return "forward:/selectAllOutput.do";
	}

	@RequestMapping("/showInsertProduct.do")
	public String showInsertProduct(Model model) {
		List<Bigtype> bigtypes = bs.selectAll();
		model.addAttribute("bigList", bigtypes);
		return "newInput";
	}

	@RequestMapping("/insertProduct.do")
	public String insertProduct(Products products, Model model) {
		ps.insertProduct(products);
		return "forward:/selectAll.do";
	}
	
	@RequestMapping("/showUpdateProduct.do")
	public String showUpdateProduct(int id,Model model) {
		List<Bigtype> bigtypes = bs.selectAll();
		model.addAttribute("bigList", bigtypes);
		Products products = ps.selectById(id);
		model.addAttribute("p",products);
		return "showPro";
	}

	@RequestMapping("/updateProduct.do")
	public String updateProduct(Products products, Model model) {
		ps.updateProduct(products);
		return "forward:/selectAll.do";
	}
}

