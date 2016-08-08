package com.andreakim.kkspetsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends AppCompatActivity {


    GoogleApiClient mGoogleApiClient;
    private ShareActionProvider mShareActionProvider;

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
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tvw = (TextView) findViewById(R.id.textViewWebsite);
        tvw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.kkspets.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        TextView tvn = (TextView) findViewById(R.id.textViewNews);
        tvn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.yelp.com/biz/kks-pet-sitting-and-dog-walking-chicago";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ImageView iv = (ImageView) findViewById(R.id.expertise);
        iv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String url = "http://www.expertise.com/il/chicago/pet-sitters";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                composeEmail();
                Snackbar.make(view, "Email KK's Pet Sitting now", Snackbar.LENGTH_LONG)
                        .setAction("Email", null).show();

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Return true to display menu
        return true;

    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//

//        if (id == R.id.toolbarShare) {
//        getMenuInflater().inflate(R.menu.share_menu, menu);
//        MenuItem item = menu.findItem(R.id.action_share);
//        mShareActionProvider = (ShareActionProvider) item.getActionProvider();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    }
}
