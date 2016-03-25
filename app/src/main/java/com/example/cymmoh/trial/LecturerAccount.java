package com.example.cymmoh.trial;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LecturerAccount extends AppCompatActivity {
    Button btnlogin, btnsignup;
    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturer_account);


        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btnsignup);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.intent.action.LECTURERREG");
                startActivity(i);
                finish();
            }
        });


        // Set On ClickListener
        btnlogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent("android.intent.action.LECTURER");
                startActivity(i);
                finish();
            }
        });

    }
}