package com.yz.bean;

public class laoshi {
	private int id;
	private String bianhao;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String zhicheng;
	private String loginname;
	private String loginpw;
	private String del;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getXingbie() {
		return xingbie;
	}
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	public String getNianling() {
		return nianling;
	}
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	public String getZhicheng() {
		return zhicheng;
	}
	public void setZhicheng(String zhicheng) {
		this.zhicheng = zhicheng;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpw() {
		return loginpw;
	}
	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "laoshi [id=" + id + ", bianhao=" + bianhao + ", xingming="
				+ xingming + ", xingbie=" + xingbie + ", nianling=" + nianling
				+ ", zhicheng=" + zhicheng + ", loginname=" + loginname
				+ ", loginpw=" + loginpw + ", del=" + del + "]";
	}
	
}
