package com.example.mycafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

public class ShowItemsAdapter extends RecyclerView.Adapter<ShowItemsAdapter.RVViewHolderClass> {
    private ArrayList<Model> modelArrayList;

    public ShowItemsAdapter(ArrayList<Model> modelArrayList) {
        this.modelArrayList = modelArrayList;

    }
    public RVViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RVViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.custom_list,viewGroup,false));
    }
    @Override
    public void onBindViewHolder(@NonNull RVViewHolderClass holder, int position) {
        final Model objectModel =modelArrayList.get(position);

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
      if(modelArrayList!=null){
          return modelArrayList.size();
      }
      else
      {return 0;}

    }

    public static class RVViewHolderClass extends RecyclerView.ViewHolder {
        TextView itemname,count,cost,faltu;
        Button decrease,add;
        ImageView img ;
      LinearLayout layoutclick;
        int counter=0;

        public RVViewHolderClass(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            faltu=itemView.findViewById(R.id.faltu);
            cost=itemView.findViewById(R.id.cost);
            itemname=itemView.findViewById(R.id.itemname);
            layoutclick=itemView.findViewById(R.id.layoutclick);
            count=itemView.findViewById(R.id.count);
            decrease=itemView.findViewById(R.id.decrease);
            add=itemView.findViewById(R.id.add);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //counter++;
                     //count.setText(Integer.toString(counter));
                    int x=Integer.parseInt(count.getText().toString());
                   x++;
                    count.setText( String.valueOf(x));
                    String s=faltu.getText().toString();
                     String a=count.getText().toString();;
               String it;
                     boolean del=false;
                   // ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.add("6");
                    for(int i=0;i<((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size();i++){

                        String CSV = (String) ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.get(i);
                        String[] values = CSV.split(",");
                        if(del==false) {
                            if (s.equals(values[0])) {
                                ((global_vars) v.getContext().getApplicationContext()).myGlobalArray.remove(i);

                                del = true;
                            }
                        }
                    }
                   String varlast=s+","+a;
                    ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.add(varlast);
                    //Toast.makeText(faltu_context.context, varlast, Toast.LENGTH_SHORT).show();
                   // cost.setText(String.valueOf( ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size()));
                }
            });
            decrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //   if(counter<0){
                   //     return ;
                    //}
                    //counter--;
                    //count.setText(Integer.toString(counter));
                    int x=Integer.parseInt(count.getText().toString());
                    if(x==0)
                    {return;
                    }
                    else{ x--;
                    }

                    count.setText( String.valueOf(x));
                    String s=faltu.getText().toString();
                    String a=count.getText().toString();;
                    boolean del=false;
                    // ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.add("6");
                    for(int i=0;i<((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size();i++){
                        String CSV = (String) ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.get(i);
                        String[] values = CSV.split(",");
                        if(del==false) {
                            if (s.equals(values[0])) {
                                ((global_vars) v.getContext().getApplicationContext()).myGlobalArray.remove(i);
                                del = true;
                            }
                        }
                    }

                    String varlast=s+","+a;
                    if(count.getText().equals("0")){}
                    else {
                        ((global_vars) v.getContext().getApplicationContext()).myGlobalArray.add(varlast);
                    }
                 //   Toast.makeText(faltu_context.context, varlast, Toast.LENGTH_SHORT).show();
                   // cost.setText(String.valueOf( ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size()));
                }
            });



        }



    }

}
