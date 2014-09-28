/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Rishabh
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Init ob1=new Init("target","C:\\Users\\Rishabh\\Desktop\\t1.txt");
        ob1.getParagraphs();
        ob1.getLines();
        ArrayList<ArrayList<String>> work;
        work=ob1.getWork("technique",1);
        
        System.out.println("work size = " + work.size());
        for(int i=0;i<work.size();i++)
        { for(int j=0;j<work.get(i).size();j++)
            {
                System.out.println(work.get(i).get(j));
            }
        System.out.println("");
        }
    }
}
