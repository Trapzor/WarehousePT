package com.kozos.progtechbeadando.AndroidEssentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.kozos.progtechbeadando.Order.Order;
import com.kozos.progtechbeadando.Products.Electronics;
import com.kozos.progtechbeadando.Products.Product;
import com.kozos.progtechbeadando.Products.Toys;
import com.kozos.progtechbeadando.R;
import com.kozos.progtechbeadando.Warranty.ForPeriodWarranty;
import com.kozos.progtechbeadando.Warranty.LifetimeWarranty;
import com.kozos.progtechbeadando.Warranty.NoWarranty;
import com.kozos.progtechbeadando.Warranty.Warranty;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class ProductsActivity extends AppCompatActivity {

    Spinner typeOfProduct;
    CheckBox noWarranty, lifetimeWarranty, warrantyForPeriod;
    Button toOrders, toCustomers, addProduct;
    EditText productId, productName, productPrice, productQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        toOrders = findViewById(R.id.productToOrdersButton);
        toCustomers = findViewById(R.id.productToCustomersButton);
        addProduct = findViewById(R.id.productAddProductButton);

        productId = findViewById(R.id.productIdText);
        productName = findViewById(R.id.productNameText);
        productPrice = findViewById(R.id.productPriceText);
        productQuantity = findViewById(R.id.productQuantityText);

        noWarranty = findViewById(R.id.productNoWarrantyCheck);
        lifetimeWarranty = findViewById(R.id.productLifetimeWarrantyCheck);
        warrantyForPeriod = findViewById(R.id.productWarrantyForPeriodCheck);

        typeOfProduct = findViewById(R.id.productTypeSpinner);
        String[] productTypes = new String[]{"Electronics", "Toys"};
        ArrayAdapter<String> productTypesAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, productTypes);
        typeOfProduct.setAdapter(productTypesAdapter);

        Intent switchToOrdersIntent = new Intent(this, OrdersActivity.class);
        Intent switchToCustomersIntent = new Intent(this, CustomersActivity.class);

        noWarranty.setChecked(true);

        noWarranty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifetimeWarranty.setChecked(false);
                warrantyForPeriod.setChecked(false);
            }
        });

        lifetimeWarranty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noWarranty.setChecked(false);
                warrantyForPeriod.setChecked(false);
            }
        });

        warrantyForPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noWarranty.setChecked(false);
                lifetimeWarranty.setChecked(false);
            }
        });

        toOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToOrdersIntent);
            }
        });

        toCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchToCustomersIntent);
            }
        });

        productId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productId.setText("");
            }
        });
        productName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productName.setText("");
            }
        });
        productPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productPrice.setText("");
            }
        });
        productQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productQuantity.setText("");
            }
        });


        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!noWarranty.isChecked() && !lifetimeWarranty.isChecked() && !warrantyForPeriod.isChecked())
                    noWarranty.setChecked(true);

                Warranty warranty;
                if(noWarranty.isChecked()) {
                    warranty = new NoWarranty();
                }
                else if(lifetimeWarranty.isChecked()) {
                    warranty = new LifetimeWarranty();
                }
                else {
                    warranty = new ForPeriodWarranty(new Date());
                }

                if(typeOfProduct.toString().equals("Electronics")){
                    Product product = new Electronics(
                            productId.toString(),
                            productName.toString(),
                            warranty,
                            Integer.parseInt(productPrice.toString()),
                            Integer.parseInt((productQuantity.toString())));
                    //TODO add to db.
                }
                else if(typeOfProduct.toString().equals("Toys")){
                    Product product = new Toys(
                        productId.toString(),
                        productName.toString(),
                        warranty,
                        Integer.parseInt(productPrice.toString()),
                        Integer.parseInt((productQuantity.toString())));
                    //TODO add to db.
                }

            }
        });
    }
}