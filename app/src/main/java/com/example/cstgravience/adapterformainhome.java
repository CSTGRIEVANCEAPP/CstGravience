package com.example.cstgravience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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


        displaydatamodel displaydatamodel = homearraylist.get(position);
        holder.displaygrievance.setText(displaydatamodel.displaygrievance);

    }

    @Override
    public int getItemCount() {
        return homearraylist.size() ;
    }

    public static class MyViewHolderHome extends RecyclerView.ViewHolder {

        TextView displaygrievance;

        public MyViewHolderHome(@NonNull View itemView) {
            super(itemView);
            displaygrievance = itemView.findViewById(R.id.grievance);
        }
    }
}