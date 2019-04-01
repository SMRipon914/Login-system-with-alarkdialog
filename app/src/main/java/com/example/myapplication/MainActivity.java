package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    EditText editText1,editText2;
    Button singnIn,signUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        singnIn=findViewById(R.id.signIn);
        signUP=findViewById(R.id.signUp);
        SharePre.init(this);

        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogActivity dialogActivity=new DialogActivity();
                dialogActivity.show(getSupportFragmentManager(),"Dialog Activity");
            }
        });
        singnIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String v1=SharePre.Read("d1","");
                String v2= SharePre.Read("d2","");
                if (v1.equals(editText1.getText().toString()) && v2.equals(editText2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}
