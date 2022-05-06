package com.kozos.progtechbeadando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kozos.progtechbeadando.Products.Electronics;
import com.kozos.progtechbeadando.Products.Product;
import com.kozos.progtechbeadando.Products.ProductImpl;
import com.kozos.progtechbeadando.Products.Toys;
import com.kozos.progtechbeadando.Warranty.LifetimeWarranty;
import com.kozos.progtechbeadando.Warranty.NoWarranty;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}