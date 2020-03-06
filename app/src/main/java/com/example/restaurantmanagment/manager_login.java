package com.example.restaurantmanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class manager_login extends AppCompatActivity {
    EditText Name, password;
    Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_manager_login );

        Name = findViewById ( R.id.muser );
        password = findViewById ( R.id.mpass );
        Login = findViewById ( R.id.mbtn);

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString() ,password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if((userName.equals("Manager")) && (userPassword.equals("manager"))) {
                Intent intent = new Intent ( manager_login.this , TableFormate.class );
                startActivity ( intent );
            } else {
                Toast.makeText (manager_login.this , "Invalid Details" , Toast.LENGTH_SHORT ).show ( );
            }
        }
    }


