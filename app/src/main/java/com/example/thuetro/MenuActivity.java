package com.example.thuetro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnBrowse, btnFav, btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
        exec();
    }

    public void init() {
        btnBrowse = (Button) findViewById(R.id.btnBrowse);
        btnFav = (Button) findViewById(R.id.btnFav);
        btnSignOut = (Button) findViewById(R.id.btnSignOut);
    }

    public void exec() {
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, BrowseActivity.class);
                startActivity(intent);
            }
        });
    }
}