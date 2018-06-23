package com.example.gagafree.myapplication75000;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OnlineActivity extends AppCompatActivity {



    FirebaseDatabase  base;

    private DatabaseReference mDatabase;

    private User user;

    private LocationData locationdata;

    private Warning warning;

    private ArrayList<String> arraylist ;

    private ArrayList<String> arraylist2 ;

    private ListView listView;

    private ListView listView2;

    private ArrayAdapter<String> adapter;

    private ArrayAdapter<String> adapter2;

    private String affich;

    private String affich2;

    private TextView text2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cinquente);

        user = new User();

        locationdata = new LocationData();

        warning = new Warning();

        base = FirebaseDatabase.getInstance();

        mDatabase = base.getReference("login");

        listView = (ListView) findViewById(R.id.listview1);

        text2 =(TextView) findViewById(R.id.t1);

        // listView2 = (ListView) findViewById(R.id.listview2);

        arraylist = new ArrayList<>();

        arraylist2 = new ArrayList<>();


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arraylist);

        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arraylist2);

        listView.setAdapter(adapter2);

        // listView2.setAdapter(adapter2);














        mDatabase.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                user = dataSnapshot.getValue(User.class);

                arraylist.add(String.valueOf("Date : "+user.getMydate()+'\n'+
                        "Username : "+user.getNom()) + '\n'+
                        "IP Adress : "+user.getPrenom());

                adapter.notifyDataSetChanged();

                int size = arraylist.size();




                arraylist2.add(arraylist.get(size-1));








                adapter2.notifyDataSetChanged();

                int size2 = arraylist2.size();

                text2.setText("You actually have "+String.valueOf(size2)+ " online contacts");










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
