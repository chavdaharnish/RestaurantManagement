package com.example.restaurantmanagment;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.Result;
import java.util.Timer;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCode extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    ZXingScannerView scannerView;
    Timer timer;
    TextView table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        table=findViewById ( R.id.carttext );
    }
    @Override
    public void handleResult(Result result) {
        HomeFragment.table.setText(result.getText());
        onBackPressed();
    }
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }
}
