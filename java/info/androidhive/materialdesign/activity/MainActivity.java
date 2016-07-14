package info.androidhive.materialdesign.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.app.AppController;
import info.androidhive.materialdesign.app.Config;
import info.androidhive.materialdesign.helper.SQLiteHandler;
import info.androidhive.materialdesign.helper.SessionManager;
import info.androidhive.materialdesign.helper.University;
import info.androidhive.materialdesign.helper.UniversityListAdapter;
import info.androidhive.materialdesign.pages.Aboutandhelp;
import info.androidhive.materialdesign.pages.LoginActivity;
import info.androidhive.materialdesign.pages.OLevelSubjectSelector;
import info.androidhive.materialdesign.pages.RegisterActivity;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private RelativeLayout relativeLayout;
    private SQLiteHandler db;
    private SessionManager session;
    private ListView listView;
    private ArrayList<University> universityList;
    private UniversityListAdapter adapter;
    // Progress dialog
    private ProgressDialog pDialog;
    //for passing cid to the next activity
    private static final String TAG_CID = "cid";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";

    String email;
    String name;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        db = new SQLiteHandler(getApplicationContext());
        // Session manager
        session = new SessionManager(getApplicationContext());

        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            TextView tv = (TextView) findViewById(R.id.userName);
            // Fetching user details from SQLite
            HashMap<String, String> user = db.getUserDetails();
            email = user.get("email");
            tv.setText("Welcome" + email);

        }else{
            //TextView tv = (TextView) findViewById(R.id.userName);
            //tv.setText("Mobi crop");
            fetchBananas();

        }


        listView = (ListView) findViewById(android.R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // getting values from selected ListItem
                String cid = ((TextView) view.findViewById(R.id.cid)).getText().toString();
                Toast.makeText(getApplicationContext(), cid, Toast.LENGTH_SHORT).show();
                // Starting new intent
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                // sending pid to next activity
                in.putExtra(TAG_CID, cid);
                startActivityForResult(in, 100);

            }
        });

        universityList = new ArrayList<University>();
        adapter = new UniversityListAdapter(this, universityList);

        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        // Fetching crops from server
        fetchBananas();

        // display the first navigation drawer view on app launch
        displayView(0);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.id.action_logout);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

         if(id == R.id.action_logout){
            Toast.makeText(getApplicationContext(), "logout action is selected!", Toast.LENGTH_SHORT).show();
             logoutUser();
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
    /**
     * Fetching the crops from our server
     * */
    private void fetchBananas() {
        // Showing progress dialog before making request

        //pDialog.setMessage("Fetching crops...");

        //showpDialog();

        // Making json object request
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, Config.URL_UNIVERSITIES, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    JSONArray crops = response.getJSONArray("universities");

                    // looping through all product nodes and storing
                    // them in array list
                    for (int i = 0; i < crops.length(); i++) {

                        JSONObject product = (JSONObject) crops.get(i);

                        String idUniversity = product.getString("idUniversity");
                        String name = product.getString("name");
                        String contact = product.getString("contact");
                        String address = product.getString("v");
                        String details = product.getString("details");
                        String image = product.getString("image");

                        University c = new University(idUniversity, name, contact,address, details, image);
                        universityList.add(c);
                    }

                    // notifying adapter about data changes, so that the
                    // list renders with new data
                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

                // hiding the progress dialog
                //hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                // hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if ((pDialog != null) &&pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                Toast.makeText(getApplicationContext(), title+" action is selected!", Toast.LENGTH_SHORT).show();
                //return true;
                break;
            case 1:
                Intent d = new Intent(MainActivity.this, OLevelSubjectSelector.class);
                startActivity(d);
                break;
            case 2:
                Intent b = new Intent(MainActivity.this, Aboutandhelp.class);
                startActivity(b);
                break;
            case 3:
                Intent g = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(g);
                break;
            case 4:
                Intent s = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(s);
                break;
            case 5:
                final Dialog dialog = new Dialog(this);

                // tell the Dialog to use the dialog.xml as it's layout
                // description
                dialog.setContentView(R.layout.help);

                TextView close = (TextView) dialog.findViewById(R.id.close);
                TextView suggest = (TextView) dialog.findViewById(R.id.suggest);
                TextView help = (TextView) dialog.findViewById(R.id.textView);
                TextView contact = (TextView) dialog.findViewById(R.id.contact);
                TextView rules = (TextView) dialog.findViewById(R.id.rules);
                // dialog.setTitle(R.id.header);
                suggest.setText("Do you have suggestions or"+ "\n" + "questions");
                // if button is clicked, close the custom dialog
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,
                                MainActivity.class);
                        startActivity(i);
                        // dialog.dismiss();
                    }
                });
                // if button is clicked, close the custom dialog
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,
                                MainActivity.class);
                        startActivity(i);
                        // dialog.dismiss();
                    }
                });

                // if button is clicked, close the custom dialog
                contact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,
                                MainActivity.class);
                        startActivity(i);
                        // dialog.dismiss();
                    }
                });
                // if button is clicked, close the custom dialog
                rules.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,
                                MainActivity.class);
                        startActivity(i);
                        // dialog.dismiss();
                    }
                });
                // dialog.setCancelable(true);
                dialog.show();
                break;
            case 6:
                endApplication();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
    private void endApplication() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}