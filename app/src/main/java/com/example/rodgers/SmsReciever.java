package com.example.rodgers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class SmsReciever extends BroadcastReceiver {
    public void onRecieve(Context context, Intent intent){

    }
    private void dialCode(@NonNull Context context, String code){
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:"+code));
        context.startActivity((dialIntent));
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle =intent.getExtras();
        if(bundle!=null){
            Object[]pdus =(Object[]) bundle.get("pdus");
            if(pdus!= null && pdus.length>0){
                for(Object pdu: pdus){
                    SmsMessage smsMessage =SmsMessage.createFromPdu((byte[]) pdu);
                    String senderNumber= smsMessage.getDisplayOriginatingAddress();
                    String messageBody= smsMessage.getDisplayMessageBody();
                    //code to handle the sender
                    Toast.makeText(context, "New Message "+messageBody,Toast.LENGTH_SHORT).show();
                    //if(senderNumber.equals("0729064995")){
                        //dial the code here
                      //  dialCode(context,"0790585997");
                    }
                }
            }
        }
    }


