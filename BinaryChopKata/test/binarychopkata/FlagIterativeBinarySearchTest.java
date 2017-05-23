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
public class FlagIterativeBinarySearchTest {
    
    private static ArrayList<Integer> badlySortedArray;
    private static ArrayList<Integer> sortedOddArray;
    private static ArrayList<Integer> sortedEvenArray;
    private static ArrayList<Integer> emptyArray;
    private static ArrayList<Integer> nullArray;
    
    public FlagIterativeBinarySearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        badlySortedArray = new ArrayList<>();
        
        badlySortedArray.add(1);
        badlySortedArray.add(2);
        badlySortedArray.add(3);
        badlySortedArray.add(4);
        badlySortedArray.add(7);
        badlySortedArray.add(5);
        
        sortedOddArray = new ArrayList<>();
        sortedOddArray.add(1);
        sortedOddArray.add(3);
        sortedOddArray.add(5);
        sortedOddArray.add(7);
        sortedOddArray.add(9);
        
        sortedEvenArray = new ArrayList<>();
        sortedEvenArray.add(2);
        sortedEvenArray.add(4);
        sortedEvenArray.add(6);
        sortedEvenArray.add(8);
        sortedEvenArray.add(10);
        sortedEvenArray.add(12);
        
        emptyArray = new ArrayList<>();
    }
    
    @AfterClass
    public static void tearDownClass() {
        badlySortedArray.clear();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Search method, of class FlagIterativeBinarySearch.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnsortedSearch() {
        System.out.println("UnsortedSearch");      
        Integer value = 5;
        FlagIterativeBinarySearch instance = new FlagIterativeBinarySearch();
        
        instance.Search(badlySortedArray, value);                       
    }
    
    @Test
    public void testSearchOddArray() {
        System.out.println("SearchOddArray");
        Integer value;               
        int result;
        FlagIterativeBinarySearch instance = new FlagIterativeBinarySearch();
        
        value = 1;
        result = instance.Search(sortedOddArray, value);        
        assertEquals(0, result);
        
        value = 5;
        result = instance.Search(sortedOddArray, value);
        assertEquals(2, result);
        
        value = 9;
        result = instance.Search(sortedOddArray, value);
        assertEquals(4, result);
        
        value = 0;
        result = instance.Search(sortedOddArray, value);
        assertEquals(-1, result);
        
        value = 2;
        result = instance.Search(sortedOddArray, value);
        assertEquals(-1, result);
        
        value = 10;
        result = instance.Search(sortedOddArray, value);
        assertEquals(-1, result);
    }       
    
    @Test
    public void testSearchEvenArray() {
        System.out.println("SearchEvenArray");
        Integer value;
        int result;
        FlagIterativeBinarySearch instance = new FlagIterativeBinarySearch();
        
        value = 2;
        result = instance.Search(sortedEvenArray, value);        
        assertEquals(0, result);        
        
        value = 8;
        result = instance.Search(sortedEvenArray, value);        
        assertEquals(3, result);
        
        value = 12;
        result = instance.Search(sortedEvenArray, value);        
        assertEquals(5, result);
        
        value = 1;
        result = instance.Search(sortedEvenArray, value);        
        assertEquals(-1, result);
        
        value = 3;
        result = instance.Search(sortedEvenArray, value);        
        assertEquals(-1, result);  
        
        value = 13;
        result = instance.Search(sortedEvenArray, value);        
        assertEquals(-1, result);        
    }
    
    @Test
    public void testSearchEmptyArray() {
        System.out.println("SearchEmptyArray");
        Integer value;
        int result;
        FlagIterativeBinarySearch instance = new FlagIterativeBinarySearch();
        
        value = 2;
        result = instance.Search(emptyArray, value);        
        assertEquals(-1, result);        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSearchNullArray() {
        System.out.println("SearchNullArray");
        Integer value;
        FlagIterativeBinarySearch instance = new FlagIterativeBinarySearch();
        
        value = 2;
        instance.Search(nullArray, value);      
    }
}
