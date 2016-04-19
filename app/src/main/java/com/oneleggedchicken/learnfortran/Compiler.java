package com.oneleggedchicken.learnfortran;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;

import com.oneleggedchicken.learnfortran.R;

import java.io.File;

public class Compiler extends AppCompatActivity {
    static WebView webview;
    static String editorPage;
    FrameLayout fl;
    Button runButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compiler_web_view);
        getSupportActionBar().setTitle("Code Playground");

        fl = (FrameLayout) findViewById(R.id.compiler_layout);
        fl.addView(Compiler.webview);
        helperFunctions.copyFile("code.c", this.getFilesDir() + "code.c", this);
        File file = new File(this.getFilesDir()+"a.out");
        Log.d("dirs", String.valueOf(this.getFilesDir()));
        file.setExecutable(true);
        if (file.exists()){
            Log.d("ls", helperFunctions.runCommand(this.getFilesDir()+"a.out"));
        }else{
            Log.d("file","doesn'tExist");
        }
        Log.d("ls", helperFunctions.runCommand("gcc -o "+this.getFilesDir()+"/code "+this.getFilesDir()+"/code.c"));
//        Log.d("ls", helperFunctions.runCommand("gcc -o code code.c"));
        Log.d("ls", helperFunctions.runCommand("ls " + this.getFilesDir()));


        runButton = (Button) findViewById(R.id.run_button);
        runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compiler.webview.loadUrl("javascript:window.handler.loadCode(window.editor.getValue());");
            }
        });
    }

    @Override
    protected void onDestroy() {
        fl.removeAllViews();
        super.onDestroy();
    }
}
