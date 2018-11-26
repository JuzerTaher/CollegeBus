package com.example.juzer.collegebus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSend;
    EditText edtData;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend=(Button) findViewById(R.id.btnSend);
        edtData=(EditText) findViewById(R.id.editText);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReferenceFromUrl("https://collegebus-a30e5.firebaseio.com/");

        btnSend.setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSend:
                myRef.setValue(edtData.getText().toString());
                break;
        }
    }
}
