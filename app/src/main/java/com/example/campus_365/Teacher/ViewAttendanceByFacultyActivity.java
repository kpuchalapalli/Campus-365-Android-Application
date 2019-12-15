package com.example.campus_365.Teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.bean.AttendanceBean;
import com.example.campus_365.bean.StudentBean;
import com.example.campus_365.context.ApplicationContext;

import java.util.ArrayList;

public class ViewAttendanceByFacultyActivity extends AppCompatActivity {
    ArrayList<AttendanceBean> attendanceBeanList;
    private ListView listView ;
    private ArrayAdapter<String> listAdapter;

    DBAdapter dbAdapter = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> attendanceList = new ArrayList<String>();
        attendanceList.add("Id | StudentName |  Status");

        attendanceBeanList=((ApplicationContext)ViewAttendanceByFacultyActivity.this.getApplicationContext()).getAttendanceBeanList();

        for(AttendanceBean attendanceBean : attendanceBeanList)
        {
            String users = "";
            if(attendanceBean.getAttendance_session_id() != 0)
            {
                DBAdapter dbAdapter = new DBAdapter(ViewAttendanceByFacultyActivity.this);
                StudentBean studentBean =dbAdapter.getStudentById(attendanceBean.getAttendance_student_id());
                users = attendanceBean.getAttendance_student_id()+".     "+studentBean.getStudent_name()+"                  "+attendanceBean.getAttendance_status();
            }
            else
            {
                users = attendanceBean.getAttendance_status();
            }

            attendanceList.add(users);
            Log.d("users: ", users);

        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.view_attendance_list, R.id.labelAttendance, attendanceList);
        listView.setAdapter( listAdapter );



    }





}