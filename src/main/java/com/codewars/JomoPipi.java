/*Welcome
        this is the second in the series of the string iterations kata!

        Here we go!

        We have a string s

        Let's say you start with this: "String"

        The first thing you do is reverse it: "gnirtS"

        Then you will take the string from the 1st position and reverse it again: "gStrin"

        Then you will take the string from the 2nd position and reverse it again: "gSnirt"

        Then you will take the string from the 3rd position and reverse it again: "gSntri"

        Continue this pattern until you have done every single position, and then you will return the string you have created. For this particular string, you would return: "gSntir"

        now,

        The Task:
        In this kata, we also have a number x

        take that reversal function, and apply it to the string x times.

        return the result of the string after applying the reversal function to it x times.

        example where s = "String" and x = 3:

        after 0 iteration  s = "String"
        after 1 iteration  s = "gSntir"
        after 2 iterations s = "rgiStn"
        after 3 iterations s = "nrtgSi"

        so you would return "nrtgSi".
        Note
        String lengths may exceed 2 million

        x exceeds a billion

        be read to optimize*/

package com.codewars;

public class JomoPipi {
    public static String stringFunc(String s, long x) {

        if (x == 0) {
            return s;
        }

        StringBuilder str = new StringBuilder(s);

/*        for (long i = 0; i < x; i++) {
            str.reverse();
            for (int h = 1; h < str.length() - 1; h++) {
                StringBuilder temp = new StringBuilder(str.substring(h, str.length()));
                for (int o = temp.length(); o > 0; o--) {
                    int p = temp.length() - o + h;
                    str.setCharAt(p, temp.charAt(o - 1));
                }
            }
        }*/

        for (long i = 0; i < x; i++) {
            str.reverse();
            for (int h = 1; h < str.length() - 1; h++) {
                str = new StringBuilder(new StringBuilder(str.substring(0, h) + new StringBuilder(str.substring(h)).reverse()));
            }
        }

        return str.toString();
    }
}


/*
import java.util.*;
        import java.math.BigInteger;
public class JomoPipi {

    static int[] cyclelengths = new int[40001];
    public static String stringFunc(String s, long x) {
        System.out.println(s.length() + ',' + x);
        int n = s.length();
        boolean b = n > 40000;
        if (b || cyclelengths[n] == 0)
        {
            int m = 5, l = n, y;
            BigInteger t = BigInteger.valueOf(2), L = BigInteger.valueOf(2*l+1);
            while(true) {
                y = (t.pow(++m).mod(L)).intValue();
                if (y == 1 || y == 2*l) break;
            }
            x %= m;
            if (!b) cyclelengths[n] = m;
        }
        else x %= cyclelengths[n];
        StringBuilder mut = new StringBuilder(s);

        List<Integer> idx = new ArrayList<>();
        for (int ii=1 ; ii<n ; ii+=2)        idx.add(ii);
        for (int ii=n-2+n%2 ; ii>=0 ; ii-=2) idx.add(ii);

        while (x-- > 0) {
            for(int j=0 ; j < idx.size() ; j++) mut.setCharAt(idx.get(j), s.charAt(j));
            s = mut.toString();
        }
        return s;
    }
}*/
