package com.example.user.mybiriyani;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    public static final String FILE="file";
    public static final String DISPLAY_NAME="userName";
    public static final String ADD_NAME="addName";

    private AutoCompleteTextView myUserNameView;
    private AutoCompleteTextView myAddr;
    private EditText myEmail;
    private EditText myPassword;
    private EditText myPasswordconfirm;

    private FirebaseAuth myAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myAuth=FirebaseAuth.getInstance();

        myUserNameView=(AutoCompleteTextView)findViewById(R.id.Register_username);
        myAddr=(AutoCompleteTextView)findViewById(R.id.Address);
        myEmail=(EditText) findViewById(R.id.Register_email);
        myPassword=(EditText) findViewById(R.id.Register_password);
        myPasswordconfirm=(EditText) findViewById(R.id.Register_confirm_password);
    }  // end of oncreate



//Actual registration


    private void registerUser()
    {
        myEmail.setError(null);
        myPassword.setError(null);

        String email=myEmail.getText().toString();
        String password=myPassword.getText().toString();

        // declaring variable

        boolean cancel=false;
        View focusView=null;

        //pass validation


        if(!TextUtils.isEmpty(password)&& !CheckPassword(password))
        {
            myPassword.setError(getString(R.string.invalid_password));
            focusView=myPassword;
            cancel=true;
        }

        if(TextUtils.isEmpty(email)&& !checkEmail(email))
        {
            myEmail.setError(getString(R.string.invalid_email));
            focusView=myEmail;
            cancel=true;
        }

        if (cancel)
        {
            focusView.requestFocus();
        }
        else
        {
            CreateUser();
        }
    }

// method to signUp

    public void signUp(View view)
    {
        registerUser();
    }

    //validation for email

    private boolean checkEmail(String email)

    {
        return email.contains("@");
    }

    // validation for password
    private boolean CheckPassword(String password)
    {
        String confirmPass=myPasswordconfirm.getText().toString();

        return confirmPass.equals(password) && password.length()>4;
    }


    private void CreateUser()
    {
        String Email=myEmail.getText().toString();
        String Password=myPassword.getText().toString();

        myAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //delete this command
                Log.i("FINDCODE","user creation was"+ task.isSuccessful());

                if(!task.isSuccessful())
                {
                    ShowErrorbox("oopssss Registration failed");

                }
                else
                {
                    SavedUserName();
                    ToastMsg("Registration was successfull");
                    Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                    finish();
                    startActivity(i);

                }

            }
        });
    }


    private void ShowErrorbox(String message)
    {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void SavedUserName()
    {
        String userName=myUserNameView.getText().toString();
        String aname=myAddr.getText().toString();
        SharedPreferences sharedPreferences=getSharedPreferences(FILE,0);
        //sharedPreferences.edit().putString(DISPLAY_NAME,userName).apply();
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
