package com.example.edu.webviewwithexplicit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextAddress;
    Button buttonAddress;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddress = findViewById(R.id.buttonAddress);


        buttonAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        editTextAddress = findViewById(R.id.editTextAddress);
        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.loadUrl(editTextAddress.getText().toString());
        webView.requestFocus();
    }
}
