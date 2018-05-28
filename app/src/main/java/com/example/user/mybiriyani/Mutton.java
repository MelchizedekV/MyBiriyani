package com.example.user.mybiriyani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Mutton extends zchkn {

    public static String  mon="NOT PURCHASED";
    public static String  mhal="NOT PURCHASED";
    public  static int c=0;
    public  static int d=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutton);

        ImageView one=(ImageView)findViewById(R.id.onekg);
        Button or=(Button)findViewById(R.id.order);
        Button or2=(Button)findViewById(R.id.order2);
        ImageButton car=(ImageButton)findViewById(R.id.cart);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(Mutton.this,zCart.class);
                startActivity(in);
            }
        });


        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mon=" PURCHASED"+" "+ ++c +" "+"times ";
                rate=rate+180;
                ToastMsg("Mutton biriyani 1kg Purchased");

            }
        });

        or2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mhal=" PURCHASED"+" "+ ++d +" "+"times ";
                rate=rate+100;
                ToastMsg("Mutton biriyani half kg Purchased");
            }
        });
    }
    }

