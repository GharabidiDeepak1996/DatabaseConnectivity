package com.example.fill_formactivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "MyAdapter";

    private List<Student> mStudentList;
   // private Context mContext;

   /* public MyAdapter(Context context, List<Student> studentList) {
        mStudentList = studentList;
        mContext = context;
    }*/

    public MyAdapter(List<Student> studentList) {
        mStudentList = studentList;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName,mTvAge,mTvRoll,mTvGender;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );
            mTvName = itemView.findViewById( R.id.tv_name );
            mTvRoll=itemView.findViewById( R.id.tv_roll );
            mTvAge=itemView.findViewById( R.id.tv_age );
            mTvGender=itemView.findViewById( R.id.tv_gender );
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.recycler_view_item, parent, false );
        return new MyViewHolder( view );

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Log.d( TAG, "onBindViewHolder: Position : " + position);

        Student student = mStudentList.get(  position);
        Log.d( TAG, "onBindViewHolder: Name " + student.getName());
        holder.mTvName.setText( student.getName() );
        holder.mTvRoll.setText(String.valueOf( student.getRoll_no() ) );
        holder.mTvAge.setText(String.valueOf( student.getAge() ) );
        holder.mTvGender.setText( student.getGender() );

    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }


}
