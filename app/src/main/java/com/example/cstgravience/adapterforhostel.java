package com.example.cstgravience;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class adapterforhostel extends RecyclerView.Adapter<adapterforhostel.MyViewHolder> {
    Context context;
    ArrayList<hdatamodel> newsarraylist;

    public adapterforhostel(Context context,ArrayList<hdatamodel> newsarraylist) {
        this.context=context;
        this.newsarraylist=newsarraylist;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.listitems,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        hdatamodel hdatamodel= newsarraylist.get(position);
        holder.grievance.setText(hdatamodel.getGrievance());
        holder.grievance_Id.setText(hdatamodel.getGrievanceId());
        holder.post_date.setText(hdatamodel.getDate());

        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.grievance.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Deleted data can't be undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String grivanceid = holder.grievance_Id.getText().toString();

                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference reference = firebaseDatabase.getReference("Deleted");
                        String key = reference.push().getKey();
                        reference.child(key).setValue(hdatamodel);

                        reference = firebaseDatabase.getReference("category");
                        Query query = reference.child("Hostel").orderByChild("grievanceId").equalTo(grivanceid);
                        query.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    dataSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });


                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.grievance.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.grievance.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Added Data can't be undo.");

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference reference = firebaseDatabase.getReference("Selected");
                String key = reference.push().getKey();
                reference.child(key).setValue(hdatamodel);
                Toast.makeText(holder.grievance.getContext(),"Grievance added",Toast.LENGTH_SHORT).show();

                        String grivanceid = holder.grievance_Id.getText().toString();
                        reference = firebaseDatabase.getReference("category");
                        Query query = reference.child("Hostel").orderByChild("grievanceId").equalTo(grivanceid);
                        query.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    dataSnapshot.getRef().removeValue();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.grievance.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

//                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//                DatabaseReference reference = firebaseDatabase.getReference("Selected");
//                String key = reference.push().getKey();
//
//                reference.child(key).setValue(hdatamodel);
//                Toast.makeText(holder.grievance.getContext(),"Grievance added",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return newsarraylist.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView grievance,grievance_Id,post_date;
        Button btn_add, btn_del;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            grievance=itemView.findViewById(R.id.grievance);
            btn_add = (Button) itemView.findViewById(R.id.admin_addGrievance);
            btn_del = (Button) itemView.findViewById(R.id.admin_deleteGrievance);
            grievance_Id=itemView.findViewById(R.id.grievance_ID);
            post_date = itemView.findViewById(R.id.Date_Of_Post);
        }
    }
}

