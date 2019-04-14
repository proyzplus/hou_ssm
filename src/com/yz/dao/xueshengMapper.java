package com.yz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yz.bean.kebiao;

public interface xueshengMapper {
	//学生课表
	public List<kebiao> xskebiaoAll1(int id);

	//学生选课
	public int xsaddkc(@Param("xs_id")int xs_id,@Param("kebiao_id")int kebiao_id);
	
}
