package com.kozos.progtechbeadando.AndroidEssentials.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kozos.progtechbeadando.Customers.Customer;
import com.kozos.progtechbeadando.R;

import java.util.ArrayList;

public class CustomersAdapter extends BaseAdapter {

    ArrayList<String> data;
    Context context;

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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
            view = inflater.inflate(R.layout.customer_list_item, (ViewGroup) view, false);
        }
        TextView customerName = view.findViewById(R.id.customerNameAdapter);
        TextView customerAddress = view.findViewById(R.id.customerAddressAdapter);

        customerName.setText(data.get(i));
        customerAddress.setText(data.get(i));

        return view;
    }
}
