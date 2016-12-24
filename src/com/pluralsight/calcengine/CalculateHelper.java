package com.pluralsight.calcengine;

/**
 * Created by MANU on 12/24/2016.
 */
public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBSTRACT_SYMBOL = '-';
    private static final char DIVIDE_SYMBOL = '/';
    private static final char MULTIPLY_SYMBOL = '+';

    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) {
        String[] parts = statement.split(" ");
        String commandString = parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue = Double.parseDouble(parts[2]);

        setCommandFromString(commandString);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Substract:
                calculator = new Substractor(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();

    }

    private void setCommandFromString(String commandString) {
        if (commandString.equalsIgnoreCase(MathCommand.Add.toString())) {
            command = MathCommand.Add;
        } else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
            command = MathCommand.Divide;
        } else if (commandString.equalsIgnoreCase(MathCommand.Substract.toString())) {
            command = MathCommand.Substract;
        } else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString())) {
            command = MathCommand.Multiply;
        }
    }

    @Override
    public String toString() {
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Substract:
                symbol = SUBSTRACT_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

}
