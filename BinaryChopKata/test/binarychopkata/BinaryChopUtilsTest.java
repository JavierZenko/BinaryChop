/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarychopkata;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zenko
 */
public class BinaryChopUtilsTest {
    private static ArrayList<Integer> wellSortedArray;
    private static ArrayList<Integer> badlySortedArray;
    
    public BinaryChopUtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        wellSortedArray = new ArrayList<>();
        
        wellSortedArray.add(1);
        wellSortedArray.add(3);
        wellSortedArray.add(5);
        wellSortedArray.add(7);
        wellSortedArray.add(9);
        wellSortedArray.add(11);
        
        badlySortedArray = new ArrayList<>();
        
        badlySortedArray.add(1);
        badlySortedArray.add(2);
        badlySortedArray.add(3);
        badlySortedArray.add(4);
        badlySortedArray.add(7);
        badlySortedArray.add(5);
                       
    }
    
    @AfterClass
    public static void tearDownClass() {
        wellSortedArray.clear();
        badlySortedArray.clear();
    }

    /**
     * Test of isSorted method, of class BinaryChopUtils.
     */
    @Test
    public void testWellSorted() {
        System.out.println("wellSorted");        
        boolean result = BinaryChopUtils.isSorted(wellSortedArray);
        assertEquals(true, result);
    }
    
    /**
     * Test of isSorted method, of class BinaryChopUtils.
     */
    @Test
    public void testBadlySorted() {
        System.out.println("badlySorted");        
        boolean result = BinaryChopUtils.isSorted(badlySortedArray);
        assertEquals(false, result);
    }
}
