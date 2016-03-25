package com.example.cymmoh.trial;

/**
 * Created by CYMMOH on 2/13/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CYMMOH on 9/1/2015.
 */
public class FridayDb extends SQLiteOpenHelper {
    public  static  final String DATABASE_NAME = "monday_db";
    public  static  final String TABLE_NAME = "monday_tbl";
    public  static  final String COL1="UNIT";
    public  static  final String COL2="TIME";
    public  static  final String COL3="VENUE";
    public  static  final String COL4="LECTURER";
    private static final int DATABASE_VERSION = 2;



    public FridayDb(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (UNIT TEXT PRIMARY KEY,TIME TEXT,VENUE TEXT,LECTURER TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);


    }


    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }


    public boolean insertData(String unit,String venue,String time,String lecturer) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,unit);
        contentValues.put(COL2,venue);
        contentValues.put(COL3,time);
        contentValues.put(COL4, lecturer);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }
//    public boolean updateData(String unit,String time,String venue,String lecturer ){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(COL1,unit);
//        contentValues.put(COL2,venue);
//        contentValues.put(COL3,time);
//        contentValues.put(COL4, lecturer);
//        db.update(TABLE_NAME, contentValues, "UNIT = ?", new String[]{unit});
//        return true;
//    }

    public Integer deleteData(String unit){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "UNIT = ?", new String[] {unit});
    }
}
