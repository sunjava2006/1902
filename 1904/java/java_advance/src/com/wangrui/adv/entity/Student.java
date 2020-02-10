package com.wangrui.adv.entity;

import java.sql.Date;

public class Student {
	private int studentID;
	private String studentName;
	private String gender;
	private Date birthDate;
	private String loginName;
	private String passwd;
	
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Student(int studentID, String studentName, String gender, Date birthDate, String loginName, String passwd) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.loginName = loginName;
		this.passwd = passwd;
	}
	public Student() {
		
	}
	
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", gender=" + gender
				+ ", birthDate=" + birthDate + ", loginName=" + loginName + ", passwd=" + passwd + "]";
	}
	
	
	
}
