package com.pluralsight.calcengine;

/**
 * Created by MANU on 12/24/2016.
 */
public class Adder extends CalculateBase {
    public Adder() {

    }
    public Adder(double leftVal, double rightVal) {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate() {
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }
}
