package com.example.restaurantmanagment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.restaurantmanagment.ui.main.PageViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Scanner;

public class HomeFragment extends Fragment{
        CardView punjabicard,southcard,chinesecard,roticard,pizzacard;
        Button qr;
        static TextView table;
    DatabaseReference databaseReference;
    TextView Punjabi,Southindian,Chinese,Roti,Pizza;
    //private PageViewModel punjabi,southindian,chinese,roti,pizza;

    @Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate ( R.layout.home_activity , container , false );
        punjabicard = (CardView) v.findViewById ( R.id.punjabicard );
        southcard = (CardView) v.findViewById ( R.id.southcard );
        chinesecard = (CardView) v.findViewById ( R.id.chinesecard );
        roticard = (CardView) v.findViewById ( R.id.roticard );
        qr=v.findViewById ( R.id.qrcode );
        table=v.findViewById ( R.id.carttext );
        databaseReference= FirebaseDatabase.getInstance ().getReference ("MENU");

        Punjabi=v.findViewById ( R.id.punjabi );
        Southindian=v.findViewById ( R.id.southindian );
        Chinese=v.findViewById ( R.id.chinese );
        Roti=v.findViewById ( R.id.roti );

    punjabicard.setOnClickListener ( new View.OnClickListener ( ) {
@Override
public void onClick(View v) {
        Intent intent = new Intent ( getActivity ( ) , Card_Punjabi.class );
        getActivity ( ).startActivity ( intent );
        }
        } );
    southcard.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent ( getActivity ( ) , Card_South.class );
                        getActivity ( ).startActivity ( intent );
                }
        } );
    chinesecard.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent ( getActivity ( ) , Card_Chinese.class );
                        getActivity ( ).startActivity ( intent );
                }
        } );
    roticard.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent ( getActivity ( ) , Card_Roti.class );
                        getActivity ( ).startActivity ( intent );
                }
        } );
    qr.setOnClickListener ( new View.OnClickListener ( ) {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent ( getActivity ( ) , QRCode.class );
            getActivity ( ).startActivity ( intent );

        }
    } );
    addDetails ();
        return v;
        }

        public void addDetails(){
            String punjabi=Punjabi.getText ().toString ().trim ();
            String southIndian=Southindian.getText ().toString ().trim ();
            String chinese=Chinese.getText ().toString ().trim ();
            String roti=Roti.getText ().toString ().trim ();

            if(!TextUtils.isEmpty ( punjabi)) {
                //String id = databaseReference.push( ).getKey ( );
                Database database=new Database (punjabi,southIndian,chinese,roti);
                databaseReference.setValue( database );
            }

        }


}

