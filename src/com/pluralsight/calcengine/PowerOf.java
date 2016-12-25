package com.pluralsight.calcengine;

/**
 * Created by MANU on 12/25/2016.
 */
public class PowerOf implements MathProcessing{
    @Override
    public String getKeyword() {
        return "power";
    }

    @Override
    public char getSymbol() {
        return '^';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        return Math.pow(leftVal, rightVal);
    }
}
