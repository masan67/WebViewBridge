package com.marioapps.webviewbridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.marioapps.webviewbridge.WebAppInterface;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private EditText edit_text_to_web;
    private String url = "https://notingerapp.000webhostapp.com/javascript_test.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        edit_text_to_web = findViewById(R.id.edit_text_to_web);

        //webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        webView.addJavascriptInterface(new WebAppInterface(getApplicationContext()),"Android");
        webView.loadUrl(url);

    }
}
