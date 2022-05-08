package com.kozos.progtechbeadando.AndroidEssentials;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kozos.progtechbeadando.R;

public class WarrantyCheckActivity extends AppCompatActivity {

    Button checkWarrantyButton;
    EditText orderId, productId;
    TextView warrantyOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warranty_check);

        checkWarrantyButton = findViewById(R.id.cwCheckButton);

        warrantyOutputText = findViewById(R.id.cwText);

        orderId = findViewById(R.id.cwOrderIdText);
        productId = findViewById(R.id.cwProductIdText);

        checkWarrantyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });
    }
}