package com.androidag.sqlitelogin.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.database.DatabaseHelper;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.androidag.sqlitelogin.model.User;
import com.androidag.sqlitelogin.util.PrefUtil;

//Complete
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences prefs;

    private Button btn_linkToRegister,btn_login;
    private EditText et_username;
    //private EditText et_email;
    private EditText et_password;
    private DatabaseHelper helper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
        // Find the widget from xml File(View e.g= editText,Button)
        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.btnLogin);
        btn_linkToRegister = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        setCredentialsIfExist();

        // Events
        btn_login.setOnClickListener(this);
        btn_linkToRegister.setOnClickListener(this);

        // GetData Preference
        if (PrefUtil.getbooleanPref("done",MainActivity.this)) {
            startActivity(new Intent(MainActivity.this,Home.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {

        // Database Class
        helper = new DatabaseHelper(this);

        if (view.getId() == R.id.btnLogin) {
            String username = et_username.getText().toString();
            String password = et_password.getText().toString();
            user = new User();

            //
            if(et_username.getText().toString().matches("\\d+(?:\\.\\d+)?")){
                //Check Condition -- Mobile number (When mobile number is valid from database)
                if (helper.loginValidation(username,password)) {
                    PrefUtil.putbooleanPref("done",true,MainActivity.this);
                    saveOnPreferences(username, password);
                    Toast.makeText(this, "You are Successfully Register your Data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this,Home.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
            //Check Condition -- Email Id (When emailId is valid from database)
            else if (helper.loginValidation(username,password)) {
                PrefUtil.putbooleanPref("done",true,MainActivity.this);
                saveOnPreferences(username, password);
                Toast.makeText(this, "You are Successfully Register your Data", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Home.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }else {
                et_username.setError("Password not matched");
            }

        }else if (view.getId() == R.id.btnLinkToRegisterScreen) {
            startActivity(new Intent(this,Register.class));
        }
    }

    private void setCredentialsIfExist () {
        String user = getUserPrefs();
        String pass = getPassPrefs();
        if (!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
            et_username.setText(user);
            et_password.setText(pass);
        }
    }

    private void saveOnPreferences( String user, String pass){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Username", user);
        editor.putString("Password", pass);
        editor.apply();
    }

    private String getUserPrefs(){
        return prefs.getString("Username", "");
    }

    private String getPassPrefs(){
        return prefs.getString("Password", "");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

