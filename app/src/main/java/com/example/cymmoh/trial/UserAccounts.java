package com.example.cymmoh.trial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class UserAccounts extends AppCompatActivity {

    Button button_student,button_lecturer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_accounts);

        //typecasting
        button_lecturer=(Button)findViewById(R.id.button_lecturer);
        button_student=(Button)findViewById(R.id.button_student);

        button_lecturer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent("android.intent.action.LECTURERACCOUNT");
                startActivity(i);

            }
        });

        button_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserAccounts.this,StudentAccountt.class);
                startActivity(intent);

            }
        });
    }


   }
