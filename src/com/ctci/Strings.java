package com.ctci;

import java.util.ArrayList;

public class Strings {
    public static boolean allUnique(String str) {
        ArrayList<Character> charArray = new ArrayList<>();
        char currChar;
        for (int i = 0; i < str.length(); i++) {
            currChar = str.charAt(i);
            if (charArray.contains(currChar)) {
                return false;
            } else {
                charArray.add(currChar);
            }
        }
        return true;
    }

    public static boolean allUniqueNoDS(String str) {
        int bits = 0;
        char currChar;
        for (int i = 0; i < str.length(); i++) {
            currChar = str.charAt(i);
            int offset = currChar - 'a';
            bits = (1 << offset) | bits;
            
        }
        return true;
    }
}
