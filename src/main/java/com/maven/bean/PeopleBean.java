package com.maven.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PeopleBean {
	//@SerializedName("Name")
	private String name;
    private String school;
    private boolean has_girlfriend;
    private double age;
    private Object car;
    private Object house;
    private List<String> major;
    private String comment;
    private Date birthday;
    //transient关键字修饰的字段在生成json时会被忽略
    private transient String ignore;
	public String getIgnore() {
		return ignore;
	}
	public void setIgnore(String ignore) {
		this.ignore = ignore;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public boolean isHas_girlfriend() {
		return has_girlfriend;
	}
	public void setHas_girlfriend(boolean has_girlfriend) {
		this.has_girlfriend = has_girlfriend;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public Object getCar() {
		return car;
	}
	public void setCar(Object car) {
		this.car = car;
	}
	public Object getHouse() {
		return house;
	}
	public void setHouse(Object house) {
		this.house = house;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List<String> getMajor() {
		return major;
	}
	public void setMajor(List<String> major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "PeopleBean [name=" + name + ", school=" + school + ", has_girlfriend=" + has_girlfriend + ", age=" + age
				+ ", car=" + car + ", house=" + house + ", major=" + major + ", comment=" + comment + ", birthday="
				+ birthday + ", ignore=" + ignore + "]";
	}
	
}
