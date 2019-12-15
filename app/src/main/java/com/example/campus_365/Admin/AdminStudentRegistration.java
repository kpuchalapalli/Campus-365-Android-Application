package com.example.campus_365.Admin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.bean.StudentBean;

public class AdminStudentRegistration extends AppCompatActivity {
    Button registerButton;
    EditText textName;
    EditText textContact;
    EditText textUsername;
    EditText textPassword;
    Spinner spinnerbranch,spinneryear;
    String userrole,branch,year;
    private String[] branchString = new String[] { "CSE"};
    private String[] yearString = new String[] {"BE-IV Year"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student_registration);

        spinnerbranch=(Spinner)findViewById(R.id.spinnerdept);
        spinneryear=(Spinner)findViewById(R.id.spinneryear);
        textName=(EditText)findViewById(R.id.st_name);
        textContact=(EditText)findViewById(R.id.st_num);
        textUsername=(EditText)findViewById(R.id.st_email);
        textPassword=(EditText)findViewById(R.id.st_password);
        registerButton=(Button)findViewById(R.id.st_save);

    spinnerbranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
            ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
            branch =(String) spinnerbranch.getSelectedItem();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

        ArrayAdapter<String> adapter_branch = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, branchString);
        adapter_branch
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbranch.setAdapter(adapter_branch);

    spinneryear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
            ((TextView) arg0.getChildAt(0)).setTextColor(Color.BLACK);
            year =(String) spinneryear.getSelectedItem();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });
        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, yearString);
        adapter_year
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneryear.setAdapter(adapter_year);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = textName.getText().toString();
                String password = textPassword.getText().toString();
                String email = textUsername.getText().toString();
                String contact = textContact.getText().toString();

                if (name.length() != 0 && password.length()!=0 && contact.length()!=0 && email.length()!=0){
                    StudentBean studentBean = new StudentBean();

                    studentBean.setStudent_name(name);
                    studentBean.setStudent_email(email);
                    studentBean.setStudent_mobilenumber(contact);
                    studentBean.setStudent_password(password);
                    studentBean.setStudent_department(branch);
                    studentBean.setStudent_class(year);

                    DBAdapter dbAdapter= new DBAdapter(AdminStudentRegistration.this);
                    dbAdapter.addStudent(studentBean);

                    Intent intent =new Intent(AdminStudentRegistration.this,AdminDashboard.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "student added successfully", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(), "Student not Added.Try Again", Toast.LENGTH_SHORT).show();

               }
            }
        });
    }
}
