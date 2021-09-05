package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//class name with DBmanaget you can give any name to the class//

public class DBmanaget  extends SQLiteOpenHelper {


// here we give a table name "StudentDesc.db" where we put our data//
    private static final String dbname="StudentDesc.db";

//make a constructur to call the object  dbname , factory null and version 1//
    public DBmanaget(@Nullable Context context) {
        super(context, dbname, null, 1);

    }


// oncreate method of sqlitedatabase with the name of (db) and we created table inside this where id is auto increment but name ,email and course fill manually//
    @Override
    public void onCreate(SQLiteDatabase db) {
       String qry="create table tbl_student(id integer primary key autoincrement, name text, email text, course text)";
       db.execSQL(qry);
    }

    // onupdate method here we put table name to update anything we wamt in the table//
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP  TABLE IF EXISTS tbl_student");

    }

     // we made a method to insert the information and here we put our oncreate database name in string//
    public String addrecord(String p1, String p2, String p3)
    {


        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",p1);
        cv.put("email",p2);
        cv.put("course",p3);

      long res=  db.insert("tbl_student",null,cv);
      
         if(res == -1)

              return "Failed";
               else
              return "success";



    }

}
