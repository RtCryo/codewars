/*#Find the missing letter

        Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.

        You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
        The array will always contain letters in only one case.

        Example:

        ['a','b','c','d','f'] -> 'e'
        ['O','Q','R','S'] -> 'P'
        (Use the English alphabet with 26 letters!)

        Have fun coding it and please don't forget to vote and rank this kata! :-)

        I have also created other katas. Take a look if you enjoyed this kata!*/

package com.codewars;

public class FindMissingLetter {
    public static char findMissingLetter(char[] array) {
        int p = (int) array[0];

        for (int i = 0; i < array.length; i++) {
            if ((int) array[i] != p) {
                return (char) p;
            }
            p++;
        }
        return ' ';
    }
}


/*
    public static char findMissingLetter(char[] array){
        char expectableLetter = array[0];
        for(char letter : array){
            if(letter != expectableLetter) break;
            expectableLetter++;
        }
        return expectableLetter;
    }*/
