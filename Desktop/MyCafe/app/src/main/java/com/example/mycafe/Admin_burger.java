package com.example.mycafe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class Admin_burger extends Fragment {
    EditText ed_itemname,ed_cost;
    ImageView mainitem;
    Button submit;
    private Uri filePath;
    private static final int PICK_IMAGE_REQUEST = 71;
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageinbtye;
    String encodedImage;
    //String encodedImage;
    private Bitmap imagetostore;
    Db_frall db;
    public Admin_burger() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin_burger, container, false);
        ed_itemname=view.findViewById(R.id.ed_itemname);
        ed_cost=view.findViewById(R.id.ed_cost);
        submit=view.findViewById(R.id.submit);
        mainitem=view.findViewById(R.id.mainitem);
        db = new Db_frall(faltu_context.context);
        //image code
        mainitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check  = db.insertUploadData("Burgers",ed_itemname.getText().toString(), imageinbtye,ed_cost.getText().toString(),"Active","0");

                if(check==true) {
                    Toast.makeText(faltu_context.context, "You item is inserted successfully ", Toast.LENGTH_SHORT).show();
                    ed_itemname.setText("");
                    ed_cost.setText("");
                    //email.setText("");
                    //mobile.setText("");
                    //pass.setText("");
                    // StartingActivity.fm.beginTransaction().replace(R.id.frag_cont_page,new UserLoginFragment(), null).commit();
                }
                else{
                    Toast.makeText(faltu_context.context, "Please Try again Insertion failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return view;

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                imagetostore = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                mainitem.setImageBitmap(imagetostore);
                mainitem.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Bitmap bitmap=imagetostore;
                byteArrayOutputStream =new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,71,byteArrayOutputStream);
                imageinbtye =byteArrayOutputStream.toByteArray();
                // encodedImage= Base64.encodeToString(imageinbtye, Base64.DEFAULT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
