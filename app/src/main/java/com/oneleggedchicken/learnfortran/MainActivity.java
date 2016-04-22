package com.oneleggedchicken.learnfortran;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String inviteText = "I'm learning Fortran on Learn Fortran application ! Checkout #FortranIsFun";
    String inviteTitle = "Share with friends";
    FrameLayout arrays,basics,loops, morebasics,modules,test;
    loadXML x;
    ArrayList<Data> al;
    Locale locale;
    Configuration config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locale = new Locale("en_US");
        Locale.setDefault(locale);
        config = new Configuration();
        config.locale = locale;
        this.getApplicationContext().getResources().updateConfiguration(config, null);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Load Compiler in The Background
        loadCompiler();

        basics = (FrameLayout) findViewById(R.id.Basics);
        basics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                al = new ArrayList<>();
                try {
                    x = new loadXML(getApplicationContext(), "basics.xml");
                    Log.d("data", x.dataArray.toString());
                    al=x.dataArray;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(MainActivity.this, TableGrid.class);
                intent.putExtra("data", al.get(0));
                intent.putExtra("name","Basic Concepts");
                startActivity(intent);

            }
        });

        morebasics = (FrameLayout) findViewById(R.id.more_basics);
        morebasics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                al = new ArrayList<>();
                try {
                    x = new loadXML(getApplicationContext(), "more_basics.xml");
                    Log.d("data", x.dataArray.toString());
                    al=x.dataArray;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(MainActivity.this,TableGrid.class);
                intent.putExtra("name","More Basics");
                intent.putExtra("data", al.get(0));
                startActivity(intent);

            }
        });



        arrays = (FrameLayout) findViewById(R.id.Arrays);

        arrays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                al = new ArrayList<>();
                try {
                    x = new loadXML(getApplicationContext(), "arrays.xml");
                    Log.d("data", x.dataArray.toString());
                    al=x.dataArray;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }


                Intent intent = new Intent(MainActivity.this,TableGrid.class);
                intent.putExtra("data", al.get(0));
                intent.putExtra("name","Arrays");
                startActivity(intent);

            }
        });



    loops = (FrameLayout) findViewById(R.id.Loops);

    loops.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            al = new ArrayList<>();
            try {
                x = new loadXML(getApplicationContext(), "loops.xml");
                Log.d("data", x.dataArray.toString());
                al=x.dataArray;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


            Intent intent = new Intent(MainActivity.this,TableGrid.class);
            intent.putExtra("name","Conditionals and Loops");
            intent.putExtra("data", al.get(0));
            startActivity(intent);

        }
    });

    modules = (FrameLayout) findViewById(R.id.modules);

    modules.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            al = new ArrayList<>();
            try {
                x = new loadXML(getApplicationContext(), "modules.xml");
                Log.d("data", x.dataArray.toString());
                al=x.dataArray;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


            Intent intent = new Intent(MainActivity.this,TableGrid.class);
            intent.putExtra("name","Procedures & Modules");
            intent.putExtra("data", al.get(0));
            startActivity(intent);

        }
    });
        test = (FrameLayout) findViewById(R.id.Test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,TestPagerMain.class);
                startActivity(intent);

            }
        });


    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            navigateHome();
        } else if (id == R.id.compiler) {
            navigateCompiler();
        } else if (id == R.id.glossary) {
            navigateGlossary();
        } else if (id == R.id.settings) {

        } else if (id == R.id.invite) {
            navigateInvite();

        } else if (id == R.id.rate) {
            navigateRate();
        }
        return true;
    }


    private boolean MyStartActivity(Intent aIntent) {
        try {
            startActivity(aIntent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }
    public void loadCompiler(){
        Compiler.editorPage = helperFunctions.loadFile("editor.html",this);
        Compiler.webview = new WebView(this);
        Compiler.webview.getSettings().setJavaScriptEnabled(true);
        Compiler.webview.getSettings().setBuiltInZoomControls(true);
        Compiler.webview.getSettings().setDisplayZoomControls(false);
        Compiler.webview.addJavascriptInterface(new codeEditorHandler(),"handler");
//        webview.loadUrl("file:///android_asset/editor.html");
        Compiler.webview.loadDataWithBaseURL("file:///android_asset/", Compiler.editorPage, "text/html", "utf-8", null);

    }
    public void navigateHome(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }
    public void navigateCompiler(){
        Intent intent = new Intent(MainActivity.this,Compiler.class);
        startActivity(intent);
    }
    public void navigateGlossary(){
        Intent intent = new Intent(MainActivity.this, Glossary.class);
        startActivity(intent);
    }
    public void navigateRate(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.oneleggedchicken.learnfortran"));
        if (!MyStartActivity(intent)) {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.oneleggedchicken.learnfortran"));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
    public void navigateInvite(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, inviteText);
        i.putExtra(Intent.EXTRA_SUBJECT, "https://play.google.com/store/apps/details?id=com.oneleggedchicken.learnfortran");
        startActivity(Intent.createChooser(i, inviteTitle));
    }

}
