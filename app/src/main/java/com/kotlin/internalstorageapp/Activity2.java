package com.kotlin.internalstorageapp;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.FileInfo;
import android.view.View;
import android.widget.Button;
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

public class Activity2 extends AppCompatActivity {


    String phonestr , messagestr ;
    TextView phone , message ;
    Button writebtn , readbtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);

        Intent intent  = getIntent();

        phone = findViewById(R.id.Phone_txtxml) ;
        message = findViewById(R.id.message_txtxml) ;
        writebtn = findViewById(R.id.Write_btnxml) ;
        readbtn = findViewById(R.id.Read_btnxml) ;

        phonestr = intent.getStringExtra("phone_key") ;
        messagestr = intent.getStringExtra("message_key") ;

        phone.setText(phonestr);
        message.setText(messagestr);

        writebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try(FileOutputStream fos = openFileOutput(MainActivity.File_Name , MODE_PRIVATE) ;
                DataOutputStream dos = new DataOutputStream(fos) ) {


                    dos.writeUTF(phone.getText().toString());
                    dos.writeUTF(message.getText().toString());
                    phone.setText("");
                    message.setText("");

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        });

        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try ( FileInputStream fis =  openFileInput (MainActivity.File_Name) ;
                DataInputStream dis = new DataInputStream(fis) ){

                    phone.setText(dis.readUTF() );
                    message.setText(dis.readUTF());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });



    }
}