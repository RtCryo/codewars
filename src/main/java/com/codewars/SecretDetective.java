/*There is a secret string which is unknown to you. Given a collection of random triplets from the string, recover the original string.

        A triplet here is defined as a sequence of three letters such that each letter occurs somewhere before
        the next in the given string. "whi" is a triplet for the string "whatisup".

        As a simplification, you may assume that no letter occurs more than once in the secret string.

        You can assume nothing about the triplets given to you other than that they are valid triplets and
        that they contain sufficient information to deduce the original string. In particular, this means
        that the secret string will never contain letters that do not occur in one of the triplets given to you.*/

package com.codewars;

import java.util.*;

public class SecretDetective {
    public static String recoverSecret(char[][] triplets) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < triplets.length; i++) {
            for (int j = 0; j < triplets[i].length; j++) {
                map.put(triplets[i][j], (j + 1) * 100);
            }
        }
        int count = triplets.length;

        while (count > 0) {
            for (int i = 0; i < triplets.length; i++) {
                if (map.get(triplets[i][1]) != null && map.getOrDefault(triplets[i][0], 0) <= map.getOrDefault(triplets[i][1], 0)) {
                    map.put(triplets[i][0], map.get(triplets[i][1]) + 10);
                } else if (map.get(triplets[i][2]) != null && map.getOrDefault(triplets[i][1], 0) <= map.getOrDefault(triplets[i][2], 0)) {
                    map.put(triplets[i][1], map.get(triplets[i][2]) + 10);
                }
            }
            count--;
        }

        StringBuilder str = new StringBuilder();

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry entry : result.entrySet()) {
            str.append(entry.getKey());
        }

        return str.toString();
    }
}

/*import java.util.*;

// This is a topological sort problem.
// This is _not_ a particularly fast algorithm, and isn't general, but it's straightforward.
public class SecretDetective {

    // Convert the input format to the data structure I want to use
    private static Map<Character, Set<Character>> buildEdgeMap(char[][] triplets) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for(char[] cs : triplets) {
            for (char c : cs) {
                if (!map.containsKey(c)) map.put(c, new HashSet<>());
            }
            map.get(cs[0]).add(cs[1]);
            map.get(cs[1]).add(cs[2]);
        }
        return map;
    }

    // Find a node with no outgoing edges
    private static char findLast(Map<Character, Set<Character>> map) {
        for(Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No end point");
    }

    // Remove a node from the graph
    private static void remove(Map<Character, Set<Character>> map, Character c) {
        map.remove(c);
        for(Set<Character> cs : map.values()) {
            cs.remove(c);
        }
    }

    // Reconstruct the string
    public String recoverSecret(char[][] triplets) {
        StringBuilder builder = new StringBuilder();
        Map<Character, Set<Character>> map = buildEdgeMap(triplets);

        while(!map.isEmpty()) {
            char last = findLast(map);
            builder.insert(0, last);
            remove(map, last);
        }

        return builder.toString();
    }
}*/
