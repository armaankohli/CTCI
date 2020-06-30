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

        int setBits = 0;
        char currChar;
        int offset;
        int shiftedBit;
        for (int i = 0; i < str.length(); i++) {
            currChar = str.charAt(i);
            offset = currChar - 'a';
            shiftedBit = (1 << offset);
            if ((shiftedBit & setBits) > 0) {
                return false;
            } else {
                setBits = (shiftedBit) | setBits;
            }
        }
        return true;
    }
}
