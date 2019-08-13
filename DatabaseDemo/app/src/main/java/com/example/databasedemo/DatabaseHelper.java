package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "databasedemo.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TAG = "DatabaseHelper";


    public class Students {
        public static final String TABLE_NAME = "STUDENT";
        public static final String NAME = "NAME";
        public static final String AGE = "AGE";
    }


    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create TABLE STUDENT (NAME text , AGE integer);";
        sqLiteDatabase.execSQL( query );
        Log.d( TAG, "onCreate: " );
    }

   /* public void insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO " +  Students.TABLE_NAME + " VALUES('ABC', 20)";
        db.execSQL( query );

        Log.d( TAG, "insert: " );
    }*/

    public void insert(Student student) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(  );
        contentValues.put(Students.NAME, student.getName());
        contentValues.put( Students.AGE,  student.getAge());
        long row = database.insert( Students.TABLE_NAME, null, contentValues  );
        //long row = database.insertWithOnConflict( "STUDENT", null, contentValues, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "insert: " + row);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d( TAG, "onUpgrade: " );
    }

    public void display() {
        String query = "SELECT * FROM STUDENT";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( query,  null);
        Log.d( TAG, "display: Cursor count : " + cursor.getCount());
        while (cursor.moveToNext()) {
            String name = cursor.getString( cursor.getColumnIndex( Students.NAME ) );
            int age  = cursor.getInt( cursor.getColumnIndex( Students.AGE ) );

            Log.d( TAG, "display: Name : " + name + ", Age : " + age);
        }

       /* for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition( i );
        }*/
        cursor.close();
    }
}
