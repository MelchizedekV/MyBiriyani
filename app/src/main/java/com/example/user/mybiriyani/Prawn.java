package com.example.user.mybiriyani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Prawn extends Mutton {
    public static String  pon="NOT PURCHASED";
    public static String  phal="NOT PURCHASED";
    public  static int e=0;
    public  static int f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prawn);

        ImageView one=(ImageView)findViewById(R.id.onekg);
        Button or=(Button)findViewById(R.id.order);
        Button or2=(Button)findViewById(R.id.order2);
        ImageButton car=(ImageButton)findViewById(R.id.cart);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(Prawn.this,zCart.class);
                startActivity(in);
            }
        });


        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pon=" PURCHASED"+" "+ ++e +" "+"times ";
                rate=rate+150;
                ToastMsg("prawn biriyani 1kg Purchased");

            }
        });

        or2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                phal=" PURCHASED"+" "+ ++f +" "+"times ";
                rate=rate+80;
                ToastMsg("prawn biriyani half kg Purchased");
            }
        });
    }

    }

