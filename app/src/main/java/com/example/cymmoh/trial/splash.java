package com.example.cymmoh.trial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by CYMMOH on 9/27/2015.
 */

public class splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread() {

            public void run() {

                try {

                    sleep(2000);
                }catch (InterruptedException e){

                    e.printStackTrace();

                }finally{

                    Intent i=new Intent("android.intent.action.USERACCOUNTS");
                    startActivity(i);
                    finish();
                }


            }


        };
        timer.start();

    }

}