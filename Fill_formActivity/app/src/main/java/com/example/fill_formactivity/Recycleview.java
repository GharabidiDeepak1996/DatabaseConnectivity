package com.example.fill_formactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Recycleview extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyAdapter myAdapter;
    List<Student> StudentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recycleview );

        StudentList=new ArrayList<Student>(  );
        mRecyclerView = findViewById( R.id.recycler_view );


        MyDatabaseHelper mc=new MyDatabaseHelper( this );
        StudentList=  mc.display();
        myAdapter=new MyAdapter(StudentList);

        //Layout manager which tells to recyclerView that which type of list it is
        LinearLayoutManager layoutManager = new LinearLayoutManager( this );
        mRecyclerView.setLayoutManager( layoutManager );

       //MyAdapter adapter = new MyAdapter(this, mc.Students);
        mRecyclerView.setAdapter(myAdapter  );

    }
}
