package com.kozos.progtechbeadando.Order;

public class OrderImplBuilder extends OrderBuilderImpl{
    @Override
    public SimpleOrder getOrder() {
        return new SimpleOrder(getOrder().builder, getOrder().id);
    }
}
