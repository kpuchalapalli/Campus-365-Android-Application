package com.example.campus_365.Admin;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.campus_365.Database.DBAdapter;
import com.example.campus_365.R;
import com.example.campus_365.bean.FacultyBean;

import java.util.ArrayList;

public class ViewFacultyActivity extends AppCompatActivity {
    ArrayList<FacultyBean> facultyBeanList;
    private ListView listView ;
    private ArrayAdapter<String> listAdapter;

    DBAdapter dbAdapter = new DBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> facultyList = new ArrayList<String>();

        facultyBeanList=dbAdapter.getAllFaculty();

        for(FacultyBean facultyBean : facultyBeanList)
        {
            String users = " FirstName: " + facultyBean.getFaculty_name()+"\nMobile:"+facultyBean.getFaculty_mobilenumber();

            facultyList.add(users);
            Log.d("users: ", users);

        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.view_faculty_list, R.id.labelF, facultyList);
        listView.setAdapter( listAdapter );

    }
}
