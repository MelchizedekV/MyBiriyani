package com.example.user.mybiriyani;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private EditText myEmail;
    private EditText myPassword;
    private static final int RC_SIGN_IN = 123;


    private FirebaseAuth myAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myAuth=FirebaseAuth.getInstance();


        if (myAuth.getCurrentUser() != null) {

            startActivity(new Intent(LoginActivity.this,Nampass.class));
            finish();

        } else {

            return ;
        }


        myEmail=(EditText)findViewById(R.id.login_email);
        myPassword=(EditText)findViewById( R.id.login_password);

    }

    public void login(View v)
    {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setIsSmartLockEnabled(false, true)

                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.PhoneBuilder().build(),
                                new AuthUI.IdpConfig.GoogleBuilder().build(),
                                new AuthUI.IdpConfig.FacebookBuilder().build()))
                        .build(),
                RC_SIGN_IN);
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                startActivity(new Intent(LoginActivity.this,Nampass.class));
                finish();
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button
                    Toast.makeText(this,"When user clicked back button",Toast.LENGTH_LONG).show();
                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this,"oops Network failure",Toast.LENGTH_LONG).show();

                    return;
                }

                Toast.makeText(this,"Unknown error",Toast.LENGTH_LONG).show();            }
        }
    }

    public void RegisterNewUser(View v)
    {
        Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(i);

    }
    public void SignInUser(View v){
        loginUserWithFirebase();
    }
    private void loginUserWithFirebase()
    {
        String email=myEmail.getText().toString();
        String password=myPassword.getText().toString();

        if (email.equals("") || password.equals(""))
        {
            ShowErrorbox(" Email or password Field is Empty");
            return;
        }

        Toast.makeText(this,"logging u in",Toast.LENGTH_SHORT).show();

        myAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.i("FINDCODEL","was user logged in :"+task.isSuccessful());

                if (!task.isSuccessful())
                {
                    ShowErrorbox(" there was a problem in logging in");
                    Log.i("FINDCODE","message:"+task.getException());

                }

                else {
                    Log.i("DEBUG","Reached");
                    Intent intent = new Intent(LoginActivity.this, Nampass.class);
                    finish();
                    startActivity(intent);
                    Log.i("DEBUG","Launched");
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

}
