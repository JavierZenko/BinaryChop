package binarychopkata;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zenko
 */
public class RecursiveStyleSearch 
        implements BinarySearcher { 
    
    private int RecursiveSearch(ArrayList<Integer> numbers, Integer value, int start, int end) {
        int curr;
        int s, e;
        
        if(start > end) {
            return -1;
        }
        
        s = start;
        e = end;
        curr = s + (e - s)/2;
        
        if(value == numbers.get(curr)) {
            return curr;
        } else if(value > numbers.get(curr)) {
            s = curr + 1;
        } else {
            e = curr - 1;
        }
        
        return RecursiveSearch(numbers, value, s, e);
    }
    
    @Override
    public int Search(ArrayList<Integer> numbers, Integer value) {
        if(!BinaryChopUtils.isSorted(numbers)) {
            throw new IllegalArgumentException("list should be ordered");
        }
        
        int result;
        result = RecursiveSearch(numbers, value, 0, numbers.size() - 1);
        
        return result;
    }
}
