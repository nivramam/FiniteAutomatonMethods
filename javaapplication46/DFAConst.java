/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lenovo
 */
public class DFAConst implements Runnable{
    String reg;
    private static Set<State> states;

    
    public DFAConst(String reg) {
        this.reg = reg;
    }

    public String getregex()
    {
        this.reg += '#';
        return this.reg;
    }
    
    public void getSymbols(String expr)
    {
        Character[] c = new Character[10];
        c[0] = '+';
        c[1] = '*';
        c[2] = '(';
        c[3] = ')';
        c[4] = '\\';
        c[5] = '.';        
        c[6] = '&';
        c[7] = '|';
        c[8] = '[';
        c[9] = ']';
        
        for (int i=0;i<c.length;i++)
        {
            System.out.println(c[i]);
        }
    }
    
    public void startProcess()
    {
        states = new HashSet<>();
        this.reg = getregex();
        getSymbols(reg);
    }
    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Welcome to my thread...");
        startProcess();
    }
    
    
}
