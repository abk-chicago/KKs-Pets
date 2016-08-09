package com.andreakim.kkspetsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceAreaActivity extends AppCompatActivity {


    Button mBtnSubmit;
    String userZip;
    Boolean mResult;


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
        setContentView(R.layout.activity_service_area);

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

        final EditText mEditField = (EditText) findViewById(R.id.editView);
        final TextView mResultField = (TextView) findViewById(R.id.textView_result);


        mBtnSubmit = (Button) findViewById(R.id.button);

        mBtnSubmit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    userZip = mEditField.getText().toString();

                    switch (userZip) {
                        case "60659":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60645":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60626":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60660":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60646":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60625":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60640":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60618":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60613":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60202":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60201":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        case "60712":
                            mResult = true;
                            mResultField.setText("@string/result_positive");
                            break;
                        default:
                            mResult = false;
                            mResultField.setText("@string/result_negative");
                            break;
                    }
                } catch (Exception e) {
                    Log.e("", "Exception caught");
                    e.printStackTrace();
                    mResultField.setText("Sorry, there was an error");
                }
            }
        });
    }
}

