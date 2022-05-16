package com.kozos.progtechbeadando.AndroidEssentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;

import com.kozos.progtechbeadando.AndroidEssentials.Adapters.CustomersAdapter;
import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Customers.SimpleCustomer;
import com.kozos.progtechbeadando.R;
import com.kozos.progtechbeadando.Warehouse.MyWarehouse;

import java.util.ArrayList;
import java.util.List;

public class CustomersActivity extends AppCompatActivity {

    Button toOrders, toProducts, addCustomer;
    EditText customerName, customerAddress;
    ListView customerListView;

    ArrayList<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        customers = (ArrayList<Customer>) MyWarehouse.getInstance().getCustomers();
        CustomersAdapter customersAdapter = new CustomersAdapter(customers, this);

        customerListView = findViewById(R.id.customerListView);
        customerListView.setAdapter(customersAdapter);

        toOrders = findViewById(R.id.customerToOrdersButton);
        toProducts = findViewById(R.id.customerToProductsButton);
        addCustomer = findViewById(R.id.customerAddCustomerButton);

        customerName = findViewById(R.id.customerNameText);
        customerAddress = findViewById(R.id.customerAddressText);

        Intent switchToOrdersIntent = new Intent(this, OrdersActivity.class);
        Intent switchToProductsIntent = new Intent(this, ProductsActivity.class);

        toOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToOrdersIntent);
            }
        });

        toProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToProductsIntent);
            }
        });

        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyWarehouse.getInstance().addNewCustomer(
                        customerName.getText().toString(),
                        customerAddress.getText().toString());
            }
        });

    }
}