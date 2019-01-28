package com.androidag.sqlitelogin.activity;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.ExercisesFragment;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.androidag.sqlitelogin.fragments.RecomExerFragment;
import com.androidag.sqlitelogin.fragments.RecomFoodFragment;
import com.androidag.sqlitelogin.fragments.TestFragment;
import com.androidag.sqlitelogin.util.PrefUtil;

//Complete
public class Home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        // setFragmentByDefault();

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(Home.this, "Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(Home.this, "Close", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()) {

                    case R.id.menu_home:fragment = new HomeFragment();
                        fragmentTransaction = true;

                        break;
                    case R.id.menu_test:
                        fragment = new TestFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_recom_ali:
                        fragment = new RecomFoodFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_exer:
                        fragment = new ExercisesFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.menu_recom_ejerc:
                        fragment = new RecomExerFragment();
                        fragmentTransaction = true;;
                        break;
                    case R.id.menu_logout:
                        PrefUtil.clearBoolean("done",false,Home.this);
                        startActivity(new Intent(Home.this,Welcome.class));
                        break;
                }

                if (fragmentTransaction) {
                    changeFragment(fragment, item);
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
/*
    private void setFragmentByDefault() {
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    } */

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // abrir menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
