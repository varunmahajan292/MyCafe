package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ShowCartActivity extends AppCompatActivity {
    private Db_frall databaseHandler;
    private RecyclerView recyclerView;
    private ShowCartAdapter showCartAdapter;
    private Button generateorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cart);
        recyclerView= findViewById(R.id.recyclerView);

        databaseHandler = new Db_frall(faltu_context.context);
        //  rating=view.findViewById(R.id.rating);
        showCartAdapter =new ShowCartAdapter(databaseHandler.getcartdata() );
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(faltu_context.context));
        recyclerView.setAdapter(showCartAdapter);
        generateorder= findViewById(R.id.generateorder);
        generateorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean check  = db.insertData(fname.getText().toString(),lname.getText().toString(),email.getText().toString(), mobile.getText().toString(),pass.getText().toString(),"0");


                global_vars globalVariable = (global_vars) faltu_context.context;
                String idsandqty = "";
                for (int i = 0; i < globalVariable.myGlobalArray.size(); i++) {
                    String CSV = (String) globalVariable.myGlobalArray.get(i);
                    idsandqty = idsandqty + "k" + CSV;


                }

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String strDate = sdf.format(new Date());
                /////////////////////time//////////////////////
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String currentTime = simpleDateFormat.format(calendar.getTime());
                String result = null;
                try {
                    Date date = simpleDateFormat.parse(currentTime);
                    calendar.setTime(date);
                    calendar.add(Calendar.MINUTE, 10);
                    result = simpleDateFormat.format(calendar.getTime());

                } catch (ParseException e) {
                    e.printStackTrace();
                }
             /*  generateorder.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i =new Intent(getApplicationContext(),ViewReceipt.class);
                       startActivity(i);
                   }
               });*/

               // generateorder.setText(String.valueOf(globalVariable.getAmounttopay()));
                boolean check = databaseHandler.generateitems(idsandqty, globalVariable.getLoginUserID(), strDate, String.valueOf(globalVariable.getAmounttopay()), result, "qrcode", "Not Received", "0");
                if (check == true) {
                    Toast.makeText(faltu_context.context, "Order Generated", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(faltu_context.context, "Please Try again  ", Toast.LENGTH_SHORT).show();

                }
                Intent i =new Intent(getApplicationContext(),ViewReceipt.class);
                startActivity(i);
            }
        });

    }
}
