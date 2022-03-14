package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.Date.*;
import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    public void isValidDateTest_1(){
        Date date = new Date(26,Date.JANVIER,1999);
        assertTrue(date.isValidDate());

    }
    @Test
    public void isValidDateTest_2(){
        Date date = new Date(35,Date.JANVIER,1999);
        assertFalse(date.isValidDate());
    }

    @Test
    public void isValidDateTest_3(){
        Date date = new Date(28,31,1999);
        assertFalse(date.isValidDate());
    }
    @Test
    public void isValidDateTest_4(){
        Date date = new Date(28,31,-1999);
        assertFalse(date.isValidDate());
    }

    @Test
    public void isLeapYeartest_1(){
        Date date = new Date(26,JANVIER,1999);
        assertFalse(date.isLeapYear());
    }

    @Test
    public void isLeapYeartest_2(){
        Date date = new Date(26,JANVIER,2012);
        assertTrue(date.isLeapYear());
    }

    @Test
    public void nextDateTest_1(){
        Date date = new Date(26,JANVIER,2012);
        // Un jour de plus et un jour de moins reviens à la même date
        assertEquals(0,date.compareTo(date.nextDate().previousDate()));
    }

    @Test
    public void nextDateTest_2(){
        Date date = new Date(26,JANVIER,2012);
        Date nextDate = new Date(27,JANVIER,2012);
        assertTrue(date.nextDate().equals(nextDate));
    }

    @Test
    public void nextDateTest_3(){
        Date date = new Date(26,JANVIER,2012);
        Date nextDate = new Date(25,1,2012);
        assertFalse(date.nextDate().equals(nextDate));
    }

    @Test
    public void nextDateTest_4(){
        //Changement de mois
        Date date = new Date(31,JANVIER,2012);
        Date nextDate = new Date(1,FEVRIER,2012);
        assertTrue(date.nextDate().equals(nextDate));
    }

    @Test
    public void nextDateTest_5(){
        //Changement d'année
        Date date = new Date(31,DECEMBRE,2012);
        Date nextDate = new Date(1,JANVIER,2013);
        assertTrue(date.nextDate().equals(nextDate));
    }

    @Test
    public void nextDateTest_6(){
        //Cas de février d'une année bissextile
        Date date = new Date(28,FEVRIER,2012);
        Date nextDate = new Date(29,FEVRIER,2012);
        assertTrue(date.nextDate().equals(nextDate));
    }

    @Test
    public void nextDateTest_7(){
        //Cas de février d'une année non bissextile
        Date date = new Date(28,FEVRIER,2013);
        Date nextDate = new Date(1,MARS,2013);
        assertTrue(date.nextDate().equals(nextDate));
    }

    @Test
    public void previousDateTest_1(){
        Date date = new Date(26,JANVIER,2012);
        // Un jour de moins et un jour de plus reviens à la même date
        assertEquals(0,date.compareTo(date.previousDate().nextDate()));
    }

    @Test
    public void previousDateTest_2(){
        Date date = new Date(26,JANVIER,2012);
        Date previousDate = new Date(25,JANVIER,2012);
        assertTrue(date.previousDate().equals(previousDate));
    }

    @Test
    public void previousDateTest_3(){
        Date date = new Date(26,JANVIER,2012);
        Date previousDate = new Date(27,1,2012);
        assertFalse(date.previousDate().equals(previousDate));
    }

    @Test
    public void previousDateTest_4(){
        // Changement d'année
        Date date = new Date(1,JANVIER,2012);
        Date previousDate = new Date(31,DECEMBRE,2011);
        assertTrue(date.previousDate().equals(previousDate));
    }

    @Test
    public void previousDateTest_5(){
        // Changement de mois
        Date date = new Date(1,FEVRIER,2012);
        Date previousDate = new Date(31,JANVIER,2012);
        assertTrue(date.previousDate().equals(previousDate));
    }

    @Test
    public void previousDateTest_6(){
        // Cas de février d'une année bissextile
        Date date = new Date(1,MARS,2012);
        Date previousDate = new Date(29,FEVRIER,2012);
        assertTrue(date.previousDate().equals(previousDate));
    }

    @Test
    public void previousDateTest_7(){
        // Cas de février d'une année non bissextile
        Date date = new Date(1,MARS,2013);
        Date previousDate = new Date(28,FEVRIER,2013);
        assertTrue(date.previousDate().equals(previousDate));
    }


    @Test
    public void compareToTest_1(){
        Date date = new Date(1,MARS,2013);
        assertEquals(0,date.compareTo(date));
    }

    @Test
    public void compareToTest_2(){
        Date date = new Date(1,MARS,2013);
        assertEquals(1,date.compareTo(date.previousDate()));
    }

    @Test
    public void compareToTest_2_1(){
        Date date1 = new Date(1,MARS,2013);
        Date date2 = new Date(1,MARS,2014);
        assertEquals(1,date2.compareTo(date1.previousDate()));
    }

    @Test
    public void compareToTest_2_2(){
        Date date1 = new Date(1,MARS,2013);
        Date date2 = new Date(1,MARS,2014);
        assertEquals(-1,date1.compareTo(date2.previousDate()));
    }

    @Test
    public void compareToTest_3(){
        Date date = new Date(1,MARS,2013);
        assertEquals(-1,date.compareTo(date.nextDate()));
    }
}