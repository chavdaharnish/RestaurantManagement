package com.example.restaurantmanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class New_Login extends AppCompatActivity {
    Button email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_new__login );
        BottomNavigationView bottomNav = findViewById ( R.id.bottom_navigation1 );
        bottomNav.setOnNavigationItemSelectedListener (navListner );
        bottomNav.setSelectedItemId ( R.id.email );

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener ( ) {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId ( )) {
                        case R.id.email:
                            selectedFragment = new Email ( );
                            break;
                        case R.id.otp:
                            selectedFragment = new OTP ( );
                            break;
                    }
                    getSupportFragmentManager ( ).beginTransaction ( ).replace ( R.id.frameLayout , selectedFragment ).commit ( );
                    return true;


                }
            };

}