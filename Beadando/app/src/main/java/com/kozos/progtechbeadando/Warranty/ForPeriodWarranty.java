package com.kozos.progtechbeadando.Warranty;

import java.util.Date;

public class ForPeriodWarranty implements Warranty{

    public ForPeriodWarranty(Date expirationDate) {
        setExpirationDate(expirationDate);
    }

    Date expirationDate;
    Date getExpirationDate(){
        return this.expirationDate;
    }
    void setExpirationDate(Date expirationDate){
        this.expirationDate = expirationDate;
    }

    @Override
    public void apply() {
        System.out.println("The Warranty's expiration date is : " + expirationDate + "!");
    }
}
