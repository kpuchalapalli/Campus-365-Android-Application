package com.example.campus_365.bean;

public class StudentBean {
	
	private int student_id;
	private String student_name;
		private String student_mobilenumber;
	private String student_department;
	private String student_class;
	private String student_email;
	private String student_password;

	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {

	    return student_name;
	}
	public void setStudent_name(String student_name) {

	    this.student_name = student_name;
	}
	public String getStudent_email() {

	    return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_mobilenumber() {

	    return student_mobilenumber;
	}
	public void setStudent_mobilenumber(String student_mobilenumber) {
		this.student_mobilenumber = student_mobilenumber;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public String getStudent_department() {
		return student_department;
	}
	public void setStudent_department(String student_department) {
		this.student_department = student_department;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
}
