/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication46;
import java.util.*;
/**
 *
 * @author lenovo
 */
public class LeafNode extends SingleNTNode{

    private int num;
    List<Integer> followpos;
    
    public LeafNode(String symbol, int num) {
        super(symbol);
        /*leaf node has 0 children*/
        this.num=num;
        this.leftchild=null;
        this.rightchild=null;
        followpos = new ArrayList<>();
    }

    public List<Integer> getFollowpos() {
        return followpos;
    }

    public void setFollowpos(List<Integer> followpos) {
        this.followpos = followpos;
    }
    
    public int getNum()
    {
        return this.num;
    }
    
    public void addToFollowPos(int number){
        followpos.add((Integer)num);
    }
    
}
