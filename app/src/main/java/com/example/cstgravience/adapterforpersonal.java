package com.example.cstgravience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterforpersonal extends RecyclerView.Adapter<adapterforpersonal.MyViewHolder> {
    Context context;
    ArrayList<pdatamodel> newsarraylist;

    public adapterforpersonal(Context context,ArrayList<pdatamodel> newsarraylist) {
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

        pdatamodel pdatamodel= newsarraylist.get(position);
        holder.grievance.setText(pdatamodel.getGrievance());


    }

    @Override
    public int getItemCount() {
        return newsarraylist.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView grievance;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            grievance=itemView.findViewById(R.id.grievance);
        }
    }
}
