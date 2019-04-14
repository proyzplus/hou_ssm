package com.yz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yz.bean.Admin;
import com.yz.bean.Kecheng;
import com.yz.bean.kebiao;
import com.yz.bean.laoshi;
import com.yz.bean.xuesheng;
import com.yz.dao.AdminMapper;
@Service("userServiceImpl")
public class AdminServiceImpl implements AdminService{

	@Autowired 
	private AdminMapper u;

	public Admin login(Admin a) {
		Admin ad=u.login(a);
		return ad;
	}

	
	public boolean adminPwEdit(String userName, String userPw) {
		boolean flog=u.adminPwEdit(userName, userPw);
		return flog;
	}


	@Override
	public laoshi loginlaoshi(laoshi ls) {
		laoshi lsa=u.loginlaoshi(ls);
		return lsa;
	}


	@Override
	public xuesheng loginxuesheng(xuesheng xs) {
		xuesheng xsa=u.loginxuesheng(xs);
		return xsa;
	}


	@Override
	public boolean add(Admin a) {
		boolean flog =u.add(a);
		return flog;
	}


	@Override
	public List<Admin> adminList() {
		List<Admin> list=u.adminList();
		return list;
	}


	@Override
	public List<Kecheng> kechengList() {
		List<Kecheng> list=u.kechengList();
		return list;
	}


	@Override
	public boolean kechengAdd(Kecheng k) {
		boolean flog =u.kechengAdd(k);
		return flog;
	}


	@Override
	public boolean kechengDel(int id) {
		boolean flog=u.kechengDel(id);
		return flog;
	}


	@Override
	public List<laoshi> sellaoshi() {
		List<laoshi> list=u.sellaoshi();
		return list;
	}


	@Override
	public boolean laoshiDel(int id) {
		boolean flog=u.laoshiDel(id);
		return flog;
	}


	@Override
	public boolean laoshiAdd(laoshi ls) {
		boolean flog=u.laoshiAdd(ls);
		return flog;
	}


	@Override
	public List<kebiao> selkebiao() {
		List<kebiao> list=u.selkebiao();
		return list;
	}


	@Override
	public boolean kebiaoDel(int id) {
		boolean flog=u.kebiaoDel(id);
		return flog;
	}


	@Override
	public boolean kebiaoAdd(kebiao kb) {
		boolean flog =u.kebiaoAdd(kb);
		System.out.println(flog+"service");
		return flog;
	}


	@Override
	public List<xuesheng> selxuesheng() {
		List<xuesheng> list=u.selxuesheng();
		return list;
	}


	@Override
	public boolean xueshengDel(int id) {
		boolean flog=u.xueshengDel(id);
		return flog;
	}


	@Override
	public boolean xueshengAdd(xuesheng xs) {
		boolean flog=u.xueshengAdd(xs);
		return flog;
	}




	
	
	


}
