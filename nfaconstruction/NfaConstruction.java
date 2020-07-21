/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfaconstruction;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class NfaConstruction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("=========== RE to NFA ==========");
        //Input format if union operator a+b, concatenation ab, closure a*
        System.out.println("Enter the Regular Expression : ");
        //scanning input
        Scanner s=new Scanner(System.in);
        String exp=s.nextLine();
        Nfa n=new Nfa(exp);
        //In output 'e' represents epsilon
        n.displayNfa();
    }
    
}
