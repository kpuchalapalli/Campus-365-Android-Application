package com.example.campus_365.Student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.Teacher.TeacherDashboard;
import com.example.campus_365.bean.FacultyBean;
import com.example.campus_365.bean.StudentBean;
import com.example.campus_365.context.ApplicationContext;

public class StudentLogin extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        email = findViewById(R.id.St_Uname);
        password = findViewById(R.id.St_Pass);
        login=findViewById(R.id.St_Lgn_Btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = email.getText().toString();
                String pass_word = password.getText().toString();

                if(user_name.length()!=0 && pass_word.length()!=0) {
                    DBAdapter dbAdapter = new DBAdapter(StudentLogin.this);
                    StudentBean studentBean = dbAdapter.validateStudent(user_name, pass_word);

                    if (studentBean != null) {
                        email.setText("");
                        password.setText("");
                        Intent intent = new Intent(StudentLogin.this, StudentDashboard.class);
                        startActivity(intent);
                        ((ApplicationContext) StudentLogin.this.getApplicationContext()).setStudentBean(studentBean);
                    } else {
                        Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
