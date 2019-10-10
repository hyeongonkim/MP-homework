package com.example.hw;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button submit = (Button) findViewById(R.id.submit);
        final ToggleButton IDcheck = (ToggleButton) findViewById(R.id.IDcheck);
        IDcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            EditText userid = (EditText) findViewById(R.id.userid);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    boolean chksuccess = true;
                    if(userid.getText().toString().length() == 0) {
                        Toast.makeText(SecondActivity.this,
                                "사용할 아이디를 입력하세요.",
                                Toast.LENGTH_LONG).show();
                        chksuccess = false;
                    } else {
                        File fileName = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/user.txt");
                        BufferedReader br = null;
                        try {
                            br = new BufferedReader(new FileReader(fileName));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        String temp = "";
                        int cnt = 0;
                        String fileid = "";
                        while(true) {
                            try {
                                if (br != null && (temp = br.readLine()) == null) break;
                            } catch (IOException e) {
                                e.printStackTrace();
                                break;
                            }
                            if((cnt % 5) == 0) fileid = temp;
                            if(fileid.equals(userid.getText().toString())) {
                                Toast.makeText(SecondActivity.this,
                                        "이미 사용중인 아이디입니다.",
                                        Toast.LENGTH_LONG).show();
                                chksuccess = false;
                            }
                            cnt++;
                        }
                    }
                    if(!chksuccess) {
                        IDcheck.setChecked(false);
                    } else {
                        userid.setClickable(false);
                        userid.setFocusable(false);
                    }

                } else {
                    IDcheck.setChecked(true);
                }
            }
        });

        final ToggleButton PWDcheck = (ToggleButton) findViewById(R.id.PWDcheck);
        PWDcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            EditText pwd = (EditText) findViewById(R.id.pwd);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    if(pwd.getText().toString().length() < 8) {
                        Toast.makeText(SecondActivity.this,
                                "8자리 이상의 비밀번호를 입력하세요.",
                                Toast.LENGTH_LONG).show();
                        PWDcheck.setChecked(false);
                    } else if(!(pwd.getText().toString().contains("!") || pwd.getText().toString().contains("@") || pwd.getText().toString().contains("#"))) {
                        Toast.makeText(SecondActivity.this,
                                "적어도 !, @, # 중 하나를 포함하여 입력하세요.",
                                Toast.LENGTH_LONG).show();
                        PWDcheck.setChecked(false);
                    } else {
                        pwd.setClickable(false);
                        pwd.setFocusable(false);
                    }

                } else {
                    PWDcheck.setChecked(true);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText userid = (EditText) findViewById(R.id.userid);
                EditText pwd = (EditText) findViewById(R.id.pwd);
                EditText name = (EditText) findViewById(R.id.name);
                EditText phone = (EditText) findViewById(R.id.phone);
                EditText address = (EditText) findViewById(R.id.address);
                RadioGroup group = (RadioGroup) findViewById(R.id.group);
                RadioButton no = (RadioButton) findViewById(R.id.no);
                RadioButton yes = (RadioButton) findViewById(R.id.yes);

                if(name.getText().toString().length() == 0 || phone.getText().toString().length() == 0 || address.getText().toString().length() == 0) {
                    Toast.makeText(SecondActivity.this,
                            "모든 필드를 채우십시오.",
                            Toast.LENGTH_LONG).show();
                } else if(!IDcheck.isChecked()) {
                    Toast.makeText(SecondActivity.this,
                            "ID 중복검사를 하십시오.",
                            Toast.LENGTH_LONG).show();
                } else if(!PWDcheck.isChecked()) {
                    Toast.makeText(SecondActivity.this,
                            "PW 유효성검사를 하십시오.",
                            Toast.LENGTH_LONG).show();
                } else if(yes.isChecked()) {
                    File fileName = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/user.txt");
                    BufferedWriter bw = null;
                    try {
                        bw = new BufferedWriter(new FileWriter(fileName, true));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    PrintWriter pw = new PrintWriter(bw, true);
                    pw.write(userid.getText().toString() + "\n");
                    pw.write(pwd.getText().toString() + "\n");
                    pw.write(name.getText().toString() + "\n");
                    pw.write(phone.getText().toString() + "\n");
                    pw.write(address.getText().toString() + "\n");
                    pw.flush();
                    pw.close();
                    finish();
                } else {
                    Toast.makeText(SecondActivity.this,
                            "개인정보처리방침에 동의하십시오.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
