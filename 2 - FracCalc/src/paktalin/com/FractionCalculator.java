package paktalin.com;

import java.util.Scanner;

/**
 * Created by Paktalin on 24.07.2017.
 */
public class FractionCalculator {
    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        System.out.print("This program is a fracture calculator\n" +
                "It will add, subtract, multiply and divide fractions until you type Q to quit.\n" +
                "Please enter your fractions in the form a/b, where a and b are integers.\n" +
                "_____________________________________________________________________________\n");
        getOperation();
    }

    private static void getOperation() {
        Fraction fraction, other;
        System.out.println("Please enter an operation +, -, /, *, = or Q to exit");
        switch (scanner.next()){
            case "+":
                fraction = getFraction();
                other = getFraction();
                System.out.print(fraction.toString() + " + " + other.toString() + " = " + fraction.add(other).toString());
                break;
            case "-":
                fraction = getFraction();
                other = getFraction();
                System.out.print(fraction.toString() + " - " + other.toString() + " = " + fraction.subtract(other).toString());
                break;
            case "/":
                fraction = getFraction();
                other = getFraction();
                System.out.print(fraction.toString() + " / " + other.toString() + " = " + fraction.divide(other).toString());
                break;
            case "*":
                fraction = getFraction();
                other = getFraction();
                System.out.print(fraction.toString() + " * " + other.toString() + " = " + fraction.multiply(other).toString());
                break;
            case "=":
                fraction = getFraction();
                other = getFraction();
                if (fraction.equals(other))
                    System.out.print("Yes, they're equal");
                else System.out.print("No, they aren't equal");
                break;
            case "Q":
                System.exit(1);
                break;
            default:
                System.out.print("It's not an operation. ");
                getOperation();
                break;
        }
    }

    private static Fraction getFraction(){
        String string;
        int numerator, denominator;
        do {
            System.out.print("Please enter (a/b) or (a), where a and b are integers and b is not zero");
            string = scanner.next();
            if(!string.contains("/") || !isNumeric(string))
                System.out.print("It's not a fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero");
        } while (!string.contains("/"));
        numerator = Integer.parseInt(string.split("/")[0]);
        denominator = Integer.parseInt(string.split("/")[1]);
        if (denominator == 0)
            System.out.print("Illegal expression. Please enter (a/b) or (a), where a and b are integers and b is not zero");
        if(denominator < 0) {
            denominator = denominator*(-1);
            numerator = numerator * (-1);
        }
        return new Fraction(numerator, denominator);
    }

    private static boolean isNumeric(String str)
    {
        try
        {
            Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
