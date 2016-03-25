package com.example.cymmoh.trial;


import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Assignments extends android.support.v4.app.Fragment {
    Button details, button_submit;

    public Assignments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_assignments, container, false);

        details = (Button) v.findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ASSIGNMENTDETAILS");
                startActivity(intent);
            }
        });
        button_submit = (Button) v.findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("android.intent.action.SUBMITASSIGNMENT");
                startActivity(i);
            }
        });
        return v;
    }

}
