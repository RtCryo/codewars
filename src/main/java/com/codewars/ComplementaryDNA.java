/*Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

        If you want to know more http://en.wikipedia.org/wiki/DNA

        In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

        More similar exercise are found here http://rosalind.info/problems/list-view/ (source)

        DnaStrand.makeComplement("ATTGC") // return "TAACG"

        DnaStrand.makeComplement("GTAT") // return "CATA"*/

package com.codewars;

import java.util.HashMap;

public class ComplementaryDNA {
    public static String makeComplement(String dna) {
        StringBuilder result = new StringBuilder();

        HashMap<String,String> dnaMap = new HashMap<>();
        dnaMap.put("A","T");
        dnaMap.put("T","A");
        dnaMap.put("C","G");
        dnaMap.put("G","C");

        for(String i : dna.split("")){
            result.append(dnaMap.get(i));
        }

        return result.toString();
    }
}


/*
    public static String makeComplement(String dna) {
        char[] chars = dna.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            chars[i] = getComplement(chars[i]);
        }

        return new String(chars);
    }

    private static char getComplement(char c) {
        switch(c) {
            case 'A': return 'T';
            case 'T': return 'A';
            case 'C': return 'G';
            case 'G': return 'C';
        }
        return c;
    }*/
