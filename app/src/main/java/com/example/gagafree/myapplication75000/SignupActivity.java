package com.example.gagafree.myapplication75000;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by gagafree on 21/04/2018.
 */

public class SignupActivity extends Activity {


    EditText text1;
    EditText text2;

    EditText text3;

    TextView text4;

    Button btn;


    FirebaseDatabase base;

    DatabaseReference mDatabase;

    private String mydate;

    private String username;

    private String number;

    private String password;

    private Register register;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        register = new Register();

        mydate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        base = FirebaseDatabase.getInstance();

        mDatabase = base.getReference("register");


        text1 = (EditText) findViewById(R.id.e1);

        text2 = (EditText) findViewById(R.id.e2);

        text3 = (EditText) findViewById(R.id.e3);

        text4 = (TextView) findViewById(R.id.t1);

        btn = (Button) findViewById(R.id.b1);

        float stvfake =  (float) ((Math.random()* 100000) + 1);

        text4.setText(String.valueOf(stvfake));

        password = String.valueOf(stvfake);




        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override

                                   public void onClick(View view) {

                                       if (text3.getText().toString().equals("application")) {

                                           username = text1.getText().toString();

                                           number = text2.getText().toString();

                                           Register register = new Register(username,number,password, mydate);

                                           mDatabase.push().setValue(register);

                                           Toast.makeText(SignupActivity.this, "Successful signup", Toast.LENGTH_SHORT).show();


                                       } else {

                                           Toast.makeText(SignupActivity.this, "Please try again", Toast.LENGTH_SHORT).show();


                                       }
                                   }

                               }

        );
    }
}
