package com.example.restaurantmanagment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Card_Roti extends AppCompatActivity {

    static HashMap<String,Integer> selection = new HashMap<>();
    static HashMap<String,Integer> price = new HashMap<>();


    TextView text1,text2,text3,text4,text5;
    CheckBox c1,c2,c3,c4,c5;
    TextView uttapam,dosa,idli,pongal,vada;
    TextView price1,price2,price3,price4,price5;
    Button add;
    int counter1=0,counter2=0,counter3=0,counter4=0,counter5=0;
    DatabaseReference databaseReference1,databaseReference2,databaseReference3,databaseReference4,databaseReference5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_card__roti );

        c1=findViewById ( R.id.rcheck1 );
        c2=findViewById ( R.id.rcheck2 );
        c3=findViewById ( R.id.rcheck3 );
        c4=findViewById ( R.id.rcheck4 );
        c5=findViewById ( R.id.rcheck5 );
        text1=findViewById ( R.id.rtext1 );
        text2=findViewById ( R.id.rtext2 );
        text3=findViewById ( R.id.rtext3 );
        text4=findViewById ( R.id.rtext4 );
        text5=findViewById ( R.id.rtext5 );
        pongal=findViewById(R.id.rname1);
        uttapam= findViewById(R.id.rname2);
        idli=findViewById(R.id.rname3);
        vada=findViewById(R.id.rname4);
        dosa=findViewById(R.id.rname5);
        price1=findViewById(R.id.rp1);
        price2=findViewById(R.id.rp2);
        price3=findViewById(R.id.rp3);
        price4=findViewById(R.id.rp4);
        price5=findViewById(R.id.rp5);
        add = findViewById(R.id.radd);

        databaseReference1= FirebaseDatabase.getInstance().getReference("Roti Order1");
        databaseReference2= FirebaseDatabase.getInstance().getReference("Roti Order2");
        databaseReference3= FirebaseDatabase.getInstance().getReference("Roti Order3");
        databaseReference4= FirebaseDatabase.getInstance().getReference("Roti Order4");
        databaseReference5= FirebaseDatabase.getInstance().getReference("Roti Order5");


        StringBuilder s = new StringBuilder();

        price.put(pongal.getText().toString(),10);
        price.put(uttapam.getText().toString(),30);
        price.put(idli.getText().toString(),25);
        price.put(vada.getText().toString(),40);
        price.put(dosa.getText().toString(),35);

        for(String str : selection.keySet())
        {
            if(pongal.getText().equals(str)){
                c1.setChecked(true);
            }
            if(uttapam.getText().equals(str)){
                c2.setChecked(true);
            }
            if(idli.getText().equals(str)){
                c3.setChecked(true);
            }
            if(vada.getText().equals(str)){
                c4.setChecked(true);
            }
            if(dosa.getText().equals(str)){
                c5.setChecked(true);
            }
            s.append(str).append(": $").append(selection.get(str)).append("\n");
        }

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Card_Roti.this, "Added", Toast.LENGTH_LONG).show();

            }
        });

    }


    public void rchapati(View view) {

        if (c1.isChecked()) {
            if(counter1 == 0)
            {
                counter1 = 1;
            }
            text1.setText(Integer.toString(counter1));
            selection.put(pongal.getText().toString(),counter1);
        } else {
            text1.setText("");
            selection.remove(pongal.getText().toString());
            counter1=0;
        }

    }

    public void rtandoori(View view) {

        if (c2.isChecked()) {
            if(counter2 == 0)
            {
                counter2 = 1;
            }
            text2.setText(Integer.toString(counter2));
            selection.put(uttapam.getText().toString(),counter2);
        } else {
            text2.setText("");
            selection.remove(uttapam.getText().toString());
            counter2=0;
        }

    }

    public void rphulka(View view) {

        if (c3.isChecked()) {
            if(counter3 == 0)
            {
                counter3 = 1;
            }
            text3.setText(Integer.toString(counter3));
            selection.put( idli.getText().toString(),counter3);
        }
        else {
            text3.setText("");
            selection.remove(idli.getText().toString());
            counter3=0;
        }

    }

    public void rtawa(View view) {

        if (c4.isChecked()) {
            if(counter4 == 0)
            {
                counter4 = 1;
            }
            text4.setText(Integer.toString(counter4));
            selection.put(vada.getText().toString(),counter4);
        }
        else {
            text4.setText("");
            selection.remove(vada.getText().toString());
            counter4=0;
        }

    }

    public void rmasala(View view) {

        if (c5.isChecked()) {
            if(counter5 == 0)
            {
                counter5 = 1;
            }
            text5.setText(Integer.toString(counter5));
            selection.put(dosa.getText().toString(),counter5);
        } else {
            text5.setText("");
            selection.remove(dosa.getText().toString());
            counter5=0;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countDE5(View view) {
        if(c5.isChecked()){
            if(counter5==1)
            {
                counter5=0;
                c5.setChecked(false);
                text5.setText("");
            }
            else
            {
                counter5--;
            }
            text5.setText(Integer.toString(counter5));
            selection.replace(dosa.getText().toString(), counter5);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text5.setText("");
        }}
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countIN5(View view) {
        if(c5.isChecked()){
            counter5++;
            text5.setText(Integer.toString(counter5));
            selection.replace(dosa.getText().toString(), counter5);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text5.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countDE4(View view) {
        if(c4.isChecked()) {
            if(counter4==1)
            {
                counter4=0;
                c4.setChecked(false);
                text4.setText("");
            }
            else
            {
                counter4--;
            }
            text4.setText(Integer.toString(counter4));
            selection.replace(vada.getText().toString(), counter4);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text4.setText("");
        }}
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countIN4(View view) {
        if(c4.isChecked()) {
            counter4++;
            text4.setText(Integer.toString(counter4));
            selection.replace(vada.getText().toString(), counter4);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text4.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countDE3(View view) {
        if(c3.isChecked()) {
            if(counter3==1)
            {
                counter3=0;
                c3.setChecked(false);
                text3.setText("");
            }
            else
            {
                counter3--;
            }
            text3.setText(Integer.toString(counter3));
            selection.replace(idli.getText().toString(), counter3);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text3.setText("");
        }}
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countIN3(View view) {
        if(c3.isChecked()) {
            counter3++;
            text3.setText(Integer.toString(counter3));
            selection.replace(idli.getText().toString(), counter3);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text3.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countDE2(View view) {
        if(c2.isChecked()) {
            if(counter2==1)
            {
                counter2=0;
                c2.setChecked(false);
                text2.setText("");
            }
            else
            {
                counter2--;
            }
            text2.setText(Integer.toString(counter2));
            selection.replace(uttapam.getText().toString(), counter2);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text2.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countIN2(View view) {
        if(c2.isChecked()) {
            counter2++;
            text2.setText(Integer.toString(counter2));
            selection.replace(uttapam.getText().toString(), counter2);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text2.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countDE1(View view) {
        if(c1.isChecked()) {
            if(counter1==1)
            {
                counter1=0;
                c1.setChecked(false);
                text1.setText("");
            }
            else
            {
                counter1--;
            }
            text1.setText(Integer.toString(counter1));
            selection.replace(pongal.getText().toString(), counter1);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text1.setText("");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void countIN1(View view) {
        if(c1.isChecked()) {
            counter1++;
            text1.setText(Integer.toString(counter1));
            selection.replace(pongal.getText().toString(), counter1);
        }
        else{
            Toast.makeText(Card_Roti.this, "Please Select That Item First", Toast.LENGTH_SHORT).show();
            text1.setText("");
        }
    }
}
