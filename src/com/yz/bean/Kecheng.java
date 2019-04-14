package com.yz.bean;

public class Kecheng {
	private int id;
	private String bianhao;
	private String mingcheng;
	private String keshi;
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
	public String getMingcheng() {
		return mingcheng;
	}
	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}
	public String getKeshi() {
		return keshi;
	}
	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "kecheng [id=" + id + ", bianhao=" + bianhao + ", mingcheng="
				+ mingcheng + ", keshi=" + keshi + ", del=" + del + "]";
	}
	
}
