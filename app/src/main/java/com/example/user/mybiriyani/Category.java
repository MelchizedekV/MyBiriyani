package com.example.user.mybiriyani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Category extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageButton c=(ImageButton)findViewById(R.id.chicken);
        ImageButton m=(ImageButton)findViewById(R.id.Mutton);
        ImageButton p=(ImageButton)findViewById(R.id.prawn);

c.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent in=new Intent(Category.this,zchkn.class);
        startActivity(in);
    }
});

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Category.this,Mutton.class);
                startActivity(in);
            }
        });

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(Category.this,Prawn.class);
                startActivity(in);
            }
        });
    }

    }

