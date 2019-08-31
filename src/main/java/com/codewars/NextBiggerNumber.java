/*You have to create a function that takes a positive integer number and returns the next bigger number formed by the same digits:

        12 ==> 21
        513 ==> 531
        2017 ==> 2071
        If no bigger number can be composed using those digits, return -1:

        9 ==> -1
        111 ==> -1
        531 ==> -1*/

package com.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextBiggerNumber {
    public static long nextBiggerNumber(long n) {

        if (n < 11) {
            return -1;
        }

        List<Long> list = new ArrayList<>();
        for (String i : String.valueOf(n).split("")) {
            list.add(Long.valueOf(i));
        }

        for (int i = list.size() - 1; i >= 1; i--) {
            if (list.get(i) > list.get(i - 1)) {
                List<Long> tempSubList = list.subList(i, list.size());
                Collections.sort(tempSubList);
                for (Long m : tempSubList) {
                    if (list.get(i - 1) < m) {
                        tempSubList.set(tempSubList.indexOf(m), list.get(i - 1));
                        list.set(i - 1, m);
                        break;
                    }
                }

                StringBuilder result = new StringBuilder();
                for (Long o : list) {
                    result.append(o);
                }
                return Long.valueOf(result.toString());
            }
        }

        return -1;
    }
}


/*
import java.util.Arrays;
public class Kata
{
    public static long nextBiggerNumber(long n)
    {
        char [] s = String.valueOf(n).toCharArray();
        for(int i = s.length - 2; i >= 0; i--){
            for (int j = s.length-1; j > i; j--){
                if(s[i] < s[j]){
                    char tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                    Arrays.sort(s, i+1, s.length);
                    return Long.valueOf(String.valueOf(s));
                }
            }
        }
        return -1;
    }
}*/
