package com.example.mycafe.ui.Desserts;

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

import com.example.mycafe.Db_frall;
import com.example.mycafe.R;
import com.example.mycafe.ShowCartActivity;
import com.example.mycafe.ShowItemsAdapter;
import com.example.mycafe.faltu_context;
import com.example.mycafe.global_vars;

public class DessertFragment extends Fragment {
    private Db_frall databaseHandler;
    private RecyclerView recyclerView;
    private ShowItemsAdapter rvAdapter;
    private Button bt_cart,bt_done;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.desserts_layout, container, false);
        recyclerView= view.findViewById(R.id.recycler);
        databaseHandler = new Db_frall(faltu_context.context);
        //  rating=view.findViewById(R.id.rating);
        rvAdapter =new ShowItemsAdapter(databaseHandler.getAllImagesData("Desserts","Active") );
        if(rvAdapter.getItemCount()==0){
            Toast.makeText(faltu_context.context, "No data found please contact to admin", Toast.LENGTH_SHORT).show();
            return view;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
        recyclerView.setAdapter(rvAdapter);
        bt_cart=view.findViewById(R.id.bt_cart);
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
                Intent i =new Intent(getActivity(), ShowCartActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}

