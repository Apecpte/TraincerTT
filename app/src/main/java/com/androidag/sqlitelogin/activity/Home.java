package com.androidag.sqlitelogin.activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.ExercisesFragment;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.androidag.sqlitelogin.fragments.NivelExerFragment;
import com.androidag.sqlitelogin.fragments.RecomFoodFragment;
import com.androidag.sqlitelogin.fragments.RelaxFragment;
import com.androidag.sqlitelogin.fragments.TestFragment;
import com.androidag.sqlitelogin.util.PrefUtil;

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

        navigationView.setItemIconTintList(null);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()) {

                case R.id.menu_home:
                    fragment = new HomeFragment();
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
                case R.id.menu_recom_relax:
                    fragment = new RelaxFragment();
                    fragmentTransaction = true;;
                    break;
                case R.id.menu_recom_ejerc:
                    fragment = new NivelExerFragment();
                    fragmentTransaction = true;;
                    break;
                case R.id.menu_logout:
                    onBackLogin();
                    //PrefUtil.clearBoolean("done",false,Home.this);
                    //startActivity(new Intent(Home.this,Welcome.class));
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

        if(getSupportActionBar()!=null)
        {
            Drawable drawable = getResources().getDrawable(R.drawable.ic_home);
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Drawable newdrawable = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, 50, 50, true));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(newdrawable);
        }

        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault() {
        changeFragment(new HomeFragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                //.addToBackStack(null)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // abrir menu lateral
                //drawerLayout.openDrawer(GravityCompat.START);
                //return true;

                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
            //case R.id.menu_info:

              //  break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    /*
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setTitle("Information");
        builder.setMessage("This alert dialog is just to show a normal informative message to the user, nothing to interact with");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Close!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    } */

    public void onBackLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        //builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Estas seguro de cerrar sesión?");
        //builder.setIcon(R.drawable.ic_logout);
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PrefUtil.clearBoolean("Realizado",false,Home.this);
                startActivity(new Intent(Home.this,Welcome.class));
                //finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
        //dialog.getWindow().setLayout(600, 400);
    }
/*
    public void play (View v){
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this,)
        }
    } */

    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            onBackPressed2();
        }
    }

    public void onBackPressed2() {
        this.moveTaskToBack(true);
    }
}
