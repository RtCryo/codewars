/*A perfect power is a classification of positive integers:

        In mathematics, a perfect power is a positive integer that can be expressed as an integer power of another positive integer. More formally, n is a perfect power if there exist natural numbers m > 1, and k > 1 such that mk = n.

        Your task is to check wheter a given integer is a perfect power. If it is a perfect power, return a pair m and k with mk = n as a proof. Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.

        Note: For a perfect power, there might be several pairs. For example 81 = 3^4 = 9^2, so (3,4) and (9,2) are valid solutions. However, the tests take care of this, so if a number is a perfect power, return any pair that proves it.

        Examples
        isPerfectPower(4) => new int[]{2,2}
        isPerfectPower(5) => null
        isPerfectPower(8) => new int[]{2,3}
        isPerfectPower(9) => new int[]{3,2}*/

package com.codewars;

import java.util.ArrayList;
import java.util.List;

public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            long count = 1;
            long p = i;
            while (p < n) {
                p = p * i;
                count++;
            }
            if (p == n && count > 1) {
                list.add(i);
                list.add((int)count);
            }
        }
        if (list.size() > 0) {
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
            return result;
        }
        return null;
    }
}

/*
public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for (int i = 2; ; i++) {
            int root = (int) Math.round(Math.pow(n, 1.0 / i));
            if (root < 2) return null;
            if (Math.pow(root, i) == n) return new int[]{root, i};
        }
    }
}*/
