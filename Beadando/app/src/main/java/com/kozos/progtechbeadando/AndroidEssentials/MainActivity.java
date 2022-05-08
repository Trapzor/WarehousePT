package com.kozos.progtechbeadando.AndroidEssentials;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kozos.progtechbeadando.Database.ChangeLogOpenHelper;
import com.kozos.progtechbeadando.Database.CustomersOpenHelper;
import com.kozos.progtechbeadando.Database.OrdersOpenHelper;
import com.kozos.progtechbeadando.Database.ProductsContract;
import com.kozos.progtechbeadando.Database.ProductsOpenHelper;
import com.kozos.progtechbeadando.R;

public class MainActivity extends AppCompatActivity {

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
    }
}