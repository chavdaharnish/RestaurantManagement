package com.example.restaurantmanagment;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;


public class OTPvar extends AppCompatActivity {
    Button registor, submit;
    EditText name, number;
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_otpvar );

        registor = findViewById ( R.id.req );
        submit = findViewById ( R.id.custsubmit );
        name = findViewById ( R.id.cust_name );
        number = findViewById ( R.id.cust_pass );
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder ( ).permitAll ( ).build ( );
        StrictMode.setThreadPolicy ( policy );
        registor.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                try {
                    // Construct data
                    String apiKey = "apikey=" + "0KJ6W7KA7m4-XAM2T9uOnuH88bYG9YUQtMdpjpiQ9A";
                    Random random = new Random ( );
                    randomNumber = random.nextInt ( 999999 );
                    String message = "&message=" + "Hey " + name.getText ( ).toString ( ) + "Your OTP for FOODY is " + randomNumber;
                    String sender = "&sender=" + "ABC" +
                            "" +
                            "";
                    String numbers = "&numbers=" + number.getText ( ).toString ( );

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL ( "https://api.textlocal.in/send/?" ).openConnection ( );
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput ( true );
                    conn.setRequestMethod ( "POST" );
                    conn.setRequestProperty ( "Content-Length" , Integer.toString ( data.length ( ) ) );
                    conn.getOutputStream ( ).write ( data.getBytes ( "UTF-8" ) );
                    final BufferedReader rd = new BufferedReader ( new InputStreamReader ( conn.getInputStream ( ) ) );
                    final StringBuffer stringBuffer = new StringBuffer ( );
                    String line;
                    while ((line = rd.readLine ( )) != null) {
                        stringBuffer.append ( line );
                    }
                    rd.close ( );
                    Toast.makeText ( getApplicationContext ( ) , "OTP SEND SUCCESSFULLY" , Toast.LENGTH_LONG ).show ( );

                    //   return stringBuffer.toString();
                } catch (Exception e) {
                    // System.out.println("Error SMS "+e);
                    // return "Error "+e;
                    Toast.makeText ( getApplicationContext ( ) , "ERROR SMS " + e , Toast.LENGTH_LONG ).show ( );
                    Toast.makeText ( getApplicationContext ( ) , "ERROR" + e , Toast.LENGTH_LONG ).show ( );
                }

            }


        } );
        submit.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                if (randomNumber == Integer.valueOf ( number.getText ( ).toString ( ) )) {
                    Toast.makeText ( getApplicationContext ( ) , "You are logged in successfully" , Toast.LENGTH_SHORT ).show ( );

                } else
                    Toast.makeText ( getApplicationContext ( ) , "WRONG OTP" , Toast.LENGTH_LONG ).show ( );
            }
        } );
    }
}
