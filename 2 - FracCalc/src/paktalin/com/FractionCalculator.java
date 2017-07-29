package paktalin.com;

import java.util.Scanner;

/**
 * Created by Paktalin on 24.07.2017.
 */
public class FractionCalculator {
    private static Scanner scanner = new Scanner(System.in);
    private static Fraction fraction, other;

    public static void main (String[] args) {
        System.out.print("This program is a fracture calculator\n" +
                "It will add, subtract, multiply and divide fractions until you type Q to quit.\n" +
                "_____________________________________________________________________________\n");
        while(true){
            fraction = getFraction();
            getOperation();
        }
    }

    private static void getOperation() {
        System.out.println("Please enter an operation +, -, /, *, = or Q to exit");
        switch (scanner.next()){
            case "+":
                other = getFraction();
                System.out.print(fraction.toString() + " + " + other.toString() + " = " + fraction.add(other).toString()+ "\n\n");
                break;
            case "-":
                other = getFraction();
                System.out.print(fraction.toString() + " - " + other.toString() + " = " + fraction.subtract(other).toString()+ "\n\n");
                break;
            case "/":
                other = getFraction();
                System.out.print(fraction.toString() + " / " + other.toString() + " = " + fraction.divide(other).toString()+ "\n\n");
                break;
            case "*":
                other = getFraction();
                System.out.print(fraction.toString() + " * " + other.toString() + " = " + fraction.multiply(other).toString()+ "\n\n");
                break;
            case "=":
                other = getFraction();
                if (fraction.equals(other))
                    System.out.print("Yes, they're equal");
                else System.out.print("No, they aren't equal");
                break;
            case "Q":
                System.exit(1);
                break;
            default:
                System.out.print("Illegal expression ");
                getOperation();
                break;
        }
    }

    private static Fraction getFraction() {
        String string;
        System.out.print("Please enter (a/b) or (a), where a and b are integers and b is not zero, or Q to exit\n");
        string = scanner.next();
        if (isValid(string)) {
            if (!(string.contains("/")))
                return new Fraction(Integer.parseInt(string));
            return new Fraction(Integer.parseInt(string.split("/")[0]), Integer.parseInt(string.split("/")[1]));
        }
        if(string.equals("Q"))
            System.exit(1);
        System.out.print("Illegal expression ");
        getFraction();
        return null;
    }

    private static boolean isNumeric(String str) {
        try
        {
            Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private static boolean isValid(String string) {
        if(string.contains("/")){
            String num = string.split("/")[0];
            String den = string.split("/")[1];
            if(isNumeric(num) && isNumeric(den)){
                if(!den.equals("0"))
                    return true;
            }
        } else{
            if(isNumeric(string))
                return true;
        }
        return false;
    }
}
