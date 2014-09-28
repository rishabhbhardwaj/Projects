/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

/**
 *
 * @author Rishabh
 */
public class myString {
    public String word;
    public String pos;
    public int depth;
    public myString(String w,String p)
    {
        this.word=w;
        this.pos=p;
    }
    public myString(String w,String p,int d)
    {
        this.word=w;
        this.pos=p;
        this.depth=d;
    }
    public myString(String w,int d)
    {
        this.word=w;
        this.depth=d;
    }
}
