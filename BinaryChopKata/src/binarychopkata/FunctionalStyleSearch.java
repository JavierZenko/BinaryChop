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
public class FunctionalStyleSearch 
        implements BinarySearcher {    
    private int FunctionalSearch(ArrayList<Integer> numbers, Integer value, int start, int end) {
        if(start > end) {
            return -1;
        }
                
        if(value == numbers.get((start + end)/2)) {
            return (start + end)/2;
        } else if(value > numbers.get((start + end)/2)) {
            return FunctionalSearch(numbers, value, (start + end)/2 + 1, end);            
        } else {
            return FunctionalSearch(numbers, value, start, (start + end)/2 - 1);            
        }        
    }
    @Override
    public int Search(ArrayList<Integer> numbers, Integer value) {
        if(!BinaryChopUtils.isSorted(numbers)) {
            throw new IllegalArgumentException("list should be ordered");
        }
        
        return FunctionalSearch(numbers, value, 0, numbers.size()-1);
    }
}
