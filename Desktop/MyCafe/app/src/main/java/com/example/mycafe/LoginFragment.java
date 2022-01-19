package com.example.mycafe;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    Context context;
    Db_frall db;
    public EditText email, pass;
    public Button bt_login_login, bt_login_signup, bt_forgotpass;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        bt_login_login = view.findViewById(R.id.bt_login_login);
        bt_login_signup = view.findViewById(R.id.bt_login_signup);
        bt_forgotpass = view.findViewById(R.id.bt_forgotpass);
        email = view.findViewById(R.id.email);
        pass = view.findViewById(R.id.pass);
        db = new Db_frall(faltu_context.context);
        bt_login_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartingActivity.fm.beginTransaction().replace(R.id.frag_cont_page, new SignupFragment(), null).commit();
            }
        });
        bt_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((email.getText().toString()).equals("") || (pass.getText().toString()).equals("")) {

                    Toast.makeText(faltu_context.context, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Cursor res2 = db.userLoginID(email.getText().toString());
                if (res2.moveToFirst()) {

                    ((global_vars) getActivity().getApplication()).setLoginUserID(Integer.parseInt(res2.getString(0)));

                } else {

                    Toast.makeText(faltu_context.context, "Error While getting user id", Toast.LENGTH_SHORT).show();
                }
                //checking email and password/////
                Cursor res = db.checkLogin(email.getText().toString(), pass.getText().toString());

                if (res.moveToFirst()) {
                   // Toast.makeText(faltu_context.context, "Work ", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(getActivity(), MainActivity.class);
                    startActivity(myIntent);

                } else {
                    Toast.makeText(faltu_context.context, "Please try again login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StartingActivity.fm.beginTransaction().replace(R.id.frag_cont_page, new Forgot_password(), null).commit();
            }
        });
        return view;
    }
}
