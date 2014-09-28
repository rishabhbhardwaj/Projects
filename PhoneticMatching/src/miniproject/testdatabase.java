/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;
import java.io.*;
import java.util.Vector;
/**
 *
 * @author deepshikha
 */
public class testdatabase {
    
    Writer out1=null;
    BufferedWriter buffwrite=null;
    File file1=null;
    
    String filepath="C:\\Users\\Rishabh\\Documents\\NetBeansProjects\\MiniProject\\src\\miniproject\\distincttopics.txt";
    String Filename=filepath;
    String title;
    double phoneme_theta=0.00001f;
    void func()
    {
        
        try 
        {
            file1=new File(filepath);
            out1=new FileWriter(file1);
            buffwrite=new BufferedWriter(out1);
            String s2;
            Database db=new Database();
            db.getConnection();
            s2="select distinct(topic) from books";
            db.r=db.stmt.executeQuery(s2);
            while(db.r.next())
            {
                buffwrite.write(db.r.getString(1));
                System.out.println(db.r.getString(1));
                buffwrite.newLine();
            }
            db.closeAll();
            out1.flush();
            buffwrite.flush();
            System.out.println("Closing object..!!");
            out1.close();
            buffwrite.close();
        }
        catch(Exception e) {}
        
        
    }
    void func2() //writing phonemes of database keywords into database table of keyword and corresponding phonemes
    {
        try
        {
          FileInputStream fs= new FileInputStream(Filename);
          DataInputStream in = new DataInputStream(fs);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          Database db=new Database();
          db.getConnection();
          String line; 
          int k=0,i,j,l,m;
          newphoneme obj=new newphoneme();
          while ((line = br.readLine()) != null)   
            {
                        line=line.toLowerCase();
                        System.out.println(line);
                        String phone=obj.find_phoneme(line);
                        db.ps=db.con.prepareStatement("insert into word_phonemes (id,word,phoneme) values(?,?,?)");
                        db.ps.setInt(1,k);
                        db.ps.setString(2,line);
                        db.ps.setString(3,phone);
                        db.ps.executeUpdate();
                        db.ps.close();
                       // System.out.println("inserted");
                        k++;
                    
                        
            }
            in.close();
        }
        catch (Exception e){}
    }
    Vector<String> get_parts_phonemes(String in)
    {
        Vector<String> ph1;
        ph1=new Vector();
        int i=0;
        int l1=in.length();
        String s1="";
        while(i<l1)
        {
         if(in.charAt(i)=='#')
         {
             ph1.add(s1);
             s1="";
         }
         s1=s1+in.charAt(i);
         i++;
     }
     ph1.add(s1);
     return ph1;
    }
    void func3(String in) //test function which retrives books and topics on the basis of phonetic matching
    {
        GraphemetoPhoneme obj=new GraphemetoPhoneme();
        PhonemeTable obj2=new PhonemeTable();
        obj.findPhonemes(in);
        Vector<String> output;
        output=new Vector();
        int i,j,k,l,p=0;
        int sz=obj.phone.size();
        String s1,s2,s3,s4;
        Database db=new Database();
        db.getConnection();
        try {
            Vector<String> temp;
            temp=new Vector();
        for(i=0;i<sz;i++)
        {
            for(j=0;j<obj.phone.get(i).size();j++)
            {
                 s1=obj.phone.get(i).get(j);
              //   System.out.println("rishabh");
                 temp=get_parts_phonemes(s1);
                 for(k=0;k<temp.size();k++)
                 {
                     s2="select word,phoneme from word_phonemes where phoneme like '%"+temp.get(k) +"%'";
                 
                 db.r=db.stmt.executeQuery(s2);
                 while(db.r.next())
                 {
                     
                     //System.out.println(s1+"   "+db.r.getString(2));
                     if((double)(obj2.find_dist_phonemes(s1,db.r.getString(2)))<phoneme_theta)
                     {
                         if(!(output.contains(db.r.getString(1))))
                         output.add(db.r.getString(1));
                         //System.out.println(db.r.getString(1));
                       //  System.out.println("rishabh2");
                     }
                 }
                 }
               //  System.out.println("rishabh3");
                
            }
        }
        }
        catch(Exception e){}
        sz=output.size();
        //for(i=0;i<sz;i++)
          //  System.out.println("from final " +output.get(i));
    }
}
