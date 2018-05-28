package com.example.user.mybiriyani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class Nampass extends AppCompatActivity {

    private AutoCompleteTextView myUserNameView;
    private AutoCompleteTextView myAddr;
    public static final String FILE="file";
    public static final String DISPLAY_NAME="userName";
    public static final String ADD_NAME="addName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nampass);

        myUserNameView=(AutoCompleteTextView)findViewById(R.id.Register_username);
        myAddr=(AutoCompleteTextView)findViewById(R.id.Address);


    }

    public void Next(View view)
    {
        SavedUserName();
        startActivity(new Intent(Nampass.this,Category.class));
        finish();
    }
    private void SavedUserName()
    {
        String userName=myUserNameView.getText().toString();
        String aname=myAddr.getText().toString();
        SharedPreferences sharedPreferences=getSharedPreferences(FILE,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(DISPLAY_NAME,userName);
        editor.putString(ADD_NAME,aname);
        editor.apply();
    }



    public void ToastMsg(String toastMessage)

    {
        Toast.makeText(this,toastMessage,Toast.LENGTH_LONG).show();
    }


}
