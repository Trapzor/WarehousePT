package com.kozos.progtechbeadando.AndroidEssentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.kozos.progtechbeadando.AndroidEssentials.Adapters.CustomersAdapter;
import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Customers.SimpleCustomer;
import com.kozos.progtechbeadando.R;
import com.kozos.progtechbeadando.Warehouse.MyWarehouse;

import java.util.ArrayList;
import java.util.List;

public class CustomersActivity extends AppCompatActivity {

    Button toOrders, toProducts, addCustomer;
    EditText customerId, customerName, customerAddress;
    GridView customerGridView;

    ArrayList<Customer> customers = (ArrayList<Customer>) MyWarehouse.getInstance().getCustomers();
    ArrayAdapter<String> customerNames, customerAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        for(Customer c : customers){
            customerNames.add(c.getName());
            customerAddresses.add(c.getAddress());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.customer_list_item, (List<String>) customerNames);

        CustomersAdapter customersAdapter = new CustomersAdapter();

        toOrders = findViewById(R.id.customerToOrdersButton);
        toProducts = findViewById(R.id.customerToProductsButton);
        addCustomer = findViewById(R.id.customerAddCustomerButton);

        customerId = findViewById(R.id.customerIdText);
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
                Customer customer = new SimpleCustomer(
                        customerId.toString(),
                        customerName.toString(),
                        customerAddress.toString());

                //TODO add to db
            }
        });

    }
}