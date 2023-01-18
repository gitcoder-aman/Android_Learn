package com.example.practicews.RoomDB;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicews.R;

import java.util.ArrayList;

public class RoomDBActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtAmount;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_dbactivity);

        edtName = findViewById(R.id.edtName);
        edtAmount = findViewById(R.id.edtAmount);
        addBtn = findViewById(R.id.btnAdd);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);


        ArrayList<Expense> arrExpenseList = (ArrayList<Expense>) databaseHelper.expenseDAO().getAllExpense();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = edtName.getText().toString();
                String amount = edtAmount.getText().toString();

                if (title.equals("") || amount.equals("")) {
                    Toast.makeText(RoomDBActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    databaseHelper.expenseDAO().addTx(new Expense(title, amount));  //add transaction

                    for (int i = 0; i < arrExpenseList.size(); i++) {
                        Log.d("data", "Title : " + arrExpenseList.get(i).getTitle() + "Amount : " + arrExpenseList.get(i).getAmount());
                    }

                }
            }
        });
    }
}