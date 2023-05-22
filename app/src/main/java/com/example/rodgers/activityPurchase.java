package com.example.rodgers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class activityPurchase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase2);

        SmsReciever smsReciever= new SmsReciever();
        Context context= getApplicationContext();
        Intent intent= new Intent();
        smsReciever.onReceive(context, intent);
    }
}