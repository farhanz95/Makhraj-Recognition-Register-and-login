package com.example.ummie.expertchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements menu {

    private Toolbar aToolbar;
    private FirebaseAuth cAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(aToolbar);
        getSupportActionBar().setTitle("Expert Chat");

        cAuth = FirebaseAuth.getInstance();


    }


    @Override
    public void onStart()
    {
        super.onStart();

        FirebaseUser current = cAuth.getCurrentUser();

        if(current == null)
        {
            activityStart();

        }
    }

    private void activityStart() {

        Intent intent = new Intent(MainActivity.this, info.class);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);


        if(item.getItemId() == R.id.logout)
        {
            activityStart();
        }

        return true;
    }
}
