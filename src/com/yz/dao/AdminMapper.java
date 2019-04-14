package com.yz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yz.bean.Admin;
import com.yz.bean.Kecheng;
import com.yz.bean.kebiao;
import com.yz.bean.laoshi;
import com.yz.bean.xuesheng;

public interface AdminMapper {

  public Admin login(Admin a);  //管理员登陆
  
  public boolean adminPwEdit(@Param("userName")String userName,@Param("userPw")String userPw);//修改密码
  
  public laoshi loginlaoshi(laoshi ls);//老师登陆
  
  public xuesheng loginxuesheng(xuesheng xs);//学生登陆
  
  public boolean add(Admin a);//添加管理员
  
  public List<Admin> adminList();//便利管理员
  
  public List<Kecheng> kechengList();//便利课程
  
  public  boolean kechengAdd(Kecheng k);//添加课程.
  
  public boolean kechengDel(int id);//删除课程
  
  public List<laoshi> sellaoshi();//便利老师
  
  public boolean laoshiDel(int id);//删除老师
  
  public boolean laoshiAdd(laoshi ls);//添加老师
  
  public List<kebiao> selkebiao();//便立刻表
  
  public boolean kebiaoDel(int id);//删除课表
 
  public boolean kebiaoAdd(kebiao kb);//添加课表
  
  public List<xuesheng> selxuesheng();//便利学生
  
  public boolean xueshengDel(int id);//删除学生
  
  public boolean xueshengAdd(xuesheng xs);//添加学生
  
  
  
}
