package com.example.restaurantmanagment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OTP extends Fragment {
    Button button;
    public View onCreateView(@NonNull LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate (R.layout.activity_otp , container , false );
        button = v.findViewById ( R.id.button5 );
        button.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getActivity (),OTPvar.class);
                getActivity ().startActivity ( intent );
            }
        } );
        return v;
    }
}
