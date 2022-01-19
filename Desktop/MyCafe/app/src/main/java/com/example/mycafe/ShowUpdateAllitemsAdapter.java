package com.example.mycafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowUpdateAllitemsAdapter extends RecyclerView.Adapter<ShowUpdateAllitemsAdapter.RecViewHolderClass> {
private ArrayList<Model> allitemsList;
private static Db_frall myDb;
public ShowUpdateAllitemsAdapter(ArrayList<Model> allitemsList) {
        this.allitemsList = allitemsList;

    this.myDb = new Db_frall(faltu_context.context);
        }
    public ShowUpdateAllitemsAdapter.RecViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ShowUpdateAllitemsAdapter.RecViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_allitems,viewGroup,false));
    }
    @Override
    public void onBindViewHolder(@NonNull ShowUpdateAllitemsAdapter.RecViewHolderClass holder, int position) {
        final Model objectModel =allitemsList.get(position);

        holder.img.setImageBitmap(objectModel.getITEMIMAGE());
        holder.cost.setText(objectModel.getCOST());
        holder.itemname.setText(objectModel.getITEMNAME());
        holder.faltu.setText(String.valueOf(objectModel.getID()));
        holder.layoutclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(),"click on item: "+objectModel,Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public int getItemCount() {
        if(allitemsList!=null){
            return allitemsList.size();
        }
        else
        {return 0;}

    }
    public static class RecViewHolderClass extends RecyclerView.ViewHolder {
        EditText itemname,cost;
        TextView faltu;
        Button remove ,update;
        ImageView img,imgcross ;
        LinearLayout layoutclick;
        int counter=0;

        public RecViewHolderClass(@NonNull View itemView) {
            super(itemView);
            //this.myDb = new Db_frall(faltu_context.context);
            img = itemView.findViewById(R.id.img);
            faltu = itemView.findViewById(R.id.faltu);
            cost = itemView.findViewById(R.id.cost);
            imgcross = itemView.findViewById(R.id.imgcross);
            itemname = itemView.findViewById(R.id.itemname);
            layoutclick = itemView.findViewById(R.id.layoutclick);
          //  count = itemView.findViewById(R.id.count);
            remove = itemView.findViewById(R.id.remove);
            update = itemView.findViewById(R.id.update);
            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isUpdate = myDb.updateITEMDETAILS(faltu.getText().toString(),itemname.getText().toString(),cost.getText().toString(),"Active" );

                    if(isUpdate == true)
                        Toast.makeText(v.getContext(),"Item Updated Successfully",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(v.getContext(),"Item Not Updated",Toast.LENGTH_LONG).show();
                }
            });
            //
                remove.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View v) {
                    boolean isUpdate = myDb.updateITEMDETAILS(faltu.getText().toString(),itemname.getText().toString(),cost.getText().toString(),"Deactive" );

                    if(isUpdate == true){
                        Toast.makeText(v.getContext(),"Item Removed Successfully",Toast.LENGTH_LONG).show();
                    imgcross.setVisibility(View.VISIBLE);}
                    else{
                        Toast.makeText(v.getContext(),"Item Not Removed ",Toast.LENGTH_LONG).show();}
                }

               });

        }
    }


}
