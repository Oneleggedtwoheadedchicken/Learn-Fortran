package com.oneleggedchicken.learnfortran;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
public class loadXML {
    ArrayList<Data> dataArray;
    public loadXML(Context ctx,String filename) throws IOException, XmlPullParserException {
        InputStream is = ctx.getAssets().open(filename);
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xmlrp = factory.newPullParser();
        xmlrp.setInput(is, "UTF-8");
        String data = null;
        Log.d("here","1");
        dataArray = new ArrayList<>();
        ArrayList<String[]> questionhead = new ArrayList<>();
        ArrayList<String[]> questiontext = new ArrayList<>();
        ArrayList<String[]> gridtext = new ArrayList<>();
        ArrayList<String[]> gridsectext = new ArrayList<>();
        int eventType = xmlrp.getEventType();
        while (eventType != xmlrp.END_DOCUMENT) {
            String name = xmlrp.getName();
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    break;

                case XmlPullParser.TEXT:
                    data = xmlrp.getText();
                    break;
                case XmlPullParser.END_TAG:
                    if (name.equals("question")) {
                        if (!questionhead.isEmpty()) {
                            dataArray.add(new Data(questionhead.get(0), questiontext.get(0), gridtext.get(0),gridsectext.get(0)));
                        }
                    } else if (name.equals("questionhead")) {
                        questionhead.add(0, data.trim().split(","));
                    } else if (name.equals("questiontext")) {
                        questiontext.add(0, data.trim().split(","));
                    } else if (name.equals("gridtext")) {
                        gridtext.add(0, data.trim().split(","));
                    } else if (name.equals("gridsectext")) {
                        gridsectext.add(0, data.trim().split(","));
                    }
             
                    break;
            }
            eventType = xmlrp.next();
        }
    }
}