package com.c1ctech.navigationdrawerexample;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.c1ctech.navigationdrawerexample.fragment.ToolsFragment;
import com.c1ctech.navigationdrawerexample.fragment.GalleryFragment;
import com.c1ctech.navigationdrawerexample.fragment.HomeFragment;
import com.c1ctech.navigationdrawerexample.fragment.ImportFragment;
import com.c1ctech.navigationdrawerexample.fragment.SlideshowFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting home as default fragment
        getSupportActionBar().setTitle("Home");
        HomeFragment home_fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, home_fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        //called when any of the given navigation items selected
        navigationView.setNavigationItemSelectedListener(this);
    }

    //onBackPress operation
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if navigationDrawer is open then it will close it
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportActionBar().setTitle("Home");
            HomeFragment home_fragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, home_fragment).commit();

        } else if (id == R.id.nav_import) {
            getSupportActionBar().setTitle("Import");
            ImportFragment import_fragment = new ImportFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, import_fragment).commit();
        } else if (id == R.id.nav_gallery) {
            getSupportActionBar().setTitle("Gallery");
            GalleryFragment gallery_fragment = new GalleryFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, gallery_fragment).commit();
        } else if (id == R.id.nav_slideshow) {
            getSupportActionBar().setTitle("Slideshow");
            SlideshowFragment slideshow_fragment = new SlideshowFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, slideshow_fragment).commit();
        } else if (id == R.id.nav_tools) {
            getSupportActionBar().setTitle("Tools");
            ToolsFragment tools_fragment = new ToolsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, tools_fragment).commit();
        } else if (id == R.id.nav_share) {

            Intent intent = new Intent(this, ShareActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this, SendActivity.class);
            startActivity(intent);
        }

        //when item is selected then it will close the drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
