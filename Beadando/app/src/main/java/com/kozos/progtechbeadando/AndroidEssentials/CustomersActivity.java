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
import android.widget.Toast;

import com.kozos.progtechbeadando.AndroidEssentials.Adapters.CustomersAdapter;
import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerAddressTooShortException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameFormatNotAcceptableException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooLongException;
import com.kozos.progtechbeadando.Customers.Exceptions.CustomerNameTooShortException;
import com.kozos.progtechbeadando.Customers.SimpleCustomer;
import com.kozos.progtechbeadando.R;
import com.kozos.progtechbeadando.Warehouse.MyWarehouse;

import java.util.ArrayList;
import java.util.List;

public class CustomersActivity extends AppCompatActivity {

    String CUSTOMER_ADDRESS_EMPTY = "Customer address cannot be empty!";
    String CUSTOMER_ADDRESS_LONG = "Customer address is too long!";
    String CUSTOMER_ADDRESS_SHORT = "Customer address is too short!";
    String CUSTOMER_NAME_FORMAT = "Customer name format not acceptable!";
    String CUSTOMER_NAME_EMPTY = "Customer name cannot be empty!";
    String CUSTOMER_NAME_LONG = "Customer name is too long!";
    String CUSTOMER_NAME_SHORT = "Customer name is too short!";
    String CUSTOMER_ADD_SUCCESSFUL = "Customer added successfully!";

    Button toOrders, toProducts, addCustomer;
    EditText customerName, customerAddress;
    ListView customerListView;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        for(int i = 1; i <= 30; i++){
            MyWarehouse.getInstance().addNewCustomer(i + " Person", "Address Address Address " + i);
        }

        CustomersAdapter customersAdapter = new CustomersAdapter((ArrayList<Customer>) MyWarehouse.getInstance().getCustomers(), this);

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
                try {
                    MyWarehouse.getInstance().addNewCustomer(
                            customerName.getText().toString(),
                            customerAddress.getText().toString());
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_ADD_SUCCESSFUL, Toast.LENGTH_LONG );
                }catch (CustomerAddressCannotBeEmptyException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_ADDRESS_EMPTY, Toast.LENGTH_LONG);
                }catch (CustomerAddressTooLongException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_ADDRESS_LONG , Toast.LENGTH_LONG);
                }catch (CustomerAddressTooShortException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_ADDRESS_SHORT, Toast.LENGTH_LONG);
                }catch (CustomerNameCannotBeEmptyException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_NAME_EMPTY , Toast.LENGTH_LONG);
                }catch (CustomerNameTooLongException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_NAME_LONG , Toast.LENGTH_LONG);
                }catch (CustomerNameTooShortException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_NAME_SHORT , Toast.LENGTH_LONG);
                }catch (CustomerNameFormatNotAcceptableException e){
                    toast = Toast.makeText(CustomersActivity.this, CUSTOMER_NAME_FORMAT, Toast.LENGTH_LONG);
                }
                toast.show();
            }
        });

    }
}