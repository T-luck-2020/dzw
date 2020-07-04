package com.accp.domain;

public class Student {
    private Integer id;

    private String name;

    private Clazz clz;
    
    private Integer age;

    private String birthday;

    private Integer clazzid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getClazzid() {
        return clazzid;
    }

    public void setClazzid(Integer clazzid) {
        this.clazzid = clazzid;
    }

	public Clazz getClz() {
		return clz;
	}

	public void setClz(Clazz clz) {
		this.clz = clz;
	}
}