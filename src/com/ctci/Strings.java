package com.ctci;

import java.util.ArrayList;
import java.util.Arrays;
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
        for (char s1 : strOneArray) {
            charCounts.put(s1, charCounts.getOrDefault(s1, 0) + 1);
        }
        for (char s2 : strTwoArray) {
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
        for (char k : charCounts.keySet()) {
            if (charCounts.get(k) != 0) {
                return false;
            }
        }
        return true;
    }

    public static String replaceSpaces(char[] stringArray, int length) {
        int newLength = 0;
        for (int i = 0; i < length; i++) {
            if (stringArray[i] == ' ') {
                newLength += 2;
            }
            newLength += 1;
        }
        char[] retArray = new char[newLength];
        int skipper = 0;
        for (int j = 0; j < length; j++) {
            if (stringArray[j] == ' ') {
                retArray[j + skipper] = '%';
                retArray[j + skipper + 1] = '2';
                retArray[j + skipper + 2] = '0';
                skipper += 3;
            } else {
                retArray[j + skipper] = stringArray[j];
            }
        }
        return Arrays.toString(retArray);
    }

    public static String compressString(String str) {
        char[] strArray = str.toCharArray();
        ArrayList<Character> retArray = new ArrayList<>();
        char currLetter = strArray[0];
        char nextLetter;
        int letterLength = 1;
        int i = 1;
        int j = 0;
        while (i < strArray.length) {
            nextLetter = strArray[i];
            if (nextLetter == currLetter) {
                letterLength++;
            } else {
                retArray.add(currLetter);
                retArray.add((char) (letterLength + '0'));
                letterLength = 1;
                currLetter = nextLetter;
            }
            i++;
        }
        retArray.add(currLetter);
        retArray.add((char) (letterLength + '0'));

        if (retArray.size() >= strArray.length) {
            return str;
        } else {
            return retArray.stream().map(Object::toString).reduce((acc, e) -> acc  + e).get();
        }
    }

    public static int[][] makeZeros(int[][] mat) {
        boolean[] rows = new boolean[mat.length];
        boolean[] cols = new boolean[mat[0].length];
        Arrays.fill(rows, false);
        Arrays.fill(cols, false);
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (mat[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (rows[i] || cols[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public static boolean isRotation(String str1, String str2) {
        if (str1.length() == str2.length()) {
            String comb = str2 + str2;
            if (comb.equals(str2.substring(1, 2))) {
                return true;
            }
        }
        return true;
    }

}
