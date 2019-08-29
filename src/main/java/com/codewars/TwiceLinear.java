/*Consider a sequence u where u is defined as follows:

        The number u(0) = 1 is the first one in u.
        For each x in u, then y = 2 * x + 1 and z = 3 * x + 1 must be in u too.
        There are no other numbers in u.
        Ex: u = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]

        1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and 22 and so on...

        Task:
        Given parameter n the function dbl_linear (or dblLinear...) returns the element u(n) of the ordered (with <) sequence u (so, there are no duplicates).

        Example:
        dbl_linear(10) should return 22

        Note:
        Focus attention on efficiency*/

package com.codewars;

import java.util.*;

public class TwiceLinear {
    public static int dbl_linear(int n) {
        Queue<Integer> queue  = new PriorityQueue<>();
        Set<Integer> setLst = new TreeSet<>();
        setLst.add(1);


        for (int i = 1; setLst.size()/2 < n; i = queue.poll()) {
            int x = i * 2 + 1;
            int y = i * 3 + 1;
            setLst.add(x);
            setLst.add(y);
            queue.add(x);
            queue.add(y);
        }

        return new ArrayList<>(setLst).get(n);
    }
}

/*
    public static int dblLinear(int n) {
        if (n == 0) return 1;
        SortedSet<Integer> u = new TreeSet<>();
        u.add(1);
        for(int i=0; i<n; i++) {
            int x = u.first();
            u.add(x*2+1);
            u.add(x*3+1);
            u.remove(x);
        }
        return u.first();
    }*/
