package com.example.campus_365.context;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Application;

import com.example.campus_365.bean.AttendanceBean;
import com.example.campus_365.bean.AttendanceSessionBean;
import com.example.campus_365.bean.FacultyBean;
import com.example.campus_365.bean.StudentBean;


public class ApplicationContext extends Application {
    private FacultyBean facultyBean;
    public StudentBean studentBean;
    private AttendanceSessionBean attendanceSessionBean;
    private ArrayList<StudentBean> studentBeanList;
    private ArrayList<AttendanceBean> attendanceBeanList;

    public FacultyBean getFacultyBean() {

        return facultyBean;
    }
    public void setFacultyBean(FacultyBean facultyBean) {

        this.facultyBean = facultyBean;
    }

    public StudentBean getStudentBean(){
        return studentBean;
    }
    public void setStudentBean(StudentBean studentBean){
        this.studentBean=studentBean;
    }
    public AttendanceSessionBean getAttendanceSessionBean() {

        return attendanceSessionBean;
    }
    public void setAttendanceSessionBean(AttendanceSessionBean attendanceSessionBean) {
        this.attendanceSessionBean = attendanceSessionBean;
    }
    public ArrayList<StudentBean> getStudentBeanList() {

        return studentBeanList;
    }
    public void setStudentBeanList(ArrayList<StudentBean> studentBeanList) {
        this.studentBeanList = studentBeanList;
    }
    public ArrayList<AttendanceBean> getAttendanceBeanList() {
        return attendanceBeanList;
    }
    public void setAttendanceBeanList(ArrayList<AttendanceBean> attendanceBeanList) {
        this.attendanceBeanList = attendanceBeanList;
    }



}
