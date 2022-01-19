package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mycafe.ui.Snacks.SnacksFragment;

public class AdminTasksActivity extends AppCompatActivity {
    public static FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tasks);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        faltu_context.context=getApplicationContext();

        fm =  getSupportFragmentManager();
        if (findViewById(R.id.frag_cont_page_adm)!=null)
        {
            if(savedInstanceState != null)
            { return;}

            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            //  Admin_car_Upload lg = new Admin_car_Upload();
            ShowAllItemsFragment lg= new ShowAllItemsFragment();
            fragmentTransaction.add(R.id.frag_cont_page_adm, lg, null);
            fragmentTransaction.commit();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menuadmin, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
//respond to menu item selection
        switch (item.getItemId()) {
            case R.id.allorders:
                //AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new ShowAllItemsFragment(), null).commit();
                // StartingActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new AdminLoginFragment(), null).commit();
                 startActivity(new Intent(this,View_order.class));
                return true;
            case R.id.allitems:
                AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new ShowAllItemsFragment(), null).commit();
                // StartingActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new AdminLoginFragment(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;

            case R.id.snack:
                   AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new Admin_Snack(), null).commit();
                // StartingActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new AdminLoginFragment(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;
            case R.id.burger:
                AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new Admin_burger(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;
            case R.id.coldbeverages:
                AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new Admin_Coldbeverages(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;
            case R.id.hotbeverages:
                AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new Admin_Hotbeverages(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;
            case R.id.muffins:
                AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new Admin_Muffins(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;
            case R.id.Gotouserlogin:
                startActivity(new Intent(this,StartingActivity.class));
                return true;
            case R.id.deserts:
                AdminTasksActivity.fm.beginTransaction().replace(R.id.frag_cont_page_adm,new Admin_Desserts(), null).commit();
                // startActivity(new Intent(this,AdminTasks.class));
                return true;
            case R.id.Logout:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
