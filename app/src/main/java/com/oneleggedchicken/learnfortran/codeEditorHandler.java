package com.oneleggedchicken.learnfortran;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Created by shinigami on 17/04/16.
 */
public class codeEditorHandler {
    public static String js_getcode = "editor.getValue()";
    public static String code;
    public codeEditorHandler(){

    }
    @JavascriptInterface
    public void loadCode(String code){
        codeEditorHandler.code = code;
    }
    public static String getCode() {
        return code;
    }
}
