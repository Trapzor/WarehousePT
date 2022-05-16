package com.kozos.progtechbeadando.AndroidEssentials.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kozos.progtechbeadando.Products.Product;
import com.kozos.progtechbeadando.R;

import java.util.ArrayList;

public class ProductsAdapter extends BaseAdapter {

    ArrayList<Product> data;
    Context context;

    public ProductsAdapter(ArrayList<Product> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.product_list_item, viewGroup, false);
        }
        TextView productName = view.findViewById(R.id.productNameAdapter);
        TextView productPrice = view.findViewById(R.id.productPriceAdapter);
        TextView productQuantity = view.findViewById(R.id.productQuantityAdapter);

        productName.setText(data.get(i).getName());
        productPrice.setText(data.get(i).getPrice() + " Ft");
        productQuantity.setText(data.get(i).getQuantity() + " DB");

        return view;
    }
}
