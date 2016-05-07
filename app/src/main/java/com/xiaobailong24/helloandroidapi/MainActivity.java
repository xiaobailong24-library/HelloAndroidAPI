package com.xiaobailong24.helloandroidapi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView myWebView;
    AdView mAdView; //google AdMob
    Menu navigationMenu;
    private boolean menuFlag = false;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // TODO: 2016/5/6 To load a web page in the WebView, use loadUrl()
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://xiaobailong24.github.io");

        // TODO: 2016/5/6  Google AdMob
        mAdView = (AdView) findViewById(R.id.adView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFabView();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationMenu = navigationView.getMenu();
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
        //        initNavigationMenu();

        if (id == R.id.nav_home) {
            // Handle the home action
            // TODO: 2016/5/6 To load a web page in the WebView, use loadUrl()
            myWebView.loadUrl("http://xiaobailong24.github.io");

            // TODO: 2016/5/6 Load Google AdMob
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_introduction) {    // TODO: 2016/5/6   Android Introduction
            menuFlag = !menuFlag;
            navigationMenu.setGroupVisible(R.id.nav_introduction_details, menuFlag);
            myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-Introduction/");
        }
        if (menuFlag) {
            if (id == R.id.nav_introduction_app_fundamentals) {
                myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-App-Fundamentals/");
            } else if (id == R.id.nav_introduction_device_compatibility) {
                myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-Device-Compatibility/");
            } else if (id == R.id.nav_introduction_system_permissions) {
                myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-System-Permissions/");
            }
        }
        //        else if (id == R.id.nav_introduction_app_fundamentals) {
        //
        //        }
        // TODO: 2016/5/6   Android Introduction
        //        else if (id == R.id.nav_introduction) {
        //            myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-Introduction/");
        //        } else if (id == R.id.nav_introduction_app_fundamentals) {
        //            myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-App-Fundamentals/");
        //        } else if (id == R.id.nav_introduction_device_compatibility) {
        //            myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-Device-Compatibility/");
        //        } else if (id == R.id.nav_introduction_system_permissions) {
        //            myWebView.loadUrl("http://xiaobailong24.github.io/2016/04/21/Android-System-Permissions/");
        //        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // TODO: 2016/5/7 Initialize fab
    private void initFabView(){
        FloatingActionButton upTopFab = (FloatingActionButton) findViewById(R.id.fab_uptop);
        FloatingActionButton backFab = (FloatingActionButton) findViewById(R.id.fab_back);   //上一页
        FloatingActionButton forwardFab = (FloatingActionButton) findViewById(R.id.fab_forward);  //下一页
        upTopFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myWebView.scrollTo(0, 0);
                Snackbar.make(view, "返回顶部", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        backFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWebView.goBack();
                Snackbar.make(v, "上一页", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
        forwardFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myWebView.goForward();
                Snackbar.make(v, "下一页", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });
    }

}
