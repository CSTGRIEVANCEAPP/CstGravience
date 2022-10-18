package com.example.cstgravience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterformainhome extends RecyclerView.Adapter<adapterformainhome.MyViewHolderHome> {

    Context context;
    ArrayList<displaydatamodel> homearraylist;

    public adapterformainhome(Context context, ArrayList<displaydatamodel> homearraylist) {
        this.context = context;
        this.homearraylist = homearraylist;


    }

    @NonNull
    @Override
    public adapterformainhome.MyViewHolderHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemlisthomepage, parent, false);
        return new adapterformainhome.MyViewHolderHome(v);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterformainhome.MyViewHolderHome holder, int position) {

        displaydatamodel displaydatamodel =homearraylist.get(position);
        holder.GVRANCE_TITLE.setText(displaydatamodel.getName());
        holder.displaygrievance.setText(displaydatamodel.getGrievance());
        holder.Add_to_Starred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+displaydatamodel.getGrievance(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return homearraylist.size() ;
    }

    public static class MyViewHolderHome extends RecyclerView.ViewHolder {

        TextView displaygrievance,GVRANCE_TITLE;
        Button Add_to_Starred;

        public MyViewHolderHome(@NonNull View itemView) {
            super(itemView);
            displaygrievance = itemView.findViewById(R.id.grievance);
            Add_to_Starred = itemView.findViewById(R.id.addtostarred);
            GVRANCE_TITLE = itemView.findViewById(R.id.GVRANCE_Title);
        }
    }
}