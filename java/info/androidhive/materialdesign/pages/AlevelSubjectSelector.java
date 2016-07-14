package info.androidhive.materialdesign.pages;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;

/**
 * Created by YIYA SERVER on 4/30/2016.
 */
public class AlevelSubjectSelector extends ActionBarActivity {

    Button go_to_Alevel;
    ArrayList<String> selectedSubjects = new ArrayList<String>();
    CheckBox subject, physics, chemistry, biology, geography, techinical,
            fnnutrition, computer, math, economics, fineart, cre, literature,
            submath, agriculture, kiswahili, french, metalwork, luganda,
            latin, arabic, music, germany, history;
    FloatingActionButton fab;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subjectlist_a);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Toast.makeText(getApplicationContext(), "O level total: "+sp.getString("olevel", "0"),Toast.LENGTH_LONG).show();

        physics = (CheckBox) findViewById(R.id.chkAndroid);
        chemistry = (CheckBox) findViewById(R.id.chemistry);
        biology = (CheckBox) findViewById(R.id.biology);
        geography = (CheckBox) findViewById(R.id.geography);
        history = (CheckBox) findViewById(R.id.history);
        techinical = (CheckBox) findViewById(R.id.tdrawing);
        fnnutrition = (CheckBox) findViewById(R.id.foodandnutrition);
        computer = (CheckBox) findViewById(R.id.computer);
        math = (CheckBox) findViewById(R.id.chkIos);

        economics = (CheckBox) findViewById(R.id.economics);
        fineart = (CheckBox) findViewById(R.id.fineart);
        cre = (CheckBox) findViewById(R.id.cre);
        literature = (CheckBox) findViewById(R.id.literature);
        submath = (CheckBox) findViewById(R.id.submath);
        agriculture = (CheckBox) findViewById(R.id.agriculture);
        kiswahili = (CheckBox) findViewById(R.id.kiswahili);
        french = (CheckBox) findViewById(R.id.french);
        metalwork = (CheckBox) findViewById(R.id.metalwork);
        luganda = (CheckBox) findViewById(R.id.luganda);
        latin = (CheckBox) findViewById(R.id.latin);
        arabic = (CheckBox) findViewById(R.id.arabic);
        music = (CheckBox) findViewById(R.id.music);
        germany = (CheckBox) findViewById(R.id.germany);
        //germany.setOnCheckedChangeListener();


        // addListenerOnChkIos();

        fab = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                StringBuffer result = new StringBuffer();

                if (physics.isChecked()) {
                    if(!selectedSubjects.contains("Physics"))
                        selectedSubjects.add("Physics");
                }else{
                    if(selectedSubjects.contains("Physics")){
                        selectedSubjects.remove("Physics");
                    }
                }

                if (chemistry.isChecked() ) {
                    if(!selectedSubjects.contains("Chemistry"))
                    selectedSubjects.add("Chemistry");
                }else{
                    if(selectedSubjects.contains("Chemistry")){
                        selectedSubjects.remove("Chemistry");
                    }
                }


                if (biology.isChecked()) {
                    if(!selectedSubjects.contains("Biology"))
                    selectedSubjects.add("Biology");
                }else{
                    if(selectedSubjects.contains("Biology")){
                        selectedSubjects.remove("Biology");
                    }
                }

                if (geography.isChecked()) {
                    if(!selectedSubjects.contains("Geography"))
                    selectedSubjects.add("Geography");
                }else{
                    if(selectedSubjects.contains("Geography")){
                        selectedSubjects.remove("Geography");
                    }
                }

                if (techinical.isChecked()) {
                    if(!selectedSubjects.contains("Techinical Drawing"))
                    selectedSubjects.add("Techinical Drawing");
                }else{
                    if(selectedSubjects.contains("Techinical Drawing")){
                        selectedSubjects.remove("Techinical Drawing");
                    }
                }

                if (history.isChecked()) {
                    if(!selectedSubjects.contains("History"))
                    selectedSubjects.add("History");
                }else{
                    if(selectedSubjects.contains("History")){
                        selectedSubjects.remove("History");
                    }
                }

                if (fnnutrition.isChecked()) {
                    if(!selectedSubjects.contains("Food and Nutrition"))
                    selectedSubjects.add("Food and Nutrition");
                }else{
                    if(selectedSubjects.contains("Food and Nutrition")){
                        selectedSubjects.remove("Food and Nutrition");
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


                if (math.isChecked()) {
                    if(!selectedSubjects.contains("Mathematics"))
                    selectedSubjects.add("Mathematics");
                }else{
                    if(selectedSubjects.contains("Mathematics")){
                        selectedSubjects.remove("Mathematics");
                    }
                }

                if (economics.isChecked()) {
                    if(!selectedSubjects.contains("Economics"))
                    selectedSubjects.add("Economics");
                }else{
                    if(selectedSubjects.contains("Economics")){
                        selectedSubjects.remove("Economics");
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

                if (submath.isChecked()) {
                    if(!selectedSubjects.contains("Sub Math"))
                    selectedSubjects.add("Sub Math");
                }else{
                    if(selectedSubjects.contains("Sub Math")){
                        selectedSubjects.remove("Sub Math");
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

                if(selectedSubjects.size()!=4 ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlevelSubjectSelector.this);
                    String Checked = "";
                    for(int i=0; i<selectedSubjects.size(); i++){
                        Checked += selectedSubjects.get(i)+"\n";
                    }

                    builder.setTitle("YOU SELECTED MORE OR LESS SUBJECTS");
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

                }else{
                    // String subjects = result.toString();
                    if(selectedSubjects.contains("Mathematics")
                            && selectedSubjects.contains("Sub Math")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(AlevelSubjectSelector.this);
                        String Checked = "";
                        for(int i=0; i<selectedSubjects.size(); i++){
                            Checked += selectedSubjects.get(i)+"\n";
                        }

                        builder.setTitle("YOU SELECTED BOTH SUB MATH AND MATHEMATICS");
                        builder.setMessage(Checked);

                        builder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing but close the dialog

                                selectedSubjects.clear();
                                //reload activity
                                startActivity(getIntent());
                            }

                        });


                    }else{
                        Bundle basket = new Bundle();
                        basket.putStringArrayList("subjects", selectedSubjects);
                        Intent i = new Intent(AlevelSubjectSelector.this, EnterALevelResults.class);
                        i.putExtras(basket);
                        startActivity(i);
                    }
                }
            }
        });

    }
}
