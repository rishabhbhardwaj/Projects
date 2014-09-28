/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wsd;

/**
 *
 * @author Rishabh
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;
public class Init {

    /**
     * @param args the command line arguments
     */
    public static String target_word;
    public static int target_word_para_index;
    public static ArrayList<String> paragraphs=new ArrayList<String>();
    public static ArrayList<ArrayList<String>> lines=new ArrayList<ArrayList<String>>();
    public static String filename;
    public String targetLine;
    ArrayList<String> targetLines=new ArrayList<String>();
    public Init(String word,String filename)
    {
        this.target_word=word;
        this.filename=filename;
        paragraphs.clear();
        lines.clear();
        targetLines.clear();
    }
    public ArrayList<String> getTargetLines()
    {
        return targetLines;
    }
    public void getParagraphs() throws FileNotFoundException, IOException
    {
        Charset encoding=Charset.defaultCharset();
        String s1="";
        File f=new File(filename);
        InputStream in=new FileInputStream(f);
        Reader reader=new InputStreamReader(in,encoding);
        Reader buff=new BufferedReader(reader);
        int r;
        char ch;
        while((r=buff.read())!=-1)
        {
           // System.out.println(s1);
            ch=(char)r;
            if(ch=='\n')
            {
                String s2;
                s2 = s1.trim(); //trim all blank spaces
                if(!s2.equals(""))
                paragraphs.add(s1);
                s1="";
            }
            else
                s1+=ch;
        }
        if(!s1.equals(""))
          paragraphs.add(s1);
        /*System.out.println(paragraphs.size());
        for(int i=0;i<paragraphs.size();i++)  
           System.out.println(paragraphs.get(i).length()+"  "+paragraphs.get(i));
        */
        }
    public boolean checkDelimit(char ch)
    {
        
        boolean ok=true;
        char ar[]={'.','!','?',';'};
       // System.out.println("ch = " + ar[0]);
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]==ch)
            {
                ok=false;
                break;
            }
        }
        return ok;
    }
    public void getLines()
    {
        ArrayList<String> curline;
        String curpara;
        for(int i=0;i<paragraphs.size();i++)
        {
            curline=new ArrayList<String>();
            curpara=paragraphs.get(i);
            String templine="";
            for(int j=0;j<curpara.length();j++)
            {
                if(checkDelimit(curpara.charAt(j))==false)
                {
                   // templine.trim();
                    curline.add(templine);
                    templine="";
                }
                else
                {
                    //System.out.println("hello");
                    templine+=curpara.charAt(j);
                }
            }
            lines.add(curline);
        }
        /*for(int i=0;i<lines.size();i++)
        {
            for(int j=0;j<lines.get(i).size();j++)
            {
                System.out.println(lines.get(i).get(j));
            }
        }*/
        
    }
    public boolean search(String target,int i,int j)
    {
        boolean found=false;
        String s=lines.get(i).get(j);
        //System.out.println("s = " + s);
        String temp="";
        for(int i2=0;i2<s.length();i2++)
        {
            if(s.charAt(i2)==' ' || s.charAt(i2)==',')
            {
          //      System.out.println("temp = " + temp);
                if(temp.equals(target))
                    return true;
                else
                    temp="";
            }
            else
                temp+=s.charAt(i2);
        }
        if(temp.equals(target))
                    return true;
       
        return found;
       
    }
    ArrayList<ArrayList<String>> getWork(String target,int k)
    {
        ArrayList<ArrayList<String>> myList=new ArrayList<ArrayList<String>>();
        ArrayList<String> curr;
        for(int i=0;i<lines.size();i++)
        {
            // Now in a paragraph
            for(int j=0;j<lines.get(i).size();j++)
            {
                boolean ok=search(target,i,j);
                if(ok==true)
                {
                    targetLine=lines.get(i).get(j);
                    targetLines.add(targetLine);
            //        System.out.println("hello in the search");
                    curr=new ArrayList<String>();
                    int p1=j,p2=0;
                    while(p1>=0 && p2<=k)
                    {
                        //System.out.println("hello "+p1+" ");
                        curr.add(lines.get(i).get(p1));
                        p1--;
                        p2++;
                    }
                    p1=j+1;p2=0;
                    
                    while(p2<k &&  p1<lines.get(i).size())
                    {
                        //System.out.println("hello");
                        curr.add(lines.get(i).get(p1));
                        p1++;
                        p2++;
                    }
                    myList.add(curr);
                }
            }
           
          
            
        }
        
        return myList;
    }
    
    
}
