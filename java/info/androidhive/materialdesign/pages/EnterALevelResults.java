package info.androidhive.materialdesign.pages;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.activity.MainActivity;

/**
 * Created by YIYA SERVER on 4/30/2016.
 */
public class EnterALevelResults extends ActionBarActivity {

    private Toolbar mToolbar;
    FloatingActionButton fab;
    ArrayList<EditText> yCheck = new ArrayList<EditText>();
    List<EditText> alleds = new ArrayList<EditText>();
    TextView content;
    ArrayList<String> gotBreadalv;
    EditText generalpaper;
    String pp, generalpapere;
    int row, column, i, h;
    String sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_level_results);

        LinearLayout mLayout = (LinearLayout) findViewById(R.id.layouta);
        //getLayoutInflater().inflate(R.layout.alevelsubjects, mLayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //ImageButton ib = (ImageButton) findViewById(R.id.imageButton);


        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Toast.makeText(getApplicationContext(), "O level total: "+sp.getString("olevel", "0"),Toast.LENGTH_LONG).show();
        Bundle gotBasket = getIntent().getExtras();
        gotBreadalv = gotBasket.getStringArrayList("subjects");
        for (int i = 0; i < gotBreadalv.size(); i++) {
            pp = pp + "\n" + gotBreadalv.get(i);

            TextView textView = new TextView(EnterALevelResults.this);
            textView.setText(gotBreadalv.get(i));
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
            mLayout.addView(textView);

            EditText mEdit1 = new EditText(EnterALevelResults.this);

            alleds.add(mEdit1);

            mEdit1.setHint("Enter Grades (A,B,C,D,E,O)");
            mEdit1.setId(i);
            mEdit1.setBackgroundColor(Color.WHITE);
            mEdit1.setTextColor(Color.BLACK);
            mEdit1.setEms(10);
            mEdit1.setTag(gotBreadalv.get(i));
            mEdit1.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,
                    Toolbar.LayoutParams.WRAP_CONTENT));
            mEdit1.setFocusableInTouchMode(true);
            mEdit1.setFocusable(true);
            mEdit1.requestFocus();
            mLayout.addView(mEdit1);
            yCheck.add(mEdit1);
        }

        TextView textView = new TextView(EnterALevelResults.this);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        textView.setPadding(17,0,0,0);
        textView.setTextSize(20);
        mLayout.addView(textView);


        gotBasket.getStringArrayList("subjects").clear();
        generalpaper = (EditText) findViewById(R.id.editgeneralpaper);

        fab = (FloatingActionButton) findViewById(R.id.fab4);
        fab.setOnClickListener(new View.OnClickListener() {

            @SuppressWarnings({ "unchecked" })
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int x = 0;

                generalpapere = generalpaper.getText().toString().toUpperCase();
                if (generalpaper.getText().length() == 0) {
                    generalpaper.setError("Field cannot be left blank.");

                    x++;
                } else {
                    if (generalpapere.equals("D") || generalpapere.equals("C")
                            || generalpapere.equals("P")
                            || generalpapere.equals("F")) {
                    } else {
                        generalpaper.setError("Invalid Grades");
                        x++;
                    }
                }
                String[] getinput = new String[alleds.size()];
                String[] getsubs = new String[alleds.size()];

                for (int i = 0; i < alleds.size(); i++) {
                    if (alleds.get(i).getText().toString().toUpperCase()
                            .equals("F")) {
                        String news = "Z";
                        alleds.get(i).setText(news);

                    }
                    if(alleds.get(i).getTag().toString().equals("Computer")){
                        if (alleds.get(i).getText().length() == 0) {
                            alleds.get(i).setError("Field cannot be left blank.");
                            x++;
                        } else {
                            if (getinput[i].equals("D") || getinput[i].equals("C")
                                    || getinput[i].equals("P")
                                    || getinput[i].equals("F")) {
                            } else {
                                alleds.get(i).setError("Ivalid Grades");
                                x++;
                            }
                        }
                    }else if(alleds.get(i).getTag().toString().equals("Sub Math")){
                        if (alleds.get(i).getText().length() == 0) {
                            alleds.get(i).setError("Field cannot be left blank.");
                            x++;
                        } else {
                            if (getinput[i].equals("D") || getinput[i].equals("C")
                                    || getinput[i].equals("P")
                                    || getinput[i].equals("F")) {
                            } else {
                                alleds.get(i).setError("Ivalid Grades");
                                x++;
                            }
                        }
                    }{
                        getinput[i] = alleds.get(i).getText().toString()
                                .toUpperCase();

                        getsubs[i] = alleds.get(i).getTag().toString();
                    }
                    if (alleds.get(i).getText().length() == 0) {
                        alleds.get(i).setError("Field cannot be left blank.");
                        x++;
                    } else {
                        if (getinput[i].equals("A") || getinput[i].equals("B")
                                || getinput[i].equals("C")
                                || getinput[i].equals("D")
                                || getinput[i].equals("E")
                                || getinput[i].equals("O")
                                || getinput[i].equals("Z")) {

                        } else {
                            alleds.get(i).setError("Ivalid Grades");
                            x++;
                        }
                    }

                }

                //calculating principle passes from entered results
                int total = 0;
                for (int m = 0; m < getinput.length; m++) {
                    if (getinput[m].equals("A") || getinput[m].equals("B")
                            || getinput[m].equals("C")
                            || getinput[m].equals("D")
                            || getinput[m].equals("E")) {
                        total = total + 1;
                    }

                }

                if (total < 2) {

                    final Dialog dialog = new Dialog(EnterALevelResults.this);

                    // tell the Dialog to use the dialog.xml as it's layout
                    // description
                    dialog.setContentView(R.layout.error_one);

                    TextView title = (TextView) dialog.findViewById(R.id.title);
                    title.setText("SORRY!! UNFORTUNATELY");
                    // dialog.setTitle(R.id.header);

                    TextView txt = (TextView) dialog.findViewById(R.id.txt);
                    ImageView image = (ImageView) dialog
                            .findViewById(R.id.image);
                    image.setImageResource(R.drawable.blue_gradient);

                    txt.setText("YOU CANNOT QUALIFY FOR UNDERGRADUATE PROGRAMS"
                            + "\n" + "PLEASE TRY OUT DIPLOMA PROGRAMS");

                    Button dialogButton = (Button) dialog
                            .findViewById(R.id.dialogButtonOK);
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(EnterALevelResults.this,
                                    MainActivity.class);
                            startActivity(i);
                            // dialog.dismiss();
                        }
                    });
                    // dialog.setCancelable(true);
                    dialog.show();

                } else {

                    if (x == 0) {

                        String[][] grades = new String[getsubs.length][2];
                        for (row = 0; row < getsubs.length; row++) {

                            for (column = 0; column < 2; column++) {
                                if (column == 0) {

                                    grades[row][column] = getsubs[row];

                                } else {
                                    grades[row][column] = getinput[row];
                                }

                            }
                            i++;

                        }

                        // Sort the array by subject grades or column 3
                        Arrays.sort(grades, new ColumnComparator(1));

                        // Print the sorted array
                        String[] Asubjects = new String[getsubs.length];
                        String[] Agrades = new String[getsubs.length];
                        for (int i = 0; i < grades.length; i++) {

                            for (int j = 0; j < 2; j++) {
                                if (j == 0) {

                                    Asubjects[i] = grades[i][j];

                                } else {
                                    Agrades[i] = grades[i][j];
                                }
                            }

                        }
                        String All=null;
                        Bundle basket = new Bundle();

                        String BestDone = Asubjects[0];
                        String BestDonegrade = Agrades[0];
                        All = "["+BestDone+":"+BestDonegrade+"], ";
                        basket.putString("subjects", BestDone);
                        basket.putString("grades", BestDonegrade);

                        String SecondBest = Asubjects[1];
                        String SecondBestgrade = Agrades[1];
                        All +="["+SecondBest+":"+SecondBestgrade+"], ";

                        basket.putString("secondsub", SecondBest);
                        basket.putString("secondgrad", SecondBestgrade);

                        String thirdBest = Asubjects[2];
                        String thirdBestgrade = Agrades[2];
                        All +="["+thirdBest+":"+thirdBestgrade+"], ";

                        basket.putString("thirdsub", thirdBest);
                        basket.putString("thirdgrad", thirdBestgrade);

                        String fourthBest = Asubjects[3];
                        String fourthBestgrade = Agrades[3];
                        All +="["+fourthBest+":"+fourthBestgrade+"], ";

                        basket.putString("foursub", fourthBest);
                        basket.putString("fourgrad", fourthBestgrade);

                        String Generalp = "General Paper";
                        String Generalgrade = generalpapere;
                        All +="["+Generalp+":"+Generalgrade+"], ";

                        basket.putString("gpsub", Generalp);
                        basket.putString("gpgrad", Generalgrade);
                        Log.d("Finished Pushing Info: ",All);

                        Intent goback = new Intent(getApplicationContext(),Calculate.class);
                        goback.putExtra("content", basket);
                        startActivity(goback);
                    }
                }
            }

            // Class that extends Comparator
            @SuppressWarnings("rawtypes")
            class ColumnComparator implements Comparator {
                int columnToSort;

                ColumnComparator(int columnToSort) {
                    this.columnToSort = columnToSort;
                }

                // overriding compare method
                public int compare(Object o1, Object o2) {
                    String[] row1 = (String[]) o1;
                    String[] row2 = (String[]) o2;
                    // compare the columns to sort
                    return row1[columnToSort].compareTo(row2[columnToSort]);
                }

            }
        });
    }
}
