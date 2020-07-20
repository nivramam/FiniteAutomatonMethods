package javaapplication46;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if(expr.contains("..") || expr.contains("**") || expr.contains("\\") || expr.contains("&&") || expr.contains("~"))
        {
            return false;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        System.out.println("----Welcome to the RE-DFA conversion - using Director method!!!\n----");

        Scanner sc = new Scanner(System.in);
        String regex = "";
        regex = sc.next();
        System.out.println(regex + ": is the input regex!\n");
        System.out.println("Let's validate the regex!");
        /*perform validation*/
        if(validateRegex(regex)){
            DFAConst dfaconstr = new DFAConst(regex);
            System.out.println(dfaconstr.getregex());
            dfaconstr.startProcess(); 
        }
    }
    
}
class DFAConst
{
//     assign the regular expression fetched from the main module
    String reg;
    private static List<State> states;
    SyntaxTree syntree;

    
    public DFAConst(String reg) {
        this.reg = reg;
        states = new ArrayList<>();
    }

    public String getregex()
    {
        this.reg += '#';
        return this.reg;
    }
    
    public ArrayList<Character> getSymbols(String expr)
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
        ArrayList<Character> symbols = new ArrayList<Character>();
        for (int i=0;i<expr.length();i++)
        {
            char atvalue = expr.charAt(i);
            for(int j=0;j<c.length;j++)
            {
                if(atvalue == c[j])
                {
                    symbols.add(atvalue);
                }
            }
        }
        System.out.println("Following are the symbols that are used in the regular expression!");
        for(int i=0;i<symbols.size();i++)
        {
            System.out.println(symbols.get(i));
        }
        return symbols;
    }
    
    public void startProcess()
    {
        states = new ArrayList<>();
        this.reg = getregex();
        String actual = this.reg;
        System.out.println(actual + "::: before the concatination");
        for(int i=0;i<this.reg.length();i++)
        {
            String concat = "&";
            if(i%2==0 && i!=0)
            {
                actual+=concat;
            }
        }
        System.out.println(actual + "::: after the concatination");
        ArrayList<Character> symbolspresesnt = getSymbols(reg);
        System.out.println("___forwarding to syntax tree builder_________");
        syntree = new SyntaxTree(reg);
        /*finding nullable of the nodes*/
        System.out.println("Debug statement");
        syntree.generateNullable(syntree.getRoot());
        syntree.generateFollowPos(syntree.getRoot());
        syntree.generateFLpos(syntree.getRoot());
        System.out.println("Debug over");
        
        formDFAStates();
    }
    public void formDFAStates()
    {
        SingleNTNode root = syntree.getRoot();
        State[] state = new State[syntree.getNumOfLeaves()+1];
        state[0]=new State(root.number_of_node);
        state[0].isStart=true;
        states.add(state[0]);
        state[0].goNext();
        SingleNTNode node = root.getLeftchild();
        for(int i=0;i<syntree.getNumOfLeaves()+1;i+=2)
        {
            state[i]=new State(node.number_of_node);
            node=node.getLeftchild();
        }
        node =root;
        for(int i=1;i<syntree.getNumOfLeaves()+1;i+=2)
        {
            state[i]=new State(node.number_of_node);
            node=node.getRightchild();
        }
        int i=syntree.getNumOfLeaves();
        while(i!=0)
        {
            state[i].isStart=false;
            i--;
        }
        while(i!=syntree.getNumOfLeaves())
        {
            state[i].isFinal=false;
            i--;
        }
        state[i].isFinal=true;
                
    }
//    @Override
//    public void run() {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("Welcome to my thread...!");
//        startProcess();
//    }  
}
