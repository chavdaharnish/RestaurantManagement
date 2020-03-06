package com.example.restaurantmanagment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class chef_login extends AppCompatActivity {
    EditText Name, password;
    Button Login;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_chef_login );
        Name = findViewById ( R.id.cuser );
        password = findViewById ( R.id.cpass );
        Login = findViewById ( R.id.cbtn);
        databaseReference = FirebaseDatabase.getInstance ().getReference ("LOGIN");

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
              //  validate(Name.getText().toString() ,password.getText().toString());
                addDetails ();
                        Intent intent=new Intent ( chef_login.this,Food_Bottom_Nav.class);
                        startActivity ( intent );

            }
        });
    }

    public void addDetails(){
       final String Chefname=Name.getText ().toString ().trim ();
       String Chefpass=password.getText ().toString ().trim ();
    if(!TextUtils.isEmpty ( Chefname )&& !TextUtils.isEmpty ( Chefpass )){
        String id=databaseReference.push ().getKey ();
            Database database=new Database ( id,Chefname,Chefpass);
            databaseReference.child ( id ).setValue ( database );
        Toast.makeText ( this,"added", Toast.LENGTH_SHORT ).show ();

    }
    else{
        Toast.makeText ( this,"Not added", Toast.LENGTH_SHORT ).show ();
    }
    }

}




