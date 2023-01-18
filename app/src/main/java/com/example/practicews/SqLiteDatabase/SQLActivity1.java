package com.example.practicews.SqLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.practicews.R;

import java.util.ArrayList;

public class SQLActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlactivity1);

        MyDBHelper1 myDBHelper1 = new MyDBHelper1(this);

//        myDBHelper1.addContact("Aman", "34824924284");
//        myDBHelper1.addContact("Rohit", "44189414833");
//        myDBHelper1.addContact("Sanju", "29419483943");
//        myDBHelper1.addContact("Rohan", "12823948391");
//        myDBHelper1.addContact("Suhani", "418448983922");
//        myDBHelper1.addContact("Amrita", "141849812419");

        ArrayList<ContactsModel>arrayList = myDBHelper1.fetchContacts();

        for(int i = 0; i < arrayList.size(); i++){
            Log.d("list", "Id : "+arrayList.get(i).id + " Name : "+arrayList.get(i).name + " Phone : "+ arrayList.get(i).phone_no);
        }

        //update  a particular contact by id
      /*  ContactModel model = new ContactModel();
        model.id = 1;
        model.phone_no = "123456789";

        myDBHelper1.updateContact(model);*/

        //delete a particular contact by id

        myDBHelper1.deleteContact(2);

        for(int i = 0; i < arrayList.size(); i++){
            Log.d("list", "Id : "+arrayList.get(i).id + " Name : "+arrayList.get(i).name + " Phone : "+ arrayList.get(i).phone_no);
        }

    }
}