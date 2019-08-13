package com.example.databasetoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView Mtv1,Mtv2;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Mtv1=findViewById( R.id.tv1 );
        Mtv2=findViewById( R.id.tv2 );

        DatabaseHelper help=new DatabaseHelper(  this);
        SQLiteDatabase data=help.getReadableDatabase();

        @SuppressLint("Recycle") Cursor c=data.rawQuery( "SELECT * FROM STUDENT",new String[]{} );//  new String[]{} --- for arrgument





      /*  if(c!=null){
            c.moveToFirst();
        }
        do{
            String name=c.getString( 0 );
            int age=c.getInt( 1 );

            Mtv1.setText( name );
            Mtv2.setText(String.valueOf(age));
        }while (c.moveToNext());*/




    }
}
