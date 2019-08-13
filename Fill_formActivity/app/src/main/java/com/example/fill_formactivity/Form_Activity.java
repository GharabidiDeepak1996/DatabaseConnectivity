package com.example.fill_formactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Form_Activity extends AppCompatActivity {

    EditText etname,etroll,etage;
    RadioButton RButton;
    RadioGroup RGroup;

    private static final String TAG = "Form_Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_form_ );

        etname = findViewById( R.id.ETname );
        etroll = findViewById( R.id.ETrollno );
        etage=findViewById( R.id.ETage );
        RGroup=findViewById( R.id.radioGroup );

    }

    public void insert(View v) {
        MyDatabaseHelper md = new MyDatabaseHelper( this );

        /*String name = etname.getText().toString();
        int roll = Integer.parseInt( etroll.getText().toString() );
        int age = Integer.parseInt( etage.getText().toString() );
        int ButtonId = RGroup.getCheckedRadioButtonId();
        RButton = findViewById( ButtonId );

        String gender = RButton.getText().toString();

        md.insert( name, roll, age, gender );*/
        Student student = new Student();
        String name = etname.getText().toString();
        student.setName( name);
        int roll = Integer.parseInt( etroll.getText().toString() );
        student.setRoll_no( roll );
        int age = Integer.parseInt( etage.getText().toString() );
        student.setAge( age );
        int ButtonId = RGroup.getCheckedRadioButtonId();
        RButton = findViewById( ButtonId );
        String gender = RButton.getText().toString();
        student.setGender( gender );

       md.insert( student );
      finish();
    }


}
