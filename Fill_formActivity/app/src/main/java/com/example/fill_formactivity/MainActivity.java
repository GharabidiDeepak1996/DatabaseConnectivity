package com.example.fill_formactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void ActivityStart(View v){

        Intent i = new Intent(MainActivity.this,Form_Activity.class);
        startActivity(i);
       // setContentView(R.layout.activity_form_);
    }

    public void update(View view) {
        MyDatabaseHelper helper = new MyDatabaseHelper( this );
        helper.updateStudent( "ABC" , 5);

    }

    public void delete(View view) {
        MyDatabaseHelper helper = new MyDatabaseHelper( this );
        helper.deleteStudent( 5 );
    }

    public void Display(View v){
Intent intent =new Intent( this,Recycleview.class );
startActivity( intent );
    }
}
