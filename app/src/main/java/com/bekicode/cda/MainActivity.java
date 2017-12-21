package com.bekicode.cda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dbHelper;
    TextView coba;

    boolean g1, g2, g3, g4;
    int k1, k2, k3, k4, k5, k6, k7, k8, k9, cf;
    String kesimpulan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DataHelper(this);
        coba = (TextView)findViewById(R.id.textSoal2);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT nama FROM gejala",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            coba.setText(cursor.getString(0).toString());
        }
    }

    public void klikHasilRadio(View v){

        RadioGroup btnGroup = (RadioGroup) findViewById(R.id.btnGroup);
        RadioGroup btnGroup2 = (RadioGroup) findViewById(R.id.btnGroup2);
        RadioGroup btnGroup3 = (RadioGroup) findViewById(R.id.btnGroup3);
        RadioGroup btnGroup4 = (RadioGroup) findViewById(R.id.btnGroup4);

        int id = btnGroup.getCheckedRadioButtonId();
        int id2 = btnGroup2.getCheckedRadioButtonId();
        int id3 = btnGroup3.getCheckedRadioButtonId();
        int id4 = btnGroup3.getCheckedRadioButtonId();

        //rules1
        if (id == R.id.rdbtnYes){
            g1 = true;
        }else if (id == R.id.rdbtnNo){
            g1 = false;
        }

        if (g1 == true){
            k1 = 10;
        }

        //rules2
        if (id2 == R.id.rdbtnYes2){
            g2 = true;
        }else if (id2 == R.id.rdbtnNo2){
            g2 = false;
        }

        if (g2 == true){
            k1 = 10;
        }

        //rules3
        if (id3 == R.id.rdbtnYes3){
            g3 = true;
        }else if (id2 == R.id.rdbtnNo3){
            g3 = false;
        }

        if (g3 == true){
            k1 = 10;
        }

        //rules4
        if (id4 == R.id.rdbtnYes4){
            g4 = true;
        }else if (id2 == R.id.rdbtnNo4){
            g4 = false;
        }

        if (g4 == true){
            k4 = 10;
            k8 = 10;
            k9 = 10;
        }

        cf = k1 + k2 + k3 + k4;
        if (cf > 10){
            kesimpulan = "kena kangker";
        } else {
            kesimpulan = "ga kena kangker";
        }

        Bundle bundle = new Bundle();
        bundle.putString("kangker", kesimpulan);
        Intent intent = new Intent(MainActivity.this, HasilActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
