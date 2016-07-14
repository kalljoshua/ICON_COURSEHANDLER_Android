package info.androidhive.materialdesign.pages;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.*;

/**
 * Created by YIYA SERVER on 4/29/2016.
 */
public class EnterOlevelResults extends ActionBarActivity {

    private Toolbar mToolbar;
    FloatingActionButton fab;
    ArrayList<EditText> mCheck = new ArrayList<EditText>();
    List<EditText> alleds = new ArrayList<EditText>();
    ArrayList<String> alpha = new ArrayList<String>();
    TextView content;
    ArrayList<String> gotBread;
    EditText math, physics, chemistry, biology, geograpy, english, history;
    String x, mathe, physicse, chemistrye, biologye, geograpye, englishe,
            historye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olevel);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //ImageButton ib = (ImageButton) findViewById(R.id.imageButton);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayout mLayout = (LinearLayout) findViewById(R.id.layout);

        Bundle gotBasket = getIntent().getExtras();
        gotBread = gotBasket.getStringArrayList("subjects");
        for (int i = 0; i < gotBread.size(); i++) {
            x = x + "\n" + gotBread.get(i);

            TextView textView = new TextView(EnterOlevelResults.this);
            textView.setText(gotBread.get(i));
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
            mLayout.addView(textView);

            EditText mEdit = new EditText(EnterOlevelResults.this);

            alleds.add(mEdit);

            mEdit.setHint("Enter Grades (D,C,P,F)");
            mEdit.setId(i);
            mEdit.setBackgroundColor(Color.WHITE);
            mEdit.setTextColor(Color.BLACK);
            mEdit.setEms(10);

            mEdit.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,
                    Toolbar.LayoutParams.WRAP_CONTENT));
            mEdit.setFocusableInTouchMode(true);
            mEdit.requestFocus();
            mLayout.addView(mEdit);
            mCheck.add(mEdit);
        }

        TextView textView = new TextView(EnterOlevelResults.this);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        textView.setPadding(17,0,0,0);
        textView.setTextSize(20);
        mLayout.addView(textView);



        gotBasket.getStringArrayList("subjects").clear();

        math = (EditText) findViewById(R.id.editmath);
        physics = (EditText) findViewById(R.id.editphysics);
        biology = (EditText) findViewById(R.id.editbiology);
        chemistry = (EditText) findViewById(R.id.editchemistry);
        geograpy = (EditText) findViewById(R.id.editgeography);
        history = (EditText) findViewById(R.id.edithistory);
        english = (EditText) findViewById(R.id.editenglish);

        // got = (Button) findViewById(R.id.btnDisplay1);
        fab = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                int x = 0;
                mathe = math.getText().toString().toUpperCase();
                alpha.add(mathe);
                physicse = physics.getText().toString().toUpperCase();
                alpha.add(physicse);
                biologye = biology.getText().toString().toUpperCase();
                alpha.add(biologye);
                chemistrye = chemistry.getText().toString().toUpperCase();
                alpha.add(chemistrye);
                geograpye = geograpy.getText().toString().toUpperCase();
                alpha.add(geograpye);
                historye = history.getText().toString().toUpperCase();
                alpha.add(historye);
                englishe = english.getText().toString().toUpperCase();
                alpha.add(englishe);
                if (math.getText().length() == 0
                        && physics.getText().length() == 0
                        && biology.getText().length() == 0
                        && chemistry.getText().length() == 0
                        && geograpy.getText().length() == 0
                        && history.getText().length() == 0
                        && english.getText().length() == 0) {
                    math.setError("Field cannot be left blank.");
                    physics.setError("Field cannot be left blank.");
                    biology.setError("Field cannot be left blank.");
                    chemistry.setError("Field cannot be left blank.");
                    geograpy.setError("Field cannot be left blank.");
                    history.setError("Field cannot be left blank.");
                    english.setError("Field cannot be left blank.");
                    x++;
                } else {

                    if ((mathe.equals("D")
                            || mathe.equals("C")
                            || mathe.equals("P")
                            || mathe.equals("F"))
                            &&(physicse.equals("D")
                            || physicse.equals("C")
                            || physicse.equals("P")
                            || physicse.equals("F"))
                            && (biologye.equals("D")
                            || biologye.equals("C")
                            || biologye.equals("P")
                            || biologye.equals("F"))
                            && (chemistrye.equals("D")
                            || chemistrye.equals("C")
                            || chemistrye.equals("P")
                            || chemistrye.equals("F"))
                            && (geograpye.equals("D")
                            || geograpye.equals("C")
                            || geograpye.equals("P")
                            || geograpye.equals("F"))
                            && (historye.equals("D")
                            || historye.equals("C")
                            || historye.equals("P")
                            || historye.equals("F"))
                            && (englishe.equals("D")
                            || englishe.equals("C")
                            || englishe.equals("P")
                            || englishe.equals("F"))) {
                    } else {
                        math.setError("Ivalid Grades");
                        physics.setError("Ivalid Grades");
                        biology.setError("Ivalid Grades");
                        chemistry.setError("Ivalid Grades");
                        geograpy.setError("Ivalid Grades");
                        history.setError("Ivalid Grades");
                        english.setError("Ivalid Grades");
                        x++;
                    }
                }
                String[] getinput = new String[alleds.size()];
                for (int i = 0; i < alleds.size(); i++) {

                    if (alleds.get(i).getText().length() == 0) {
                        alleds.get(i).setError("Field cannot be left blank.");
                        x++;
                    } else {
                        getinput[i] = alleds.get(i).getText().toString().toUpperCase();
                        if (getinput[i].equals("D")
                                || getinput[i].equals("C")
                                || getinput[i].equals("P")
                                || getinput[i].equals("F")) {

                            alpha.add(getinput[i]);

                        } else {
                            alleds.get(i).setError("Ivalid Grades");
                            alpha.clear();
                            x++;
                        }
                    }

                }


                if (x == 0) {

                    double total=0;
                    for(int m=0; m<alpha.size(); m++){
                        if(alpha.get(m).equals("D")){
                            total = total+0.3;
                        }
                        if(alpha.get(m).equals("C")){
                            total = total+0.2;
                        }
                        if(alpha.get(m).equals("P")){
                            total = total+0.1;
                        }
                        if(alpha.get(m).equals("F")){
                            total = total+0.0;
                        }
                    }

                    DecimalFormat round = new DecimalFormat("#.#");
                    // save user data
                    double j = Math.ceil(total);
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(EnterOlevelResults.this);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("olevel",round.format(total));
                    edit.commit();
                    Toast.makeText(getApplicationContext(), j+" IS YOUR O-LEVEL SCORE", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(EnterOlevelResults.this, AlevelSubjectSelector.class);
                    startActivity(i);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.olevel_selector, menu);
        //getMenuInflater().inflate(R.menu.olevel, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                onBackPressed();
                //selectedSubjects.clear();
                Toast.makeText(getApplicationContext(), "Yeah!", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
