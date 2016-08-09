package com.andreakim.kkspetsapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceAreaActivity extends AppCompatActivity {


    Button mBtnSubmit;
    String userZip;
    Boolean mResult;
    ImageView iv;

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:andreaforanimals@gmail.com")); // only email apps should handle this
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
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
        iv = (ImageView) findViewById(R.id.staticMap);

        mBtnSubmit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                try {
                    userZip = mEditField.getText().toString();
                    String yes = getResources().getString(R.string.result_positive);
                    String no = getResources().getString(R.string.result_negative);
                    switch (userZip) {
                        case "60659":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60645":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60626":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60660":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60646":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60625":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60640":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60618":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60613":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60202":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60201":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        case "60712":
                            mResult = true;
                            mResultField.setText(yes);
                            iv.setImageResource(R.drawable.happypatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                        default:
                            mResult = false;
                            mResultField.setText(no);
                            iv.setImageResource(R.drawable.sadpatsysmall);
                            hideKeyboard(ServiceAreaActivity.this);
                            break;
                    }
                } catch (Exception e) {
                    Log.e("", "Exception caught");
                    e.printStackTrace();
                    mResultField.setText("Sorry, there was an error");
                    hideKeyboard(ServiceAreaActivity.this);
                }
            }
        });
    }
}

