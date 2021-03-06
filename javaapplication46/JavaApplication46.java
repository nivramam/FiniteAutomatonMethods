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
        System.out.println("----Director method!!!\n----");

        Scanner sc = new Scanner(System.in);
        String regex = "";
        regex = sc.next();
        System.out.println(regex + ":input!\n");
        System.out.println("VALIDATION OF REGEX");
        /*perform validation*/
        if(validateRegex(regex)){
            DFAConst dfaconstr = new DFAConst(regex);
            System.out.println(dfaconstr.getRegex());
            dfaconstr.startProcess(); 
        }
    }   
}
class DFAConst
{
    //assign the regular expression fetched from the main module
    String reg;
    private static List<State> states;
    SyntaxTree syntree;
    private State current_state;
    public DFAConst(String reg) 
    {
        this.reg = reg;
        states = new ArrayList<>();
    }
    public String getRegex()
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
        this.reg = getRegex();
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
        System.out.println(actual + "::: after the concatenation");
        ArrayList<Character> symbolspresesnt = getSymbols(reg);
        System.out.println("---___Forwarding to syntax tree builder___---");
        syntree = new SyntaxTree(reg);
        /*finding nullable of the nodes*/
        System.out.println("Debug statement");
        syntree.generateNullable(syntree.getRoot());
//        syntree.generateFollowPos(syntree.getRoot());
        syntree.generateFLpos(syntree.getRoot());
        
        System.out.println(syntree);
        System.out.println("Debug over");
        
        formDFAStates();
    }
    public void formDFAStates()
    {
        
        SingleNTNode root = this.syntree.getRoot();
        State[] state = new State[syntree.getNumOfLeaves()+1];
        if(root!=null)
        {
            int rootID = root.number_of_node;
            System.out.println("Debug DFASTates functionality");
            if(state[0]==null)
                state[0] = new State(rootID);
            state[0].isStart=true;
            states.add(state[0]);
            int i;
            SingleNTNode node = root.getLeftchild();
            for(i=0;i<syntree.getNumOfLeaves()+1;i+=2)
            {
                state[i]=new State(node.number_of_node);
                states.add(state[i]);
                node=node.getLeftchild();
            }
            node =root;
            for(i=1;i<syntree.getNumOfLeaves()+1;i+=2)
            {
                state[i]=new State(node.number_of_node);
                states.add(state[i]);
                node=node.getRightchild();
            }
            i=syntree.getNumOfLeaves();
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
            for(int j=0;j<syntree.getNumOfLeaves();j++)
                state[j].goNext(j+1, states);
        }
    }
}
class State {
    int ID;
    String name;
    /*for opns that are different for final, start and normal nodes*/
    State nextState;
    public boolean isFinal,isStart;

    public State(int number) {
        ID = number;
        this.isFinal = false;
        this.isStart = false;
    }    
    public void goNext(int IDNext, List<State> states) {
      System.out.println("Player is in nextstate");
      this.nextState=states.get(IDNext);
    }
    public void printnextState()
    {
        System.out.println(this.nextState);
    }
    @Override
    public String toString() {
        return "ID number : " + this.ID + "state!"; //To change body of generated methods, choose Tools | Templates.
    }
}
