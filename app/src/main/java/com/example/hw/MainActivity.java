package com.example.hw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FileReader fr = null;
//        try {
//            fr = new FileReader("account.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader bufrd = new BufferedReader(fr);
//        try {
//            String str = bufrd.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        setContentView(R.layout.activity_main);
        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        DetailActivity.class);
                startActivity(intent);
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
