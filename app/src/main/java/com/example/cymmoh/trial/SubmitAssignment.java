package com.example.cymmoh.trial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SubmitAssignment extends AppCompatActivity {
private static final int PICKFILE_RESULT_CODE=1;
    Button send;
    ImageView imagefile;
    TextView file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_assignment);

        send=(Button)findViewById(R.id.send);
        imagefile=(ImageView)findViewById(R.id.imagefile);
        file=(TextView)findViewById(R.id.file);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send data over the network to the lecturer
            }
        });


    }
public void imagefile(View v){
    imagefile=(ImageView)findViewById(R.id.imagefile);
    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    intent.setType("file/*");
    startActivityForResult(intent,PICKFILE_RESULT_CODE);

}
}