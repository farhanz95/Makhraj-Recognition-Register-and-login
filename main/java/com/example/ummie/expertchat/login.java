package com.example.ummie.expertchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by UmiIrwanMaryam on 12-Dec-17.
 */

public class login extends AppCompatActivity {


    private Toolbar aToolbar;
    private FirebaseAuth cAuth;
    private TextInputLayout email2,pass2;
    private Button login;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        aToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(aToolbar);


        cAuth = FirebaseAuth.getInstance();

        email2 = (TextInputLayout) findViewById(R.id.email2);
        pass2 = (TextInputLayout) findViewById(R.id.pass2);
        login = (Button) findViewById(R.id.login2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email2.getEditText().getText().toString();
                String pass = pass2.getEditText().getText().toString();

                login_user(email,pass);
            }
        });









    }

    private void login_user(String email, String pass) {
        cAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                else
                {
                    Toast.makeText(login.this, "wrong password" , Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


}
