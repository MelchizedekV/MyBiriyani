package com.example.user.mybiriyani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class zchkn extends AppCompatActivity {

    public  static int rate=0;
    public  static int a=0;
    public  static int b=0;
public static String  con="NOT PURCHASED";
    public static String  chal="NOT PURCHASED";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zchkn);

            ImageView one=(ImageView)findViewById(R.id.onekg);
            Button or=(Button)findViewById(R.id.order);
            Button or2=(Button)findViewById(R.id.order2);
            ImageButton car=(ImageButton)findViewById(R.id.cart);

        car.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent in=new Intent(zchkn.this,zCart.class);
                    startActivity(in);
                }
            });


        or.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View view) {
                con=" PURCHASED"+" " + ++a +" " +"times";
                rate=rate+120;

                ToastMsg("chicken biriyani 1kg Purchased");


                }


        });
        or2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                chal=" PURCHASED"+" "+ ++b +" "+"times";
                rate=rate+70;

                ToastMsg("chicken biriyani half kg Purchased");

            }
        });
    }

    public void ToastMsg(String toastMessage)

    {
        Toast.makeText(this,toastMessage,Toast.LENGTH_LONG).show();
    }
}

