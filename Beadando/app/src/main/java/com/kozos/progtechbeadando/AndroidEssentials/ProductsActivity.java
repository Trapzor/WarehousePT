package com.kozos.progtechbeadando.AndroidEssentials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.kozos.progtechbeadando.AndroidEssentials.Adapters.ProductsAdapter;
import com.kozos.progtechbeadando.Products.Electronics;
import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooHighException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductDesiredQuantityIsTooLowException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameCannotBeEmptyException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooLongException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductNameTooShortException;
import com.kozos.progtechbeadando.Products.Exceptions.ProductPriceIsTooLowException;
import com.kozos.progtechbeadando.Products.Product;
import com.kozos.progtechbeadando.R;
import com.kozos.progtechbeadando.Warehouse.MyWarehouse;
import com.kozos.progtechbeadando.Warranty.ForPeriodWarranty;
import com.kozos.progtechbeadando.Warranty.LifetimeWarranty;
import com.kozos.progtechbeadando.Warranty.NoWarranty;
import com.kozos.progtechbeadando.Warranty.Warranty;
import java.util.ArrayList;
import java.util.Date;

public class ProductsActivity extends AppCompatActivity {

    String PRODUCT_NAME_EMPTY = "Product name cannot be empty!";
    String PRODUCT_NAME_SHORT = "Product name too short!";
    String PRODUCT_NAME_LONG = "Product name too long!";
    String PRODUCT_PRICE_LOW = "Product price too low";
    String PRODUCT_QUANTITY_LOW ="Desired quantity is too low!";
    String PRODUCT_QUANTITY_HIGH = "Desired quantity is too high!";
    String PRODUCT_ADD_SUCCESSFUL = "Product successfully added!";

    Spinner typeOfProduct;
    CheckBox noWarranty, lifetimeWarranty, warrantyForPeriod;
    Button toOrders, toCustomers, addProduct;
    EditText productId, productName, productPrice, productQuantity;
    ListView productListView;

    Toast toast;

    ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        products = (ArrayList<Product>) MyWarehouse.getInstance().getProducts();
        ProductsAdapter productsAdapter = new ProductsAdapter(products, this);

        for(int i = 0; i < 30; i++){
            products.add(new Electronics(i + "aaa", i+"sajbolvanahold", new NoWarranty(), i, i));
        }

        productListView = findViewById(R.id.productListView);
        productListView.setAdapter(productsAdapter);

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

        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(productPrice.getText().toString().equals(null)  || productPrice.getText().toString().equals("") || productPrice.getText().toString().equals(" ")){
                    toast = Toast.makeText(ProductsActivity.this,"Product price cannot be empty!", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                if(productQuantity.getText().toString().equals(null) || productQuantity.getText().toString().equals("") || productQuantity.getText().toString().equals(" ")){
                    toast = Toast.makeText(ProductsActivity.this,"Product quantity cannot be empty!", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

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

                if(typeOfProduct.getSelectedItem().toString().equals("Electronics")){
                    try{
                    MyWarehouse.getInstance().addElectronicsProduct(
                            productName.getText().toString(),
                            warranty,
                            Integer.parseInt(productPrice.getText().toString()),
                            Integer.parseInt(productQuantity.getText().toString()));
                    toast = Toast.makeText(ProductsActivity.this, PRODUCT_ADD_SUCCESSFUL, Toast.LENGTH_LONG);
                    }catch (ProductNameCannotBeEmptyException e) {
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_NAME_EMPTY, Toast.LENGTH_LONG);
                    }catch (ProductNameTooLongException e) {
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_NAME_LONG, Toast.LENGTH_LONG);
                    }catch (ProductNameTooShortException e) {
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_NAME_SHORT, Toast.LENGTH_LONG);
                    }catch (ProductPriceIsTooLowException e){
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_PRICE_LOW,Toast.LENGTH_LONG);
                    }catch (ProductDesiredQuantityIsTooHighException e){
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_QUANTITY_HIGH, Toast.LENGTH_LONG);
                    }catch (ProductDesiredQuantityIsTooLowException e){
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_QUANTITY_LOW, Toast.LENGTH_LONG);
                    }
                    toast.show();

                }
                else if(typeOfProduct.toString().equals("Toys")){
                    try{
                    MyWarehouse.getInstance().addToysProduct(
                            productName.getText().toString(),
                            warranty,
                            Integer.parseInt(productPrice.getText().toString()),
                            Integer.parseInt(productQuantity.getText().toString()));
                    toast = Toast.makeText(ProductsActivity.this, PRODUCT_ADD_SUCCESSFUL, Toast.LENGTH_LONG);
                    }catch (ProductNameCannotBeEmptyException e) {
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_NAME_EMPTY, Toast.LENGTH_LONG);
                    }catch (ProductNameTooLongException e) {
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_NAME_LONG, Toast.LENGTH_LONG);
                    }catch (ProductNameTooShortException e) {
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_NAME_SHORT, Toast.LENGTH_LONG);
                    }catch (ProductPriceIsTooLowException e){
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_PRICE_LOW,Toast.LENGTH_LONG);
                    }catch (ProductDesiredQuantityIsTooHighException e){
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_QUANTITY_HIGH, Toast.LENGTH_LONG);
                    }catch (ProductDesiredQuantityIsTooLowException e){
                        toast = Toast.makeText(ProductsActivity.this, PRODUCT_QUANTITY_LOW, Toast.LENGTH_LONG);
                    }
                    toast.show();
                }
            }
        });
    }
}