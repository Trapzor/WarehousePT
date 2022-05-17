package com.kozos.progtechbeadando.AndroidEssentials;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kozos.progtechbeadando.Database.ChangeLogOpenHelper;
import com.kozos.progtechbeadando.Database.CustomersOpenHelper;
import com.kozos.progtechbeadando.Database.OrdersOpenHelper;
import com.kozos.progtechbeadando.Database.ProductsOpenHelper;
import com.kozos.progtechbeadando.R;

public class MainActivity extends AppCompatActivity {

    Button toProducts, toOrders, toCustomers, toWarrantyCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductsOpenHelper productsOpenHelper = new ProductsOpenHelper(this);
        CustomersOpenHelper customersOpenHelper = new CustomersOpenHelper(this);
        OrdersOpenHelper ordersOpenHelper = new OrdersOpenHelper(this);
        ChangeLogOpenHelper changeLogOpenHelper = new ChangeLogOpenHelper(this);

        SQLiteDatabase products = productsOpenHelper.getWritableDatabase();
        SQLiteDatabase customers = customersOpenHelper.getWritableDatabase();
        SQLiteDatabase orders = ordersOpenHelper.getWritableDatabase();
        SQLiteDatabase changeLogs = changeLogOpenHelper.getWritableDatabase();

        toProducts = findViewById(R.id.mainToProductsButton);
        toOrders = findViewById(R.id.mainToOrdersButton);
        toCustomers = findViewById(R.id.mainToCustomersButton);
        toWarrantyCheck = findViewById(R.id.mainToWarrantyCheckButton);

        Intent switchToProductsIntent = new Intent(this, ProductsActivity.class);
        Intent switchToCustomersIntent = new Intent(this, CustomersActivity.class);
        Intent switchToOrdersIntent = new Intent(this, OrdersActivity.class);
        Intent switchToWarrantyCheckIntent = new Intent(this, WarrantyCheckActivity.class);


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

        toOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToOrdersIntent);
            }
        });

        toWarrantyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToWarrantyCheckIntent);
            }
        });
    }
}