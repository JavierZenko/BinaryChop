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
public class BinaryChopUtils {

    /**
     *
     * @param numbers
     * @return
     */
    public static boolean isSorted(ArrayList<Integer> numbers) {
        for(int i = 0; i < numbers.size() - 1; i++) {
            if(numbers.get(i) > numbers.get(i+1)) {
                return false;
            }           
        }
        return true;
    }
}
