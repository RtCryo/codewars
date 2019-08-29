/*Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.

        s1 = "A aaaa bb c"

        s2 = "& aaa bbb c d"

        s1 has 4 'a', 2 'b', 1 'c'

        s2 has 3 'a', 3 'b', 1 'c', 1 'd'

        So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.

        We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.

        The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.

        In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing order of their length and when they have the same length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'. See examples and "Example Tests".

        Hopefully other examples can make this clearer.

        s1 = "my&friend&Paul has heavy hats! &"
        s2 = "my friend John has many many friends &"
        mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

        s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
        s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
        mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

        s1="Are the kids at home? aaaaa fffff"
        s2="Yes they are here! aaaaa fffff"
        mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"*/

package com.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class StringsMix {
    public static String mix(String s1, String s2) {
        String newS1 = s1.replaceAll("[^a-z]", "");
        String newS2 = s2.replaceAll("[^a-z]", "");

        List<String> resultList = new ArrayList<>();

        Map<String, Integer> mapS1 = new HashMap<>();
        Map<String, Integer> mapS2 = new HashMap<>();

        for (int i = 0; i < newS1.length(); i++) {
            Character temp1 = newS1.charAt(i);
            mapS1.put(temp1.toString(), mapS1.getOrDefault(temp1.toString(), 0) + 1);
        }

        for (int i = 0; i < newS2.length(); i++) {
            Character temp1 = newS2.charAt(i);
            mapS2.put(temp1.toString(), mapS2.getOrDefault(temp1.toString(), 0) + 1);
        }

        Set<String> keys = new HashSet<>(mapS1.keySet());

        keys.addAll(mapS2.keySet());


        for (String h : keys) {
            if (mapS1.getOrDefault(h, -1) > mapS2.getOrDefault(h, -1)) {
                if(mapS1.get(h) > 1){resultList.add("1:" + stringSum(h, mapS1.get(h)));}
            } else if (mapS1.getOrDefault(h, -1) < mapS2.getOrDefault(h, -1)) {
                if(mapS2.get(h) > 1)resultList.add("2:" + stringSum(h, mapS2.get(h)));
            } else {
                if(mapS1.get(h) > 1)resultList.add("=:" + stringSum(h, mapS2.get(h)));
            }
        }

        resultList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return 1;
                } else if (o2.length() < o1.length()) {
                    return -1;
                } else {
                    if (o1.charAt(0) < o2.charAt(0)) {
                        return -1;
                    } else if (o2.charAt(0) < o1.charAt(0)) {
                        return 1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
        });

        return resultList.stream().collect(Collectors.joining("/"));
    }

    public static String stringSum(String h, int t) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < t; i++) {
            temp.append(h);
        }
        return temp.toString();
    }


/*    public static String mix(String s1, String s2) {

        List<String> finalStr = new ArrayList();

        for (char c = 'a'; c <= 'z'; c++) {
            String s1_char = s1.replaceAll("[^" + c + "]+", "");
            String s2_char = s2.replaceAll("[^" + c + "]+", "");

            int s1_length = s1_char.length();
            int s2_length = s2_char.length();

            if (s1_length > 1 || s2_length > 1) {
                if (s1_length == s2_length) {
                    finalStr.add("=:" + s1_char);
                }
                if (s1_length > s2_length) {
                    finalStr.add("1:" + s1_char);
                }
                if (s1_length < s2_length) {
                    finalStr.add("2:" + s2_char);
                }
            }
        }
        Comparator<String> length = (x, y) -> y.length() - x.length();
        Comparator<String> type_value = (x, y) -> Character.compare(x.charAt(0), y.charAt(0));

        return finalStr.stream().sorted(length.thenComparing(type_value)).collect(Collectors.joining("/"));
    }*/
}