package com.example.practicews.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicews.R;

import java.util.ArrayList;

public class ListViewSpinner extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;

    ArrayList<String> arrNames = new ArrayList<>(); //for listView
    int[] arrNo = new int[]{1,2,3,4,5};
    ArrayList<String>arrIds = new ArrayList<>();  //for spinner

    ArrayList<String> arrLanguage = new ArrayList<>(); //for autoCompleteTextView
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_spinner);

        listView = findViewById(R.id.listview);
        spinner = findViewById(R.id.spinner);
        autoCompleteTextView = findViewById(R.id.autoComplete);

        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");
        arrNames.add("Aman");

        ArrayAdapter<String>adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(position == 0){
                    Toast.makeText(ListViewSpinner.this, "Clicked first Item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //spinner

        arrIds.add("Aadhar Card");
        arrIds.add("Pan Card");
        arrIds.add("Voter Id Card");
        arrIds.add("Driving License Card");
        arrIds.add("Ration Card");
        arrIds.add("Xth score Card");
        arrIds.add("XIIth score Card");

        ArrayAdapter<String>spinnerAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdapter);

        //AutoCompleteTextView
        arrLanguage.add("Java");
        arrLanguage.add("C++");
        arrLanguage.add("C");
        arrLanguage.add("Python");
        arrLanguage.add("C#");
        arrLanguage.add("JavaScript");
        arrLanguage.add("PHP");
        arrLanguage.add("Objective C");

        ArrayAdapter<String>actvAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrLanguage);
        autoCompleteTextView.setAdapter(actvAdapter);

        autoCompleteTextView.setThreshold(1);
    }
}
