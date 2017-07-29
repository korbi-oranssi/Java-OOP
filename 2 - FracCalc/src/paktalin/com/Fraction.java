package paktalin.com;

import java.math.BigInteger;

/**
 * Created by Paktalin on 24.07.2017.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) throws IllegalArgumentException {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    Fraction(int numerator) {
        this(numerator, 1);
    }

    public String toString(){
        return numerator+"/"+denominator;
    }

    Fraction add(Fraction other) {
        Fraction f = new Fraction(numerator*other.denominator + other.numerator*denominator, denominator * other.denominator);
        return toLowestTerms(f);
        //return f;
    }

    Fraction subtract(Fraction other) {
        Fraction f = new Fraction(numerator*other.denominator - other.numerator*denominator, denominator * other.denominator);
        return toLowestTerms(f);
    }

    Fraction multiply(Fraction other) {
        Fraction f = new Fraction(numerator*other.numerator, denominator * other.denominator);
        return toLowestTerms(f);
    }

    Fraction divide(Fraction other) {
        if (other.denominator == 0){
            throw new IllegalArgumentException("the denominator cant't be 0");
        }
        Fraction f = new Fraction(numerator*other.denominator, denominator * other.numerator);
        return toLowestTerms(f);
    }

    public boolean equals (Object other) {
        if (other instanceof Fraction){
            Fraction other_fraction = toLowestTerms((Fraction)other);
            return toLowestTerms(this).numerator == other_fraction.numerator &&  toLowestTerms(this).denominator == other_fraction.denominator;
        }else throw new IllegalArgumentException("not Fracture argument");

    }

    private Fraction toLowestTerms(Fraction fraction) {
        int gcd = gcd(fraction.numerator, fraction.denominator);
        return new Fraction(fraction.numerator/gcd, fraction.denominator/gcd);
    }

    private int gcd(int numerator, int denominator) {
        BigInteger b1 = BigInteger.valueOf(numerator);
        BigInteger b2 = BigInteger.valueOf(denominator);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
