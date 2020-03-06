package com.example.restaurantmanagment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CartFragment extends Fragment {

    Button placeorder;
    TextView Total;
    TextView item,quantity,price;
    static TextView temp;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate ( R.layout.cart_activity,container,false);
        placeorder = v.findViewById(R.id.placeorder);
        Total = v.findViewById(R.id.total);
        item = v.findViewById(R.id.item);
        quantity = v.findViewById(R.id.quantity);
        price = v.findViewById(R.id.cartprice);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        Integer temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0;
        Integer total = 0;


        databaseReference = FirebaseDatabase.getInstance ().getReference ("Final Order");

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Food_Bottom_Nav.class);

                addDetails ();

                getActivity().startActivity(intent);


            }
        });
        for(String str : Card_Punjabi.selection.keySet())
        {
            temp1 = Card_Punjabi.price.get(str)*Card_Punjabi.selection.get(str);
            total+=temp1;
            s1.append(str).append("\n");
            s2.append(Card_Punjabi.selection.get(str)).append("\n");
            s3.append("₹"+temp1.toString()).append("\n");
        }
        price.setText(s3.toString());
        item.setText(s1.toString());
        quantity.setText(s2.toString());

        for(String str : Card_Chinese.selection.keySet())
        {
            temp2 = Card_Chinese.price.get(str)*Card_Chinese.selection.get(str);
            total+=temp2;
            s1.append(str).append("\n");
            s2.append(Card_Chinese.selection.get(str)).append("\n");
            s3.append("₹"+temp2.toString()).append("\n");
        }
        price.setText(s3.toString());
        item.setText(s1.toString());
        quantity.setText(s2.toString());

        for(String str : Card_South.selection.keySet())
        {
            temp4 = Card_South.price.get(str)*Card_South.selection.get(str);
            total+=temp4;
            s1.append(str).append("\n");
            s2.append(Card_South.selection.get(str)).append("\n");
            s3.append("₹"+temp4.toString()).append("\n");
        }
        price.setText(s3.toString());
        item.setText(s1.toString());
        quantity.setText(s2.toString());

        for(String str : Card_Roti.selection.keySet())
        {
            temp3 = Card_Roti.price.get(str)*Card_Roti.selection.get(str);
            total+=temp3;
            s1.append(str).append("\n");
            s2.append(Card_Roti.selection.get(str)).append("\n");
            s3.append("₹"+temp3.toString()).append("\n");
        }
        price.setText(s3.toString());
        item.setText(s1.toString());
        quantity.setText(s2.toString());

        Total.setText(":   ₹ "+total.toString());

        return v;
    }

    public void addDetails(){

        String foodname = item.getText().toString().trim();
        String Price = price.getText().toString().trim();
        String Quantity = quantity.getText().toString().trim();
        String total = Total.getText().toString().trim();
        String id = databaseReference.push().getKey();
        Database database = new Database(id, foodname, Price, Quantity,total);

        databaseReference.setValue(database);

    }


}
