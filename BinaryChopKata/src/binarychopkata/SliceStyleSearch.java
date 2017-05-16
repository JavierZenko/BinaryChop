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
public class SliceStyleSearch 
        implements BinarySearcher { 
    
    private int SliceSearch(ArrayList<Integer> numbers, Integer value, Integer ini) {
        if(numbers.isEmpty()) {
            return -1;
        }
        
        int mid = (numbers.size() - 1) / 2;
        if(value == numbers.get(mid)) {
            return mid+ini;
        } else if (value > numbers.get(mid)) {
            ArrayList<Integer> a = new ArrayList(numbers.subList(mid + 1, numbers.size()));
            return SliceSearch(a, value, mid + ini + 1);            
        } else {
            ArrayList<Integer> a = new ArrayList(numbers.subList(0, mid));
            return SliceSearch(a, value, 0);            
        }
    }
    
    public int Search(ArrayList<Integer> numbers, Integer value) {
        int found = SliceSearch(numbers, value, 0);
        
        return found;
    }
}
