package com.example.cstgravience;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StarredAdapter extends RecyclerView.Adapter<StarredAdapter.ExampleViewHolder> {
    private ArrayList<StarredDataModel> sGrievanceList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView GrievanceTopic,GrievanceContent;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            GrievanceTopic = itemView.findViewById(R.id.GVRANCE_Title);
            GrievanceContent = itemView.findViewById(R.id.grievance);
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
        holder.GrievanceTopic.setText(starredGrievance.getGrievanceTITLE());
        holder.GrievanceContent.setText(starredGrievance.getGrieveanceTEXT());


    }
    @Override
    public int getItemCount() {
        return sGrievanceList.size();
    }
}
