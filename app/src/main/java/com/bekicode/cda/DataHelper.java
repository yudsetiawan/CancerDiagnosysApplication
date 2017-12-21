package com.bekicode.cda;

/**
 * Created by Yudi Setiawan on 12/21/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "listrules.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table gejala(id integer primary key, nama text null);";
        Log.d("Data", "onCreate"+sql);
        db.execSQL(sql);
        sql = "INSERT INTO gejala(id, nama) VALUES ('1','Apakah Pendarahan Pada Vagina?');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){

    }
}
