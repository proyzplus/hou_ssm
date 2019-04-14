package com.yz.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yz.bean.*;
import com.yz.service.AdminService;
import com.yz.service.LaoshiService;
import com.yz.service.xueshengService;
@Controller
public class IndexController {
	
	@RequestMapping("/login")
	public void  login(HttpServletRequest request,HttpSession session,HttpServletResponse resp ) throws IOException{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		String name=request.getParameter("userName");
		String pw=request.getParameter("userPw");
		Admin a= new Admin();
		a.setUserName(name);
	    a.setUserPw(pw);
	    
		String usertypee=request.getParameter("userType");
		int userType=Integer.parseInt(usertypee);
		
		laoshi ls=new laoshi();
		ls.setLoginname(name);
		ls.setLoginpw(pw);
		
		xuesheng xs=new xuesheng();
		xs.setLoginname(name);
		xs.setLoginpw(pw);
		
		if(userType==0)
		{
			  Admin ad=us.login(a);
			  if(ad!=null)
			  {
				  session.setAttribute("userType",userType);
				  session.setAttribute("user", ad);
				  resp.sendRedirect("loginSuccess.jsp");
			  }
		}
		else if(userType==1)
		{
			laoshi lsa=us.loginlaoshi(ls);
			if(lsa!=null)
			{
				session.setAttribute("userType", userType);
				session.setAttribute("laoshi", lsa);
				resp.sendRedirect("loginSuccess.jsp");
			}
		}
		else if(userType==2)
		{
			xuesheng xsa=us.loginxuesheng(xs);
			System.out.println(xsa+"123456799");
			if(xsa!=null)
			{
				session.setAttribute("userType", userType);
				session.setAttribute("xuesheng", xsa);
				resp.sendRedirect("loginSuccess.jsp");
			}
		}
		}
	
	@RequestMapping("/adminPwEdit")
	public void adminPwEdit(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		Admin name=(Admin)session.getAttribute("user");
		String userName=name.getUserName();
		String userPw=request.getParameter("userPw1");
		
		boolean a=us.adminPwEdit(userName, userPw);
		
		if(a == true)
		{
			resp.sendRedirect("login_.jsp");
			System.out.println("yes.修改成功");
		}

	}
	
	@RequestMapping("/adminAdd")
	public void add(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		String userName=request.getParameter("userName");
		String userPw=request.getParameter("userPw");
		Admin a=new Admin();
		a.setUserName(userName);
		a.setUserPw(userPw);
		boolean i=us.add(a);
		if(i == true)
		{
			request.getRequestDispatcher("admin/admin/adminAdd.jsp");
		}
		else{
			System.out.println("失败");
		}
	}
	
	@RequestMapping(value = "/adminList", method = RequestMethod.GET)
	public void adminList(HttpSession session, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		List<Admin> list=us.adminList();
		System.out.println(list);
		request.setAttribute("adminList", list);
		request.getRequestDispatcher("admin/admin/adminMana.jsp").forward(
				request, response);
	}
	
	@RequestMapping("/kechengList")
	public void kechengList(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws IOException, ServletException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		/*System.out.println("便利课程");*/
		List<Kecheng> list =us.kechengList();
		request.setAttribute("kechengList", list);
		request.getRequestDispatcher("admin/kecheng/kechengMana.jsp").forward(
				request, response);
	}
	
	@RequestMapping("kechengxiala")
	public void kechengxiala(HttpServletRequest request, HttpSession session,
			HttpServletResponse response) throws IOException, ServletException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		List<Kecheng> list=us.kechengList();
		session.setAttribute("kechengList", list);
		response.sendRedirect(request.getContextPath()+"/admin/kecheng/kechengAll.jsp");
	}
	
	@RequestMapping(value = "/kechengAdd", method = RequestMethod.POST)
	public void kechengAdd(HttpSession session, HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		String bianhao = request.getParameter("bianhao");
		String mingcheng = request.getParameter("mingcheng");
		String keshi = request.getParameter("keshi");
		Kecheng kc= new Kecheng();
		kc.setBianhao(bianhao);
		kc.setMingcheng(mingcheng);
		kc.setKeshi(keshi);
		boolean flog=us.kechengAdd(kc);
		if(flog==true)
		{
			request.getRequestDispatcher("/kechengList").forward(request,
					response);
		}
	}
	
	@RequestMapping(value = "/kechengDel", method = RequestMethod.GET)
	public void kechengDel(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"AppliactionContext_MapperScanner.xml");
		AdminService us = context.getBean("userServiceImpl",AdminService.class);
		
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		System.out.println(id);
		boolean a = us.kechengDel(id);
		if (a == true) {
			request.getRequestDispatcher("/kechengList").forward(request,
					response);
		}
	}
	
	@RequestMapping(value = "/laoshiall", method = RequestMethod.GET)
	public void laoshiall(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		List<laoshi> list=us.sellaoshi();
		request.setAttribute("laoshilist", list);
		request.getRequestDispatcher("/admin/laoshi/laoshiMana.jsp").forward(
				request, response);
	}
	
	@RequestMapping(value="/laoshiAdd")
	public void laoshiAdd(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String bianhao = request.getParameter("bianhao");
		String xingming = request.getParameter("xingming");
		String xingbie = request.getParameter("xingbie");
		String nianling = request.getParameter("nianling");
		String zhicheng = request.getParameter("zhicheng");
		String loginname = request.getParameter("loginname");
		String loginpw = request.getParameter("loginpw");
		laoshi ls =new laoshi();
		ls.setBianhao(bianhao);
		ls.setXingming(xingming);
		ls.setXingbie(xingbie);
		ls.setNianling(nianling);
		ls.setZhicheng(zhicheng);
		ls.setLoginname(loginname);
		ls.setLoginpw(loginpw);
		System.out.println(ls);
		boolean flog=us.laoshiAdd(ls);
		if(flog==true)
		{
			request.getRequestDispatcher("/laoshiall").forward(request,
					response);
		}
	}

	@RequestMapping(value="/laoshiDel", method = RequestMethod.GET)
	public void laoshiDel(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		String ids =request.getParameter("id");
		int id = Integer.parseInt(ids);
		boolean a=us.laoshiDel(id);
		if(a==true)
		{
			request.getRequestDispatcher("/laoshiall").forward(request,
					response);
		}
	}

	@RequestMapping(value="/selkebiao")
	public void selkebiao(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		List<kebiao> list = us.selkebiao();
		System.out.println(list);
		request.setAttribute("kebiaoList", list);
		request.getRequestDispatcher("/admin/kebiao/kebiaoMana.jsp").forward(
				request, response);
	}
	
	@RequestMapping(value="/kebiaoDel", method = RequestMethod.GET)
	public void kebiaoDel(HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		String ids=request.getParameter("id");
		int id=Integer.parseInt(ids);
		boolean flog=us.kebiaoDel(id);
		if(flog==true)
		{
			request.getRequestDispatcher("/selkebiao").forward(request,
					response);
		}
	}
	
	@RequestMapping(value="/kebiaaAdd", method = RequestMethod.POST)
	public void kebiaaAdd(HttpSession session, HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		System.out.println("123sjjsjsjjsjs");
		String id = request.getParameter("kecheng_id");
		int ids = Integer.parseInt(id);
		String shijian = request.getParameter("shijian");
		String jieci = request.getParameter("jieci");
		String jiaoshi = request.getParameter("jiaoshi");
		String laoshiid = request.getParameter("laoshi_id");
		int ide=Integer.parseInt(laoshiid);
		
		kebiao kb=new kebiao();
		
		kb.setKecheng_id(ids);
		kb.setShijian(shijian);
		kb.setJieci(jieci);
		kb.setJiaoshi(jiaoshi);
		kb.setLaoshi_id(ide);
		
		boolean flog=us.kebiaoAdd(kb);
		System.out.println(flog);
		if(flog==true)
		{
			request.getRequestDispatcher("/selkebiao").forward(request,
					response);
		}
	}
	
	@RequestMapping(value="/selxuesheng")
	public void selxuesheng(HttpSession session, HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
		
		List<xuesheng> list=us.selxuesheng();
		request.setAttribute("xueshengList", list);
		request.getRequestDispatcher("admin/xuesheng/xueshengMana.jsp")
				.forward(request, response);
	}
	
	@RequestMapping(value = "/xueshengDel", method = RequestMethod.GET)
	public void xueshengDel(HttpSession session, HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
	
		String ids=request.getParameter("id");
		int id = Integer.parseInt(ids);
		boolean a = us.xueshengDel(id);
		if (a == true) {
			request.getRequestDispatcher("/selxuesheng").forward(request,
					response);
		}
	}
	
	@RequestMapping(value = "/xueshengAdd", method = RequestMethod.POST)
	public void xueshengAdd(HttpSession session, HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService us=context.getBean("userServiceImpl",AdminService.class);
	
		String xuehao = request.getParameter("xuehao");
		String xingming = request.getParameter("xingming");
		String xingbie = request.getParameter("xingbie");
		String nianling = request.getParameter("nianling");
		String banji = request.getParameter("banji");
		String loginname = request.getParameter("loginname");
		String loginpw = request.getParameter("loginpw");
		xuesheng sx=new xuesheng();
		sx.setXuehao(xuehao);
		sx.setXingming(xingming);
		sx.setXingbie(xingbie);
		sx.setNianling(nianling);
		sx.setBanji(banji);
		sx.setLoginname(loginname);
		sx.setLoginpw(loginpw);
		System.out.println(sx);
		boolean flog =us.xueshengAdd(sx);
		if (flog == true) {
			request.getRequestDispatcher("/selxuesheng").forward(request,
					response);
		}
	}
	/*老师端*/
	@RequestMapping("/kebiaoxinxi")
	public void kebiaoxinxi(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		LaoshiService us=context.getBean("LaoshiServiceImpl",LaoshiService.class);
	
		List<kebiao> list=us.sel();
		System.out.println(list);
		session.setAttribute("kebiaoList", list);
		response.sendRedirect("admin/kebiao/kebiaoAll.jsp");
	}
	/*学生端*/
	//课表遍历
	@RequestMapping("/xskechengall")
	public void xskechengall(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		AdminService stu=context.getBean("userServiceImpl",AdminService.class);
		List<kebiao> kb=stu.selkebiao();
		session.setAttribute("xskebiaoll", kb);
		resp.sendRedirect(request.getContextPath()+"/admin/kebiao/kebiaoAll1.jsp");
	}
	//选课
	@RequestMapping("/xsaddkc")
	public void xsaddkc(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		xueshengService stu=context.getBean("stServiceImpl",xueshengService.class);
		
		String kebiao_id1=request.getParameter("id");
		int kebiao_id=Integer.parseInt(kebiao_id1);
		xuesheng s=(xuesheng) session.getAttribute("xuesheng");
		int xsid=s.getId();
		int i=stu.xsaddkc(xsid, kebiao_id);
		resp.sendRedirect(request.getContextPath()+"/xskebiaoAll");
	}
	//学生课表
	@RequestMapping("/xskebiaoAll")
	public void xskebiaoAll(HttpServletRequest request,HttpSession session,HttpServletResponse resp) throws IOException
	{
		ApplicationContext context =new ClassPathXmlApplicationContext("AppliactionContext_MapperScanner.xml");
		xueshengService stu=context.getBean("stServiceImpl",xueshengService.class);
		
		
		xuesheng st=(xuesheng) session.getAttribute("xuesheng");
		int id=st.getId();
		List<kebiao> kb=stu.xskebiaoAll1(id);
		session.setAttribute("xuesheng_kebiao_list", kb);
		resp.sendRedirect(request.getContextPath()+"/axuesheng/kebiao/kebiao_mana_stu.jsp");

	}
}