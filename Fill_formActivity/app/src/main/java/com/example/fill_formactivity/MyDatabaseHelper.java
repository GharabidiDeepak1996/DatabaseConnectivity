package com.example.fill_formactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "MyDatabaseHelper";



    public class Students {

        public static final String TABLE_NAME = "student";
        public static final String NAME = "name";
        public static final String ROLL_NUMBER = "roll_number";
        public static final String AGE = "age";
        public static final String GENDER = "gender";
    }

    public MyDatabaseHelper(Context context) {

        super( context, "database.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query = "CREATE TABLE STUDENT (NAME TEXT,ROLLNO INTEGER ,AGE INTEGER,GENDER TEXT);";
        String query = "CREATE TABLE " + Students.TABLE_NAME + "( "
                + Students.NAME + " TEXT, "
                + Students.ROLL_NUMBER + " INTEGER, "
                + Students.AGE + " INTEGER, "
                + Students.GENDER + " TEXT );";
        Log.d( TAG, "onCreate: Query : " + query );
        db.execSQL( query );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
           /*       onway
    public void insert(String name, int roll, int age, String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put( Students.NAME, name );
        contentValues.put( Students.ROLL_NUMBER, roll );
        contentValues.put( Students.AGE, age );
        contentValues.put( Students.GENDER, gender );

*/
           public void insert(Student student) {
               SQLiteDatabase db = this.getWritableDatabase();    //write into the table
               ContentValues contentValues = new ContentValues();  //insert the values in rows
               contentValues.put( Students.NAME, student.getName() );
               contentValues.put( Students.ROLL_NUMBER, student.getRoll_no() );
               contentValues.put( Students.AGE, student.getAge() );
               contentValues.put( Students.GENDER, student.getGender() );


               Log.d( TAG, "insert: " +  student.getName()  );
        Log.d( TAG, "insert: " + student.getRoll_no() );
        Log.d( TAG, "insert: " + student.getAge() );
        Log.d( TAG, "insert: " + student.getGender() );

        long row = db.insert( Students.TABLE_NAME, null, contentValues); //row count number of rows inserted
        Log.d( TAG, "insert: Row : " + row);
    }

  /*  public void display() {


    }*/
  /*public void updateStudent(String name, int rollNumber) {
      SQLiteDatabase database = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues(  );
      contentValues.put( Students.ROLL_NUMBER,  rollNumber);
      //Query to change name where rollNumber equal to provided in the method argument
      //int update = database.update( Students.TABLE_NAME, contentValues, Students.ROLL_NUMBER + "=?", new String[]{String.valueOf( rollNumber )} );
      int update = database.update( Students.TABLE_NAME, contentValues, Students.NAME + "=?", new String[]{name } );
      Log.d( TAG, "updateStudent: Affected row : " + update);
      //database.update(Students.TABLE_NAME, contentValues, Students.ROLL_NUMBER + "=" + rollNumber , null);
  }*/

  public void updateStudent(String name, int rollNumber) {
      Log.d( TAG, "updateStudent: "+name );
      Log.d( TAG, "updateStudent:1 " +rollNumber);
      SQLiteDatabase database = this.getWritableDatabase();
      ContentValues contentValues = new ContentValues(  );
      contentValues.put( Students.ROLL_NUMBER,  rollNumber); //update the roll number
      Log.d( TAG, "updateStudent:1 " +contentValues);
      //Query to change name where rollNumber equal to provided in the method argument
      //int update = database.update( Students.TABLE_NAME, contentValues, Students.ROLL_NUMBER + "=?", new String[]{String.valueOf( rollNumber )} );
    int update = database.update( Students.TABLE_NAME, contentValues, Students.NAME + "=?", new String[]{name} );

      Log.d( TAG, "updateStudent: Affected row : " + update);
      //database.update(Students.TABLE_NAME, contentValues, Students.ROLL_NUMBER + "=" + rollNumber , null);
  }

  public void deleteStudent(int rollNumber) {
      SQLiteDatabase database = this.getWritableDatabase();
      int delete = database.delete( Students.TABLE_NAME, Students.ROLL_NUMBER + "=?", new String[]{String.valueOf( rollNumber )} );
      Log.d( TAG, "deleteStudent: Number of students deleted : " +delete);
  }
/*
      //logcat display
    public void display() {
        String query = "SELECT * FROM " + Students.TABLE_NAME;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( query, null );

        while(cursor.moveToNext()){
            String name=cursor.getString( cursor.getColumnIndex(Students.NAME ));
            int roll_no=cursor.getInt( cursor.getColumnIndex( MyDatabaseHelper.Students.ROLL_NUMBER ) );
            int age=cursor.getInt( cursor.getColumnIndex( MyDatabaseHelper.Students.AGE ));
           String gender= cursor.getString( cursor.getColumnIndex( MyDatabaseHelper.Students.GENDER ));
            Log.d( TAG, "display: Name : " + name + ", Roll_no : " + roll_no+", Age : " + age+",Gender :" +gender);
        }
        cursor.close();
    }*/

   // public List<Student> x() {
    public   List<Student> display(){
      List<Student> studentList = new ArrayList<>(  );
        String query = "SELECT * FROM " + Students.TABLE_NAME;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( query, null );
        StringBuffer stringBuffer = new StringBuffer();
       // Student student1=null; optional

        while(cursor.moveToNext()){
            Student student = new Student();
            String name=cursor.getString( cursor.getColumnIndex(Students.NAME ));
            int roll_no=cursor.getInt( cursor.getColumnIndex( MyDatabaseHelper.Students.ROLL_NUMBER ) );
            int age=cursor.getInt( cursor.getColumnIndex( MyDatabaseHelper.Students.AGE ));
            String gender= cursor.getString( cursor.getColumnIndex( MyDatabaseHelper.Students.GENDER ));
            Log.d( TAG, "display: Name : " + name + ", Roll_no : " + roll_no+", Age : " + age+",Gender :" +gender);

            student.setName( name );
            student.setAge( age );
            student.setRoll_no( roll_no);
            student.setGender( gender );

            stringBuffer.append( student);
            studentList.add( student );



        }
        cursor.close();

        return studentList;
    }

}
