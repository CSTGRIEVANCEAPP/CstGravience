package com.example.cstgravience;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DraftAdapter extends RecyclerView.Adapter<DraftAdapter.ExampleViewHolder> {
    private ArrayList<DraftGrievance>  dGrievanceList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView GrievanceTopic,GrievanceContent;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            GrievanceTopic = itemView.findViewById(R.id.GVRANCE_Title);
            GrievanceContent = itemView.findViewById(R.id.grievance);
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


    }

    @Override
    public int getItemCount() {
        return dGrievanceList.size();
    }
}
