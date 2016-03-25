package com.example.cymmoh.trial;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lecture extends Fragment {

    private String[] states;
    private Spinner spinner;
    Button button_res;
    Button button_qn,my_units;

    public Lecture() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lecture, container, false);
//button


        states = getResources().getStringArray(R.array.countries_list);

        spinner = (Spinner) v.findViewById(R.id.country_spinner);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(dataAdapter);
        spinner.setSelection(0, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, states);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                switch (position) {
                    case 0:
                        //do nothing
                        break;
                    case 1:
                        Intent intent1 = new Intent("com.example.cymmoh.trial.Monday");
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent("com.example.cymmoh.trial.Tuesday");
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent("com.example.cymmoh.trial.Wednesday");
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent("com.example.cymmoh.trial.Thursday");
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new Intent("com.example.cymmoh.trial.Friday");
                        startActivity(intent5);
                        break;

                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


button_res=(Button)v.findViewById(R.id.button_res);
        button_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("android.intent.action.RESOURCES");
                startActivity(intent);
            }
        });
        button_qn=(Button)v.findViewById(R.id.button_qn);
        button_qn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent("android.intent.action.QAFORUM");
                startActivity(i);
            }
        });

        my_units=(Button)v.findViewById(R.id.my_units);
        my_units.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cymoh =new Intent("android.intent.action.MYUNITS");
                startActivity(cymoh);
            }
        });


        return v;

    }




}





