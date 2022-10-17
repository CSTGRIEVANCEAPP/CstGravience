package com.example.cstgravience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterforstarred extends RecyclerView.Adapter<adapterforstarred.MyViewHolder> {
    Context context;
    ArrayList<stareddatamodel> staredarraylist;

    public adapterforstarred(Context context,ArrayList<stareddatamodel> staredarraylist) {
        this.context=context;
        this.staredarraylist=staredarraylist;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.listitems,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        stareddatamodel stareddatamodel=staredarraylist.get(position);
        holder.staredgrievance.setText(stareddatamodel.staredgrievance);
    }



    @Override
    public int getItemCount() {
        return staredarraylist.size();
    }
    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView staredgrievance;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           staredgrievance=itemView.findViewById(R.id.grievance);
        }
    }
}
