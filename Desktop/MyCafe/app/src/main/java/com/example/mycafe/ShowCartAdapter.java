package com.example.mycafe;

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

public class ShowCartAdapter extends RecyclerView.Adapter<ShowCartAdapter.RViewHolderClass>  {
    private ArrayList<Model> cartarray;
    public float Amounttopay;
    public ShowCartAdapter(ArrayList<Model> cartarray) {
        this.cartarray = cartarray;

    }

    public RViewHolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RViewHolderClass(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.customcart,viewGroup,false));
    }
    @Override
    public void onBindViewHolder(@NonNull RViewHolderClass holder, int position) {
         final Model objectModel =cartarray.get(position);

        holder.img.setImageBitmap(objectModel.getITEMIMAGE());
        holder.cost.setText(objectModel.getCOST());
        holder.itemname.setText(objectModel.getITEMNAME());
        holder.count.setText(objectModel.getCATEGORY());
        holder.layoutclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast.makeText(view.getContext(),"click on item: "+objectModel,Toast.LENGTH_LONG).show();
            }
        });
       Float f=Float.parseFloat(objectModel.getCOST())*Float.parseFloat(objectModel.getCATEGORY());
    Amounttopay=Amounttopay+f;
        global_vars globalVariable = (global_vars) faltu_context.context;
        //globalVariable.setAmounttopay(Amounttopay);
       String s=Float.toString(f) ;
       holder.ttl.setText(s);
        holder.faltu.setText(String.valueOf(objectModel.getID()));
    }

    @Override
    public int getItemCount() {

        if(cartarray!=null){
            return cartarray.size();
        }
        else
        {return 0;}
    }

    public static class RViewHolderClass extends RecyclerView.ViewHolder {
        TextView itemname,count,cost,faltu,ttl;
        Button decrease,add, cancel;
        ImageView img ;
        LinearLayout layoutclick;
        int counter=0;
        public RViewHolderClass(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            faltu=itemView.findViewById(R.id.faltu);
            cost=itemView.findViewById(R.id.cost);
            itemname=itemView.findViewById(R.id.itemname);
            layoutclick=itemView.findViewById(R.id.layoutclick);
            count=itemView.findViewById(R.id.count);
            decrease=itemView.findViewById(R.id.decrease);
            add=itemView.findViewById(R.id.add);
            ttl=itemView.findViewById(R.id.ttl);
            cancel=itemView.findViewById(R.id.cancel);
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
                    Float f= Float.parseFloat(count.getText().toString())*Float.parseFloat(cost.getText().toString());
                    String xv= ttl.getText().toString();
                    ttl.setText(String.valueOf(f).toString());
                    Float fk= Float.parseFloat(ttl.getText().toString())-Float.parseFloat(xv.toString());
                    ((global_vars) v.getContext().getApplicationContext()).setAmounttopay(((global_vars) v.getContext().getApplicationContext()).getAmounttopay()+fk);
                    //Toast.makeText(faltu_context.context, varlast, Toast.LENGTH_SHORT).show();
                    // cost.setText(String.valueOf( ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size()));
                }
            });
            ////////////////////////////////cancel
            cancel.setOnClickListener(new View.OnClickListener() {
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
                    else{ x=0;
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

                        //((global_vars) v.getContext().getApplicationContext()).myGlobalArray.add(varlast);
                        Float f= Float.parseFloat(count.getText().toString())*Float.parseFloat(cost.getText().toString());
                        String xv= ttl.getText().toString();
                        ttl.setText(String.valueOf(f).toString());
                        Float fk= Float.parseFloat(ttl.getText().toString())-Float.parseFloat(xv.toString());
                        ((global_vars) v.getContext().getApplicationContext()).setAmounttopay(((global_vars) v.getContext().getApplicationContext()).getAmounttopay()+fk);


                    //   Toast.makeText(faltu_context.context, varlast, Toast.LENGTH_SHORT).show();
                    // cost.setText(String.valueOf( ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size()));
                }
            });


            /////////////////////////////decrease
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
                        Float f= Float.parseFloat(count.getText().toString())*Float.parseFloat(cost.getText().toString());
                        String xv= ttl.getText().toString();
                        ttl.setText(String.valueOf(f).toString());
                        Float fk= Float.parseFloat(ttl.getText().toString())-Float.parseFloat(xv.toString());
                        ((global_vars) v.getContext().getApplicationContext()).setAmounttopay(((global_vars) v.getContext().getApplicationContext()).getAmounttopay()+fk);

                    }
                    //   Toast.makeText(faltu_context.context, varlast, Toast.LENGTH_SHORT).show();
                    // cost.setText(String.valueOf( ((global_vars) v.getContext().getApplicationContext()) .myGlobalArray.size()));
                }
            });





        }



    }

}
