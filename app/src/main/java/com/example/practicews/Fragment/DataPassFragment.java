package com.example.practicews.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.practicews.Activity.DataPassingInFragActivity;
import com.example.practicews.R;

public class DataPassFragment extends Fragment {

    private static final String ARG1 = "argument1";
    private static final String ARG2 = "argument2";

    //2nd way of data passing in Fragment from activity
    public static DataPassFragment getInstance(String name, int rollNo) {

        DataPassFragment dataPassFrag = new DataPassFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG1, name);
        bundle.putInt(ARG2, rollNo);

        dataPassFrag.setArguments(bundle);
        return dataPassFrag;
    }

    public DataPassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity())
                .getSupportActionBar()
                .setTitle("Data Pass in Fragment");

//        if(getArguments()!=null){     //1st way of data passing in Fragment from activity
//            String name = getArguments().getString("Arg1");
//            int rollNo = getArguments().getInt("Arg2");
//
//            Toast.makeText(getContext(), "Name is: "+name+" Roll No "+rollNo,Toast.LENGTH_SHORT).show();
//            Log.d("Value from Act","Name is: "+name+ " Roll No "+rollNo);
//        }


        if (getArguments() != null) {      //2nd way of data passing in Fragment from activity
            String name = getArguments().getString(ARG1);
            int rollNo = getArguments().getInt(ARG2);

            Toast.makeText(getContext(), "Name is: " + name + " Roll No " + rollNo, Toast.LENGTH_SHORT).show();
            Log.d("Value from Act", "Name is: " + name + " Roll No " + rollNo);

            //any Method of Activity call from Fragment
            ((DataPassingInFragActivity)getActivity()).callFromFragment();
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data_pass, container, false);
        return view;
    }
}