package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Degree of a polynomial")
    void testPolynomialDegree() {
        ArrayList<Integer> coeff = new ArrayList<>(Arrays.asList(-3, 2, 0, 2, 1));  // 1x^4 + 2x^3 + 2x - 3
        ArrayList<Integer> coeff2 = new ArrayList<>(List.of(-1));               // -1
        ArrayList<Integer> coeff3 = new ArrayList<>();                              // blank

        Pol polynomial = new Pol(coeff);
        Pol polynomial2 = new Pol(coeff2);
        Pol polynomial3 = new Pol(coeff3);

        int deg = Pol.polynomialDegree(polynomial);
        int deg2 = Pol.polynomialDegree(polynomial2);
        int deg3 = Pol.polynomialDegree(polynomial3);

        assertAll(() -> Assertions.assertEquals(4, deg),
                () -> Assertions.assertEquals(0, deg2),
                () -> Assertions.assertEquals(-1, deg3));                   // incorrect/blank
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Value of a polynomial")
    void testPolynomialValue() {
        ArrayList<Integer> coeff = new ArrayList<>(Arrays.asList(-3, 2, 0, 2, 1));  // 1x^4 + 2x^3 + 2x - 3
        Pol polynomial = new Pol(coeff);
        assertAll(() -> Assertions.assertEquals(2, Pol.polynomialValue(polynomial, 1)),
                () -> Assertions.assertEquals(1, Pol.polynomialValue(polynomial, 0)),
                () -> Assertions.assertEquals(0, Pol.polynomialValue(polynomial, -1)));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Operations on polynomial")
    void testPolynomialOperations() {
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(3, 2, 1));         // 1x^2 + 2x + 3
        ArrayList<Integer> c2 = new ArrayList<>(Arrays.asList(-1, 2, 4, 8));    // 8x^3 + 4x^2 + 2x - 1

        Pol p = new Pol(c);
        Pol p2 = new Pol(c2);

        // 8x^3 + 5x^2 + 4x + 2
        ArrayList<Integer> coeffAdd = new ArrayList<>(Arrays.asList(2, 4, 5, 8));
        Pol polynomialAdd = new Pol(coeffAdd);

        // -8x^3 - 3x^2 + 4
        ArrayList<Integer> coeffSubtract = new ArrayList<>(Arrays.asList(4, 0, -3, -8));
        Pol polynomialSubtract = new Pol(coeffSubtract);

        // 8x^5 + 20x^4 + 34x^3 + 15x^2 + 4x - 3
        ArrayList<Integer> coeffMultiply = new ArrayList<>(Arrays.asList(-3, 4, 15, 34, 20, 8));
        Pol polynomialMultiply = new Pol(coeffMultiply);

        Pol resultAdd = Pol.polynomialOperations(p, p2, '+');
        Pol resultSubtract = Pol.polynomialOperations(p, p2, '-');
        Pol resultMultiply = Pol.polynomialOperations(p, p2, '*');

        assertAll(() -> Assertions.assertEquals(polynomialAdd, resultAdd),
                () -> Assertions.assertEquals(polynomialSubtract, resultSubtract),
                () -> Assertions.assertEquals(polynomialMultiply, resultMultiply));
    }

}