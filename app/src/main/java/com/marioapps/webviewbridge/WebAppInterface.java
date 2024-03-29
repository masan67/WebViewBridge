package com.marioapps.webviewbridge;

import android.webkit.JavascriptInterface;
import android.widget.Toast;
import android.content.Context;

public class WebAppInterface {

    private Context context;

    public WebAppInterface(Context context){
        this.context=context;
    }

    @JavascriptInterface
    public void showToast(String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }

}
