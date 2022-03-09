package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    StringUtils stringUtils;

    @BeforeEach
    void init(){
        stringUtils= new StringUtils();
    }

    @Test
    void isBalancedTest_0(){
        assertTrue(stringUtils.isBalanced("{[][]}({})"));
    }

    @Test
    void isBalancedTest_1(){
        assertFalse(stringUtils.isBalanced("{"));
    }

    @Test
    void isBalancedTest_2(){
        assertFalse(stringUtils.isBalanced("{([)]"));
    }

    @Test
    void isBalancedTest_3(){
        assertFalse(stringUtils.isBalanced("{(}{}"));
    }

    @Test
    void isBalancedTest_4(){
        assertFalse(stringUtils.isBalanced("]["));
    }
}