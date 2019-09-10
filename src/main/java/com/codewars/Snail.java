/*Snail Sort
        Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.

        array = [[1,2,3],
        [4,5,6],
        [7,8,9]]
        snail(array) #=> [1,2,3,6,9,8,7,4,5]
        For better understanding, please follow the numbers of the next array consecutively:

        array = [[1,2,3],
        [8,9,4],
        [7,6,5]]
        snail(array) #=> [1,2,3,4,5,6,7,8,9]*/

package com.codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snail {
    public static int[] snail(int[][] array) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listResult = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(new ArrayList<>());
            for (int z : array[i]) {
                list.get(i).add(z);
            }
        }

        while (!list.isEmpty()) {
            for (int p = 0; list.size() > 0; p++) {
                switch (p) {
                    case (0):
                        listResult.addAll(list.get(0));
                        list.remove(0);
                        break;
                    case (1):
                        for (int i = 0; i < list.size() - 1; i++) {
                            listResult.add(list.get(i).get(list.get(i).size() - 1));
                            list.get(i).remove(list.get(i).size() - 1);
                        }
                        break;
                    case (2):
                        Collections.reverse(list.get(list.size() - 1));
                        listResult.addAll(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                        break;
                    case (3):
                        for (int u = list.size() - 1; u >= 0; u--) {
                            listResult.add(list.get(u).get(0));
                            list.get(u).remove(0);
                        }
                        p = -1;
                        break;
                }
            }
        }

        int[] result = new int[listResult.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = listResult.get(i);
        }

        return result;
    }
}

/*
public class Snail {

    public static int[] snail(int[][] array) {
        if (array[0].length == 0) return new int[0];
        int n = array.length;
        int[] answer = new int[n*n];
        int index=0;
        for (int i = 0; i<n/2; i++){
            for (int j = i; j < n-i; j++) answer[index++] = array[i][j];
            for (int j = i+1; j < n-i; j++) answer[index++] = array[j][n-i-1];
            for (int j = i+1; j < n-i; j++) answer[index++] = array[n-i-1][n-j-1];
            for (int j = i+1; j < n-i-1; j++) answer[index++] = array[n-j-1][i];
        }
        if (n%2 != 0) answer[index++] = array[n/2][n/2];
        return answer;
    }
}*/
