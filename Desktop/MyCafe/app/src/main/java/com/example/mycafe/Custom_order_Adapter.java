package com.example.mycafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Custom_order_Adapter extends RecyclerView.Adapter<Custom_order_Adapter.RViewHolderClass>  {
    private ArrayList<ViewDetail> viewDetailArrayList;
    public Custom_order_Adapter(ArrayList<ViewDetail> viewDetailArrayList) {
        this.viewDetailArrayList=viewDetailArrayList;

    }

    public RViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_customer_order, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolderClass holder, int position) {
        final ViewDetail objectModel =viewDetailArrayList.get(position);
        holder.itemname.setText(objectModel.getItemname());
        holder.itemorder.setText(objectModel.getTotalitems());
        holder.count.setText(objectModel.getNooforders());
        holder.amount.setText(objectModel.getTotalcost());
        holder.img.setImageBitmap(objectModel.getItemimage());
    }



    @Override
    public int getItemCount() {
        if(viewDetailArrayList!=null){
            return viewDetailArrayList.size();
        }
        else
        {return 0;}
    }


    public static class RViewHolderClass extends RecyclerView.ViewHolder {
        TextView itemname,count,itemorder,amount, faltu;
        ImageView img;


        public RViewHolderClass(@NonNull View itemView) {
            super(itemView);
            itemname =itemView.findViewById(R.id.itemname);
            count =itemView.findViewById(R.id.count);
            itemorder =itemView.findViewById(R.id.itemorder);
            amount =itemView.findViewById(R.id.amount);
             faltu =itemView.findViewById(R.id.faltu);
            img =itemView.findViewById(R.id.img);

        }
    }
}
