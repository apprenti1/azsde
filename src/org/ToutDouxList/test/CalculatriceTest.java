package org.ToutDouxList.test;

import org.ToutDouxList.Calculatrice;
import org.ToutDouxList.Item;
import org.ToutDouxList.ToutDouxList;
import org.ToutDouxList.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatriceTest {

    Calculatrice calculatrice = new Calculatrice();


    @Test
    public void testAdd() {
        Assertions.assertEquals(5, calculatrice.add(2, 3));
    }

    @Test
    public void testSub() {
        Assertions.assertEquals(1, calculatrice.sub(3, 2));
    }

    @Test
    public void testMul() {
        Assertions.assertEquals(6, calculatrice.mul(2, 3));
    }

    @Test
    public void testDiv() {
        Assertions.assertEquals(2, calculatrice.div(6, 3));
    }

    @Test
    public void testAvg() {
        Assertions.assertEquals(3, calculatrice.avg(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testDivByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculatrice.div(1, 0));
    }

    @Test
    public void testAvgEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> calculatrice.avg(new int[]{}));
    }


    @Test
    public void testAll(){
        testAdd();
        testSub();
        testMul();
        testDiv();
        testAvg();
        testDivByZero();
        testAvgEmptyArray();
    }
}


