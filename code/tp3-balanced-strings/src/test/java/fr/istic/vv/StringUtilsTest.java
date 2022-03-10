package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    StringUtils stringUtils;

    @BeforeEach
    void init(){

        stringUtils= new StringUtils();
        HashMap<Character,Character> set = new HashMap<Character,Character>();
        set.put('(',')');
        set.put('{','}');
        set.put('[',']');
        stringUtils.setCharacterMap(set);
    }

    @Test
    void isBalancedTest_0() throws StringUtils.EmptyInitialSetException, StringUtils.SymbolNotInSetException {
        assertTrue(stringUtils.isBalanced("{[][]}({})"));
    }

    @Test
    void isBalancedTest_1() throws StringUtils.EmptyInitialSetException, StringUtils.SymbolNotInSetException {
        assertFalse(stringUtils.isBalanced("{"));
    }

    @Test
    void isBalancedTest_2() throws StringUtils.EmptyInitialSetException, StringUtils.SymbolNotInSetException {
        assertFalse(stringUtils.isBalanced("{([)]"));
    }

    @Test
    void isBalancedTest_3() throws StringUtils.EmptyInitialSetException, StringUtils.SymbolNotInSetException {
        assertFalse(stringUtils.isBalanced("{(}{}"));
    }

    @Test
    void isBalancedTest_4() throws StringUtils.EmptyInitialSetException, StringUtils.SymbolNotInSetException {
        assertFalse(stringUtils.isBalanced("]["));
    }
}