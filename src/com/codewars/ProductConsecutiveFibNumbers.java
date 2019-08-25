/*
The Fibonacci numbers are the numbers in the following integer sequence (Fn):

        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...

        such as

        F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.

        Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying

        F(n) * F(n+1) = prod.

        Your function productFib takes an integer (prod) and returns an array:

        [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True)
        depending on the language if F(n) * F(n+1) = prod.

        If you don't find two consecutive F(m) verifying F(m) * F(m+1) = prodyou will return

        [F(m), F(m+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False)
        F(m) being the smallest one such as F(m) * F(m+1) > prod.

        Examples
        productFib(714) # should return {21, 34, 1},
        # since F(8) = 21, F(9) = 34 and 714 = 21 * 34

        productFib(800) # should return {34, 55, 0},
        # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
        Notes: Not useful here but we can tell how to choose the number n up to which to go: we can use the "golden ratio" phi which is (1 + sqrt(5))/2 knowing that F(n) is asymptotic to: phi^n / sqrt(5). That gives a possible upper bound to n.
*/

package com.codewars;

public class ProductConsecutiveFibNumbers {
    public static long[] productFib(long prod) {

        long[] array = Fib(prod);
        if(array[0]*array[1] == prod){
            return new long[]{array[0],array[1],1};
        } else {
            return new long[]{array[0],array[1],0};
        }
    }

    public static long[] Fib (long i){

        long z1 = 0;
        long z2 = 1;

        for(;z2*z1 < i;){
            long temp = z2;
            z2 += z1;
            z1 = temp;
        }

        return new long[]{z1,z2};
    }
}

/*
    public static long[] productFib(long prod) {
        long a = 0L;
        long b = 1L;
        while (a * b < prod) {
            long tmp = a;
            a = b;
            b = tmp + b;
        }
        return new long[] { a, b, a * b == prod ? 1 : 0 };
    }*/
