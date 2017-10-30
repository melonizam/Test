package com.notes.tyrocity.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.notes.tyrocity.test.fragments.MainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        MainFragment mainFragment = new MainFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, mainFragment);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void displaySelectedScreen(int id) {

        Fragment fragment = null;

        switch (id) {
            case R.id.nav_home:

                fragment = new MainFragment();
                break;

            case R.id.nav_sci_11:

                // Start NewActivity.class
//                Intent myIntent = new Intent(this, SearchcarActivity.class);
//                myIntent.putExtra("ALLVEHICLES", "");
//
//
//                startActivity(myIntent);
//
//                break;


            case R.id.nav_man_11:
//                fragment = new WebViewFragment();
//                Bundle fBundle = new Bundle();
////                fBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_dynamic.php?pid=1");
//                fBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_inHouseFinance.php");
//                fragment.setArguments(fBundle);
//                break;


            case R.id.nav_hum_11:
//                fragment = new WebViewFragment();
//                Bundle gBundle = new Bundle();
////                fBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_dynamic.php?pid=1");
//                gBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_buyers_guide.php?slug=tips-for-buying");
//                fragment.setArguments(gBundle);
//                break;

            case R.id.nav_bba:
//                fragment = new WebViewFragment();
//                Bundle hBundle = new Bundle();
////                fBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_dynamic.php?pid=1");
//                hBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_buyers_guide.php?slug=inspection");
//                fragment.setArguments(hBundle);
//                break;

            case R.id.nav_ce:
//                fragment = new WebViewFragment();
//                Bundle iBundle = new Bundle();
////                fBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_dynamic.php?pid=1");
//                iBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_buyers_guide.php?slug=test-drive");
//                fragment.setArguments(iBundle);
//                break;

            case R.id.nav_law:
//                fragment = new WebViewFragment();
//                Bundle jBundle = new Bundle();
////                fBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_dynamic.php?pid=1");
//                jBundle.putString("URL", "http://popularcarsoman.dev.techneek.in/app_page_buyers_guide.php?slug=close-the-deal");
//                fragment.setArguments(jBundle);
//                break;

            case R.id.nav_it:
//                fragment = new ThirdPartyFinanceFragment();
//                break;


        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
