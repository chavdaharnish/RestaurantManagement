package com.example.restaurantmanagment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    @Nullable
    Button login;
    TextView signup;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.frag1, container,false);
        View v = inflater.inflate ( R.layout.frag1 , container , false );
        login = (Button) v.findViewById ( R.id.custlogin );
        signup=v.findViewById ( R.id.textsignup );

        login.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getActivity ( ) , Food_Bottom_Nav.class );
                getActivity ( ).startActivity ( intent );
            }
        } );
        signup.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getActivity ( ) , cust_signup.class );
                getActivity ( ).startActivity ( intent );
            }
        } );
        return v;


    }
}

