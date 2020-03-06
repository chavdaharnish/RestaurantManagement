package com.example.restaurantmanagment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Food_Bottom_Nav extends AppCompatActivity {
    public static EditText table;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_food__bottom__nav );
        BottomNavigationView bottomNav = findViewById ( R.id.bottom_navigation );
        bottomNav.setOnNavigationItemSelectedListener (navListner );
        bottomNav.setSelectedItemId ( R.id.home );

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener ( ) {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId ( )) {
                        case R.id.account:
                            selectedFragment = new AccountFragment ( );
                            break;
                        case R.id.home:
                            selectedFragment = new HomeFragment ( );
                            break;

                        case R.id.cart:
                            selectedFragment = new CartFragment ( );
                            break;
                    }
                    getSupportFragmentManager ( ).beginTransaction ( ).replace ( R.id.Fragment_container , selectedFragment ).commit ( );
                    return true;


                }
            };

}
