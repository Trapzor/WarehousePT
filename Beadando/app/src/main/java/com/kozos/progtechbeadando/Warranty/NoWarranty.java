package com.kozos.progtechbeadando.Warranty;

public class NoWarranty implements Warranty{
    @Override
    public void apply() {
        System.out.println("No warranty!");
    }
}
