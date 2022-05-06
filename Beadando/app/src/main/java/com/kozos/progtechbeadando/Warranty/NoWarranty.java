package com.kozos.progtechbeadando.Warranty;

import android.util.Log;

public class NoWarranty implements Warranty{
    @Override
    public void apply() {
        System.out.println("No warranty!");
    }
}
