/* 
 * The MIT License
 *
 * Copyright 2017 zenko.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
 package binarychopkata;

import java.util.ArrayList;

/**
 *
 * @author JavierZenko
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
    
    @Override
    /**
     * Search the given list of numbers for the value using the binary search
     * algorithm using a slice approach. The list should be sorted in 
     * ascending order otherwise a IllegalArgumentException will be raised. 
     * If the list contains multiple elements equal to the specified object, 
     * any of them could be found.
     * @param numbers the list of numbers to be searched.
     * @param value the value to be searched for.
     * @return the index of the search key, if it is contained in the list; 
     * otherwise it returns -1
     * @throws IllegalArgumentException if the list is not sorted.
     */
    public int Search(ArrayList<Integer> numbers, Integer value) {
        if(!BinaryChopUtils.isSorted(numbers)) {
            throw new IllegalArgumentException("list should be ordered");
        }
        
        int found = SliceSearch(numbers, value, 0);
        
        return found;
    }
}
