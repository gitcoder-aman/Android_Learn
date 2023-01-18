package com.example.practicews.SqLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDBHelper1 extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NO = "phone_no";

    public MyDBHelper1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String q = "create table "+ TABLE_CONTACTS + "(" +KEY_ID + " integer primary key autoincrement,"+KEY_NAME+ " text," + KEY_PHONE_NO + " text" + ")";
        sqLiteDatabase.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_CONTACTS);
        onCreate(sqLiteDatabase);
    }

    public void addContact(String name, String phone_no){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE_NO,phone_no);

        database.insert(TABLE_CONTACTS,null,values);
    }

    public ArrayList<ContactsModel>fetchContacts(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from "+TABLE_CONTACTS,null);

        ArrayList<ContactsModel>arrContacts = new ArrayList<>();

        while (cursor.moveToNext()){
            ContactsModel contactModel = new ContactsModel();
            contactModel.id = cursor.getInt(0);   //column index
            contactModel.name = cursor.getString(1);
            contactModel.phone_no = cursor.getString(2);

            arrContacts.add(contactModel);
        }
        return arrContacts;
    }
    public void updateContact(ContactsModel contactModel ){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PHONE_NO, contactModel.phone_no);
        database.update(TABLE_CONTACTS,values,KEY_ID+" = "+contactModel.id,null);
    }

    public void deleteContact(int id){
        SQLiteDatabase database = this.getWritableDatabase();

        database.delete(TABLE_CONTACTS,KEY_ID + " = ? ",new String[]{String.valueOf(id)} );
    }
}
