/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication46;

import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author lenovo
 */
public class JavaApplication46 {

    /**
     * DFA Tester!!
     * @param args the command line arguments
     */
    public static boolean validateRegex(String expr)
    {
        if(expr.contains("..") || expr.contains("**"))
        {
            return false;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        System.out.println("----Welcome to the RE-DFA conversion!!\n----");
        String regex ="";
        char item;
        Scanner sc = new Scanner(System.in);
        
        regex = sc.next();
        System.out.println(regex + ": is the regex you gave!\n");
        System.out.println("Let's validate the regex!");
        
        validateRegex(regex);
        
        DFAConst dfaconstr = new DFAConst(regex);
        Thread t = new Thread(dfaconstr);
        t.start();
    }
    
}
