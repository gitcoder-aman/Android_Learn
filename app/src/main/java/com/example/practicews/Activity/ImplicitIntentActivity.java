package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practicews.R;

public class ImplicitIntentActivity extends AppCompatActivity {

    Button callIntentBtn,messageIntentBtn,emailIntentBtn,shareIntentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        callIntentBtn = findViewById(R.id.callIntent);
        emailIntentBtn = findViewById(R.id.emailIntent);
        messageIntentBtn = findViewById(R.id.messageIntent);
        shareIntentBtn = findViewById(R.id.shareIntent);

        callIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
//                iDial.setAction(Intent.ACTION_DIAL); //or
                iDial.setData(Uri.parse("tel: +918294888127"));
                startActivity(iDial);
            }
        });
        messageIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iMessage = new Intent();
                iMessage.setAction(Intent.ACTION_SENDTO);
                iMessage.setData(Uri.parse("smsto:"+ Uri.encode("+918294888127")));
                iMessage.putExtra("sms_body","Hi everyone , I am here!");
                startActivity(iMessage);
            }
        });
        emailIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iEmail = new Intent();
                iEmail.setAction(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL,new String[] {"amankumar93578@gmail.com","aman.nittc@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT,"Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT,"Please resolve this issue");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });
        shareIntentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Download the Amazing App,https://play.google.com/store/apps/details?id=com.tech.coderamankumarguptaquizearn");
                startActivity(Intent.createChooser(iShare,"Share via"));
            }
        });

    }

}