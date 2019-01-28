package com.androidag.sqlitelogin.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.database.DatabaseHelper;
import com.androidag.sqlitelogin.model.User;
import com.androidag.sqlitelogin.util.DateFormate;
//Complete
public class Update extends AppCompatActivity implements View.OnClickListener {

    private EditText et_first_name;
    private EditText et_last_name;
    private EditText et_last_name_two;
    private EditText et_username;
    //private EditText et_mobile_number;
    private EditText et_birth_date;
    //private EditText et_email;
    private User user;
    private Intent i;
    private int id;
    private Button btn_update;
    private ImageButton btn_image;
    private DatabaseHelper data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        et_last_name_two = (EditText) findViewById(R.id.et_last_name_two);
        et_username = (EditText) findViewById(R.id.et_username);
        //et_mobile_number = (EditText) findViewById(R.id.et_mobile_number);
        //et_email = (EditText) findViewById(R.id.et_email);
        et_birth_date = (EditText) findViewById(R.id.et_birth_date);

        //Take value from RegisterActivity  -- Intent Through
        i = getIntent();
        user = (User) getIntent().getSerializableExtra("User");

        id = user.getId();
        String first_name = user.getFirst_name();
        String last_name = user.getLast_name();
        String last_name_two = user.getLast_name_two();
        String username = user.getUsername();
        //String mobile_number = user.getMobile_number();
        //String email = user.getEmail();
        String birth_date = user.getBirthdate();

        // ************************* OR ****************************
        /*id = i.getIntExtra("User",0);
        String first_name = i.getStringExtra("UserF");
        String last_name = i.getStringExtra("UserL");
        String mobile_number = i.getStringExtra("UserM");
        String email = i.getStringExtra("UserE");
        String birth_date = i.getStringExtra("UserB");*/

        // Set the value inside EdiText field
        et_first_name.setText(first_name);
        et_last_name.setText(last_name);
        et_last_name_two.setText(last_name_two);
        et_username.setText(username);
        //et_mobile_number.setText(mobile_number);
        //et_email.setText(email);
        et_birth_date.setText(birth_date);
        btn_image = (ImageButton) findViewById(R.id.image_calender);
        btn_update = (Button) findViewById(R.id.btnUpdate);

        btn_image.setOnClickListener(this);
        btn_update.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnUpdate)
        {
            data = new DatabaseHelper(this);

            // Set the editText value inside User class
            user.setId(id);
            user.setFirst_name(et_first_name.getText().toString());
            user.setLast_name(et_last_name.getText().toString());
            user.setLast_name_two(et_last_name_two.getText().toString());
            user.setUsername(et_username.getText().toString());
            //user.setMobile_number(et_mobile_number.getText().toString());
            //user.setEmail(et_email.getText().toString());
            user.setBirthdate(et_birth_date.getText().toString());
            user.setGender(user.getGender());
            user.setPassword(user.getPassword());
            user.setConfirm_password(user.getConfirm_password());
            data.onUpdate(user);

            startActivity(new Intent(this,Display.class));
            Toast.makeText(this, "Insert Button was clicked", Toast.LENGTH_SHORT).show();

        }else if (view.getId() == R.id.image_calender) {
            //DateFormate Class using from open ***** calendar *****
            DialogFragment dialogFragment = new DateFormate();
            dialogFragment.show(getFragmentManager(), "DatePicker");
        }
    }
}

