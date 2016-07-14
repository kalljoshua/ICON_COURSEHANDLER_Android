package info.androidhive.materialdesign.pages;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.MainActivity;

/**
 * Created by YIYA SERVER on 4/29/2016.
 */
public class Aboutandhelp extends ActionBarActivity {

    private Toolbar mToolbar;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutandhelp);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //ImageButton ib = (ImageButton) findViewById(R.id.imageButton);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.olevel_selector, menu);
        getMenuInflater().inflate(R.menu.olevel, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "Back action is selected!", Toast.LENGTH_SHORT).show();
                //break;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
