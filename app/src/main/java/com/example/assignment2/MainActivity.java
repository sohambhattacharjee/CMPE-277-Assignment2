package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button_visit, button_dial;
    EditText editText_url, editText_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_visit = findViewById(R.id.button);
        editText_url =  findViewById(R.id.editText);

        button_dial = findViewById(R.id.button1);
        editText_phone = findViewById(R.id.editText1);

        button_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editText_url.getText().toString();
                if(!url.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            }
        });

        button_dial.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String phone_number = editText_phone.getText().toString();
                if(!phone_number.isEmpty()){
                    Intent callIntent = new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:"+phone_number));
                    startActivity(callIntent);
                }
            }
        });


    }
}