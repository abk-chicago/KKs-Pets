package com.andreakim.kkspetsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class ScheduleActivity extends AppCompatActivity {

Button mHome;
    Intent mHomeIntent;

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:andreaforanimals@gmail.com")); // only email apps should handle this
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeEmail();
                Snackbar.make(view, "Email KK's Pet Sitting now", Snackbar.LENGTH_LONG)
                        .setAction("Email", null).show();

            }
        });

        final String websiteURL = "http://kkspets.youcanbook.me";

        mHome = (Button) findViewById(R.id.home_button);

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHomeIntent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(mHomeIntent);
            }
        });


        // wrap our page here!
        // this will be used to show our guests to print
        final WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl(websiteURL);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

    }

}
