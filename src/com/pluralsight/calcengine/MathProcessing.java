package com.pluralsight.calcengine;

/**
 * Created by MANU on 12/25/2016.
 */
public interface MathProcessing {
    String SEPERATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);
}
