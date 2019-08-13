package com.example.databasetoactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super( context, "mydatabase.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE STUDENT (NAME TEXT, AGE INTEGER);";
        db.execSQL( query );


    }

public void insert(String name,int age, SQLiteDatabase db) {


    ContentValues values = new ContentValues();
    values.put( "NAME",name  );
    values.put( "AGE", age );
    db.insert( "STUDENT", null, values );

    insert( "deepak", 23, db );
    insert( "sonu", 20, db );
    insert( "sunil", 19, db );
    insert( "sanjana", 18, db );
}




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
