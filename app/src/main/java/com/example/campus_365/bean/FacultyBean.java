package com.example.campus_365.bean;

public class FacultyBean {
	
	private int faculty_id;
	private String faculty_emp;
	private String faculty_name;
	private String faculty_mobilenumber;
	private String faculty_username;
	private String faculty_password;

	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}



	public String getFaculty_name() {
		return faculty_name;
	}
	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}

	public String getFaculty_mobilenumber() {
		return faculty_mobilenumber;
	}
	public void setFaculty_mobilenumber(String faculty_mobilenumber) {
		this.faculty_mobilenumber = faculty_mobilenumber;
	}

	public String getFaculty_username() {
		return faculty_username;
	}
	public void setFaculty_username(String faculty_username) {
		this.faculty_username = faculty_username;
	}

	public String getFaculty_password() {
		return faculty_password;
	}
	public void setFaculty_password(String faculty_password) {
		this.faculty_password = faculty_password;
	}
}
