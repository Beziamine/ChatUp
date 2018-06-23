package com.example.gagafree.myapplication75000;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;

public class MainActivity extends Activity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;


    EditText text1;
    EditText text2;

    Button btn;

    Button btn2;

    TextView text10;


    FirebaseDatabase base;

    FirebaseDatabase base2;

    DatabaseReference mDatabase;

    DatabaseReference mDatabase2;

    private String mydate;

    private String username;

    private String password;

    private String adress;

    private int size;

    private int k;

    private User user;

    private Register register;

    private ListView listView;

    private ArrayAdapter<Register> adapter;

    private ArrayList<Register> arraylist;

    private String phoneNo;

    private String message;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_gradbk);

        user = new User();

        register = new Register();

        mydate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        base = FirebaseDatabase.getInstance();

        base2 = FirebaseDatabase.getInstance();

        mDatabase = base.getReference("login");

        mDatabase2 = base2.getReference("register");

        arraylist = new ArrayList<>();

        adapter = new ArrayAdapter<Register>(this, android.R.layout.simple_list_item_1, arraylist);


        text1 = (EditText) findViewById(R.id.e1);

        text2 = (EditText) findViewById(R.id.e2);

        text10 = (TextView) findViewById(R.id.t2);

        btn = (Button) findViewById(R.id.b1);

        btn2 = (Button) findViewById(R.id.b2);


        mDatabase2.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                register = dataSnapshot.getValue(Register.class);

                arraylist.add(register);

                adapter.notifyDataSetChanged();

                size = arraylist.size();


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


        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override

                                   public void onClick(View view) {

                                       for (int i = 0; i < size; i++) {


                                           if (text1.getText().toString().equals(arraylist.get(i).getNom().toString())) {

                                               k = i;

                                               if (text2.getText().toString().equals(arraylist.get(k).getPassword().toString())) {

                                                   username = text1.getText().toString();

                                                   password = text2.getText().toString();

                                                   adress = String.valueOf(getNetworkInterfaceIpAddress());

                                                   User user = new User(username, adress, mydate);

                                                   mDatabase.push().setValue(user);

                                                   Toast.makeText(MainActivity.this, "Successful login", Toast.LENGTH_SHORT).show();

                                                   Intent j = new Intent(MainActivity.this, ChatActivity.class);

                                                   startActivity(j);

                                               } else {

                                                   Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                                               }


                                           } else {

                                               Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();


                                           }
                                       }

                                   }
                               }

        );


        btn2.setOnClickListener(new View.OnClickListener() {

                                    @Override

                                    public void onClick(View view) {


                                        Intent i = new Intent(MainActivity.this, SignupActivity.class);

                                        startActivity(i);


                                    }
                                }

        );


        text10.setOnClickListener(new View.OnClickListener() {

                                      @Override

                                      public void onClick(View view) {

                                          for (int i = 0; i < size; i++) {


                                              if (text1.getText().toString().equals(arraylist.get(i).getNom().toString())) {

                                                  k = i;

                                                  phoneNo = String.valueOf(arraylist.get(k).getNumber().toString());

                                                  message = String.valueOf("Your password is : " + arraylist.get(k).getPassword().toString());

                                                  sendSMSMessage();

                                                  Toast.makeText(MainActivity.this, "Your password was sent to your phone", Toast.LENGTH_SHORT).show();



                                              } else {

                                                  Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                                              }


                                          }


                                      }
                                  }

        );

    }


    private String getDeviceIpAddress() {
        String actualConnectedToNetwork = null;
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connManager != null) {
            NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWifi.isConnected()) {
                actualConnectedToNetwork = getWifiIp();
            }
        }
        if (TextUtils.isEmpty(actualConnectedToNetwork)) {
            actualConnectedToNetwork = getNetworkInterfaceIpAddress();
        }
        if (TextUtils.isEmpty(actualConnectedToNetwork)) {
            actualConnectedToNetwork = "127.0.0.1";
        }
        return actualConnectedToNetwork;
    }

    @Nullable
    private String getWifiIp() {
        final WifiManager mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (mWifiManager != null && mWifiManager.isWifiEnabled()) {
            int ip = mWifiManager.getConnectionInfo().getIpAddress();
            return (ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "."
                    + ((ip >> 24) & 0xFF);
        }
        return null;
    }


    @Nullable
    public String getNetworkInterfaceIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface networkInterface = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = networkInterface.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        String host = inetAddress.getHostAddress();
                        if (!TextUtils.isEmpty(host)) {
                            return host;
                        }
                    }
                }

            }
        } catch (Exception ex) {
            Log.e("IP Address", "getLocalIpAddress", ex);
        }
        return null;
    }


    protected void sendSMSMessage() {

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    // Toast.makeText(getApplicationContext(), "SMS sent.",
                    // Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }


    }
}
