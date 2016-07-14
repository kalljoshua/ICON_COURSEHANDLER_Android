package info.androidhive.materialdesign.pages;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.FloatingActionButton;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;

/**
 * Created by YIYA SERVER on 4/29/2016.
 */
public class OLevelSubjectSelector extends ActionBarActivity {

    Button go_to_Olevel;
    ArrayList<String> selectedSubjects = new ArrayList<String>();
    CheckBox subject, physics, chemistry, biology, geography, techinical,
            Homeeconomics, computer, math, political, fineart, cre, literature,
            addmath, agriculture, kiswahili, french, metalwork, luganda,
            latin, arabic, music, germany;
    FloatingActionButton fab;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectlist);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        techinical = (CheckBox) findViewById(R.id.tdrawing);
        Homeeconomics = (CheckBox) findViewById(R.id.Homeeconomics);
        computer = (CheckBox) findViewById(R.id.computer);
        political = (CheckBox) findViewById(R.id.political);
        fineart = (CheckBox) findViewById(R.id.fineart);
        cre = (CheckBox) findViewById(R.id.cre);
        literature = (CheckBox) findViewById(R.id.literature);
        addmath = (CheckBox) findViewById(R.id.addmath);
        agriculture = (CheckBox) findViewById(R.id.agriculture);
        kiswahili = (CheckBox) findViewById(R.id.kiswahili);
        french = (CheckBox) findViewById(R.id.french);
        metalwork = (CheckBox) findViewById(R.id.metalwork);
        luganda = (CheckBox) findViewById(R.id.luganda);
        latin = (CheckBox) findViewById(R.id.latin);
        arabic = (CheckBox) findViewById(R.id.arabic);
        music = (CheckBox) findViewById(R.id.music);
        germany = (CheckBox) findViewById(R.id.germany);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                StringBuffer result = new StringBuffer();

                if (techinical.isChecked()) {
                    if(!selectedSubjects.contains("Techinical Drawing"))
                        selectedSubjects.add("Techinical Drawing");
                }else{
                    if(selectedSubjects.contains("Techinical Drawing")){
                        selectedSubjects.remove("Techinical Drawing");
                    }
                }

                if (Homeeconomics.isChecked()) {
                    if(!selectedSubjects.contains("Home Economics"))
                        selectedSubjects.add("Home Economics");
                }else{
                    if(selectedSubjects.contains("Home Economics")){
                        selectedSubjects.remove("Home Economics");
                    }
                }
                if (computer.isChecked()) {
                    if(!selectedSubjects.contains("Computer"))
                        selectedSubjects.add("Computer");
                }else{
                    if(selectedSubjects.contains("Computer")){
                        selectedSubjects.remove("Computer");
                    }
                }
                if (political.isChecked()) {
                    if(!selectedSubjects.contains("Political Education"))
                        selectedSubjects.add("Political Education");
                }else{
                    if(selectedSubjects.contains("Political Education")){
                        selectedSubjects.remove("Political Education");
                    }
                }
                if (fineart.isChecked()) {
                    if(!selectedSubjects.contains("Fine Art"))
                        selectedSubjects.add("Fine Art");
                }else{
                    if(selectedSubjects.contains("Fine Art")){
                        selectedSubjects.remove("Fine Art");
                    }
                }
                if (cre.isChecked()) {
                    if(!selectedSubjects.contains("Christian Religious Education"))
                        selectedSubjects.add("Christian Religious Education");
                }else{
                    if(selectedSubjects.contains("Christian Religious Education")){
                        selectedSubjects.remove("Christian Religious Education");
                    }
                }
                if (literature.isChecked()) {
                    if(!selectedSubjects.contains("Literature"))
                        selectedSubjects.add("Literature");
                }else{
                    if(selectedSubjects.contains("Literature")){
                        selectedSubjects.remove("Literature");
                    }
                }
                if (addmath.isChecked()) {
                    if(!selectedSubjects.contains("Additional Math"))
                        selectedSubjects.add("Additional Math");
                }else{
                    if(selectedSubjects.contains("Additional Math")){
                        selectedSubjects.remove("Additional Math");
                    }
                }
                if (agriculture.isChecked()) {
                    if(!selectedSubjects.contains("Agriculture"))
                        selectedSubjects.add("Agriculture");
                }else{
                    if(selectedSubjects.contains("Agriculture")){
                        selectedSubjects.remove("Agriculture");
                    }
                }
                if (kiswahili.isChecked()) {
                    if(!selectedSubjects.contains("Kiswahili"))
                        selectedSubjects.add("Kiswahili");
                }else{
                    if(selectedSubjects.contains("Kiswahili")){
                        selectedSubjects.remove("Kiswahili");
                    }
                }
                if (french.isChecked()) {
                    if(!selectedSubjects.contains("French"))
                        selectedSubjects.add("French");
                }else{
                    if(selectedSubjects.contains("French")){
                        selectedSubjects.remove("French");
                    }
                }
                if (metalwork.isChecked()) {
                    if(!selectedSubjects.contains("Metal Work"))
                        selectedSubjects.add("Metal Work");
                }else{
                    if(selectedSubjects.contains("Metal Work")){
                        selectedSubjects.remove("Metal Work");
                    }
                }
                 if (luganda.isChecked()) {
                    if(!selectedSubjects.contains("Luganda"))
                        selectedSubjects.add("Luganda");
                }else{
                    if(selectedSubjects.contains("Luganda")){
                        selectedSubjects.remove("Luganda");
                    }
                }
                 if (latin.isChecked()) {
                    if(!selectedSubjects.contains("Latin"))
                        selectedSubjects.add("Latin");
                }else{
                    if(selectedSubjects.contains("Latin")){
                        selectedSubjects.remove("Latin");
                    }
                }
                if (arabic.isChecked()) {
                    if(!selectedSubjects.contains("Arabic"))
                        selectedSubjects.add("Arabic");
                }else{
                    if(selectedSubjects.contains("Arabic")){
                        selectedSubjects.remove("Arabic");
                    }
                }
                if (music.isChecked()) {
                    if(!selectedSubjects.contains("Music"))
                        selectedSubjects.add("Music");
                }else{
                    if(selectedSubjects.contains("Music")){
                        selectedSubjects.remove("Music");
                    }
                }
                if (germany.isChecked()) {
                    if(!selectedSubjects.contains("Germany"))
                        selectedSubjects.add("Germany");
                }else{
                    if(selectedSubjects.contains("Germany")){
                        selectedSubjects.remove("Germany");
                    }
                }



                if(selectedSubjects.size()>3 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(OLevelSubjectSelector.this);
                    String Checked = "";
                    for(int i=0; i<selectedSubjects.size(); i++){
                        Checked += selectedSubjects.get(i)+"\n";
                    }

                    builder.setTitle("YOU SELECTED MORE THAN 3 SUBJECTS");
                    builder.setMessage(Checked);

                    builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // Do nothing but close the dialog

                            selectedSubjects.clear();
                            //reload activity
                            startActivity(getIntent());


                        }

                    });


                    AlertDialog alert = builder.create();
                    alert.show();

                }else if(selectedSubjects.size()<1 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(OLevelSubjectSelector.this);
                    String Checked = "";
                    for(int i=0; i<selectedSubjects.size(); i++){
                        Checked += selectedSubjects.get(i)+"\n";
                    }

                    builder.setTitle("YOU NEED TO SELECT AT LEAST ONE SUBJECT");
                    builder.setMessage(Checked);

                    builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            // Do nothing but close the dialog

                            selectedSubjects.clear();
                            //reload activity
                            startActivity(getIntent());


                        }

                    });


                    AlertDialog alert = builder.create();
                    alert.show();

                }else {

                    // String subjects = result.toString();

                    Bundle basket = new Bundle();
                    basket.putStringArrayList("subjects", selectedSubjects);
                    Intent i = new Intent(OLevelSubjectSelector.this, EnterOlevelResults.class);
                    i.putExtras(basket);
                    startActivity(i);

                }

            }
        });
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
            case R.id.back:
                selectedSubjects.clear();
                onBackPressed();
                Toast.makeText(getApplicationContext(), "Yeah!", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
