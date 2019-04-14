package com.yz.bean;

public class xuesheng_kb {
	private int id;
	private xuesheng xuesheng_id;
	private kebiao kebiao_id;
	public xuesheng_kb(int id, xuesheng xuesheng_id, kebiao kebiao_id) {
		super();
		this.id = id;
		this.xuesheng_id = xuesheng_id;
		this.kebiao_id = kebiao_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public xuesheng getXuesheng_id() {
		return xuesheng_id;
	}
	public void setXuesheng_id(xuesheng xuesheng_id) {
		this.xuesheng_id = xuesheng_id;
	}
	public kebiao getKebiao_id() {
		return kebiao_id;
	}
	public void setKebiao_id(kebiao kebiao_id) {
		this.kebiao_id = kebiao_id;
	}
	
}
