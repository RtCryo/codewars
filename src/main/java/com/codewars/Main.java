package com.codewars;

public class Main {

    public static void main(String[] args)  {

        char[][] triplets = {
                {'m','a','t'},
                {'a','t','h'},
                {'i','s','f'},
                {'t','h','i'},
                {'s','f','u'},
                {'f','u','n'},
                {'a','t','i'}
        };

        System.out.println(SecretDetective.recoverSecret(triplets));

    }
}
