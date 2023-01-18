package com.example.practicews.sendReceiveMessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        Object[] smsObj = (Object[]) bundle.get("pdus");  //pdus fixed string for receive message

        for (Object obj : smsObj) {
            SmsMessage message = SmsMessage.createFromPdu((byte []) obj);

            String mobNo = message.getDisplayOriginatingAddress();
            String msg = message.getDisplayMessageBody();

            Log.d("msgDetail","Mob no: "+mobNo + " ,Msg: "+msg);

            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage("+918989898989",null,"Hello Developer",null,null);

        }

    }
}
