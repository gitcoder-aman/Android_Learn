package com.example.practicews.SqLiteDatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.practicews.R;

import java.util.Objects;

public class SqliteDatabaseActivity extends AppCompatActivity {

    private AppCompatButton insertBtn;
    private AppCompatButton updateBtn;
    private AppCompatButton deleteBtn;
    private AppCompatButton viewBtn;

    private AppCompatEditText nameET;
    private AppCompatEditText userNameET;
    private AppCompatEditText passET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database);

        insertBtn = findViewById(R.id.insertBtn);
        updateBtn = findViewById(R.id.updateBtn);
        deleteBtn = findViewById(R.id.deleteBtn);
        viewBtn = findViewById(R.id.viewBtn);

        nameET = findViewById(R.id.nameET);
        userNameET = findViewById(R.id.userNameET);
        passET = findViewById(R.id.passET);

        MyDBHelper myDBHelper = new MyDBHelper(this);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Objects.requireNonNull(nameET.getText()).toString();
                String userName = Objects.requireNonNull(userNameET.getText()).toString();
                String pass = Objects.requireNonNull(passET.getText()).toString();

                if(name.equals("") || userName.equals("") || pass.equals("")){
                    Toast.makeText(SqliteDatabaseActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    boolean insert_data = myDBHelper.insert_data(name,userName,pass);

                    if(insert_data){
                        Toast.makeText(SqliteDatabaseActivity.this, "Data Successful inserted", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SqliteDatabaseActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur  = myDBHelper.getInfo();
                if(cur.getCount() == 0){
                    Toast.makeText(SqliteDatabaseActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }

                StringBuffer buffer = new StringBuffer();
                while(cur.moveToNext()){
                    buffer.append("name ::"+cur.getString(1)+"\n");
                    buffer.append("username :: "+cur.getString(2)+"\n");
                    buffer.append("password :: "+cur.getString(3)+"\n\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(SqliteDatabaseActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Signup users data");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Objects.requireNonNull(nameET.getText()).toString();
                String userName = Objects.requireNonNull(userNameET.getText()).toString();
                String pass = Objects.requireNonNull(passET.getText()).toString();

                if(name.equals("") || userName.equals("") || pass.equals("")){
                    Toast.makeText(SqliteDatabaseActivity.this, "Enter all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    boolean update_data = myDBHelper.update_data(name,userName,pass);
                    if(update_data){
                        Toast.makeText(SqliteDatabaseActivity.this, "Successful update data.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SqliteDatabaseActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = Objects.requireNonNull(userNameET.getText()).toString();
                boolean delete_data = myDBHelper.delete_data(userName);
                if(delete_data){
                    Toast.makeText(SqliteDatabaseActivity.this, "Delete Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SqliteDatabaseActivity.this, "Something went wrong.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}