package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class ViewReceipt extends AppCompatActivity {
    Context context;
    Db_frall db;//

    TextView amount,recievetime;
    private ImageView qrImage;
    private Button btnview;
    private String inputValue;
    private String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    private Bitmap bitmap;
    static final long ONE_MINUTE_IN_MILLIS=60000;
    private QRGEncoder qrgEncoder;
    private AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_receipt);
        amount = findViewById(R.id.amount);
        btnview = findViewById(R.id.btnview);
        recievetime = findViewById(R.id.recievetime);//
        qrImage=findViewById(R.id.qr_image);
        activity = this;

        db = new Db_frall(faltu_context.context);

        Cursor res = db.GetGenerateDetails();

        if (res.moveToLast()) {
            //Toast.makeText(faltu_context.context, "Work ", Toast.LENGTH_SHORT).show();
            amount.setText(amount.getText()+""+res.getString(4).toString());
          recievetime.setText(recievetime.getText()+res.getString(5).toString());
        } else {
            Toast.makeText(faltu_context.context, "Please try again login failed", Toast.LENGTH_SHORT).show();
        }
        /////next act
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                global_vars globalVariable = (global_vars) faltu_context.context;
                globalVariable.myGlobalArray.clear();
                Intent i=new Intent(ViewReceipt.this,MainActivity.class);
                startActivity(i);
            }
        });
        //////////qr code
        inputValue = String.valueOf(res.getInt(0)).toString().trim();
        if (inputValue.length() > 0) {
            WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = width < height ? width : height;
            smallerDimension = smallerDimension * 3 / 4;

            qrgEncoder = new QRGEncoder(
                    inputValue, null,
                    QRGContents.Type.TEXT,
                    smallerDimension);

            try {
                bitmap = qrgEncoder.encodeAsBitmap();
                qrImage.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
          //  edtValue.setError(getResources().getString(R.string.value_required));
        }
       /*Cursor res= db.GetGenerateDetails();
       res.moveToFirst();
       String a =res.getString(4);
       amount.setText(a);
        String b =res.getString(5);
        recievetime.setText(b);*/


    }

}
