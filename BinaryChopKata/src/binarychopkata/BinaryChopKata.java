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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author JavierZenko
 */
public class BinaryChopKata {

    /**
     * This program receives a number to be searched for and a file containing
     * a list of sorted numbers one per line. The program prints the line in
     * which the number is located (zero based numbering) or not found if the
     * number is not present in the file.
     * The program requires the file to exist, to be sorted and permissions
     * to read.
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
