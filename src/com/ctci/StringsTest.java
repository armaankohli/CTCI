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

    @Test
    void compressStringTest() {
        assertEquals("a2b1c5a3", Strings.compressString("aabcccccaaa"));
        assertEquals("abcd", Strings.compressString("abcd"));
        assertEquals("a2b2c2d2", Strings.compressString("aabbccdd"));
    }

}