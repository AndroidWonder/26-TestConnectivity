package com.course.example.testconnectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String TAG = "Connect";

        ConnectivityManager cm = (ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        int connectionType = -1;

        if (isConnected) {
            connectionType = activeNetwork.getType();
            if (connectionType == ConnectivityManager.TYPE_WIFI) {
                Log.e(TAG, "Mobile connected: to Wi-Fi");
            } else if (connectionType == ConnectivityManager.TYPE_MOBILE) {
                Log.e(TAG, "Mobile connected: to Cellular Network");
            }
        } else {
            Log.e(TAG, "Mobile connected: No active network connection");


        }
    }
}