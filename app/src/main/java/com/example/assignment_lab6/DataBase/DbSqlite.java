package com.example.assignment_lab6.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

import com.example.assignment_lab6.Employee;

import java.util.ArrayList;
import java.util.List;

public class DbSqlite extends SQLiteOpenHelper {
    private static String databaseName="employeeDatabase";

    public DbSqlite(Context context){
        super(context,databaseName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String departmentCreationStatement="create table department(DeptID integer primary key autoincrement, name text not null)";
//        sqLiteDatabase.execSQL(departmentCreationStatement);
//        String employeeCreationStatement="create table employee(EmpID integer primary key " +
//                "autoincrement,Name text not null,title text , phone text , email text , Dept_id integer,FOREIGN KEY(Dept_id)" +
//                " REFERENCES Department(DeptID));";
//        sqLiteDatabase.execSQL(employeeCreationStatement);
        sqLiteDatabase.execSQL("create table employee ( EMPID integer primary key  autoincrement , " +
                "name text not null , Title text not null , Phone text not null , Email text not null , Dept_id integer , FOREIGN KEY (Dept_id) REFERENCES Department (DeptID)  )");
        sqLiteDatabase.execSQL("create table department ( DeptID integer primary key  autoincrement , name text )"  );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS employee");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS department");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(Employee employee) {
//        try {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues row1 = new ContentValues();
        ContentValues row2 = new ContentValues();
        row1.put("name", employee.getDepartment().getName());
        //-------------------------
        row2.put("Name", employee.getName());
        row2.put("Title", employee.getTitle());
        row2.put("Phone", employee.getPhoneNo());
        row2.put("Email", employee.getEmail());
        long res = db.insert("department", null, row1);
        System.out.println("--------------------------------Result : " + res);
        if (res == -1) {
            return false;
        }
        res = db.insert("employee", null, row2);
        db.close();;
        System.out.println("-------------------Result : " + res);
        return (res != -1);

//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
    }
    @SuppressLint("Range")
    public ArrayList getAllEmployeeName(String targetName){
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from employee",null);
        res.moveToFirst();
        String name;
        System.out.println("getAllEmployeeName-*---------------- ");
        while (!res.isAfterLast()){
            System.out.println(res);
//            name=res.getString(1);;
            name=res.getString(res.getColumnIndex("name"));
            System.out.println(name);
            arrayList.add(name);
            res.moveToNext();
        }
        return arrayList;
    }
    public List<String> getEmployee(String Name) {
        SQLiteDatabase dbSqlite = getReadableDatabase();
        String[] rowDetails = {Name};
        Cursor cursor = dbSqlite.rawQuery("select * from employee where name = ?",rowDetails);
        String emp_name="Not Found";
        List<String> names = new ArrayList<>();
        if (cursor.moveToFirst()) {

            do{
                emp_name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                names.add(emp_name);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        dbSqlite.close();
        return names;
    }
}
