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
        ArrayList<String[]> firstquestionhead = new ArrayList<>();
        ArrayList<String[]> firstquestiontext = new ArrayList<>();
        ArrayList<String[]> secondquestionhead = new ArrayList<>();
        ArrayList<String[]> secondquestiontext = new ArrayList<>();
        ArrayList<String[]> thirdquestionhead = new ArrayList<>();
        ArrayList<String[]> thirdquestiontext = new ArrayList<>();
        ArrayList<String[]> fourthquestionhead = new ArrayList<>();
        ArrayList<String[]> fourthquestiontext = new ArrayList<>();
        ArrayList<String[]> fifthquestionhead = new ArrayList<>();
        ArrayList<String[]> fifthquestiontext = new ArrayList<>();
        ArrayList<String[]> sixthquestionhead = new ArrayList<>();
        ArrayList<String[]> sixthquestiontext = new ArrayList<>();
        ArrayList<String[]> seventhquestionhead = new ArrayList<>();
        ArrayList<String[]> seventhquestiontext = new ArrayList<>();
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
                        if (!secondquestionhead.isEmpty()) {
                            dataArray.add(new Data(firstquestionhead.get(0), firstquestiontext.get(0), secondquestionhead.get(0), secondquestiontext.get(0), thirdquestionhead.get(0), thirdquestiontext.get(0), fourthquestionhead.get(0), fourthquestiontext.get(0),
                                    fifthquestionhead.get(0), fifthquestiontext.get(0), sixthquestionhead.get(0), sixthquestiontext.get(0), seventhquestionhead.get(0), seventhquestiontext.get(0), gridtext.get(0), gridsectext.get(0)));
                        }
                    } else if (name.equals("firstquestionhead")) {
                        firstquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("firstquestiontext")) {
                        firstquestiontext.add(0, data.trim().split(","));
                    } else if (name.equals("secondquestionhead")) {
                        secondquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("secondquestiontext")) {
                        secondquestiontext.add(0, data.trim().split(","));
                    } else if (name.equals("thirdquestionhead")) {
                        thirdquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("thirdquestiontext")) {
                        thirdquestiontext.add(0, data.trim().split(","));
                    } else if (name.equals("fourthquestionhead")) {
                        fourthquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("fourthquestiontext")) {
                        fourthquestiontext.add(0, data.trim().split(","));
                    } else if (name.equals("fifthquestionhead")) {
                        fifthquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("fifthquestiontext")) {
                        fifthquestiontext.add(0, data.trim().split(","));
                    } else if (name.equals("sixthquestionhead")) {
                        sixthquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("sixthquestiontext")) {
                        sixthquestiontext.add(0, data.trim().split(","));
                    } else if (name.equals("seventhquestionhead")) {
                        seventhquestionhead.add(0, data.trim().split(","));
                    } else if (name.equals("seventhquestiontext")) {
                        seventhquestiontext.add(0, data.trim().split(","));
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