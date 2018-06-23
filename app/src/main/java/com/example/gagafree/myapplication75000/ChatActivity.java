package com.example.gagafree.myapplication75000;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ChatActivity extends AppCompatActivity {

    private Button btn;

    private EditText txt;

    private EditText txt1;

    FirebaseDatabase  base;

    private DatabaseReference mDatabase;

    private User1 user1;

    private User user;

    private ArrayList<String> arraylist ;

    private ArrayList<String> arraylist2 ;

    private ListView listView;

    private ListView listView2;

    private ArrayAdapter<String> adapter;

    private ArrayAdapter<String> adapter2;

    private TextView tt1;

    private TextView tt2;

    private String affich;

    private String affich2;

    private String mydate;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chat);

        user1 = new User1();

        user = new User();

        base = FirebaseDatabase.getInstance();

        mDatabase = base.getReference("users");

        mydate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        // listView = (ListView) findViewById(R.id.listview1);

        // listView2 = (ListView) findViewById(R.id.listview2);

        arraylist = new ArrayList<>();

        arraylist2 = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist2);

        // listView.setAdapter(adapter);

        // listView2.setAdapter(adapter2);








        txt = (EditText) findViewById(R.id.t1);

        // txt1 = (EditText) findViewById(R.id.textview1);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override

                                   public void onClick(View view) {

                                       User1 user1 = new User1(txt.getText().toString(), mydate);

                                       mDatabase.push().setValue(user1);

                                   }
                               }

        );



        mDatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                user1 = dataSnapshot.getValue(User1.class);

                arraylist.add(user1.getMessage());





                // arraylist2.add(user.getPrenom());


                adapter.notifyDataSetChanged();

               // adapter2.notifyDataSetChanged();

                int size = arraylist.size();

                // int size2 = arraylist2.size();

                for (int i =0; i<(size) ; i++) {

                    affich = affich + arraylist.get(i) + " ";


                }

                /* for (int j =0; j<size2 ; j++) {

                    affich2 = affich2 + arraylist2.get(j) + " ";


                }*/

                // tt1.setText(affich);

                // tt2.setText(affich2);




            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
