package com.example.campus_365.Teacher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.bean.FacultyBean;
import com.example.campus_365.context.ApplicationContext;

public class TeacherLogin extends AppCompatActivity {

    Button login;
    EditText username,password;
    Spinner spinnerloginas;
    String userrole;
    private String[] userRoleString = new String[] { "admin", "faculty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        login =(Button)findViewById(R.id.Te_Lgn_Btn);
        username=(EditText)findViewById(R.id.Te_Uname);
        password=(EditText)findViewById(R.id.Te_Pass);


        login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                    String user_name = username.getText().toString();
                    String pass_word = password.getText().toString();

                    if (TextUtils.isEmpty(user_name))
                    {
                        username.setError("Invalid User Name");
                    }
                    else if(TextUtils.isEmpty(pass_word))
                    {
                        password.setError("enter password");
                    }
                    DBAdapter dbAdapter = new DBAdapter(TeacherLogin.this);
                    FacultyBean facultyBean = dbAdapter.validateFaculty(user_name, pass_word);

                    if(facultyBean!=null)
                    {
                        username.setText("");
                        password.setText("");
                        Intent intent = new Intent(TeacherLogin.this,TeacherDashboard.class);
                        startActivity(intent);
                       ((ApplicationContext)TeacherLogin.this.getApplicationContext()).setFacultyBean(facultyBean);
                        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(TeacherLogin.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                }


            //}
        });



    }



}
