package com.kozos.progtechbeadando.AndroidEssentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kozos.progtechbeadando.R;

public class OrdersActivity extends AppCompatActivity {

    Button toProducts, toCustomers, toCreateOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        toProducts = findViewById(R.id.orderToProductsButton);
        toCustomers = findViewById(R.id.orderToCustomersButton);
        toCreateOrder = findViewById(R.id.orderToCreatNewOrderButton);

        Intent switchToProductsIntent = new Intent(this, ProductsActivity.class);
        Intent switchToCustomersIntent = new Intent(this, CustomersActivity.class);
        Intent switchToCreateNewOrderIntent = new Intent(this, CreateNewOrderActivity.class);

        toProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToProductsIntent);
            }
        });

        toCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToCustomersIntent);
            }
        });

        toCreateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToCreateNewOrderIntent);
            }
        });
    }
}