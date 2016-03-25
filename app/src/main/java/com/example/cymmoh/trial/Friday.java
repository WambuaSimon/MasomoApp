package com.example.cymmoh.trial;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Friday extends AppCompatActivity {

    FridayDb myDb;
    EditText editText_unit, editText_time, editText_venue, editText_lecturer;
    Button button_add, button_delete, button_view, button_update;
    String et_unit, et_time, et_venue, et_lecturer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        myDb = new FridayDb(this);
        editText_unit = (EditText) findViewById(R.id.editText_unit);
        editText_time = (EditText) findViewById(R.id.editText_time);
        editText_venue = (EditText) findViewById(R.id.editText_venue);
        editText_lecturer = (EditText) findViewById(R.id.editText_lecturer);
        button_add = (Button) findViewById(R.id.button_add);
        button_view = (Button) findViewById(R.id.button_view);
        button_update = (Button) findViewById(R.id.button_update);
        button_delete = (Button) findViewById(R.id.button_delete);
        addData();
        viewAll();
        DeleteData();
    }

    public void addData() {
        button_add.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              boolean isInserted = myDb.insertData(editText_unit.getText().toString(), editText_time.getText().toString(),
                                                      editText_venue.getText().toString(), editText_lecturer.getText().toString());
                                              if (isInserted = true) {
                                                  Toast.makeText(Friday.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                                              } else {
                                                  Toast.makeText(Friday.this, "Data not inserted", Toast.LENGTH_SHORT).show();

                                              }
                                              if (editText_unit.equals("") || editText_time.equals("") || editText_venue.equals("") || editText_lecturer.equals("")) {

                                                  Toast.makeText(Friday.this, "Enter your schedule", Toast.LENGTH_LONG).show();
                                              }
                                              /*if( editText_unit.getText().toString().length() == 0 )
                                                  editText_unit.setError( "unit name is required!" );

                                              if( editText_time.getText().toString().length() == 0 )
                                                  editText_time.setError( "First name is required!" );

                                              if( editText_lecturer.getText().toString().length() == 0 )
                                                  editText_lecturer.setError( "First name is required!" );

                                              if( editText_venue.getText().toString().length() == 0 )
                                                  editText_venue.setError( "First name is required!" );
*/

                                              editText_unit.setText("");
                                              editText_time.setText("");
                                              editText_lecturer.setText("");
                                              editText_venue.setText("");


                                          }
                                      }
        );

    }

    public void viewAll() {
        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error!", "Nothing was found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Unit :" + res.getString(0) + "\n");
                    buffer.append("Time :" + res.getString(1) + "\n");
                    buffer.append("Venue :" + res.getString(2) + "\n");
                    buffer.append("Lecturer :" + res.getString(3) + "\n\n");
                }
                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    //    public void updateData(){
//        button_update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isUpdate = myDb.updateData(editText_unit.getText().toString(), editText_time.getText().toString(),
//                        editText_venue.getText().toString(), editText_lecturer.getText().toString());
//                if (isUpdate == true)
//                    Toast.makeText(Monday.this, "Data Updated", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(Monday.this, "Data not updated", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
    public void DeleteData() {
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editText_unit.getText().toString());
                if (deletedRows > 0)
                    Toast.makeText(Friday.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Friday.this, "Data not Deleted", Toast.LENGTH_SHORT).show();

                editText_unit.setText("");
                editText_time.setText("");
                editText_lecturer.setText("");
                editText_venue.setText("");


            }
        });


        editText_unit.setText("");
        editText_time.setText("");
        editText_lecturer.setText("");
        editText_venue.setText("");

    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        et_unit = editText_unit.getText().toString();
        et_time = editText_time.getText().toString();
        et_venue = editText_venue.getText().toString();
        et_lecturer = editText_lecturer.getText().toString();

        outState.putString("edittext1", et_unit);
        outState.putString("edittext2", et_time);
        outState.putString("edittext3", et_venue);
        outState.putString("edittext4", et_lecturer);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("edittext1");
        editText_unit.setText(savedInstanceState.getString("edittext1"));
        editText_time.setText(savedInstanceState.getString("edittext2"));
        editText_venue.setText(savedInstanceState.getString("edittext3"));
        editText_lecturer.setText(savedInstanceState.getString("edittext4"));

    }
}


