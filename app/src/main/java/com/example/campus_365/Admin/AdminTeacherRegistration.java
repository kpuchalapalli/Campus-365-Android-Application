package com.example.campus_365.Admin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.bean.FacultyBean;

public class AdminTeacherRegistration extends AppCompatActivity {
    private EditText empno;
    private EditText name;
    private EditText password;
    private EditText mob;
    private EditText email;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_teacher_registration);

        name=(EditText)findViewById(R.id.te_name);
        password=(EditText)findViewById(R.id.te_password);
        mob=(EditText)findViewById(R.id.te_num);
        email=(EditText)findViewById(R.id.te_email);
        btn=(Button)findViewById(R.id.te_save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.length() != 0 && password.length()!=0 && mob.length()!=0 && email.length()!=0) {
//                    String emp = empno.getText().toString();
                    String Name = name.getText().toString();
                    String Password = password.getText().toString();
                    String Mob = mob.getText().toString();
                    String Mail = email.getText().toString();

                    FacultyBean facultyBean = new FacultyBean();
                    //facultyBean.setFaculty_emp(emp);
                    facultyBean.setFaculty_name(Name);
                    facultyBean.setFaculty_password(Password);
                    facultyBean.setFaculty_mobilenumber(Mob);
                    facultyBean.setFaculty_username(Mail);
                    DBAdapter dbAdapter = new DBAdapter(AdminTeacherRegistration.this);
                    dbAdapter.addFaculty(facultyBean);

                    Intent intent = new Intent(AdminTeacherRegistration.this, AdminDashboard.class);
                    startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Faculty Not added ", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
