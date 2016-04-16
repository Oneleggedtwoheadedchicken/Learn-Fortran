package com.oneleggedchicken.learnfortran;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import com.oneleggedchicken.learnfortran.R;

public class Compiler extends Activity {
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compiler_web_view);

        WebView webview = (WebView) findViewById(R.id.web);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("file:///android_asset/editor.html");

    }

}
