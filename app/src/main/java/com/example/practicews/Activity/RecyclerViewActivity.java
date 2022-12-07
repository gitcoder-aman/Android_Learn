package com.example.practicews.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicews.Adapter.ContactAdapter;
import com.example.practicews.Model.ContactModel;
import com.example.practicews.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recyclerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactModel contactModel = new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433");
        arrContacts.add(contactModel);
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Rohan Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));
        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24, "Aman Kumar", "3642749433"));

        adapter = new ContactAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);

        //Add data in RecyclerView

        FloatingActionButton btnFloating;
        btnFloating = findViewById(R.id.btnOpenDialog);

        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(RecyclerViewActivity.this);
                dialog.setContentView(R.layout.activity_add_update);

                EditText edtName = dialog.findViewById(R.id.editName);
                EditText edtNumber = dialog.findViewById(R.id.editNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String name="",number="";

                        if (!edtName.getText().toString().equals("")) {
                             name = edtName.getText().toString();
                        }else{
                            Toast.makeText(RecyclerViewActivity.this, "Please add the Name", Toast.LENGTH_SHORT).show();
                        }

                        if (!edtNumber.getText().toString().equals("")) {

                             number = edtNumber.getText().toString();
                        }else{
                            Toast.makeText(RecyclerViewActivity.this, "Please add the Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.add(new ContactModel(R.drawable.ic_baseline_person_3_24,name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }
}