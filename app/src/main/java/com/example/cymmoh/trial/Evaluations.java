package com.example.cymmoh.trial;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Evaluations extends Fragment {
    private Spinner spinner1;
Button ref;
    public Evaluations() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_evaluations, container, false);

        ref=(Button)v.findViewById(R.id.ref);
        ref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("android.intent.action.RESOURCES");
                startActivity(intent);
            }
        });

        spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    //do nothing
                }

                if (position == 1) {
                    Intent intent = new Intent("android.intent.action.CAT1");
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent("android.intent.action.CAT2");
                    startActivity(intent);
                }

                if (position == 3) {
                    Intent intent = new Intent("android.intent.action.TAKEAWAY");
                    startActivity(intent);

                }
                if (position == 4) {
                    Intent intent = new Intent("android.intent.action.EXAM");
                    startActivity(intent);

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        return v;
    }
}






