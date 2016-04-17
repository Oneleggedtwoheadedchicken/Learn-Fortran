package com.oneleggedchicken.learnfortran;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.oneleggedchicken.learnfortran.R;

public class Compiler extends AppCompatActivity {
    static WebView webview;
    static String editorPage;
    FrameLayout fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compiler_web_view);
        fl = (FrameLayout) findViewById(R.id.compiler_layout);
//        fl = new FrameLayout(this);
        fl.addView(Compiler.webview);
    }

    @Override
    protected void onDestroy() {
        fl.removeAllViews();
        super.onDestroy();
    }
}
