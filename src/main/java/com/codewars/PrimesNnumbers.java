/*Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :

        "(p1**n1)(p2**n2)...(pk**nk)"
        with the p(i) in increasing order and n(i) empty if n(i) is 1.

        Example: n = 86240 should return "(2**5)(5)(7**2)(11)"*/

package com.codewars;

import java.util.stream.IntStream;

public class PrimesNnumbers {
    public static String factors(int n) {

        int number = n;
        StringBuilder result = new StringBuilder();
        int z = 2;

        while (number > 1) {
            if (number % z == 0) {
                int k = 0;
                while (number % z == 0) {
                    k += 1;
                    number /= z;
                }
                result.append("(").append(z).append(k > 1 ? "**" + k : "").append(")");
            }
            z = nextPrime(z);
            if(z *z > number) {
                result.append("(").append(number).append(")");
                break;
            }
        }

        return result.toString();
    }

    private static int nextPrime(final int number) {
        int i = number + 1;
        while (!isPrime(i) && i < number * 2)
            i++;
        return i;
    }

    private static boolean isPrime(final int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

/*    public static String factors(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }*/


}
