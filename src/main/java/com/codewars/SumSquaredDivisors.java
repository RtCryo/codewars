/*Divisors of 42 are : 1, 2, 3, 6, 7, 14, 21, 42. These divisors squared are: 1, 4, 9, 36, 49, 196, 441, 1764. The sum of the squared divisors is 2500 which is 50 * 50, a square!

        Given two integers m, n (1 <= m <= n) we want to find all integers between m and n whose sum of squared divisors is itself a square. 42 is such a number.

        The result will be an array of arrays or of tuples (in C an array of Pair) or a string, each subarray having two elements, first the number whose squared divisors is a square and then the sum of the squared divisors.

        #Examples:

        list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
        list_squared(42, 250) --> [[42, 2500], [246, 84100]]
        The form of the examples may change according to the language, see Example Tests: for more details.*/

package com.codewars;

import java.util.ArrayList;
import java.util.List;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {

        List<long[]> result = new ArrayList<>();

        for (long i = m; i < n; i++) {
            List<Long> listDiv = new ArrayList<>();
            long sum = 0;
            for (long j = 1; j <= i; j++) {
                if (i % j == 0) {
                    listDiv.add(j);
                }
            }
            for (long g : listDiv) {
                sum += g * g;
            }
            if (Math.sqrt(sum) % 1 == 0) {
                if (Math.sqrt(sum) * Math.sqrt(sum) == sum) {
                    result.add(new long[]{i, sum});
                }
            }
        }

        StringBuilder str = new StringBuilder();

        str.append("[");

        for (int i = 0; i < result.size(); i++) {
            str.append("[").append(result.get(i)[0]).append(", ").append(result.get(i)[1]).append("]");
            if (i != result.size() - 1) {
                str.append(", ");
            }
        }

        str.append("]");

        return str.toString();

    }
}

/*
import java.util.stream.LongStream;
public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        // your code
        String result = "[";
        for(long i=m; i<=n; i++) {
            if(Math.round(Math.sqrt(sumOfSquareDivisors(i))) == Math.sqrt(sumOfSquareDivisors(i))) {
                result+= "["+i +", "+sumOfSquareDivisors(i)+"], ";
            }
        }
        return result.length()>1 ? result.substring(0, result.length()-2)+"]" : "[]";
    }


    public static long sumOfSquareDivisors(long n) {
        return LongStream.range(1, n + 1)
                .filter(i -> n % i == 0)
                .map(i -> i * i)
                .sum();
    }
}*/
