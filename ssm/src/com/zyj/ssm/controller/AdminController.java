package com.zyj.ssm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zyj.ssm.pojo.Admin;
import com.zyj.ssm.service.AdminService;
import com.zyj.ssm.util.MD5Code;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService as;
	
	@RequestMapping("/showLogin.do")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String selectOne(Admin admin,Model model,HttpServletRequest request) throws ParseException{
		MD5Code md5=new MD5Code();
		admin.setPwd(md5.getMD5ofStr(admin.getPwd()));
		System.out.println("admin:"+admin.getName());
		Admin admin2 = as.selectOne(admin);
		String name = admin.getName();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(admin2==null){//表示找不到，登录失败
			admin2 = as.selectByName(name);
			if(admin2==null){//用户名错误
				model.addAttribute("loginError","用户名不存在");
			}else {
				if(admin2.getCount()==0){//第一次登录失败，记录第一次登录失败的时间
					as.updateFirstErrorLog(name);
					model.addAttribute("loginError","密码错误");//传数据至jsp界面
				}else {
					Date now=sdf.parse(sdf.format(new Date()));
					Date date1=sdf.parse(admin2.getTime());
					System.out.println(now);
					System.out.println(date1);
					System.out.println(now.getTime()-date1.getTime()<24*60*60*1000);
					model.addAttribute("loginError","密码错误");//传数据至jsp界面
					if(admin2.getCount()>0&&admin2.getCount()<4){//登录密码错误，count加一
						as.updateErrorCount(name);
						model.addAttribute("loginError","密码错误");//传数据至jsp界面
					}
					if(now.getTime()-date1.getTime()<24*60*60*1000&&admin2.getCount()==4){
						as.updateState(name);//设置count为5，并且设置状态为冻结，设置time为当前冻结的时间
						model.addAttribute("loginError","一天内输错密码5次，账号冻结一天");//传数据至jsp界面
					}
					if(admin2.getCount()==5&&now.getTime()-date1.getTime()<24*60*60*1000){
						model.addAttribute("loginError","该用户名因多次输入密码错误，已被冻结");
					}
				}
			}
			return "forward:/login.jsp";
		}if(admin2.getState()==-1) {//账户被冻结的情况
			Date now=sdf.parse(sdf.format(new Date()));
			Date date1=sdf.parse(admin2.getTime());
			System.out.println(now);
			System.out.println(date1);
			System.out.println(now.getTime()-date1.getTime()<24*60*60*1000);
			if(now.getTime()-date1.getTime()>24*60*60*1000){
				as.updateErrorState(name);//冻结时间超过一天，自动解冻
			}
			else{
				model.addAttribute("loginError","用户被冻结");//传数据至jsp界面
				return "forward:/login.jsp";
			}
		}
		as.initLog(name);
		model.addAttribute("admin",admin2);
		request.getSession().setAttribute("admin",admin2);
		return "forward:/selectAll.do";
	}
	
	@RequestMapping("/showAdmin.do")
	public String getAllAdmin(Model model) {
		List<Admin> admins = as.findAllAdmin();
		if(admins == null){
			model.addAttribute("msg","数据加载不到请重试");
		}else {
			model.addAttribute("alist",admins);
		}
		return "showAdmin";
	}
	
	@RequestMapping("/showAddAdmin.do")
	public String showAddAdmin() {
		return "addAdmin";
	}
	
	@RequestMapping("/addAdmin.do")
	public String addAdmin(Admin admin,Model model) {	
		MD5Code md5=new MD5Code();
		admin.setPwd(md5.getMD5ofStr(admin.getPwd()));
		int result = as.insert(admin);
		if(result==1){
			model.addAttribute("msg","添加管理员成功");
		}else {
			model.addAttribute("msg","添加管理员失败");
		}
		return "addAdmin";
	}
	
	@RequestMapping("/showUpdateAdmin.do")
	public String showUpdateAdmin(int id,Model model) {
		Admin admin = as.selectById(id);
		model.addAttribute("admin",admin);
		return "updateAdmin";
	}
	
	@RequestMapping("/updateAdmin.do")
	public String updateAdmin(Admin admin,Model model) {
		MD5Code md5=new MD5Code();
		admin.setPwd(md5.getMD5ofStr(admin.getPwd()));
		int result = as.updateAdmin(admin);
		if (result==1) {
			model.addAttribute("msg","修改管理员成功");
		}else {
			model.addAttribute("msg","修改管理员失败");
		}
		return "updateAdmin";
	}
	
	@RequestMapping("/deleteAdmin.do")
	public String deleteAdmin(int id,Model model) {
		as.deleteAdmin(id);
		model.addAttribute("msg","删除管理员成功");
		return "forward:/showAdmin.do";
	}
}
