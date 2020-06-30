package com.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    @Test
    void allUniqueTest() {
       assertTrue(Strings.allUnique("x"));
       assertTrue(Strings.allUnique("abcde"));
       assertFalse(Strings.allUnique("ababa"));
       assertTrue(Strings.allUnique("caret"));
       assertFalse(Strings.allUnique("zyxnbqz"));
    }

    @Test
    void allUniqueTestNoDS() {
        assertTrue(Strings.allUniqueNoDS("abcde"));
        assertFalse(Strings.allUniqueNoDS("ababa"));
        assertTrue(Strings.allUniqueNoDS("caret"));
        assertFalse(Strings.allUniqueNoDS("zyxnbqz"));
    }

    @Test
    void isPermutationTest() {
        assertTrue(Strings.isPermutation("calfo", "focal"));
        assertFalse(Strings.isPermutation("ghostly", "ghost"));
        assertFalse(Strings.isPermutation("fsdafd", "dasfad"));
        assertTrue(Strings.isPermutation("temperature", "tempreature"));
    }
}