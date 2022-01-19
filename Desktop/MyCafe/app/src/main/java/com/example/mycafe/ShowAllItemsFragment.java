package com.example.mycafe;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowAllItemsFragment extends Fragment {
    private Db_frall databaseHandler;
    private RecyclerView recyclerView;
    private ShowUpdateAllitemsAdapter rvAdapter;
    private Button bt_cart,bt_done;

    public ShowAllItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_show_all_items, container, false);
        recyclerView= view.findViewById(R.id.recycler);
        databaseHandler = new Db_frall(faltu_context.context);
        //  rating=view.findViewById(R.id.rating);
        rvAdapter =new ShowUpdateAllitemsAdapter(databaseHandler.getAllitemsData("Active"));
        if(rvAdapter.getItemCount()==0){
            Toast.makeText(faltu_context.context, "No data found please contact to admin", Toast.LENGTH_SHORT).show();
            return view;
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
        recyclerView.setAdapter(rvAdapter);

        return view;
    }
}
