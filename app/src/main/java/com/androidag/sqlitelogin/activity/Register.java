package com.androidag.sqlitelogin.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.database.DatabaseHelper;
import com.androidag.sqlitelogin.model.User;
import com.androidag.sqlitelogin.util.Constant;
import com.androidag.sqlitelogin.util.DateFormate;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Complete
public class Register extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    String TAG=getClass().getSimpleName();
    private EditText et_last_name;
    private EditText et_last_name_two;
    private EditText et_username;
    //private EditText et_email;
    private EditText et_password;
    private Button btn_register;
    private Button btn_LinkToLogin;
    private EditText et_first_name;
    //private EditText et_mobile_number;
    private EditText et_confirm_password;
    private RadioGroup rg;
    private EditText et_birth_date;
    String gender = "Male";
    private ImageButton btn_image;
    Random random;
    int otp_number;
    //String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private DatabaseHelper helper;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Find the widget from xml File(View e.g= editText,Button)
        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        et_last_name_two = (EditText) findViewById(R.id.et_last_name_two);
        et_username = (EditText) findViewById(R.id.et_username);
        //et_mobile_number = (EditText) findViewById(R.id.et_mobile_number);
        //et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_confirm_password = (EditText) findViewById(R.id.et_confirm_password);
        rg = (RadioGroup) findViewById(R.id.rg);
        et_birth_date = (EditText) findViewById(R.id.et_birth_date);
        btn_image = (ImageButton) findViewById(R.id.image_calender);
        btn_register = (Button) findViewById(R.id.btnRegister);
        btn_LinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

        //**** Events ***** (Button & Radio Group)
        btn_image.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
        btn_register.setOnClickListener(this);
        btn_LinkToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btnRegister) {
            //Database class called
            helper = new DatabaseHelper(this);
            //Setter Getter class called
            user = new User();

            //Set the value inside User Class(setterGetter class)
            user.setFirst_name(et_first_name.getText().toString());
            user.setLast_name(et_last_name.getText().toString());
            user.setLast_name_two(et_last_name_two.getText().toString());
            user.setUsername(et_username.getText().toString());
            //user.setMobile_number(et_mobile_number.getText().toString());
            //user.setEmail(et_email.getText().toString());
            user.setPassword(et_password.getText().toString());
            user.setConfirm_password(et_confirm_password.getText().toString());
            user.setGender(gender);
            user.setBirthdate(et_birth_date.getText().toString());

            /* Check the condition
             1> All Data are not Empty
             2> Email Pattern Condition check
             3> OTP Generate
             4> mobile number and email are  varify they already exist or not in database.
             5> Password & confirm password are matched or not.*/

            if (et_first_name.getText().toString().isEmpty()) {
                et_first_name.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
                et_first_name.setError("Dato vacío");
            }
            else if (et_last_name.getText().toString().isEmpty()) {
                et_last_name.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
                et_last_name.setError("Dato vacío");
            }else if (et_last_name_two.getText().toString().isEmpty()) {
                et_last_name_two.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
                et_last_name_two.setError("Dato vacío");
            }
            //else if (et_mobile_number.getText().toString().isEmpty()) {
              //  et_mobile_number.setError("Data Empty");
           // }
            //else if (et_email.getText().toString().isEmpty()) {
              //  et_email.setError("Data Empty");
           // }
            // 2> Below condition check the ***********Email Pattern***********
            //else if (!et_email.getText().toString().matches(emailPattern)) {
              //  et_email.setError("Invalid");
            //}
            else if (et_username.getText().toString().isEmpty()) {
                et_username.setFilters(new InputFilter[] { new InputFilter.LengthFilter(25) });
              et_username.setError("Invalido");
            }
            else if (et_password.getText().toString().isEmpty()) {
                et_password.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
                et_password.setError("Dato vacío");
            }else if (et_birth_date.getText().toString().isEmpty()) {
                et_birth_date.setError("Dato vacío");
            }

            else {
                // Below condition check ********* Email already exit or not in database**************
                if (!helper.isUsernameExist(user.getUsername())) {

                    // Below condition check ******* Password and confirm password are matched or not ***************
                    if (et_password.getText().toString().equalsIgnoreCase(et_confirm_password.getText().toString())) {

                        //Generate random  otp number
                        //random = new Random();
                        //otp_number=random.nextInt(10000);
                        //Log.i(TAG, "onClick: "+otp_number);
                        //Constant.otp= String.valueOf(otp_number);

                        // Below code ****** all setData(User) are send to confirmRegister activity****
                        helper.onInsert(user);
                        Intent i = new Intent(Register.this,MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        Toast.makeText(this, "¡Registrado correctamente!", Toast.LENGTH_LONG).show();
                        startActivity(i);i.putExtra("Model",user);
                        finish();
                    } else {
                        et_confirm_password.setError("Contraseña incorrecta");
                    }
                } else {
                        et_username.setError("El nombre de usuario ya está en uso");
                    }
            }

            // Button Event
        }else if (view.getId() == R.id.btnLinkToLoginScreen) {
            startActivity(new Intent(this,MainActivity.class));
        }else if (view.getId() == R.id.image_calender) {
            DialogFragment dialogFragment = new DateFormate();
            dialogFragment.show(getFragmentManager(), "DatePicker");
        }
    }

    // RadioGroup Event (they check the condition which gender ...Male or Female)
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i)
        {
            case R.id.rb_female :
                gender= "Female";
                break;
            case R.id.rb_male :
                gender= "Male";
                break;
        }
    }

}
