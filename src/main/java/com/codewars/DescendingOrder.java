/*Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

        Examples:
        Input: 21445 Output: 54421

        Input: 145263 Output: 654321

        Input: 1254859723 Output: 9875543221*/

package com.codewars;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
    public static int sortDesc(final int num) {

        String[] arr = String.valueOf(num).split("");
        Arrays.sort(arr, Collections.reverseOrder());

        return Integer.valueOf(String.join("", arr));
    }
}


/*
    public static int sortDesc(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }*/
