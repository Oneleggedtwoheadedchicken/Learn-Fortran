package com.oneleggedchicken.learnfortran;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by shinigami on 17/04/16.
 */
public class helperFunctions {
    public helperFunctions(){

    }
    public static String loadFile(String filename,Context context) {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            InputStream in = context.getAssets().open(filename, AssetManager.ACCESS_BUFFER);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n;
            while ((n = br.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return writer.toString();
    }
}
