package com.example.hw;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        1);
            }
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText idText = (EditText) findViewById(R.id.loginId);
                EditText pwdText = (EditText) findViewById(R.id.loginPw);
                if ( idText.getText().toString().length() == 0 || pwdText.getText().toString().length() == 0 ){
                    Toast.makeText(MainActivity.this,
                            "올바른 계정을 입력해주세요.",
                            Toast.LENGTH_LONG).show();
                } else {
                    File fileName = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/user.txt");
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(fileName));
                    } catch (FileNotFoundException e) {
                        try {
                            FileWriter fw = new FileWriter(fileName);
                            fw.write("");
                            fw.close();
                            br = new BufferedReader(new FileReader(fileName));
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    String temp = "";
                    int cnt = 0;
                    String fileid = "";
                    String filepwd = "";
                    boolean chksuccess = false;
                    while(true) {
                        try {
                            if (br != null && (temp = br.readLine()) == null) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                        if((cnt % 5) == 0) fileid = temp;
                        if((cnt % 5) == 1) {
                            filepwd = temp;
                            if(fileid.equals(idText.getText().toString()) && filepwd.equals(pwdText.getText().toString())) {
                                Toast.makeText(MainActivity.this,
                                        "로그인 성공",
                                        Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(),
                                        DetailActivity.class);
                                startActivity(intent);
                                chksuccess = true;
                            }
                        }
                        cnt++;
                    }
                    if(!chksuccess){
                        Toast.makeText(MainActivity.this,
                                "계정이 잘못되었습니다.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        Button registerbtn = (Button) findViewById(R.id.registerbtn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
