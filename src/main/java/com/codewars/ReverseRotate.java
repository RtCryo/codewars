/*The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).

        If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.

        If

        sz is <= 0 or if str is empty return ""
        sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
        Examples:
        revrot("123456987654", 6) --> "234561876549"
        revrot("123456987653", 6) --> "234561356789"
        revrot("66443875", 4) --> "44668753"
        revrot("66443875", 8) --> "64438756"
        revrot("664438769", 8) --> "67834466"
        revrot("123456779", 8) --> "23456771"
        revrot("", 8) --> ""
        revrot("123456779", 0) --> ""
        revrot("563000655734469485", 4) --> "0365065073456944"*/

package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseRotate {
    public static String revRot(String strng, int sz) {
        List<String> array = new ArrayList();
        List<String> result = new ArrayList();
        int subBeginIndex = 0;
        int subEndIndex = sz;
        if (sz <= 0 || sz > strng.length()) {
            return "";
        }
        while (strng.length() >= subEndIndex) {
            array.add(strng.substring(subBeginIndex, subEndIndex));
            subBeginIndex += sz;
            subEndIndex += sz;
        }

        for (String h : array) {
            List<String> temp = Arrays.asList(h.split(""));
            long sum = 0;
            for (String k : temp) {
                sum += Long.parseLong(k) * Long.parseLong(k) * Long.parseLong(k);
            }
            if (sum % 2 == 0) {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    result.add(temp.get(i));
                }
            } else {
                for (int i = 1; i < temp.size(); i++) {
                    result.add(temp.get(i));
                }
                result.add(temp.get(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s);
        }

        return sb.toString();

    }
}

/*
    public static String revRot(String nums, int sz) {
        StringBuffer groups = new StringBuffer();
        for (int i = 0, len = nums.length(); i + sz <= len && sz > 0; i += sz) {
            String group = nums.substring(i, i + sz);
            groups.append(isDivisible(group) ? new StringBuffer(group).reverse() : group.substring(1) + group.charAt(0));
        }
        return groups.toString();
    }

    public static boolean isDivisible(String group) {
        int sum = 0;
        for (char num : group.toCharArray()) {
            sum += Character.getNumericValue(num);
        }
        return sum % 2 == 0;
    }*/
