package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        mContext = this;
    }

    public void insert(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper( mContext );
        Student student = new Student();
        student.setName( "afsaf asd" );
        student.setAge( 34 );
        databaseHelper.insert(student);
    }

    public void display(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper( mContext );
        databaseHelper.display();
    }
}
