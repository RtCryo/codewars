/*The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.

        Examples
        "din"      =>  "((("
        "recede"   =>  "()()()"
        "Success"  =>  ")())())"
        "(( @"     =>  "))(("*/



        package com.codewars;

import java.util.Arrays;
import java.util.List;

public class DuplicateEncoder {
    static String encode(String word) {
        StringBuilder newWord = new StringBuilder();
        List<String> array = Arrays.asList(word.toLowerCase().split(""));

        for (String t : array){
            if(array.stream().filter(arr -> t.equals(arr)).count() > 1){
                newWord.append(")");
            } else {
                newWord.append("(");
            }
        }

        return newWord.toString();
    }
}


/*
    static String encode(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }*/
