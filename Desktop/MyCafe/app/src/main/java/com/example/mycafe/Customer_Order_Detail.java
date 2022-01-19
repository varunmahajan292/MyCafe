package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

public class Customer_Order_Detail extends AppCompatActivity {
    private Db_frall databaseHandler;
    private RecyclerView recyclerView;
    private Custom_order_Adapter rvAdapter;
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__order__detail);

        recyclerView = findViewById(R.id.recycler);
        databaseHandler = new Db_frall(faltu_context.context);
        global_vars g = (global_vars) faltu_context.context;
        rvAdapter = new Custom_order_Adapter(databaseHandler.getAllOrderDetails( String.valueOf(g.getIdofgenerate())));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
        recyclerView.setAdapter(rvAdapter);
    }
}
