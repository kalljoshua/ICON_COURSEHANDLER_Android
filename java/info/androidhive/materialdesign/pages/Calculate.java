package info.androidhive.materialdesign.pages;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import info.androidhive.materialdesign.R;

public class Calculate extends Activity {

    private ProgressDialog pDialog;
    String sid;
    private JSONArray courses = null;
    JSONParser jParser = new JSONParser();
    private ArrayList<HashMap<String, String>> courseList;
    private static final String READ_COURSES_URL = "http://10.0.2.2/ch/getData.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        new LoadAllcourses().execute();

    }


    class LoadAllcourses extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         **/
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        /**
         * getting All courses from url
         */
        protected String doInBackground(String... args) {

            String grade, sub;
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("grade1", "2"));


            // getting JSON string from URL
            JSONObject json = jParser.makeHttpRequest(READ_COURSES_URL, "GET",
                    params);

            // Check your log cat for JSON reponse
            Log.d("All Courses: ", json.toString());

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         **/
        protected void onPostExecute(String file_url) {


        }
    }
}