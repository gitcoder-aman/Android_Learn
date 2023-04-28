package com.example.practicews.SqLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//database is a not case sensitive

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "signup.db";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Create table contacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name text, phone text)
//        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CONTACT+
//                "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_NAME + " TEXT,"+ KEY_PHONE_NO +" TEXT" + ")");

        String q = "create table users (_id integer primary key autoincrement, name text, username text, password text)";
        sqLiteDatabase.execSQL(q);

//        SQLiteDatabase database = this.getWritableDatabase();
//        database.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }

    //insert data
    public boolean insert_data(String name, String userName, String password) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("userName", userName);
        values.put("password", password);

        long r = database.insert("users", null, values);
        if (r == -1) {
            return false;
        } else {
            return true;
        }

    }
    //delete data
    public boolean delete_data(String username) {

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("select * from users where username=?", new String[]{username});

        if(cursor.getCount() > 0){
            long r = database.delete("users","username=?", new String[]{username});
            if(r == -1){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
    //update data
    public boolean update_data(String name,String username,String password) {

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("password", password);

        Cursor cursor = database.rawQuery("select * from users where username=?", new String[]{username});
        if(cursor.getCount() > 0){
            long r = database.update("users", values,"username=?", new String[]{username});
            if(r == -1){
                return false;
            }else return true;

        }else return false;
    }

    //show the data from database
    public Cursor getInfo() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from users ", null);
        return cursor;
    }

}