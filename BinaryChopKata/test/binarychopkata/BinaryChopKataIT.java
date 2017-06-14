/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarychopkata;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JavierZenko
 */
public class BinaryChopKataIT {
    
    /**
     * Test of main method, of class BinaryChopKata.
     */
    @Test
    public void testMainNoArguments() {
        System.out.println("MainNoArguments");
        String[] args = new String[0];
        
        PrintStream stdout = System.err;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setErr(new PrintStream(baos));
        
        BinaryChopKata.main(args);

        System.setErr(stdout);
        
        String currentOutput = new String(baos.toByteArray());
        
        assertEquals("Usage: BinaryChopKata <number> <file>\n", currentOutput);
    }
    
    @Test
    public void testMainBadNumber() {
        System.out.println("MainBadNumber");
        
        String[] args = new String[2];
        args[0] = "A";
        args[1] = "testFile.txt";
        
        PrintStream stdout = System.err;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setErr(new PrintStream(baos));
        
        BinaryChopKata.main(args);

        System.setErr(stdout);
        
        String currentOutput = new String(baos.toByteArray());
        
        assertEquals("Argument " +args[0] + " must be an integer.\n", currentOutput);
    }
    
    @Test
    public void testMainFileNotExists() {        
        System.out.println("MainFileNotExists");
        
        String[] args = new String[2];
        args[0] = "7";
        args[1] = "unexistentFile.txt";
        
        PrintStream stdout = System.err;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setErr(new PrintStream(baos));
        
        BinaryChopKata.main(args);

        System.setErr(stdout);
        
        String currentOutput = new String(baos.toByteArray());
        
        assertEquals("File: " + args[1] + " Not Found.\n", currentOutput);
    }
    
    @Test
    public void testMainNumberFormatError() throws IOException {
        System.out.println("MainNumberFormatError");
        
        String[] args = new String[2];
        args[0] = "7";
        args[1] = "./test/bad_numbers.txt";
        
        PrintStream stdout = System.err;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setErr(new PrintStream(baos));

        BinaryChopKata.main(args);

        System.setErr(stdout);
        
        String currentOutput = new String(baos.toByteArray());        
        assertEquals("Error parsing integers from file " + args[1] + ".\n", currentOutput);        
    }
    
    
    @Test
    public void testMainNumberNotFound() {
        System.out.println("MainNumberFormatError");
        
        String[] args = new String[2];
        args[0] = "77";
        args[1] = "./test/sorted_numbers_even.txt";
        
        PrintStream stdout = System.out;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setOut(new PrintStream(baos));       

        BinaryChopKata.main(args);

        System.setOut(stdout);
        
        String currentOutput = new String(baos.toByteArray());        
        assertEquals("Number not found.\n", currentOutput);   
    }
    
    @Test
    public void testMainNumberFoundOdd() {
        System.out.println("MainNumberFoundOdd");
        
        String[] args = new String[2];
        args[0] = "7";
        args[1] = "./test/sorted_numbers_odd.txt";
        
        PrintStream stdout = System.out;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setOut(new PrintStream(baos));       

        BinaryChopKata.main(args);

        System.setOut(stdout);
        
        String currentOutput = new String(baos.toByteArray());        
        assertEquals("Number found at position: 3\n", currentOutput);
    }
    
    @Test
    public void testMainNumberFoundEven() {
        System.out.println("MainNumberFoundEven");
        
        String[] args = new String[2];
        args[0] = "7";
        args[1] = "./test/sorted_numbers_even.txt";
        
        PrintStream stdout = System.out;        
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);        
        System.setOut(new PrintStream(baos));       

        BinaryChopKata.main(args);

        System.setOut(stdout);
        
        String currentOutput = new String(baos.toByteArray());        
        assertEquals("Number found at position: 6\n", currentOutput);  
    }    
}
