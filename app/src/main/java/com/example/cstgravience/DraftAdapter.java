package com.example.cstgravience;

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

public class DraftAdapter extends RecyclerView.Adapter<DraftAdapter.ExampleViewHolder> {
    private ArrayList<DraftGrievance>  dGrievanceList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView GrievanceTopic,GrievanceContent,DG_ID;
        Button Post_DGrievance,draftGdeleteBtn;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            GrievanceTopic = itemView.findViewById(R.id.GVRANCE_Title);
            GrievanceContent = itemView.findViewById(R.id.grievance);
            Post_DGrievance = itemView.findViewById(R.id.Draft_PostBtn);
            DG_ID = itemView.findViewById(R.id.DG_ID);
            draftGdeleteBtn = itemView.findViewById(R.id.DeletefromDraft);
        }
    }

    public DraftAdapter(ArrayList<DraftGrievance> draftGrievanceList){
        dGrievanceList = draftGrievanceList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitemstared,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);

        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        DraftGrievance draftGrievance = dGrievanceList.get(position);
        holder.GrievanceTopic.setText(draftGrievance.getGrievance_Category());
        holder.GrievanceContent.setText(draftGrievance.getGrievance_Text());
        holder.DG_ID.setText(draftGrievance.getGrievanceID());


        holder.Post_DGrievance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.GrievanceContent.getContext());
                builder.setTitle("Are you sure?");
                builder.setMessage("Post data can't be undo.");

                builder.setPositiveButton("Post", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        DatabaseReference databaseReference = firebaseDatabase.getReference("category");
                        String key = databaseReference.push().getKey();

                        String grievance = holder.GrievanceContent.getText().toString();
                        String sCategory = holder.GrievanceTopic.getText().toString();
                        HelperClass helperClass = new HelperClass(grievance, key,sCategory);
                        databaseReference.child(sCategory).child(key).setValue(helperClass);
                        String grivanceid = holder.DG_ID.getText().toString();

                        databaseReference = firebaseDatabase.getReference("Draft");
                        Query query = databaseReference.orderByChild("grievanceID").equalTo(grivanceid);
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
                        Toast.makeText(holder.GrievanceContent.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });

    holder.draftGdeleteBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.GrievanceContent.getContext());
            builder.setTitle("Are you sure?");
            builder.setMessage("Deleted data can't be undo.");

            builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String grivanceid = holder.DG_ID.getText().toString();

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference reference = firebaseDatabase.getReference("Draft");

                    Query query = reference.orderByChild("grievanceID").equalTo(grivanceid);
                    query.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                                dataSnapshot.getRef().removeValue();
                                Toast.makeText(holder.GrievanceContent.getContext(),"Deleted",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(holder.GrievanceContent.getContext(),"Cancelled",Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();


        }
    });

    }

    @Override
    public int getItemCount() {
        return dGrievanceList.size();
    }
}
