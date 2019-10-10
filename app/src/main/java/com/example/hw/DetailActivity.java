package com.example.hw;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends Activity {
    private WebView web1;
    private WebSettings web1Settings;
    private WebView web2;
    private WebSettings web2Settings;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detailpage);
        web1 = (WebView) findViewById(R.id.web1);
        web1.setWebViewClient(new WebViewClient());
        web1Settings = web1.getSettings();
        web1Settings.setJavaScriptEnabled(true);
        web1Settings.setSupportMultipleWindows(false);
        web1Settings.setJavaScriptCanOpenWindowsAutomatically(false);
        web1Settings.setLoadWithOverviewMode(true);
        web1Settings.setUseWideViewPort(true);
        web1Settings.setSupportZoom(false);
        web1Settings.setBuiltInZoomControls(false);
        web1Settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        web1Settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        web1Settings.setDomStorageEnabled(true);

        web2 = (WebView) findViewById(R.id.web2);
        web2.setWebViewClient(new WebViewClient());
        web2Settings = web2.getSettings();
        web2Settings.setJavaScriptEnabled(true);
        web2Settings.setSupportMultipleWindows(false);
        web2Settings.setJavaScriptCanOpenWindowsAutomatically(false);
        web2Settings.setLoadWithOverviewMode(true);
        web2Settings.setUseWideViewPort(true);
        web2Settings.setSupportZoom(false);
        web2Settings.setBuiltInZoomControls(false);
        web2Settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        web2Settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        web2Settings.setDomStorageEnabled(true);

        Button movebtn = (Button) findViewById(R.id.movebtn);
        movebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText firstUrl = (EditText) findViewById(R.id.firstUrl);
                EditText secondUrl = (EditText) findViewById(R.id.secondUrl);
                web1.loadUrl(firstUrl.getText().toString());
                web2.loadUrl(secondUrl.getText().toString());
            }
        });
        Button logoutbtn = (Button) findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
