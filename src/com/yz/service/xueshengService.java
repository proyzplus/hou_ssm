package com.yz.service;

import java.util.List;

import com.yz.bean.kebiao;

public interface xueshengService {
	//学生课表
		public List<kebiao> xskebiaoAll1(int id);

		//学生选课
		public int xsaddkc(int xs_id,int kebiao_id);
}
