/*"7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?

        Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).

        It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.

        Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.

        "Interesting" Numbers
        Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:

        Any digit followed by all zeros: 100, 90000
        Every digit is the same number: 1111
        The digits are sequential, incementing†: 1234
        The digits are sequential, decrementing‡: 4321
        The digits are a palindrome: 1221 or 73837
        The digits match one of the values in the awesomePhrases array
        † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
        ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.

        So, you should expect these inputs and outputs:

// "boring" numbers
        CarMileage.isInteresting(3, new int[]{1337, 256});    // 0
        CarMileage.isInteresting(3236, new int[]{1337, 256}); // 0

// progress as we near an "interesting" number
        CarMileage.isInteresting(11207, new int[]{}); // 0
        CarMileage.isInteresting(11208, new int[]{}); // 0
        CarMileage.isInteresting(11209, new int[]{}); // 1
        CarMileage.isInteresting(11210, new int[]{}); // 1
        CarMileage.isInteresting(11211, new int[]{}); // 2

// nearing a provided "awesome phrase"
        CarMileage.isInteresting(1335, new int[]{1337, 256}); // 1
        CarMileage.isInteresting(1336, new int[]{1337, 256}); // 1
        CarMileage.isInteresting(1337, new int[]{1337, 256}); // 2*/

package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarMileage {
    public static int isInteresting(int number, int[] awesomePhrases) {
        for (int z : awesomePhrases) {
            if (number == z) {
                return 2;
            } else if (number + 1 == z || number + 2 == z) {
                return 1;
            }
        }
        if (number < 98) {
            return 0;
        }
        if (number == 98 || number == 99) {
            return 1;
        }

        for (int b = 0; b <= 2; b++, number++) {
            String[] str = String.valueOf(number).split("");
            int[] list = Arrays.stream(str).mapToInt((s) -> Integer.parseInt(s)).toArray();

            {
                int sum = 0;
                for (int i = 1; i <= list.length - 2; i++) {
                    sum += list[i];
                }
                if (sum + list[list.length - 1] == 0) {
                    return b == 0 ? 2 : 1;
                }
            }
            {
                int u = -1;
                boolean flagEqually = true;
                for (int i = 1; i <= list.length - 1; i++) {
                    if (!(list[0] == list[i])) {
                        if (i == list.length - 1) {
                            u = list[i];
                        } else {
                            flagEqually = false;
                        }
                        break;
                    }
                }
                if (flagEqually) {
                    if (u == -1) {
                        return b == 0 ? 2 : 1;
                    }
                }
            }
            {
                boolean flagInc = true;
                int u = list[0];
                for (int i = 1; i <= list.length - 1; i++) {
                    if (!(++u == list[i])) {
                        if (i == list.length - 1) {
                            if (u == 10 && list[i] == 0) {
                                return b == 0 ? 2 : 1;
                            }
                        }
                        flagInc = false;
                        break;
                    }
                }
                if (flagInc) {
                    return b == 0 ? 2 : 1;
                }
            }
            {
                boolean flagDec = true;
                int u = list[0];
                for (int i = 1; i <= list.length - 1; i++) {
                    if (!(--u == list[i])) {
                        if (i == list.length - 1) {
                            if (u == 10 && list[i] == 0) {
                                return b == 0 ? 2 : 1;
                            }
                        }
                        flagDec = false;
                        break;
                    }
                }
                if (flagDec) {
                    return b == 0 ? 2 : 1;
                }
            }
            {
                List<Integer> aList = new ArrayList<>();
                for (int u : list) {
                    aList.add(u);
                }
                int m;
                if (aList.size() % 2 == 0) {
                    m = aList.size() / 2;
                } else {
                    m = (aList.size() - 1) / 2;
                }
                StringBuilder str1 = new StringBuilder();
                StringBuilder str2 = new StringBuilder();

                for (int i = 0; i < m; i++) {
                    str1.append(aList.get(i));
                }
                for (int i = aList.size() - 1; aList.size() % 2 == 0 ? i >= m : i > m; i--) {
                    str2.append(aList.get(i));
                }
                if (str1.toString().equals(str2.toString())) {
                    return b == 0 ? 2 : 1;
/*                    if (aList.size() % 2 == 0) {
                        return b == 0?2:1;
                    } else {
                        if ((1 + aList.get(m - 1)) == (aList.get(m))) {
                            return b == 0?2:1;
                        }
                    }*/
                }
            }
        }
        return 0;
    }
}

/*
import java.util.Arrays;
        import java.util.function.Predicate;
        import java.util.stream.Stream;

        import static java.lang.Integer.parseInt;

public class CarMileage {

    public static boolean isReallyInteresting(int number, final int[] awesomePhrases) {
        return Stream.<Predicate<String>>of(
                s -> s.matches("\\d0+"),
                s -> new StringBuilder(s).reverse().toString().equals(s),
                s -> "1234567890".contains(s),
                s -> "9876543210".contains(s),
                s -> Arrays.stream(awesomePhrases).anyMatch(n -> parseInt(s) == n)
        ).anyMatch( p -> number > 99 && p.test(Integer.toString(number)));
    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        return isReallyInteresting(number, awesomePhrases) ? 2 :
                isReallyInteresting(number + 1, awesomePhrases) ? 1 :
                        isReallyInteresting(number + 2, awesomePhrases) ? 1 : 0;
    }

}*/
