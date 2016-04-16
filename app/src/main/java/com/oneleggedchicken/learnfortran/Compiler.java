package com.oneleggedchicken.learnfortran;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.oneleggedchicken.learnfortran.R;

public class Compiler extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webview = (WebView) findViewById(R.id.web);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://ideone.com");

    }

}
