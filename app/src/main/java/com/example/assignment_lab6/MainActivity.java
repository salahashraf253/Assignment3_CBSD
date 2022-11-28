package com.example.assignment_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignment_lab6.DataBase.DbSqlite;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DbSqlite db=new DbSqlite(this);
    EditText empName;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Boolean res=db.insertData(new Employee("Salah","Software Engineer","01102527521","salahashraf924@gmail.com",new Department("Backend")));
//        if(res==false){
//            Toast.makeText(MainActivity.this,"NO",Toast.LENGTH_SHORT).show();;
//        }
//        db.insertData(new Employee("Salah","Software Engineer","01102527521","salahashraf924@gmail.com",new Department("Backend")));
//        db.insertData(new Employee("Salah","Software Engineer","01102527521","salahashraf924@gmail.com",new Department("Backend")));
        empName=findViewById(R.id.empName_txt);
        listView=findViewById(R.id.list_view);

    }

    public void btn_Search(View view) {
        String targetName=empName.getText().toString();
        System.out.println("TargetName: "+targetName);
//        ArrayList<String> arrayList=db.getAllEmployeeName(targetName);
        List<String>arrayList=db.getAllEmployeeName(targetName);
        ArrayAdapter arrayAdapter=new ArrayAdapter( this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

    }
}