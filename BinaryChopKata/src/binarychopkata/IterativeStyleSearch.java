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
public class IterativeStyleSearch {
    
    /**
     *
     * @param numbers
     * @param value
     * @return
     */
    public int Search(ArrayList<Integer> numbers, Integer value) {
        if(!BinaryChopUtils.isSorted(numbers)) {
            throw new IllegalArgumentException("list should be ordered");
        }
        
        int start = 0;
        int end = numbers.size() - 1;
        int curr = (end - start)/2;
        
        while(start <= end && numbers.get(curr) != value) {
            if(value > numbers.get(curr)) {
                start = curr + 1;
            } else {
                end = curr - 1;
            }
            curr = (end - start)/2 + start;
        }
        
        if(start <= end) {
            return curr;
        } else {
            return -1;
        }                   
    }
}
