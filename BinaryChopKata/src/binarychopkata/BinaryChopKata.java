/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarychopkata;

import java.util.ArrayList;

/**
 *
 * @author zenko
 */
public class BinaryChopKata {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer found;
                
        //IterativeStyleSearch iss = new IterativeStyleSearch();
        //RecursiveStyleSearch iss = new RecursiveStyleSearch();
        //FunctionalStyleSearch iss = new FunctionalStyleSearch();
        SliceStyleSearch iss = new SliceStyleSearch();
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(2);
        test1.add(3);
        test1.add(5);
        
        found = iss.Search(test1, 1);        
        System.out.println(found);
        found = iss.Search(test1, 2);        
        System.out.println(found);
        found = iss.Search(test1, 3);        
        System.out.println(found);
        found = iss.Search(test1, 5);        
        System.out.println(found);
        found = iss.Search(test1, 6);        
        System.out.println(found);
        found = iss.Search(test1, 0);        
        System.out.println(found);
        found = iss.Search(test1, 4);        
        System.out.println(found);
        System.out.println();
        
        ArrayList<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(2);
        test2.add(3);
        test2.add(4);
        test2.add(6);
        
        found = iss.Search(test2, 1);                
        System.out.println(found);
        found = iss.Search(test2, 2);        
        System.out.println(found);
        found = iss.Search(test2, 3);        
        System.out.println(found);
        found = iss.Search(test2, 4);        
        System.out.println(found);
        found = iss.Search(test2, 6);        
        System.out.println(found);
        found = iss.Search(test2, 7);        
        System.out.println(found);
        found = iss.Search(test2, 0);        
        System.out.println(found);
        found = iss.Search(test2, 5);        
        System.out.println(found);
        
                
    }
    
}
