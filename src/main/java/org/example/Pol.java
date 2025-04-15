package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pol {

    ArrayList<Integer> Coefficient;

    // class constructor
    public Pol(ArrayList<Integer> coefficients) {
        this.Coefficient = coefficients;
        //this.Coefficient = new ArrayList<>(Coefficient);
    }

    public ArrayList<Integer> getCoefficients() {
        return Coefficient;
    }

    // implementation of +=
    public void add(Pol other) {
        this.Coefficient = Objects.requireNonNull(polynomialOperations(this, other, '+')).getCoefficients();
    }

    // implementation of -=
    public void subtract(Pol other) {
        this.Coefficient = Objects.requireNonNull(polynomialOperations(this, other, '-')).getCoefficients();
    }

    // implementation of *=
    public void multiply(Pol other) {
        this.Coefficient = Objects.requireNonNull(polynomialOperations(this, other, '*')).getCoefficients();
    }


    static int polynomialDegree(Pol pol) {
        ArrayList<Integer> coeff = pol.getCoefficients();

        // returning degree or -1 if the polynomial is incorrect
        for (int i = coeff.size() - 1; i >= 0; i--) {
            if (coeff.get(i) != 0) {
                return i;
            }
        }
        return -1;
    }

    public static void printPol(Pol polynomial) {
        if (polynomial != null) {
            ArrayList<Integer> pol = polynomial.getCoefficients();
            System.out.print("W(x): ");
            for (int i = pol.size() - 1; i >= 0; i--) {
                // skipping blank variables
                if (pol.get(i) == 0) {
                    continue;
                }
                if (i != pol.size() - 1) {
                    System.out.print(pol.get(i) > 0 ? " + " : " ");  // adding "+" for positive coefficients
                }

                System.out.print(pol.get(i));

                if (i > 0) {
                    System.out.print("x^" + i);
                }
            }
            System.out.println("\n");
        } else throw new IllegalArgumentException("empty polynomial");
    }

    public static double polynomialValue(Pol pol, int arg) {
        ArrayList<Integer> coeff = pol.getCoefficients();
        int result = 0;

        for (int i = coeff.size() - 1; i >= 0; i--) {
            if (i == coeff.size() - 1) {
                result += coeff.get(i);
            } else result += (coeff.get(i) * arg);
        }

        return result;
    }

    public static Pol polynomialOperations(Pol pol, Pol pol2, char option) {
        ArrayList<Integer> coeff1 = pol.getCoefficients();
        ArrayList<Integer> coeff2 = pol2.getCoefficients();

        int deg1 = coeff1.size();
        int deg2 = coeff2.size();
        int max = Math.max(deg1, deg2);

        ArrayList<Integer> result = new ArrayList<>();

        switch (option) {
            case '+':
                for (int i = 0; i < max; i++) {
                    int a = (i < deg1) ? coeff1.get(i) : 0;
                    int b = (i < deg2) ? coeff2.get(i) : 0;
                    result.add(a + b);
                }
                break;

            case '-':
                for (int i = 0; i < max; i++) {
                    int a = (i < deg1) ? coeff1.get(i) : 0;
                    int b = (i < deg2) ? coeff2.get(i) : 0;
                    result.add(a - b);
                }
                break;

            case '*':
                int degResult = deg1 + deg2 - 1;
                for (int i = 0; i < degResult; i++) result.add(0);

                for (int i = 0; i < deg1; i++) {
                    for (int j = 0; j < deg2; j++) {
                        int value = result.get(i + j) + coeff1.get(i) * coeff2.get(j);
                        result.set(i + j, value);
                    }
                }
                break;

            default:
                System.out.println("invalid operation");
                return null;
        }

        // deleting additional zeros
        while (result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        return new Pol(result);
    }

    public static void main(String[] args) {
        /*rrayList<Integer> coeff = new ArrayList<>(Arrays.asList(64, 0, -3, -16, 0, 0, 1));
        ArrayList<Integer> coeff2 = new ArrayList<>(Arrays.asList(3, 4, -3, 12, -8, 0, -4));
        Pol polynomial = new Pol(coeff);
        Pol polynomial2 = new Pol(coeff2);*/

        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(3, 2, 1));         // 1x^2 + 2x + 3
        ArrayList<Integer> c2 = new ArrayList<>(Arrays.asList(-1, 2, 4, 8));    // 8x^3 + 4x^2 + 2x - 1

        Pol p = new Pol(c);
        Pol p2 = new Pol(c2);

        // printing in legible form
        printPol(p);
        printPol(p2);

        // degree of a polynomial
        System.out.println("1st polynomial degree: " + polynomialDegree(p) + "\n");

        // calculating W(val)
        int val = 1;
        System.out.print("W(" + val + "): ");
        System.out.println(polynomialValue(p, val) + "\n");

        System.out.println("adding: ");
        printPol(polynomialOperations(p, p2, '+'));
        System.out.println("subtracting: ");
        printPol(polynomialOperations(p, p2, '-'));
        System.out.println("multiplying: ");
        printPol(polynomialOperations(p, p2, '*'));

        System.out.println("W1 after += W2: ");
        p.add(p2);
        printPol(p);
        //System.out.println("W1 -= W2: ");
        //p.subtract(p2);
    }
}