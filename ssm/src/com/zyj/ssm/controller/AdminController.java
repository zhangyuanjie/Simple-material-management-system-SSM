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
		if(admin2==null){//��ʾ�Ҳ�������¼ʧ��
			admin2 = as.selectByName(name);
			if(admin2==null){//�û�������
				model.addAttribute("loginError","�û���������");
			}else {
				if(admin2.getCount()==0){//��һ�ε�¼ʧ�ܣ���¼��һ�ε�¼ʧ�ܵ�ʱ��
					as.updateFirstErrorLog(name);
					model.addAttribute("loginError","�������");//��������jsp����
				}else {
					Date now=sdf.parse(sdf.format(new Date()));
					Date date1=sdf.parse(admin2.getTime());
					System.out.println(now);
					System.out.println(date1);
					System.out.println(now.getTime()-date1.getTime()<24*60*60*1000);
					model.addAttribute("loginError","�������");//��������jsp����
					if(admin2.getCount()>0&&admin2.getCount()<4){//��¼�������count��һ
						as.updateErrorCount(name);
						model.addAttribute("loginError","�������");//��������jsp����
					}
					if(now.getTime()-date1.getTime()<24*60*60*1000&&admin2.getCount()==4){
						as.updateState(name);//����countΪ5����������״̬Ϊ���ᣬ����timeΪ��ǰ�����ʱ��
						model.addAttribute("loginError","һ�����������5�Σ��˺Ŷ���һ��");//��������jsp����
					}
					if(admin2.getCount()==5&&now.getTime()-date1.getTime()<24*60*60*1000){
						model.addAttribute("loginError","���û�������������������ѱ�����");
					}
				}
			}
			return "forward:/login.jsp";
		}if(admin2.getState()==-1) {//�˻�����������
			Date now=sdf.parse(sdf.format(new Date()));
			Date date1=sdf.parse(admin2.getTime());
			System.out.println(now);
			System.out.println(date1);
			System.out.println(now.getTime()-date1.getTime()<24*60*60*1000);
			if(now.getTime()-date1.getTime()>24*60*60*1000){
				as.updateErrorState(name);//����ʱ�䳬��һ�죬�Զ��ⶳ
			}
			else{
				model.addAttribute("loginError","�û�������");//��������jsp����
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
			model.addAttribute("msg","���ݼ��ز���������");
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
			model.addAttribute("msg","��ӹ���Ա�ɹ�");
		}else {
			model.addAttribute("msg","��ӹ���Աʧ��");
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
			model.addAttribute("msg","�޸Ĺ���Ա�ɹ�");
		}else {
			model.addAttribute("msg","�޸Ĺ���Աʧ��");
		}
		return "updateAdmin";
	}
	
	@RequestMapping("/deleteAdmin.do")
	public String deleteAdmin(int id,Model model) {
		as.deleteAdmin(id);
		model.addAttribute("msg","ɾ������Ա�ɹ�");
		return "forward:/showAdmin.do";
	}
}
