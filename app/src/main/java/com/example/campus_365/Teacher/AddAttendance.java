package com.example.campus_365.Teacher;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.bean.AttendanceBean;
import com.example.campus_365.bean.StudentBean;
import com.example.campus_365.context.ApplicationContext;

import java.util.ArrayList;

public class AddAttendance extends Activity {

    ArrayList<StudentBean> studentBeanList;
    private ListView listView ;
    private ArrayAdapter<String> listAdapter;
    int sessionId=0;
    String status="P";
    Button attendanceSubmit;
    DBAdapter dbAdapter = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        sessionId = getIntent().getExtras().getInt("sessionId");



        listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> studentList = new ArrayList<String>();

        studentBeanList=((ApplicationContext)AddAttendance.this.getApplicationContext()).getStudentBeanList();


        for(StudentBean studentBean : studentBeanList)
        {
            String users = studentBean.getStudent_name();

            studentList.add(users);
            Log.d("users: ", users);

        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.add_student_attendance, R.id.labelA, studentList);
        listView.setAdapter( listAdapter );

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                arg0.getChildAt(arg2).setBackgroundColor(Color.TRANSPARENT);
                arg1.setBackgroundColor(334455);
                final StudentBean studentBean = studentBeanList.get(arg2);
                final Dialog dialog = new Dialog(AddAttendance.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//...........
                dialog.setContentView(R.layout.test_layout);
                RadioGroup radioGroup;
                RadioButton present;
                RadioButton absent;
                radioGroup = (RadioGroup) dialog.findViewById(R.id.radioGroup);
                present=(RadioButton)dialog.findViewById(R.id.PresentradioButton);
                absent=(RadioButton)dialog.findViewById(R.id.AbsentradioButton);
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.PresentradioButton) {

                            status = "P";
                        } else if(checkedId == R.id.AbsentradioButton) {

                            status = "A";
                        } else {
                        }
                    }
                });

                attendanceSubmit = (Button)dialog.findViewById(R.id.attendanceSubmitButton);
                attendanceSubmit.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        AttendanceBean attendanceBean = new AttendanceBean();

                        attendanceBean.setAttendance_session_id(sessionId);
                        attendanceBean.setAttendance_student_id(studentBean.getStudent_id());
                        attendanceBean.setAttendance_status(status);

                        DBAdapter dbAdapter = new DBAdapter(AddAttendance.this);
                        dbAdapter.addNewAttendance(attendanceBean);

                        dialog.dismiss();

                    }
                });

                dialog.setCancelable(true);
                dialog.show();
            }
        });



    }





}
