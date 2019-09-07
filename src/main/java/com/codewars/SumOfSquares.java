/*The task is simply stated. Given an integer n (3 < n < 109), find the length of the smallest list of perfect squares which add up to n. Come up with the best algorithm you can; you'll need it!

        Examples:

        sum_of_squares(17) = 2
        17 = 16 + 1 (4 and 1 are perfect squares).
        sum_of_squares(15) = 4
        15 = 9 + 4 + 1 + 1. There is no way to represent 15 as the sum of three perfect squares.
        sum_of_squares(16) = 1
        16 itself is a perfect square.*/

//Lagrange's four-square theorem, also known as Bachet's conjecture, states that every natural number can be represented as the sum of four integer squares.

package com.codewars;

public class SumOfSquares {
    public static int nSquaresFor(int n) {

        if (Math.sqrt(n) % 1 == 0) {
            return 1;
        }


        for (int t = 1; t * t <= n; t++) {
            if (Math.sqrt(n - t * t) % 1 == 0) {
                return 2;
            }
        }

        //In mathematics, Legendre's three-square theorem states that a natural number can be represented as the sum of three squares of integers
        //
        //n=x^{2}+y^{2}+z^{2}
        //if and only if n is not of the form n = 4^a(8b + 7) for nonnegative integers a and b.

        while (n % 4 == 0) {
            n /= 4;
        }

        if (n % 8 == 7) {
            return 4;
        }

        return 3;

    }
}
