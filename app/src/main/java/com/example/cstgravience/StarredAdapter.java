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

public class StarredAdapter extends RecyclerView.Adapter<StarredAdapter.ExampleViewHolder> {
    private ArrayList<StarredDataModel> sGrievanceList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView GrievanceTopic,GrievanceContent,DG_ID;
        Button StarredGdeletBtn, GPostBtn;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            GrievanceTopic = itemView.findViewById(R.id.GVRANCE_Title);
            GrievanceContent = itemView.findViewById(R.id.grievance);
            StarredGdeletBtn = itemView.findViewById(R.id.DeletefromDraft);
            DG_ID = itemView.findViewById(R.id.DG_ID);
            GPostBtn = itemView.findViewById(R.id.Draft_PostBtn);
        }
    }
    public StarredAdapter(ArrayList<StarredDataModel> starredGrievanceList){
        sGrievanceList = starredGrievanceList;
    }
    @NonNull
    @Override
    public StarredAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitemstared,parent,false);
        StarredAdapter.ExampleViewHolder evh = new StarredAdapter.ExampleViewHolder(v);

        return evh;
    }
    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        StarredDataModel starredGrievance = sGrievanceList.get(position);
        holder.GPostBtn.setVisibility(View.GONE);
        holder.GrievanceTopic.setText(starredGrievance.getGrievanceTITLE());
        holder.GrievanceContent.setText(starredGrievance.getGrieveanceTEXT());
        holder.DG_ID.setText(starredGrievance.getStarredGrievanceID());

        holder.StarredGdeletBtn.setOnClickListener(new View.OnClickListener() {
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
                        DatabaseReference reference = firebaseDatabase.getReference("starred");

                        Query query = reference.orderByChild("starredGrievanceID").equalTo(grivanceid);
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


    }
    @Override
    public int getItemCount() {
        return sGrievanceList.size();
    }
}
