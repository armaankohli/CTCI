package com.ctci;

import java.util.ArrayList;
import java.util.HashMap;

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

    public static boolean isPermutation(String stringOne, String stringTwo) {
        char[] strOneArray = stringOne.toCharArray();
        char[] strTwoArray = stringTwo.toCharArray();
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (char s1: strOneArray) {
            charCounts.put(s1, charCounts.getOrDefault(s1, 0) + 1);
        }
        for (char s2: strTwoArray) {
            if (!charCounts.containsKey(s2)) {
                return false;
            } else {
                int newVal = charCounts.get(s2) - 1;
                if (newVal < 0) {
                    return false;
                }
                charCounts.put(s2, newVal);
            }
        }
        for (char k: charCounts.keySet()) {
            if (charCounts.get(k) != 0) {
                return false;
            }
        }
        return true;
    }
}
