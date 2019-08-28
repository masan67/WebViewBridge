package com.marioapps.webviewbridge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private Button btnWV, btnJSON;
    public static TextView textView;
    private ScrollView scrollView;

    private String url = "https://notingerapp.000webhostapp.com/javascript_test.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btnWV = findViewById(R.id.buttonwebview);
        btnJSON = findViewById(R.id.buttonJSON);
        textView = findViewById(R.id.textview);
        scrollView = findViewById(R.id.scrollview);

        btnWV.setOnClickListener(this);
        btnJSON.setOnClickListener(this);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        webView.addJavascriptInterface(new WebAppInterface(getApplicationContext()),"Android");
        webView.loadUrl(url);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonwebview:
                webView.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                break;

            case R.id.buttonJSON:
                webView.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                fetchData process = new fetchData();
                process.execute();
                break;

            default:
                break;
        }
    }
}
