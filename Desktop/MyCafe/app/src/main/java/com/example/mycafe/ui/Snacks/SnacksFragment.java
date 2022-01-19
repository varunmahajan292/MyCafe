package com.example.mycafe.ui.Snacks;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycafe.Cart;
import com.example.mycafe.Db_frall;
import com.example.mycafe.MainActivity;
import com.example.mycafe.R;
import com.example.mycafe.ShowCartActivity;
import com.example.mycafe.ShowItemsAdapter;
import com.example.mycafe.faltu_context;
import com.example.mycafe.global_vars;

import java.util.ArrayList;

public class SnacksFragment extends Fragment {
    private Db_frall databaseHandler;
    private RecyclerView recyclerView;
    private ShowItemsAdapter rvAdapter;
    public ArrayList<Cart> cartArrayList;
    private int itmcnt=0;
    private int a=0;
    public  Cart cart;
    private Button bt_cart,bt_done;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.snack_layout, container, false);
        recyclerView= view.findViewById(R.id.recycler);

        databaseHandler = new Db_frall(faltu_context.context);
        //  rating=view.findViewById(R.id.rating);
        rvAdapter =new ShowItemsAdapter(databaseHandler.getAllImagesData("Snacks","Active") );
        if(rvAdapter.getItemCount()==0){
            Toast.makeText(faltu_context.context, "No data found please contact to admin", Toast.LENGTH_SHORT).show();
            return view;
        }
       recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
         recyclerView.setAdapter(rvAdapter);
        // if(rvAdapter.getItemCount()null){
          //   Toast.makeText(faltu_context.context, "Please enter all the fields", Toast.LENGTH_SHORT).show();
         //}

        bt_cart=view.findViewById(R.id.bt_cart);
        //a= rvAdapter.getItemCount();

        bt_done=view.findViewById(R.id.bt_done);
               bt_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });
         bt_done.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 global_vars globalVariable = (global_vars) faltu_context.context;
                 // ((global_vars) getActivity().getApplication()).setLoginUserID(Integer.parseInt(res2.getString(0)));
                 if(globalVariable .myGlobalArray.size()==0)
                 {
                     Toast.makeText(getActivity(),"Please Select Atleast one Item for Order",Toast.LENGTH_LONG).show();
                     return;
                 }
                 Intent i =new Intent(getActivity(),ShowCartActivity.class);
                 startActivity(i);
             }
         });

        return view;
    }
}