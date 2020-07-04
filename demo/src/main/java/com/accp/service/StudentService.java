package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.StudentMapper;
import com.accp.domain.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class StudentService {
	@Autowired
	StudentMapper map;
	public List<Student> find(){
		return map.selectByExample(null);
	}
	public Integer remove(Integer id) {
		return map.deleteByPrimaryKey(id);
	}
	public Student findByid(Integer id) {
		return map.selectByPrimaryKey(id);
	}
	public Integer update(Student stu) {
		return map.updateByPrimaryKey(stu);
	}
	public Integer add(Student stu) {
		return map.insert(stu);
	}
	public PageInfo<Student> findbypage(Integer pageNum,Integer pageSize){
		Page<Student> page = PageHelper.startPage(pageNum, pageSize);
		map.selectByExample(null);
		return page.toPageInfo();
	}
}
