package com.example.campus_365.Admin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.campus_365.R;

public class AdminLogin extends AppCompatActivity {
    private EditText uname;
    private EditText pass;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        uname = (EditText) findViewById(R.id.Ad_Uname);
        pass = (EditText) findViewById(R.id.Ad_Pass);
        Login = (Button) findViewById(R.id.Ad_Lgn_Btn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(uname.getText().toString(), pass.getText().toString());
            }
        });
    }

    private void validate(String UserName, String UserPassword) {
        String user="admin";
        String passw="admin123";
        if (UserName.equals(user) && UserPassword.equals(passw)) {
            uname.setText("");
            pass.setText("");
            Intent intent = new Intent(AdminLogin.this, AdminDashboard.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Invalid Username or Password!!!");
            dlgAlert.setTitle("Invalid Login");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();


        }
    }
}