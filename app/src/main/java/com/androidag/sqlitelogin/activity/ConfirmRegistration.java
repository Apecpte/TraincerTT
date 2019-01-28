package com.androidag.sqlitelogin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.database.DatabaseHelper;
import com.androidag.sqlitelogin.model.User;
import com.androidag.sqlitelogin.util.Constant;

//Complete
public class ConfirmRegistration extends AppCompatActivity {

    private Button btn_confRegister;
    private EditText et_otp;
    DatabaseHelper helper;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_registration);

        // Find the widget from xml File(View e.g= editText,Button)
        et_otp = (EditText) findViewById(R.id.et_otp);
        btn_confRegister = (Button) findViewById(R.id.btn_confRegister);

        //Database class called
        helper = new DatabaseHelper(this);

        //Take value from RegisterActivity  -- Intent Through
        user = (User) getIntent().getSerializableExtra("Model");

        // Buttn Events
        //Button was clicked when otp was right register was complete and go to MainActivity otherwise otp was wrong they describe Error(otp was wrong).
        btn_confRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Constant is java class and otp has one variable and that store random data from RegisterActivity
                //below line check the condition editText value and otp was matched ... then go to LoginPage. (Otherwise give Error.)
                if (!et_otp.getText().toString().isEmpty()){

                    //Below line insert data into database.
                    helper.onInsert(user);
                    startActivity(new Intent(ConfirmRegistration.this,MainActivity.class));
                    Toast.makeText(ConfirmRegistration.this, "You are SuccTessfully Register your Data", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    et_otp.setError("Otp was wrong");
                }
            }
        });
    }
}
