/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

/**
 *
 * @author Rishabh
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Vector;
public class test3 {

    /**
     * @param args the command line arguments
     */
    String line;
    Vector<String> ph;
    void ReadFile(String Filename)
    {
        ph=new Vector();
        try
        {
            FileInputStream fs=new FileInputStream(Filename);
            DataInputStream in=new DataInputStream(fs);
            BufferedReader br=new BufferedReader(new InputStreamReader(in));
            while((line=br.readLine())!=null)
            {
               //ystem.out.println(line);
                String[] s=line.split("\t");
               // System.out.println(s[0]+ " ->> " + s[1]);
                String[] s2=s[1].split(" ");
             // System.out.print("hey1");
                for(int i=0;i<s2.length;i++)
                {
                    if(!(ph.contains(s2[i])))
                    {
                        ph.add(s2[i]);
                    }
                }
                
            }
        }
        catch(Exception e){}
    }
    public static void main(String[] args) {
        // TODO code application logic here
     /*   String s="abc   def ghi";
        String[] s2=s.split("   ");
        for(int i=0;i<s2.length;i++)
            System.out.println(s2[i]); */
        try {
        test3 o1=new test3();
        BufferedWriter out=new BufferedWriter(new FileWriter("phone.txt"));
       System.out.println("heeyyy");
        o1.ReadFile("C:\\Users\\Rishabh\\Desktop\\phoneset.txt");
        for(int i=0;i<o1.ph.size();i++)
        {
            System.out.println(o1.ph.get(i));
            out.write(o1.ph.get(i));
            out.newLine();
        }
        }
        catch(Exception e){}
    }
}
