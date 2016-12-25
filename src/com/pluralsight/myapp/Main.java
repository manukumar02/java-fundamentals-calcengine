package com.pluralsight.myapp;


import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Substractor;

/**
 * Created by MANU on 12/19/2016.
 */
public class Main {
    public static void main(String[] args) {

        String[] statements = {
                "add 25.0 92.0",
                "power 9.0 5.0",
                "multiply 20.0 30.0",
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                new Adder(),
                new PowerOf(),
                new Multiplier(),
        });

        for (String statement : statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }

    }

    static void useCalculatorHelper() {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addx 0.0 0.0",
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "substract 225.0 22.0",
                "multiply 11.0 22.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println(" Original exception: " + e.getCause().getMessage());
                }
            }
        }

//        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
//        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = {'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];
//        MathEquation[] equations = new MathEquation[4];
//        equations[0] = new MathEquation('a', 100.0d, 50.0d);
//        equations[1] = new MathEquation('d', 100.0d, 50.0d);
//        equations[2] = new MathEquation('s', 100.0d, 50.0d);
//        equations[3] = new MathEquation('m', 100.0d, 50.0d);
////        equations[0] = create(100.0d, 50.0d, 'a');
////        equations[1] = create(25.0d, 520.0d, 'd');
////        equations[2] = create(225.0d, 20.0d, 's');
////        equations[3] = create(11.0d, 5.0d, 'm');
//
//        for (MathEquation equation : equations) {
//            equation.execute();
//            System.out.println("Result = ");
//            System.out.println(equation.getResult());
//        }
//
//        System.out.println();
//        System.out.println("Using Overloads!");
//        System.out.println();
//
//        double leftDouble = 9.0d;
//        double rightDouble = 4.0d;
//
//        int leftInt = 9;
//        int rightInt = 4;


//        MathEquation equationoverload = new MathEquation('d');
//        equationoverload.execute(leftDouble, rightDouble);
//        System.out.println("Results=");
//        System.out.println(equationoverload.getResult());
//
//        equationoverload.execute(leftInt, rightInt);
//        System.out.println("Results=");
//        System.out.println(equationoverload.getResult());
//
//        equationoverload.execute((double) leftInt, rightInt);
//        System.out.println("Results=");
//        System.out.println(equationoverload.getResult());


        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(300.0d, 50.0d),
                new Substractor(100.0d, 23.0d),
                new Multiplier(100.0d, 30.0d)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            System.out.println("Results = ");
            System.out.println(calculator.getResult());
        }
    }

//    public static MathEquation create(double leftVal, double rightVal, char opCode) {
//        MathEquation equation = new MathEquation();
//        equation.setLeftVal(leftVal);
//        equation.setRightVal(rightVal);
//        equation.setOpCode(opCode);
//
//        return equation;
//    }
}
