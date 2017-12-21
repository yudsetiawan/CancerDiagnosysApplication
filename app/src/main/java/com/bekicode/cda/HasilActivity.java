package com.bekicode.cda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HasilActivity extends AppCompatActivity {

    Button kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        TextView texthasil = (TextView) findViewById(R.id.textHasil);

        Bundle bundle = getIntent().getExtras();
        texthasil.setText(bundle.getString("kangker"));

        kembali = (Button)findViewById(R.id.kembali);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(HasilActivity.this, LoginActivity.class);
                startActivity(back);
            }
        });
    }
}
