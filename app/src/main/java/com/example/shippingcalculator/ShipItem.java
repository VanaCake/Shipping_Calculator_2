package com.example.shippingcalculator;

import java.util.function.DoubleBinaryOperator;

public class ShipItem {
    Double weight;
    static final Double BASE = 3.00;
    static final Double ADDED = 0.50;
    static final Double EXTRA = 4.00;
    static final int BASE_WEIGHT = 16;
    static final int EXTRA_WEIGHT = 30;

    public ShipItem(double weight)
    {
        this.weight = weight;
    }
    public ShipItem(){
        weight = 0.0;
    }


    public void setWeight(double weight){
        this.weight = weight;
    }

    public Double getBaseCost(){
        if(weight > EXTRA_WEIGHT){
            return EXTRA;
        }
        return BASE;
    }
    public Double getAddedCost(){
        double temp = weight - BASE_WEIGHT;
        if(weight > BASE_WEIGHT) {
            return Math.ceil(temp / 4 * ADDED);
        }
        return 0.0;
    }
    public Double getTotalCost(){
        return getBaseCost() + getAddedCost();
    }
}
