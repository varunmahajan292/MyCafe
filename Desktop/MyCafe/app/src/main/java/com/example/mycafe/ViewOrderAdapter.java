package com.example.mycafe;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewOrderAdapter  extends RecyclerView.Adapter<ViewOrderAdapter.RViewHolderClass> {
  private ArrayList<Orderview> orderviewArrayList;
    public ViewOrderAdapter(ArrayList<Orderview> orderviewArrayList) {
        this.orderviewArrayList=orderviewArrayList;

    }

    public RViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custiom_vieworder, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolderClass holder, int position) {
        final Orderview objectModel =orderviewArrayList.get(position);
        holder.tvorder.setText(String.valueOf(objectModel.getID()));
        holder.tvname.setText(objectModel.getFname());
        holder.tvtime.setText(objectModel.getRecievingtime());
        holder.tvstatus.setText(objectModel.getStatus());

    }

    @Override
    public int getItemCount() {
        if(orderviewArrayList!=null){
            return orderviewArrayList.size();
        }
        else
        {return 0;}
    }


    public static class RViewHolderClass extends RecyclerView.ViewHolder {
        TextView tvtime,tvstatus,tvname,tvorder, faltu;
        Button viewdetails;


        public RViewHolderClass(@NonNull View itemView) {
            super(itemView);
            tvtime =itemView.findViewById(R.id.tvtime);
            tvstatus =itemView.findViewById(R.id.tvstatus);
            tvname =itemView.findViewById(R.id.tvname);
            tvorder =itemView.findViewById(R.id.tvorder);
           // faltu =itemView.findViewById(R.id.faltu);
            viewdetails =itemView.findViewById(R.id.viewdetails);
            viewdetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((global_vars) v.getContext().getApplicationContext()) .setIdofgenerate(Integer.parseInt(tvorder.getText().toString()));
                    Intent i = new Intent(v.getContext(),Customer_Order_Detail.class);
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
