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
public class FlagIterativeBinarySearch 
        implements BinarySearcher {
    
    @Override
    public int Search(ArrayList<Integer> numbers, Integer value) {
        if(!BinaryChopUtils.isSorted(numbers)) {
            throw new IllegalArgumentException("list should be ordered");
        }
        
        int lowerBound = 0;
        int upperBound = numbers.size() - 1;
        int midPoint = -1;
        
        boolean found = false;
        
        while(!found) {
            if(upperBound < lowerBound) {
                return -1;
            }
            
            midPoint = lowerBound + (upperBound - lowerBound)/2;
            
            if(numbers.get(midPoint) < value) {
                lowerBound = midPoint + 1;
            } else if (numbers.get(midPoint) > value) {
                upperBound = midPoint - 1;
            } else {
                found = true;
            }
        }
        
        return midPoint;
    }
}
