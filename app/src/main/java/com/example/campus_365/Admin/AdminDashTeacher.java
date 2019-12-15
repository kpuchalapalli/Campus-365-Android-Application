package com.example.campus_365.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.campus_365.R;

public class AdminDashTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash_teacher);

        Button myButton=(Button) findViewById(R.id.add_tea);// Home -> Student Login Page
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashTeacher.this, AdminTeacherRegistration.class);
                startActivity(intent);
            }
        });
    }
}
