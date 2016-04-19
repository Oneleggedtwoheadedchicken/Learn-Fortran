package com.oneleggedchicken.learnfortran;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public static String runCommand(String commandLine){
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try{
            Process process = Runtime.getRuntime().exec(commandLine);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            int n;
            while ((n = bufferedReader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

        }catch (Exception e){

        }
        return writer.toString();
    }
    public static void copyFile(String assetPath, String localPath, Context context) {
        try {
            InputStream in = context.getAssets().open(assetPath);
            FileOutputStream out = new FileOutputStream(localPath);
            int read;
            byte[] buffer = new byte[4096];
            while ((read = in.read(buffer)) > 0) {
                out.write(buffer, 0, read);
            }
            out.close();
            in.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
