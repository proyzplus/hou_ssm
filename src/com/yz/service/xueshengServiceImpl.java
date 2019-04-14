package com.yz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yz.bean.kebiao;
import com.yz.dao.xueshengMapper;
@Service("stServiceImpl")
public class xueshengServiceImpl implements xueshengService{
	
	@Autowired xueshengMapper st;
	
	@Override
	public List<kebiao> xskebiaoAll1(int id) {
		List<kebiao> list=st.xskebiaoAll1(id);
		return list;
	}

	@Override
	public int xsaddkc(int xs_id, int kebiao_id) {
		int i=st.xsaddkc(xs_id, kebiao_id);
		return i;
	}

}
