package com.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {
    @Test
    void allUniqueTest() {
       assertTrue(Strings.allUnique("abcde"));
       
    }
}