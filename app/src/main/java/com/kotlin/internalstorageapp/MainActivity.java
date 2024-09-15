package com.kotlin.internalstorageapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.FileInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static final String File_Name = "Phone_Message" ;

EditText phoneEt , messageEt ;
Button mainBtn;

      String phonestr;
     String messagestr ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        phoneEt = findViewById(R.id.writephone_xml) ;
        messageEt = findViewById(R.id.writemessage_xml) ;

        mainBtn = findViewById(R.id.main_btn_xml) ;
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonestr = phoneEt.getText().toString() ;
                messagestr = messageEt.getText().toString() ;
                Intent intent = new Intent(MainActivity.this , Activity2.class) ;
                intent.putExtra("message_key", messagestr) ;
                intent.putExtra("phone_key", phonestr) ;
                startActivity(intent);

            }
        });



    }
}