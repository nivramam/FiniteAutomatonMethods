/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication46;

import java.util.Set;

/**
 *
 * @author lenovo
 */
public class SyntaxTree {
    private String regex;
    private BTree btee;
    private SingleNTNode root; //the head of raw syntax tree
    private int numOfLeaves;
    private Set<Integer> followPos[];
    
    public SyntaxTree(String regex)
    {
        this.regex = regex;
        this.btee = new BTree();
        btee.generateTree(regex);
    }
    
    public void generateNullable(SingleNTNode node){
        if(node==null)
        {
            return;
        }
        if(!(node instanceof LeafNode))
        {
            SingleNTNode leftndoe = node.getLeftchild();
            SingleNTNode rightndoe = node.getRightchild();
            generateNullable(leftndoe);
            generateNullable(rightndoe);
            switch(node.getSymbol())
            {
                case "|":
                    node.setNullable(leftndoe.isNullable() | rightndoe.isNullable());
                    break;
                case "*":
                    node.setNullable(true);
                    break;
                default:
                    System.out.println("do nothing...");
                    
            }
        }
    }
    public void generateFLpos(){
        
    }
    public void generateFollowPos()
    {
        
    }
           
}
