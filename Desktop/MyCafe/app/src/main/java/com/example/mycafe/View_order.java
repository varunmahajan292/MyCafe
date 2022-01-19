package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

public class View_order extends AppCompatActivity {
    private Db_frall databaseHandler;
    private RecyclerView recyclerView;
    private ViewOrderAdapter rvAdapter;
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        recyclerView = findViewById(R.id.recycler);
        databaseHandler = new Db_frall(faltu_context.context);

        rvAdapter = new ViewOrderAdapter(databaseHandler.fetchdetails());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
        recyclerView.setAdapter(rvAdapter);
    }
}