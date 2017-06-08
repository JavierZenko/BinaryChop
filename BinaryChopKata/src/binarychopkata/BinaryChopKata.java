/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarychopkata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        
        if(args.length != 2) {
            System.err.println("Usage: BinaryChopKata <number> <file>");
            return;
        }
        
        Integer numberToSearch = null;
        try {
            numberToSearch = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Argument " + args[0] + " must be an integer.");
            return;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        File file = new File(args[1]);
        BufferedReader reader = null;
        int returnValue = -1;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(Integer.parseInt(text));
            }

            BinarySearcher searcher = new FlagIterativeBinarySearch();
            returnValue = searcher.Search(list, numberToSearch);
            
            if(returnValue == -1) {
                System.out.println("Number not found.");
            } else {
                System.out.println("Number found at position: " + returnValue);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("File: " + args[1] + " Not Found.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + args[1] + ".");            
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integers from file " + args[1] + ".");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }                
    }
    
}
