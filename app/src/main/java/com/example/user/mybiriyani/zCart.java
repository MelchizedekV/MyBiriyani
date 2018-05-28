package com.example.user.mybiriyani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class zCart extends Prawn {

    private String myUserName;
    private String Adr;
Firebase firebase;
    EditText cf;
    EditText ch;
    EditText mf;
    EditText mh;
    EditText pf;
    EditText ph;
    EditText na;
    EditText ad;
    EditText tot;

    Button po;
    Button category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zcart);
        po=(Button)findViewById(R.id.or);
        category=(Button)findViewById(R.id.category);
        //edit text
  cf=(EditText)findViewById(R.id.c1);
  cf.setText(String.valueOf(con));
        ch=(EditText)findViewById(R.id.c12);

        mf=(EditText)findViewById(R.id.m1);
        mh=(EditText)findViewById(R.id.m12);
        pf=(EditText)findViewById(R.id.p1);
        ph=(EditText)findViewById(R.id.p12);
        na=(EditText)findViewById(R.id.nam);
        ad=(EditText)findViewById(R.id.addr);
        tot=(EditText)findViewById(R.id.tr);

        ch.setText(String.valueOf(chal));
        mf.setText(String.valueOf(mon));
        mh.setText(String.valueOf(mhal));
        pf.setText(String.valueOf(pon));
        ph.setText(String.valueOf(phal));

        tot.setText(String.valueOf(rate));

        //display name

        SharedPreferences prefs = getSharedPreferences(RegisterActivity.FILE, MODE_PRIVATE);
        myUserName = prefs.getString(RegisterActivity.DISPLAY_NAME, null);
        Adr= prefs.getString(RegisterActivity.ADD_NAME, null);

na.setText(String.valueOf(myUserName));
        ad.setText(String.valueOf(Adr));

        //firebase

        String DeviceId= Settings.Secure.getString(getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID);
        firebase.setAndroidContext(this);
        firebase=new Firebase("https://mybiriyani-39064.firebaseio.com/ID-"+DeviceId);

        final String name=na.getText().toString();

        final String address=ad.getText().toString();
        final String cknf=cf.getText().toString();
        final String cknh=ch.getText().toString();
        final String mknf=mf.getText().toString();
        final String mknh=mh.getText().toString();
        final String pknf=pf.getText().toString();
        final String pknh=ph.getText().toString();
        final String Rate=tot.getText().toString();

//buttons

        po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





//adding to firebase

               Firebase myNewChild=firebase.child("AAName");
                myNewChild.setValue(name);

               // Firebase ccc=  myNewChild.child("Hey");
              //  ccc.setValue("hello");
                Firebase ChildName=firebase.child("Address");
                ChildName.setValue(address);
                Firebase kf=firebase.child("Chicken full");
                kf.setValue(cknf);
                Firebase kh=firebase.child("Chicken Half");
                kh.setValue(cknh);
                Firebase af=firebase.child("Mutton Full");
                af.setValue(mknf);
                Firebase ah=firebase.child("Mutton Half");
                ah.setValue(mknh);
                Firebase ef=firebase.child("Prawn full");
                ef.setValue(pknf);
                Firebase es=firebase.child("Prawn half");
                es.setValue(pknh);
                Firebase pannam=firebase.child("Total Amount");
                pannam.setValue(Rate);
                ToastMsg("order placed successfully");
                Intent i=new Intent(zCart.this,Category.class);
                startActivity(i);
                a=0;
                b=0;
                c=0;
                d=0;
                e=0;
                f=0;
                rate=0;
                con="NOT PURCHASED";
                chal="NOT PURCHASED";
                mon="NOT PURCHASED";
                mhal="NOT PURCHASED";
                pon="NOT PURCHASED";
                phal="NOT PURCHASED";


            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i=new Intent(zCart.this,Category.class);
                startActivity(i);
                a=0;
                b=0;
                c=0;
                d=0;
                e=0;
                f=0;
                rate=0;
                con="NOT PURCHASED";
                chal="NOT PURCHASED";
                mon="NOT PURCHASED";
                mhal="NOT PURCHASED";
                pon="NOT PURCHASED";
                phal="NOT PURCHASED";


            }
        });


    }

    public void logout(View v)
    {
        if (v.getId() == R.id.sgout) {
            AuthUI.getInstance()
                    .signOut(this)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {

                            a=0;
                            b=0;
                            c=0;
                            d=0;
                            e=0;
                            f=0;
                            rate=0;
                            con="NOT PURCHASED";
                            chal="NOT PURCHASED";
                            mon="NOT PURCHASED";
                            mhal="NOT PURCHASED";
                            pon="NOT PURCHASED";
                            phal="NOT PURCHASED";
                            myUserName="Enter the name";
                            Adr="Enter the address";



                            // user is now signed out
                            Intent i=new Intent(zCart.this,LoginActivity.class);
                            startActivity(i);
                        }
                    });
        }

    }

    public void ToastMsg(String toastMessage)

    {
        Toast.makeText(this,toastMessage,Toast.LENGTH_LONG).show();
    }


}

