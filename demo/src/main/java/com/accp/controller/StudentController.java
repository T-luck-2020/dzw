package com.accp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.domain.Clazz;
import com.accp.domain.Student;
import com.accp.service.ClazzService;
import com.accp.service.StudentService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService ser;
	@Autowired
	ClazzService ser1;
	@GetMapping
	public String find(Model m){
		System.out.println("55555");
		List<Student> list = ser.find();
		m.addAttribute("list",list);
		return "student";
	}
	@GetMapping("/del")
	public String del(Integer id){
		int ret = ser.remove(id);
		if(ret>0) {
			return "redirect:http://127.0.0.1:8888/student";
		}
		return "student";
	}
	@GetMapping("/findbyid")
	public String findbyid(Integer id,Model m){
		Student stu = ser.findByid(id);
		if(stu!=null) {
			m.addAttribute("stu",stu);
		}
		return "update";
	}
	@GetMapping("/update")
	public String update(Student stu){
		System.out.println(stu.getName());
		int ret = ser.update(stu);
		if(ret>0) {
			return "redirect:http://127.0.0.1:8888/student";
		}
		return "student";
	}
	@PostMapping("/add")
	public String add(Student stu){
		int ret = ser.add(stu);
		if(ret>0) {
			return "redirect:http://127.0.0.1:8888/student";
		}
		return "student";
	}
	@GetMapping("/toadd")
	public String toadd() {
		return "add";
	}
	@RequestMapping("/toajax")
	public String toajax() {
		return "ajaxstudent";
	}
	@RequestMapping("/ajax")
	@ResponseBody
	public PageInfo<Student> findbypage(Integer pageNum,Integer pageSize){
		PageInfo<Student> page = ser.findbypage(pageNum, pageSize);
		for (Student p : page.getList()) {
			Clazz cl = ser1.findbyid(p.getClazzid());
			p.setClz(cl);
		}
	    return page;
	}
	@RequestMapping("/remove")
	@ResponseBody
	public String remove(Integer[] id){
		for (Integer i : id) {
			int ret = ser.remove(i);
			if(ret<0) {
				return "11111";
			}
		}
	    return "00000";
	}
	@RequestMapping("/jia")
	@ResponseBody
	public String pladd(@RequestBody Clazz clz){
		int ret = ser1.add(clz);
		Clazz cc = ser1.findbyName(clz.getName());
		if(ret>0) {
			for (Student s : clz.getSlist()) {
				s.setClazzid(cc.getId());
				int re = ser.add(s);
				if(re<0) {
					return "11111";
				}
			}
		}
	    return "00000";
	}
}
