package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.ClazzMapper;
import com.accp.domain.Clazz;
import com.accp.domain.ClazzExample;

@Service      
@Transactional
public class ClazzService {
	@Autowired         
	ClazzMapper map; 
	/*
	 * 假两件家里看
	 * */
	public List<Clazz> find(){
		return map.selectByExample(null);
	}
	public Clazz findbyid(Integer id){
		ClazzExample ex = new ClazzExample();
		ex.createCriteria().andIdEqualTo(id);
		List<Clazz> list = map.selectByExample(ex);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	public Clazz findbyName(String name){
		ClazzExample ex = new ClazzExample();
		ex.createCriteria().andNameEqualTo(name);
		List<Clazz> list = map.selectByExample(ex);
		return list!=null&&list.size()>0?list.get(0):null;
	}
	public Integer del(Integer id) {
		return map.deleteByPrimaryKey(id);
	}
	public Integer add(Clazz clz) {
		return map.insert(clz);
	}
}
