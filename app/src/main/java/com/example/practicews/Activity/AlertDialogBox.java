package com.example.practicews.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicews.R;

public class AlertDialogBox extends AppCompatActivity {

    Button generalDialogBtn,customDialogBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_box);

        generalDialogBtn = findViewById(R.id.general_btn);
        customDialogBtn = findViewById(R.id.customBtn);

        generalDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AlertDialogBox.this);
                alertDialog.setTitle("Term & Condition");
                alertDialog.setIcon(R.drawable.ic_baseline_info_24);
                alertDialog.setMessage("Have you read all terms & Conditions");

                alertDialog.setPositiveButton("yes, I've Read",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogBox.this, "Yes, You can proceed now.", Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogBox.this, "Ok read after some times", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogBox.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        customDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(AlertDialogBox.this);
                dialog.setContentView(R.layout.custom_dialog_layout);
                dialog.setCancelable(false);

                Button btnOk = dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AlertDialogBox.this, "Closed", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();


            }
        });

    }
}
