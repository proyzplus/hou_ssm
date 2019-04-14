package com.yz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yz.dao.LaoshiMapper;
import com.yz.bean.kebiao;
@Service("LaoshiServiceImpl")
public class LaoshiServiceImpl implements LaoshiService{

	@Autowired
	private LaoshiMapper la;
	
	@Override
	public List<kebiao> sel() {
		return la.sel();
	}

}
